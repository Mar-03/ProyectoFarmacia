package controladores;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import modelos.ModeloVistaInicio;
import vista.VistaAdmin;

/**
 *
 * @author jhosu
 */
public class ControladorVistaInicio implements MouseListener{
    
    ModeloVistaInicio modelo;

    public ControladorVistaInicio(ModeloVistaInicio modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getComponent().equals(modelo.getVistaInicio().btnAcceder)){
            VistaAdmin vistaAdmin = new VistaAdmin();
            vistaAdmin.setVisible(true);
            modelo.getVistaInicio().dispose();
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
    
    
    
    
    
}
