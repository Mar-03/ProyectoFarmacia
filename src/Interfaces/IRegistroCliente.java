/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.ModeloRegistroCliente;

/**
 *
 * @author anyi4
 */
import javax.swing.table.DefaultTableModel;
import Modelo.ModeloRegistroCliente;

public interface IRegistroCliente {

    public ModeloRegistroCliente ConsultaCliente(String nombre, String apellido,
        int telefono, String direccion, int identificacion, String nit, String subsidio, String fecha);

    public boolean insertarCliente(ModeloRegistroCliente cliente);

    public boolean actualizarCliente(ModeloRegistroCliente cliente);

    public boolean eliminarCliente(int id_cliente);

   
    public DefaultTableModel listarClientes();
}
