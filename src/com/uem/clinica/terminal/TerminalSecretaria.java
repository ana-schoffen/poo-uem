package com.uem.clinica.terminal;

import com.uem.clinica.entidades.Secretaria;

public class TerminalSecretaria implements Terminal{
    private Secretaria secretaria;

    public TerminalSecretaria() {
        this.secretaria = new Secretaria();
    }

    @Override
    public void listarOperacoes() {
        System.out.println("\n===\t\tSECRETÁRIA\t\t===");
        System.out.println("0. Sair");
        System.out.println("1. Criar Paciente");
        System.out.println("2. Atualizar Paciente");
        System.out.println("3. Remover Paciente");
        System.out.println("4. Agendar Consulta");
        System.out.println("5. Atualizar Consulta");
        System.out.println("6. Cancelar Consulta");
        System.out.println("7. Consultas amanhã");
        System.out.print("\n> ");
    }

    @Override
    public void mapear(int operacao) {
        switch (operacao) {
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                System.out.println("Operação 1 secretária");
                break;
            case 2:
                System.out.println("Operação 2 secretária");
                break;
            case 3:
                System.out.println("Operação 3 secretária");
                break;
            case 4:
                System.out.println("Operação 4 secretária");
                break;
        }
    }
}
