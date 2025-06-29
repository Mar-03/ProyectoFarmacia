/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import Implementacion.RegistroClienteImpl;
import Interfaces.IRegistroCliente;
import Modelo.ModeloRegistroCliente;
//import Modelo.ModeloRegistroCliente;
import Vistas.PanelClientes;
import Modelo.ModeloRegistroCliente.Cliente;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorClientes implements MouseListener {
    
    ModeloRegistroCliente modelo;
    
    RegistroClienteImpl implementacion = new RegistroClienteImpl();

//    PanelClientes vista;
//    ModeloRegistroCliente modelo;
//    IRegistroCliente interfaz;
//    DefaultTableModel tableModel;
    private final PanelClientes vista;
    private final IRegistroCliente interfaz;
    private final DefaultTableModel tableModel;

    public ControladorClientes(PanelClientes vista, IRegistroCliente modelo) {
        this.vista = vista;
        this.interfaz = modelo;
        this.tableModel = (DefaultTableModel) vista.tblclientes.getModel();

        // Asignar listeners
        this.vista.btnAgregar.addMouseListener(this);
        this.vista.btnActualizar.addMouseListener(this);
        this.vista.btnEliminar.addMouseListener(this);
        this.vista.tblclientes.addMouseListener(this);

        // Cargar datos al iniciar
        cargarClientes();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnAgregar) {
            agregarCliente();
        } else if (e.getSource() == vista.btnActualizar) {
            actualizarCliente();
        } else if (e.getSource() == vista.btnEliminar) {
            eliminarCliente();
        } else if (e.getSource() == vista.tblclientes) {
            seleccionarClienteDeTabla();
        }
    }

    private void agregarCliente() {
     
       // Cliente cliente = obtenerClienteDesdeFormulario();
      //  if (cliente != null && interfaz.insertarCliente(cliente)) {
       //     JOptionPane.showMessageDialog(vista, "Cliente agregado exitosamente");
          //  limpiarFormulario();
           // cargarClientes();
       // } else {
       //     JOptionPane.showMessageDialog(vista, "Error al agregar cliente", "Error", JOptionPane.ERROR_MESSAGE);
        //}
        
    System.out.println("Botón presionado");

    Cliente cliente = obtenerClienteDesdeFormulario();
    if (cliente == null) {
        System.out.println("Cliente nulo. Revisa obtenerClienteDesdeFormulario().");
        JOptionPane.showMessageDialog(vista, "Datos inválidos del formulario", "Error", JOptionPane.ERROR_MESSAGE);
        return;
    }

    boolean guardado = interfaz.insertarCliente(cliente);
    System.out.println("Resultado de insertarCliente: " + guardado);

    if (guardado) {
        JOptionPane.showMessageDialog(vista, "Cliente agregado exitosamente");
        limpiarFormulario();
        cargarClientes();
    } else {
        JOptionPane.showMessageDialog(vista, "Error al agregar cliente", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
    }

    private void actualizarCliente() {
        int idCliente = obtenerIdClienteSeleccionado();
        if (idCliente == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un cliente primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cliente cliente = obtenerClienteDesdeFormulario();
        if (cliente != null) {
            cliente.setIdCliente(idCliente);
            if (interfaz.actualizarCliente(cliente)) {
                JOptionPane.showMessageDialog(vista, "Cliente actualizado exitosamente");
                limpiarFormulario();
                cargarClientes();
            } else {
                JOptionPane.showMessageDialog(vista, "Error al actualizar cliente", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void eliminarCliente() {
        int idCliente = obtenerIdClienteSeleccionado();
        if (idCliente == -1) {
            JOptionPane.showMessageDialog(vista, "Seleccione un cliente primero", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        int confirmacion = JOptionPane.showConfirmDialog(vista, "¿Está seguro de eliminar este cliente?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION && interfaz.eliminarCliente(idCliente)) {
            JOptionPane.showMessageDialog(vista, "Cliente eliminado exitosamente");
            limpiarFormulario();
            cargarClientes();
        }
    }

    private void seleccionarClienteDeTabla() {
        int filaSeleccionada = vista.tblclientes.getSelectedRow();
        if (filaSeleccionada != -1) {
            int idCliente = (int) tableModel.getValueAt(filaSeleccionada, 0);
            Cliente cliente = interfaz.obtenerClientePorId(idCliente);
            if (cliente != null) {
                llenarFormulario(cliente);
            }
        }
    }

    private void cargarClientes() {
        tableModel.setRowCount(0);
        List<Cliente> clientes = interfaz.listarClientes();
        for (Cliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                cliente.getIdCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getTelefono(),
                cliente.getIdentificacion(),
                cliente.getNit(),
                cliente.isTieneSubsidio() ? "Sí" : "No"
            });
        }
    }

    private void llenarFormulario(Cliente cliente) {
        vista.txtNombreCliente.setText(cliente.getNombre());
        vista.txtApellidoCliente.setText(cliente.getApellido());
        vista.txtTelefono.setText(cliente.getTelefono());
        vista.txtIdentificacion.setText(cliente.getIdentificacion());
        vista.txtNIT.setText(cliente.getNit());
        vista.Subsidio.setSelected(cliente.isTieneSubsidio());
    }

    private void limpiarFormulario() {
        vista.txtNombreCliente.setText("");
        vista.txtApellidoCliente.setText("");
        vista.txtTelefono.setText("");
        vista.txtIdentificacion.setText("");
        vista.txtNIT.setText("");
        vista.Subsidio.setSelected(false);
        vista.tblclientes.clearSelection();
    }

    private int obtenerIdClienteSeleccionado() {
        int fila = vista.tblclientes.getSelectedRow();
        if (fila != -1) {
            return (int) tableModel.getValueAt(fila, 0);
        }
        return -1;
    }

    private Cliente obtenerClienteDesdeFormulario() {
        String nombre = vista.txtNombreCliente.getText().trim();
        String apellido = vista.txtApellidoCliente.getText().trim();
        String telefono = vista.txtTelefono.getText().trim();
        String identificacion = vista.txtIdentificacion.getText().trim();
        String nit = vista.txtNIT.getText().trim();
        boolean tieneSubsidio = vista.Subsidio.isSelected();

        if (nombre.isEmpty() || apellido.isEmpty() || telefono.isEmpty() || identificacion.isEmpty() || nit.isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Por favor, complete todos los campos", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return null;
        }

        Cliente cliente = new Cliente();
        cliente.setNombre(nombre);
        cliente.setApellido(apellido);
        cliente.setTelefono(telefono);
        cliente.setIdentificacion(identificacion);
        cliente.setNit(nit);
        cliente.setTieneSubsidio(tieneSubsidio);

        return cliente;
    }
    
    public boolean validarClienteActivo (String clienteActivo){
        
        boolean estaActivo = true;
        
        if (clienteActivo.equals("SI")){
        }else{
            estaActivo = false;
        }
        return estaActivo;
    
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
         if (e.getSource() == vista.btnAgregar) {
            vista.btnAgregar.setBackground(new Color(50,95,110));
        } else if (e.getSource() == vista.btnActualizar) {
            vista.btnActualizar.setBackground(new Color(50,95,110));
        } else if (e.getSource() == vista.btnEliminar) {
            vista.btnEliminar.setBackground(new Color(50,95,110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
  
}
