package com.uem.clinica.terminal;

import com.uem.clinica.entidades.Consulta;
import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.entidades.Secretaria;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;
import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TerminalSecretaria implements Terminal{
    private final Secretaria secretaria;
    private final Scanner scan;

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
        System.out.println("6. Listar Consultas");
        System.out.println("7. Atualizar Consulta");
        System.out.println("8. Cancelar Consulta");
        System.out.println("9. Consultas amanhã");
        System.out.print("\n> ");
    }

    @Override
    public void mapear(int operacao) {
        String nome, cel, email;
        LocalDate nasc;
        LocalDateTime horario;
        Endereco end;
        Convenio convenio;
        TipoConsulta tipo;
        Paciente aux_p;
        Consulta aux_c;
        int op, id;

        switch (operacao) {
            case 0:
                System.out.println("Saindo...");
                scan.close();
                break;
            case 1:
                System.out.print("Nome: ");
                nome = (scan.nextLine());
                System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                nasc = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                end = new Endereco();
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
                cel = scan.nextLine();
                System.out.print("Email: ");
                email = scan.nextLine();

                op = getConvenio();

                convenio = (op == 1) ? Convenio.Particular : Convenio.Plano;

                this.secretaria.criarPaciente(nome, nasc, end, cel, email, convenio);
                break;
            case 2:
                ArrayList<Paciente> pacientes = secretaria.listarPacientes();
                System.out.println("PACIENTES:");
                pacientes.forEach(p -> System.out.println(p.toString()));
                break;
            case 3:
                System.out.print("Digite o id do paciente: ");
                id = scan.nextInt();
                scan.nextLine();

                aux_p = secretaria.detalhesPaciente(id);

                if (aux_p == null) {
                    System.out.println("Paciente não existe");
                    return;
                }

                System.out.println("Paciente: " + aux_p.toString());
                System.out.println("Digite os novos dados: ");


                System.out.print("Nome: ");
                nome = (scan.nextLine());
                System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                nasc = LocalDate.parse(scan.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                end = new Endereco();
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
                cel = scan.nextLine();
                System.out.print("Email: ");
                email = scan.nextLine();

                op = getConvenio();

                convenio = (op == 1) ? Convenio.Particular : Convenio.Plano;

                this.secretaria.atualizarPaciente(id, nome, nasc, end, cel, email, convenio);
                break;
            case 4:
                System.out.print("Digite o id do paciente: ");
                id = scan.nextInt();
                scan.nextLine();

                aux_p = secretaria.detalhesPaciente(id);

                if (aux_p == null) {
                    System.out.println("Paciente não existe");
                    return;
                }

                System.out.println("Paciente: " + aux_p.toString());
                System.out.print("Tem certeza que deseja remover o paciente? (Digite SIM para confirmar) ");
                String confirmacao = scan.nextLine();

                if (confirmacao.equals("SIM")) {
                    System.out.println("Removendo paciente "+ id);
                    secretaria.removerPaciente(id);
                } else {
                    System.out.println("Operação cancelada");
                }

                break;
            case 5:
                System.out.print("Digite o id do paciente: ");
                id = scan.nextInt();
                scan.nextLine();

                aux_p = secretaria.detalhesPaciente(id);

                if (aux_p == null) {
                    System.out.println("Paciente não existe");
                    return;
                }

                System.out.print("Digite o horário da consulta (hh:mm dd/mm/aaaa): ");
                horario = LocalDateTime.parse(scan.nextLine(), DateTimeFormatter.ofPattern("kk:mm dd/MM/yyyy"));

                op = getTipo();

                tipo = (op == 1) ? TipoConsulta.Regular : TipoConsulta.Retorno;

                secretaria.criarConsulta(horario, aux_p, tipo);
                break;
            case 6:
                ArrayList<Consulta> consultas = secretaria.listarConsultas();
                System.out.println("Consultas:");
                System.out.println("ID|HORÁRIO|ID PACIENTE|TIPO");
                consultas.forEach(p -> System.out.println(p));
                break;
            case 7:
                System.out.print("Digite o id da consulta: ");
                id = scan.nextInt();
                scan.nextLine();

                aux_c = secretaria.detalhesConsulta(id);

                if (aux_c == null) {
                    System.out.println("Consulta não existe");
                    return;
                }

                System.out.println("Consulta: " + aux_c);
                System.out.println("Digite os novos dados: ");

                System.out.print("Digite o id do paciente: ");
                id = scan.nextInt();
                scan.nextLine();

                aux_p = secretaria.detalhesPaciente(id);

                if (aux_p == null) {
                    System.out.println("Paciente não existe");
                    return;
                }

                System.out.print("Digite o horário da consulta (hh:mm dd/mm/aaaa): ");
                horario = LocalDateTime.parse(scan.nextLine(), DateTimeFormatter.ofPattern("kk:mm dd/MM/yyyy"));

                op = getTipo();

                tipo = (op == 1) ? TipoConsulta.Regular : TipoConsulta.Retorno;
                secretaria.atualizarConsulta(id, horario, aux_p, tipo);
                break;
        }
    }

    private int getTipo() {
        int op;
        do {
            System.out.println("Tipo:");
            System.out.println("1. Regular");
            System.out.println("2. Retorno");

            System.out.print("\n> ");
            op = scan.nextInt();
        } while (op != 1 && op != 2);
        return op;
    }

    private int getConvenio() {
        int op;
        do {
            System.out.println("Convênio:");
            System.out.println("1. Particular");
            System.out.println("2. Plano");

            System.out.print("\n> ");
            op = scan.nextInt();
        } while (op != 1 && op != 2);
        return op;
    }
}
