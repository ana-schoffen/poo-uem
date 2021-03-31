package com.uem.clinica.terminal;

import com.uem.clinica.entidades.Medico;
import com.uem.clinica.entidades.Paciente;

public class TerminalMedico implements Terminal{
    private Medico medico;
    private Paciente paciente;

    public TerminalMedico() {
        this.medico = new Medico();
    }

    @Override
    public void listarOperacoes() {
        System.out.println("\n===\t\tMÉDICO\t\t===");
        System.out.println("0. Sair");
        System.out.println("1. Definir paciente");
        System.out.println("2. Adicionar detalhes paciente");
        System.out.println("3. Atualiazar detalhes paciente");
        System.out.println("4. Remover detalhes paciente");
        System.out.println("5. Criar prontuário");
        System.out.println("6. Atualizar prontuário");
        System.out.println("7. Remover prontuário");
        System.out.println("8. Gerar receita");
        System.out.println("9. Gerar atestado");
        System.out.println("10. Gerar declaração de acompanhamento");
        System.out.println("11. Ver n° de pacientes atendidos no mês");
        System.out.print("\n> ");
    }

    @Override
    public void mapear(int operacao) {
        switch (operacao) {
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                System.out.println("Operação 1 médico");
                break;
            case 2:
                System.out.println("Operação 2 médico");
                break;
            case 3:
                System.out.println("Operação 3 médico");
                break;
            case 4:
                System.out.println("Operação 4 médico");
                break;
            case 5:
                System.out.println("Operação 5 médico");
                break;
            case 6:
                System.out.println("Operação 6 médico");
                break;
            case 7:
                System.out.println("Operação 7 médico");
                break;
            case 8:
                System.out.println("Operação 8 médico");
                break;
            case 9:
                System.out.println("Operação 9 médico");
                break;
            case 10:
                System.out.println("Operação 10 médico");
                break;
            case 11:
                System.out.println("Operação 11 médico");
                break;
            default:
                System.out.println("Operação Inválida!");
                break;
        }
    }
}
