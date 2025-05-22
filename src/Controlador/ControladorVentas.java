/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Implementacion.VentaImp;
import Modelo.ModeloProducto;
import Modelo.ModeloVenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhosu
 */
public class ControladorVentas implements MouseListener {

    ModeloVenta modelo;

    public ControladorVentas(ModeloVenta modelo) {
        this.modelo = modelo;
    }

    VentaImp implementacion = new VentaImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaVentas().btnAgregar)) {
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)) {
            datosVaciosBuscarP();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)) {
            modelo.getVistaVentas().btnBuscar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnAgregar)) {
            modelo.getVistaVentas().btnAgregar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnEliminar)) {
            modelo.getVistaVentas().btnEliminar.setBackground(new Color(50, 95, 110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)) {
            modelo.getVistaVentas().btnBuscar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnAgregar)) {
            modelo.getVistaVentas().btnAgregar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnEliminar)) {
            modelo.getVistaVentas().btnEliminar.setBackground(new Color(75, 128, 146));
        }
    }

    private void capturaDatosBuscarP() {
        String nombreIngresado = modelo.getVistaVentas().txtNombreProducto.getText();
        String codigoIngresadoP = modelo.getVistaVentas().txtCodigoBarras.getText();

        consultarProducto(nombreIngresado, codigoIngresadoP);
    }
    
    private void capturaDatosAgregarP(){
        
        String nombreP = modelo.getVistaVentas().txtNombreProducto.getText();
        String precioP = modelo.getVistaVentas().txtPrecio.getText();
        
        
        
    }
    
    private String calcularPrecioP(String precio){
        
        modelo.getVistaVentas().cmbSubsidio.getItemAt(1);
        
        
        
        return "";
    }
    
    
    private String calcularSubTotal(){
        
        return "";
    }
    
    private String calcularTotal(){
        
        
        return "";
    }
    
    private void limpiarDatos() {
    }

    public void datosVaciosBuscarP() {
        if (modelo.getVistaVentas().txtNombreProducto.getText().isEmpty() && modelo.getVistaVentas().txtCodigoBarras.getText().isEmpty()) {
            mostrarError("Debe de ingresar al menos el nombre o código del producto");
        } else {
            capturaDatosBuscarP();
        }
    }

    public void datosVaciosAgregarP() {
        if (modelo.getVistaVentas().txtNombreProducto.getText().isEmpty() || modelo.getVistaVentas().txtCodigoBarras.getText().isEmpty()) {
            mostrarError("No se pudo agregar el producto, por favor busque un producto para agregarlo");
        } else {
        }
    }

    public void elementosVisibles() {
    }

    public void consultarProducto(String nombreP, String codigoB) {

//        ModeloVenta modeloV = new ModeloVenta();
        ModeloProducto modeloP = new ModeloProducto();

        modeloP = implementacion.buscarProducto(nombreP, codigoB);

        modelo.getVistaVentas().txtIdProducto.setText(String.valueOf(modeloP.getIdProducto()));
        modelo.getVistaVentas().txtCodigoBarras.setText(modeloP.getCodigoBarrasP());
        modelo.getVistaVentas().txtNombreProducto.setText(modeloP.getNombreOficialP());
        modelo.getVistaVentas().txtArea.setText(modeloP.getDescripcionP());
//        agregarDatosTabla();
    }

    public void agregarDatosTabla(String nombreP, String precio, String cantidad, String subtotal, String total) {

        Object[][] data = {
            {nombreP, precio, cantidad, subtotal, total},};

        String[] nombreColumnas = {"Nombre Producto", "Precio", "Cantidad", "SubTotal", "Total"};
        DefaultTableModel modeloTabla = new DefaultTableModel(data, nombreColumnas);

        agregarTabla(modeloTabla);
    }

    
    //METODOS PARA DEFINIR LA TABLA DENTRO DEL JSCROLL
    public void tableSize(JTable tabla) {
        int rowHeight = tabla.getRowHeight();
        int rowCount = tabla.getRowCount();
        int headerHeight = tabla.getTableHeader().getPreferredSize().height;

        int alturaTotal = (rowHeight * rowCount) + headerHeight;
        tabla.setPreferredScrollableViewportSize(new Dimension(tabla.getPreferredSize().width, alturaTotal));
    }
    
    
    public void agregarTabla(DefaultTableModel modeloTabla){
        JTable nuevaTabla = new JTable(modeloTabla);
        tableSize(nuevaTabla);

        System.out.println(nuevaTabla.getRowCount());

        JScrollPane tableScroll = new JScrollPane(nuevaTabla);
        tableScroll.setBorder(BorderFactory.createTitledBorder("Carrito de Compras" + (modelo.getVistaVentas().jTableProductos.getComponentCount() + 1)));

        modelo.getVistaVentas().jTableProductos.add(tableScroll);
        modelo.getVistaVentas().jTableProductos.revalidate();
        modelo.getVistaVentas().jTableProductos.repaint();
    }
    
    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}
