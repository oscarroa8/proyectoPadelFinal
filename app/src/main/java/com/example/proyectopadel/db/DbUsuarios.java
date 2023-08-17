package com.example.proyectopadel.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.proyectopadel.utilidades.Utilidades;

public class DbUsuarios extends DbHelper {
    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context=context;
    }

    public long insertarUsuario(String nombre, String apellido1, String apellido2, String mail, String contrasena){
        long resultado=0;
        try{
            DbHelper db = new DbHelper(context);
            SQLiteDatabase database = db.getWritableDatabase();
            ContentValues cv = new ContentValues();
            cv.put("nombre",nombre);
            cv.put("apellido1",apellido1);
            cv.put("apellido2",apellido2);
            cv.put("email",mail);
            cv.put("contrasena",contrasena);
            resultado = database.insert(Utilidades.TABLA_USUARIOS,null,cv);
        }catch (Exception ex){
            ex.toString();
        }

        return resultado;
    }
}
