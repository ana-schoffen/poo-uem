package com.uem.clinica.entidades;

import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Consulta {
    private int id;
    private LocalDateTime data;
    private Paciente paciente;
    private Prontuario prontuario;
    private TipoConsulta tipo;

    public Consulta(){

    }

    public Consulta(LocalDateTime data, Paciente paciente, TipoConsulta tipo) {
        this.data = data;
        this.paciente = paciente;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public TipoConsulta getTipo() {
        return tipo;
    }

    public void setTipo(TipoConsulta tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return String.format("%d|%s|%d|%s",
                             id,
                             data.format(DateTimeFormatter.ofPattern("kk:mm - dd/MM/yyyy")),
                             paciente.getId(),
                             tipo.toString());
    }
}
