package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProveedorDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Proveedor p = new Proveedor();

    public List listar() {
        List<Proveedor> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from proveedor ");
            rs = ps.executeQuery();
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setIdProveedor(rs.getInt(1));
                p.setNombre(rs.getString(2));
                p.setRuc(rs.getInt(3));
                p.setDireccion(rs.getString(4));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int agregar(Proveedor Pro) {  
        int r=0;
        String sql="insert into proveedor(nombre,ruc,direccion)values(?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getNombre());
            ps.setInt(2,Pro.getRuc());
            ps.setString(3, Pro.getDireccion());
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
   public int Actualizar(Proveedor Pro) {  
        int r=0;
        String sql="update proveedor set nombre=?,ruc=?,direccion=? where idproveedor=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getNombre());
            ps.setInt(2,Pro.getRuc());
            ps.setString(3,Pro.getDireccion());
            ps.setInt(4,Pro.getIdProveedor());
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
   
   
    public int Delete(int idproveedor){
        int r=0;
        String sql="delete from proveedor where idproveedor="+idproveedor;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public ArrayList<Proveedor> Proveedor(int idproveedor) {
        ArrayList datos = new ArrayList();
        try {
            con = conectar.getConnection();
            String sql ="select * from proveedor where idproveedor=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idproveedor);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Proveedor Pro = new Proveedor();
                Pro.setIdProveedor(rs.getInt(1));
                Pro.setNombre(rs.getString(2));
                Pro.setRuc(rs.getInt(3));
                Pro.setDireccion(rs.getString(4));
                datos.add(Pro);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}

