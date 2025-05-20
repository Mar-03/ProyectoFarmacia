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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhosu
 */
public class ControladorVentas implements MouseListener{

    ModeloVenta modelo;

    public ControladorVentas(ModeloVenta modelo) {
        this.modelo = modelo;
    }
    
    VentaImp implementacion = new VentaImp();
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().equals(modelo.getVistaVentas().btnAgregar)){
            
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)){
           capturaDatosBuscarP(); 
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
    
    
    public void capturaDatosBuscarP(){
        
       String nombreIngresado = modelo.getVistaVentas().txtNombreProducto.getText();
       String codigoIngresadoP = modelo.getVistaVentas().txtCodigoBarras.getText();
       
        consultarProducto(nombreIngresado, codigoIngresadoP);
    }
    
    
    public void limpiarDatos(){
        
    }
    
    
    public void elementosVisibles(){
    
    }
    
    public void consultarProducto(String nombreP, String codigoB){
        
       implementacion.buscarProducto(nombreP, codigoB);
       ModeloVenta modeloV = new ModeloVenta();
       ModeloProducto modeloP = new ModeloProducto();
       
       modeloV.getVistaVentas().txtIdProducto.setText(String.valueOf(modeloP.getIdProducto()));
       
       agregarDatosTabla();
        
    }
    
    public void agregarDatosTabla(){
        
        Object[][] data = {
            {"Aspirina", "5.50", "1", "5.50", "5.50"},
        };
        
        
        String[] nombreColumnas = {"Nombre Producto", "Precio", "Cantidad", "SubTotal", "Total"};
        DefaultTableModel modeloTabla = new DefaultTableModel(data, nombreColumnas);
        
        modelo.getVistaVentas().jTableProductos.setModel(modeloTabla);
    }
    
}
