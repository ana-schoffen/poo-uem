package com.uem.clinica;
import com.uem.clinica.terminal.Terminal;
import com.uem.clinica.terminal.TerminalMedico;
import com.uem.clinica.terminal.TerminalSecretaria;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int opt;

        do {
            System.out.println("===\t\tCLINICA MÉDICA\t\t===\n");
            System.out.println("1. Entrar como secretária");
            System.out.println("2. Entrar como médico\n");
            System.out.print("> ");
            opt = scan.nextInt();
        } while (opt != 1 && opt != 2);

        Terminal term = (opt == 1) ? new TerminalSecretaria(): new TerminalMedico();

        do {
            term.listarOperacoes();
            opt = scan.nextInt();
            term.mapear(opt);
        } while (opt != 0);

        scan.close();

    }
}
