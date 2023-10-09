package com.example.proyectopadel.back.interfaces;

import com.example.proyectopadel.back.entidades.Usuario;

public interface IUsuario<T> extends Operaciones<T> {
    Usuario obtenerUsuarioPorUsuarioYContrasena(String usuario, String contrasena) throws Exception;

    Usuario obtenerUsuarioPorEmailYContrasena(String email, String contrasena) throws Exception;


}
