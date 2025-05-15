/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interfaces;

import modelos.*;

/**
 *
 * @author anyi4
 */
public interface IRegistroCliente {
     public ModeloRegistroCliente ConsultaCliente(String nombre,String apellido,
     int telefono,String direccion, int identificacion, String nit, String subcidio, String fecha);
     public boolean insertarCliente(ModeloRegistroCliente cliente);

   
    public boolean actualizarCliente(ModeloRegistroCliente cliente);

    
    public boolean eliminarCliente(int id_cliente);

}
