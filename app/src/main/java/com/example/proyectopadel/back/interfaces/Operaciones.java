package com.example.proyectopadel.back.interfaces;

import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.entidades.Usuario;
import com.google.android.gms.tasks.Task;

import java.util.List;

public interface Operaciones <T>{
    Task<String> insertar(T entidad);
    void actualizar(T entidad);
    void borrar(T entidad);
    T getById(Integer id);

}
