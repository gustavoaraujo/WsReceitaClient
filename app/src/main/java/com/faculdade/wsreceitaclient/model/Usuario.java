/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.io.Serializable;

/**
 *
 * @author Cliente
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Usuario implements Serializable {

    @JsonProperty("$id")
    private int IdUsuario;
    
    private String Login;
    private String Senha;
    private String Crm;
    private Medico Medico;

    public Usuario() {
        this.Medico = new Medico();
    }

    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }
    
    public String getLogin() {
        return Login;
    }

    public void setLogin(String Login) {
        this.Login = Login;
    }
    
    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }

    public String getCrm() {
        return Crm;
    }

    public void setCrm(String Crm) {
        this.Crm = Crm;
    }

    public Medico getMedico() {
        return Medico;
    }

    public void setMedico(Medico Medico) {
        this.Medico = Medico;
    }
    
    
}
