package com.example.proyectopadel.utilidades.db;

public class Scripts {
    // Tabla Roles
    public static final String TABLA_ROLES = "roles";
    public static final String CAMPO_IDROL = "idRol";
    public static final String CAMPO_ROL = "rol";

    // Tabla Usuarios
    public static final String TABLA_USUARIOS = "usuario";
    public static final String CAMPO_IDUSUARIO = "idUsuario";
    public static final String CAMPO_NOMBREUSUARIO = "nombre";
    public static final String CAMPO_APELLIDO1USU = "apellido1";
    public static final String CAMPO_APELLIDO2USU = "apellido2";
    public static final String CAMPO_EMAILUSU = "email";
    public static final String CAMPO_CONTRASENAUSU = "contrasena";

    // Tabla Equipos
    public static final String TABLA_EQUIPOS = "equipos";
    public static final String CAMPO_IDEQUIPO = "idEquipo";
    public static final String CAMPO_NOMBREEQUIPO = "nombreEquipo";
    public static final String CAMPO_COLORPRINCIPAL = "colorPrincipal";
    public static final String CAMPO_COLORSECUNDARIO = "colorSecundario";

    // Tabla Clientes
    public static final String TABLA_CLIENTES = "cliente";
    public static final String CAMPO_IDCLIENTE = "idCliente";
    public static final String CAMPO_NOMBRECLIENTE = "nombreCliente";
    public static final String CAMPO_APELLIDO1CLI = "apellido1";
    public static final String CAMPO_APELLIDO2CLI = "apellido2";
    public static final String CAMPO_EMAILCLI = "emailCli";
    public static final String CAMPO_TELEFONO = "telefono";

    // Tabla Pistas
    public static final String TABLA_PISTAS = "pista";
    public static final String CAMPO_IDPISTA = "idPista";
    public static final String CAMPO_NOMBREPISTA = "nombre";
    public static final String CAMPO_MATERIAL = "material";
    public static final String CAMPO_PRECIO = "precio";

    // Tabla ReservaPista
    public static final String TABLA_RESERVARPISTA = "reservaPista";
    public static final String CAMPO_FECHAINIRESERVA = "fechaIniReserva";
    public static final String CAMPO_FECHAFINRESERVA = "fechaFinReserva";
    public static final String CAMPO_PRECIOFINALRESERVA = "precioFinalReserva";

    // Tabla Material
    public static final String TABLA_MATERIAL = "material";
    public static final String CAMPO_IDMATERIAL = "idMaterial";
    public static final String CAMPO_PRECIOHORAMATERIAL = "precioHoraMaterial";

    // Tabla Alquiler
    public static final String TABLA_ALQUILER = "alquiler";
    public static final String CAMPO_FECHAINIALQUILER = "fechaIniAlquiler";
    public static final String CAMPO_FECHAFINALQUILER = "fechaFinAlquiler";
    public static final String CAMPO_PRECIOFINALALQUILER = "precioFinalAlquiler";

    // Tabla Torneos
    public static final String TABLA_TORNEOS = "torneos";
    public static final String CAMPO_IDTORNEO = "idTorneo";
    public static final String CAMPO_NOMBRETORNEO = "nombreTorneo";
    public static final String CAMPO_PUNTOSRONDA = "puntosRonda";
    public static final String CAMPO_NEQUIPOS = "nEquipos";

    // Tabla Participacion
    public static final String TABLA_PARTICIPACIONES = "participacion";
    public static final String CAMPO_FECHAINIPARTICIPACION = "fechaIniParticipacion";
    public static final String CAMPO_FECHAFINPARTICIPACION = "fechaFinParticipacion";

    public static final String DROP_TABLE="drop table if exists ";

