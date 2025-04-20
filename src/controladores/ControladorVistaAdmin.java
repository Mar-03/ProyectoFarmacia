package controladores;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelos.ModeloVistaAdmin;
import vista.VistaInicio;

public class ControladorVistaAdmin implements MouseListener{
    
    ModeloVistaAdmin modelo;

    public ControladorVistaAdmin(ModeloVistaAdmin modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getComponent().equals(modelo.getVistaAdmin().btnRegresar)){
            VistaInicio vistaInicio = new VistaInicio();
            vistaInicio.setVisible(true);
            modelo.getVistaAdmin().dispose();
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
        if(e.getComponent().equals(modelo.getVistaAdmin().btnRegresar)){
            modelo.getVistaAdmin().btnRegresar.setBackground(new Color(50,95,110));
        } else if(e.getComponent().equals(modelo.getVistaAdmin().btnProductos)){
            modelo.getVistaAdmin().btnProductos.setBackground(new Color(50,95,110));
        } else if (e.getComponent().equals(modelo.getVistaAdmin().btnGestionInventario)){
            modelo.getVistaAdmin().btnGestionInventario.setBackground(new Color(50,95,110));
        } else if (e.getComponent().equals(modelo.getVistaAdmin().btnReportes)){
            modelo.getVistaAdmin().btnReportes.setBackground(new Color(50,95,110));
        } else if (e.getComponent().equals(modelo.getVistaAdmin().btnRegistroUsuarios)){
            modelo.getVistaAdmin().btnReportes.setBackground(new Color(50,95,110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getComponent().equals(modelo.getVistaAdmin().btnRegresar)){
            modelo.getVistaAdmin().btnRegresar.setBackground(new Color(75,128,146));
        } else if(e.getComponent().equals(modelo.getVistaAdmin().btnProductos)){
            modelo.getVistaAdmin().btnProductos.setBackground(new Color(75,128,146));
        } else if (e.getComponent().equals(modelo.getVistaAdmin().btnGestionInventario)){
            modelo.getVistaAdmin().btnGestionInventario.setBackground(new Color(75,128,146));
        } else if (e.getComponent().equals(modelo.getVistaAdmin().btnReportes)){
            modelo.getVistaAdmin().btnReportes.setBackground(new Color(75,128,146));
        } else if (e.getComponent().equals(modelo.getVistaAdmin().btnRegistroUsuarios)){
            modelo.getVistaAdmin().btnRegistroUsuarios.setBackground(new Color(75,128,146));
        }
        
    }
    
    
    public void mostrarPaneles(){
        
    }
    
    
}
