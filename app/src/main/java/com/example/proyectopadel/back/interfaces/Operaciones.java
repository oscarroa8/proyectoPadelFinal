package com.example.proyectopadel.back.interfaces;

import java.util.List;

public interface Operaciones <T>{
    Integer insertar(T entidad);
    void actualizar(T entidad);
    void borrar(T entidad);
    T getById(Integer id);
    List<T> findAll();
}
