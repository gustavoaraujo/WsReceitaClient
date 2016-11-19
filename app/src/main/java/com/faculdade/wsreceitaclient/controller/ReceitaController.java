/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.controller;

import com.faculdade.wsreceitaclient.model.NumeroReceita;
import com.faculdade.wsreceitaclient.model.Receita;
import com.faculdade.wsreceitaclient.model.ResultCadastroReceita;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;

/**
 *
 * @author Cliente
 */
public class ReceitaController {

    public ReceitaController() {

        ObjectMapper om = new ObjectMapper() {

            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    jacksonObjectMapper.setPropertyNamingStrategy(
                            PropertyNamingStrategy.UPPER_CAMEL_CASE);

                    if (valueType == ResultCadastroReceita.class || valueType == Receita.class) {
                        String[] sarr = value.split("\"");

                        String toBeReplaced = "";

                        for (String str : sarr) {
                            String[] sarr2 = str.split(Pattern.quote(":"));
                            if (sarr2.length > 3) {
                                toBeReplaced = str;
                                break;
                            }
                        }

                        String toReplace = toBeReplaced.split(Pattern.quote("."))[0];

                        value = value.replaceAll(toBeReplaced, toReplace);
                    }

                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    jacksonObjectMapper.setPropertyNamingStrategy(
                            PropertyNamingStrategy.UPPER_CAMEL_CASE);

                    String test = jacksonObjectMapper.writeValueAsString(value);

                    if (value instanceof ResultCadastroReceita || value instanceof Receita) {
                        String[] sarr = test.split("\"");

                        String toBeReplaced = "";

                        Date date = new Date();

                        for (String str : sarr) {
                            if (str.length() > 12) {
                                String str2 = str.substring(1, str.length() - 1);
                                try {
                                    date = new Date(Long.parseLong(str2));
                                    toBeReplaced = str;
                                } catch (Exception ex) {
                                    continue;
                                }

                                if (str2.length() == 13) {
                                    toBeReplaced = str2;
                                    break;
                                }
                            }
                        }

                        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                        String toReplace = formatter.format(date).replace(" ", "T");

                        test = test.replaceAll(toBeReplaced, "\""+toReplace+"\"");
                    }

                    return test;
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }

            public String translate(String input) {
                // Replace first lower-case letter with upper-case equivalent
                return input.substring(0, 1).toUpperCase() + input.substring(1);
            }
        };

        Unirest.setObjectMapper(om);
    }

    public String CancelarReceitaMedica(NumeroReceita numeroReceita) {
        String result = "";

        try {
            HttpResponse<String> postResponse = Unirest.post("http://wsreceita.gear.host/CancelarReceitaMedica")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(numeroReceita)
                    .asObject(String.class);

            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public String UtilizarReceitaMedica(NumeroReceita numeroReceita) {
        String result = "";

        try {
            HttpResponse<String> postResponse = Unirest.post("http://wsreceita.gear.host/UtilizarReceitaMedica")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(numeroReceita)
                    .asObject(String.class);

            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public Receita ObterReceitaMedica(NumeroReceita numeroReceita) {
        Receita result = new Receita();

        try {
            HttpResponse<Receita> postResponse = Unirest.post("http://wsreceita.gear.host/ObterReceitaMedica")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(numeroReceita)
                    .asObject(Receita.class);

            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }

    public ResultCadastroReceita CadastrarReceitaMedica(Receita receita) {
        ResultCadastroReceita result = new ResultCadastroReceita();

        try {
            HttpResponse<ResultCadastroReceita> postResponse = Unirest.post("http://wsreceita.gear.host/CadastrarReceitaMedica")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(receita)
                    .asObject(ResultCadastroReceita.class);

            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
