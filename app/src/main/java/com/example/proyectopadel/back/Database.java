package com.example.proyectopadel.back;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectopadel.back.dao.UsuarioRepositorio;
import com.example.proyectopadel.back.entidades.Rol;
import com.example.proyectopadel.back.entidades.Usuario;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;
import com.example.proyectopadel.utilidades.enums.Roles;

public class Database extends SQLiteOpenHelper {
    private final SQLiteDatabase bd;

    public Database(@Nullable Context context) {
        super(context, Constantes.DATABASE_NOMBRE, null, Constantes.DATABASE_VERSION);
        bd = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_ROLES);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_USUARIO);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_EQUIPOS);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_CLIENTE);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_PISTA);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_RESERVARPISTA);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_MATERIAL);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_ALQUILER);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_TORNEOS);
        sqLiteDatabase.execSQL(Scripts.CREAR_TABLA_PARTICIPACIONES);
        bd.insert(Scripts.TABLA_ROLES, null, rellenarRol(new Rol(Roles.ADMINISTRADOR)));
        bd.insert(Scripts.TABLA_ROLES, null, rellenarRol(new Rol(Roles.EMPLEADO)));
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_ROLES);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_USUARIOS);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_EQUIPOS);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_CLIENTES);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_PISTAS);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_RESERVARPISTA);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_MATERIAL);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_ALQUILER);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_TORNEOS);
        sqLiteDatabase.execSQL(Constantes.DROP_ORDEN + Scripts.TABLA_PARTICIPACIONES);
        bd.insert(Scripts.TABLA_ROLES, null, rellenarRol(new Rol(Roles.ADMINISTRADOR)));
        bd.insert(Scripts.TABLA_ROLES, null, rellenarRol(new Rol(Roles.EMPLEADO)));

        onCreate(sqLiteDatabase);
    }

    private ContentValues rellenarRol(Rol rol) {
        ContentValues cv = new ContentValues();
        cv.put(Scripts.CAMPO_ROL, rol.getRol().toString());
        return cv;
    }

    public void close() {
        bd.close();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////

    public Integer insertarUsuario(Usuario usuario) {
        return new UsuarioRepositorio(bd).insertar(usuario);
    }

    public void actualizarUsuario(Usuario usuario){
        new UsuarioRepositorio(bd).actualizar(usuario);
    }

    public void borrarUsuario(Usuario usuario){
        new UsuarioRepositorio(bd).borrar(usuario);
    }

}
