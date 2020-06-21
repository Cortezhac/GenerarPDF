/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Interfaces.CRUD;
import Model.Conexion;
import Model.Persona;
import com.mysql.jdbc.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class DAOPersona implements CRUD{
    Conexion con = new Conexion();
    Connection com;
    ResultSet  miResultSet;
    
    @Override
    public List<Persona> listar() {
        ArrayList<Persona> Resultados = new ArrayList<>();
        try {
            String SqlQuery = "SELECT * FROM tb_persona";
            Statement sqlStatement;
            com = con.getConnection();
            sqlStatement = com.createStatement();
            miResultSet = sqlStatement.executeQuery(SqlQuery);
            while (miResultSet.next()) {
                Persona persona = new Persona(miResultSet.getString("dui_persona"),
                                              miResultSet.getString("apellidos_persona"), 
                                              miResultSet.getString("nombre_persona"));
                Resultados.add(persona);
            }
        } catch (SQLException e) {
            System.out.println("Che la has regado en listar " + e);
        }
        return Resultados;
    }
    
}
