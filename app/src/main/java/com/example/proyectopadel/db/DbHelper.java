package com.example.proyectopadel.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NOMBRE="proyectopadel.db";
    private static final String TABLE_PISTA="t_pista";
    private static final String TABLE_USUARIO="t_usuario";




    public DbHelper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_PISTA+"(  idPista integer PRIMARY KEY AUTOINCREMENT not null,\n" +
                "    nombre text,\n" +
                "    material text,\n" +
                "    precio real,\n" +
                "    idUsuario integer,\n" +
                "    FOREIGN KEY(idUsuario) REFERENCES usuario(idUsuario))");
        sqLiteDatabase.execSQL("CREATE TABLE "+TABLE_USUARIO+"(idUsuario integer primary key AUTOINCREMENT not null,\n" +
                "    nombre text,\n" +
                "    apellido1 text,\n" +
                "    apellido2 text,\n" +
                "    email text,\n" +
                "    contrasena text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
