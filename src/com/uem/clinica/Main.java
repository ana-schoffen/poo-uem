package com.uem.clinica;
import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.entidades.Secretaria;
import com.uem.clinica.util.Convenio;
import com.uem.clinica.util.Endereco;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        Endereco aux = new Endereco("Av. Paulista", 40, "Apt 100", "Centro", "São Paulo", "SP", 20000000);

        Secretaria sec1 = new Secretaria("Maria", LocalDate.of(2000, 8, 11) , aux, "(44)99722-0011", "example@example.com");
        Paciente pac1 = sec1.criarPaciente("João", LocalDate.of(2000, 8, 11), aux, "(44) 99511-0000", Convenio.Particular);

        System.out.println(sec1.getNome());

    }
}
