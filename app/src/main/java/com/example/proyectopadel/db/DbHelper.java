package com.example.proyectopadel.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectopadel.utilidades.Utilidades;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=3;
    private static final String DATABASE_NOMBRE="proyectoPadel.db";
    private final SQLiteDatabase bd;

    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
        bd = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_EQUIPOS);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_CLIENTE);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PISTA);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_ALQUILER);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_MATERIAL);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_PARTICIPACIONES);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_RESERVARPISTA);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_ROLES);
        sqLiteDatabase.execSQL(Utilidades.CREAR_TABLA_TORNEOS);



    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_USUARIOS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_CLIENTES);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+Utilidades.TABLA_PISTAS);
        onCreate(sqLiteDatabase);
    }
        //Insertamos los datos del login en la tabla

    //Metodo para comprobar que el email  este ya introducido en la base de datos
    public Boolean checkEmail(String email){
        Cursor cursor = bd.rawQuery("Select * from usuario where email = ?", new String[]{email});
        if (cursor.getCount()>0 ){
            return true;
        }else{
            return false;
        }
    }
//Metodo para comprobar la contraseña del email
    public Boolean checkContrasena(String email,String contrasena){
        Cursor cursor = bd.rawQuery("Select * from usuario where email = ? and password = ?", new String[]{email,contrasena});
        if (cursor.getCount()>0 ){
            return true;
        }else{
            return false;
        }
    }


    public void close() {
        bd.close();
    }
}
