/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author cindy
 */
import Interfaces.IRegistroCliente;
import Modelo.ModeloRegistroCliente;
import Vistas.PanelClientes;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;


public class ControladorCliente implements MouseListener {
    private final PanelClientes vista;
    private final IRegistroCliente impl;

    public ControladorCliente(PanelClientes vista, IRegistroCliente impl) {
        this.vista = vista;
        this.impl = impl;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    
    }

   
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
}

