package pantallas;

import DTOs.salida.ProductoResumenDTO;
import control.ControlNavegacion;
import entidades.enums.TipoProducto;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class PantallaTablaProductos extends javax.swing.JFrame {

    List<ProductoResumenDTO> productos;

    public PantallaTablaProductos(List<ProductoResumenDTO> productos) {
        initComponents();

        this.productos = productos;

        for (TipoProducto tipo : TipoProducto.values()) {
            cmbCategoria.addItem(tipo.toString());
        }

        DefaultTableModel modelo = (DefaultTableModel) tblProductos.getModel();
        for (ProductoResumenDTO producto : productos) {
            Object[] fila = {
                producto.getId(),
                producto.getNombre(),
                producto.getTipo(),
                producto.getPrecio()
            };
            modelo.addRow(fila);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sepArriba = new javax.swing.JSeparator();
        sepAbajo = new javax.swing.JSeparator();
        lblTitulo = new javax.swing.JLabel();
        btnVolverAtras = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        scrProductos = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        chkNombreProducto = new javax.swing.JCheckBox();
        chkCategoria = new javax.swing.JCheckBox();
        txtNombreProducto = new javax.swing.JTextField();
        btnFiltrar = new javax.swing.JButton();
        cmbCategoria = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Productos");

        lblTitulo.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblTitulo.setText("Productos");
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

        scrProductos.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Tipo", "Precio"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrProductos.setViewportView(tblProductos);

        chkNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkNombreProducto.setText("Nombre producto");
        chkNombreProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkNombreProductoActionPerformed(evt);
            }
        });

        chkCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        chkCategoria.setText("Categoria");
        chkCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCategoriaActionPerformed(evt);
            }
        });

        txtNombreProducto.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        txtNombreProducto.setEnabled(false);

        btnFiltrar.setBackground(new java.awt.Color(135, 174, 206));
        btnFiltrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnFiltrar.setText("Filtrar");
        btnFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrarActionPerformed(evt);
            }
        });

        cmbCategoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmbCategoria.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sepArriba)
            .addComponent(sepAbajo, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(chkNombreProducto)
                                    .addComponent(chkCategoria))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                    .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(btnFiltrar)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolverAtras, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSeleccionar, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sepArriba, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkNombreProducto)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chkCategoria)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(scrProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 349, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(sepAbajo, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVolverAtras, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed

    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnVolverAtrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverAtrasActionPerformed
        ControlNavegacion.mostrarPantallaMenuProducto();

        this.dispose();
    }//GEN-LAST:event_btnVolverAtrasActionPerformed

    private void chkNombreProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkNombreProductoActionPerformed
        boolean estado = chkNombreProducto.isSelected();
        txtNombreProducto.setEnabled(estado);
    }//GEN-LAST:event_chkNombreProductoActionPerformed

    private void chkCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCategoriaActionPerformed
        boolean estado = chkCategoria.isSelected();
        cmbCategoria.setEnabled(estado);
    }//GEN-LAST:event_chkCategoriaActionPerformed

    private void btnFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrarActionPerformed
        String filtroProducto = chkNombreProducto.isSelected() ? txtNombreProducto.getText().strip() : "";
        String filtroCategoria = chkCategoria.isSelected() ? cmbCategoria.getSelectedItem().toString().strip() : "";
        ControlNavegacion.mostrarPantallaTablaProductos(filtroProducto, filtroCategoria);

        this.dispose();
    }//GEN-LAST:event_btnFiltrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltrar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVolverAtras;
    private javax.swing.JCheckBox chkCategoria;
    private javax.swing.JCheckBox chkNombreProducto;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JScrollPane scrProductos;
    private javax.swing.JSeparator sepAbajo;
    private javax.swing.JSeparator sepArriba;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtNombreProducto;
    // End of variables declaration//GEN-END:variables
}
