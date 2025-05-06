package Conector;

/**
 *
 * @author jhosu
 */
public class SQL {
    
    //DOCUMENTO PARA HACER LAS CONSULTAS A LA BASE DE DATOS
    private final String CONSULTA_USUARIO = "SELECT id_usuario, nombre_usuario, contrasenia_usuario, tipo_usuario FROM Usuario WHERE nombre_usuario = ?";

    public SQL() {
    }

    public String getCONSULTA_USUARIO() {
        return CONSULTA_USUARIO;
    }
    
}
