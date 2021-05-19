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

public class Medico {

    private final String nome = "Emanuele Eduarda Mendes";
    private final PacienteDAO pacienteDAO;
    private final ConsultaDAO consultaDAO;

    public Medico(EntityManagerFactory emf){
        consultaDAO = new ConsultaDAO(emf);
        pacienteDAO = new PacienteDAO(emf);
    }

    public Paciente buscarPaciente(int id) {
        return pacienteDAO.buscarEntidade(id);
    }
    public Consulta buscarConsulta(int id) {
        return consultaDAO.buscarEntidade(id);
    }
    
    public void atualizarConsulta(Consulta c) {
        consultaDAO.adicionarEntidade(c);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacienteDAO.getEntidades();
    }
    public ArrayList<Consulta> getConsultas() {
        return consultaDAO.getEntidades();
    }

    public String getNome() {
        return nome;
    }
}
