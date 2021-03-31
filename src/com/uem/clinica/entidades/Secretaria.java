package com.uem.clinica.entidades;

import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.time.LocalDate;

public class Secretaria {

    public Secretaria(){

    }

    public Paciente criarPaciente(String nome, LocalDate dataNascimento, Endereco endereco, String celular, String email, Convenio convenio) {
        return new Paciente(nome, dataNascimento, endereco, celular, email, convenio);
    }

    public void atualizarPaciente(Paciente paciente, String nome, LocalDate dataNascimento, Endereco endereco, String celular, Convenio convenio) {
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setCelular(celular);
        paciente.setConvenio(convenio);
    }

    public void atualizarPaciente(Paciente paciente, String nome, LocalDate dataNascimento, Endereco endereco, String celular, String email, Convenio convenio) {
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setCelular(celular);
        paciente.setEmail(email);
        paciente.setConvenio(convenio);
    }

    public void removerPaciente(Paciente paciente) {
        paciente = null;
    }
}
