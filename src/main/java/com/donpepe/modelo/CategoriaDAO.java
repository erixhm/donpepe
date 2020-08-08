package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Categoria p = new Categoria();

    public List listar() {
        List<Categoria> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from categoria ");
            rs = ps.executeQuery();
            while (rs.next()) {
                Categoria p = new Categoria();
                p.setIdCategoria(rs.getInt(1));
                p.setNombre(rs.getString(2));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int agregar(Categoria Pro) {  
        int r=0;
        String sql="insert into categoria(nombre)values(?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getNombre());
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
   public int Actualizar(Categoria Pro) {  
        int r=0;
        String sql="update categoria set nombre=? where idcategoria=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getNombre());
            ps.setInt(2,Pro.getIdCategoria());
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
   
   
    public int Delete(int idcategoria){
        int r=0;
        String sql="delete from categoria where idcategoria="+idcategoria;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public ArrayList<Categoria> Categoria(int idcategoria) {
        ArrayList datos = new ArrayList();
        try {
            con = conectar.getConnection();
            String sql ="select * from categoria where idcategoria=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, idcategoria);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Categoria Pro = new Categoria();
                Pro.setIdCategoria(rs.getInt(1));
                Pro.setNombre(rs.getString(2));
                datos.add(Pro);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}


