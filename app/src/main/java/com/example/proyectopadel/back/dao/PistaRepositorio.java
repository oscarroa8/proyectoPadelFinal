package com.example.proyectopadel.back.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.entidades.Torneo;
import com.example.proyectopadel.back.interfaces.IPista;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;

import java.util.Objects;

public class PistaRepositorio implements IPista<Pista> {
    private final SQLiteDatabase bd;

    public PistaRepositorio(SQLiteDatabase bd) {
        this.bd = bd;
    }

    @Override
    public Integer insertar(Pista pista) {
        return (int) bd.insert(Scripts.TABLA_PISTAS, null, rellenarPista(pista));

    }

    @Override
    public void actualizar(Pista pista) {
        bd.update(Scripts.TABLA_PISTAS, rellenarPista(pista), Scripts.CAMPO_IDPISTA
                + Constantes.SIMBOLO_IGUAL + pista.getIdPista(), null);
    }

    @Override
    public void borrar(Pista pista) {
        bd.delete(Scripts.TABLA_PISTAS, Scripts.CAMPO_IDPISTA
                + Constantes.SIMBOLO_IGUAL + pista.getIdPista(), null);
    }

    @Override
    public Pista getById(Integer id) {
        String SQL = Constantes.SELECCIONAR_TODO + Scripts.TABLA_PISTAS + Constantes.DONDE + Scripts.CAMPO_IDPISTA + Constantes.SIMBOLO_IGUAL + id;
        Cursor c = bd.rawQuery(SQL, null);
        return buscarPista(c);
    }

    private ContentValues rellenarPista(Pista pista) {
        ContentValues cv = new ContentValues();
        cv.put(Scripts.CAMPO_NOMBREPISTA, pista.getNombrePista());
        cv.put(Scripts.CAMPO_MATERIAL, pista.getMaterial());
        cv.put(Scripts.CAMPO_PRECIO, pista.getPrecio());
        return cv;
    }

    private Pista buscarPista(Cursor c) {
        Pista pista = null;
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                pista = new Pista(c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_IDPISTA)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_NOMBREPISTA)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_MATERIAL)),
                        c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_PRECIO)));

            } while (c.moveToNext());
        }
        Objects.requireNonNull(c).close();
        return pista;
    }
}
