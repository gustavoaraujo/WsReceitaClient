/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.controller;

import com.faculdade.wsreceitaclient.model.Usuario;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.nio.reactor.IOReactorException;

/**
 *
 * @author Cliente
 */
public class UsuarioController {
    
    public String CadastrarUsuario(Usuario usuario)
    {
        String result = "";
        
        try {
            HttpResponse<String> postResponse = Unirest.post("http://wsreceita.gear.host/CadastrarUsuario")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(usuario)
                    .asObject(String.class);
            
            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return result;
    }
    
    public Usuario LogarUsuario(Usuario u) 
    {
        Usuario result = new Usuario();
        
        try {
            HttpResponse<Usuario> postResponse = Unirest.post("http://wsreceita.gear.host/LogarUsuario")
                    .header("accept", "application/json")
                    .header("Content-Type", "application/json")
                    .body(u)
                    .asObject(Usuario.class);
            
            result = postResponse.getBody();
        } catch (UnirestException ex) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        return result;
    }

    public UsuarioController() {
        
        ObjectMapper om = new ObjectMapper() {
            
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                        = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    jacksonObjectMapper.setPropertyNamingStrategy(
            PropertyNamingStrategy.UPPER_CAMEL_CASE);
                    
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
}
