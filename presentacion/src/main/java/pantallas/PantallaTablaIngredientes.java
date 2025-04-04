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
import javax.swing.JButton;
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
        if (modo == ModoTablaIngredientes.INGREDIENTE) {
            btnSeleccionar.setVisible(false);
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

        if (modo == ModoTablaIngredientes.PRODUCTO) {
            for (IngredienteViejoDTO ingrediente : ingredientes) {
                Object[] fila = {
                    ingrediente.getId(),
                    ingrediente.getNombre(),
                    ingrediente.getUnidadMedida(),
                    ingrediente.getCantidadStock()
                };
                modelo.addRow(fila);
            }
        } else if (modo == ModoTablaIngredientes.INGREDIENTE) {
            for (IngredienteViejoDTO ingrediente : ingredientes) {
                Object[] fila = {
                    ingrediente.getId(),
                    ingrediente.getNombre(),
                    ingrediente.getUnidadMedida(),
                    ingrediente.getCantidadStock(),
                    crearBoton("Restar Stock", ingrediente),
                    crearBoton("Aumentar Stock", ingrediente),
                    crearBoton("Eliminar", ingrediente)
                };
                modelo.addRow(fila);
            }
        }
    }

    private void actualizarIngredientesFiltrados() {
        String filtroNombre = chkNombreIngrediente.isSelected() ? txtNombreIngrediente.getText().strip() : "";
        String filtroUnidadMedida = chkUnidadMedida.isSelected() ? comboBoxUnidadMedida.getSelectedItem().toString().strip() : "";

        this.ingredientes = ControlNavegacion.obtenerIngredientes(filtroNombre, filtroUnidadMedida);
    }

    private JButton crearBoton(String nombre, IngredienteViejoDTO ingrediente) {
        JButton boton = new JButton(nombre);
        boton.addActionListener(e -> {
            switch (nombre) {
                case "Restar Stock":
                    restarStock(ingrediente);
                    break;
                case "Aumentar Stock":
                    aumentarStock(ingrediente);
                    break;
                case "Eliminar":
                    eliminarIngrediente(ingrediente);
                    break;
            }
        });
        return boton;
    }

    private void restarStock(IngredienteViejoDTO ingrediente) {
        try {
            if (ingrediente.getCantidadStock() > 0) {
                boolean resultado = ingredienteBO.reducirStock(ingrediente.getId(), 1);
                if (resultado) {
                    ingrediente.setCantidadStock(ingrediente.getCantidadStock() - 1);
                    actualizarTabla();
                } else {
                    JOptionPane.showMessageDialog(this, "No se pudo reducir el stock.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "No se puede restar más stock");
            }
        } catch (PersistenciaException | NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al reducir stock: " + e.getMessage());
        }
    }

    private void aumentarStock(IngredienteViejoDTO ingrediente) {
        try {
            boolean resultado = ingredienteBO.aumentarStock(ingrediente.getId(), 1);
            if (resultado) {
                ingrediente.setCantidadStock(ingrediente.getCantidadStock() + 1);
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo aumentar el stock.");
            }
        } catch (PersistenciaException | NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al aumentar stock: " + e.getMessage());
        }
    }

    private void eliminarIngrediente(IngredienteViejoDTO ingrediente) {
        try {
            boolean eliminado = ingredienteBO.eliminarIngrediente(ingrediente.getId());
            if (eliminado) {
                ingredientes.remove(ingrediente);
                actualizarTabla();
            } else {
                JOptionPane.showMessageDialog(this, "No se pudo eliminar el ingrediente.");
            }
        } catch (PersistenciaException | NegocioException e) {
            JOptionPane.showMessageDialog(this, "Error al eliminar ingrediente: " + e.getMessage());
        }
    }

    private void actualizarTabla() {
        modelo.setRowCount(0);
        for (IngredienteViejoDTO ingrediente : ingredientes) {
            Object[] fila = {
                ingrediente.getId(),
                ingrediente.getNombre(),
                ingrediente.getUnidadMedida(),
                ingrediente.getCantidadStock(),
                crearBoton("Restar Stock", ingrediente),
                crearBoton("Aumentar Stock", ingrediente),
                crearBoton("Eliminar", ingrediente)
            };
            modelo.addRow(fila);
        }
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

        btnSeleccionar.setBackground(new java.awt.Color(135, 174, 206));
        btnSeleccionar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 555, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(232, Short.MAX_VALUE))
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
                                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(0, 302, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(1, 1, 1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(163, Short.MAX_VALUE)
                .addComponent(scrollTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(94, 94, 94))
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
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnVolverAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JCheckBox chkNombreIngrediente;
    private javax.swing.JCheckBox chkUnidadMedida;
    private javax.swing.JComboBox<String> comboBoxUnidadMedida;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrollTabla;
    private javax.swing.JSeparator sepAbajo;
    private javax.swing.JSeparator sepArriba;
    private javax.swing.JTable tablaIngredientes;
    private javax.swing.JTextField txtNombreIngrediente;
    // End of variables declaration//GEN-END:variables
}