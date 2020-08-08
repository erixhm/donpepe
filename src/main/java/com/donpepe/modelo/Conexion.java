package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexion {
    String url="jdbc:mysql://localhost:3308/sis_venta?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String DRIVER = "com.mysql.jdbc.Driver";
    String user="root";
    String pass="mysql";  
    
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName(DRIVER).newInstance();
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {            
        }
        return con;
    }
}



