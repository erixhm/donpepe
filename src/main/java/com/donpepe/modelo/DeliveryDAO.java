
package com.donpepe.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DeliveryDAO {
    PreparedStatement ps;
    ResultSet rs;
    Connection con;
    Conexion conectar = new Conexion();
    Delivery p = new Delivery();

    public List listar() {
        List<Delivery> datos = new ArrayList<>();
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement("select * from delivery ");
            rs = ps.executeQuery();
            while (rs.next()) {
                Delivery p = new Delivery();
                p.setIdDelivery(rs.getInt(1));
                p.setIdVenta(rs.getInt(2));
                p.setMotorizado(rs.getString(3));
                p.setDireccion(rs.getString(4));
                datos.add(p);
            }
        } catch (Exception e) {
        }
        return datos;
    }
    public int agregar(Delivery Pro) {  
        int r=0;
        String sql="insert into delivery(motorizado,direccion)values(?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getMotorizado());
            ps.setString(2,Pro.getDireccion());
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
   public int Actualizar(Delivery Pro) {  
        int r=0;
        String sql="update delivery set motorizado=?,direccion=? where iddelivery=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);            
            ps.setString(1,Pro.getMotorizado());
            ps.setString(2,Pro.getDireccion());
            ps.setInt(3,Pro.getIdDelivery());
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
   
   
    public int Delete(int iddelivery){
        int r=0;
        String sql="delete from delivery where iddelivery="+iddelivery;
        try {
            con=conectar.getConnection();
            ps=con.prepareStatement(sql);
            r= ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }
    
    public ArrayList<Delivery> Delivery(int iddelivery) {
        ArrayList datos = new ArrayList();
        try {
            con = conectar.getConnection();
            String sql ="select * from delivery where iddelivery=?";
            ps = con.prepareStatement(sql);
            ps.setInt(1, iddelivery);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Delivery Pro = new Delivery();
                Pro.setIdDelivery(rs.getInt(1));
                Pro.setMotorizado(rs.getString(2));
                Pro.setDireccion(rs.getString(3));
                datos.add(Pro);
            }
        } catch (Exception e) {
        }
        return datos;
    }
}

