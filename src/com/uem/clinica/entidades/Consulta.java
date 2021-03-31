package com.uem.clinica.entidades;

import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDateTime;

public class Consulta {
    private int id;
    private LocalDateTime data;
    private Medico medico;
    private Paciente paciente;
    private Prontuario prontuario;
    private TipoConsulta tipo;

    public Consulta(){

    }

    public Consulta(LocalDateTime data, Medico medico, Paciente paciente, TipoConsulta tipo) {
        this.data = data;
        this.medico = medico;
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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
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
}
