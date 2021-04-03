package com.uem.clinica.terminal;

import com.uem.clinica.banco.DadosClinica;
import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.entidades.Secretaria;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TerminalSecretaria implements Terminal{
    private final Secretaria secretaria;
    private Scanner scan;

    public TerminalSecretaria() {
        this.secretaria = new Secretaria();
        this.scan = new Scanner(System.in);
    }

    @Override
    public void listarOperacoes() {
        System.out.println("\n===\t\tSECRETÁRIA\t\t===");
        System.out.println("0. Sair");
        System.out.println("1. Criar Paciente");
        System.out.println("2. Listar Pacientes");
        System.out.println("3. Atualizar Paciente");
        System.out.println("4. Remover Paciente");
        System.out.println("5. Agendar Consulta");
        System.out.println("6. Atualizar Consulta");
        System.out.println("7. Cancelar Consulta");
        System.out.println("8. Consultas amanhã");
        System.out.print("\n> ");
    }

    @Override
    public void mapear(DadosClinica banco, int operacao) {
        switch (operacao) {
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                System.out.print("Nome: ");
                String nome = (scan.nextLine());
                System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                LocalDate nasc = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                Endereco end = new Endereco();
                System.out.print("Rua: ");
                end.setRua(scan.nextLine());
                System.out.print("Número: ");
                end.setNumero(scan.nextInt());
                scan.nextLine();
                System.out.print("Bairro: ");
                end.setBairro(scan.nextLine());
                System.out.print("Complemento: ");
                end.setComplemento(scan.nextLine());
                System.out.print("CEP: ");
                end.setCep(scan.nextInt());
                scan.nextLine();
                System.out.print("Cidade: ");
                end.setCidade(scan.nextLine());
                System.out.print("Estado: ");
                end.setEstado(scan.nextLine());
                System.out.print("Celular: ");
                String cel = scan.nextLine();
                System.out.print("Email: ");
                String email = scan.nextLine();

                int op;

                do {
                    System.out.println("Convênio:");
                    System.out.println("1. Particular");
                    System.out.println("2. Plano");

                    System.out.print("\n> ");
                    op = scan.nextInt();
                } while (op != 1 && op != 2);

                Convenio convenio = (op == 1) ? Convenio.Particular : Convenio.Plano;

                this.secretaria.criarPaciente(banco, nome, nasc, end, cel, email, convenio);
                break;
            case 2:
                ArrayList<Paciente> pacientes = banco.getPacientes();
                System.out.println("PACIENTES:");
                pacientes.forEach(p -> System.out.println(p.toString()));
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
