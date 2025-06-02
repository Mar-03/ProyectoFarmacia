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
private final IReportes reportes;
    public final VistaReporte vista;

    public ModeloReporte(VistaReporte vista) {
        this.vista = vista;
        this.reportes = new ReporteImp();
    }

    public void cargarVentasDelDiaEnTabla() {
        try {
            ResultSet rs = reportes.obtenerVentasDelDia();
            actualizarTabla(rs);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar reportes: " + ex.getMessage());
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

   /* public void generarReportePDF() {
        try {
            String carpetaBase = System.getProperty("user.home") + File.separator + "ReportesFarmacia" + File.separator;
            new File(carpetaBase).mkdirs();
            
            String nombreArchivo = "VentasDiarias_" + 
                                  new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + 
                                  ".pdf";
            String rutaCompleta = carpetaBase + nombreArchivo;
          
            generadorPDF.generarReporteDia(vista.tblReportesVentas, rutaCompleta);
            
            registrarReporteEnBD(rutaCompleta, nombreArchivo);
            
            JOptionPane.showMessageDialog(vista, "Reporte generado en:\n" + rutaCompleta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(vista, "Error al generar PDF: " + e.getMessage());
            e.printStackTrace();
        }
    }

  */
}
