package com.uem.clinica.terminal;

import com.uem.clinica.entidades.Medico;
import com.uem.clinica.entidades.Paciente;

import java.util.ArrayList;
import java.util.Scanner;

public class TerminalMedico implements Terminal{
    private Medico medico;
    private Paciente paciente;
    private Scanner scan;

    public TerminalMedico() {
        medico = new Medico();
        scan = new Scanner(System.in);
    }

    @Override
    public void listarOperacoes() {
        System.out.println("\n===\t\tMÉDICO\t\t===");
        System.out.println("0. Sair");
        System.out.println("1. Definir paciente");
        System.out.println("2. Listar pacientes");
        System.out.println("3. Adicionar detalhes paciente");
        System.out.println("4. Listar detalhes paciente");
        System.out.println("5. Atualiazar detalhes paciente");
        System.out.println("6. Remover detalhes paciente");
        System.out.println("7. Criar prontuário");
        System.out.println("8. Atualizar prontuário");
        System.out.println("9. Remover prontuário");
        System.out.println("10. Gerar receita");
        System.out.println("11. Gerar atestado");
        System.out.println("12. Gerar declaração de acompanhamento");
        System.out.println("13. Ver n° de pacientes atendidos no mês");
        System.out.print("\n> ");
    }

    @Override
    public void mapear(int operacao) {
        String addAux, ponto;
        ArrayList<Paciente> pacientes;
        Paciente auxP;
        int id, op;
        switch (operacao) {
            case 0:
                System.out.println("Saindo...");
                break;
            case 1:
                System.out.print("Digite o Id do paciente: ");
                id = scan.nextInt();
                scan.nextLine();

                auxP = medico.buscarPaciente(id);

                if (auxP == null) {
                    System.out.println("Paciente não existe");
                    return;
                }

                paciente = auxP;
                break;
            case 2:
                System.out.println("Pacientes: ");
                pacientes = medico.getPacientes();
                pacientes.forEach(System.out::println);
                break;
            case 3:
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }

                do {
                    System.out.println("Adicionar:");
                    System.out.println("1. Alergias");
                    System.out.println("2. Cirurgias");
                    System.out.println("3. Outros dados");
                    System.out.print("\n> ");
                    op = scan.nextInt();
                    scan.nextLine();
                } while (op != 1 && op != 2 && op != 3);

                switch (op) {
                    case 1:
                        System.out.println("Digite uma alergia (nada para parar)");
                        do {
                            System.out.print("> ");
                            addAux = scan.nextLine();

                            if (!addAux.equals("")) {
                                paciente.getAlergias().add(addAux);
                            }
                        } while (!addAux.equals(""));
                        break;
                    case 2:
                        System.out.println("Digite uma cirurgia (nada para parar)");
                        do {
                            System.out.print("> ");
                            addAux = scan.nextLine();

                            if (!addAux.equals("")) {
                                paciente.getCirurgias().add(addAux);
                            }
                        } while (!addAux.equals(""));
                        break;
                    case 3:
                        System.out.println("Digite outros dados (nada para parar)");
                        do {
                            System.out.print("> ");
                            addAux = scan.nextLine();

                            if (!addAux.equals("")) {
                                paciente.getDadosAdicionais().add(addAux);
                            }
                        } while (!addAux.equals(""));
                        break;
                }


                break;
            case 4:
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }
                System.out.println("Paciente: " + paciente.getNome());
                System.out.println("=== Cirurgias ===");
                paciente.getCirurgias().forEach(System.out::println);

                if (paciente.getCirurgias().isEmpty())
                    System.out.println("Nenhuma");

                System.out.println("=== Alergias ===");
                paciente.getAlergias().forEach(System.out::println);

                if (paciente.getAlergias().isEmpty())
                    System.out.println("Nenhuma");

                System.out.println("=== Outros dados ===");
                paciente.getDadosAdicionais().forEach(System.out::println);

