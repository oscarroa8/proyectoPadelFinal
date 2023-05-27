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

  //  public static final String TABLA_PISTA="pista";
    //public static final String CAMPO_ID="idPista";
  //  public static final String CAMPO_NOMBRE="pista";
  //  public static final String CAMPO_MATERIAL="material";
  //  public static final String CAMPO_PRECIO="precio";
   // public static final String CAMPO_IDUSUARIO="idUsuario";

   // public static final String CREAR_TABLA_PISTA="CREATE TABLE "+ ""+TABLA_PISTA+"("+CAMPO_ID+""+"PRIMARY KEY AUTOINCREMENT not null, "+CAMPO_NOMBRE+" TEXT,"+CAMPO_MATERIAL+"TEXT,"+CAMPO_PRECIO+"INTEGER,FOREIGN KEY"+(CAMPO_IDUSUARIO)+" REFERENCES usuario(idUsuario))";

}
