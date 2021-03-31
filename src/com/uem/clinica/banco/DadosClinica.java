package com.uem.clinica.banco;

import com.uem.clinica.entidades.Consulta;
import com.uem.clinica.entidades.Paciente;

import java.util.ArrayList;

public class DadosClinica {
    private final ArrayList<Paciente> pacientes;
    private final ArrayList<Consulta> consultas;
    private int lastIdPaciente = 0;
    private int lastIdConsulta = 0;

    public DadosClinica() {
        this.pacientes = new ArrayList<>();
        this.consultas = new ArrayList<>();
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void adicionarPaciente(Paciente p) {
        lastIdPaciente += 1;
        p.setId(lastIdPaciente);
        pacientes.add(p);
    }

    public Paciente buscarPaciente(int id) {
        for (Paciente obj : pacientes)
            if (obj.getId() == id) {
                return obj;
            }

        return null;
    }

    public void removerPaciente(int id) {
        pacientes.removeIf(p -> p.getId() == id);

    }

    public void adicionarConsulta(Consulta c) {
        lastIdConsulta += 1;
        c.setId(lastIdConsulta);
        consultas.add(c);
    }

    public Consulta buscarConsulta(int id) {
        for (Consulta obj : consultas)
            if (obj.getId() == id) {
                return obj;
            }

        return null;
    }

    public void removerConsulta(Consulta p) {
        consultas.remove(p);
    }
}
