package com.uem.clinica.dao;

import com.uem.clinica.entidades.Paciente;
import java.util.ArrayList;

public class PacienteDAO implements InterfaceDAO<Paciente> {
    private final ArrayList<Paciente> pacientes;
    private int lastId = 0;

    public PacienteDAO() {
        this.pacientes = new ArrayList<>();
    }

    @Override
    public ArrayList<Paciente> getEntidades() {
        return pacientes;
    }

    @Override
    public void adicionarEntidade(Paciente obj) {
        lastId += 1;
        obj.setId(lastId);
        pacientes.add(obj);
    }

    @Override
    public Paciente buscarEntidade(int id) {
        for (Paciente obj : pacientes)
            if (obj.getId() == id) {
                return obj;
            }

        return null;
    }

    @Override
    public void removerEntidade(int id) {
        pacientes.removeIf(p -> p.getId() == id);
    }
}
