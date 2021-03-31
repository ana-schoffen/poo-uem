package com.uem.clinica;
import com.uem.clinica.banco.DadosClinica;
import com.uem.clinica.terminal.Terminal;
import com.uem.clinica.terminal.TerminalMedico;
import com.uem.clinica.terminal.TerminalSecretaria;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        DadosClinica banco = new DadosClinica();

        Scanner scan = new Scanner(System.in);
        int opt;

        do {
            System.out.println("===\t\tCLINICA MÉDICA\t\t===\n");
            System.out.println("1. Entrar como secretária");
            System.out.println("2. Entrar como médico\n");
            System.out.print("> ");
            opt = scan.nextInt();
        } while (opt != 1 && opt != 2);

        Terminal term;

        if (opt == 1) {
            term = new TerminalSecretaria();
        } else {
            term = new TerminalMedico();
        }

        do {
            term.listarOperacoes();
            opt = scan.nextInt();
            term.mapear(banco, opt);
        } while (opt != 0);

    }
}
