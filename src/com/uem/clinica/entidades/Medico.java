package com.uem.clinica.entidades;

import com.uem.clinica.util.Endereco;

import java.time.LocalDate;

public class Medico extends Pessoa {

    private int crm;

    public Medico(){

    }

    public Medico(String nome, LocalDate dataNascimento, Endereco endereco, String celular, int crm) {
        super(nome, dataNascimento, endereco, celular);
        this.crm = crm;
    }

    public Medico(String nome, LocalDate dataNascimento, Endereco endereco, String celular, String email, int crm) {
        super(nome, dataNascimento, endereco, celular, email);
        this.crm = crm;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }
}
