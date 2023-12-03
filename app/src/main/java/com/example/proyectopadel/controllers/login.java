package com.example.proyectopadel.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.entidades.Usuario;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity{
    private Button entrar;
    private EditText etUsuario, etContrasena;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        elementosIntefaz();

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //updateUI(currentUser);
    }

    private void elementosIntefaz() {
        this.entrar = findViewById(R.id.btnEntrar);
        this.etUsuario= findViewById(R.id.etCorreo);
        this.etContrasena = findViewById(R.id.etContrasena);
    }

}