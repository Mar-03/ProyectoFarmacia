package Controlador;

import Modelo.ModeloReporte;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ControladorReportes implements MouseListener {
    private final ModeloReporte modelo;

    public ControladorReportes(ModeloReporte modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == modelo.vista.btnMostrarVentas) {
            modelo.cargarVentasDelDia();
        } 
        else if (e.getSource() == modelo.vista.btnExportarPDF) {
            modelo.generarReportePDF();
        }
    }

    
    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {}
    @Override public void mouseExited(MouseEvent e) {}
}
