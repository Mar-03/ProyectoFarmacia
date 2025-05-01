/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author Usuario
 */

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/farmacia_social?serverTimezone=UTC";
    private static final String USUARIO = "root"; 
    private static final String CONTRASENA = "umg$123456"; 

    
     // ESTABLECER LA CONEXIÓN
    public static Connection getConnection() {
    
        Connection conn = null;
        
        try {
            conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
        } catch (SQLException e) {
            System.out.println("Error en la conexión de BD: " + e.getMessage());
        }
        
        return conn;
        
    }
}
