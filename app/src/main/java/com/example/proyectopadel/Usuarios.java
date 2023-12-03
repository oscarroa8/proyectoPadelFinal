package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.proyectopadel.adaptadores.ListAdapterUsuarios;
import com.example.proyectopadel.back.dao.UsuarioRepositorio;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class Usuarios extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listaUsuarios;
    ListAdapterUsuarios adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);


        listaUsuarios = findViewById(R.id.listviewUsuarios);

        listaUsuarios.setOnItemClickListener(this);

        FirebaseFirestore bd = FirebaseFirestore.getInstance();
        UsuarioRepositorio ur = new UsuarioRepositorio(bd);
        adaptador = new ListAdapterUsuarios(Usuarios.this,R.layout.row_usuarios, new ArrayList<>());
        listaUsuarios.setAdapter(adaptador);
        ur.findAllUsuarios().addOnCompleteListener(task -> {
            adaptador.setUsuarios(task.getResult());
        });
    }
    public void pantallaCrearUsuario (View view){
        Intent intent = new Intent(this,nuevoUsuario.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        pantallaCrearUsuario(view);
    }
}