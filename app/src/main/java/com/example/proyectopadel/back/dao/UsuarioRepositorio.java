package com.example.proyectopadel.back.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.entidades.Rol;
import com.example.proyectopadel.back.entidades.Usuario;
import com.example.proyectopadel.back.interfaces.IUsuario;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;
import com.example.proyectopadel.utilidades.enums.Roles;

import java.util.Objects;

public class UsuarioRepositorio implements IUsuario<Usuario> {
    private final SQLiteDatabase bd;
    private final Context contexto;

    public UsuarioRepositorio(SQLiteDatabase bd, Context contexto) {
        this.bd = bd;
        this.contexto = contexto;
    }

    @Override
    public Integer insertar(Usuario usuario) {
        return (int) bd.insert(Scripts.TABLA_USUARIOS, null, rellenarUsuario(usuario));
    }

    @Override
    public void actualizar(Usuario usuario) {
        bd.update(Scripts.TABLA_USUARIOS, rellenarUsuario(usuario), Scripts.CAMPO_IDUSUARIO
                + Constantes.SIMBOLO_IGUAL + usuario.getIdUsuario(), null);
    }

    @Override
    public void borrar(Usuario usuario) {
        bd.delete(Scripts.TABLA_USUARIOS, Scripts.CAMPO_IDUSUARIO
                + Constantes.SIMBOLO_IGUAL + usuario.getIdUsuario(), null);
    }

    @Override
    public Usuario getById(Integer id) {
        String SQL = contexto.getResources().getString(R.string.OBTENER_USUARIO_POR_ID);
        Cursor c = bd.rawQuery(SQL, new String[]{String.valueOf(id)});
        return buscarUsuarioUnico(c);
    }

    @Override
    public Usuario obtenerUsuarioPorUsuarioYContrasena(String usuario, String contrasena) throws Exception {
        String SQL = contexto.getResources().getString(R.string.OBTENER_USUARIO_POR_USUARIO_Y_CONTRASENA);
        Cursor c = bd.rawQuery(SQL, new String[]{usuario, contrasena});
        return buscarUsuarioUnico(c);
    }

    @Override
    public Usuario obtenerUsuarioPorEmailYContrasena(String email, String contrasena) throws Exception {
        String SQL = contexto.getResources().getString(R.string.OBTENER_USUARIO_POR_EMAIL_Y_CONTRASENA);
        Cursor c = bd.rawQuery(SQL, new String[]{email, contrasena});
        return buscarUsuarioUnico(c);
    }

    //region metodos auxiliares

    private ContentValues rellenarUsuario(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put(Scripts.CAMPO_NOMBREUSUARIO, usuario.getNombre());
        cv.put(Scripts.CAMPO_APELLIDO1USU, usuario.getApellido1());
        cv.put(Scripts.CAMPO_APELLIDO2USU, usuario.getApellido2());
        cv.put(Scripts.CAMPO_EMAILUSU, usuario.getMail());
        cv.put(Scripts.CAMPO_CONTRASENAUSU, usuario.getContrasena());
        return cv;
    }

    private Usuario buscarUsuarioUnico(Cursor c) {
        Usuario usuario = null;
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                usuario = new Usuario(c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_IDUSUARIO)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_NOMBREUSUARIO)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_APELLIDO1USU)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_APELLIDO2USU)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_EMAILUSU)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_CONTRASENAUSU)));
            } while (c.moveToNext());
        }
        Objects.requireNonNull(c).close();
        return usuario;
    }

    //endregion

}
