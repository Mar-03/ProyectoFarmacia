/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Conector.DBConnection;
import Modelo.ModeloRegistroCliente;
 import Implementacion.*;
import Vistas.PanelClientes;
import java.awt.Color;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import java.awt.event.MouseListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author anyi4
 */
public class ControladorClientes implements MouseListener{


    private ModeloRegistroCliente modelo;
    private RegistroClienteImpl dao;
     private RegistroClienteImpl impl;

    
    public ControladorClientes() {
        impl = new RegistroClienteImpl();
    }


    public ControladorClientes(ModeloRegistroCliente modelo, PanelClientes vista) {
        this.modelo = modelo;
    }
    public void limpiar(){
        modelo.getPanelCliente().txtActivo.setText("");
        modelo.getPanelCliente().txtNombreCliente.setText("");
        modelo.getPanelCliente().txtApellidoCliente.setText("");
        modelo.getPanelCliente().txtDireccion.setText("");
        modelo.getPanelCliente().txtFechaRegistro.setText("");
        modelo.getPanelCliente().txtIdCliente.setText("");
        modelo.getPanelCliente().txtIdentificacion.setText("");
        modelo.getPanelCliente().txtInsSubsidio.setText("");
        modelo.getPanelCliente().txtNIT.setText("");
        modelo.getPanelCliente().txtTelefono.setText("");
    }
       

  public void agregarCliente() {
    
    ModeloRegistroCliente nuevo = new ModeloRegistroCliente();

    
    nuevo.setNombre(this.modelo.getPanelCliente().txtNombreCliente.getText());
    nuevo.setApellido(this.modelo.getPanelCliente().txtApellidoCliente.getText());
    nuevo.setNit(this.modelo.getPanelCliente().txtNIT.getText());
    nuevo.setDireccion(this.modelo.getPanelCliente().txtDireccion.getText());
    
    try {
        nuevo.setIdentificacion(Integer.parseInt(this.modelo.getPanelCliente().txtIdentificacion.getText()));
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "Identificación no válida. Debe ser un número.");
        return;
    }

    nuevo.setSubsidio(this.modelo.getPanelCliente().txtSubsidio.getText());
    nuevo.setFecha(this.modelo.getPanelCliente().txtFechaRegistro.getText());

    String textoTelefono = modelo.getPanelCliente().txtTelefono.getText().trim();
    if (textoTelefono.matches("\\d+")) {
        nuevo.setTelefono(Integer.parseInt(textoTelefono));
    } else {
        JOptionPane.showMessageDialog(null, "Teléfono no válido. Ingresa solo números.");
        return;
    }

   
    boolean exito = dao.insertarCliente(nuevo); 

