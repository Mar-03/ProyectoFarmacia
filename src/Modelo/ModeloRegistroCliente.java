/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import Vistas.PanelClientes;
import java.util.logging.Logger;
import Vistas.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 *
 * @author anyi4
 */
public class ModeloRegistroCliente {
    PanelClientes panelCliente;
    

    private int id_clientes;
    private String nombre;
    private String apellido; 
     private String telefono; 
    private String identificacion; 
    private String direccion; 

    private String nit;
    private boolean subsidio;
    private LocalDate fecha;
  
      

    public static String fechaActual() {
        LocalDate fecha = LocalDate.now(); 
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return fecha.format(formateador);     }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



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

    public int getId_clientes() {
        return id_clientes;
    }

    public void setId_clientes(int id_clientes) {
        this.id_clientes = id_clientes;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

   

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

   

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public boolean isSubsidio() {
        return subsidio;
    }

    public void setSubsidio(boolean subsidio) {
        this.subsidio = subsidio;
    }

}

   