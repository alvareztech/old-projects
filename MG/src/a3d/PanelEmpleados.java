package a3d;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PanelEmpleados extends javax.swing.JPanel {

    private VentanaPrincipal nucleo;

    public PanelEmpleados(VentanaPrincipal f) {
        nucleo = f;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaEmpleados = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrarEmpleado = new javax.swing.JButton();
        btnEliminarEmpleado = new javax.swing.JButton();

        tablaEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaEmpleados);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Empleados");

        btnRegistrarEmpleado.setText("Registrar Nuevo Empleado");
        btnRegistrarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarEmpleadoActionPerformed(evt);
            }
        });

        btnEliminarEmpleado.setText("Eliminar Empleado Seleccionado");
        btnEliminarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarEmpleadoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRegistrarEmpleado)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarEmpleado)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarEmpleado)
                    .addComponent(btnEliminarEmpleado))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarEmpleadoActionPerformed
        nucleo.mostrarRegistrarEmpleado();
    }//GEN-LAST:event_btnRegistrarEmpleadoActionPerformed

    private void btnEliminarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarEmpleadoActionPerformed
        int respuesta = JOptionPane.showConfirmDialog(this, "Realmente desea eliminar los datos?");
        if (respuesta == 0) {
            try {
                (new MGamesDB()).eliminarEmpleado(Integer.parseInt((String) tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 0)));
                actualizarTablaEmpleados();
            } catch (Exception ex) {
            }
        }

    }//GEN-LAST:event_btnEliminarEmpleadoActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminarEmpleado;
    private javax.swing.JButton btnRegistrarEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaEmpleados;
    // End of variables declaration//GEN-END:variables

    public void actualizarTablaEmpleados() {
        String[] nombresColumnas = {"CI", "Nombres", "Paterno", "Materno", "Sexo", "Direccion", "Telefono", "Correo", "Fecha de Nacimiento", "Cargo", "Contraseña"};
        Object[][] empleados = (new MGamesDB()).getDatosEmpleado();
        DefaultTableModel datos = new DefaultTableModel(empleados, nombresColumnas);
        tablaEmpleados.setModel(datos);
    }
}
