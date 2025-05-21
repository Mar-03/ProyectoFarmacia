package Implementacion;

import Conector.DBConnection;
import Conector.SQL;
import Interfaces.IVenta;
import Modelo.ModeloProducto;
import Modelo.ModeloVenta;
import Modelo.ModeloVistaInicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jhosu
 */
public class VentaImp implements IVenta{
    
    DBConnection conector = new DBConnection();
    SQL sql = new SQL();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean hacerVenta(ModeloVenta modelo) {
        
        boolean resultado = true;
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String fechaFormateada = LocalDateTime.now().format(formatter);
        
        conector.conectar();
        try {
            ps = conector.preparar(sql.getHACER_VENTA());
            ps.setInt(1, 1);
            ps.setInt(2, 0);
            ps.setString(3,fechaFormateada);
            ps.setBigDecimal(4, modelo.getSubTotal());
            ps.setBigDecimal(5, modelo.getDescuento());
            ps.setBigDecimal(6, modelo.getTotal());
            ps.setString(7, modelo.getTipoPago());
            ps.setBoolean(8, modelo.isSubsidio());
            ps.setString(9, modelo.getInstitucion());
            ps.setString(10, modelo.getObservaciones());
            
        } catch (Exception e) {
        }
        return resultado;
    }

    @Override
    public boolean guardarDetalleVenta(ModeloVenta modelo) {
        
        conector.conectar();
        boolean resultado = false;
        
        try {
            ps = conector.preparar(sql.getINSERTAR_DETALLE_VENTA());
            ps.setInt(1, 0);
            
        } catch (Exception e) {
        }
        
        return resultado;
    }

    @Override
    public ModeloProducto buscarProducto(String nombreP, String codigoB) {
    
    //CAMBIAR EL MODELO
        ModeloProducto modelo = null;
        String sqlEjecutar;
        boolean buscarPorNombre = !nombreP.isEmpty();

        if (buscarPorNombre) {
            sqlEjecutar = sql.getCONSULTA_PRODUCTO_NOMBRE();
        } else {
            sqlEjecutar = sql.getCONSULTA_PRODUCTO_CODIGO();
        }

        conector.conectar();

        try {
            ps = conector.preparar(sqlEjecutar);

            if (buscarPorNombre) {
                ps.setString(1,  nombreP );
            } else {
                ps.setString(1, codigoB);
            }

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    modelo = new ModeloProducto();
                    modelo.setIdProducto(rs.getInt("id_producto"));
                    modelo.setNombreOficialP(rs.getString("nombre_oficial"));
                    modelo.setDescripcionP(rs.getString("descripcion"));
                    modelo.setCodigoBarrasP(rs.getString("codigo_barras"));
                    modelo.setRequiereRecetaP(rs.getBoolean("requiere_receta")); // Corregido
                    modelo.setActivoP(rs.getBoolean("activo")); // Añadido si existe
//                    modelo.setFechaRegistro(rs.getString("fecha_registro"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductoImp.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProductoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conector.desconectar();
        }
        return modelo;
    
    }

    
    
    
}
