package pantallas;

import control.ControlNavegacion;
import control.ModoMenu;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class PantallaMenuOpciones extends javax.swing.JFrame {

    private final int PADDINGBOTONESVERTICAL = 10;
    private final int PADDINGBOTONESHORIZONTAL = 10;
    private final JButton BTN_LEVANTAR_COMANDA = new PlantillaBotonMenuOpciones("Levantar comanda", "#afd06d");
    private final JButton BTN_COMANDAS_POR_REALIZAR = new PlantillaBotonMenuOpciones("Comandas por realizar", "#7bbf70");
    private final JButton BTN_REGISTRAR_CLIENTE = new PlantillaBotonMenuOpciones("Registrar cliente", "#46ac76");
    private final JButton BTN_PRODUCTOS = new PlantillaBotonMenuOpciones("Productos", "#00987b");
    private final JButton BTN_INGREDIENTES = new PlantillaBotonMenuOpciones("Ingredientes", "#00837d");

    public PantallaMenuOpciones() {
        initComponents();
        iniciarPanel();
    }

    private void iniciarPanel() {
        pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER, PADDINGBOTONESHORIZONTAL, PADDINGBOTONESVERTICAL));

        pnlBotones.add(BTN_LEVANTAR_COMANDA);
        pnlBotones.add(BTN_COMANDAS_POR_REALIZAR);
        if (ControlNavegacion.getModoMenu() == ModoMenu.ADMINISTRADOR) {
            pnlBotones.add(BTN_REGISTRAR_CLIENTE);
            pnlBotones.add(BTN_PRODUCTOS);
            pnlBotones.add(BTN_INGREDIENTES);
        }

        BTN_LEVANTAR_COMANDA.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnLevantarComandaActionPerformed(evt);
        });

        BTN_COMANDAS_POR_REALIZAR.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnComandasPorRealizarActionPerformed(evt);
        });

        BTN_REGISTRAR_CLIENTE.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnRegistrarClienteActionPerformed(evt);
        });

        BTN_PRODUCTOS.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnProductosActionPerformed(evt);
        });

        BTN_INGREDIENTES.addActionListener((java.awt.event.ActionEvent evt) -> {
            btnIngredientesActionPerformed(evt);
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sepArriba = new javax.swing.JSeparator();
        sepAbajo = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        lblSubtitulo = new javax.swing.JLabel();
        pnlBotones = new javax.swing.JPanel();
        btnLogOut = new javax.swing.JButton();
        btnReportes = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Menú de opciones");

        lblSubtitulo.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lblSubtitulo.setText("¿Qué deseas hacer?");

        javax.swing.GroupLayout pnlBotonesLayout = new javax.swing.GroupLayout(pnlBotones);
        pnlBotones.setLayout(pnlBotonesLayout);
        pnlBotonesLayout.setHorizontalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );
        pnlBotonesLayout.setVerticalGroup(
            pnlBotonesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );

        btnLogOut.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnLogOut.setText("Log out");
        btnLogOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogOutActionPerformed(evt);
            }
        });

        btnReportes.setBackground(new java.awt.Color(0, 131, 125));
        btnReportes.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReportes.setText("Reportes");
        btnReportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReportesActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setText("Insertar mesas");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepArriba)
            .addComponent(sepAbajo, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblSubtitulo)
                            .addComponent(btnLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnReportes, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitulo)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblSubtitulo)
                .addGap(18, 18, 18)
                .addComponent(pnlBotones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(sepAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnReportes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLogOut, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReportesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReportesActionPerformed

    private void btnLogOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogOutActionPerformed
        ControlNavegacion.mostrarPantallaInicioSesion();

        this.dispose();
    }//GEN-LAST:event_btnLogOutActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLevantarComandaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnComandasPorRealizarActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnRegistrarClienteActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btnIngredientesActionPerformed(java.awt.event.ActionEvent evt) {

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogOut;
    private javax.swing.JButton btnReportes;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblSubtitulo;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlBotones;
    private javax.swing.JSeparator sepAbajo;
    private javax.swing.JSeparator sepArriba;
    // End of variables declaration//GEN-END:variables
}
