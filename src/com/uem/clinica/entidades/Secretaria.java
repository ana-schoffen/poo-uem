package com.uem.clinica.entidades;

import com.uem.clinica.dao.DadosClinica;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;
import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    public void criarConsulta(LocalDateTime data, Paciente p, TipoConsulta tipo) {

        Consulta c = new Consulta(data, p, tipo );
        dao.adicionarConsulta(c);
    }

    public Consulta detalhesConsulta(int id) {
        return dao.buscarConsulta(id);
    }


    public ArrayList<Consulta> listarConsultas() {
        return dao.getConsultas();
    }

    public void atualizarConsulta(int id, LocalDateTime data, Paciente p, TipoConsulta tipo) {
        Consulta consulta = dao.buscarConsulta(id);

        if (consulta == null) {
            return;
        }

        consulta.setData(data);
        consulta.setPaciente(p);
        consulta.setTipo(tipo);
    }

    public void removerConsulta(int id) {
        dao.removerConsulta(id);
    }


}
