package Implementacion;

import Conector.DBConnection;
import Conector.SQL;
import Interfaces.IProducto;
import Modelo.ModeloProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author jhosu
 */
public class ProductoImp implements IProducto {

    DBConnection conector = new DBConnection();
    SQL sql = new SQL();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean guardarProducto(ModeloProducto modelo) {
        boolean resultado = false;
        conector.conectar();
        System.out.println("Hola desde implementacion");
        
        try {
            ps = conector.preparar(sql.getAGREGAR_PRODUCTO());
 System.out.println("nombre " + modelo.getNombreOficialP());
            System.out.println("descripcion " + modelo.getDescripcionP());
            ps.setString(1, modelo.getNombreOficialP());
            ps.setString(2, modelo.getDescripcionP());
            ps.setString(3, modelo.getCodigoBarrasP());
            ps.setBoolean(4, modelo.isRequiereRecetaP());
            ps.setBoolean(5, modelo.isActivoP());

            int filasAfectadas = ps.executeUpdate();
            resultado = (filasAfectadas > 0);

        } catch (SQLException e) {
            System.out.println("Error al en Imp guardarP" + e);
            resultado = false;
        }
        System.out.println(resultado);
        return resultado;
    }

    @Override
    public boolean actualizarProducto(ModeloProducto modelo) {

        boolean resultado = false;
        conector.conectar();

        try {
            ps = conector.preparar(sql.getACTUALIZAR_PRODUCTO());
            ps.setString(1, modelo.getNombreOficialP());
            ps.setString(2, modelo.getDescripcionP());
            ps.setString(3, modelo.getCodigoBarrasP());
            ps.setBoolean(4, modelo.isRequiereRecetaP());
            ps.setBoolean(5, modelo.isActivoP());

            int filasAfectadas = ps.executeUpdate();
            resultado = (filasAfectadas > 0);

        } catch (SQLException e) {
            resultado = false;
        }
        return resultado;
    }

    @Override
    public boolean eliminarProducto(int idProducto) {

        boolean resultado = false;
        PreparedStatement ps = null;

        try {
            conector.conectar();
            ps = conector.preparar(sql.getELIMINAR_PRODUCTO());

            ps.setInt(1, idProducto);

            int filasAfectadas = ps.executeUpdate();
            resultado = (filasAfectadas > 0);

        } catch (SQLException e) {
            resultado = false;
            System.out.println("No se puedo eliminar el producto Mimp(eliminarProducto) " + e);

        } finally {

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                }
            }
            if (conector != null) {
                conector.desconectar();
            }
        }
        return resultado;
    }

//    @Override
//    public ModeloProducto mostrarProducto(int idProducto) {
//
//        ModeloProducto modelo = new ModeloProducto();
//        conector.conectar();
//
//        try {
//            ps = conector.preparar(sql.getCONSULTA_PRODUCTO_NOMBRE());
//            ps.setInt(1, idProducto);
//
//            rs = ps.executeQuery();
//
//            while (rs.next()) {
//                modelo.setIdProducto(rs.getInt("id_producto"));
//                modelo.setNombreOficialP(rs.getString("nombre_oficial"));
//                modelo.setDescripcionP(rs.getString("descripcion"));
//                modelo.setCodigoBarrasP(rs.getString("codigo_barras"));
//                modelo.setRequiereRecetaP(rs.getBoolean("activo"));
//                modelo.setFechaRegistro(rs.getString("fecha_registro"));
//            }
//            conector.desconectar();
//        } catch (SQLException e) {
//            System.out.println("Error al realizar la consulta " + e);
//        }
//        return modelo;
//    }
    @Override
    public ModeloProducto mostrarProducto(String nombreP, String codigoP) {

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
                ps.setString(1, "%" + nombreP + "%");
            } else {
                ps.setString(1, codigoP);
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
                    modelo.setFechaRegistro(rs.getString("fecha_registro"));
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

//while (rs.next()) {
//                modelo.setIdProducto(rs.getInt("id_producto"));
//                modelo.setNombreOficialP(rs.getString("nombre_oficial"));
//                modelo.setDescripcionP(rs.getString("descripcion"));
//                modelo.setCodigoBarrasP(rs.getString("codigo_barras"));
//                modelo.setRequiereRecetaP(rs.getBoolean("activo"));
//                modelo.setFechaRegistro(rs.getString("fecha_registro"));
//            }
