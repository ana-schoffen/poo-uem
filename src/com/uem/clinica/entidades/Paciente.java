package com.uem.clinica.entidades;

import com.uem.clinica.util.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;

public class Paciente {

    private int id;
    private String nome;
    private LocalDate dataNascimento;
    private Endereco endereco;
    private String celular;
    private String email;

    private Convenio convenio;

    private HashMap<String,String> dadosAdicionais;

    private ArrayList<String> cirurgias;

    private ArrayList<String> alergias;

    public Paciente() {

    }

    public Paciente(String nome, LocalDate dataNascimento, Endereco endereco, String celular, String email, Convenio convenio) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.celular = celular;
        this.email = email;
        this.convenio = convenio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
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

    @Override
    public String toString() {
        return String.format("%d|%s|%s|%s|%s|%s|%s",
                              id,
                              nome,
                              dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")),
                              endereco.toString(),
                              celular,
                              email,
                              convenio.toString());
    }
}