                if (paciente.getDadosAdicionais().isEmpty())
                    System.out.println("Nenhum");
                break;
            case 5:
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }

                do {
                    System.out.println("Editar:");
                    System.out.println("1. Alergias");
                    System.out.println("2. Cirurgias");
                    System.out.println("3. Outros dados");
                    System.out.print("\n> ");
                    op = scan.nextInt();
                    scan.nextLine();
                } while (op != 1 && op != 2 && op != 3);

                switch (op) {
                    case 1:
                        System.out.println("=== Alergias ===");
                        for (String p : paciente.getAlergias()) {
                            System.out.println(paciente.getAlergias().indexOf(p) + " | " + p);
                        }
                        if (paciente.getAlergias().isEmpty())
                            System.out.println("Nenhuma");

                        System.out.print("Editar qual entrada? (Use os indices acima) ");
                        id = scan.nextInt();
                        scan.nextLine();

                        try {
                            ponto = paciente.getAlergias().get(id);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Editando: " + ponto);
                        System.out.print("Nova entrada => ");
                        addAux = scan.nextLine();

                        paciente.getAlergias().remove(id);
                        paciente.getAlergias().add(id, addAux);
                        break;
                    case 2:
                        System.out.println("=== Cirurgias ===");
                        for (String p : paciente.getCirurgias()) {
                            System.out.println(paciente.getCirurgias().indexOf(p) + " | " + p);
                        }
                        if (paciente.getCirurgias().isEmpty())
                            System.out.println("Nenhuma");

                        System.out.print("Editar qual entrada? (Use os indices acima) ");
                        id = scan.nextInt();
                        scan.nextLine();

                        try {
                            ponto = paciente.getCirurgias().get(id);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Editando: " + ponto);
                        System.out.print("Nova entrada => ");
                        addAux = scan.nextLine();

                        paciente.getCirurgias().remove(id);
                        paciente.getCirurgias().add(id, addAux);
                        break;
                    case 3:
                        System.out.println("=== Outros dados ===");
                        for (String p : paciente.getDadosAdicionais()) {
                            System.out.println(paciente.getDadosAdicionais().indexOf(p) + " | " + p);
                        }
                        if (paciente.getDadosAdicionais().isEmpty())
                            System.out.println("Nenhuma");

                        System.out.print("Editar qual entrada? (Use os indices acima) ");
                        id = scan.nextInt();
                        scan.nextLine();

                        try {
                            ponto = paciente.getDadosAdicionais().get(id);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Editando: " + ponto);
                        System.out.print("Nova entrada => ");
                        addAux = scan.nextLine();

                        paciente.getDadosAdicionais().remove(id);
                        paciente.getDadosAdicionais().add(id, addAux);
                        break;
                }


                break;
            case 6:
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }

                do {
                    System.out.println("Remover:");
                    System.out.println("1. Alergias");
                    System.out.println("2. Cirurgias");
                    System.out.println("3. Outros dados");
                    System.out.print("\n> ");
                    op = scan.nextInt();
                    scan.nextLine();
                } while (op != 1 && op != 2 && op != 3);

                switch (op) {
                    case 1:
                        System.out.println("=== Alergias ===");
                        for (String p : paciente.getAlergias()) {
                            System.out.println(paciente.getAlergias().indexOf(p) + " | " + p);
                        }
                        if (paciente.getAlergias().isEmpty())
                            System.out.println("Nenhuma");

                        System.out.print("Remover qual entrada? (Use os indices acima) ");
                        id = scan.nextInt();
                        scan.nextLine();

                        try {
                            ponto = paciente.getAlergias().get(id);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Removendo: " + ponto);
                        paciente.getAlergias().remove(id);
                        break;
                    case 2:
                        System.out.println("=== Cirurgias ===");
                        for (String p : paciente.getCirurgias()) {
                            System.out.println(paciente.getCirurgias().indexOf(p) + " | " + p);
                        }
                        if (paciente.getCirurgias().isEmpty())
                            System.out.println("Nenhuma");

                        System.out.print("Remover qual entrada? (Use os indices acima) ");
                        id = scan.nextInt();
                        scan.nextLine();

                        try {
                            ponto = paciente.getCirurgias().get(id);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Removendo: " + ponto);
                        paciente.getCirurgias().remove(id);
                        break;
                    case 3:
                        System.out.println("=== Outros dados ===");
                        for (String p : paciente.getDadosAdicionais()) {
                            System.out.println(paciente.getDadosAdicionais().indexOf(p) + " | " + p);
                        }
                        if (paciente.getDadosAdicionais().isEmpty())
                            System.out.println("Nenhuma");

                        System.out.print("Remover qual entrada? (Use os indices acima) ");
                        id = scan.nextInt();
                        scan.nextLine();

                        try {
                            ponto = paciente.getDadosAdicionais().get(id);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Removendo: " + ponto);
                        paciente.getDadosAdicionais().remove(id);
                        break;
                }
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
