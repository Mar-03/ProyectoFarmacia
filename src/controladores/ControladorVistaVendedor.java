package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelos.ModeloVistaVendedor;
import vista.VistaInicio;

/**
 *
 * @author jhosu
 */
public class ControladorVistaVendedor implements MouseListener{
    
    ModeloVistaVendedor modelo;

    public ControladorVistaVendedor(ModeloVistaVendedor modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getComponent().equals(modelo.getVistaVendedor().btnRegresar)){
            VistaInicio vistaInicio = new VistaInicio();
            vistaInicio.setVisible(true);
            modelo.getVistaVendedor().dispose();
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
        if(e.getComponent().equals(modelo.getVistaVendedor().btnRegresar)){
            modelo.getVistaVendedor().btnRegresar.setBackground(new Color(50,95,110));
        } else if (e.getComponent().equals(modelo.getVistaVendedor().btnVentas)){
            modelo.getVistaVendedor().btnVentas.setBackground(new Color(50,95,110));
        } else if (e.getComponent().equals(modelo.getVistaVendedor().btnClientes)){
            modelo.getVistaVendedor().btnClientes.setBackground(new Color(50,95,110));          
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getComponent().equals(modelo.getVistaVendedor().btnRegresar)){
            modelo.getVistaVendedor().btnRegresar.setBackground(new Color(75,128,146));
        } else if (e.getComponent().equals(modelo.getVistaVendedor().btnVentas)){
            modelo.getVistaVendedor().btnVentas.setBackground(new Color(75,128,146));
        } else if (e.getComponent().equals(modelo.getVistaVendedor().btnClientes)){
            modelo.getVistaVendedor().btnClientes.setBackground(new Color(75,128,146));          
        } 
    }
        
       
    
    
    public void mostrarPanel(){
        
    }
    
    
}
