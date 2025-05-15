/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Implementacion.VentaImp;
import Modelo.ModeloVenta;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
    
    public void capturaDeDatos(){
        
    }
    
    
    public void limpiarDatos(){
        
    }
    
    
    public void elementosVisibles(){
    
    }
    
}
