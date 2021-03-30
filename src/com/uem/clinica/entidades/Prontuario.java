package com.uem.clinica.entidades;

import java.util.ArrayList;
import java.util.HashMap;

public class Prontuario {
    private ArrayList<String> sintomas;
    private String diagnostico;
    private HashMap<String, String> prescricao;

    public Prontuario(ArrayList<String> sintomas, String diagnostico, HashMap<String, String> prescricao) {
        this.sintomas = sintomas;
        this.diagnostico = diagnostico;
        this.prescricao = prescricao;
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
