package Conector;

/**
 *
 * @author jhosu
 */
public class SQL {
    
    //DOCUMENTO PARA HACER LAS CONSULTAS A LA BASE DE DATOS
    //CONSULTAS PARA USUARIOS
    private final String CONSULTA_USUARIO = "SELECT id_usuario, nombre, contrasena, tipo_usuario FROM usuarios WHERE nombre = ?";
    
    //CONSULTAS PARA PRODUCTOS
    private final String AGREGAR_PRODUCTO = "INSERT INTO productos (nombre_oficial, descripcion, codigo_barras, requiere_receta) VALUES (?,?,?,?)";
    private final String CONSULTA_PRODUCTO = "SELECT id_producto, nombre_oficial, descripcion, codigo_barras, requiere_receta, activo FROM productos WHERE id_producto = ?";
    private final String ELIMINAR_PRODUCTO = "DELETE FROM ProductoS WHERE id_producto = ?";
    private final String ACTUALIZAR_PRODUCTO = "UPDATE productos SET nombre_oficial = ?,descripcion = ?,codigo_barras = ?,requiere_receta = ?,activo = ?,WHERE id_producto = ?";
    
    
    
    
    public SQL() {
    }

    public String getCONSULTA_USUARIO() {
        return CONSULTA_USUARIO;
    }

    public String getAGREGAR_PRODUCTO() {
        return AGREGAR_PRODUCTO;
    }

    public String getCONSULTA_PRODUCTO() {
        return CONSULTA_PRODUCTO;
    }

    public String getELIMINAR_PRODUCTO() {
        return ELIMINAR_PRODUCTO;
    }

    public String getACTUALIZAR_PRODUCTO() {
        return ACTUALIZAR_PRODUCTO;
    }
    
    
    
}
