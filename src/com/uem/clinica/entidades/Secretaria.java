package com.uem.clinica.entidades;

import com.uem.clinica.dao.DadosClinica;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.time.LocalDate;
import java.util.ArrayList;

public class Secretaria {

    private final DadosClinica dao;

    public Secretaria(){
        dao = new DadosClinica();
    }

    public void criarPaciente(String nome, LocalDate dataNascimento, Endereco endereco,
                              String celular,
                              String email,
                              Convenio convenio) {

        Paciente p = new Paciente(nome, dataNascimento, endereco, celular, email, convenio);
        dao.adicionarPaciente(p);
    }

    public Paciente detalhesPaciente(int id) {
        return dao.buscarPaciente(id);
    }


    public ArrayList<Paciente> listarPacientes() {
        return dao.getPacientes();
    }

    public void atualizarPaciente(int id, String nome, LocalDate dataNascimento,
                                  Endereco endereco,
                                   String celular, String email, Convenio convenio) {
        Paciente paciente = dao.buscarPaciente(id);

        if (paciente == null) {
            return;
        }

        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setCelular(celular);
        paciente.setConvenio(convenio);
    }

    public void removerPaciente(int id) {
        dao.removerPaciente(id);
    }
}
