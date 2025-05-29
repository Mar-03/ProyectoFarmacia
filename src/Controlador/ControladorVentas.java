/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Implementacion.VentaImp;
import Modelo.ModeloProducto;
import Modelo.ModeloRegistroCliente;
import Modelo.ModeloVenta;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jhosu
 */
public class ControladorVentas implements MouseListener, ActionListener {

    ModeloVenta modelo;
    private DefaultTableModel modeloTablaVentas;
    private JTable tablaVentas;

    public ControladorVentas(ModeloVenta modelo) {
        this.modelo = modelo;
        
        modeloTablaVentas = new DefaultTableModel();
        modeloTablaVentas.setColumnIdentifiers(new Object[]{"Nombre Producto", "Precio", "Cantidad", "SubTotal", "Total"});
    
        tablaVentas = new JTable(modeloTablaVentas);
        tablaVentas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        JScrollPane tableScroll = new JScrollPane(tablaVentas);
        tableScroll.setBorder(BorderFactory.createTitledBorder("Carrito de Compras"));
        
        modelo.getVistaVentas().contenedorTablaVentas.add(tableScroll);
        modelo.getVistaVentas().contenedorTablaVentas.revalidate();
        modelo.getVistaVentas().contenedorTablaVentas.repaint();
        
    }
    
    VentaImp implementacion = new VentaImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaVentas().btnAgregar)) {
            datosVaciosAgregarP();
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnBuscar)) {
            datosVaciosBuscarP();
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnEliminar)) {
            EliminarP();
        } else if (e.getComponent().equals(modelo.getVistaVentas().btnHacerVenta)) {
            datosVaciosHacerVenta();
        } else if (e.getComponent().equals(modelo.getVistaVentas().checkBoxVentaSinClienteR)) {
            clienteNoRegistrado();
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
        String precioTotal = calcularTotal(subtotal, cantidadIngresada);
        agregarDatosTabla(nombreP, precioP, cantidadIngresada, subtotal, precioTotal);
    }

    private String calcularPrecioP(String precio, String descuento) {
        double precioDescuento;
        String precioFinal = "";
        double descuentoObtenido;
        if (descuento.equals("")) {
            precioDescuento = 0.00;
        } else {
            precioDescuento = (Double.parseDouble(descuento)) / 100;
        }

        if (modelo.getVistaVentas().cmbSubsidio.getItemAt(1).equals("SI")) {
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
    
    public void datosVaciosHacerVenta(){
        
        if(modeloTablaVentas.getRowCount() == 0
                || !modelo.getVistaVentas().checkBoxVentaSinClienteR.isSelected()
                || modelo.getVistaVentas().txtNITCliente.getText().isEmpty()){
            mostrarError("No se puede realizar la venta, debe de llenar todos los campos");
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

    private void limpiarElementos(){
                modelo.getVistaVentas().txtNombreProducto.setText("");
                modelo.getVistaVentas().txtCodigoBarras.setText("");
                modelo.getVistaVentas().txtCantidad.setText("");
                modelo.getVistaVentas().txtDescuentoSubsidio.setText("");
                modelo.getVistaVentas().txtIdProducto.setText("");
                modelo.getVistaVentas().cmbSubsidio.setSelectedIndex(0);
                modelo.getVistaVentas().labelInstitucionSubsidio.setText("");
                modelo.getVistaVentas().labelInstitucionSubsidio.setVisible(false);
                modelo.getVistaVentas().labelDescuentoSubsidio.setText("");
                modelo.getVistaVentas().txtDescuentoSubsidio.setVisible(false);
                modelo.getVistaVentas().txtPrecio.setText("");
    }
    
    public void consultarProducto(String nombreP, String codigoB) {

        ModeloProducto modeloP;

        modeloP = implementacion.buscarProducto(nombreP, codigoB);

        if (modeloP == null) {
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
    
    

    //METODOS PARA GENERAR LA TABLA DE LOS PRODUCTOS PARA LA VENTA
    public void agregarDatosTabla(String nombreP, String precio, String cantidad, String subtotal, String total) {
      
        modeloTablaVentas.addRow(new Object[]{
            nombreP,
            precio,
            cantidad,
            subtotal,
            total});

        limpiarElementos();
    }

    
    private void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "¡ADVERTENCIA!", JOptionPane.WARNING_MESSAGE);
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
    
    //METODO PARA MOSTRAR CAMPOS, DEPENDIENDO SI SE DESEA INGRESAR SUBSIDIO
    private void comboBoxSubsidio() {
        int itemSeleccionado = modelo.getVistaVentas().cmbSubsidio.getSelectedIndex();

        if (itemSeleccionado == 1) {
            modelo.getVistaVentas().labelInstitucionSubsidio.setVisible(true);
            modelo.getVistaVentas().txtIdInsSubsidio.setVisible(true);
            modelo.getVistaVentas().labelDescuentoSubsidio.setVisible(true);
            modelo.getVistaVentas().txtDescuentoSubsidio.setVisible(true);
        } else {
            modelo.getVistaVentas().labelInstitucionSubsidio.setVisible(false);
            modelo.getVistaVentas().txtIdInsSubsidio.setVisible(false);
            modelo.getVistaVentas().labelDescuentoSubsidio.setVisible(false);
            modelo.getVistaVentas().txtDescuentoSubsidio.setVisible(false);

        }
    }

    
    //METODO PARA MOSTRAR CAMPOS SI EL CLIENTE ESTA REGISTRADO (No NIT)
    private void clienteNoRegistrado() {
        if (modelo.getVistaVentas().checkBoxVentaSinClienteR.isSelected()) {
            modelo.getVistaVentas().labelNIT.setVisible(false);
            modelo.getVistaVentas().txtNITCliente.setVisible(false);
        } else {
            modelo.getVistaVentas().labelNIT.setVisible(true);
            modelo.getVistaVentas().txtNITCliente.setVisible(true);

        }

    }
    
    
     private void EliminarP(){
          int filasSeleccionada = tablaVentas.getSelectedRow();
          if(filasSeleccionada != -1){
              modeloTablaVentas.removeRow(filasSeleccionada);
          } else {
              mostrarError("Selecciona un producto agregado para eliminarlo");
          }   
    }

    public void consultarClienteNit(){
        
    }
     
     
    @Override
    public void actionPerformed(ActionEvent e) {

        comboBoxSubsidio();

    }
}
