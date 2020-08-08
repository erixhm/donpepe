package com.donpepe.modelo;


public class Delivery {
   
private int idDelivery;
private int idVenta;
private String motorizado;
private String direccion;

public Delivery (){}

    public Delivery(int idDelivery, int idVenta, String motorizado, String direccion) {
        this.idDelivery = idDelivery;
        this.idVenta = idVenta;
        this.motorizado = motorizado;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdDelivery() {
        return idDelivery;
    }

    public void setIdDelivery(int idDelivery) {
        this.idDelivery = idDelivery;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getMotorizado() {
        return motorizado;
    }

    public void setMotorizado(String motorizado) {
        this.motorizado = motorizado;
    }


    
    
    
}
