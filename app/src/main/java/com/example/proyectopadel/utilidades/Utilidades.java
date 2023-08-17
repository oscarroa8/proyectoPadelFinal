package com.example.proyectopadel.utilidades;

public class Utilidades {
    //Constantes tabla pista

    public static final String CAMPO_IDUSUARIO = "idUsuario";
    public static final String TABLA_USUARIOS = "usuario";
    public static final String CAMPO_NOMBREUSUARIO = "nombre";
    public static final String CAMPO_APELLIDO1USU = "apellido1";
    public static final String CAMPO_APELLIDO2USU = "apellido2";
    public static final String CAMPO_EMAILUSU = "email";
    public static final String CAMPO_CONTRASENAUSU = "contrasena";


    public static final String TABLA_CLIENTES = "cliente";
    public static final String CAMPO_IDCLIENTE = "idCliente";
    public static final String CAMPO_NOMBRECLIENTE = "nombre";
    public static final String CAMPO_APELLIDO1CLI = "apellido1";
    public static final String CAMPO_APELLIDO2CLI = "apellido2";
    public static final String CAMPO_EMAILCLI = "emailCli";
    public static final String CAMPO_TELEFONO = "telefono";


    public static final String TABLA_PISTAS = "pista";
    public static final String CAMPO_ID = "idPista";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_MATERIAL = "material";
    public static final String CAMPO_PRECIO = "precio";



    public static final String TABLA_EQUIPOS = "equipos";
    public static final String CAMPO_IDEQUIPO = "idEquipo";
    public static final String CAMPO_NOMBREEQUIPO = "nombreEquipo";
    public static final String CAMPO_COLORPRINCIPAL = "colorPrincipal";
    public static final String CAMPO_COLORSECUNDARIO = "colorSecundario";



    public static final String TABLA_ROLES = "roles";
    public static final String CAMPO_IDROL = "idRol";
    public static final String CAMPO_ROL = "rol";



    public static final String TABLA_RESERVARPISTA = "reservaPista";
    public static final String CAMPO_FECHAINIRESERVA = "fechaIniReserva";
    public static final String CAMPO_FECHAFINRESERVA = "fechaFinReserva";
    public static final String CAMPO_PRECIOFINALRESERVA = "precioFinalReserva";



    public static final String TABLA_ALQUILER = "alquiler";
    public static final String CAMPO_FECHAINIALQUILER= "fechaIniAlquiler";
    public static final String CAMPO_FECHAFINALQUILER = "fechaFinAlquiler";
    public static final String CAMPO_PRECIOFINALALQUILER = "precioFinalAlquiler";



    public static final String TABLA_MATERIAL = "material";
    public static final String CAMPO_IDMATERIAL = "idMaterial";
    public static final String CAMPO_PRECIOHORAMATERIAL = "precioHoraMaterial";



    public static final String TABLA_PARTICIPACIONES = "participacion";
    public static final String CAMPO_FECHAINIPARTICIPACION= "fechaIniParticipacion";
    public static final String CAMPO_FECHAFINPARTICIPACION = "fechaFinParticipacion";



    public static final String TABLA_TORNEOS = "torneos";
    public static final String CAMPO_IDTORNEO = "idTorneo";
    public static final String CAMPO_NOMBRETORNEO = "nombreTorneo";
    public static final String CAMPO_PUNTOSRONDA = "puntosRonda";
    public static final String CAMPO_NEQUIPOS = "nEquipos";


    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " + "" + TABLA_USUARIOS + "(" + CAMPO_IDUSUARIO + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBREUSUARIO + " TEXT," + CAMPO_APELLIDO1USU + " TEXT," + CAMPO_APELLIDO2USU + " TEXT," + CAMPO_EMAILUSU + " TEXT," + CAMPO_CONTRASENAUSU + " TEXT, FOREIGN KEY(" + CAMPO_IDROL + ") REFERENCES roles(idRol))";
    public static final String CREAR_TABLA_CLIENTE = "CREATE TABLE " + "" + TABLA_CLIENTES + "(" + CAMPO_IDCLIENTE + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBRECLIENTE + " TEXT," + CAMPO_APELLIDO1CLI + " TEXT," + CAMPO_APELLIDO2CLI + " TEXT," + CAMPO_EMAILCLI + " TEXT," + CAMPO_TELEFONO + " TEXT, FOREIGN KEY(" + CAMPO_IDEQUIPO + ") REFERENCES equipos(idEquipo))";
    public static final String CREAR_TABLA_PISTA = "CREATE TABLE " + "" + TABLA_PISTAS + "(" + CAMPO_ID + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBRE + " TEXT," + CAMPO_MATERIAL + " TEXT," + CAMPO_PRECIO + " INTEGER,"+CAMPO_IDUSUARIO+" INTEGER, FOREIGN KEY(" + CAMPO_IDUSUARIO + ") REFERENCES usuario(idUsuario))";
    public static final String CREAR_TABLA_EQUIPOS = "CREATE TABLE " + "" + TABLA_EQUIPOS + "(" + CAMPO_IDEQUIPO + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBREEQUIPO + " TEXT," + CAMPO_COLORPRINCIPAL + " TEXT," + CAMPO_COLORSECUNDARIO + " INTEGER)";
    public static final String CREAR_TABLA_ROLES = "CREATE TABLE " + "" + TABLA_ROLES + "(" + CAMPO_IDROL + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_ROL + " TEXT)";
    public static final String CREAR_TABLA_RESERVARPISTA = "CREATE TABLE " + "" + TABLA_RESERVARPISTA + "(" + CAMPO_FECHAINIRESERVA + " TEXT," + CAMPO_FECHAFINRESERVA + " TEXT," + CAMPO_PRECIOFINALRESERVA + " INTEGER)";
    public static final String CREAR_TABLA_ALQUILER = "CREATE TABLE " + "" + TABLA_ALQUILER + "(" + CAMPO_FECHAINIALQUILER + " TEXT," + CAMPO_FECHAFINALQUILER + " TEXT," + CAMPO_PRECIOFINALALQUILER + " INTEGER)";
    public static final String CREAR_TABLA_PARTICIPACIONES = "CREATE TABLE " + "" + TABLA_PARTICIPACIONES + "(" + CAMPO_FECHAINIPARTICIPACION + " TEXT," + CAMPO_FECHAFINPARTICIPACION + " TEXT)";
    public static final String CREAR_TABLA_MATERIAL = "CREATE TABLE " + "" + TABLA_MATERIAL + "(" + CAMPO_IDMATERIAL + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_PRECIOHORAMATERIAL + " TEXT)";
    public static final String CREAR_TABLA_TORNEOS = "CREATE TABLE " + "" + TABLA_TORNEOS + "(" + CAMPO_IDTORNEO + " " + "INTEGER PRIMARY KEY AUTOINCREMENT not null, " + CAMPO_NOMBRETORNEO + " TEXT," + CAMPO_PUNTOSRONDA + " INTEGER," + CAMPO_NEQUIPOS + " INTEGER)";



}
