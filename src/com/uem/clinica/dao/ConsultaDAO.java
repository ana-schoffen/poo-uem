package com.uem.clinica.dao;

import com.uem.clinica.entidades.Consulta;

import java.util.ArrayList;

public class ConsultaDAO implements InterfaceDAO<Consulta> {
    private final ArrayList<Consulta> consultas;
    private int lastId = 0;

    public ConsultaDAO() {
        this.consultas = new ArrayList<>();
    }

    @Override
    public ArrayList<Consulta> getEntidades() {
        return consultas;
    }

    @Override
    public void adicionarEntidade(Consulta obj) {
        lastId += 1;
        obj.setId(lastId);
        consultas.add(obj);
    }

    @Override
    public Consulta buscarEntidade(int id) {
        for (Consulta obj : consultas)
            if (obj.getId() == id) {
                return obj;
            }

        return null;
    }

    @Override
    public boolean removerEntidade(int id) {
        return consultas.removeIf(c -> c.getId() == id);
    }
}
