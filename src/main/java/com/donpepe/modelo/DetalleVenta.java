package com.donpepe.modelo;

public class DetalleVenta {
   
 private int idDetalle;
 private int idVenta;
 private int idProducto;
 private double precio_Venta;
 private int cantidad;
 
 public DetalleVenta (){}

    public DetalleVenta(int idDetalle, int idVenta, int idProducto, double precio_Venta, int cantidad) {
        this.idDetalle = idDetalle;
        this.idVenta = idVenta;
        this.idProducto = idProducto;
        this.precio_Venta = precio_Venta;
        this.cantidad = cantidad;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getIdDetalle() {
        return idDetalle;
    }

    public void setIdDetalle(int idDetalle) {
        this.idDetalle = idDetalle;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public double getPrecio_Venta() {
        return precio_Venta;
    }

    public void setPrecio_Venta(double precio_Venta) {
        this.precio_Venta = precio_Venta;
    }
 
 
 
    
    
    
    
    
}
