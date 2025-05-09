/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package vista;

/**
 *
 * @author cindy
 */
public class PanelProducto extends javax.swing.JPanel {

    /**
     * Creates new form PanelProducto
     */
    public PanelProducto() {
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

        fondoPanel = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        marcaAgua = new javax.swing.JLabel();
        separador = new javax.swing.JSeparator();
        separador2 = new javax.swing.JSeparator();
        btnSalir = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        fondoPanel.setBackground(new java.awt.Color(28, 95, 118));
        fondoPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 24)); // NOI18N
        titulo.setForeground(new java.awt.Color(255, 255, 255));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("REGISTRO PRODUCTO");
        fondoPanel.add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 850, -1));

        marcaAgua.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 12)); // NOI18N
        marcaAgua.setForeground(new java.awt.Color(255, 255, 255));
        marcaAgua.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        marcaAgua.setText("FARMACIA");
        fondoPanel.add(marcaAgua, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, 850, -1));
        fondoPanel.add(separador, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 850, -1));
        fondoPanel.add(separador2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 620, 850, -1));

        btnSalir.setBackground(new java.awt.Color(75, 128, 146));
        btnSalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
        });
        btnSalir.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalir.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-1, 0, 30, 30));

        fondoPanel.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 10, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(fondoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        System.exit(0); 
    }//GEN-LAST:event_btnSalirMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSalir;
    private javax.swing.JPanel fondoPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel marcaAgua;
    private javax.swing.JSeparator separador;
    private javax.swing.JSeparator separador2;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
