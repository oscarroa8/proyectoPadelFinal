package com.example.proyectopadel.back.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectopadel.back.entidades.Torneo;
import com.example.proyectopadel.back.interfaces.ITorneo;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;

import java.util.Objects;

public class TorneoRepositorio implements ITorneo<Torneo> {
    private final SQLiteDatabase bd;

    public TorneoRepositorio(SQLiteDatabase bd) {
        this.bd = bd;
    }

    @Override
    public Integer insertar(Torneo torneo) {
        return (int) bd.insert(Scripts.TABLA_TORNEOS, null, rellenarTorneo(torneo));
    }

    @Override
    public void actualizar(Torneo torneo) {
        bd.update(Scripts.TABLA_TORNEOS, rellenarTorneo(torneo), Scripts.CAMPO_IDTORNEO
                + Constantes.SIMBOLO_IGUAL + torneo.getIdTorneo(), null);
    }

    @Override
    public void borrar(Torneo torneo) {
        bd.delete(Scripts.TABLA_TORNEOS, Scripts.CAMPO_IDTORNEO
                + Constantes.SIMBOLO_IGUAL + torneo.getIdTorneo(), null);
    }

    @Override
    public Torneo getById(Integer id) {
        String SQL = Constantes.SELECCIONAR_TODO + Scripts.TABLA_TORNEOS + Constantes.DONDE + Scripts.CAMPO_IDTORNEO + Constantes.SIMBOLO_IGUAL + id;
        Cursor c = bd.rawQuery(SQL, null);
        return buscarTorneo(c);
    }

    private ContentValues rellenarTorneo(Torneo torneo) {
        ContentValues cv = new ContentValues();
        cv.put(Scripts.CAMPO_NOMBRETORNEO, torneo.getNombre());
        cv.put(Scripts.CAMPO_PUNTOSRONDA, torneo.getPuntosRonda());
        cv.put(Scripts.CAMPO_NEQUIPOS, torneo.getnEquipos());
        return cv;
    }

    private Torneo buscarTorneo(Cursor c) {
        Torneo torneo = null;
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                torneo = new Torneo(c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_IDTORNEO)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_NOMBRETORNEO)),
                        c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_PUNTOSRONDA)),
                        c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_NEQUIPOS)));

            } while (c.moveToNext());
        }
        Objects.requireNonNull(c).close();
        return torneo;
    }


}
