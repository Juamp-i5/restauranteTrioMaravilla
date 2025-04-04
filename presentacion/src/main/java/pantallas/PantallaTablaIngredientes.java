package pantallas;

import BOs.IngredienteBO;
import DTOs.salida.IngredienteViejoDTO;
import control.ControlNavegacion;
import control.enums.ModoTablaIngredientes;
import enums.UnidadMedida;
import excepciones.NegocioException;
import excepciones.PersistenciaException;
import interfaces.IIngredienteBO;
import java.util.List;
import java.util.Optional;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author norma
 */
public class PantallaTablaIngredientes extends javax.swing.JFrame {

    IIngredienteBO ingredienteBO = new IngredienteBO();
    List<IngredienteViejoDTO> ingredientes;

    ModoTablaIngredientes modo;
    DefaultTableModel modelo;
    private Timer timer;
    private static final int TIPO_DEBOUNCE = 50;

    public PantallaTablaIngredientes(List<IngredienteViejoDTO> ingredientes, ModoTablaIngredientes modo) {
        initComponents();
        tablaIngredientes.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && tablaIngredientes.getSelectedRow() != -1) {
                int filaSeleccionada = tablaIngredientes.getSelectedRow();
                String nombreIngrediente = (String) tablaIngredientes.getValueAt(filaSeleccionada, 1);
                lblNombreProducto.setText(nombreIngrediente);
                btnAumentar.setEnabled(true);
                btnReducir.setEnabled(true);
                btnEliminar.setEnabled(true);
                btnSeleccionar.setEnabled(true);
            }
        });

        if (modo == ModoTablaIngredientes.INGREDIENTE) {
            btnSeleccionar.setVisible(false);
            btnAumentar.setEnabled(false);
            btnReducir.setEnabled(false);
            btnEliminar.setEnabled(false);
        } else {
            btnSeleccionar.setEnabled(false);
            btnAumentar.setVisible(false);
            btnReducir.setVisible(false);
            btnEliminar.setVisible(false);
            lblIngredienteSeleccionado.setVisible(false);
            lblNombre.setVisible(false);
            lblNombreProducto.setVisible(false);
            lblStock.setVisible(false);
        }

        this.modo = modo;

        comboBoxUnidadMedida.removeAllItems();
        for (UnidadMedida tipo : UnidadMedida.values()) {
            comboBoxUnidadMedida.addItem(tipo.toString());
        }

        cargarIngredientesTabla();

    }

    private void cargarIngredientesTabla() {
        actualizarIngredientesFiltrados();

        modelo = (DefaultTableModel) tablaIngredientes.getModel();
        modelo.setRowCount(0);

        for (IngredienteViejoDTO ingrediente : ingredientes) {
            Object[] fila = {
                ingrediente.getId(),
                ingrediente.getNombre(),
                ingrediente.getUnidadMedida(),
                ingrediente.getCantidadStock()
            };
            modelo.addRow(fila);
        }

    }

    private void actualizarIngredientesFiltrados() {
        String filtroNombre = chkNombreIngrediente.isSelected() ? txtNombreIngrediente.getText().strip() : "";
        String filtroUnidadMedida = chkUnidadMedida.isSelected() ? comboBoxUnidadMedida.getSelectedItem().toString().strip() : "";

        this.ingredientes = ControlNavegacion.obtenerIngredientes(filtroNombre, filtroUnidadMedida);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        sepArriba = new javax.swing.JSeparator();
        txtNombreIngrediente = new javax.swing.JTextField();
        comboBoxUnidadMedida = new javax.swing.JComboBox<>();
        chkUnidadMedida = new javax.swing.JCheckBox();
        chkNombreIngrediente = new javax.swing.JCheckBox();
        lblTitulo = new javax.swing.JLabel();
        sepAbajo = new javax.swing.JSeparator();
        btnVolverAtras = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        scrollTabla = new javax.swing.JScrollPane();
        tablaIngredientes = new javax.swing.JTable();
        lblIngredienteSeleccionado = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblStock = new javax.swing.JLabel();
        btnReducir = new javax.swing.JButton();
        btnAumentar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtNombreIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreIngrediente.setEnabled(false);
        txtNombreIngrediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreIngredienteKeyTyped(evt);
            }
        });

        comboBoxUnidadMedida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        comboBoxUnidadMedida.setEnabled(false);
        comboBoxUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUnidadMedidaActionPerformed(evt);
            }
        });

        chkUnidadMedida.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkUnidadMedida.setText("Unidad de medida");
        chkUnidadMedida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkUnidadMedidaActionPerformed(evt);
            }
        });

        chkNombreIngrediente.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkNombreIngrediente.setText("Nombre ingrediente");
        chkNombreIngrediente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNombreIngredienteActionPerformed(evt);
            }
        });

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Buscador de ingredientes");
        lblTitulo.setToolTipText("");

        btnVolverAtras.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnVolverAtras.setText("<---");
        btnVolverAtras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverAtrasActionPerformed(evt);
            }
        });

        btnSeleccionar.setBackground(new java.awt.Color(0, 131, 125));
        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

        scrollTabla.setBackground(new java.awt.Color(255, 255, 255));

        tablaIngredientes.setBackground(new java.awt.Color(204, 204, 204));
        tablaIngredientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Unidad medida", "Cantidad Stock"
            }
        ));
        scrollTabla.setViewportView(tablaIngredientes);

        lblIngredienteSeleccionado.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblIngredienteSeleccionado.setForeground(new java.awt.Color(0, 131, 125));
        lblIngredienteSeleccionado.setText("Ingrediente seleccionado:");

        lblNombre.setText("Nombre:");

        lblNombreProducto.setBackground(new java.awt.Color(255, 255, 255));
        lblNombreProducto.setText("-");
        lblNombreProducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        lblStock.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblStock.setForeground(new java.awt.Color(0, 131, 125));
        lblStock.setText("Stock:");

        btnReducir.setBackground(new java.awt.Color(204, 204, 204));
        btnReducir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnReducir.setText("-");
        btnReducir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReducirActionPerformed(evt);
            }
        });

        btnAumentar.setBackground(new java.awt.Color(204, 204, 204));
        btnAumentar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnAumentar.setText("+");
        btnAumentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAumentarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(0, 204, 204));
        btnEliminar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar ingrediente");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(65, 65, 65)
                        .addComponent(lblIngredienteSeleccionado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(48, 48, 48))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(20, 20, 20))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblStock)
                        .addGap(103, 103, 103))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnEliminar)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReducir, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(sepArriba)
                        .addComponent(sepAbajo, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(chkNombreIngrediente)
                                        .addComponent(chkUnidadMedida))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtNombreIngrediente, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                        .addComponent(comboBoxUnidadMedida, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 349, Short.MAX_VALUE)))
                    .addGap(1, 1, 1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblIngredienteSeleccionado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(lblNombreProducto))
                        .addGap(27, 27, 27)
                        .addComponent(lblStock)
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReducir)
                            .addComponent(btnAumentar))
                        .addGap(38, 38, 38)
                        .addComponent(btnEliminar)
                        .addGap(165, 165, 165))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(4, 4, 4)
                    .addComponent(lblTitulo)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(sepArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkNombreIngrediente)
                        .addComponent(txtNombreIngrediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(chkUnidadMedida)
                        .addComponent(comboBoxUnidadMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(385, 385, 385)
                    .addComponent(sepAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkUnidadMedidaActionPerformed
        boolean estado = chkUnidadMedida.isSelected();
        comboBoxUnidadMedida.setEnabled(estado);

        cargarIngredientesTabla();
    }//GEN-LAST:event_chkUnidadMedidaActionPerformed

    private void chkNombreIngredienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNombreIngredienteActionPerformed
        boolean estado = chkNombreIngrediente.isSelected();
        txtNombreIngrediente.setEnabled(estado);

        cargarIngredientesTabla();
    }//GEN-LAST:event_chkNombreIngredienteActionPerformed

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        if (this.modo == ModoTablaIngredientes.INGREDIENTE) {
            ControlNavegacion.mostrarPantallaMenuIngrediente();
        } else if (this.modo == ModoTablaIngredientes.PRODUCTO) {
            //regresar a módulo producto
        }

        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        int filaSeleccionada = tablaIngredientes.getSelectedRow();
        Long id = Optional.ofNullable(filaSeleccionada != -1 ? modelo.getValueAt(filaSeleccionada, 0) : null)
                .map(valor -> (valor instanceof Number) ? ((Number) valor).longValue() : Long.valueOf(valor.toString()))
                .orElse(null);

        if (id == null) {
            JOptionPane.showMessageDialog(null, "Selecciona un producto");
            return;
        }

        //logica para que agregar ingrediente al producto

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void txtNombreIngredienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreIngredienteKeyTyped

        if (timer != null) {
            timer.stop();
        }

        timer = new Timer(TIPO_DEBOUNCE, e -> {
            String filtroNombre = chkNombreIngrediente.isSelected() ? txtNombreIngrediente.getText().strip() : "";
            String filtroUnidadMedida = chkUnidadMedida.isSelected() ? comboBoxUnidadMedida.getSelectedItem().toString().strip() : "";

            this.ingredientes = ControlNavegacion.obtenerIngredientes(filtroNombre, filtroUnidadMedida);

            cargarIngredientesTabla();
        });

        timer.setRepeats(false);
        timer.start();

    }//GEN-LAST:event_txtNombreIngredienteKeyTyped

    private void comboBoxUnidadMedidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxUnidadMedidaActionPerformed
        if (chkUnidadMedida.isSelected()) {
            String filtroNombre = chkNombreIngrediente.isSelected() ? txtNombreIngrediente.getText().strip() : "";
            String filtroUnidadMedida = comboBoxUnidadMedida.getSelectedItem().toString().strip();

            this.ingredientes = ControlNavegacion.obtenerIngredientes(filtroNombre, filtroUnidadMedida);

            cargarIngredientesTabla();
        }

    }//GEN-LAST:event_comboBoxUnidadMedidaActionPerformed

    private void btnReducirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReducirActionPerformed
        int filaSeleccionada = tablaIngredientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            Long idIngrediente = Long.valueOf(tablaIngredientes.getValueAt(filaSeleccionada, 0).toString());

            try {
                ingredienteBO.reducirStock(idIngrediente, 1);
                cargarIngredientesTabla();

            } catch (NegocioException | PersistenciaException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnReducirActionPerformed

    private void btnAumentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAumentarActionPerformed
        int filaSeleccionada = tablaIngredientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            Long idIngrediente = Long.valueOf(tablaIngredientes.getValueAt(filaSeleccionada, 0).toString());

            try {
                ingredienteBO.aumentarStock(idIngrediente, 1);
                cargarIngredientesTabla();
            } catch (NegocioException | PersistenciaException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnAumentarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        int filaSeleccionada = tablaIngredientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            Long idIngrediente = Long.valueOf(tablaIngredientes.getValueAt(filaSeleccionada, 0).toString());
            int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro de que desea eliminar este ingrediente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (confirmacion == JOptionPane.YES_OPTION) {
                try {
                    ingredienteBO.eliminarIngrediente(idIngrediente);

                    JOptionPane.showMessageDialog(this, "Ingrediente eliminado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    cargarIngredientesTabla();
                    lblNombreProducto.setText("-");
                    btnAumentar.setEnabled(false);
                    btnReducir.setEnabled(false);
                    btnEliminar.setEnabled(false);

                } catch (NegocioException | PersistenciaException e) {
                    JOptionPane.showMessageDialog(this, "Error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAumentar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnReducir;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JCheckBox chkNombreIngrediente;
    private javax.swing.JCheckBox chkUnidadMedida;
    private javax.swing.JComboBox<String> comboBoxUnidadMedida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblIngredienteSeleccionado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblStock;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JSeparator sepAbajo;
    private javax.swing.JSeparator sepArriba;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtNombreIngrediente;
    // End of variables declaration//GEN-END:variables
}
