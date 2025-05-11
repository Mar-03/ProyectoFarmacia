package Implementacion;

import Conector.DBConnection;
import Conector.SQL;
import Interfaces.ISesionInicio;
import Modelo.ModeloVistaInicio;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SesionInicioImp implements ISesionInicio{

    DBConnection conector = new DBConnection();
    SQL sql = new SQL();
    PreparedStatement ps;
    ResultSet rs;
    
    @Override
    public ModeloVistaInicio consultaUsuario(String usuario, String contrasenia) {
    
        ModeloVistaInicio modelo = new ModeloVistaInicio();
        conector.conectar();
        
        try {
            ps = conector.preparar(sql.getCONSULTA_USUARIO());
            
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            
            while(rs.next()){
                modelo.setIdUsuarioEncontrado(rs.getInt("id_usuario"));
                modelo.setUsuarioEncontrado(rs.getString("nombre_usuario"));
                modelo.setContraseniaEncontrada(rs.getString("contrasenia_usuario"));
                modelo.setTipoUsuario(Integer.parseInt("tipo_usuario"));
            }
            conector.desconectar();
            
        } catch (Exception e) {
            System.out.println("Error en la consulta");
        }
    return modelo;
    }
    
    
    
}
