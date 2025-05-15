package Controlador;

import Implementacion.ProductoImp;
import Modelo.ModeloProducto;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ControladorProducto implements MouseListener {

    ModeloProducto modelo;
    
    ProductoImp implementacion = new ProductoImp();

    public ControladorProducto(ModeloProducto modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaProducto().btnBuscar)) {

        } else if (e.getComponent().equals(modelo.getVistaProducto().btnAgregar)) {
            inputIsEmptyAgregarP();
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnActualizar)) {
            
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnEliminar)) {
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
        if (e.getComponent().equals(modelo.getVistaProducto().btnBuscar)) {
            modelo.getVistaProducto().btnBuscar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnAgregar)) {
            modelo.getVistaProducto().btnAgregar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnActualizar)) {
            modelo.getVistaProducto().btnActualizar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnEliminar)) {
            modelo.getVistaProducto().btnActualizar.setBackground(new Color(50, 95, 110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaProducto().btnBuscar)) {
            modelo.getVistaProducto().btnBuscar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnAgregar)) {
            modelo.getVistaProducto().btnBuscar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnActualizar)) {
            modelo.getVistaProducto().btnBuscar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnEliminar)) {
            modelo.getVistaProducto().btnBuscar.setBackground(new Color(75, 128, 146));
        }
    }

    public void inputIsEmptyAgregarP() {
        if (modelo.getVistaProducto().txtNombreProducto.getText().isEmpty()
                || modelo.getVistaProducto().txtCantidad.getText().isEmpty()
                || modelo.getVistaProducto().txtCodigoBarras.getText().isEmpty()
                || modelo.getVistaProducto().txtFechaRegistro.getText().isEmpty()
                || modelo.getVistaProducto().txtPrecioInicial.getText().isEmpty()
                || modelo.getVistaProducto().txtActivo.getText().isEmpty()
                || modelo.getVistaProducto().txtCantidad.getText().isEmpty()
                || modelo.getVistaProducto().txtPrecioNuevo.getText().isEmpty()
                || modelo.getVistaProducto().txtDescripcion.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "Por favor debe de ingresar todos los datos", "ERROR \"DATOS VACIOS\"", JOptionPane.ERROR_MESSAGE);
        } else {
            capturaDeDatosAgregarP();
        }
    }

    /*
        modelo.getVistaProducto().txtNombreProducto.getText().isEmpty()
                || modelo.getVistaProducto().txtCantidad.getText().isEmpty()
                || modelo.getVistaProducto().txtCodigoBarras.getText().isEmpty()
                || modelo.getVistaProducto().txtFechaRegistro.getText().isEmpty()
                || modelo.getVistaProducto().txtPrecioInicial.getText().isEmpty()
                || modelo.getVistaProducto().txtActivo.getText().isEmpty()
                || modelo.getVistaProducto().txtCantidad.getText().isEmpty()
                || modelo.getVistaProducto().txtPrecioNuevo.getText()
     */
    public void capturaDeDatosAgregarP() {
        
        ModeloProducto model = new ModeloProducto();

        String nombreIngresadoP = model.getVistaProducto().txtNombreProducto.getText();
        String descripcionIngresadaP = model.getVistaProducto().txtDescripcion.getText();
        String codigoBarrasP = model.getVistaProducto().txtCodigoBarras.getText();
        String receta = String.valueOf(model.getVistaProducto().boxReceta.getSelectedItem());
        String fechaRegistroP = model.getVistaProducto().txtFechaRegistro.getText();
        String precioInicialP = model.getVistaProducto().txtPrecioInicial.getText();
         String productoActivo = String.valueOf(model.getVistaProducto().boxActivo.getSelectedItem());
        String cantidadStockP = model.getVistaProducto().txtCantidad.getText();
//        String precioNuevoP =  modelo.getVistaProducto().txtPrecioNuevo.getText();

        implementacion.guardarProducto(model);
    }
}
