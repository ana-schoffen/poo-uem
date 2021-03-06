/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uem.clinica.view;


import com.uem.clinica.entidades.Medico;
import com.uem.clinica.entidades.Paciente;
import com.uem.clinica.entidades.Secretaria;
import java.awt.Component;
import java.awt.event.WindowEvent;
import java.time.LocalDateTime;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;

public class MainInterface extends javax.swing.JFrame {
    /**
     * Creates new form MainPage
     */
    
    private EntityManagerFactory emf;
    
    @SuppressWarnings("unchecked")
    public MainInterface() {
        initComponents();
        try {
            emf = Persistence.createEntityManagerFactory("clinicaPU");
        } catch (PersistenceException e) {
            JOptionPane.showMessageDialog(this, "Banco de dados Java Derby não iniciado", "Falha ao se conectar ao banco da dados", JOptionPane.ERROR_MESSAGE);
            this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
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

        jDesktopPane1 = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        secretarioMenu = new javax.swing.JMenu();
        criarPacienteEscolhaMenu = new javax.swing.JMenuItem();
        listarPacientes = new javax.swing.JMenuItem();
        atualizarPacienteEscolhaMenu = new javax.swing.JMenuItem();
        removerPacienteEscolhaMenu = new javax.swing.JMenuItem();
        criarAgendamentoEscolhaMenu = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        atualizarAgendamentoEscolhaMenu = new javax.swing.JMenuItem();
        relatorioAgendamentoEscolhaMenu = new javax.swing.JMenuItem();
        cancelarAgendamentoEscolhaMenu = new javax.swing.JMenuItem();
        medicoMenu = new javax.swing.JMenu();
        removerDadoAdcicionalEscolhaMenu = new javax.swing.JMenuItem();
        criarRelatorioMedicoEscolhaMenu = new javax.swing.JMenuItem();
        atualizarRelatorioMedicoEscolhaMenu = new javax.swing.JMenuItem();
        removerRelatorioMedicoEscolhaMenu = new javax.swing.JMenuItem();
        criarPronturarioEscolhaMenu = new javax.swing.JMenuItem();
        atualizarProntuarioEscolhaMenu = new javax.swing.JMenuItem();
        removerProntuarioEscolhaMenu = new javax.swing.JMenuItem();
        gerarReceitaEscolhaMenu = new javax.swing.JMenuItem();
        gerarAtestadoEscolhaMenu = new javax.swing.JMenuItem();
        gerarDeclaracao = new javax.swing.JMenuItem();
        numPacientesMesEscolha = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Clínica Médica");

        jDesktopPane1.setBackground(java.awt.SystemColor.desktop);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1083, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 607, Short.MAX_VALUE)
        );

        secretarioMenu.setText("Secretário");

