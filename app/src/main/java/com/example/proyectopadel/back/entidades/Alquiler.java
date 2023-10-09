package com.example.proyectopadel.back.entidades;

import java.io.Serializable;
import java.util.Date;

public class Alquiler implements Serializable {
    private Integer idMaterial;
    private Integer idCliente;
    private Date fechaInicio;
    private Date fechaFin;
    private double precioFinal;

    public Alquiler() {
    }

    public Alquiler(Integer idMaterial, Integer idCliente, Date fechaInicio, Date fechaFin,
                    double precioFinal) {
        this.idMaterial = idMaterial;
        this.idCliente = idCliente;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.precioFinal = precioFinal;
    }

    public Integer getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Integer idMaterial) {
        this.idMaterial = idMaterial;
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
