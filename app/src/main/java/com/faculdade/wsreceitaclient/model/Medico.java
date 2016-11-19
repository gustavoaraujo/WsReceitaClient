/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Cliente
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Medico implements Serializable{
    
    @JsonProperty("Crm")
    private String Crm;
    private String Nome;
    private ArrayList<Receita> Receitas;
    private Usuario Usuario;

    public Medico() {
    }

    public String getCrm() {
        return Crm;
    }

    public void setCrm(String Crm) {
        this.Crm = Crm;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public ArrayList<Receita> getReceitas() {
        return Receitas;
    }

    public void setReceitas(ArrayList<Receita> Receitas) {
        this.Receitas = Receitas;
    }

    public Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(Usuario Usuario) {
        this.Usuario = Usuario;
    }
}
