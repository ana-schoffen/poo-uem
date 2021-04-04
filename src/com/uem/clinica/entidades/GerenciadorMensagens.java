package com.uem.clinica.entidades;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;

public class GerenciadorMensagens {

    public GerenciadorMensagens() {
    }

    public void enviarEmail(ArrayList<Consulta> consultas){

        HashSet<Paciente> pacientes = new HashSet<>();
        LocalDateTime limite = LocalDate.now().plusDays(1).atTime(23, 59);

        for(Consulta c : consultas) {
            if (c.getData().isBefore(limite) && c.getData().isAfter(LocalDateTime.now())) {
                if (c.getPaciente().getEmail() != null) {
                    pacientes.add(c.getPaciente());
                }
            }
        }
        //usar pacientes para enviar as mensagens

    }
    public void enviarSMS(ArrayList<Consulta> consultas){

        HashSet<Paciente> pacientes = new HashSet<>();
        LocalDateTime limite = LocalDate.now().plusDays(1).atTime(23, 59);

        for(Consulta c : consultas) {
            if (c.getData().isBefore(limite) && c.getData().isAfter(LocalDateTime.now())) {
                if (c.getPaciente().getCelular() != null) {
                    pacientes.add(c.getPaciente());
                }
            }
        }

        //usar pacientes para enviar as mensagens
    }
}
