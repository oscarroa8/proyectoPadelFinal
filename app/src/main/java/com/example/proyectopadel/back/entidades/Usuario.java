package com.example.proyectopadel.back.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {
    private Integer idUsuario;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String mail;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String nombre, String apellido1, String apellido2, String mail, String contrasena) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.mail = mail;
        this.contrasena = contrasena;
    }

    public Usuario(Integer idUsuario, String nombre, String apellido1, String apellido2,
                   String mail, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.mail = mail;
        this.contrasena = contrasena;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}