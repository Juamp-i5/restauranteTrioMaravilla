package pantallas;

import BOs.IngredienteBO;
import DTOs.entrada.IngredienteNuevoDTO;
import DTOs.salida.UnidadMedidaDTO;
import control.ControlNavegacion;
import entidades.enums.UnidadMedida;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteBO;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author norma
 */
public class PantallaRegistrarNuevoIngrediente extends javax.swing.JFrame {

    IIngredienteBO ingredienteBO = new IngredienteBO();
    IngredienteNuevoDTO ingredienteNuevo;

    public PantallaRegistrarNuevoIngrediente() {
        initComponents();
        cargarUnidadesDeMedida();
        listenerVerificarCampos();

    }

    private void cargarUnidadesDeMedida() {
        List<UnidadMedidaDTO> unidades = ingredienteBO.obtenerUnidadesMedida();
        comboBoxUnidadMedida.removeAllItems();

        for (UnidadMedidaDTO unidad : unidades) {
            comboBoxUnidadMedida.addItem(unidad.getNombre());
        }
    }

    private void registrarInformacionIngrediente() {
        String nombreIngrediente = txtNombreIngrediente.getText();
        String cantidadStock = jTextField2.getText();
        String unidadMedidaStr = (String) comboBoxUnidadMedida.getSelectedItem();

        UnidadMedida unidadMedida = UnidadMedida.valueOf(unidadMedidaStr.toUpperCase());

        ingredienteNuevo = new IngredienteNuevoDTO();
        ingredienteNuevo.setNombre(nombreIngrediente);
        ingredienteNuevo.setUnidadMedida(unidadMedida);
        ingredienteNuevo.setCantidadStock(Integer.parseInt(cantidadStock));

        registrarNuevoIngrediente();
    }

    public void registrarNuevoIngrediente() {
        try {
            ingredienteBO.registrarNuevoIngrediente(ingredienteNuevo);
            JOptionPane.showMessageDialog(this, "Ingrediente registrado exitosamente.");
        } catch (NegocioException | PersistenciaException e) {
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listenerVerificarCampos() {
        txtNombreIngrediente.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarCampos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarCampos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarCampos();
            }
        });

        jTextField2.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                verificarCampos();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                verificarCampos();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                verificarCampos();
            }
        });

        comboBoxUnidadMedida.addActionListener(e -> verificarCampos());
    }

    private void verificarCampos() {
        String nombreIngrediente = txtNombreIngrediente.getText().trim();
        String cantidadStock = jTextField2.getText().trim();
        String unidadMedidaStr = (String) comboBoxUnidadMedida.getSelectedItem();

        if (!nombreIngrediente.isEmpty() && !cantidadStock.isEmpty() && !unidadMedidaStr.isEmpty()) {
            btnGuardarIngrediente.setEnabled(true);
        } else {
            btnGuardarIngrediente.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        lblTitulo = new javax.swing.JLabel();
        sepArriba = new javax.swing.JSeparator();
        sepAbajo = new javax.swing.JSeparator();
        javax.swing.JButton btnVolverAtras = new javax.swing.JButton();
        lblNombreIngrediente = new javax.swing.JLabel();
        txtNombreIngrediente = new javax.swing.JTextField();
        lblUnidadMedida = new javax.swing.JLabel();
        comboBoxUnidadMedida = new javax.swing.JComboBox<>();
        lblCantidadDeStock = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        btnGuardarIngrediente = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Registrar nuevo ingrediente");
        lblTitulo.setToolTipText("");

        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolverAtras.setText("<---");
        btnVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasActionPerformed(evt);
            }
        });

        lblNombreIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblNombreIngrediente.setText("Nombre ingrediente");

        txtNombreIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        lblUnidadMedida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblUnidadMedida.setText("Unidad de medida");

        comboBoxUnidadMedida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboBoxUnidadMedida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblCantidadDeStock.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lblCantidadDeStock.setText("Cantidad de stock");

        jTextField2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        btnGuardarIngrediente.setBackground(new java.awt.Color(0, 131, 125));
        btnGuardarIngrediente.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnGuardarIngrediente.setText("Guardar ingrediente");
        btnGuardarIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarIngredienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(304, 304, 304)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblNombreIngrediente)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblUnidadMedida)
                        .addComponent(txtNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboBoxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblCantidadDeStock, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(328, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardarIngrediente)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTitulo))
                    .addContainerGap(320, Short.MAX_VALUE))
                .addComponent(sepArriba)
                .addComponent(sepAbajo))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(lblNombreIngrediente)
                .addGap(18, 18, 18)
                .addComponent(txtNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(lblUnidadMedida)
                .addGap(18, 18, 18)
                .addComponent(comboBoxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(lblCantidadDeStock)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(123, 123, 123)
                .addComponent(btnGuardarIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(lblTitulo)
                    .addGap(5, 5, 5)
                    .addComponent(sepArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(460, 460, 460)
                    .addComponent(sepAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        ControlNavegacion.mostrarPantallaMenuIngrediente();
        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed

    private void btnGuardarIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarIngredienteActionPerformed
        registrarInformacionIngrediente();
        ControlNavegacion.mostrarPantallaMenuIngrediente();
        this.dispose();
    }//GEN-LAST:event_btnGuardarIngredienteActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardarIngrediente;
    private javax.swing.JComboBox<String> comboBoxUnidadMedida;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblCantidadDeStock;
    private javax.swing.JLabel lblNombreIngrediente;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblUnidadMedida;
    private javax.swing.JSeparator sepAbajo;
    private javax.swing.JSeparator sepArriba;
    private javax.swing.JTextField txtNombreIngrediente;
    // End of variables declaration//GEN-END:variables
}
