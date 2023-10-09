package com.example.proyectopadel.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.Database;
import com.example.proyectopadel.back.entidades.Usuario;

public class login extends AppCompatActivity {
    private Database db;
    private Button entrar;
    private EditText etUsuario, etContrasena;
    private Usuario usuarioLogeado=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cargarBaseDatos();
        elementosIntefaz();


        entrar.setOnClickListener(view -> login() );

    }

    private void cargarBaseDatos() {
        this.db = new Database(this);
        this.db.insertarUsuario(new Usuario("PIRI" ,"ROALES","GONZALEZ","org@gmail.com","contrasena"));

    }

    private void elementosIntefaz() {
        this.entrar = findViewById(R.id.btnEntrar);
        this.etUsuario= findViewById(R.id.etUsuario);
        this.etContrasena = findViewById(R.id.etContrasena);
    }

    private void login(){
        try{
            usuarioLogeado = db.obtenerUsuarioPorUsuarioYContrasena(etUsuario.getText().toString().trim(), etContrasena.getText().toString().trim());
            if(usuarioLogeado == null)
                usuarioLogeado = db.obtenerUsuarioPorUsuarioYContrasena(etUsuario.getText().toString().trim(), etContrasena.getText().toString().trim());
            if(usuarioLogeado==null)
                loginIncorrecto();
            else
                loginCorrecto();
        } catch (Exception e) {
            e.printStackTrace();
            loginIncorrecto();
        }
    }

    private void loginIncorrecto(){
        etUsuario.setText(getString(R.string.blanco));
        etContrasena.setText(getString(R.string.blanco));
        Toast.makeText(this, R.string.tipo_dato_invalido, Toast.LENGTH_SHORT).show();
    }
    private void loginCorrecto() {
        Toast.makeText(this, "LA POLLA DEL ZAKO" , Toast.LENGTH_SHORT).show();

       /* if (checkTeams()) {
            Intent i = new Intent(this, TeamView.class);
            i.putExtra("user", usuarioLogeado);
            i.putExtra("team", userTeam);
            startActivity(i);
      } else {
            Intent i = new Intent(this, CreateTeam.class);
            i.putExtra("user", userLogged);
            startActivity(i);
        }*/

    }


}