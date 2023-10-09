package com.example.proyectopadel.back.entidades;

import java.io.Serializable;

public class Pista implements Serializable {
    private Integer idPista;
    private String nombrePista;
    private String material;
    private Integer precio;
    private Integer idUsuario;

    public Pista() {
    }

    public Pista(Integer idPista, String nombrePista, String material, Integer precio) {
        this.idPista = idPista;
        this.nombrePista = nombrePista;
        this.material = material;
        this.precio = precio;
    }

    public Pista(Integer idPista, String nombre, String material, Integer precio,
                 Integer idUsuario) {
        this.idPista = idPista;
        this.nombrePista = nombre;
        this.material = material;
        this.precio = precio;
        this.idUsuario = idUsuario;
    }

    public Integer getIdPista() {
        return idPista;
    }

    public void setIdPista(Integer idPista) {
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

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

}
