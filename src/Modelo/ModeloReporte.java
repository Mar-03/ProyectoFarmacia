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
    public VistaReporte vista;
    private final GeneradorPDFreporte generadorPDF = new GeneradorPDFreporte();

    public ModeloReporte(VistaReporte vista) {
        this.vista = vista;
        this.reportes = new ReporteImp();
    }

    public void cargarVentasDelDia() {
        DefaultTableModel modelo = (DefaultTableModel) vista.tblReportesVentas.getModel();
        modelo.setRowCount(0);
        
        try (ResultSet rs = reportes.obtenerRegistroVentasDelDia()) {
            while (rs.next()) {
                modelo.addRow(new Object[]{
                    rs.getInt("id_venta"),
                    rs.getString("fecha"),
                    rs.getString("cliente"),
                    rs.getDouble("subtotal"),
                    rs.getDouble("descuento"),
                    rs.getDouble("total"),
                    rs.getString("tipo_pago")
                });
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista, "Error al cargar ventas: " + ex.getMessage());
        }
    }

    public void generarReportePDF() {
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

    private void registrarReporteEnBD(String ruta, String nombreArchivo) {
        try (Connection conexion = DBConnection.conectar().getConnection()) {
            String query = "INSERT INTO reportes (tipo_reporte, parametros, nombre_archivo, ruta_archivo) "
                         + "VALUES (?, ?, ?, ?)";
            
            try (PreparedStatement ps = conexion.prepareStatement(query)) {
                ps.setString(1, "VENTAS_DIARIAS");
                ps.setString(2, "Reporte diario automático");
                ps.setString(3, nombreArchivo);
                ps.setString(4, ruta);
                ps.executeUpdate();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(vista, "Error al registrar reporte: " + ex.getMessage());
        }
    }}
