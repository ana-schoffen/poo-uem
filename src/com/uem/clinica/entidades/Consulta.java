package com.uem.clinica.entidades;

import com.uem.clinica.util.TipoConsulta;

import java.util.Calendar;

public class Consulta {
    private Calendar data;
    private Medico medico;
    private Paciente paciente;
    private Prontuario prontuario;
    private TipoConsulta tipo;

    public Consulta(){

    }

    public Consulta(Calendar data, Medico medico, Paciente paciente, TipoConsulta tipo) {
        this.data = data;
        this.medico = medico;
        this.paciente = paciente;
        this.tipo = tipo;
    }

    public Prontuario getProntuario() {
        return prontuario;
    }

    public void setProntuario(Prontuario prontuario) {
        this.prontuario = prontuario;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
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
