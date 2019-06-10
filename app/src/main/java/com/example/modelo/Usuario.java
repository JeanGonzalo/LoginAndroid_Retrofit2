package com.example.modelo;

public class Usuario {


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCodalu() {
        return codalu;
    }

    public void setCodalu(String codalu) {
        this.codalu = codalu;
    }
    String error;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }


    String nombre;
    String password;
    String correo;
    String cargo;
    String codalu;
}
