package com.example.proyectopadel.back.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.entidades.Usuario;
import com.example.proyectopadel.back.interfaces.IUsuario;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Objects;

public class UsuarioRepositorio implements IUsuario<Usuario> {
    private final SQLiteDatabase bd;

    public UsuarioRepositorio(SQLiteDatabase bd) {
        this.bd = bd;
    }


    @Override
    public Task<String> insertar(Usuario usuario) {
        throw new UnsupportedOperationException();
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
        String SQL = Constantes.SELECCIONAR_TODO + Scripts.TABLA_USUARIOS + Constantes.DONDE + Scripts.CAMPO_IDUSUARIO + Constantes.SIMBOLO_IGUAL + id;
        Cursor c = bd.rawQuery(SQL, new String[]{String.valueOf(id)});
        c.moveToFirst();
        Usuario usuario = cursorAUsuario(c);
        Objects.requireNonNull(c).close();
        return usuario;
    }

    //@Override
   public Usuario obtenerUsuarioPorUsuarioYContrasena(String usuario, String contrasena) throws Exception {
       throw new UnsupportedOperationException();
       /* String SQL = contexto.getResources().getString(R.string.OBTENER_USUARIO_POR_USUARIO_Y_CONTRASENA);
        Cursor c = bd.rawQuery(SQL, new String[]{usuario, contrasena});
        c.moveToFirst();
        Usuario usu= cursorAUsuario(c);
        Objects.requireNonNull(c).close();
        return usu;*/
    }

    @Override
    public Usuario obtenerUsuarioPorEmailYContrasena(String email, String contrasena) throws Exception {
      /*  String SQL = contexto.getResources().getString(R.string.OBTENER_USUARIO_POR_EMAIL_Y_CONTRASENA);
        Cursor c = bd.rawQuery(SQL, new String[]{email, contrasena});
        c.moveToFirst();
        Usuario usuario = cursorAUsuario(c);
        Objects.requireNonNull(c).close();
        return usuario;*/
        throw new UnsupportedOperationException();
    }
    @Override
    public Task<List<Pista>> findAll() {

        throw new UnsupportedOperationException();
    }

    private Usuario cursorAUsuario(Cursor c) {
        return new Usuario(c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_IDUSUARIO)),
                c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_NOMBREUSUARIO)),
                c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_APELLIDO1USU)),
                c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_APELLIDO2USU)),
                c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_EMAILUSU)),
                c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_CONTRASENAUSU)));
    }

    private ContentValues rellenarUsuario(Usuario usuario) {
        ContentValues cv = new ContentValues();
        cv.put(Scripts.CAMPO_NOMBREUSUARIO, usuario.getNombre());
        cv.put(Scripts.CAMPO_APELLIDO1USU, usuario.getApellido1());
        cv.put(Scripts.CAMPO_APELLIDO2USU, usuario.getApellido2());
        cv.put(Scripts.CAMPO_EMAILUSU, usuario.getMail());
        cv.put(Scripts.CAMPO_CONTRASENAUSU, usuario.getContrasena());
        return cv;
    }



    //endregion

}
