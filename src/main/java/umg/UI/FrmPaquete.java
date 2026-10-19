package umg.UI;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import umg.DAO.CiudadDAO;
import umg.DAO.PaqueteDAO;
import umg.modelo.Ciudad;
import umg.modelo.Paquete;

public class FrmPaquete extends javax.swing.JFrame {

    private PaqueteDAO paqueteDAO = new PaqueteDAO();
    private CiudadDAO ciudadDAO = new CiudadDAO();
    private int idPaqueteSeleccionado = -1;

    public FrmPaquete() {
        initComponents();
        cargarCiudadesCombo();
        cargarPaquetes();
    }

  private void cargarCiudadesCombo() {
        cmbCiudad.removeAllItems();
        try {
            for (Ciudad c : ciudadDAO.listar()) {
                cmbCiudad.addItem(c.getCiudad() + " - " + c.getNombre());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al cargar ciudades: " + e.getMessage());
        }
    }

    private void cargarPaquetes() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("Código");
        model.addColumn("Descripción");
        model.addColumn("Destinatario");
        model.addColumn("Dirección");
        model.addColumn("ID Ciudad");

        for (Paquete p : paqueteDAO.listar()) {
            model.addRow(new Object[]{
                p.getIdPaquete(),
                p.getCodigo(),
                p.getDescripcion(),
                p.getDestinatario(),
                p.getDireccionDestinatario(),
                p.getIdCiudad()
            });
        }
        tblPaquete.setModel(model);
    }

    private void limpiar() {
        txtCodigo.setText("");
        txtDescripcion.setText("");
        txtDestinatario.setText("");
        txtDireccion.setText("");
        idPaqueteSeleccionado = -1;
        if (cmbCiudad.getItemCount() > 0) {
            cmbCiudad.setSelectedIndex(0);
        }
    }

    private int obtenerIdCiudadSeleccionada() {
        String seleccion = (String) cmbCiudad.getSelectedItem();
        if (seleccion != null && seleccion.contains(" - ")) {
            return Integer.parseInt(seleccion.split(" - ")[0]);
        }
        return -1;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtCodigo = new javax.swing.JTextField();
        txtDescripcion = new javax.swing.JTextField();
        txtDestinatario = new javax.swing.JTextField();
        txtDireccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCiudad = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPaquete = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        txtDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinatarioActionPerformed(evt);
            }
        });

        txtDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDireccionActionPerformed(evt);
            }
        });

        jLabel2.setText("Codigo");

        jLabel1.setText("Descripcion:");

        jLabel3.setText("Destinatario:");

        jLabel4.setText("Direccion:");

        cmbCiudad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbCiudad.setToolTipText("");
        cmbCiudad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbCiudadActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        tblPaquete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Codigo", "Descripcion", "Destinatario", "Direccion", "IDcCiudad"
            }
        ));
        tblPaquete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaqueteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblPaquete);

        jLabel5.setText("Ciudad:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(25, 25, 25))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCodigo)
                            .addComponent(txtDescripcion)
                            .addComponent(txtDireccion)
                            .addComponent(txtDestinatario)
                            .addComponent(cmbCiudad, 0, 161, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar)
                        .addGap(18, 18, 18)
                        .addComponent(btnActualizar)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)))
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(80, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDestinatario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCiudad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminar)
                    .addComponent(btnActualizar)
                    .addComponent(btnGuardar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void txtDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinatarioActionPerformed

    private void txtDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDireccionActionPerformed

    private void cmbCiudadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbCiudadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbCiudadActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       int idCiudad = obtenerIdCiudadSeleccionada();
        if (idCiudad == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una ciudad válida.");
            return;
        }

        Paquete p = new Paquete();
        p.setCodigo(txtCodigo.getText());
        p.setDescripcion(txtDescripcion.getText());
        p.setDestinatario(txtDestinatario.getText());
        p.setDireccionDestinatario(txtDireccion.getText());
        p.setIdCiudad(idCiudad);

        if (paqueteDAO.insertar(p)) {
            JOptionPane.showMessageDialog(this, "Paquete guardado correctamente.");
            cargarPaquetes();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar el paquete.");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (idPaqueteSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla.");
            return;
        }
        int idCiudad = obtenerIdCiudadSeleccionada();
        if (idCiudad == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una ciudad válida.");
            return;
        }

        Paquete p = new Paquete();
        p.setIdPaquete(idPaqueteSeleccionado);
        p.setCodigo(txtCodigo.getText());
        p.setDescripcion(txtDescripcion.getText());
        p.setDestinatario(txtDestinatario.getText());
        p.setDireccionDestinatario(txtDireccion.getText());
        p.setIdCiudad(idCiudad);

        if (paqueteDAO.actualizar(p)) {
            JOptionPane.showMessageDialog(this, "Paquete actualizado correctamente.");
            cargarPaquetes();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar el paquete.");
        }
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

       if (idPaqueteSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un registro de la tabla.");
            return;
        }
        if (paqueteDAO.eliminar(idPaqueteSeleccionado)) {
            JOptionPane.showMessageDialog(this, "Paquete eliminado correctamente.");
            cargarPaquetes();
            limpiar();
        } else {
            JOptionPane.showMessageDialog(this, "Error al eliminar el paquete.");
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblPaqueteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaqueteMouseClicked
                                           
        int fila = tblPaquete.getSelectedRow();
        if (fila >= 0) {
            idPaqueteSeleccionado = Integer.parseInt(tblPaquete.getValueAt(fila, 0).toString());
            txtCodigo.setText(tblPaquete.getValueAt(fila, 1).toString());
            txtDescripcion.setText(tblPaquete.getValueAt(fila, 2).toString());
            txtDestinatario.setText(tblPaquete.getValueAt(fila, 3).toString());
            txtDireccion.setText(tblPaquete.getValueAt(fila, 4).toString());

            // Seleccionar automáticamente la ciudad en el JComboBox
            int idCiudad = Integer.parseInt(tblPaquete.getValueAt(fila, 5).toString());
            for (int i = 0; i < cmbCiudad.getItemCount(); i++) {
                String item = cmbCiudad.getItemAt(i);
                if (item.startsWith(idCiudad + " - ")) {
                    cmbCiudad.setSelectedIndex(i);
                    break;
                }
            }
        }
 
    }//GEN-LAST:event_tblPaqueteMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            System.err.println("Error al aplicar el tema visual: " + ex.getMessage());
        }

        java.awt.EventQueue.invokeLater(() -> new FrmPaquete().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbCiudad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblPaquete;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtDestinatario;
    private javax.swing.JTextField txtDireccion;
    // End of variables declaration//GEN-END:variables
}
