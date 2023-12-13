package com.example.proyectopadel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.proyectopadel.adaptadores.ListAdapterPistas;
import com.example.proyectopadel.back.dao.PistaRepositorio;
import com.example.proyectopadel.back.entidades.Pista;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;

public class pistas extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView listaPistas;
    ListAdapterPistas adaptador;
    ListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistas);
        listaPistas = findViewById(R.id.listviewPistas);

        listaPistas.setOnItemClickListener(this);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        Snackbar.make(findViewById(android.R.id.content),"Bienvenido "+currentUser.getEmail(),Snackbar.LENGTH_SHORT).show();

        FirebaseFirestore bd = FirebaseFirestore.getInstance();
        PistaRepositorio pr = new PistaRepositorio(bd);
        adaptador = new ListAdapterPistas(pistas.this,R.layout.row_pistas, new ArrayList<>());
        listaPistas.setAdapter(adaptador);
        pr.findAll().addOnCompleteListener(task -> {
           adaptador.setPistas(task.getResult());
        });

        adapter= listaPistas.getAdapter();

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


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {//Metodo que sirve
        // para que cuando se pincha en un row del listview de pistas, se abra las reservas de la pista
        // y se le pase los datos de la pista

        if(adapter == null)
            throw new NullPointerException("El adaptador no contiene valores.");

        Pista pistaToGet = (Pista) adapter.getItem(i);

        Intent intent = new Intent(this,datosPista.class);
        intent.putExtra("nombrePista", pistaToGet.getNombre());
        intent.putExtra("idPista", pistaToGet.getIdPista());
        intent.putExtra("precioPista", pistaToGet.getPrecio());
        startActivity(intent);
    }
}