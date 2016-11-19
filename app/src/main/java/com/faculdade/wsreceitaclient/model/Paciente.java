/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Cliente
 */
public class Paciente implements Serializable {
    private String CPF;
    private String Nome;
    private ArrayList<Receita> Receitas;

    public Paciente() {
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
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

    @Override
    public String toString() {
        String s = "CPF: " + CPF + System.getProperty("line.separator") +
                "Nome: " + Nome + System.getProperty("line.separator");
        return s;
    }
}
