package com.example.proyectopadel.utilidades;

public class Utilidades {
    //Constantes tabla pista

    public static final String TABLA_PISTA="pista";
    public static final String CAMPO_ID="idPista";
    public static final String CAMPO_NOMBRE="pista";
    public static final String CAMPO_MATERIAL="material";
    public static final String CAMPO_PRECIO="precio";
    public static final String CAMPO_IDUSUARIO="idUsuario";

    public static final String CREAR_TABLA_PISTA="CREATE TABLE "+ ""+TABLA_PISTA+"("+CAMPO_ID+""+"PRIMARY KEY AUTOINCREMENT not null, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_MATERIAL+"TEXT,"+CAMPO_PRECIO+"INTEGER,FOREIGN KEY"+(CAMPO_IDUSUARIO)+" REFERENCES usuario(idUsuario))";

   public static final String TABLA_USUARIO="pista";
   public static final String CAMPO_NOMBREUSUARIO="nombre";
   public static final String CAMPO_APELLIDO1USU="apellido1";
   public static final String CAMPO_APELLIDO2USU="apellido2";
   public static final String CAMPO_EMAILUSU="email";
    public static final String CAMPO_CONTRASENAUSU="contrasena";

   public static final String CREAR_TABLA_USUARIO="CREATE TABLE "+ ""+TABLA_USUARIO+"("+CAMPO_IDUSUARIO+""+"PRIMARY KEY AUTOINCREMENT not null, "+CAMPO_NOMBREUSUARIO+" TEXT,"+CAMPO_APELLIDO1USU+"TEXT,"+CAMPO_APELLIDO2USU+"TEXT,"+CAMPO_EMAILUSU+"TEXT,"+CAMPO_CONTRASENAUSU+"TEXT)";

    public static final String TABLA_CLIENTE="cliente";
    public static final String CAMPO_IDCLIENTE="nombre";
    public static final String CAMPO_NOMBRECLIENTE="nombre";
    public static final String CAMPO_APELLIDO1CLI="apellido1";
    public static final String CAMPO_APELLIDO2CLI="apellido2";
    public static final String CAMPO_EMAILCLI="apellido2";
    public static final String CAMPO_CONTRASENACLI="apellido2";

    public static final String CREAR_TABLA_CLIENTE="CREATE TABLE "+ ""+TABLA_CLIENTE+"("+CAMPO_IDCLIENTE+""+"PRIMARY KEY AUTOINCREMENT not null, "+CAMPO_NOMBRECLIENTE+" TEXT,"+CAMPO_APELLIDO1CLI+"TEXT,"+CAMPO_APELLIDO2CLI+"TEXT,"+CAMPO_EMAILCLI+"TEXT,"+CAMPO_CONTRASENACLI+"TEXT)";


}
