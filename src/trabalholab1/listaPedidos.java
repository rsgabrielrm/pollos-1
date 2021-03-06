/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalholab1;


import Banco.Conector;
import Banco.PedidosDB;
import java.text.DecimalFormat;
import java.util.ArrayList;
import models.Pedidos;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author gabrielrm
 */
public class listaPedidos extends javax.swing.JFrame {

    /**
     * Creates new form listaPedidos
     */
    public listaPedidos() {
        initComponents();
        // Para fechar a janela e não o sistema
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        // Chamamos o método para popular nossa tabela
        populatabela();
    }
    
    public void populatabela(){
        Conector db = new Conector();
        //Chamamos a classe Pedidos e atribuimos o valor pedidos
        PedidosDB ped = new PedidosDB(db);
        ArrayList<Pedidos> lista = ped.buscapedidos();
        
        //Aqui começamos a montar um modelo padrão de tabela
        DefaultTableModel modelo = new DefaultTableModel();
        //Adicionamos as colunas da nossa tabela
        modelo.addColumn("Número");
        modelo.addColumn("Nome Cliente");
        modelo.addColumn("Cód. Produto");
        modelo.addColumn("Quantidade");
        modelo.addColumn("Status do Pedido");
        modelo.addColumn("Valor");
        //Setamos quantas linhas vamos ter conforme o tamnho de nosso Array
        modelo.setRowCount(lista.size());
        // contador para coluna
        int cont = 0;
        // damos um "forEach" onde para cada possição do nosso array e a cada volta atribuimos a obj
        if(lista != null){
        for(Pedidos obj : lista){
            DecimalFormat decimal = new DecimalFormat( "0.##" );
            //Aqui começamos a setar os valores onde o parametro 1 (dado), parametro 2(linha), parametro 3(coluna)
            String valor = decimal.format(obj.getValor());
            ///
            modelo.setValueAt(obj.getId(),cont,0);
            modelo.setValueAt(obj.getNome(),cont,1);
            modelo.setValueAt(obj.getCodProduto(),cont,2);
            modelo.setValueAt(obj.getQuantidade(),cont,3);
            modelo.setValueAt(obj.getStatus(),cont,4);
            modelo.setValueAt(valor,cont,5);
            // Acumulamos +1 no nosso contador para colocar os dados em nova linha
            cont++;
        }
        // Setamos o novo modelo de tabela na nossa tabela que chamamos de jTablePedidos
        jTablePedidos.setModel(modelo);
//        System.out.println("linhaaa "+jTablePedidos.getSelectedRow());
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

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jButtonAtualizaPedido = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pedidos");

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jTablePedidos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTablePedidosMouseClicked(evt);
            }
        });
        jTablePedidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTablePedidosKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTablePedidos);

        jButtonAtualizaPedido.setText("Atualizar pedido");
        jButtonAtualizaPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAtualizaPedidoActionPerformed(evt);
            }
        });

        jButton1.setText("Novo pedido");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Excluir pedido");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonAtualizaPedido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 705, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2)
                        .addComponent(jButtonAtualizaPedido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTablePedidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTablePedidosKeyReleased
//        // TODO add your handling code here:
//         if (jTablePedidos.getSelectedRow() != -1) {
//            System.out.println("Nome : "+jTablePedidos.getSelectedRow());
//         }
    }//GEN-LAST:event_jTablePedidosKeyReleased

    private void jTablePedidosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTablePedidosMouseClicked
        // TODO add your handling code here:
        if (jTablePedidos.getSelectedRow() != -1) {
            System.out.println("Nome : "+jTablePedidos.getSelectedRow());
         }
    }//GEN-LAST:event_jTablePedidosMouseClicked

    private void jButtonAtualizaPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAtualizaPedidoActionPerformed
        // TODO add your handling code here:
        if (jTablePedidos.getSelectedRow() != -1) {
            Pedidos p = new Pedidos();
            p.setId((int) jTablePedidos.getValueAt(jTablePedidos.getSelectedRow(), 0));
            int idPed = (int) jTablePedidos.getValueAt(jTablePedidos.getSelectedRow(), 0);
            //Chamamos nosso jframe e atribuimos a form
            editaPedido form = new editaPedido(idPed);
            //Aqui setamos para abrir no centro quando aberto
            form.setLocationRelativeTo(null);
            //Deixamos o jframe visivel
            form.setVisible(true);
            dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pedido para atualizar.");
        }

    }//GEN-LAST:event_jButtonAtualizaPedidoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (jTablePedidos.getSelectedRow() != -1) {
            Conector db = new Conector();
            PedidosDB pedido = new PedidosDB(db);
            Pedidos p = new Pedidos();
            p.setId((int) jTablePedidos.getValueAt(jTablePedidos.getSelectedRow(), 0));
            int idPed = (int) jTablePedidos.getValueAt(jTablePedidos.getSelectedRow(), 0);
            int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog (null, "Deseja excluir o Pedido número "+idPed+"?","Warning",dialogButton);
            if(dialogResult == JOptionPane.YES_OPTION){
                String retorno = pedido.deletePedido(idPed);
                JOptionPane.showMessageDialog(null, retorno);
                populatabela();
            }
            

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um pedido para excluir.");
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //Chamamos nosso jframe e atribuimos a form
        novoPedido form = new novoPedido();
        //Aqui setamos para abrir no centro quando aberto
        form.setLocationRelativeTo(null);
        //Deixamos o jframe visivel
        form.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaPedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new listaPedidos().setVisible(true);
            }
        });
    }
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonAtualizaPedido;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTablePedidos;
    // End of variables declaration//GEN-END:variables
}
