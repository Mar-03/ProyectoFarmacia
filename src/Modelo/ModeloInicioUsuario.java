package Modelo;

/**
 *
 * @author jhosu
 */
public class ModeloInicioUsuario {
    
    private static String usuarioActivo;

    public static void setUsuarioActual(String usuario){
        usuarioActivo = usuario;
    }

    public static String getUsuarioActivo() {
        return usuarioActivo;
    }
      
}
