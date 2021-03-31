package com.uem.clinica.interfaces;

import com.uem.clinica.entidades.Secretaria;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.util.Calendar;

public interface InterfaceSecretariaDAO {
    Secretaria criarSecretaria(String nome, Calendar dataNascimento, Endereco endereco, String celular);
    Secretaria criarSecretaria(String nome, Calendar dataNascimento, Endereco endereco, String celular, String email);

    void atualizarSecretaria(Secretaria secretaria, String nome, Calendar dataNascimento, Endereco endereco, String celular);
    void atualizarPaciente(Secretaria secretaria, String nome, Calendar dataNascimento, Endereco endereco, String celular, String email);

    void removerSecretaria(Secretaria secretaria);

}
