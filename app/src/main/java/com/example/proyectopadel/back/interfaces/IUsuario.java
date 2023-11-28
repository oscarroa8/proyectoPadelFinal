package com.example.proyectopadel.back.interfaces;

import com.example.proyectopadel.back.entidades.Usuario;
import com.google.android.gms.tasks.Task;

import java.util.List;

public interface IUsuario<T> extends Operaciones<T> {
    Task<List<Usuario>> findAllUsuarios();

    Usuario obtenerUsuarioPorUsuarioYContrasena(String usuario, String contrasena) throws Exception;

    Usuario obtenerUsuarioPorEmailYContrasena(String email, String contrasena) throws Exception;


}
