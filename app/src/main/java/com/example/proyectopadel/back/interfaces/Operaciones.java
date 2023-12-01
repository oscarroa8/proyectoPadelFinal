package com.example.proyectopadel.back.interfaces;

import com.google.android.gms.tasks.Task;

public interface Operaciones <T>{
    Task<String> insertar(T entidad);
    void actualizar(T entidad);
    Task<Void> borrar(T entidad);
    T getById(Integer id);

}
