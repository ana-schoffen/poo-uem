package com.uem.clinica.entidades;

import com.uem.clinica.util.Endereco;

import java.util.Calendar;

public class Pessoa {
    private String nome;
    private Calendar dataNascimento;
    private Endereco endereco;
    private String celular;
    private String email;

    public Pessoa(String nome, Calendar dataNascimento, Endereco endereco, String celular) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.celular = celular;
    }

    public Pessoa(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.celular = celular;
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Calendar dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
