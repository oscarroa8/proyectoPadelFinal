package com.example.proyectopadel.back.interfaces;

import com.example.proyectopadel.back.entidades.ReservarPista;
import com.google.android.gms.tasks.Task;

import java.util.List;

public interface IReservarPista<T> extends Operaciones<T>{

    Task<List<ReservarPista>> findAllByPista(String idPista);
}
