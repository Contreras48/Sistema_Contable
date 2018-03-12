/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import Reportes.GenerarReporte;

/**
 *
 * @author mateo
 */
public class VentanaPrincipal extends javax.swing.JFrame {
    GenerarReporte reporte;
    /**
     * Creates new form VentanaPrincipal
     */
    public VentanaPrincipal() {
        initComponents();
        setLocationRelativeTo(null);
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
        btnAsientos = new javax.swing.JButton();
        btnMayor = new javax.swing.JButton();
        btnAjustes = new javax.swing.JButton();
        btnEstados = new javax.swing.JButton();
        btnCatalogo = new javax.swing.JButton();
        btnDiario = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(0, 0));
        setName("frame1"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 30)); // NOI18N
        jLabel1.setText("Sistema Contable ");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, -1, -1));

        btnAsientos.setText("Realizar asientos");
        btnAsientos.setFocusable(false);
        btnAsientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsientosActionPerformed(evt);
            }
        });
        getContentPane().add(btnAsientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 177, -1));

        btnMayor.setText("Libro Mayor");
        btnMayor.setFocusable(false);
        btnMayor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMayorActionPerformed(evt);
            }
        });
        getContentPane().add(btnMayor, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 177, -1));

        btnAjustes.setText("Ajustes");
        btnAjustes.setFocusable(false);
        getContentPane().add(btnAjustes, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 180, 177, -1));

        btnEstados.setText("Estados Financieros");
        btnEstados.setFocusable(false);
        getContentPane().add(btnEstados, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 180, -1, -1));

        btnCatalogo.setText("Catálogo");
        btnCatalogo.setDefaultCapable(false);
        btnCatalogo.setFocusable(false);
        btnCatalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatalogoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCatalogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 177, -1));

        btnDiario.setText("Libro Diario");
        btnDiario.setFocusable(false);
        btnDiario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDiarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnDiario, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 130, 177, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Recursos/fondo_menu.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 310));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCatalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatalogoActionPerformed
        Catalogo catalogo = new Catalogo();
        catalogo.setVisible(true);
        
    }//GEN-LAST:event_btnCatalogoActionPerformed

    private void btnMayorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMayorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMayorActionPerformed

    private void btnAsientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsientosActionPerformed
        Diario diario = new Diario();
        diario.setVisible(true);
        
    }//GEN-LAST:event_btnAsientosActionPerformed

    private void btnDiarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDiarioActionPerformed
        reporte = new GenerarReporte();
        reporte.reporteLibroDiario();
    }//GEN-LAST:event_btnDiarioActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAjustes;
    private javax.swing.JButton btnAsientos;
    private javax.swing.JButton btnCatalogo;
    private javax.swing.JButton btnDiario;
    private javax.swing.JButton btnEstados;
    private javax.swing.JButton btnMayor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
