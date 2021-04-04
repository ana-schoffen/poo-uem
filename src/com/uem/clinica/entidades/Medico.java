package com.uem.clinica.entidades;

import com.uem.clinica.dao.ConsultaDAO;
import com.uem.clinica.dao.PacienteDAO;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;
import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Medico {

    private final PacienteDAO pacienteDAO;
    private final ConsultaDAO consultaDAO;

    public Medico(){
        consultaDAO = new ConsultaDAO();
        pacienteDAO = new PacienteDAO();

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

        pacienteDAO.adicionarEntidade(p);

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

        pacienteDAO.adicionarEntidade(p);

        Consulta c = new Consulta(LocalDateTime.of(2021, 4, 5, 15, 0),
                                  p,
                                  TipoConsulta.Regular
                                  );

        consultaDAO.adicionarEntidade(c);
    }

    public Paciente buscarPaciente(int id) {
        return pacienteDAO.buscarEntidade(id);
    }
    public Consulta buscarConsulta(int id) {
        return consultaDAO.buscarEntidade(id);
    }

    public ArrayList<Paciente> getPacientes() {
        return pacienteDAO.getEntidades();
    }
    public ArrayList<Consulta> getConsultas() {
        return consultaDAO.getEntidades();
    }


}
