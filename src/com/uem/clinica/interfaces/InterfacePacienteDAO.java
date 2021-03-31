package com.uem.clinica.interfaces;

import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.util.Calendar;

public interface InterfacePacienteDAO {
    Paciente criarPaciente(String nome, Calendar dataNascimento, Endereco endereco, String celular, Convenio convenio);
    Paciente criarPaciente(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email, Convenio convenio);

    void atualizarPaciente(Paciente paciente, String nome, Calendar dataNascimento, Endereco endereco, String celular, Convenio convenio);
    void atualizarPaciente(Paciente paciente, String nome, Calendar dataNascimento, Endereco endereco, String celular, String email, Convenio convenio);

    void removerPaciente(Paciente paciente);
}
