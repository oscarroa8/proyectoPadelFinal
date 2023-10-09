package com.example.proyectopadel.back.entidades;

import java.io.Serializable;

public class Equipo implements Serializable {

    private Integer idEquipo;
    private String nombreEquipo;
    private String colorPrincipal;
    private String colorSecundario;

    public Equipo() {
    }

    public Equipo(Integer idEquipo, String nombre, String colorPrincipal, String colorSecundario) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombre;
        this.colorPrincipal = colorPrincipal;
        this.colorSecundario = colorSecundario;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
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
