package com.example.proyectopadel.back.entidades;

import java.io.Serializable;

public class Torneo implements Serializable {
    private Integer idTorneo;
    private String nombre;
    private int puntosRonda;
    private int nEquipos;

    public Torneo(Integer idTorneo, String nombre, int puntosRonda, int nEquipos) {
        this.idTorneo = idTorneo;
        this.nombre = nombre;
        this.puntosRonda = puntosRonda;
        this.nEquipos = nEquipos;
    }

    public Torneo() {
    }

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntosRonda() {
        return puntosRonda;
    }

    public void setPuntosRonda(int puntosRonda) {
        this.puntosRonda = puntosRonda;
    }

    public int getnEquipos() {
        return nEquipos;
    }

    public void setnEquipos(int nEquipos) {
        this.nEquipos = nEquipos;
    }
}
