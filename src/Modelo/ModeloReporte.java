package Modelo;

import Vistas.PanelRegistroUsuario;

public class ModeloReporte {

    PanelRegistroUsuario vistaRegistro;

    public ModeloReporte() {
    }

    public ModeloReporte(PanelRegistroUsuario vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
    }

    public PanelRegistroUsuario getVistaRegistro() {
        return vistaRegistro;
    }

    public void setVistaRegistro(PanelRegistroUsuario vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
    }
}
