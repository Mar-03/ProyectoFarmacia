/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Implementacion.ProductoImp;
import Interfaces.Iinventario;
import Modelo.ModeloInventario;
import Modelo.ModeloProducto;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControladorInventario implements MouseListener {

    private JTable tablaInventario;
    private Iinventario inventarioService;
    ModeloInventario modelo;

    ProductoImp implementacion = new ProductoImp();

    public ControladorInventario(ModeloInventario modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() instanceof JTable) {
            cargarLotesEnTabla();
        }
    }

    private void cargarLotesEnTabla() {
        List<ModeloInventario> lotes = inventarioService.mostrarLotesActivos();
        DefaultTableModel modeloTabla = (DefaultTableModel) tablaInventario.getModel();
        modeloTabla.setRowCount(0);

        for (ModeloInventario lote : lotes) {
            modeloTabla.addRow(new Object[]{
                lote.getIdProducto(),
                lote.getNombreProducto(),
                lote.getNumeroLote(),
                lote.getFechaFabricacion(),
                lote.getFechaVencimiento(),
                lote.getCantidadDisponible(),
                lote.getPrecioCompra(),
                lote.getPrecioVenta()
            });
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
