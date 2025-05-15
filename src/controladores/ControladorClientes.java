/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Conector.DBConnection;
import modelos.ModeloRegistroCliente;
 import Implementacion.*;
import Vistas.PanelClientes;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author anyi4
 */
public class ControladorClientes implements IcontroladorCliente {


    private ModeloRegistroCliente modelo;
    private PanelClientes vista;
    private RegistroClienteImpl dao;

    public ControladorClientes(ModeloRegistroCliente modelo, PanelClientes vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.dao = new RegistroClienteImpl();
        this.vista.setControlador(this); 
    }

    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            agregarCliente();
        } else if (e.getSource() == vista.btnActualizar) {
            actualizarCliente();
        } else if (e.getSource() == vista.btnEliminar) {
            eliminarCliente();
        } else if (e.getSource() == vista.tblRegistroClientes) {
            cargarDatosSeleccionados();
        }
    }

    private void agregarCliente() {
        ModeloRegistroCliente nuevo = new ModeloRegistroCliente();
        nuevo.setNombre(vista.txtNombreCliente.getText());
        nuevo.setApellido(vista.txtApellidoCliente.getText());
        nuevo.setTelefono(Integer.parseInt(vista.txtTelefono.getText()));
        nuevo.setNit(vista.txtNIT.getText());
        nuevo.setDireccion(vista.txtDireccion.getText());
        nuevo.setIdentificacion(Integer.parseInt(vista.txtIdentificacion.getText()));
        nuevo.setSubsidio(vista.txtSubsidio.getText());
        nuevo.setFecha(vista.txtFechaRegistro.getText());

        if (dao.insertarCliente(nuevo)) {
            JOptionPane.showMessageDialog(null, "Cliente agregado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al agregar cliente.");
        }
    }

    private void actualizarCliente() {
        ModeloRegistroCliente actualizado = new ModeloRegistroCliente();
        actualizado.setId_clientes(Integer.parseInt(vista.txtIdCliente.getText()));
        actualizado.setNombre(vista.txtNombreCliente.getText());
        actualizado.setApellido(vista.txtApellidoCliente.getText());
        actualizado.setTelefono(Integer.parseInt(vista.txtTelefono.getText()));
        actualizado.setNit(vista.txtNIT.getText());
        actualizado.setDireccion(vista.txtDireccion.getText());
        actualizado.setIdentificacion(Integer.parseInt(vista.txtIdentificacion.getText()));
        actualizado.setSubsidio(vista.txtSubsidio.getText());
        actualizado.setFecha(vista.txtFechaRegistro.getText());

        if (dao.actualizarCliente(actualizado)) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente.");
        }
    }

    private void eliminarCliente() {
        int id = Integer.parseInt(vista.txtIdCliente.getText());

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (dao.eliminarCliente(id)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente.");
            }
        }
    }

    private void cargarDatosSeleccionados() {
        int fila = vista.tblRegistroClientes.getSelectedRow();
        if (fila != -1) {
            vista.txtIdCliente.setText(vista.tblRegistroClientes.getValueAt(fila, 0).toString());
            vista.txtNombreCliente.setText(vista.tblRegistroClientes.getValueAt(fila, 1).toString());
            vista.txtApellidoCliente.setText(vista.tblRegistroClientes.getValueAt(fila, 2).toString());
            vista.txtTelefono.setText(vista.tblRegistroClientes.getValueAt(fila, 3).toString());
            vista.txtNIT.setText(vista.tblRegistroClientes.getValueAt(fila, 4).toString());
            vista.txtDireccion.setText(vista.tblRegistroClientes.getValueAt(fila, 5).toString());
            vista.txtIdentificacion.setText(vista.tblRegistroClientes.getValueAt(fila, 6).toString());
            vista.txtSubsidio.setText(vista.tblRegistroClientes.getValueAt(fila, 7).toString());
            vista.txtFechaRegistro.setText(vista.tblRegistroClientes.getValueAt(fila, 8).toString());
        }
    }

  
    
}

