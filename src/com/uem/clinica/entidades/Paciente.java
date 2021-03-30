package com.uem.clinica.entidades;

import com.uem.clinica.util.*;

import java.util.Calendar;

public class Paciente extends Pessoa{

    private Convenio convenio;

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
}
