/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import Modelo.ModeloRegistroCliente;
import Modelo.ModeloRegistroCliente.Cliente;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anyi4
 */


public interface IRegistroCliente {

    
    
    boolean insertarCliente(Cliente cliente);
    boolean actualizarCliente(Cliente cliente);
    boolean eliminarCliente(int idCliente);
    List<Cliente> listarClientes();
    Cliente obtenerClientePorId(int idCliente);

}
