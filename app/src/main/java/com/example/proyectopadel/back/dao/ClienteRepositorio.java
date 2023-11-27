package com.example.proyectopadel.back.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.proyectopadel.back.entidades.Cliente;
import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.interfaces.ICliente;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;
import com.google.android.gms.tasks.Task;

import java.util.List;
import java.util.Objects;

public class ClienteRepositorio   {
   // private final SQLiteDatabase bd;

   /* public ClienteRepositorio(SQLiteDatabase bd) {
        this.bd = bd;
    }

    @Override
    /*public Task<String> insertar(Cliente cliente) {
        /*return (int) bd.insert(Scripts.TABLA_CLIENTES, null, rellenarCliente(cliente));
    }

    @Override
    public void actualizar(Cliente cliente) {
        bd.update(Scripts.TABLA_CLIENTES, rellenarCliente(cliente), Scripts.CAMPO_IDCLIENTE
                + Constantes.SIMBOLO_IGUAL + cliente.getIdCliente(), null);
    }

    @Override
    public void borrar(Cliente cliente) {
        bd.delete(Scripts.TABLA_CLIENTES, Scripts.CAMPO_IDCLIENTE
                + Constantes.SIMBOLO_IGUAL + cliente.getIdCliente(), null);
    }

    @Override
    public Cliente getById(Integer id) {
        String SQL = Constantes.SELECCIONAR_TODO + Scripts.TABLA_CLIENTES + Constantes.DONDE + Scripts.CAMPO_IDCLIENTE + Constantes.SIMBOLO_IGUAL + id;
        Cursor c = bd.rawQuery(SQL, null);
        return buscarClienteUnico(c);
    }

    @Override
    public Task<List<Pista>> findAll() {
        throw new UnsupportedOperationException();
    }

    private ContentValues rellenarCliente(Cliente cliente) {
        ContentValues cv = new ContentValues();
        cv.put(Scripts.CAMPO_NOMBRECLIENTE, cliente.getNombre());
        cv.put(Scripts.CAMPO_APELLIDO1CLI, cliente.getApellido1());
        cv.put(Scripts.CAMPO_APELLIDO2CLI, cliente.getApellido2());
        cv.put(Scripts.CAMPO_EMAILCLI, cliente.getEmail());
        cv.put(Scripts.CAMPO_TELEFONO, cliente.getTelefono());
        return cv;
    }

    private Cliente buscarClienteUnico(Cursor c) {
        Cliente cliente = null;
        if (c != null && c.getCount() > 0) {
            c.moveToFirst();
            do {
                cliente = new Cliente(c.getInt(c.getColumnIndexOrThrow(Scripts.CAMPO_IDCLIENTE)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_NOMBRECLIENTE)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_APELLIDO1CLI)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_APELLIDO2CLI)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_EMAILCLI)),
                        c.getString(c.getColumnIndexOrThrow(Scripts.CAMPO_TELEFONO)));
            } while (c.moveToNext());
        }
        Objects.requireNonNull(c).close();
        return cliente;
    }*/

}
