package com.uem.clinica.entidades;

import com.uem.clinica.util.Endereco;

import java.util.Calendar;

public class Secretaria extends Pessoa{

    public Secretaria(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email) {
        super(nome, dataNascimento, endereco, celular, email);
    }
}