    if (exito) {
        JOptionPane.showMessageDialog(null, "Cliente agregado exitosamente.");
        limpiar();
    } else {
        JOptionPane.showMessageDialog(null, "Error al agregar cliente.");
    }
}



    private void actualizarCliente() {
        ModeloRegistroCliente actualizado = new ModeloRegistroCliente();
        actualizado.setId_clientes(Integer.parseInt(this.modelo.getPanelCliente().txtIdCliente.getText()));
        actualizado.setNombre(this.modelo.getPanelCliente().txtNombreCliente.getText());
        actualizado.setApellido(this.modelo.getPanelCliente().txtApellidoCliente.getText());
        actualizado.setTelefono(Integer.parseInt(this.modelo.getPanelCliente().txtTelefono.getText()));
        actualizado.setNit(this.modelo.getPanelCliente().txtNIT.getText());
        actualizado.setDireccion(this.modelo.getPanelCliente().txtDireccion.getText());
        actualizado.setIdentificacion(Integer.parseInt(this.modelo.getPanelCliente().txtIdentificacion.getText()));
        actualizado.setSubsidio(this.modelo.getPanelCliente().txtSubsidio.getText());
        actualizado.setFecha(this.modelo.getPanelCliente().txtFechaRegistro.getText());

      
    }

    private void eliminarCliente() {
        int id = Integer.parseInt(this.modelo.getPanelCliente().txtIdCliente.getText());

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirmacion == JOptionPane.YES_OPTION) {
            if (dao.eliminarCliente(id)) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente.");
            }
        }
    }
    public void consultarCliente(JTextField txtNombre, JTextField txtApellido, JTextField txtTelefono,
                                  JTextField txtDireccion, JTextField txtIdentificacion, JTextField txtNit,
                                  JTextField txtSubsidio, JTextField txtFecha, JTextField txtID) {

        ModeloRegistroCliente cliente = impl.ConsultaCliente(
            txtNombre.getText(),
            txtApellido.getText(),
            Integer.parseInt(txtTelefono.getText()),
            txtDireccion.getText(),
            Integer.parseInt(txtIdentificacion.getText()),
            txtNit.getText(),
            txtSubsidio.getText(),
            txtFecha.getText()
        );if (cliente.getId_clientes() != 0) {
            txtID.setText(String.valueOf(cliente.getId_clientes()));
            txtNombre.setText(cliente.getNombre());
            txtApellido.setText(cliente.getApellido());
            txtTelefono.setText(String.valueOf(cliente.getTelefono()));
            txtDireccion.setText(cliente.getDireccion());
            txtIdentificacion.setText(String.valueOf(cliente.getIdentificacion()));
            txtNit.setText(cliente.getNit());
            txtSubsidio.setText(cliente.getSubsidio());
            txtFecha.setText(cliente.getFecha());
        } else {
            JOptionPane.showMessageDialog(null, "Cliente no encontrado.");
        }
    }
    public void mostrarClientesEnTabla(JTable tablaClientes) {
        DefaultTableModel modelo = impl.listarClientes();
        tablaClientes.setModel(modelo);
    }

   @Override
public void mouseClicked(MouseEvent e) {
    if (e.getComponent().equals(modelo.getPanelCliente().btnAgregar)) {
        if (modelo.getPanelCliente().txtNombreCliente.getText().isEmpty() ||
            modelo.getPanelCliente().txtApellidoCliente.getText().isEmpty() ||
            modelo.getPanelCliente().txtTelefono.getText().isEmpty() ||
            modelo.getPanelCliente().txtNIT.getText().isEmpty() ||
            modelo.getPanelCliente().txtDireccion.getText().isEmpty() ||
            modelo.getPanelCliente().txtIdentificacion.getText().isEmpty() ||
            modelo.getPanelCliente().txtSubsidio.getText().isEmpty() ||
            modelo.getPanelCliente().txtFechaRegistro.getText().isEmpty()) {

            JOptionPane.showMessageDialog(null, "Debe de ingresar todos los campos", "ERROR AL AGREGAR CLIENTE", JOptionPane.ERROR_MESSAGE);
        } else {
            agregarCliente();
            limpiar();
            JOptionPane.showMessageDialog(null, "Cliente agregado con éxito", "CLIENTE AGREGADO", JOptionPane.INFORMATION_MESSAGE);
        }
    } else if (e.getComponent().equals(modelo.getPanelCliente().btnEliminar)) {
        if (modelo.getPanelCliente().txtIdCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el ID del cliente", "ERROR AL ELIMINAR CLIENTE", JOptionPane.ERROR_MESSAGE);
        } else {
            eliminarCliente();
        }
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
        if(e.getComponent().equals(modelo.getPanelCliente().btnAgregar)){
        modelo.getPanelCliente().btnAgregar.setBackground(new Color(83, 134, 134) );
        }else if (e.getComponent().equals(modelo.getPanelCliente().btnEliminar)){
        modelo.getPanelCliente().btnEliminar.setBackground(new Color(83, 134, 134));
        }
         }

    @Override
    public void mouseExited(MouseEvent e) {
        if (e.getComponent().equals(modelo.getPanelCliente().btnAgregar)) {
            modelo.getPanelCliente().btnAgregar.setBackground(new Color(48, 99, 99));
        } else if (e.getComponent().equals(modelo.getPanelCliente().btnEliminar)) {
            modelo.getPanelCliente().btnEliminar.setBackground(new Color(48, 99, 99));
        }
    }
         }

    

