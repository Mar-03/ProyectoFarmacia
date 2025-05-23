/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vistas;

import Controlador.*;
import Modelo.*;

/**
 *
 * @author jhosu
 */
public class PanelLotesProductos extends javax.swing.JPanel {

    /**
     * Creates new form PanelLotesProductos
     */
    public PanelLotesProductos() {
        initComponents();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoVistaLotes = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        btnSalir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnRegistrar = new javax.swing.JPanel();
        registrar = new javax.swing.JLabel();
        txtNombreUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnBuscar = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumeroLote = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtFechaVencimiento = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtPrecioCompra = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioVenta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setPreferredSize(new java.awt.Dimension(850, 700));

        fondoVistaLotes.setBackground(new java.awt.Color(28, 95, 118));
        fondoVistaLotes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("LOTES DE PRODUCTOS");
        fondoVistaLotes.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 850, -1));

        btnSalir.setBackground(new java.awt.Color(75, 128, 146));
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");

        javax.swing.GroupLayout btnSalirLayout = new javax.swing.GroupLayout(btnSalir);
        btnSalir.setLayout(btnSalirLayout);
        btnSalirLayout.setHorizontalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );
        btnSalirLayout.setVerticalGroup(
            btnSalirLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        fondoVistaLotes.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 30, 30));

        btnRegistrar.setBackground(new java.awt.Color(75, 128, 146));
        btnRegistrar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnRegistrar.setPreferredSize(new java.awt.Dimension(110, 30));
        btnRegistrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        registrar.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        registrar.setForeground(new java.awt.Color(255, 255, 255));
        registrar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrar.setText("Registrar");
        registrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnRegistrar.add(registrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 100, 20));

        fondoVistaLotes.add(btnRegistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 420, -1, 30));

        txtNombreUsuario.setBackground(new java.awt.Color(75, 128, 146));
        txtNombreUsuario.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtNombreUsuario.setForeground(new java.awt.Color(255, 255, 255));
        txtNombreUsuario.setCaretColor(new java.awt.Color(255, 255, 255));
        fondoVistaLotes.add(txtNombreUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 280, -1));

        jLabel6.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nombre Producto:");
        fondoVistaLotes.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 250, 130, -1));

        btnBuscar.setBackground(new java.awt.Color(75, 128, 146));
        btnBuscar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setFont(new java.awt.Font("Arial Rounded MT Bold", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Buscar");

        javax.swing.GroupLayout btnBuscarLayout = new javax.swing.GroupLayout(btnBuscar);
        btnBuscar.setLayout(btnBuscarLayout);
        btnBuscarLayout.setHorizontalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnBuscarLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        btnBuscarLayout.setVerticalGroup(
            btnBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
        );

        fondoVistaLotes.add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 245, 110, 30));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Número Lote:");
        fondoVistaLotes.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 350, 120, -1));

        txtNumeroLote.setBackground(new java.awt.Color(75, 128, 146));
        txtNumeroLote.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtNumeroLote.setCaretColor(new java.awt.Color(255, 255, 255));
        fondoVistaLotes.add(txtNumeroLote, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 350, 140, -1));

        jLabel3.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha Vencimiento:");
        fondoVistaLotes.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 350, -1, -1));

        txtFechaVencimiento.setBackground(new java.awt.Color(75, 128, 146));
        txtFechaVencimiento.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtFechaVencimiento.setCaretColor(new java.awt.Color(255, 255, 255));
        fondoVistaLotes.add(txtFechaVencimiento, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 350, 110, -1));

        jLabel4.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Cantidad:");
        fondoVistaLotes.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 390, 120, -1));

        txtCantidad.setBackground(new java.awt.Color(75, 128, 146));
        txtCantidad.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtCantidad.setCaretColor(new java.awt.Color(255, 255, 255));
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        fondoVistaLotes.add(txtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, 290, -1));

        jLabel5.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Precio Compra:");
        fondoVistaLotes.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 430, 120, -1));

        txtPrecioCompra.setBackground(new java.awt.Color(75, 128, 146));
        txtPrecioCompra.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtPrecioCompra.setCaretColor(new java.awt.Color(255, 255, 255));
        txtPrecioCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPrecioCompraActionPerformed(evt);
            }
        });
        fondoVistaLotes.add(txtPrecioCompra, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 430, 290, -1));

        jLabel8.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Precio Venta:");
        fondoVistaLotes.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 470, 120, -1));

        txtPrecioVenta.setBackground(new java.awt.Color(75, 128, 146));
        txtPrecioVenta.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        txtPrecioVenta.setCaretColor(new java.awt.Color(255, 255, 255));
        fondoVistaLotes.add(txtPrecioVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 470, 290, -1));

        jLabel9.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("FARMACIA");
        fondoVistaLotes.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 850, -1));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        fondoVistaLotes.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 850, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        fondoVistaLotes.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 850, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoVistaLotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoVistaLotes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    private void txtPrecioCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPrecioCompraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPrecioCompraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JPanel btnBuscar;
    public javax.swing.JPanel btnRegistrar;
    private javax.swing.JPanel btnSalir;
    private javax.swing.JPanel fondoVistaLotes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel registrar;
    private javax.swing.JLabel titulo;
    public javax.swing.JTextField txtCantidad;
    public javax.swing.JTextField txtFechaVencimiento;
    public javax.swing.JTextField txtNombreUsuario;
    public javax.swing.JTextField txtNumeroLote;
    public javax.swing.JTextField txtPrecioCompra;
    public javax.swing.JTextField txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
