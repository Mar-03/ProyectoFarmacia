package Modelo;

import Vistas.PanelProducto;

public class ModeloProducto {
    
    PanelProducto vistaProducto;
    
    private int idProducto;
    private String nombreOficialP;
    private String descripcionP;
    private String codigoBarrasP;
    private boolean requiereRecetaP;
    private boolean activoP;
    private String fechaRegistro;
   
    
    public ModeloProducto() {
    }

    public ModeloProducto(PanelProducto vistaProducto) {
        this.vistaProducto = vistaProducto;
    }

    public PanelProducto getVistaProducto() {
        return vistaProducto;
    }

    public void setVistaProducto(PanelProducto vistaProducto) {
        this.vistaProducto = vistaProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreOficialP() {
        return nombreOficialP;
    }

    public void setNombreOficialP(String nombreOficialP) {
        this.nombreOficialP = nombreOficialP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getCodigoBarrasP() {
        return codigoBarrasP;
    }

    public void setCodigoBarrasP(String codigoBarrasP) {
        this.codigoBarrasP = codigoBarrasP;
    }

    public boolean isRequiereRecetaP() {
        return requiereRecetaP;
    }

    public void setRequiereRecetaP(boolean requiereRecetaP) {
        this.requiereRecetaP = requiereRecetaP;
    }

    public boolean isActivoP() {
        return activoP;
    }

    public void setActivoP(boolean activoP) {
        this.activoP = activoP;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
    
}
