package com.example.proyectopadel.entidades;

import java.io.Serializable;

public class Rol implements Serializable {
    private Integer idRol;

    public Rol(Integer idRol) {
        this.idRol = idRol;
    }

    public Rol() {
    }

    public Integer getIdRol() {
        return idRol;
    }

    public void setIdRol(Integer idRol) {
        this.idRol = idRol;
    }
}
