/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.PanelRegistroUsuario;

/**
 *
 * @author jhosu
 */
public class ModeloRegistroUsuario {
    
    PanelRegistroUsuario vistaRegistro;
    private String nombreUsuario;
    private String apellidoUsuario;
    private String contraseniaUsuario;
    private int tipoUsuario;
    private String numeroUsuario;
    private String emailUsuario;
    private boolean activoUsuario;
    
    
    
    public ModeloRegistroUsuario() {
    }

    public ModeloRegistroUsuario(PanelRegistroUsuario vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
    }

    public PanelRegistroUsuario getVistaRegistro() {
        return vistaRegistro;
    }

    public void setVistaRegistro(PanelRegistroUsuario vistaRegistro) {
        this.vistaRegistro = vistaRegistro;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getContraseniaUsuario() {
        return contraseniaUsuario;
    }

    public void setContraseniaUsuario(String contraseniaUsuario) {
        this.contraseniaUsuario = contraseniaUsuario;
    }

    public int getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(int tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    public String getNumeroUsuario() {
        return numeroUsuario;
    }

    public void setNumeroUsuario(String numeroUsuario) {
        this.numeroUsuario = numeroUsuario;
    }

    public String getEmailUsuario() {
        return emailUsuario;
    }

    public void setEmailUsuario(String emailUsuario) {
        this.emailUsuario = emailUsuario;
    }

    public boolean isActivoUsuario() {
        return activoUsuario;
    }

    public void setActivoUsuario(boolean activoUsuario) {
        this.activoUsuario = activoUsuario;
    }
    
    
}
