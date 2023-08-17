package com.example.proyectopadel.entidades;

import java.io.Serializable;

public class Equipo implements Serializable {

    private Integer idEquipo;
    private String nombre;
    private String colorPrincipal;
    private String colorSecundario;

    public Equipo(Integer idEquipo, String nombre, String colorPrincipal, String colorSecundario) {
        this.idEquipo = idEquipo;
        this.nombre = nombre;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
    }

    public Equipo() {}

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColorPrincipal() {
        return colorPrincipal;
    }

    public void setColorPrincipal(String colorPrincipal) {
        this.colorPrincipal = colorPrincipal;
    }

    public String getColorSecundario() {
        return colorSecundario;
    }

    public void setColorSecundario(String colorSecundario) {
        this.colorSecundario = colorSecundario;
    }
}
