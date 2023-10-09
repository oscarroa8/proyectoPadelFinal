package com.example.proyectopadel.back.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectopadel.back.entidades.Equipo;
import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.interfaces.IEquipo;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;

import java.util.Objects;

public class EquipoRepositorio implements IEquipo<Equipo> {
    private final SQLiteDatabase bd;

    public EquipoRepositorio(SQLiteDatabase bd) {
        this.bd = bd;
    }

    @Override
    public Integer insertar(Equipo equipo) {
        return (int) bd.insert(Scripts.TABLA_EQUIPOS, null, rellenarEquipo(equipo));

    }

    @Override
    public void actualizar(Equipo equipo) {
        bd.update(Scripts.TABLA_EQUIPOS, rellenarEquipo(equipo), Scripts.CAMPO_IDEQUIPO
                + Constantes.SIMBOLO_IGUAL + equipo.getIdEquipo(), null);
    }

    @Override
    public void borrar(Equipo equipo) {
        bd.delete(Scripts.TABLA_EQUIPOS, Scripts.CAMPO_IDEQUIPO
                + Constantes.SIMBOLO_IGUAL + equipo.getIdEquipo(), null);
    }

    @Override
    public Equipo getById(Integer id) {
        String SQL = Constantes.SELECCIONAR_TODO + Scripts.TABLA_EQUIPOS + Constantes.DONDE + Scripts.CAMPO_IDEQUIPO + Constantes.SIMBOLO_IGUAL + id;
        Cursor c = bd.rawQuery(SQL, null);
        return buscarEquipo(c);    }

    private ContentValues rellenarEquipo(Equipo equipo) {
        ContentValues cv = new ContentValues();
        cv.put(Scripts.CAMPO_NOMBREEQUIPO, equipo.getNombreEquipo());
        cv.put(Scripts.CAMPO_COLORPRINCIPAL, equipo.getColorPrincipal());
        cv.put(Scripts.CAMPO_COLORSECUNDARIO, equipo.getColorSecundario());
        return cv;
    }

    private Equipo buscarEquipo(Cursor c) {
        Equipo equipo = null;
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                equipo = new Equipo(c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_IDEQUIPO)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_NOMBREEQUIPO)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_COLORPRINCIPAL)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_COLORSECUNDARIO)));

            } while (c.moveToNext());
        }
        Objects.requireNonNull(c).close();
        return equipo;
    }


}
