package com.uem.clinica.entidades;

import com.uem.clinica.util.TipoConsulta;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    private LocalDateTime dataConsulta;
    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Paciente paciente;
    @OneToOne(cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Prontuario prontuario;
    private TipoConsulta tipo;

    public Consulta(){
    }

    public Consulta(LocalDateTime data, Paciente paciente, TipoConsulta tipo) {
        this.dataConsulta = data;
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

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
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
                             dataConsulta.format(DateTimeFormatter.ofPattern("kk:mm - dd/MM/yyyy")),
                             paciente.getId(),
                             tipo.toString());
    }
}
