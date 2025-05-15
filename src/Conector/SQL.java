package Conector;

/**
 *
 * @author jhosu
 */
public class SQL {

    //DOCUMENTO PARA HACER LAS CONSULTAS A LA BASE DE DATOS
    //CONSULTAS PARA USUARIOS
    private final String CONSULTA_USUARIO = "SELECT id_usuario, usuario, contrasena, tipo_usuario FROM usuarios WHERE usuario = ?";

    //CONSULTAS PARA PRODUCTOS
    private final String AGREGAR_PRODUCTO = "INSERT INTO productos (nombre_oficial, descripcion, codigo_barras, requiere_receta, activo) VALUES (?,?,?,?,?)";
    private final String CONSULTA_PRODUCTO = "SELECT id_producto, nombre_oficial, descripcion, codigo_barras, requiere_receta, activo FROM productos WHERE id_producto = ?";
    private final String ELIMINAR_PRODUCTO = "DELETE FROM ProductoS WHERE id_producto = ?";
    private final String ACTUALIZAR_PRODUCTO = "UPDATE productos SET nombre_oficial = ?,descripcion = ?,codigo_barras = ?,requiere_receta = ?,activo = ?,WHERE id_producto = ?";
    // COSULRA PARA CLIENTES USUSARIOS
    

    private final String INSERT = 
        "INSERT INTO clientes (nombre, apellido, telefono, nit, direccion, identificacion, subsidio, fecha) " +
        "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

    private  final String UPDATE = 
        "UPDATE clientes SET nombre=?, apellido=?, telefono=?, nit=?, direccion=?, identificacion=?, " +
        "subsidio=?, fecha=? WHERE id_cliente=?";

    private final String DELETE = 
        "DELETE FROM clientes WHERE id_cliente=?";

    private final String SELECT_ALL = 
        "SELECT * FROM clientes";

    private final String SELECT_BY_ID = 
        "SELECT * FROM clientes WHERE id_cliente=?";

    private final String SELECT_BY_PARAMS = 
        "SELECT * FROM clientes WHERE nombre LIKE ? AND apellido LIKE ? AND telefono = ? " +
        "AND direccion LIKE ? AND identificacion = ? AND nit LIKE ? AND subsidio LIKE ? AND fecha LIKE ?";

     //CONSULTA PARA LOS USUARIOS
    private final String AGREGAR_USUARIO = "INSERT INTO usuarios (nombre, apellido, telefono, email, usuario, contrasena, tipo_usuario, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    
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

    public String getAGREGAR_USUARIO() {
        return AGREGAR_USUARIO;
    }
     public String getAtualizar_USUARIO() {
        return AGREGAR_USUARIO;
    }
     public String geteiminar_USUARIO() {
        return AGREGAR_USUARIO;
    }
}
