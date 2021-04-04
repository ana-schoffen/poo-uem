package com.uem.clinica.dao;

import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.time.LocalDate;
import java.util.ArrayList;

public class PacienteDAO implements InterfaceDAO<Paciente> {
    private final ArrayList<Paciente> pacientes;
    private int lastId = 0;

    public PacienteDAO() {
        this.pacientes = new ArrayList<>();

        Endereco end = new Endereco("Rua José Anselmo da Silva",
                                    734,
                                    "Apt 101",
                                    "Ressacada",
                                    "Itajaí",
                                    "SC",
                                    88307385);

        Paciente p = new Paciente("Yago Caldeira",
                                  LocalDate.of(1990, 7, 10),
                                  end,
                                  "(47) 98970-1797",
                                  "yyagocaldeira@example.com",
                                  Convenio.Particular);

        adicionarEntidade(p);

        end = new Endereco("Rua Portal dos Gramados",
                                    517,
                                    "Apt 903",
                                    "Portal dos Gramados",
                                    "Guarulhos",
                                    "SP",
                                    7124005);

        p = new Paciente("Gabriel Benedito Novaes",
                                  LocalDate.of(1944, 11, 12),
                                  end,
                                  "(11) 98862-1178",
                                  "gbenedito@example.com",
                                  Convenio.Plano);

        adicionarEntidade(p);
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
