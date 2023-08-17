package com.example.proyectopadel.entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
    private Integer idCliente;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String email;
    private String telefono;

    public Cliente(Integer idCliente, String nombre, String apellido1, String apellido2, String email, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente() {}

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefonoContrasena(String telefono) {
        this.telefono = telefono;
    }
}
