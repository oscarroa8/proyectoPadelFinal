package com.example.proyectopadel.back.entidades;

import java.io.Serializable;

public class Material implements Serializable {
    private Integer idMaterial;
    private double precioHora;

    public Material() {
    }

    public Material(Integer idMaterial, double precioHora) {
        this.idMaterial = idMaterial;
        this.precioHora = precioHora;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
    }

    public double getPrecioHora() {
        return precioHora;
    }

    public void setPrecioHora(double precioHora) {
        this.precioHora = precioHora;
    }
}
