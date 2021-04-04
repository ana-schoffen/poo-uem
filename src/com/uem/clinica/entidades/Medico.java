package com.uem.clinica.entidades;

import com.uem.clinica.dao.ConsultaDAO;
import com.uem.clinica.dao.PacienteDAO;

import java.util.ArrayList;

public class Medico {

    private PacienteDAO pacienteDAO;
    private ConsultaDAO consultaDAO;

    public Medico(){
        consultaDAO = new ConsultaDAO();
        pacienteDAO = new PacienteDAO();
    }

    public Paciente buscarPaciente(int id) {
        return pacienteDAO.buscarEntidade(id);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacienteDAO.getEntidades();
    }


}
