package com.example.proyectopadel.back.entidades;

import java.io.Serializable;

public class Pista implements Serializable {
    private String idPista;
    private String nombrePista;
    private String material;
    private Integer precio;
    private String idUsuario;

    public Pista() {
    }

    public Pista(String idPista, String nombrePista, String material, Integer precio) {
        this.idPista = idPista;
        this.nombrePista = nombrePista;
        this.material = material;
        this.precio = precio;
    }

    public Pista( String nombrePista, String material, Integer precio) {
        this.nombrePista = nombrePista;
        this.material = material;
        this.precio = precio;
    }

    public Pista(String idPista, String nombre, String material, Integer precio,
                 String idUsuario) {
        this.idPista = idPista;
        this.nombrePista = nombre;
        this.material = material;
        this.precio = precio;
        this.idUsuario = idUsuario;
    }

    public String getIdPista() {
        return idPista;
    }

    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    public String getNombrePista() {
        return nombrePista;
    }

    public void setNombrePista(String nombrePista) {
        this.nombrePista = nombrePista;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

}
