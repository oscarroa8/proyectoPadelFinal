package com.example.proyectopadel.back.interfaces;

public interface Operaciones <T>{
    Integer insertar(T entidad);
    void actualizar(T entidad);
    void borrar(T entidad);
    T getById(Integer id);
}
