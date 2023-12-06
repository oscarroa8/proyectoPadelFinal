package com.example.proyectopadel.back.entidades;

import java.io.Serializable;
import java.util.UUID;

public class Pista implements Serializable {
    private String idPista;
    private String nombre;
    private String material;
    private Integer precio;

    public Pista() {
    }

    public Pista(String idPista, String nombre, String material, Integer precio) {
        this.idPista = idPista;
        this.nombre = nombre;
        this.material = material;
        this.precio = precio;
    }

    public Pista( String nombre, String material, Integer precio) {
        this.idPista = UUID.randomUUID().toString();//Crea una secuencia de caracteres aleatoria que nunca se repite
        this.nombre = nombre;
        this.material = material;
        this.precio = precio;
    }



    public String getIdPista() {
        return idPista;
    }

    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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



}
