package com.uem.clinica.entidades;

import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.time.LocalDate;

public class Secretaria extends Pessoa {

    public Secretaria(){

    }

    public Secretaria(String nome, LocalDate dataNascimento, Endereco endereco, String celular) {
        super(nome, dataNascimento, endereco, celular);
    }

    public Secretaria(String nome, LocalDate dataNascimento, Endereco endereco, String celular, String email) {
        super(nome, dataNascimento, endereco, celular, email);
    }


    public Secretaria criarSecretaria(String nome, LocalDate dataNascimento, Endereco endereco, String celular) {
        return new Secretaria(nome, dataNascimento, endereco, celular);
    }

    public Secretaria criarSecretaria(String nome, LocalDate dataNascimento, Endereco endereco, String celular, String email) {
        return new Secretaria(nome, dataNascimento, endereco, celular, email);
    }

    public void atualizarSecretaria(Secretaria secretaria, String nome, LocalDate dataNascimento, Endereco endereco, String celular) {
        secretaria.setNome(nome);
        secretaria.setDataNascimento(dataNascimento);
        secretaria.setEndereco(endereco);
        secretaria.setCelular(celular);
    }

    public void atualizarPaciente(Secretaria secretaria, String nome, LocalDate dataNascimento, Endereco endereco, String celular, String email) {
        secretaria.setNome(nome);
        secretaria.setDataNascimento(dataNascimento);
        secretaria.setEndereco(endereco);
        secretaria.setCelular(celular);
        secretaria.setEmail(email);
    }

    public void removerSecretaria(Secretaria secretaria) {
        secretaria = null;
    }

    public Paciente criarPaciente(String nome, LocalDate dataNascimento, Endereco endereco, String celular, Convenio convenio) {
        return new Paciente(nome, dataNascimento, endereco, celular, convenio);
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
