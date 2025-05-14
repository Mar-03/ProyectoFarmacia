package Implementacion;

import Conector.DBConnection;
import Conector.SQL;
import Interfaces.IRegistroUsuario;
import Modelo.ModeloRegistroUsuario;
import javax.swing.DefaultComboBoxModel;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author jhosu
 */
public class RegistroUsuarioImp implements IRegistroUsuario {

    DBConnection conector = new DBConnection();
    SQL sql = new SQL();
    PreparedStatement ps;
    ResultSet rs;

    @Override
    public boolean guardarUsuario(ModeloRegistroUsuario modelo) {
        boolean resultado = false;
        
        conector.conectar();
        
        try {
           
            ps.setString(1, modelo.getNombreUsuario());
            ps.setString(2, modelo.getApellidoUsuario());
        } catch (Exception e) {
        }
        
        
        
       
    }

    @Override
    public DefaultComboBoxModel mostrarTiposUsuarios() {
    }

    @Override
    public boolean elimiarUsuario(String nombreU) {
    }

    @Override
    public ModeloRegistroUsuario validarUsuario(String nombreU, String contraU) {
    }

}
