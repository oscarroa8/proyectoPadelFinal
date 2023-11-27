package com.example.proyectopadel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.proyectopadel.back.dao.PistaRepositorio;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class pistas extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listaPistas;
    ListAdapterPistas adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistas);
        listaPistas = findViewById(R.id.listviewPistas);

        listaPistas.setOnItemClickListener(this);

        FirebaseFirestore bd = FirebaseFirestore.getInstance();
        PistaRepositorio pr = new PistaRepositorio(bd);
        adaptador = new ListAdapterPistas(pistas.this,R.layout.row_pistas, new ArrayList<>());
        listaPistas.setAdapter(adaptador);
        pr.findAll().addOnCompleteListener(task -> {
           adaptador.setPistas(task.getResult());
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.itemUsuarios){
            Intent intent = new Intent(this,Usuarios.class);//Falta crear la clase usuarios
            startActivity(intent);
        }
        if(id == R.id.itemMateriales){
            Intent intent = new Intent(this,AlquilerMaterial.class);//falta crear la clase material
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);    }

    public void pantallaCrearPista (View view){
        Intent intent = new Intent(this,nuevaPista.class);
        startActivity(intent);
    }

    public void pantallaDatosPista (View view){
        Intent intent = new Intent(this,datosPista.class);
        startActivity(intent);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        pantallaDatosPista(view);
    }
}