/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Implementacion.RegistroUsuarioImp;
import Modelo.ModeloRegistroUsuario;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jhosu
 */
public class ControladorRegistroUsuario implements MouseListener {

    ModeloRegistroUsuario modelo;

    RegistroUsuarioImp implementacion = new RegistroUsuarioImp();

    public ControladorRegistroUsuario(ModeloRegistroUsuario modelo) {
        this.modelo = modelo;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getComponent().equals(modelo.getVistaRegistro().btnRegistrar)) {
            inputisEmpty();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaRegistro().btnRegistrar)) {
            modelo.getVistaRegistro().btnRegistrar.setBackground(new Color(50, 95, 110));
        } else if (e.getComponent().equals(modelo.getVistaRegistro().btnBorrar)) {
            modelo.getVistaRegistro().btnBorrar.setBackground(new Color(50, 95, 110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getComponent().equals(modelo.getVistaRegistro().btnRegistrar)) {
            modelo.getVistaRegistro().btnRegistrar.setBackground(new Color(75, 128, 146));
        } else if (e.getComponent().equals(modelo.getVistaRegistro().btnBorrar)) {
            modelo.getVistaRegistro().btnBorrar.setBackground(new Color(75, 128, 146));
        }

    }

    public void inputisEmpty() {

        if (modelo.getVistaRegistro().txtNombreUsuario.getText().isEmpty()
                || modelo.getVistaRegistro().txtApellidoUsuario.getText().isEmpty()
                || modelo.getVistaRegistro().txtPassword.getPassword().equals("")
                || modelo.getVistaRegistro().txtTelefono.getText().isEmpty()
                || modelo.getVistaRegistro().txtEmail.getText().isEmpty()
                || modelo.getVistaRegistro().txtActivo.getText().isEmpty()
                || modelo.getVistaRegistro().boxTipoUsuario.getSelectedItem() == null) {
//warning
            JOptionPane.showInternalMessageDialog(null, "Por favor debe de ingresar todos los datos", "ADVERTENCIA \"DATOS VACIOS\"", JOptionPane.WARNING_MESSAGE);
        } else {
            capturaDeDatos();

            limpiarDatos();
        }

    }

    public void capturaDeDatos() {

        String nombreIngresado = modelo.getVistaRegistro().txtNombreUsuario.getText();
        String apellidoIngresado = modelo.getVistaRegistro().txtApellidoUsuario.getText();
        String contraseniaIngresada = String.valueOf(modelo.getVistaRegistro().txtPassword.getPassword());
        String telefonoIngresado = modelo.getVistaRegistro().txtTelefono.getText();
        String emailIngresado = modelo.getVistaRegistro().txtEmail.getText();
        String usuarioActivo = modelo.getVistaRegistro().txtActivo.getText();

        creacionDeUsuario(nombreIngresado, apellidoIngresado, contraseniaIngresada, telefonoIngresado, emailIngresado, usuarioActivo);
    }

    public void creacionDeUsuario(String nombreIngre, String apellidoIngre, String contraIngre, String telefonoIngre, String emailIngre, String usuarioActivo) {

        ModeloRegistroUsuario model = new ModeloRegistroUsuario();

        model.setNombreUsuario(nombreIngre);
        model.setApellidoUsuario(apellidoIngre);
        model.setContraseniaUsuario(contraIngre);
        model.setNumeroUsuario(telefonoIngre);
        model.setEmailUsuario(emailIngre);

        boolean creacionUsuario = implementacion.guardarUsuario(model);
        
        if (creacionUsuario == true) {
            JOptionPane.showInternalMessageDialog(null, "Usuario creado con éxito", "\"CREACIÓN DE USUARIOS\"", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showInternalMessageDialog(null, "Error en la creación del usuario", "ERROR \"ERROR AL CREAR USUARIO\"", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void limpiarDatos() {

        modelo.getVistaRegistro().txtNombreUsuario.setText("");
        modelo.getVistaRegistro().txtApellidoUsuario.setText("");
        modelo.getVistaRegistro().txtPassword.setText("");
        modelo.getVistaRegistro().txtTelefono.setText("");
        modelo.getVistaRegistro().txtEmail.setText("");
        modelo.getVistaRegistro().txtActivo.setText("");
        modelo.getVistaRegistro().boxTipoUsuario.setSelectedIndex(0);

    }

}
