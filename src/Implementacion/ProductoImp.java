package Implementacion;

import Conector.DBConnection;
import Conector.SQL;
import Interfaces.IProducto;
import Modelo.ModeloProducto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
        try {
            ps = conector.preparar(sql.getAGREGAR_PRODUCTO());
            
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
    public boolean actualizarProducto(ModeloProducto modelo) {
        
        return false;
    }

    @Override
    public boolean eliminarProducto(int idProducto) {
    
    
        return false;
    }

    @Override
    public ModeloProducto mostrarProducto(int idProducto) {
        
        ModeloProducto modelo = new ModeloProducto();
        conector.conectar();
        
        try {
            ps = conector.preparar(sql.getCONSULTA_PRODUCTO());
            ps.setInt(1, idProducto);
            
            rs = ps.executeQuery();
            
            while(rs.next()){
                modelo.setIdProducto(rs.getInt("id_producto"));
                modelo.setNombreOficialP(rs.getString("nombre_oficial"));
                modelo.setDescripcionP(rs.getString("descripcion"));
                modelo.setCodigoBarrasP(rs.getString("codigo_barras"));
                modelo.setRequiereRecetaP(rs.getBoolean("activo"));
                modelo.setFechaRegistro(rs.getString("fecha_registro"));
            }
            conector.desconectar();
        } catch (SQLException e) {
            System.out.println("Error al realizar la consulta " + e);
            
        }
        return modelo;
    }
    
}
