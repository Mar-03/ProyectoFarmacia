package Modelo;

import Conector.DBConnection;
import Implementacion.ReporteImp;
import Interfaces.IReportes;
import Utilities.GeneradorPDFreporte;
import Vistas.VistaReporte;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSetMetaData; 

public class ModeloReporte {
    private VistaReporte vista;
    private IReportes reportes;
    private Connection conexion;
    private int idUsuario;

    public ModeloReporte(VistaReporte vista) {
        this.vista = vista;

        DBConnection conector = new DBConnection();
        conector.conectar();
        this.conexion = conector.getConexion();

        this.reportes = new ReporteImp(conexion);
        this.idUsuario = 1; 
    }

    public void cargarVentasDelDia() {
        try {
            ResultSet rs = reportes.obtenerVentasDelDia(idUsuario);
            actualizarTabla(rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar ventas del día: " + ex.getMessage());
        }
    }

    public void generarPDFVentasDelDia() {
        try {
            GeneradorPDFreporte pdf = new GeneradorPDFreporte();
            String ruta = "ReporteVentasDelDia_" + System.currentTimeMillis() + ".pdf";
            pdf.generarReporteDia(vista.tblReportesVentas, ruta, idUsuario);
            JOptionPane.showMessageDialog(vista, "¡PDF generado exitosamente!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(vista, "Error al generar PDF: " + ex.getMessage());
        }
    }

    private void actualizarTabla(ResultSet rs) throws SQLException {
        DefaultTableModel model = new DefaultTableModel();
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        for (int i = 1; i <= columnCount; i++) {
            model.addColumn(metaData.getColumnName(i));
        }

        while (rs.next()) {
            Object[] row = new Object[columnCount];
            for (int i = 1; i <= columnCount; i++) {
                row[i - 1] = rs.getObject(i);
            }
            model.addRow(row);
        }

        vista.tblReportesVentas.setModel(model);
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
}