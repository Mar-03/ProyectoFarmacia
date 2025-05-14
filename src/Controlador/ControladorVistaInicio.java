package Controlador;

import Implementacion.SesionInicioImp;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import Modelo.ModeloVistaInicio;
import Vistas.VistaAdmin;
import Vistas.VistaVendedor;
import javax.swing.JOptionPane;

/**
 *
 * @author jhosu
 */
public class ControladorVistaInicio implements MouseListener {

    ModeloVistaInicio modelo;

    public ControladorVistaInicio(ModeloVistaInicio modelo) {
        this.modelo = modelo;
    }

    SesionInicioImp implementacion = new SesionInicioImp();

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getComponent().equals(modelo.getVistaInicio().btnAcceder)) {
            inputIsEmpty();
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

        if (e.getComponent().equals(modelo.getVistaInicio().btnAcceder)) {
            modelo.getVistaInicio().btnAcceder.setBackground(new Color(50, 95, 110));
        }
    }

    @Override
    public void mouseExited(MouseEvent e) {

        if (e.getComponent().equals(modelo.getVistaInicio().btnAcceder)) {
            modelo.getVistaInicio().btnAcceder.setBackground(new Color(75, 128, 146));
        }
    }

    public void vallidarUsuario(String tipoUsuario, String usuarioIngresado, String contraIngresada, String usuarioEncontrado, String contraEncontrada) {

        String usuarioAdmin = "ADMINISTRADOR";
        String usuarioVend = "VENDEDOR";

        if (tipoUsuario.equals(usuarioAdmin)) {
            if (usuarioIngresado.equals(usuarioEncontrado) && contraIngresada.equals(contraEncontrada)) {
                VistaAdmin vistaAdmin = new VistaAdmin();
                vistaAdmin.setVisible(true);
                modelo.getVistaInicio().dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión, usuario o contrasenia incorrectos", "ERROR INICIO DE SESIÓN", JOptionPane.ERROR_MESSAGE);
            }
        } else if (tipoUsuario.equals(usuarioVend)) {
            if (usuarioIngresado.equals(usuarioEncontrado) && contraIngresada.equals(contraEncontrada)) {
                VistaVendedor vistaVendedor = new VistaVendedor();
                vistaVendedor.setVisible(true);
                modelo.getVistaInicio().dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Iniciar Sesión, usuario o contrasenia incorrectos", "ERROR INICIO DE SESIÓN", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void inputIsEmpty() {

        if (modelo.getVistaInicio().txtUsuario.getText().isEmpty() || modelo.getVistaInicio().txtContraseña.getText().isEmpty()) {
            JOptionPane.showInternalMessageDialog(null, "Por favor debe de ingresar todos los datos", "ERROR \"DATOS VACIOS\"", JOptionPane.ERROR_MESSAGE);
        } else {
            capturaDeDatos();
        }
    }

    public void capturaDeDatos() {

        String usuarioIngresado = modelo.getVistaInicio().txtUsuario.getText();
        String contraseniaIngresada = modelo.getVistaInicio().txtContraseña.getText();

        ModeloVistaInicio model = implementacion.consultaUsuario(usuarioIngresado, contraseniaIngresada);

        String usuarioEncontrado = model.getUsuarioEncontrado();
        String contraseniaEncontrada = model.getContraseniaEncontrada();
        String tipoDeUsuario = model.getTipoUsuario();

        vallidarUsuario(tipoDeUsuario, usuarioIngresado, contraseniaIngresada, usuarioEncontrado, contraseniaEncontrada);
    }
}
