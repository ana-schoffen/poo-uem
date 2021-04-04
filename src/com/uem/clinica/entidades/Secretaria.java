package com.uem.clinica.entidades;

import com.uem.clinica.dao.ConsultaDAO;
import com.uem.clinica.dao.PacienteDAO;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;
import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Secretaria {

    private final ConsultaDAO consultaDAO;
    private final PacienteDAO pacienteDAO;

    public Secretaria(){
        consultaDAO = new ConsultaDAO();
        pacienteDAO = new PacienteDAO();

        //cadastra alguns pacientes e consultas nos registros
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

        Consulta c = new Consulta(LocalDateTime.now().plusHours(2),
                p,
                TipoConsulta.Regular
        );

        consultaDAO.adicionarEntidade(c);

        c = new Consulta(LocalDateTime.now().minusHours(1),
                pacienteDAO.buscarEntidade(1),
                TipoConsulta.Regular
        );

        consultaDAO.adicionarEntidade(c);

        c = new Consulta(LocalDateTime.now().minusDays(2),
                p,
                TipoConsulta.Retorno
        );

        consultaDAO.adicionarEntidade(c);

        c = new Consulta(LocalDateTime.now().plusDays(10),
                p,
                TipoConsulta.Retorno
        );

        consultaDAO.adicionarEntidade(c);
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

        consulta.setData(data);
        consulta.setPaciente(p);
        consulta.setTipo(tipo);
    }

    public void removerConsulta(int id) {
        consultaDAO.removerEntidade(id);
    }


}
