package com.example.proyectopadel.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.entidades.Usuario;
import com.example.proyectopadel.pistas;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity{
    private Button entrar;
    private EditText etUsuario, etContrasena;

    private FirebaseAuth mAuth;

    private String emailUsuario,contrasenaUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mAuth=FirebaseAuth.getInstance();
        elementosIntefaz();

    }

    private void elementosIntefaz() {
        this.entrar = findViewById(R.id.btnEntrar);
        this.etUsuario= findViewById(R.id.etCorreo);
        this.etContrasena = findViewById(R.id.etContrasena);
    }



    public void logUser(View v){
        this.emailUsuario= etUsuario.getText().toString();
        this.contrasenaUsuario = etContrasena.getText().toString();

        Intent i = new Intent(login.this, pistas.class);
        Task<AuthResult> getUserInfoTask = mAuth.signInWithEmailAndPassword(this.emailUsuario,this.contrasenaUsuario).addOnCompleteListener(
                task -> {
                    if(task.isSuccessful()){
                        AuthResult authResult = task.getResult();
                        FirebaseUser currentUser = authResult.getUser();
                        i.putExtra("user",currentUser);
                        startActivity(i);
                    }
                }
        );
    }
}