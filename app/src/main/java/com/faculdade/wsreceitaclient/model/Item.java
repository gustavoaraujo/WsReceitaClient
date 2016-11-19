/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.model;

import java.io.Serializable;

/**
 *
 * @author Cliente
 */
public class Item implements Serializable {
    private int Id;
    private int NumReceita;
    private Receita Receita;
    private int RegAnvisa;
    private String Instrucao;
    private String Nome;
    private String Uso;
    private String ContraIndicacao;

    public Item() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getNumReceita() {
        return NumReceita;
    }

    public void setNumReceita(int NumReceita) {
        this.NumReceita = NumReceita;
    }

    public Receita getReceita() {
        return Receita;
    }

    public void setReceita(Receita Receita) {
        this.Receita = Receita;
    }

    public int getRegAnvisa() {
        return RegAnvisa;
    }

    public void setRegAnvisa(int RegAnvisa) {
        this.RegAnvisa = RegAnvisa;
    }

    public String getInstrucao() {
        return Instrucao;
    }

    public void setInstrucao(String Instrucao) {
        this.Instrucao = Instrucao;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String Uso) {
        this.Uso = Uso;
    }

    public String getContraIndicacao() {
        return ContraIndicacao;
    }

    public void setContraIndicacao(String ContraIndicacao) {
        this.ContraIndicacao = ContraIndicacao;
    }

    @Override
    public String toString() {
        String s = "Reg. Anvisa: " + RegAnvisa + System.getProperty("line.separator") +
                "Instrução: " + Instrucao + System.getProperty("line.separator") +
                "Nome: " + Nome + System.getProperty("line.separator") +
                "Uso: " + Uso + System.getProperty("line.separator") +
                "Contra Indicacão: " + ContraIndicacao;

        return s;
    }
}