    public static final String BORRAR_TABLA_ROLES= DROP_TABLE+TABLA_ROLES;
    public static final String BORRAR_TABLA_USUARIOS= DROP_TABLE+TABLA_USUARIOS;
    public static final String BORRAR_TABLA_EQUIPOS= DROP_TABLE+TABLA_EQUIPOS;
    public static final String BORRAR_TABLA_CLIENTE= DROP_TABLE+TABLA_CLIENTES;
    public static final String BORRAR_TABLA_PISTA= DROP_TABLE+TABLA_PISTAS;
    public static final String BORRAR_TABLA_RESERVAPISTA= DROP_TABLE+TABLA_RESERVARPISTA;
    public static final String BORRAR_TABLA_MATERIAL= DROP_TABLE+TABLA_MATERIAL;
    public static final String BORRAR_TABLA_ALQUILER= DROP_TABLE+TABLA_ALQUILER;




    public static final String CREAR_TABLA_ROLES = "CREATE TABLE " + "" + TABLA_ROLES + "(" + CAMPO_IDROL + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_ROL + " TEXT)";
    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + "" + TABLA_USUARIOS + "(" + CAMPO_IDUSUARIO + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBREUSUARIO + " TEXT," + CAMPO_APELLIDO1USU + " TEXT," + CAMPO_APELLIDO2USU + " TEXT," + CAMPO_EMAILUSU + " TEXT," + CAMPO_CONTRASENAUSU + " TEXT,"+ CAMPO_IDROL +" INTEGER,  FOREIGN KEY(" + CAMPO_IDROL + ") REFERENCES roles(idRol))";
    public static final String CREAR_TABLA_EQUIPOS = "CREATE TABLE " + "" + TABLA_EQUIPOS + "(" + CAMPO_IDEQUIPO + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBREEQUIPO + " TEXT," + CAMPO_COLORPRINCIPAL + " TEXT," + CAMPO_COLORSECUNDARIO + " INTEGER)";
    public static final String CREAR_TABLA_CLIENTE = "CREATE TABLE " + "" + TABLA_CLIENTES + "(" + CAMPO_IDCLIENTE + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBRECLIENTE + " TEXT," + CAMPO_APELLIDO1CLI + " TEXT," + CAMPO_APELLIDO2CLI + " TEXT," + CAMPO_EMAILCLI + " TEXT," + CAMPO_TELEFONO + " TEXT," +CAMPO_IDEQUIPO+ " INTEGER, FOREIGN KEY(" + CAMPO_IDEQUIPO + ") REFERENCES equipos(idEquipo))";
    public static final String CREAR_TABLA_PISTA = "CREATE TABLE " + "" + TABLA_PISTAS + "(" + CAMPO_IDPISTA + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBREPISTA + " TEXT," + CAMPO_MATERIAL + " TEXT," + CAMPO_PRECIO + " INTEGER," + CAMPO_IDUSUARIO + " INTEGER, FOREIGN KEY(" + CAMPO_IDUSUARIO + ") REFERENCES usuario(idUsuario))";
    public static final String CREAR_TABLA_RESERVARPISTA = "CREATE TABLE " + "" + TABLA_RESERVARPISTA + "(" + CAMPO_FECHAINIRESERVA + " TEXT," + CAMPO_FECHAFINRESERVA + " TEXT," + CAMPO_PRECIOFINALRESERVA + " REAL)";
    public static final String CREAR_TABLA_MATERIAL = "CREATE TABLE " + "" + TABLA_MATERIAL + "(" + CAMPO_IDMATERIAL + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_PRECIOHORAMATERIAL + " REAL)";
    public static final String CREAR_TABLA_ALQUILER = "CREATE TABLE " + "" + TABLA_ALQUILER + "(" + CAMPO_FECHAINIALQUILER + " TEXT," + CAMPO_FECHAFINALQUILER + " TEXT," + CAMPO_PRECIOFINALALQUILER + " REAL)";
    public static final String CREAR_TABLA_TORNEOS = "CREATE TABLE " + "" + TABLA_TORNEOS + "(" + CAMPO_IDTORNEO + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBRETORNEO + " TEXT," + CAMPO_PUNTOSRONDA + " INTEGER," + CAMPO_NEQUIPOS + " INTEGER)";
    public static final String CREAR_TABLA_PARTICIPACIONES = "CREATE TABLE " + "" + TABLA_PARTICIPACIONES + "(" + CAMPO_FECHAINIPARTICIPACION + " TEXT," + CAMPO_FECHAFINPARTICIPACION + " TEXT)";


}
