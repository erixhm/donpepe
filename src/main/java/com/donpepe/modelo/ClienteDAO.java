package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Cliente p = new Cliente();

    public List listar() {
        List<Cliente> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from cliente ");
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente p = new Cliente();
                p.setIdCliente(rs.getInt(1));
                p.setNombres(rs.getString(2));
                p.setApellidos(rs.getString(3));
                p.setDni(rs.getString(4));
                p.setDireccion(rs.getString(5));
                p.setTelefono(rs.getString(6));
                p.setCorreo(rs.getString(7));
                
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int agregar(Cliente Pro) {  
        int r=0;
        String sql="insert into cliente(nombres,apellidos,dni,direccion,telefono,correo)values(?,?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getNombres());
            ps.setString(2,Pro.getApellidos());
            ps.setString(3,Pro.getDni());
            ps.setString(4,Pro.getDireccion());
            ps.setString(5,Pro.getTelefono());
            ps.setString(6,Pro.getCorreo());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
   public int Actualizar(Cliente Pro) {  
        int r=0;
        String sql="update cliente set nombres=?,apellidos=?,dni=?,direccion=?,telefono=?,correo=? where idcliente=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getNombres());
            ps.setString(2,Pro.getApellidos());
            ps.setString(3,Pro.getDni());
            ps.setString(4,Pro.getDireccion());
            ps.setString(5,Pro.getTelefono());
            ps.setString(6,Pro.getCorreo());
            r=ps.executeUpdate();    
            if(r==1){
                return 1;
            }
            else{
                return 0;
            }
        } catch (Exception e) {
        }  
        return r;
    }
   
   
    public int Delete(int idcliente){
        int r=0;
        String sql="delete from cliente where idcliente="+idcliente;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public ArrayList<Cliente> Cliente(int idcliente) {
        ArrayList datos = new ArrayList();
        try {
            con = conectar.getConnection();
            String sql ="select * from cliente where idcliente=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idcliente);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Cliente Pro = new Cliente();
                Pro.setIdCliente(rs.getInt(1));
                Pro.setNombres(rs.getString(2));
                Pro.setApellidos(rs.getString(3));
                Pro.setDni(rs.getString(4));
                Pro.setDireccion(rs.getString(5));
                Pro.setTelefono(rs.getString(6));
                Pro.setCorreo(rs.getString(7));
                datos.add(Pro);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}

