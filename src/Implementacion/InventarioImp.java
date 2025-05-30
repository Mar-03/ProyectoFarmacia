package Implementacion;

import Conector.DBConnection;
import Interfaces.*;
import Conector.SQL;
import Modelo.ModeloInventario;
import Modelo.ModeloProducto;
import java.sql.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class InventarioImp implements Iinventario {

    private DBConnection conector = new DBConnection();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
public List<ModeloInventario> mostrarLotesActivos() {
    List<ModeloInventario> lotes = new ArrayList<>();
    String sql = "SELECT l.*, p.nombre_oficial AS nombre_producto "
               + "FROM lotes l "
               + "INNER JOIN productos p ON l.id_producto = p.id_producto "
               + "WHERE l.activo = true";

    try (Connection conn = conector.conectar();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            ModeloInventario lote = new ModeloInventario();
            lote.setIdLote(rs.getInt("id_lote"));
            lote.setIdProducto(rs.getInt("id_producto"));
            lote.setNumeroLote(rs.getString("numero_lote"));
            lote.setFechaVencimiento(rs.getDate("fecha_vencimiento"));
            lote.setFechaFabricacion(rs.getDate("fecha_fabricacion"));
            lote.setCantidadDisponible(rs.getInt("cantidad_disponible"));
            lote.setPrecioCompra(rs.getBigDecimal("precio_compra"));
            lote.setPrecioVenta(rs.getBigDecimal("precio_venta"));
            lote.setActivo(rs.getBoolean("activo"));
            lote.setNombreProducto(rs.getString("nombre_producto"));
            lotes.add(lote);
        }

    } catch (SQLException e) {
        System.err.println("Error al mostrar los lotes activos: " + e.getMessage());
    }

    return lotes;
}

}
