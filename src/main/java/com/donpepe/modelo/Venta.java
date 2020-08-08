
package com.donpepe.modelo;

import java.util.Date;


public class Venta {
   
private int idVenta;
private int idCliente;
private int idUsuario;
private String numSerie;
private Date fecha;
private double total_Venta;
private String estado;
private String origen;

public Venta (){}    

    public Venta(int idVenta, int idCliente, int idUsuario, String numSerie, Date fecha, double total_Venta, String estado, String origen) {
        this.idVenta = idVenta;
        this.idCliente = idCliente;
        this.idUsuario = idUsuario;
        this.numSerie = numSerie;
        this.fecha = fecha;
        this.total_Venta = total_Venta;
        this.estado = estado;
        this.origen = origen;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(String numSerie) {
        this.numSerie = numSerie;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getTotal_Venta() {
        return total_Venta;
    }

    public void setTotal_Venta(double total_Venta) {
        this.total_Venta = total_Venta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
