/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.model;

import java.util.Date;

/**
 *
 * @author Cliente
 */
public class ResultCadastroReceita {

    private String Msg;
    private String CPF;
    private String CRM;
    private Date DataCadastro;
    private int NumeroReceita;

    public ResultCadastroReceita(String Msg, Receita Receita) {
        this.Msg = Msg;
        this.CPF = Receita.getCPF();
        this.CRM = Receita.getCRM();
        this.DataCadastro = new Date();
        this.NumeroReceita = Receita.getNumReceita();
    }

    public ResultCadastroReceita() {
        
    }

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public Date getDataCadastro() {
        return DataCadastro;
    }

    public void setDataCadastro(Date DataCadastro) {
        this.DataCadastro = DataCadastro;
    }

    public int getNumeroReceita() {
        return NumeroReceita;
    }

    public void setNumeroReceita(int NumeroReceita) {
        this.NumeroReceita = NumeroReceita;
    }
}
