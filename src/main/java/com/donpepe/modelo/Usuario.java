package com.donpepe.modelo;

public class Usuario {
    int id;
   String nombres;
   String apellidos;
   String correo;
   String rol;
   
   public Usuario (){}
   
   public Usuario (int id, String nombres, String apellidos, String correo, String rol){
       this.id = id;
       this.nombres = nombres;
       this.apellidos = apellidos;
       this.correo = correo;
       this.rol = rol;
   }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
