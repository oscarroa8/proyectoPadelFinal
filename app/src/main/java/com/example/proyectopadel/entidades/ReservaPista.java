package com.example.proyectopadel.entidades;

import java.io.Serializable;
import java.util.Date;

public class ReservaPista implements Serializable {
    private Integer idPista;
    private Integer idCliente;
    private Date fechaInicio;
    private Date fechaFin;
    private double precioFinal;

    public ReservaPista(Integer idPista, Integer idCliente, Date fechaInicio, Date fechaFin, double precioFinal) {
        this.idPista = idPista;
        this.idCliente = idCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioFinal = precioFinal;
    }

    public ReservaPista() {
    }

    public Integer getIdPista() {
        return idPista;
    }

    public void setIdPista(Integer idPista) {
        this.idPista = idPista;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
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

    public double getPrecioFinal() {
        return precioFinal;
    }

    public void setPrecioFinal(double precioFinal) {
        this.precioFinal = precioFinal;
    }
}
