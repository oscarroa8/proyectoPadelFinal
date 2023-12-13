package com.example.proyectopadel.back.interfaces;

import com.example.proyectopadel.back.entidades.Pista;
import com.google.android.gms.tasks.Task;

import java.util.List;

public interface IPista<T> extends Operaciones<T>{
    Task<List<Pista>> findAll();
    Task<Pista> getPistaById(String idPista);
}
