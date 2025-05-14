/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Conector;

import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author jhosu
 */
public class DBConnection {

    private final String HOST = "sql.freedb.tech";
    private final String USUARIO = "freedb_UserPruebas";
    private final String CLAVE = "bnRB@krf4&bB#72";
    private final String BASEDATOS = "freedb_FarmaciaSocial";
    private final String URL;

    private Connection link;
    private PreparedStatement ps;

    public DBConnection() {
        this.URL = "jdbc:mysql://" + this.HOST + "/" + this.BASEDATOS;
    }

    public void conectar() {
        try {
            this.link = DriverManager.getConnection(this.URL, this.USUARIO, this.CLAVE);
        } catch (IllegalArgumentException | SecurityException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void desconectar() {
        try {
            if (link != null && !link.isClosed()) {
                this.link.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public PreparedStatement preparar(String sql) {
        try {
            ps = link.prepareStatement(sql);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return ps;
    }
//    public class ConexionBD {
//    private static final String URL = "jdbc:mysql://localhost:3306/farmacia_social?serverTimezone=UTC";
//    private static final String USUARIO = "root"; 
//    private static final String CONTRASENA = "umg$123456"; 
//
//    
//     // ESTABLECER LA CONEXIÓN
//    public static Connection getConnection() {
//    
//        Connection conn = null;
//        
//        try {
//            conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
//        } catch (SQLException e) {
//            System.out.println("Error en la conexión de BD: " + e.getMessage());
//        }
//        
//        return conn;
//        
//    }
//}
}
