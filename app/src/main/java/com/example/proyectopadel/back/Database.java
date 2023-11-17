package com.example.proyectopadel.back;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.dao.ClienteRepositorio;
import com.example.proyectopadel.back.dao.EquipoRepositorio;
import com.example.proyectopadel.back.dao.UsuarioRepositorio;
import com.example.proyectopadel.back.entidades.Cliente;
import com.example.proyectopadel.back.entidades.Equipo;
import com.example.proyectopadel.back.entidades.Usuario;
import com.example.proyectopadel.back.interfaces.Operaciones;
import com.example.proyectopadel.utilidades.Constantes;
import com.example.proyectopadel.utilidades.db.Scripts;

public class Database extends SQLiteOpenHelper {
    private final SQLiteDatabase bd;
    private final Context contexto;

    public Database(@Nullable Context context) {
        super(context, Constantes.DATABASE_NOMBRE, null, Constantes.DATABASE_VERSION);
        this.bd = this.getWritableDatabase();
        this.contexto = context;
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
       // sqLiteDatabase.execSQL(contexto.getResources().getString(R.string.CREAR_TABLA_TORNEOS));
        //sqLiteDatabase.execSQL(contexto.getResources().getString(R.string.CREAR_TABLA_PARTICIPACIONES));
       // sqLiteDatabase.execSQL(contexto.getResources().getString(R.string.CREAR_ROL_ADMINISTRADOR));
        //sqLiteDatabase.execSQL(contexto.getResources().getString(R.string.CREAR_ROL_EMPLEADO));
       // sqLiteDatabase.execSQL(contexto.getResources().getString(R.string.CREAR_SUPERUSUARIO));

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_ROLES);
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_USUARIOS);
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_EQUIPOS);
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_CLIENTE);
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_PISTA);
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_RESERVAPISTA);
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_MATERIAL);
        sqLiteDatabase.execSQL(Scripts.BORRAR_TABLA_ALQUILER);
        //sqLiteDatabase.execSQL(contexto.getResources().getString(R.string.BORRAR_TABLA_TORNEOS));
        //sqLiteDatabase.execSQL(contexto.getResources().getString(R.string.BORRAR_TABLA_PARTICIPACIONES));
        onCreate(sqLiteDatabase);
    }

    public void close() {
        bd.close();
    }

    /////////////////////////////////////////USUARIOS//////////////////////////////////////////////

    public Integer insertarUsuario(Usuario usuario) {
        return new UsuarioRepositorio(bd, contexto).insertar(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        new UsuarioRepositorio(bd, contexto).actualizar(usuario);
    }

    public void borrarUsuario(Usuario usuario) {
        new UsuarioRepositorio(bd, contexto).borrar(usuario);
    }

    public Usuario obtenerUsuarioPorUsuarioYContrasena(String usuario, String contrasena) throws Exception {
        return new UsuarioRepositorio(bd, contexto).obtenerUsuarioPorUsuarioYContrasena(usuario, contrasena);
    }

    ////////////////////////////////////////CLIENTES//////////////////////////////////////////////

    public Integer insertarCliente(Cliente cliente) {
        return new ClienteRepositorio(bd).insertar(cliente);
    }

    public void actualizarCliente(Cliente cliente) {
        new ClienteRepositorio(bd).actualizar(cliente);
    }

    public void borrarCliente(Cliente cliente) {
        new ClienteRepositorio(bd).borrar(cliente);
    }

    ///////////////////////////////////////TORNEOS////////////////////////////////////////////////

    /*public Integer insertarTorneo(Torneo torneo) {
        return new TorneoRepositorio(bd).insertar(torneo);
    }

    public void actualizarTorneo(Torneo torneo) {
        new TorneoRepositorio(bd).actualizar(torneo);
    }

    public void borrarTorneo(Torneo torneo) {
        new TorneoRepositorio(bd).borrar(torneo);
    }
*/
    ///////////////////////////////////////EQUIPOS/////////////////////////////////////////////////

    public Integer insertarEquipo(Equipo equipo) {
        return new EquipoRepositorio(bd).insertar(equipo);
    }

    public void actualizarEquipo(Equipo equipo) {
        new EquipoRepositorio(bd).actualizar(equipo);
    }

    public void borrarEquipo(Equipo equipo) {
        new EquipoRepositorio(bd).borrar(equipo);
    }
}
