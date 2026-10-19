package umg.UI;

import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import umg.DAO.CamionDAO;
import umg.DAO.CamioneroDAO;
import umg.DAO.ConductorCamionDAO;
import umg.modelo.Camion;
import umg.modelo.Camionero;
import umg.modelo.ConductorCamion;

public class FrmConductorCamion extends javax.swing.JFrame {

    private ConductorCamionDAO ccDAO = new ConductorCamionDAO();
    private CamioneroDAO camioneroDAO = new CamioneroDAO();
    private CamionDAO camionDAO = new CamionDAO();
    private int idSeleccionado = -1;

    public FrmConductorCamion() {
        initComponents();
        this.setLocationRelativeTo(null);
        cargarCamionerosCombo();
        cargarCamionesCombo();
        txtFecha.setText(LocalDate.now().toString());
        cargarTabla();
    }

    private void cargarCamionerosCombo() {
        cmbCamionero.removeAllItems();
        try {
            for (Camionero c : camioneroDAO.listar()) {
                cmbCamionero.addItem(c.getIdCamionero() + " - " + c.getNombre());
            }
        } catch (Exception e) {
            System.err.println("Error al cargar camioneros: " + e.getMessage());
        }
    }

    private void cargarCamionesCombo() {
        cmbCamion.removeAllItems();
        try {
            for (Camion cm : camionDAO.listar()) {
                cmbCamion.addItem(cm.getIdCamion() + " - " + cm.getModelo() + " [" + cm.getMatricula() + "]");
            }
        } catch (Exception e) {
            System.err.println("Error al cargar camiones: " + e.getMessage());
        }
    }

    private void cargarTabla() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("ID Camionero");
        model.addColumn("Camionero");
        model.addColumn("ID Camión");
        model.addColumn("Matrícula Camión");
        model.addColumn("Fecha");

        try {
            for (ConductorCamion cc : ccDAO.listar()) {
                model.addRow(new Object[]{
                    cc.getIdConductorCamion(),
                    cc.getConductor() != null ? cc.getConductor().getIdCamionero() : "",
                    cc.getConductor() != null ? cc.getConductor().getNombre() : "",
                    cc.getCamion() != null ? cc.getCamion().getIdCamion() : "",
                    cc.getCamion() != null ? cc.getCamion().getMatricula() : "",
                    cc.getFecha() != null ? cc.getFecha().toString() : ""
                });
            }
        } catch (Exception e) {
            System.err.println("Error al cargar tabla: " + e.getMessage());
        }
    }

    private void limpiar() {
        idSeleccionado = -1;
        txtFecha.setText(LocalDate.now().toString());
        if (cmbCamionero.getItemCount() > 0) cmbCamionero.setSelectedIndex(0);
        if (cmbCamion.getItemCount() > 0) cmbCamion.setSelectedIndex(0);
    }

    private int obtenerIdCamionero() {
        String sel = (String) cmbCamionero.getSelectedItem();
        if (sel != null && sel.contains(" - ")) {
            return Integer.parseInt(sel.split(" - ")[0]);
        }
        return -1;
    }

    private int obtenerIdCamion() {
        String sel = (String) cmbCamion.getSelectedItem();
        if (sel != null && sel.contains(" - ")) {
            return Integer.parseInt(sel.split(" - ")[0]);
        }
        return -1;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbCamionero = new javax.swing.JComboBox<>();
        cmbCamion = new javax.swing.JComboBox<>();
        txtFecha = new javax.swing.JTextField();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Asignacion de Conductor ");

        jLabel2.setText("conductor");

        jLabel3.setText("Camion");

        jLabel4.setText("Fecha de Asignación (YYYY-MM-DD)");

        cmbCamionero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cmbCamion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnLimpiar.setText("Limpiar");

        btnGuardar.setText("Guardar ");

        btnEliminar.setText("Eliminar");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbCamionero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLimpiar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar)))
                .addContainerGap(66, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cmbCamionero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(91, 91, 91)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
          System.err.println("Error de Look and Feel: " + ex.getMessage());
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FrmConductorCamion().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JComboBox<String> cmbCamion;
    private javax.swing.JComboBox<String> cmbCamionero;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
}
