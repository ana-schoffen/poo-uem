package com.uem.clinica.entidades;

import com.uem.clinica.interfaces.InterfacePacienteDAO;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.util.Calendar;

public class Secretaria extends Pessoa {

    public Secretaria(){

    }

    public Secretaria(String nome, Calendar dataNascimento, Endereco endereco, String celular) {
        super(nome, dataNascimento, endereco, celular);
    }

    public Secretaria(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email) {
        super(nome, dataNascimento, endereco, celular, email);
    }
}
