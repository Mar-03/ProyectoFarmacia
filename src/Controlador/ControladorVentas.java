/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Implementacion.VentaImp;
import Modelo.ModeloProducto;
import Modelo.ModeloVenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhosu
 */
public class ControladorVentas implements MouseListener {

    ModeloVenta modelo;

    public ControladorVentas(ModeloVenta modelo) {
        this.modelo = modelo;
    }

    VentaImp implementacion = new VentaImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaVentas().btnAgregar)) {
            datosVaciosAgregarP();
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)) {
            datosVaciosBuscarP();
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnEliminar)) {

        } else if (e.getComponent().equals(modelo.getVistaVentas().btnHacerVenta)) {

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
        if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)) {
            modelo.getVistaVentas().btnBuscar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnAgregar)) {
            modelo.getVistaVentas().btnAgregar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnEliminar)) {
            modelo.getVistaVentas().btnEliminar.setBackground(new Color(50, 95, 110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)) {
            modelo.getVistaVentas().btnBuscar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnAgregar)) {
            modelo.getVistaVentas().btnAgregar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnEliminar)) {
            modelo.getVistaVentas().btnEliminar.setBackground(new Color(75, 128, 146));
        }
    }

    private void capturaDatosBuscarP() {
        String nombreIngresado = modelo.getVistaVentas().txtNombreProducto.getText();
        String codigoIngresadoP = modelo.getVistaVentas().txtCodigoBarras.getText();

        consultarProducto(nombreIngresado, codigoIngresadoP);
    }

    private void capturaDatosAgregarP() {

        String nombreP = modelo.getVistaVentas().txtNombreProducto.getText();
        String precioP = modelo.getVistaVentas().txtPrecio.getText();
        String cantidadIngresada = modelo.getVistaVentas().txtCantidad.getText();
        String descuentoSubsidio = modelo.getVistaVentas().txtDescuentoSubsidio.getText();
        String subtotal = calcularPrecioP(precioP, descuentoSubsidio);
        String precioTotal = calcularTotal(subtotal,cantidadIngresada);
        agregarDatosTabla(nombreP, precioP, cantidadIngresada, subtotal, precioTotal);
    }

    private String calcularPrecioP(String precio, String descuento) {
            double precioDescuento;
            String precioFinal = "";
            double descuentoObtenido;
            if(descuento.equals("")){
                precioDescuento = 0.00;
            } else {
                precioDescuento = (Double.parseDouble(descuento))/100;
            }
        
        if(modelo.getVistaVentas().cmbSubsidio.getItemAt(2).equals("SI")){
            double precioInt = Double.parseDouble(precio);
            descuentoObtenido = precioInt * precioDescuento;
            precioFinal = String.valueOf(precioInt - descuentoObtenido);
        }
        
        return precioFinal;
    }

    private String calcularSubTotal() {

        return "";
    }

    private String calcularTotal(String precioFinal, String cantidad) {
        
        double precioCalculado = Double.parseDouble(precioFinal);
        double cantidadIngresada = Double.parseDouble(cantidad);
        
        double totalCalculado = precioCalculado * cantidadIngresada;
        String precioTotalCalculado = String.valueOf(totalCalculado);
        return precioTotalCalculado;
    }

    private void limpiarDatos() {
    }

    public void datosVaciosBuscarP() {
        if (modelo.getVistaVentas().txtNombreProducto.getText().isEmpty() && modelo.getVistaVentas().txtCodigoBarras.getText().isEmpty()) {
            mostrarError("Debe de ingresar al menos el nombre o código del producto");
        } else {
            capturaDatosBuscarP();
        }
    }

    public void datosVaciosAgregarP() {
        if (modelo.getVistaVentas().txtNombreProducto.getText().isEmpty() 
                || modelo.getVistaVentas().txtCodigoBarras.getText().isEmpty()
                || modelo.getVistaVentas().txtPrecio.getText().isEmpty()) {
            mostrarError("No se pudo agregar el producto, por favor busque un producto para agregarlo");
        } else {
            capturaDatosAgregarP();
        }
    }

    private void datosVaciosHacerVentas() {
        if (modelo.getVistaVentas().txtNombreProducto.getText().isEmpty()
                || modelo.getVistaVentas().txtCodigoBarras.getText().isEmpty()
                || modelo.getVistaVentas().txtCantidad.getText().isEmpty()
                || modelo.getVistaVentas().txtSubtotal.getText().isEmpty()
                || modelo.getVistaVentas().txtDescuentoSubsidio.getText().isEmpty()
                || modelo.getVistaVentas().txtTotal.getText().isEmpty()) {

        } else {
            //Llamar al método que registre la venta
            //En ese mismo método añadir la opción de generar o no PDF (Comprobante)
            hacerVenta();
        }
    }

    public void elementosVisibles() {
    }

    public void consultarProducto(String nombreP, String codigoB) {

        ModeloProducto modeloP;

        modeloP = implementacion.buscarProducto(nombreP, codigoB);
        
        if (modeloP == null){
            mostrarError("Producto no encontrado");
            return;
        }
        
        boolean estaActivo = modeloP.isActivoP();
        int cantidadDisponible = modeloP.getCantidadDisponible();

        if (!estaActivo == true) {
            mostrarError("El producto no se encuentra activo");
        } else if (cantidadDisponible < 1) {
            mostrarError("El Producto no tiene suficiente stock");
        } else {
            modelo.getVistaVentas().txtIdProducto.setText(String.valueOf(modeloP.getIdProducto()));
            modelo.getVistaVentas().txtCodigoBarras.setText(modeloP.getCodigoBarrasP());
            modelo.getVistaVentas().txtNombreProducto.setText(modeloP.getNombreOficialP());
            modelo.getVistaVentas().txtArea.setText(modeloP.getDescripcionP());
            modelo.getVistaVentas().txtPrecio.setText(String.valueOf(modeloP.getPrecioVenta()));
        }

    }

    public void agregarDatosTabla(String nombreP, String precio, String cantidad, String subtotal, String total) {
        
        DefaultTableModel modeloTabla = new DefaultTableModel();
       
        modeloTabla.setColumnIdentifiers(new Object [] {"Nombre Producto", "Precio", "Cantidad", "SubTotal", "Total"});
       
        modeloTabla.addRow(new Object[]{
            nombreP, 
            precio, 
            cantidad, 
            subtotal, 
            total});

        agregarTabla(modeloTabla);
    }

    //METODOS PARA DEFINIR LA TABLA DENTRO DEL JSCROLL
    public void tableSize(JTable tabla) {
        int rowHeight = tabla.getRowHeight();
        int rowCount = tabla.getRowCount();
        int headerHeight = tabla.getTableHeader().getPreferredSize().height;

        int alturaTotal = (rowHeight * rowCount) + headerHeight;
        tabla.setPreferredScrollableViewportSize(new Dimension(tabla.getPreferredSize().width, alturaTotal));
    }

    public void agregarTabla(DefaultTableModel modeloTabla) {
        JTable nuevaTabla = new JTable(modeloTabla);
        tableSize(nuevaTabla);

        System.out.println(nuevaTabla.getRowCount());

        JScrollPane tableScroll = new JScrollPane(nuevaTabla);
        tableScroll.setBorder(BorderFactory.createTitledBorder("Carrito de Compras" + (modelo.getVistaVentas().contenedorTablaVentas.getComponentCount() + 1)));

        modelo.getVistaVentas().contenedorTablaVentas.add(tableScroll);
        modelo.getVistaVentas().contenedorTablaVentas.revalidate();
        modelo.getVistaVentas().contenedorTablaVentas.repaint();
    }

    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    private void hacerVenta() {

        ModeloVenta modeloVenta = new ModeloVenta();

        //Llamar al método de implementación para la venta
        if (modeloVenta != null) {
            int mensajeHacerComprobante = JOptionPane.showConfirmDialog(null, "¿Desea generar comprobante de esta venta?", "VENTA", JOptionPane.YES_NO_OPTION);
            if (mensajeHacerComprobante == JOptionPane.YES_OPTION) {
                generarComprobante();
            } else {
                JOptionPane.showMessageDialog(null, "Venta realizada con éxito", "VENTA", JOptionPane.WARNING_MESSAGE);
                //Tal vez llamar aquí el método para limpiar todo
            }
        }

    }

    private void generarComprobante() {

    }
}
