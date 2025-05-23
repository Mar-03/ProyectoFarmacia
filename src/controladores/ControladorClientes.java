/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;


import Modelo.ModeloRegistroCliente;
import Implementacion.RegistroClienteImpl;
import Vistas.PanelClientes;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ControladorClientes implements MouseListener {

    private ModeloRegistroCliente modelo;
    private RegistroClienteImpl dao;

    public ControladorClientes(ModeloRegistroCliente modelo, PanelClientes vista) {
        this.modelo = modelo;
        this.dao = new RegistroClienteImpl();
        this.modelo.setPanelCliente(vista);
        vista.setControlador(this);
        mostrarClientesEnTabla(vista.tblclientes);
    }

    public void limpiar() {
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

        // Validación de campos
        nuevo.setNombre(modelo.getPanelCliente().txtNombreCliente.getText().trim());
        nuevo.setApellido(modelo.getPanelCliente().txtApellidoCliente.getText().trim());
        nuevo.setNit(modelo.getPanelCliente().txtNIT.getText().trim());
        nuevo.setDireccion(modelo.getPanelCliente().txtDireccion.getText().trim());
        nuevo.setSubsidio(modelo.getPanelCliente().Subsidio.isSelected());

       
        String textoIdentificacion = modelo.getPanelCliente().txtIdentificacion.getText().trim();
        if (!textoIdentificacion.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Identificación inválida. Solo números permitidos.");
            return;
        }
        nuevo.setIdentificacion(textoIdentificacion);

        
        String fechaStr = modelo.getPanelCliente().txtFechaRegistro.getText().trim();
        if (!fechaStr.matches("^\\d{4}-\\d{2}-\\d{2}$") || !esFechaValida(fechaStr)) {
            JOptionPane.showMessageDialog(null, "Formato de fecha inválido. Use yyyy-MM-dd.");
            return;
        }
        LocalDate fecha = LocalDate.parse(fechaStr);
        
          String textoTelefono = modelo.getPanelCliente().txtTelefono.getText().trim();
            if (!textoTelefono.matches("\\d{8,15}")) { 
             JOptionPane.showMessageDialog(null, "Teléfono inválido.");
        return;
            }
            nuevo.setTelefono(textoTelefono);

        if (dao.insertarCliente(nuevo)) {
            JOptionPane.showMessageDialog(null, "Cliente registrado exitosamente");
            limpiar();
            mostrarClientesEnTabla(modelo.getPanelCliente().tblclientes);
        } else {
            JOptionPane.showMessageDialog(null, "Error al registrar cliente");
        }
    }

   

    private boolean esFechaValida(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        sdf.setLenient(false);
        try {
            sdf.parse(fecha);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private void actualizarCliente() {
        ModeloRegistroCliente actualizado = new ModeloRegistroCliente();

        try {
            actualizado.setId_clientes(Integer.parseInt(modelo.getPanelCliente().txtIdCliente.getText()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
            return;
        }

        String textoTelefono = modelo.getPanelCliente().txtTelefono.getText().trim().replaceAll("\\s+", "");
        if (!textoTelefono.matches("\\d{8,15}")) {
            JOptionPane.showMessageDialog(null, "Teléfono inválido.");
            return;
        }
        actualizado.setTelefono(textoTelefono);

        String textoIdentificacion = modelo.getPanelCliente().txtIdentificacion.getText().trim();
        if (!textoIdentificacion.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Identificación inválida.");
            return;
        }
        actualizado.setIdentificacion(textoIdentificacion);

        String textoFecha = modelo.getPanelCliente().txtFechaRegistro.getText().trim();
        if (!textoFecha.matches("^\\d{4}-\\d{2}-\\d{2}$") || !esFechaValida(textoFecha)) {
        JOptionPane.showMessageDialog(null, "Formato de fecha inválido.");
     return;
            }
        LocalDate fecha = LocalDate.parse(textoFecha);
        //actualizado.setFecha(fecha);


       // actualizado.setFecha(fecha);

        actualizado.setNombre(modelo.getPanelCliente().txtNombreCliente.getText().trim());
        actualizado.setApellido(modelo.getPanelCliente().txtApellidoCliente.getText().trim());
        actualizado.setNit(modelo.getPanelCliente().txtNIT.getText().trim());
        actualizado.setDireccion(modelo.getPanelCliente().txtDireccion.getText().trim());
        actualizado.setSubsidio(modelo.getPanelCliente().Subsidio.isSelected());


        boolean exito = dao.actualizarCliente(actualizado);
        if (exito) {
            JOptionPane.showMessageDialog(null, "Cliente actualizado correctamente.");
            limpiar();
            mostrarClientesEnTabla(modelo.getPanelCliente().tblclientes);
        } else {
            JOptionPane.showMessageDialog(null, "Error al actualizar cliente.");
        }
    }

    private void eliminarCliente() {
        int id;
        try {
            id = Integer.parseInt(modelo.getPanelCliente().txtIdCliente.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID no válido.");
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(null, "¿Estás seguro de eliminar este cliente?", "Confirmar", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            boolean exito = dao.eliminarCliente(id);
            if (exito) {
                JOptionPane.showMessageDialog(null, "Cliente eliminado correctamente.");
                limpiar();
                mostrarClientesEnTabla(modelo.getPanelCliente().tblclientes);
            } else {
                JOptionPane.showMessageDialog(null, "Error al eliminar cliente.");
            }
        }
    }

    public void mostrarClientesEnTabla(JTable tablaClientes) {
        DefaultTableModel modeloTabla = dao.listarClientes();
        tablaClientes.setModel(modeloTabla);
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
                modelo.getPanelCliente().txtInsSubsidio.getText().isEmpty() ||
                modelo.getPanelCliente().txtFechaRegistro.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe ingresar todos los campos.");
            } else {
                agregarCliente();
            }
        } else if (e.getComponent().equals(modelo.getPanelCliente().btnEliminar)) {
            eliminarCliente();
        } else if (e.getComponent().equals(modelo.getPanelCliente().btnActualizar)) {
            actualizarCliente();
        }
    }

    @Override public void mousePressed(MouseEvent e) {}
    @Override public void mouseReleased(MouseEvent e) {}
    @Override public void mouseEntered(MouseEvent e) {
        if (e.getComponent() instanceof JTextField) {
            ((JTextField) e.getComponent()).setBackground(Color.WHITE);
        }
    }

    @Override public void mouseExited(MouseEvent e) {
        if (e.getComponent() instanceof JTextField) {
            ((JTextField) e.getComponent()).setBackground(new Color(204, 204, 204));
        }
    }
}