        criarPacienteEscolhaMenu.setText("Criar Paciente");
        criarPacienteEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarPacienteEscolhaMenuActionPerformed(evt);
            }
        });
        secretarioMenu.add(criarPacienteEscolhaMenu);

        listarPacientes.setText("Listar Pacientes");
        listarPacientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listarPacientesActionPerformed(evt);
            }
        });
        secretarioMenu.add(listarPacientes);

        atualizarPacienteEscolhaMenu.setText("Atualizar Paciente");
        atualizarPacienteEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarPacienteEscolhaMenuActionPerformed(evt);
            }
        });
        secretarioMenu.add(atualizarPacienteEscolhaMenu);

        removerPacienteEscolhaMenu.setText("Remover Paciente");
        removerPacienteEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerPacienteEscolhaMenuActionPerformed(evt);
            }
        });
        secretarioMenu.add(removerPacienteEscolhaMenu);

        criarAgendamentoEscolhaMenu.setText("Criar consulta");
        criarAgendamentoEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarAgendamentoEscolhaMenuActionPerformed(evt);
            }
        });
        secretarioMenu.add(criarAgendamentoEscolhaMenu);

        jMenuItem1.setText("Listar consultas");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        secretarioMenu.add(jMenuItem1);

        atualizarAgendamentoEscolhaMenu.setText("Atualizar consulta");
        atualizarAgendamentoEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarAgendamentoEscolhaMenuActionPerformed(evt);
            }
        });
        secretarioMenu.add(atualizarAgendamentoEscolhaMenu);

        relatorioAgendamentoEscolhaMenu.setText("Consultas amanhã");
        relatorioAgendamentoEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relatorioAgendamentoEscolhaMenuActionPerformed(evt);
            }
        });
        secretarioMenu.add(relatorioAgendamentoEscolhaMenu);

        cancelarAgendamentoEscolhaMenu.setText("Cancelar consulta");
        cancelarAgendamentoEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarAgendamentoEscolhaMenuActionPerformed(evt);
            }
        });
        secretarioMenu.add(cancelarAgendamentoEscolhaMenu);

        jMenuBar1.add(secretarioMenu);

        medicoMenu.setText("Médico");

        removerDadoAdcicionalEscolhaMenu.setText("Listar Pacientes");
        removerDadoAdcicionalEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerDadoAdcicionalEscolhaMenuActionPerformed(evt);
            }
        });
        medicoMenu.add(removerDadoAdcicionalEscolhaMenu);

        criarRelatorioMedicoEscolhaMenu.setText("Adicionar detalhe paciente");
        criarRelatorioMedicoEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarRelatorioMedicoEscolhaMenuActionPerformed(evt);
            }
        });
        medicoMenu.add(criarRelatorioMedicoEscolhaMenu);

        atualizarRelatorioMedicoEscolhaMenu.setText("Atualizar detalhes paciente");
        atualizarRelatorioMedicoEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarRelatorioMedicoEscolhaMenuActionPerformed(evt);
            }
        });
        medicoMenu.add(atualizarRelatorioMedicoEscolhaMenu);

        removerRelatorioMedicoEscolhaMenu.setText("Remover detalhes paciente");
        removerRelatorioMedicoEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerRelatorioMedicoEscolhaMenuActionPerformed(evt);
            }
        });
        medicoMenu.add(removerRelatorioMedicoEscolhaMenu);

        criarPronturarioEscolhaMenu.setText("Criar Prontuário");
        criarPronturarioEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarPronturarioEscolhaMenuActionPerformed(evt);
            }
        });
        medicoMenu.add(criarPronturarioEscolhaMenu);

        atualizarProntuarioEscolhaMenu.setText("Atualizar Prontuario");
        atualizarProntuarioEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atualizarProntuarioEscolhaMenuActionPerformed(evt);
            }
        });
        medicoMenu.add(atualizarProntuarioEscolhaMenu);

        removerProntuarioEscolhaMenu.setText("Remover Prontuário");
        removerProntuarioEscolhaMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removerProntuarioEscolhaMenuActionPerformed(evt);
            }
        });
        medicoMenu.add(removerProntuarioEscolhaMenu);

        gerarReceitaEscolhaMenu.setText("Gerar Receita");
        medicoMenu.add(gerarReceitaEscolhaMenu);

        gerarAtestadoEscolhaMenu.setText("Gerar Atestado");
        medicoMenu.add(gerarAtestadoEscolhaMenu);

        gerarDeclaracao.setText("Gerar declaração");
        medicoMenu.add(gerarDeclaracao);

        numPacientesMesEscolha.setText("N° pacientes atendidos no mês");
        medicoMenu.add(numPacientesMesEscolha);

        jMenuBar1.add(medicoMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void criarPacienteEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarPacienteEscolhaMenuActionPerformed
        // Criar Paciente
        CriarPacienteView pg = new CriarPacienteView(emf);
        jDesktopPane1.add(pg);
        pg.setVisible(true);
    }//GEN-LAST:event_criarPacienteEscolhaMenuActionPerformed

    private void atualizarPacienteEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarPacienteEscolhaMenuActionPerformed
        // Atualizar Paciente pelo nome:
        String input = JOptionPane.showInputDialog("Digite o id do usuário:");
        
        CriarPacienteView pg = new CriarPacienteView(emf, Integer.parseInt(input));
        
        jDesktopPane1.add(pg);
        pg.setVisible(true);
    }//GEN-LAST:event_atualizarPacienteEscolhaMenuActionPerformed

    private void removerPacienteEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerPacienteEscolhaMenuActionPerformed
        // Remover Paciente pelo e-mail:
        String input = JOptionPane.showInputDialog("Digite o id do usuário"); 
        
        Secretaria sec = new Secretaria(emf);
        
        sec.removerPaciente(Integer.parseInt(input));
        
        JOptionPane.showMessageDialog(null, "Paciente " + input + " removido");

    }//GEN-LAST:event_removerPacienteEscolhaMenuActionPerformed

    private void criarAgendamentoEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarAgendamentoEscolhaMenuActionPerformed
        // criar atendimento
        CriarConsultaView c = new CriarConsultaView(emf);
        jDesktopPane1.add(c);
        c.setVisible(true);
    }//GEN-LAST:event_criarAgendamentoEscolhaMenuActionPerformed

    private void atualizarAgendamentoEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarAgendamentoEscolhaMenuActionPerformed
        // atualizar atendimento
        String input = JOptionPane.showInputDialog("Digite o id da consulta:");
        
        CriarConsultaView pg = new CriarConsultaView(emf, Integer.parseInt(input));
        
        jDesktopPane1.add(pg);
        pg.setVisible(true);

    }//GEN-LAST:event_atualizarAgendamentoEscolhaMenuActionPerformed

    private void removerDadoAdcicionalEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerDadoAdcicionalEscolhaMenuActionPerformed
        // remover dado adicional

        
    }//GEN-LAST:event_removerDadoAdcicionalEscolhaMenuActionPerformed

    private void criarRelatorioMedicoEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarRelatorioMedicoEscolhaMenuActionPerformed
        // relatório médico

    }//GEN-LAST:event_criarRelatorioMedicoEscolhaMenuActionPerformed

    private void atualizarRelatorioMedicoEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarRelatorioMedicoEscolhaMenuActionPerformed
        // atualizar relatório médico

    }//GEN-LAST:event_atualizarRelatorioMedicoEscolhaMenuActionPerformed

    private void removerRelatorioMedicoEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerRelatorioMedicoEscolhaMenuActionPerformed
        // remover relatório médico

    }//GEN-LAST:event_removerRelatorioMedicoEscolhaMenuActionPerformed

    private void atualizarProntuarioEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atualizarProntuarioEscolhaMenuActionPerformed
        //atualizar prontuári

    }//GEN-LAST:event_atualizarProntuarioEscolhaMenuActionPerformed

    private void criarPronturarioEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_criarPronturarioEscolhaMenuActionPerformed
        // criar prontuário

    }//GEN-LAST:event_criarPronturarioEscolhaMenuActionPerformed

    private void removerProntuarioEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removerProntuarioEscolhaMenuActionPerformed
        // remover prontuário

    }//GEN-LAST:event_removerProntuarioEscolhaMenuActionPerformed

    private void listarPacientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listarPacientesActionPerformed
        // TODO add your handling code here:
        ListarPacientes lp = new ListarPacientes(emf);
        jDesktopPane1.add(lp);
        lp.setVisible(true);
    }//GEN-LAST:event_listarPacientesActionPerformed

    private void cancelarAgendamentoEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarAgendamentoEscolhaMenuActionPerformed
        // TODO add your handling code here:
        String input = JOptionPane.showInputDialog("Digite o id da consulta"); 
        
        Secretaria sec = new Secretaria(emf);
        
        sec.removerConsulta(Integer.parseInt(input));
        
        JOptionPane.showMessageDialog(null, "Consulta " + input + " removido");
    }//GEN-LAST:event_cancelarAgendamentoEscolhaMenuActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        ListarConsultas lc = new ListarConsultas(emf);
        jDesktopPane1.add(lc);
        lc.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void relatorioAgendamentoEscolhaMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relatorioAgendamentoEscolhaMenuActionPerformed
        // TODO add your handling code here:
        ListarConsultas lc = new ListarConsultas(emf, LocalDateTime.now());
        jDesktopPane1.add(lc);
        lc.setVisible(true);
    }//GEN-LAST:event_relatorioAgendamentoEscolhaMenuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem atualizarAgendamentoEscolhaMenu;
    private javax.swing.JMenuItem atualizarPacienteEscolhaMenu;
    private javax.swing.JMenuItem atualizarProntuarioEscolhaMenu;
    private javax.swing.JMenuItem atualizarRelatorioMedicoEscolhaMenu;
    private javax.swing.JMenuItem cancelarAgendamentoEscolhaMenu;
    private javax.swing.JMenuItem criarAgendamentoEscolhaMenu;
    private javax.swing.JMenuItem criarPacienteEscolhaMenu;
    private javax.swing.JMenuItem criarPronturarioEscolhaMenu;
    private javax.swing.JMenuItem criarRelatorioMedicoEscolhaMenu;
    private javax.swing.JMenuItem gerarAtestadoEscolhaMenu;
    private javax.swing.JMenuItem gerarDeclaracao;
    private javax.swing.JMenuItem gerarReceitaEscolhaMenu;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem listarPacientes;
    private javax.swing.JMenu medicoMenu;
    private javax.swing.JMenuItem numPacientesMesEscolha;
    private javax.swing.JMenuItem relatorioAgendamentoEscolhaMenu;
    private javax.swing.JMenuItem removerDadoAdcicionalEscolhaMenu;
    private javax.swing.JMenuItem removerPacienteEscolhaMenu;
    private javax.swing.JMenuItem removerProntuarioEscolhaMenu;
    private javax.swing.JMenuItem removerRelatorioMedicoEscolhaMenu;
    private javax.swing.JMenu secretarioMenu;
    // End of variables declaration//GEN-END:variables
}
