package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsuarioDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Usuario usu = new Usuario();
    
    public ArrayList<Usuario> logueo(String usuario, String clave) {
        ArrayList datos = new ArrayList();
        try {
            con = conectar.getConnection();
            String sql ="select idusuario,nombres,apellidos,correo,rol from usuario where correo=? and clave=?";
                
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.setString(2, clave);
                
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Usuario usu = new Usuario();
                usu.setId(rs.getInt(1));
                usu.setNombres(rs.getString(2));
                usu.setApellidos(rs.getString(3));
                usu.setCorreo(rs.getString(4));
                usu.setRol(rs.getString(5));
                datos.add(usu);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}
