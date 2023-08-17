package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectopadel.db.DbHelper;

public class login extends AppCompatActivity {

    private DbHelper db;
    Button registrar,entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cargarBaseDatos();
        elementosIntefaz();


        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentRegistrarse = new Intent(login.this,activity_newlogin.class);
                login.this.startActivity(intentRegistrarse);
            }
        });
    }
    private void cargarBaseDatos() { db = new DbHelper(this);
    }


    private void elementosIntefaz(){
        registrar= findViewById(R.id.btnRegistrarse);
        entrar= findViewById(R.id.btnEntrar);
    }
}