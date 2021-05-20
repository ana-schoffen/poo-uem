package com.uem.clinica.entidades;

import com.uem.clinica.dao.ConsultaDAO;
import com.uem.clinica.dao.PacienteDAO;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;
import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;

public class Secretaria {

    private final ConsultaDAO consultaDAO;
    private final PacienteDAO pacienteDAO;

    public Secretaria(EntityManagerFactory emf){
        consultaDAO = new ConsultaDAO(emf);
        pacienteDAO = new PacienteDAO(emf);
    }

    public void criarPaciente(String nome, LocalDate dataNascimento, Endereco endereco,
                              String celular,
                              String email,
                              Convenio convenio) {

        Paciente p = new Paciente(nome, dataNascimento, endereco, celular, email, convenio);
        pacienteDAO.adicionarEntidade(p);
    }

    public Paciente detalhesPaciente(int id) {
        return pacienteDAO.buscarEntidade(id);
    }


    public ArrayList<Paciente> listarPacientes() {
        return pacienteDAO.getEntidades();
    }

    public void atualizarPaciente(int id, String nome, LocalDate dataNascimento,
                                  Endereco endereco,
                                   String celular, String email, Convenio convenio) {
        Paciente paciente = pacienteDAO.buscarEntidade(id);

        if (paciente == null) {
            return;
        }

        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setCelular(celular);
        paciente.setConvenio(convenio);
        
        pacienteDAO.adicionarEntidade(paciente);
    }

    public void removerPaciente(int id) {
        pacienteDAO.removerEntidade(id);
        ArrayList<Consulta> aux = consultaDAO.getEntidades();

        for (Consulta c : aux)
            if (c.getPaciente().getId() == id) {
                consultaDAO.removerEntidade(c.getId());
            }
    }

    public void criarConsulta(LocalDateTime data, Paciente p, TipoConsulta tipo) {

        Consulta c = new Consulta(data, p, tipo );
        consultaDAO.adicionarEntidade(c);
    }

    public Consulta detalhesConsulta(int id) {
        return consultaDAO.buscarEntidade(id);
    }


    public ArrayList<Consulta> listarConsultas() {
        return consultaDAO.getEntidades();
    }

    public void atualizarConsulta(int id, LocalDateTime data, Paciente p, TipoConsulta tipo) {
        Consulta consulta = consultaDAO.buscarEntidade(id);

        if (consulta == null) {
            return;
        }

        consulta.setDataConsulta(data);
        consulta.setPaciente(p);
        consulta.setTipo(tipo);
    }

    public void removerConsulta(int id) {
        consultaDAO.removerEntidade(id);
    }


}
