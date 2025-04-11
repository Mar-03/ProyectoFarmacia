package modelos;

import vista.VistaInicio;

public class ModeloVistaInicio {
    
    VistaInicio vistaInicio;

    public ModeloVistaInicio() {
    }
    
    
    public ModeloVistaInicio(VistaInicio vistaInicio) {
        this.vistaInicio = vistaInicio;
    }

    public VistaInicio getVistaInicio() {
        return vistaInicio;
    }

    public void setVistaInicio(VistaInicio vistaInicio) {
        this.vistaInicio = vistaInicio;
    }
        
}
