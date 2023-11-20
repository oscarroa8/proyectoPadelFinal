package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.proyectopadel.back.Database;
import com.example.proyectopadel.back.dao.PistaRepositorio;
import com.example.proyectopadel.back.entidades.Pista;

import java.util.ArrayList;
import java.util.List;

public class pistas extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listaPistas;
    ListAdapter adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistas);
        listaPistas = findViewById(R.id.listviewPistas);
        listaPistas.setOnItemClickListener(this);

        Database bd = new Database(this);
        List<Pista> listaPista = new ArrayList<>();
        PistaRepositorio pr = new PistaRepositorio(bd.getWritableDatabase());
        adaptador = new ListAdapter(pistas.this,R.layout.row_pistas, pr.findAll());
        listaPistas.setAdapter(adaptador);
    }

    public boolean onCreateOptionMenu(Menu menu){
        getMenuInflater().inflate(R.menu.overflow,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.itemUsuarios){
            Intent intent = new Intent(this,nuevaPista.class);//Falta crear la clase usuarios
            startActivity(intent);
        }
        if(id == R.id.itemMateriales){
            Intent intent = new Intent(this,nuevaPista.class);//falta crear la clase material
            startActivity(intent);
        }
        return true;
    }

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