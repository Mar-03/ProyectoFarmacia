package Modelo;

import Vistas.PanelInventario;

public class ModeloInventario {
    
    PanelInventario vistaInventario;

    public ModeloInventario() {
    }

    public ModeloInventario(PanelInventario vistaInventario) {
        this.vistaInventario = vistaInventario;
    }

    public PanelInventario getVistaInventario() {
        return vistaInventario;
    }

    public void setVistaInventario(PanelInventario vistaInventario) {
        this.vistaInventario = vistaInventario;
    }
    
    
}
