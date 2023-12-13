package com.example.proyectopadel.back.entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

public class ReservarPista implements Serializable {
    private String idPista;
    private String idReserva;

    private Date fechaInicio;
    private Date fechaFin;
    private double precioFinal;
    private String nombreCliente;
    private String telefonoCliente;
    private Date fechaReserva;
    private int horaInicio;
    private int minutoInicio;
    private int minutosReserva;


    public ReservarPista() {
    }

    public ReservarPista(String idPista, String nombreCliente, String telefonoCliente, Date fechaReserva,
                         int horaInicio, int minutoInicio, int minutosReserva,
                         double precioFinal) {
        this.idReserva = UUID.randomUUID().toString();
        this.idPista = idPista;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.minutoInicio = minutoInicio;
        this.minutosReserva = minutosReserva;
        this.precioFinal = precioFinal;
    }

    public ReservarPista(String idReserva, String idPista, String nombreCliente, String telefonoCliente,
                         Date fechaReserva, int horaInicio, int minutoInicio,int minutosReserva,
                         double precioFinal) {
        this.idReserva = idReserva;
        this.idPista = idPista;
        this.nombreCliente = nombreCliente;
        this.telefonoCliente = telefonoCliente;
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.minutoInicio = minutoInicio;
        this.minutosReserva = minutosReserva;
        this.precioFinal = precioFinal;
    }


    public String getIdPista() {
        return idPista;
    }

    public void setIdPista(String idPista) {
        this.idPista = idPista;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
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

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(String telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getMinutoInicio() {
        return minutoInicio;
    }

    public void setMinutoInicio(int minutoInicio) {
        this.minutoInicio = minutoInicio;
    }

    public int getMinutosReserva() {
        return minutosReserva;
    }

    public void setMinutosReserva(int minutosReserva) {
        this.minutosReserva = minutosReserva;
    }



}
