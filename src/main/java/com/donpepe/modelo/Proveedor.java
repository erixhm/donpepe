package com.donpepe.modelo;

public class Proveedor {
    
private int idProveedor;
private String nombre;
private int ruc;
private String direccion;

public Proveedor (){}

    public Proveedor(int idProveedor, String nombre, int ruc, String direccion) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.ruc = ruc;
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRuc() {
        return ruc;
    }

    public void setRuc(int ruc) {
        this.ruc = ruc;
    }

   
    
    
    
    
}
