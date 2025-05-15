package Implementacion;

import Conector.DBConnection;
import Conector.SQL;
import Interfaces.IVenta;
import Modelo.ModeloVenta;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
        
        conector.conectar();
        try {
            ps = conector.preparar(sql.getHACER_VENTA());
        } catch (Exception e) {
        }
        return resultado;
    }

    @Override
    public ModeloVenta buscarProducto(String nombreP) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
