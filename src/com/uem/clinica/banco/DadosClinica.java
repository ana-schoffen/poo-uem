package com.uem.clinica.banco;

import com.uem.clinica.entidades.Consulta;
import com.uem.clinica.entidades.Paciente;

import java.util.ArrayList;

public class DadosClinica {
    private final ArrayList<Paciente> pacientes;
    private final ArrayList<Consulta> consultas;
    private int lastId = 0;

    public DadosClinica() {
        this.pacientes = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void adicionarPaciente(Paciente p) {
        lastId += 1;
        p.setId(lastId);
        pacientes.add(p);
    }

    public Paciente buscarPaciente(int id) {
        for (Paciente obj : pacientes)
            if (obj.getId() == id) {
                return obj;
            }

        return null;
    }

    public void removerPaciente(Paciente p) {
        pacientes.remove(p);
    }
}
