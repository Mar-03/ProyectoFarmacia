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
    private final String AGREGAR_LOTE_PRODUCTO = "INSERT INTO lotes (id_producto, numero_lote, fecha_vencimiento, fecha_fabricacion, cantidad_disponible, precio_compra, precio_venta, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String AGREGAR_NOMBRE_ALTERNATIVO = "INSERT INTO nombres_alternativos (id_producto, nombre_alternativo) VALUES (?, ?)";
    
    
    //Metodos de productos (posible actualización de más funcionalidades)
    private final String CONSULTA_PRODUCTO_NOMBRE = "SELECT id_producto, nombre_oficial, descripcion, codigo_barras, requiere_receta, activo FROM productos WHERE nombre_oficial LIKE '%?%'";
    private final String ELIMINAR_PRODUCTO = "DELETE FROM ProductoS WHERE id_producto = ?";
    private final String ACTUALIZAR_PRODUCTO = "UPDATE productos SET nombre_oficial = ?,descripcion = ?,codigo_barras = ?,requiere_receta = ?,activo = ?,WHERE id_producto = ?";
    private final String CONSULTA_PRODUCTO_CODIGO = "SELECT id_producto, nombre_oficial, descripcion, codigo_barras, requiere_receta, activo FROM productos WHERE codigo_barras = ?;";
    

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
    
    //CONSULTA PARA LAS VENTAS
    private final String HACER_VENTA ="INSERT INTO ventas (id_usuario, id_cliente, id_institucion_subsidio, subtotal, descuento_subsidio, total, tipo_pago, con_subsidio, observaciones) VALUES (?,?,?,?,?,?,?,?,?)";
    private final String BUSCAR_PRODUCTOS ="";
    private final String DETALLE_VENTAS ="";
    private final String GENERAR_COMPROBANTE = "";
    
    public String getCONSULTA_USUARIO() {
        return CONSULTA_USUARIO;
    }

    public String getAGREGAR_PRODUCTO() {
        return AGREGAR_PRODUCTO;
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

    public String getHACER_VENTA() {
        return HACER_VENTA;
    }

    public String getBUSCAR_PRODUCTOS() {
        return BUSCAR_PRODUCTOS;
    }

    public String getDETALLE_VENTAS() {
        return DETALLE_VENTAS;
    }

    public String getGENERAR_COMPROBANTE() {
        return GENERAR_COMPROBANTE;
    }

    public String getCONSULTA_PRODUCTO_NOMBRE() {
        return CONSULTA_PRODUCTO_NOMBRE;
    }

    public String getCONSULTA_PRODUCTO_CODIGO() {
        return CONSULTA_PRODUCTO_CODIGO;
    }

    public String getAGREGAR_LOTE_PRODUCTO() {
        return AGREGAR_LOTE_PRODUCTO;
    }

    public String getAGREGAR_NOMBRE_ALTERNATIVO() {
        return AGREGAR_NOMBRE_ALTERNATIVO;
    }
       
}
