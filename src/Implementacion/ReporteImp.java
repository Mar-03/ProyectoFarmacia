/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacion;

import Conector.DBConnection;
import Interfaces.IReportes;
import Utilities.GeneradorPDFreporte;
import Vistas.VistaReporte;
import com.mysql.cj.xdevapi.Statement;

/**
 *
 * @author jhosu
 */
import Conector.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
 public class ReporteImp implements IReportes {
    private final DBConnection conector = new DBConnection();
    
    @Override
    public ResultSet obtenerRegistroVentasDelDia() throws SQLException {
        Connection con = conector.conectar().getConnection();
        String query = "SELECT v.id_venta, DATE_FORMAT(v.fecha, '%d/%m/%Y %H:%i') AS fecha, "
                + "CONCAT(c.nombre, ' ', c.apellido) AS cliente, v.subtotal, "
                + "v.descuento_subsidio AS descuento, v.total, v.tipo_pago "
                + "FROM ventas v "
                + "JOIN clientes c ON v.id_cliente = c.id_cliente "
                + "WHERE DATE(v.fecha) = CURDATE() "
                + "ORDER BY v.fecha DESC";
        
        return con.prepareStatement(query).executeQuery();
    }

}