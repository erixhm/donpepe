
package com.donpepe.modelo;

public class Categoria {
    
 private int idCategoria;
 private String nombre;

 
 
 public Categoria (){}
 
    public Categoria(int idCategoria, String nombre) {
        this.idCategoria = idCategoria;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }
 
 
    
    
    
    
    
    
    
    
    
}