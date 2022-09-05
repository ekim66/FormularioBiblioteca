/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.ciclo2reto5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class SysBiblio extends javax.swing.JFrame {

    DefaultTableModel modelo = new DefaultTableModel();
    Connect con = new Connect();
    Connection connect = con.getConnection();
    ArrayList listObjetoCar = new ArrayList();
    Lector objLector = new Lector();
    String[] dataLector = new String[6];
    public int indexcbxCarrera;
    public int fila;

    /**
     * Creates new form SysBiblio
     */
    public SysBiblio() {
        initComponents();

        this.modelo.addColumn("Codigo");
        this.modelo.addColumn("Identificacion");
        this.modelo.addColumn("Nombres");
        this.modelo.addColumn("Dirección");
        this.modelo.addColumn("Telefono");
        this.modelo.addColumn("Carrera");
        this.tabData.setModel(modelo);
        this.cargarTabla();
        this.listObjetoCar = ListaobjCarrera();
        Iterator i = listObjetoCar.iterator();

        while (i.hasNext()) {
            Carrera objcbxCarrera = (Carrera) i.next();
            this.cbxCodCarrera.addItem("" + objcbxCarrera);
        }
    }

 /*   public void cargarTabla() {

        for (int i = 0; i < this.tabData.getRowCount(); i++) {
            this.modelo.removeRow(i);
            i--;
        }
        try {
            PreparedStatement consulta = connect.prepareStatement("select codLector, identificacion, nombres, codCarrera from lector;");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                //this.objLector.setCodLector(resultado.getInt("codLector"));
                //this.dataLector[0] = "" +this.objLector.getCodLector();

                this.dataLector[0] = resultado.getString(1);
                this.dataLector[1] = resultado.getString(2);
                this.dataLector[2] = resultado.getString(3);
                this.dataLector[3] = resultado.getString(4);

                this.modelo.addRow(this.dataLector);
                this.tabData.setModel(modelo);
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "Connection error");
        }

    }
*/
    public ArrayList ListaobjCarrera() {
        ArrayList listadoCarreras = new ArrayList();

        Carrera objCarrera = null;
        try {
            PreparedStatement consulta = connect.prepareStatement("select * from carrera;");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                objCarrera = new Carrera();
                objCarrera.setCodCarrera(resultado.getInt("codCarrera"));
                objCarrera.setNombre(resultado.getNString("nombre"));
                listadoCarreras.add(objCarrera);
                System.out.println(objCarrera);
            }
        } catch (Exception e) {
            System.err.println(e);
            JOptionPane.showMessageDialog(null, "error to get carreras data");
        }
        //System.out.println(listadoCarreras);
        return listadoCarreras;
    }

    public void capturaDatos() {
        this.indexcbxCarrera = this.cbxCodCarrera.getSelectedIndex() + 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabData = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        labelDatos = new javax.swing.JLabel();
        labelIdentificacion = new javax.swing.JLabel();
        labelNombre = new javax.swing.JLabel();
        labelDireccion = new javax.swing.JLabel();
        labelTelefono = new javax.swing.JLabel();
        labelCodCarrera = new javax.swing.JLabel();
        texfIdentificacion = new javax.swing.JTextField();
        texfNombre = new javax.swing.JTextField();
        texfDireccion = new javax.swing.JTextField();
        texfTelefono = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        cbxCodCarrera = new javax.swing.JComboBox<>();
        labelCodigo = new javax.swing.JLabel();
        texfCodLector = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabData);

        labelDatos.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDatos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDatos.setText("Gestionar Lector");

        labelIdentificacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelIdentificacion.setText("Identificacion");

        labelNombre.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelNombre.setText("Nombre");

        labelDireccion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelDireccion.setText("Direccion");

        labelTelefono.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelTelefono.setText("Telefono");

        labelCodCarrera.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCodCarrera.setText("Codigo de Carrera");

        texfDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfDireccionActionPerformed(evt);
            }
        });

        texfTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                texfTelefonoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        labelCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        labelCodigo.setText("Codigo");

        texfCodLector.setText("No digite valores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelIdentificacion)
                            .addComponent(labelDireccion)
                            .addComponent(labelTelefono)
                            .addComponent(labelCodCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelNombre)
                            .addComponent(labelCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxCodCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(texfCodLector, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(texfNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(texfIdentificacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(texfDireccion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                    .addComponent(texfTelefono, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                                .addGap(47, 47, 47)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnModificar))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelDatos)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodigo)
                    .addComponent(texfCodLector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelIdentificacion)
                    .addComponent(texfIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelNombre)
                    .addComponent(texfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDireccion)
                    .addComponent(texfDireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTelefono)
                    .addComponent(texfTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCodCarrera)
                    .addComponent(cbxCodCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void texfDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfDireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texfDireccionActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        this.capturaDatos();
        if (this.validar()) {
            try {
                PreparedStatement guardar = connect.prepareStatement("insert into lector (identificacion, nombres, direccion, telefono, codCarrera) values (?,?,?,?,?)");
                guardar.setString(1, texfIdentificacion.getText());
                guardar.setString(2, texfNombre.getText());
                guardar.setString(3, texfDireccion.getText());
                guardar.setString(4, texfTelefono.getText());
                //guardar.setString(5, cbxCodCarrera.getSelectedItem().toString());
                guardar.setString(5, "" + this.indexcbxCarrera);
                guardar.executeUpdate();
                JOptionPane.showMessageDialog(null, "The data was saved");
                texfIdentificacion.setText("");
                texfNombre.setText("");
                texfDireccion.setText("");
                texfTelefono.setText("");
                texfIdentificacion.requestFocus();
                
                this.cargarTabla();
                this.limpiar();
            } catch (Exception e) {
                System.err.println(e);
                JOptionPane.showMessageDialog(null, "error sending data");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        this.fila = this.tabData.getSelectedRow();

        this.capturaDatos();

        if (fila >= 0) {
            if (this.validar()) {
                try {
                    String codigo = "" + this.tabData.getValueAt(fila, 0);
                    this.texfCodLector.setText(codigo);
                    this.texfCodLector.setEnabled(false);
                    PreparedStatement consulta = (PreparedStatement) connect.prepareStatement("UPDATE lector SET identificacion = ?, nombres = ?, direccion = ?, telefono = ?, codCarrera = ? WHERE codLector = ?");
                    consulta.setString(1, this.texfIdentificacion.getText());
                    consulta.setString(2, this.texfNombre.getText());
                    consulta.setString(3, this.texfDireccion.getText());
                    consulta.setString(4, this.texfTelefono.getText());
                    consulta.setString(5, "" + this.indexcbxCarrera);
                    consulta.setString(6, this.texfCodLector.getText());

                    consulta.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Update was successful");

                    this.cargarTabla();
                    this.limpiar();
                } catch (SQLException ex) {
                    Logger.getLogger(SysBiblio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        this.fila = this.tabData.getSelectedRow();

        if (fila >= 0) {
            try {
                String codigo = "" + this.tabData.getValueAt(fila, 0);
                this.texfCodLector.setText(codigo);
                this.texfCodLector.setEnabled(false);
                PreparedStatement consulta = (PreparedStatement) this.connect.prepareStatement("DELETE FROM lector WHERE codLector = ?");
                consulta.setString(1, this.texfCodLector.getText());
                consulta.executeUpdate();
                JOptionPane.showMessageDialog(null, "Datos eliminados correctamente!");

                this.cargarTabla();
                this.limpiar();
            } catch (SQLException ex) {
                Logger.getLogger(SysBiblio.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un registro de la tabla");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void texfTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_texfTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_texfTelefonoActionPerformed
    public boolean validar() {

        if (this.texfCodLector.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el Código del Lector");
            this.texfCodLector.requestFocus();
            return false;
        } else if (this.texfIdentificacion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite la Identificación del Lector");
            this.texfIdentificacion.requestFocus();
            return false;
        } else if (this.texfNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el Nombre completo del Lector");
            this.texfNombre.requestFocus();
            return false;
        } else if (this.texfTelefono.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Digite el Teléfono del Lector");
            this.texfTelefono.requestFocus();
            return false;
        } else {
            return true;
        }

    }

    public void cargarTabla() {

        for (int i = 0; i < this.tabData.getRowCount(); i++) {
            this.modelo.removeRow(i);
            i--;
        }

        try {
            PreparedStatement consulta = (PreparedStatement) connect.prepareStatement("select codLector, identificacion, nombres, direccion, telefono, codCarrera from lector;");
            ResultSet resultado = consulta.executeQuery();

            while (resultado.next()) {
                //this.objLector.setCodLector(resultado.getInt("codLector"));
                //this.dataLector[0] = ""+this.objLector.getCodLector();

                this.dataLector[0] = resultado.getString(1);
                this.dataLector[1] = resultado.getString(2);
                this.dataLector[2] = resultado.getString(3);
                this.dataLector[3] = resultado.getString(4);
                this.dataLector[4] = resultado.getString(5);
                this.dataLector[5] = resultado.getString(6);

                this.modelo.addRow(this.dataLector);
                this.tabData.setModel(modelo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SysBiblio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public void limpiar() {

        this.texfIdentificacion.setText("");
        this.texfNombre.setText("");
        this.texfDireccion.setText("");
        this.texfTelefono.setText("");
        this.cbxCodCarrera.setSelectedIndex(0);
        

    }

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
            java.util.logging.Logger.getLogger(SysBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SysBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SysBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SysBiblio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SysBiblio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cbxCodCarrera;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodCarrera;
    private javax.swing.JLabel labelCodigo;
    private javax.swing.JLabel labelDatos;
    private javax.swing.JLabel labelDireccion;
    private javax.swing.JLabel labelIdentificacion;
    private javax.swing.JLabel labelNombre;
    private javax.swing.JLabel labelTelefono;
    private javax.swing.JTable tabData;
    private javax.swing.JTextField texfCodLector;
    private javax.swing.JTextField texfDireccion;
    private javax.swing.JTextField texfIdentificacion;
    private javax.swing.JTextField texfNombre;
    private javax.swing.JTextField texfTelefono;
    // End of variables declaration//GEN-END:variables
}
