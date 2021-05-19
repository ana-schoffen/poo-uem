package com.uem.clinica;
import com.uem.clinica.terminal.Terminal;
import com.uem.clinica.terminal.TerminalMedico;
import com.uem.clinica.terminal.TerminalSecretaria;
import com.uem.clinica.view.MainInterface;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {
        MainInterface screen = new MainInterface();
        screen.setVisible(true);
       
    }
}
