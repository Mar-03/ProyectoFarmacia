/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacion;

import Conector.DBConnection;
import Conector.SQL;


import modelos.*;

import Interfaces.*;
import static java.awt.Event.DELETE;
import static java.awt.event.PaintEvent.UPDATE;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author anyi4
 */
import java.sql.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class RegistroClienteImpl implements IRegistroCliente{

    DBConnection conector = new DBConnection();
    SQL sql = new SQL(); 
    PreparedStatement ps;
    ResultSet rs;

    @Override
public ModeloRegistroCliente ConsultaCliente(String nombre, String apellido, int telefono, String direccion, int identificacion, String nit, String subsidio, String fecha) {
    ModeloRegistroCliente modelo = new ModeloRegistroCliente();
    conector.conectar();

    try {
        String SELECT_BY_PARAMS = null;
        ps = conector.preparar(SELECT_BY_PARAMS);
        ps.setString(1, "%" + nombre + "%");
        ps.setString(2, "%" + apellido + "%");
        ps.setInt(3, telefono);
        ps.setString(4, "%" + direccion + "%");
        ps.setInt(5, identificacion);
        ps.setString(6, "%" + nit + "%");
        ps.setString(7, "%" + subsidio + "%");
        ps.setString(8, "%" + fecha + "%");

        rs = ps.executeQuery();

        while (rs.next()) {
            modelo.setId_clientes(rs.getInt("id_cliente"));
            modelo.setNombre(rs.getString("nombre"));
            modelo.setApellido(rs.getString("apellido"));
            modelo.setTelefono(rs.getInt("telefono"));
            modelo.setDireccion(rs.getString("direccion"));
            modelo.setIdentificacion(rs.getInt("identificacion"));
            modelo.setNit(rs.getString("nit"));
            modelo.setSubsidio(rs.getString("subsidio"));
            modelo.setFecha(rs.getString("fecha"));

            System.out.println("Cliente encontrado: " + rs.getString("nombre") + " " + rs.getString("apellido"));
        }

        conector.desconectar();
    } catch (SQLException e) {
        System.out.println("Error en la consulta de cliente: " + e.getMessage());
    }

    return modelo;
}

@Override
public boolean eliminarCliente(int id_cliente) {
    boolean eliminado = false;
    conector.conectar();

    try {
        ps = conector.preparar(DELETE);
        ps.setInt(1, id_cliente);
        eliminado = ps.executeUpdate() > 0;
        conector.desconectar();
    } catch (SQLException e) {
        System.out.println("Error al eliminar cliente: " + e.getMessage());
    }

    return eliminado;
}

@Override
public boolean actualizarCliente(ModeloRegistroCliente cliente) {
    boolean actualizado = false;
    conector.conectar();

    try {
        ps = conector.preparar(UPDATE);
        ps.setString(1, cliente.getNombre());
        ps.setString(2, cliente.getApellido());
        ps.setInt(3, cliente.getTelefono());
        ps.setString(4, cliente.getNit());
        ps.setString(5, cliente.getDireccion());
        ps.setInt(6, cliente.getIdentificacion());
        ps.setString(7, cliente.getSubsidio());
        ps.setString(8, cliente.getFecha());
        ps.setInt(9, cliente.getId_clientes());

        actualizado = ps.executeUpdate() > 0;
        conector.desconectar();
    } catch (SQLException e) {
        System.out.println("Error al actualizar cliente: " + e.getMessage());
    }

    return actualizado;
}

    @Override
    public boolean insertarCliente(ModeloRegistroCliente cliente) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    

   

  
    
}