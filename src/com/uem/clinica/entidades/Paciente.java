package com.uem.clinica.entidades;

import com.uem.clinica.util.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class Paciente extends Pessoa{

    private Convenio convenio;

    private HashMap<String,String> dadosAdicionais;

    private ArrayList<String> cirurgias;

    private ArrayList<String> alergias;

    public Paciente(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email, Convenio convenio) {
        super(nome, dataNascimento, endereco, celular, email);
        this.convenio = convenio;
    }

    public Convenio getConvenio() {
        return convenio;
    }

    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public HashMap<String, String> getDadosAdicionais() {
        return dadosAdicionais;
    }

    public void setDadosAdicionais(HashMap<String, String> dadosAdicionais) {
        this.dadosAdicionais = dadosAdicionais;
    }

    public ArrayList<String> getCirurgias() {
        return cirurgias;
    }

    public void setCirurgias(ArrayList<String> cirurgias) {
        this.cirurgias = cirurgias;
    }

    public ArrayList<String> getAlergias() {
        return alergias;
    }

    public void setAlergias(ArrayList<String> alergias) {
        this.alergias = alergias;
    }
}
