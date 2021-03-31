package com.uem.clinica.terminal;

import com.uem.clinica.banco.DadosClinica;

public interface Terminal {
    void listarOperacoes();
    void mapear(DadosClinica banco, int operacao);
}
