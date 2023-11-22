package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.proyectopadel.back.Database;
import com.example.proyectopadel.back.dao.PistaRepositorio;
import com.example.proyectopadel.back.dao.UsuarioRepositorio;

public class Usuarios extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listaUsuarios;
    ListAdapterUsuarios adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);


        listaUsuarios = findViewById(R.id.listviewUsuarios);

        listaUsuarios.setOnItemClickListener(this);

        Database bd = new Database(this);
        UsuarioRepositorio ur = new UsuarioRepositorio(bd.getWritableDatabase());
        adaptador = new ListAdapterUsuarios(Usuarios.this,R.layout.row_usuarios, ur.findAll());
        listaUsuarios.setAdapter(adaptador);
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