/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Implementacion;

import Modelo.ModeloRegistroCliente;
import Conector.DBConnection;
import Interfaces.IRegistroCliente;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

import Interfaces.*;

public class RegistroClienteImpl implements IRegistroCliente {

    private final DBConnection conector = new DBConnection();
    private PreparedStatement ps;
    private ResultSet rs;

    @Override
    public ModeloRegistroCliente ConsultaCliente(String nombre, String apellido, int telefono, String direccion, int identificacion, String nit, String subsidio, String fecha) {
        ModeloRegistroCliente modelo = new ModeloRegistroCliente();

        try {
            conector.conectar();
            String sql = "SELECT * FROM clientes WHERE nombre LIKE ? AND apellido LIKE ? AND telefono = ? AND direccion LIKE ? AND identificacion = ? AND nit LIKE ? AND subsidio LIKE ? AND fecha LIKE ?";
            ps = conector.preparar(sql);
            ps.setString(1, "%" + nombre + "%");
            ps.setString(2, "%" + apellido + "%");
            ps.setInt(3, telefono);
            ps.setString(4, "%" + direccion + "%");
            ps.setInt(5, identificacion);
            ps.setString(6, "%" + nit + "%");
            ps.setString(7, "%" + subsidio + "%");
            ps.setString(8, "%" + fecha + "%");

            rs = ps.executeQuery();

            if (rs.next()) {
                modelo.setId_clientes(rs.getInt("id_cliente"));
                modelo.setNombre(rs.getString("nombre"));
                modelo.setApellido(rs.getString("apellido"));
                modelo.setTelefono(rs.getInt("telefono"));
                modelo.setDireccion(rs.getString("direccion"));
                modelo.setIdentificacion(rs.getInt("identificacion"));
                modelo.setNit(rs.getString("nit"));
                modelo.setSubsidio(rs.getString("subsidio"));
                modelo.setFecha(rs.getString("fecha"));
                System.out.println("Cliente encontrado: " + modelo.getNombre() + " " + modelo.getApellido());
            }
        } catch (SQLException e) {
            System.out.println("Error en la consulta de cliente: " + e.getMessage());
        } finally {
            conector.desconectar();
        }
        return modelo;
    }

    @Override
    public boolean eliminarCliente(int id_cliente) {
        boolean eliminado = false;

        try {
            conector.conectar();
            String sql = "DELETE FROM clientes WHERE id_cliente = ?";
            ps = conector.preparar(sql);
            ps.setInt(1, id_cliente);
            eliminado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        } finally {
            conector.desconectar();
        }
        return eliminado;
    }

    @Override
    public boolean actualizarCliente(ModeloRegistroCliente cliente) {
        boolean actualizado = false;

        try {
            conector.conectar();
            String sql = "UPDATE clientes SET nombre = ?, apellido = ?, telefono = ?, nit = ?, direccion = ?, identificacion = ?, subsidio = ?, fecha = ? WHERE id_cliente = ?";
            ps = conector.preparar(sql);
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
        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente: " + e.getMessage());
        } finally {
            conector.desconectar();
        }
        return actualizado;
    }

    @Override
    public boolean insertarCliente(ModeloRegistroCliente cliente) {
        boolean insertado = false;

        try {
            conector.conectar();
            String sql = "INSERT INTO clientes (nombre, apellido, telefono, nit, direccion, identificacion, subsidio, fecha) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            ps = conector.preparar(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getTelefono());
            ps.setString(4, cliente.getNit());
            ps.setString(5, cliente.getDireccion());
            ps.setInt(6, cliente.getIdentificacion());
            ps.setString(7, cliente.getSubsidio());
            ps.setString(8, cliente.getFecha());

            insertado = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error al insertar cliente: " + e.getMessage());
        } finally {
            conector.desconectar();
        }
        return insertado;
    }

    @Override
    public DefaultTableModel listarClientes() {
        DefaultTableModel modeloTabla = new DefaultTableModel();

        modeloTabla.setColumnIdentifiers(new Object[]{
            "ID", "Nombre", "Apellido", "Teléfono", "NIT", "Dirección", "Identificación", "Subsidio", "Fecha Registro"
        });
        try {
            conector.conectar();
            String sql = "SELECT * FROM clientes";
            ps = conector.preparar(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                modeloTabla.addRow(new Object[]{
                    rs.getInt("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getInt("telefono"),
                    rs.getString("nit"),
                    rs.getString("direccion"),
                    rs.getInt("identificacion"),
                    rs.getString("subsidio"),
                    rs.getString("fecha")
                });
            }
        } catch (SQLException e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        } finally {
            conector.desconectar();
        }
        return modeloTabla;
    }
}
