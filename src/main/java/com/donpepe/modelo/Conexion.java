package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author PC
 */
public class Conexion {
    String url="jdbc:mysql://localhost/sis_venta?useLegacyDatetimeCode=false&serverTimezone=America/Lima";
    String user="root";
    String pass="mysql";    
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {            
        }
        return con;
    }
}
