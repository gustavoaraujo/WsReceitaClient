/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculdade.wsreceitaclient.model;

import com.faculdade.wsreceitaclient.model.Item;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author Cliente
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Receita implements Serializable {

    private int NumReceita;
    private Date Data;
    private String CRM;
    private Medico Medico;
    private String CPF;
    private Paciente Paciente;
    private ArrayList<Item> ItensReceita;
    private boolean Utilizada;
    private boolean Cancelada;

    public Receita() {
        this.Utilizada = false;
        this.Cancelada = false;
        this.Data = new Date();
        this.ItensReceita = new ArrayList<>();
    }

    public int getNumReceita() {
        return NumReceita;
    }

    public void setNumReceita(int NumReceita) {
        this.NumReceita = NumReceita;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date Data) {
        this.Data = Data;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public Medico getMedico() {
        return Medico;
    }

    public void setMedico(Medico Medico) {
        this.Medico = Medico;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public Paciente getPaciente() {
        return Paciente;
    }

    public void setPaciente(Paciente Paciente) {
        this.Paciente = Paciente;
    }

    public ArrayList<Item> getItensReceita() {
        return ItensReceita;
    }

    public void setItensReceita(ArrayList<Item> ItensReceita) {
        this.ItensReceita = ItensReceita;
    }

    public boolean isUtilizada() {
        return Utilizada;
    }

    public void setUtilizada(boolean Utilizada) {
        this.Utilizada = Utilizada;
    }

    public boolean isCancelada() {
        return Cancelada;
    }

    public void setCancelada(boolean Cancelada) {
        this.Cancelada = Cancelada;
    }

    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");

        String s = "Número de receita: " + NumReceita + System.getProperty("line.separator") +
                "Médico: " + Medico.toString() + System.getProperty("line.separator") +
                "Paciente: " + Paciente.toString() + System.getProperty("line.separator") +
                "Utilizada: " + Utilizada + System.getProperty("line.separator") +
                "Cancelada: " + Cancelada + System.getProperty("line.separator") +
                "Data: " + df.format(Data) + System.getProperty("line.separator") +
                "Itens da receita: " + System.getProperty("line.separator");

        for (Item i : ItensReceita) {
            s += i.toString() + System.getProperty("line.separator");
        }

        return s;
    }
}
