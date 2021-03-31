package com.uem.clinica.dao;

import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.entidades.Secretaria;
import com.uem.clinica.interfaces.InterfacePacienteDAO;
import com.uem.clinica.interfaces.InterfaceSecretariaDAO;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.util.Calendar;

public class SecretariaDAO implements InterfaceSecretariaDAO, InterfacePacienteDAO {
    @Override
    public Secretaria criarSecretaria(String nome, Calendar dataNascimento, Endereco endereco, String celular) {
        return new Secretaria(nome, dataNascimento, endereco, celular);
    }

    @Override
    public Secretaria criarSecretaria(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email) {
        return new Secretaria(nome, dataNascimento, endereco, celular, email);
    }

    @Override
    public void atualizarSecretaria(Secretaria secretaria, String nome, Calendar dataNascimento, Endereco endereco, String celular) {
        secretaria.setNome(nome);
        secretaria.setDataNascimento(dataNascimento);
        secretaria.setEndereco(endereco);
        secretaria.setCelular(celular);
    }

    @Override
    public void atualizarPaciente(Secretaria secretaria, String nome, Calendar dataNascimento, Endereco endereco, String celular, String email) {
        secretaria.setNome(nome);
        secretaria.setDataNascimento(dataNascimento);
        secretaria.setEndereco(endereco);
        secretaria.setCelular(celular);
        secretaria.setEmail(email);
    }

    @Override
    public void removerSecretaria(Secretaria secretaria) {
        secretaria = null;
    }

    @Override
    public Paciente criarPaciente(String nome, Calendar dataNascimento, Endereco endereco, String celular, Convenio convenio) {
        return new Paciente(nome, dataNascimento, endereco, celular, convenio);
    }

    @Override
    public Paciente criarPaciente(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email, Convenio convenio) {
        return new Paciente(nome, dataNascimento, endereco, celular, email, convenio);
    }

    @Override
    public void atualizarPaciente(Paciente paciente, String nome, Calendar dataNascimento, Endereco endereco, String celular, Convenio convenio) {
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setCelular(celular);
        paciente.setConvenio(convenio);
    }

    @Override
    public void atualizarPaciente(Paciente paciente, String nome, Calendar dataNascimento, Endereco endereco, String celular, String email, Convenio convenio) {
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setCelular(celular);
        paciente.setEmail(email);
        paciente.setConvenio(convenio);
    }

    @Override
    public void removerPaciente(Paciente paciente) {
        paciente = null;
    }
}
