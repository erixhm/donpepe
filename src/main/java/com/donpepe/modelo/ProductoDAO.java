package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Producto p = new Producto();

    public List listar() {
        List<Producto> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from producto ");
            rs = ps.executeQuery();
            while (rs.next()) {
                Producto p = new Producto();
                p.setIdProducto(rs.getInt(1));
                p.setIdCategoria(rs.getInt(2));
                p.setIdProveedor(rs.getInt(3));
                p.setCodigo(rs.getString(4));
                p.setNombre(rs.getString(5));
                p.setStock(rs.getInt(6));
                p.setPrecio(rs.getDouble(7));
                p.setDescripcion(rs.getString(8));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int agregar(Producto Pro) {  
        int r=0;
        String sql="insert into producto(codigo,nombre,stock,precio,descripcion)values(?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1,Pro.getCodigo());            
            ps.setString(2,Pro.getNombre());
            ps.setInt(3,Pro.getStock());
            ps.setDouble(4,Pro.getPrecio());
            ps.setString(5, Pro.getDescripcion());
            
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
   public int Actualizar(Producto Pro) {  
        int r=0;
        String sql="update producto set codigo=?,nombre=?,stock=?,precio=?,descripcion=? where idproducto=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getCodigo());
            ps.setString(2,Pro.getNombre());
            ps.setInt(3,Pro.getStock());
            ps.setDouble(4,Pro.getPrecio());
            ps.setString(5,Pro.getDescripcion());
            ps.setInt(6,Pro.getIdProducto());
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
   
   
    public int Delete(int idproducto){
        int r=0;
        String sql="delete from producto where idproducto="+idproducto;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public ArrayList<Producto> Producto(int idproducto) {
        ArrayList datos = new ArrayList();
        try {
            con = conectar.getConnection();
            String sql ="select * from producto where idproducto=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idproducto);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Producto Pro = new Producto();
                Pro.setIdProducto(rs.getInt(1));
                Pro.setIdCategoria(rs.getInt(2));
                Pro.setIdProveedor(rs.getInt(3));
                Pro.setCodigo(rs.getString(4));
                Pro.setNombre(rs.getString(5));
                Pro.setStock(rs.getInt(6));
                Pro.setPrecio(rs.getDouble(7));
                Pro.setDescripcion(rs.getString(8));
                datos.add(Pro);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}


               