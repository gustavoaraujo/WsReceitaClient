/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.controller;

import com.faculdade.wsreceitaclient.model.Paciente;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cliente
 */
public class PacienteController {

    public PacienteController() {
        ObjectMapper om = new ObjectMapper() {

            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    jacksonObjectMapper.setPropertyNamingStrategy(
                            PropertyNamingStrategy.UPPER_CAMEL_CASE);

                    if (valueType == ArrayList.class) {
                        Paciente[] pacientes = jacksonObjectMapper
                        .readValue(value, Paciente[].class);
                        
                        List<Paciente> pacienteList = Arrays.asList(pacientes);
                        List<Paciente> mcList = new ArrayList<>(pacienteList);
                        return (T) mcList;
                    }

                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
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

    public String CadastrarPaciente(Paciente p) 
    {
        String result = "";

        try {
            HttpResponse<String> postResponse = Unirest.post("http://wsreceita.gear.host/CadastrarPaciente")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(p)
                    .asObject(String.class);

            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
    
    public ArrayList<Paciente> GetPaciente() {
        ArrayList<Paciente> result = new ArrayList<Paciente>();

        try {
            HttpResponse<ArrayList> postResponse = Unirest.get("http://wsreceita.gear.host/ObterPacientes")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .asObject(ArrayList.class);

            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }

        return result;
    }
}
