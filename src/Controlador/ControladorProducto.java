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
            inputIsEmptyBuscarP();
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
            modelo.getVistaProducto().btnEliminar.setBackground(new Color(50, 95, 110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaProducto().btnBuscar)) {
            modelo.getVistaProducto().btnBuscar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnAgregar)) {
            modelo.getVistaProducto().btnAgregar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnActualizar)) {
            modelo.getVistaProducto().btnActualizar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaProducto().btnEliminar)) {
            modelo.getVistaProducto().btnEliminar.setBackground(new Color(75, 128, 146));
        }
    }

    public void inputIsEmptyAgregarP() {
        if (modelo.getVistaProducto().txtNombreProducto.getText().isEmpty()
                || modelo.getVistaProducto().txtCodigoBarras.getText().isEmpty()
                || modelo.getVistaProducto().boxActivo.getSelectedItem() == null
                || modelo.getVistaProducto().boxReceta.getSelectedItem() == null
                || modelo.getVistaProducto().txtDescripcion.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "Por favor debe de ingresar todos los datos", "ERROR \"DATOS VACIOS\"", JOptionPane.ERROR_MESSAGE);
        } else {
            capturaDeDatosAgregarP();
        }
    }

    public void inputIsEmptyBuscarP() {
        if (modelo.getVistaProducto().txtNombreProductoB.getText().isEmpty()
                && modelo.getVistaProducto().txtCodigoBarrasP.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "Por favor debe de ingresar todos los datos", "ERROR \"DATOS VACIOS\"", JOptionPane.ERROR_MESSAGE);
        } else {
            buscarProducto();
        }

    }

    public void capturaDeDatosAgregarP() {

//        ModeloProducto model = new ModeloProducto();
        String nombreIngresado = modelo.getVistaProducto().txtNombreProducto.getText();
        String descripcionIngresada = modelo.getVistaProducto().txtDescripcion.getText();
        String codigoIngresado = modelo.getVistaProducto().txtCodigoBarras.getText();
        String receta = String.valueOf(modelo.getVistaProducto().boxReceta.getSelectedItem());
        String activo = String.valueOf(modelo.getVistaProducto().boxActivo.getSelectedItem());
        registrarProducto(nombreIngresado, descripcionIngresada, codigoIngresado, receta, activo);
        
    }
    
    public void registrarProducto(String nombre, String descripcion, String codigo, String receta, String activo){
        
        boolean recetaIngresada, productoActivo;
        
        if(receta.equals("SI")){
            recetaIngresada = true; 
        } else {
            recetaIngresada = false;
        }
        
        if(activo.equals("SI")){
            productoActivo = true;
        } else {
            productoActivo = false;
        }
        
        
        ModeloProducto modeloRegistroProducto = new ModeloProducto();
        
        modeloRegistroProducto.setNombreOficialP(nombre);
        modeloRegistroProducto.setDescripcionP(descripcion);
        modeloRegistroProducto.setCodigoBarrasP(codigo);
        modeloRegistroProducto.setRequiereRecetaP(recetaIngresada);
        modeloRegistroProducto.setActivoP(productoActivo);
        
        boolean guardarP = implementacion.guardarProducto(modeloRegistroProducto);
        
        notificarProductoGuardado(guardarP);
     
    }
    
   
    public void notificarProductoGuardado(boolean productoGuardado) {

        if (productoGuardado == true) {
            JOptionPane.showInternalMessageDialog(null, "Producto Registrado con éxito", "\"PRODUCTO REGISTRADO\"", JOptionPane.INFORMATION_MESSAGE);
            limpiarDatosAgregarP();
        } else {
            JOptionPane.showInternalMessageDialog(null, "Error al registrar el producto", "\"ERROR EN EL REGISTRO DEL PRODUCTO\"", JOptionPane.ERROR_MESSAGE);
            limpiarDatosAgregarP();
        }

    }

    public void buscarProducto() {

        String nombreB = modelo.getVistaProducto().txtCodigoBarrasP.getText();
        String codigoB = modelo.getVistaProducto().txtNombreProductoB.getText();

        ModeloProducto modeloBuscar = implementacion.mostrarProducto(nombreB, codigoB);
        if (modeloBuscar == null) {
            JOptionPane.showInternalMessageDialog(null, "Producto no encontrado", "\"PRODUCTO NO ENCONTRADO\"", JOptionPane.WARNING_MESSAGE);
        } else {
            agregarDatos(modeloBuscar);
        }

    }

    public void limpiarDatosAgregarP() {
        modelo.getVistaProducto().txtNombreProducto.setText("");
        modelo.getVistaProducto().txtDescripcion.setText("");
        modelo.getVistaProducto().txtCodigoBarras.setText("");
        modelo.getVistaProducto().boxActivo.setSelectedIndex(0);
        modelo.getVistaProducto().boxReceta.setSelectedIndex(0);
    }

    public void limpiarDatos() {

    }

    public void agregarDatos(ModeloProducto modeloB) {

        modelo.getVistaProducto().txtNombreProducto.setText(modeloB.getNombreOficialP());
        modelo.getVistaProducto().txtCodigoBarras.setText(modeloB.getCodigoBarrasP());
        modelo.getVistaProducto().txtDescripcion.setText(modeloB.getDescripcionP());
        modelo.getVistaProducto().txtCodigoBarras.setText(modeloB.getCodigoBarrasP());

        boolean usuarioActivo = modeloB.isActivoP();

        if (usuarioActivo == true) {
            modelo.getVistaProducto().boxActivo.setSelectedIndex(0);
        } else {
            modelo.getVistaProducto().boxActivo.setSelectedIndex(1);
        }

        boolean requiereReceta = modeloB.isRequiereRecetaP();

        if (requiereReceta == true) {
            modelo.getVistaProducto().boxReceta.setSelectedIndex(0);
        } else {
            modelo.getVistaProducto().boxReceta.setSelectedIndex(1);
        }

        modelo.getVistaProducto().txtFechaRegistro.setText(modeloB.getFechaRegistro());

    }

}
