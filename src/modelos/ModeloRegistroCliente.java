/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import Vistas.PanelClientes;
import java.util.logging.Logger;
import Vistas.*;

        

/**
 *
 * @author anyi4
 */
public class ModeloRegistroCliente {
    PanelClientes panelCliente;
   private static int id_clientes;
   private static String nombre;
   private static String apellido; 
   private static int telefono; 
   private static String direccion; 
   private static int identificacion;
   private static String nit;
   private static String subsidio;
   private static String fecha;

    public ModeloRegistroCliente() {
    }

    public ModeloRegistroCliente(PanelClientes panelCliente) {
        this.panelCliente = panelCliente;
    }

    public PanelClientes getPanelCliente() {
        return panelCliente;
    }

    public void setPanelCliente(PanelClientes panelCliente) {
        this.panelCliente = panelCliente;
    }

    public static int getId_clientes() {
        return id_clientes;
    }

    public static void setId_clientes(int id_clientes) {
        ModeloRegistroCliente.id_clientes = id_clientes;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        ModeloRegistroCliente.nombre = nombre;
    }

    public static String getApellido() {
        return apellido;
    }

    public static void setApellido(String apellido) {
        ModeloRegistroCliente.apellido = apellido;
    }

    public static int getTelefono() {
        return telefono;
    }

    public static void setTelefono(int telefono) {
        ModeloRegistroCliente.telefono = telefono;
    }

    public static String getDireccion() {
        return direccion;
    }

    public static void setDireccion(String direccion) {
        ModeloRegistroCliente.direccion = direccion;
    }

    public static int getIdentificacion() {
        return identificacion;
    }

    public static void setIdentificacion(int identificacion) {
        ModeloRegistroCliente.identificacion = identificacion;
    }

    public static String getNit() {
        return nit;
    }

    public static void setNit(String nit) {
        ModeloRegistroCliente.nit = nit;
    }

    public static String getSubsidio() {
        return subsidio;
    }

    public static void setSubsidio(String subsidio) {
        ModeloRegistroCliente.subsidio = subsidio;
    }

    public static String getFecha() {
        return fecha;
    }

    public static void setFecha(String fecha) {
        ModeloRegistroCliente.fecha = fecha;
    }
   
    


   
}
