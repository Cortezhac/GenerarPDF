/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Admin
 */
public class Conexion {
    private final String HOST = "jdbc:mysql://localhost:3306/bd_recursos_humanos?zeroDateTimeBehavior=convertToNull";
    private final String USUARIO = "root";
    private final String CLAVE = "";
    private final String Driver_Mysql = "com.mysql.jdbc.Driver";
    private Connection connection;
    
    public Conexion(){
        try {
            Class.forName(Driver_Mysql);
            connection = (Connection) DriverManager.getConnection(HOST,USUARIO,CLAVE);
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error con la conexion" +  e);
        }
    }
    
    public Connection getConnection(){
        return connection;
    }
}
