/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Implementacion.VentaImp;
import Modelo.ModeloProducto;
import Modelo.ModeloVenta;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
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

    public void capturaDatosBuscarP() {

        String nombreIngresado = modelo.getVistaVentas().txtNombreProducto.getText();
        String codigoIngresadoP = modelo.getVistaVentas().txtCodigoBarras.getText();

        consultarProducto(nombreIngresado, codigoIngresadoP);
        
        
    }

    public void limpiarDatos() {

    }

    public void datosVaciosBuscarP() {

        if (modelo.getVistaVentas().txtNombreProducto.getText().isEmpty() && modelo.getVistaVentas().txtCodigoBarras.getText().isEmpty()) {
            mostrarError("Debe de ingresar al menos el nombre o código del producto");
        } else {
            capturaDatosBuscarP();
        }

    }
    
    public void datosVaciosAgregarP(){
         if (modelo.getVistaVentas().txtNombreProducto.getText().isEmpty() || modelo.getVistaVentas().txtCodigoBarras.getText().isEmpty()) {
            mostrarError("No se pudo agregar el producto, por favor busque un producto para agregarlo");
        } else {
            
        }
    }

    public void elementosVisibles() {

    }

    public void consultarProducto(String nombreP, String codigoB) {

        ModeloVenta modeloV = new ModeloVenta();
        ModeloProducto modeloP = new ModeloProducto();
        
        modeloP = implementacion.buscarProducto(nombreP, codigoB);
        
        modelo.getVistaVentas().txtIdProducto.setText(String.valueOf(modeloP.getIdProducto()));
        modelo.getVistaVentas().txtCodigoBarras.setText(modeloP.getCodigoBarrasP());
        modelo.getVistaVentas().txtNombreProducto.setText(modeloP.getNombreOficialP());
        modelo.getVistaVentas().txtArea.setText(modeloP.getDescripcionP());
//        agregarDatosTabla();

    }

    public void agregarDatosTabla() {

        Object[][] data = {
            {"Aspirina", "5.50", "1", "5.50", "5.50"},};

        String[] nombreColumnas = {"Nombre Producto", "Precio", "Cantidad", "SubTotal", "Total"};
        DefaultTableModel modeloTabla = new DefaultTableModel(data, nombreColumnas);

        modelo.getVistaVentas().jTableProductos.setModel(modeloTabla);
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);

    }

}
