package com.uem.clinica.entidades;

import com.uem.clinica.banco.DadosClinica;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.time.LocalDate;

public class Secretaria {

    public Secretaria(){

    }

    public void criarPaciente(DadosClinica banco, String nome, LocalDate dataNascimento, Endereco endereco,
                              String celular,
                              String email,
                              Convenio convenio) {

        Paciente p = new Paciente(nome, dataNascimento, endereco, celular, email, convenio);
        banco.adicionarPaciente(p);
    }

    public void atualizarPaciente(DadosClinica banco, int id, String nome, LocalDate dataNascimento,
                                  Endereco endereco,
                                   String celular, String email, Convenio convenio) {
        Paciente paciente = banco.buscarPaciente(id);

        if (paciente == null) {
            return;
        }

        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setEndereco(endereco);
        paciente.setCelular(celular);
        paciente.setConvenio(convenio);
    }

    public void removerPaciente(DadosClinica banco, int id) {
        banco.removerPaciente(id);
    }
}
