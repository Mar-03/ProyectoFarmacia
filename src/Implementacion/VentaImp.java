package Implementacion;

import Conector.DBConnection;
import Conector.SQL;
import Interfaces.IVenta;
import Modelo.ModeloClientesVentas;
import Modelo.ModeloProducto;
import Modelo.ModeloRegistroCliente;
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
public class VentaImp implements IVenta {

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
            ps.setString(3, fechaFormateada);
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

        System.out.println("HOLA DESDE IMP");
        ModeloProducto modelo = null;
        String sqlEjecutar;
        boolean buscarPorNombre = !nombreP.isEmpty();

        if (buscarPorNombre) {
            sqlEjecutar = sql.getBUSCAR_PRODUCTOS_NOMBRES();
        } else {
            sqlEjecutar = sql.getBUSCAR_PRODUCTO_CODIGO();
        }

        conector.conectar();

        try {
            ps = conector.preparar(sqlEjecutar);

            if (buscarPorNombre) {
                ps.setString(1, "%" + nombreP + "%");
                ps.setString(2, "%" + nombreP + "%");
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
                    modelo.setPrecioVenta(rs.getBigDecimal("precio"));
                    modelo.setCantidadDisponible(rs.getInt("cantidad_disponible"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProductoImp.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProductoImp.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            conector.desconectar();
        }
        System.out.println("Nombre " + modelo.getNombreOficialP());
        return modelo;
    }

    public ModeloClientesVentas consultarCliente(String criterioNitId) {

        ModeloClientesVentas modelo = null;

        conector.conectar();

        try {
            ps = conector.preparar(sql.getBUSCAR_CLIENTE_NIT_IDENTIFICACION());
            ps.setString(1, criterioNitId);
            ps.setString(2, criterioNitId);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    modelo = new ModeloClientesVentas();
                    modelo.setIdCliente(rs.getInt("id_cliente"));
                    modelo.setNombre(rs.getString("nombre"));
                    modelo.setApellido(rs.getString("apellido"));
                    modelo.setDireccion(rs.getString("direccion"));
                    modelo.setNit(rs.getString("nit"));
                    modelo.setIdentificacion(rs.getString("identificacion"));
                    modelo.setTelefono(rs.getString("telefono"));
                    modelo.setTieneSubsidio(rs.getBoolean("tiene_subsidio"));

                    int idInstitucion = rs.getInt("id_institucion_subsidio");
                    if (!rs.wasNull()) {
                        modelo.setIdInstitucionSubsidio(idInstitucion);
                    }
                }
            } catch (Exception e) {
                Logger.getLogger(this.getClass().getName()).log(
                        Level.SEVERE,
                        "Error al procesar resultados de la consulta para cliente: " + criterioNitId,
                        e
                );
            }

        } catch (SQLException e) {
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                conector.desconectar();
            } catch (SQLException e) {

                Logger.getLogger(this.getClass().getName()).log(
                        Level.WARNING,
                        "Error al cerrar recursos de conexión",
                        e
                );

            }
        }

        return modelo;
    }
}
