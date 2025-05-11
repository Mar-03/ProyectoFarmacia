package Controlador;

import Implementacion.SesionInicioImp;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.ModeloVistaInicio;
import Vistas.VistaAdmin;
import Vistas.VistaVendedor;

/**
 *
 * @author jhosu
 */
public class ControladorVistaInicio implements MouseListener{
    
    ModeloVistaInicio modelo;

    public ControladorVistaInicio(ModeloVistaInicio modelo) {
        this.modelo = modelo;
    }

    SesionInicioImp implementacion = new SesionInicioImp();
    
    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().equals(modelo.getVistaInicio().btnAcceder)){
            if(tipoUsuario() == 1){
            VistaAdmin vistaAdmin = new VistaAdmin();
            vistaAdmin.setVisible(true);
            modelo.getVistaInicio().dispose();    
            } else if(tipoUsuario() == 2){
                VistaVendedor vistaVendedor = new VistaVendedor();
                vistaVendedor.setVisible(true);
                modelo.getVistaInicio().dispose();
            }
            
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
    
        if(e.getComponent().equals(modelo.getVistaInicio().btnAcceder)){
            modelo.getVistaInicio().btnAcceder.setBackground(new Color(50,95,110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        
        if(e.getComponent().equals(modelo.getVistaInicio().btnAcceder)){
            modelo.getVistaInicio().btnAcceder.setBackground(new Color(75,128,146));
        }
    }
      
    public int tipoUsuario(){
        
        int usuarioIngresado = Integer.parseInt((modelo.getVistaInicio().txtUsuario.getText()));
        
        return usuarioIngresado;
    }
    
    
    
}
