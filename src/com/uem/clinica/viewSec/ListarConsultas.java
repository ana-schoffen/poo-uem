/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uem.clinica.viewSec;
import com.uem.clinica.entidades.Consulta;
import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.entidades.Secretaria;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.persistence.EntityManagerFactory;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class ListarConsultas extends javax.swing.JInternalFrame {
    private Secretaria sec;
    private String[] colunas = {"ID", "Data e Hora", "ID Paciente", "Nome Paciente"};
    private DefaultTableModel tableModel = new DefaultTableModel(colunas, 0);
            

    public ListarConsultas(EntityManagerFactory emf) {
        initComponents();
        jTable1.setPreferredScrollableViewportSize(jTable1.getPreferredScrollableViewportSize());
        
        this.sec = new Secretaria(emf);
        
        ArrayList<Consulta> lista = sec.listarConsultas();
        
        for(Consulta c: lista) {
            Object[] ob = {c.getId(), c.getDataConsulta().format(DateTimeFormatter.ofPattern("kk:mm dd/MM/yyyy")), c.getPaciente().getId(), c.getPaciente().getNome()};
            tableModel.addRow(ob);
        }
    }
    
    public ListarConsultas(EntityManagerFactory emf, LocalDateTime dataInicial) {
        initComponents();
        jTable1.setPreferredScrollableViewportSize(jTable1.getPreferredScrollableViewportSize());
        
        this.sec = new Secretaria(emf);
        
        ArrayList<Consulta> lista = sec.listarConsultas();
        
        for(Consulta c: lista) {
            LocalDateTime limite = LocalDate.now().plusDays(1).atTime(23,59);
            
            if (c.getDataConsulta().isAfter(dataInicial) && c.getDataConsulta().isBefore(limite)) {
                Object[] ob = {c.getId(), c.getDataConsulta().format(DateTimeFormatter.ofPattern("kk:mm dd/MM/yyyy")), c.getPaciente().getId(), c.getPaciente().getNome()};
                tableModel.addRow(ob);
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setClosable(true);
        setResizable(true);
        setTitle("Listar Pacientes");

        jTable1.setModel(tableModel);
        jTable1.setEnabled(false);
        jScrollPane2.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
