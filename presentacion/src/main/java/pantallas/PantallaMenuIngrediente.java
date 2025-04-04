package pantallas;

import control.ControlNavegacion;
import control.enums.ModoTablaIngredientes;

/**
 *
 * @author norma
 */
public class PantallaMenuIngrediente extends javax.swing.JFrame {

    public PantallaMenuIngrediente() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        sepArriba = new javax.swing.JSeparator();
        btnRegistrarIngrediente = new javax.swing.JButton();
        btnAdministrarProductos = new javax.swing.JButton();
        sepAbajo = new javax.swing.JSeparator();
        javax.swing.JButton btnVolverAtras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Menú ingrediente");

        btnRegistrarIngrediente.setBackground(new java.awt.Color(0, 131, 125));
        btnRegistrarIngrediente.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnRegistrarIngrediente.setText("<html><center>Registrar nuevo ingrediente</center></html>");
        btnRegistrarIngrediente.setToolTipText("");
        btnRegistrarIngrediente.setPreferredSize(new java.awt.Dimension(250, 250));
        btnRegistrarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarIngredienteActionPerformed(evt);
            }
        });

        btnAdministrarProductos.setBackground(new java.awt.Color(0, 131, 125));
        btnAdministrarProductos.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        btnAdministrarProductos.setText("<html><center>Administrar ingredientes</center></html>");
        btnAdministrarProductos.setToolTipText("");
        btnAdministrarProductos.setPreferredSize(new java.awt.Dimension(250, 250));
        btnAdministrarProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdministrarProductosActionPerformed(evt);
            }
        });

        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolverAtras.setText("<---");
        btnVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(btnRegistrarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89)
                        .addComponent(btnAdministrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(103, Short.MAX_VALUE))
            .addComponent(sepAbajo)
            .addComponent(sepArriba)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(5, 5, 5)
                .addComponent(sepArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdministrarProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                .addComponent(sepAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarIngredienteActionPerformed
        ControlNavegacion.mostrarPantallaRegistrarNuevoIngrediente();
        this.dispose();
    }//GEN-LAST:event_btnRegistrarIngredienteActionPerformed

    private void btnAdministrarProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdministrarProductosActionPerformed
        ControlNavegacion.mostrarPantallaTablaIngredientes(ModoTablaIngredientes.INGREDIENTE);
        this.dispose();
    }//GEN-LAST:event_btnAdministrarProductosActionPerformed

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        ControlNavegacion.mostrarPantallaMenuOpciones();

        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdministrarProductos;
    private javax.swing.JButton btnRegistrarIngrediente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JSeparator sepAbajo;
    private javax.swing.JSeparator sepArriba;
    // End of variables declaration//GEN-END:variables
}
