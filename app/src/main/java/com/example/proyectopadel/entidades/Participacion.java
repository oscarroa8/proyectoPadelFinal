package com.example.proyectopadel.entidades;

import java.io.Serializable;
import java.util.Date;

public class Participacion implements Serializable {
    private Integer idTorneo;
    private Integer IdEquipo;
    private Date fechaInicio;
    private Date fechaFin;

    public Participacion(Integer idTorneo, Integer idEquipo, Date fechaInicio, Date fechaFin) {
        this.idTorneo = idTorneo;
        IdEquipo = idEquipo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Participacion() {
    }

    public Integer getIdTorneo() {
        return idTorneo;
    }

    public void setIdTorneo(Integer idTorneo) {
        this.idTorneo = idTorneo;
    }

    public Integer getIdEquipo() {
        return IdEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        IdEquipo = idEquipo;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }
}
