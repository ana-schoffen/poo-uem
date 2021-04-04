package com.uem.clinica.terminal;

import com.uem.clinica.entidades.Consulta;
import com.uem.clinica.entidades.Medico;
import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.entidades.Prontuario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class TerminalMedico implements Terminal{
    private final Medico medico;
    private Paciente paciente;
    private Consulta consulta;
    private final Scanner scan;

    public TerminalMedico() {
        medico = new Medico();
        scan = new Scanner(System.in);
    }

    @Override
    public void listarOperacoes() {
        System.out.println("\n===\t\tMÉDICO\t\t===");
        System.out.println("0. Sair");
        System.out.println("1. Definir paciente");
        System.out.println("2. Definir consulta");
        System.out.println("3. Listar pacientes");
        System.out.println("4. Adicionar detalhes paciente");
        System.out.println("5. Listar detalhes paciente");
        System.out.println("6. Atualiazar detalhes paciente");
        System.out.println("7. Remover detalhes paciente");
        System.out.println("8. Criar prontuário");
        System.out.println("9. Mostrar prontuário");
        System.out.println("10. Atualizar prontuário");
        System.out.println("11. Remover prontuário");
        System.out.println("12. Gerar receita");
        System.out.println("13. Gerar atestado");
        System.out.println("14. Gerar declaração de acompanhamento");
        System.out.println("15. Ver n° de pacientes atendidos no mês");
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
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }
                ArrayList<Consulta> consultas = medico.getConsultas();
                int count = 0;
                for (Consulta c : consultas) {
                    if ( c.getPaciente() == paciente ) {
                        System.out.println(c.getId() + " | " + c);
                        count += 1;
                    }
                }
                if (count == 0) {
                    System.out.println("Nenhuma consulta para este paciente");
                    return;
                }
                System.out.print("Usar qual consulta? (Use os indices acima) ");
                id = scan.nextInt();
                scan.nextLine();

                this.consulta = medico.buscarConsulta(id);

                if (consulta == null) {
                    System.out.print("Entrada inválida!");
                    return;
                }
                break;
            case 3:
                System.out.println("Pacientes: ");
                pacientes = medico.getPacientes();
                pacientes.forEach(System.out::println);
                break;
            case 4:
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
            case 5:
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
            case 6:
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
                        if (paciente.getAlergias().isEmpty()){
                            System.out.println("Nenhuma");
                            return;
                        }

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
                        if (paciente.getCirurgias().isEmpty()) {
                            System.out.println("Nenhuma");
                            return;
                        }

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
                        if (paciente.getDadosAdicionais().isEmpty()) {
                            System.out.println("Nenhuma");
                            return;
                        }

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
            case 7:
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
            case 8:
                consulta.setProntuario(new Prontuario());
                System.out.println("Digite os sintomas (Nada para parar): ");
                do {
                    System.out.print("> ");
                    addAux = scan.nextLine();

                    if (!addAux.equals("")) {
                        consulta.getProntuario().getSintomas().add(addAux);
                    }
                } while (!addAux.equals(""));

                System.out.println("Qual o diagnóstico? ");
                System.out.print("> ");
                consulta.getProntuario().setDiagnostico(scan.nextLine());

                System.out.println("Quais as prescrições? (<medicamento>, <posologia>) ");
                do {
                    System.out.print("> ");
                    addAux = scan.nextLine();

                    if (!addAux.equals("")) {
                        String[] entrada = addAux.split(",");
                        HashMap<String, String> med = consulta.getProntuario().getPrescricao();
                        try{
                            med.put(entrada[0], entrada[1]);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                        }
                    }
                } while (!addAux.equals(""));
                break;
            case 9:
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }
                if (consulta == null) {
                    System.out.println("Nenhuma consulta selecionada");
                    return;
                }
                if (consulta.getProntuario() == null) {
                    System.out.println("Nenhum prontuário criado");
                    return;
                }

                System.out.println("Paciente: " + paciente.getNome());
                System.out.println("=== Sintomas ===");
                consulta.getProntuario().getSintomas().forEach(System.out::println);

                System.out.println("=== Diagnóstico ===");
                System.out.println(consulta.getProntuario().getDiagnostico());

                System.out.println("=== Prescrição ===");
                HashMap<String, String> pres = consulta.getProntuario().getPrescricao();
                pres.keySet().forEach(k -> System.out.println(k + " - " + pres.get(k)));

                break;
            case 10:
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }
                if (consulta == null) {
                    System.out.println("Nenhuma consulta selecionada");
                    return;
                }
                if (consulta.getProntuario() == null) {
                    System.out.println("Nenhum prontuário criado");
                    return;
                }

                do {
                    System.out.println("Editar:");
                    System.out.println("1. Sintomas");
                    System.out.println("2. Diagnóstico");
                    System.out.println("3. Prescrição");
                    System.out.print("\n> ");
                    op = scan.nextInt();
                    scan.nextLine();
                } while (op != 1 && op != 2 && op != 3);

                switch (op) {
                    case 1:
                        System.out.println("=== Sintomas ===");
                        for (String c : consulta.getProntuario().getSintomas()) {
                            System.out.println(consulta.getProntuario().getSintomas().indexOf(c) + " | " + c);
                        }
                        if (consulta.getProntuario().getSintomas().isEmpty()) {
                            System.out.println("Nenhuma");
                            return;
                        }

                        System.out.print("Editar qual entrada? (Use os indices acima) ");
                        id = scan.nextInt();
                        scan.nextLine();

                        try {
                            ponto = consulta.getProntuario().getSintomas().get(id);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Editando: " + ponto);
                        System.out.print("Nova entrada => ");
                        addAux = scan.nextLine();

                        consulta.getProntuario().getSintomas().remove(id);
                        consulta.getProntuario().getSintomas().add(id, addAux);
                        break;
                    case 2:
                        System.out.println("=== Diagnóstico ===");
                        System.out.println("Atual: " + consulta.getProntuario().getDiagnostico());
                        System.out.print("Nova entrada => ");
                        addAux = scan.nextLine();

                        consulta.getProntuario().setDiagnostico(addAux);
                        break;
                    case 3:
                        System.out.println("=== Prescrição ===");
                        for (String p : consulta.getProntuario().getPrescricao().keySet()) {
                            System.out.println(p);
                        }
                        if (consulta.getProntuario().getPrescricao().isEmpty()) {
                            System.out.println("Nenhuma");
                            return;
                        }

                        System.out.print("Editar qual entrada? (Digite o nome da entrada) ");
                        addAux = scan.nextLine();

                        try {
                            ponto = consulta.getProntuario().getPrescricao().get(addAux);
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                            return;
                        }

                        System.out.println("Editando: " + addAux + " - " + ponto);
                        System.out.print("Nova entrada (<medicamento>,<posologia>) => ");
                        ponto = scan.nextLine();

                        String[] prescricao = ponto.split(",");

                        try{
                            consulta.getProntuario().getPrescricao().put(prescricao[0], prescricao[1]);
                            System.out.println("Entrada atualizada!");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Entrada inválida!");
                        }

                        consulta.getProntuario().getPrescricao().remove(addAux);
                        break;
                }
                break;
            case 11:
                if (paciente == null) {
                    System.out.println("Nenhum paciente selecionado");
                    return;
                }
                if (consulta == null) {
                    System.out.println("Nenhuma consulta selecionada");
                    return;
                }
                if (consulta.getProntuario() == null) {
                    System.out.println("Nenhum prontuário criado");
                    return;
                }
                System.out.print("Tem certeza que deseja destruir o prontuário? (Digite SIM para confirmar) ");
                String confirmacao = scan.nextLine();

                if (confirmacao.equals("SIM")) {
                    System.out.println("Removendo prontuário");
                    consulta.setProntuario(null);
                } else {
                    System.out.println("Operação cancelada");
                }
                break;
            case 12:
                System.out.println("Operação 11 médico");
                break;
            default:
                System.out.println("Operação Inválida!");
                break;
        }
    }
}
