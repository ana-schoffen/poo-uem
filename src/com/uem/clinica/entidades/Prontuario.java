package com.uem.clinica.entidades;

import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prontuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private ArrayList<String> sintomas;
    private String diagnostico;
    private HashMap<String, String> prescricao;

    public Prontuario(){
        sintomas = new ArrayList<>();
        prescricao = new HashMap<>();
    }

    public Prontuario(ArrayList<String> sintomas, String diagnostico, HashMap<String, String> prescricao) {
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
        sintomas = new ArrayList<>();
        prescricao = new HashMap<>();
    }

    public ArrayList<String> getSintomas() {
        return sintomas;
    }

    public void setSintomas(ArrayList<String> sintomas) {
        this.sintomas = sintomas;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public HashMap<String, String> getPrescricao() {
        return prescricao;
    }

    public void setPrescricao(HashMap<String, String> prescricao) {
        this.prescricao = prescricao;
    }
}
