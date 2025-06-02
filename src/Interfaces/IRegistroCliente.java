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

    public boolean insertarCliente(Cliente cliente);

    public boolean actualizarCliente(Cliente cliente);

    public boolean eliminarCliente(int idCliente);

    public List<Cliente> listarClientes();

    public Cliente obtenerClientePorId(int idCliente);
}
