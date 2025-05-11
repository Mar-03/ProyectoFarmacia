package Modelo;

import Vistas.VistaInicio;

public class ModeloVistaInicio {
    
    VistaInicio vistaInicio;
    private String usuario;
    private String contrasenia;
    private static int tipoUsuario;
    private static String usuarioEncontrado;
    private static String contraseniaEncontrada;
    private static int idUsuarioEncontrado;

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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public static int getTipoUsuario() {
        return tipoUsuario;
    }

    public static void setTipoUsuario(int tipoUsuario) {
        ModeloVistaInicio.tipoUsuario = tipoUsuario;
    }

    public static String getUsuarioEncontrado() {
        return usuarioEncontrado;
    }

    public static void setUsuarioEncontrado(String usuarioEncontrado) {
        ModeloVistaInicio.usuarioEncontrado = usuarioEncontrado;
    }

    public static String getContraseniaEncontrada() {
        return contraseniaEncontrada;
    }

    public static void setContraseniaEncontrada(String contraseniaEncontrada) {
        ModeloVistaInicio.contraseniaEncontrada = contraseniaEncontrada;
    }

    public static int getIdUsuarioEncontrado() {
        return idUsuarioEncontrado;
    }

    public static void setIdUsuarioEncontrado(int idUsuarioEncontrado) {
        ModeloVistaInicio.idUsuarioEncontrado = idUsuarioEncontrado;
    }
       
    
    
    
}
