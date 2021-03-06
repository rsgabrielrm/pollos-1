/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholab1;

import Banco.Conector;
import Banco.PessoasDB;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import models.Funcionarios;

/**
 *
 * @author Patrick
 */
public class listaFuncionarios extends javax.swing.JFrame {

    /**
     * Creates new form listaFuncionarios
     */
    public listaFuncionarios() {
        initComponents();
        // Para fechar a janela e não o sistema
        setDefaultCloseOperation( DISPOSE_ON_CLOSE ); 
        populatabela();
    }
    public void populatabela(){
        Conector db = new Conector();
        PessoasDB pesso = new PessoasDB(db);
        ArrayList<Funcionarios> lista = pesso.listafuncionariosgeral();
        //Aqui começamos a montar um modelo padrão de tabela
        DefaultTableModel modelo = new DefaultTableModel();
        //Adicionamos as colunas da nossa tabela
        modelo.addColumn("Código");
        modelo.addColumn("Nome");
        modelo.addColumn("CPF");
        modelo.addColumn("Telefone");
        modelo.addColumn("E-mail");
        //Setamos quantas linhas vamos ter conforme o tamnho de nosso Array
        modelo.setRowCount(lista.size());
        // contador para coluna
        int cont = 0;
        if(lista != null){
            for(Funcionarios obj: lista){
                //Aqui começamos a setar os valores onde o parametro 1 (dado), parametro 2(linha), parametro 3(coluna)
                modelo.setValueAt(obj.getId(),cont,0);
                modelo.setValueAt(obj.getNome(),cont,1);
                modelo.setValueAt(obj.getCpf(),cont,2);
                modelo.setValueAt(obj.getTelefone(),cont,3);
                modelo.setValueAt(obj.getEmail() ,cont,4);
                // Acumulamos +1 no nosso contador para colocar os dados em nova linha
                cont++;
            }
            // Setamos o novo modelo de tabela na nossa tabela que chamamos de jTablePedidos
            jTableFuncionarios.setModel(modelo);
        }
//       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButtonAtualizaFuncionario = new javax.swing.JButton();
        jButtonExcluirFuncionario = new javax.swing.JButton();
        jButtonCadastraNovoFuncionario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Lista Funcionários");

        jButtonAtualizaFuncionario.setText("Atualizar funcionário");
        jButtonAtualizaFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaFuncionarioActionPerformed(evt);
            }
        });

        jButtonExcluirFuncionario.setText("Excluir funcionário");
        jButtonExcluirFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExcluirFuncionarioActionPerformed(evt);
            }
        });

        jButtonCadastraNovoFuncionario.setText("Cadastrar novo funcionário");
        jButtonCadastraNovoFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastraNovoFuncionarioActionPerformed(evt);
            }
        });

        jTableFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTableFuncionarios);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonCadastraNovoFuncionario)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtualizaFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonExcluirFuncionario)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAtualizaFuncionario)
                    .addComponent(jButtonExcluirFuncionario)
                    .addComponent(jButtonCadastraNovoFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAtualizaFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaFuncionarioActionPerformed
        // TODO add your handling code here:
        if (jTableFuncionarios.getSelectedRow() != -1) {
            Funcionarios p = new Funcionarios();
            p.setId((int) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 0));
            int idFun = (int) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 0);
            //Chamamos nosso jframe e atribuimos a form

//            editaPessoas form = new editaPessoas(idFun);

            editaPessoas form = new editaPessoas(idFun);
            //Aqui setamos para abrir no centro quando aberto
            form.setLocationRelativeTo(null);
            //Deixamos o jframe visivel
            form.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário para atualizar.");
        }
    }//GEN-LAST:event_jButtonAtualizaFuncionarioActionPerformed

    private void jButtonExcluirFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExcluirFuncionarioActionPerformed
        if (jTableFuncionarios.getSelectedRow() != -1) {
            Conector db = new Conector();
            PessoasDB funcionario = new PessoasDB(db);
            Funcionarios fun = new Funcionarios();
            fun.setId((int) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 0));
            int idFun = (int) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 0);
            String nome = (String) jTableFuncionarios.getValueAt(jTableFuncionarios.getSelectedRow(), 1);
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja excluir o funcionário "+nome+"?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                String retorno = funcionario.deletePessoa(idFun);
                JOptionPane.showMessageDialog(null, retorno);
                populatabela();
            }

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Funcionário para excluir.");
        }
    }//GEN-LAST:event_jButtonExcluirFuncionarioActionPerformed

    private void jButtonCadastraNovoFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastraNovoFuncionarioActionPerformed
        // TODO add your handling code here:
        //Chamamos nosso jframe e atribuimos a form
        cadastraPessoa form = new cadastraPessoa();
        //Aqui setamos para abrir no centro quando aberto
        form.setLocationRelativeTo(null);
        //Deixamos o jframe visivel
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonCadastraNovoFuncionarioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(listaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaFuncionarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaFuncionarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAtualizaFuncionario;
    private javax.swing.JButton jButtonCadastraNovoFuncionario;
    private javax.swing.JButton jButtonExcluirFuncionario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableFuncionarios;
    // End of variables declaration//GEN-END:variables
}
