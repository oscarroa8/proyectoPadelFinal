package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectopadel.back.Database;
import com.example.proyectopadel.back.dao.PistaRepositorio;
import com.example.proyectopadel.back.entidades.Pista;

import java.util.ArrayList;
import java.util.List;

public class nuevaPista extends AppCompatActivity {
    Button btnCrear;
    EditText etNombre,etMaterial,etPrecio;
    Database bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_pista);
        btnCrear = findViewById(R.id.btnCrear);

         bd = new Database(this);


        etNombre = findViewById(R.id.etNombrePista);
        etMaterial = findViewById(R.id.etMaterialPista);
        etPrecio = findViewById(R.id.etnPrecio);

    }
    public void insertarPista(View view){
        PistaRepositorio pr = new PistaRepositorio(bd.getWritableDatabase());
        String nombrePista = etNombre.getText().toString();
        String materialPista = etMaterial.getText().toString();
        String precioPista = etPrecio.getText().toString();
        Pista p = new Pista(nombrePista,materialPista,Integer.parseInt(precioPista));

        if (!nombrePista.isEmpty() && !materialPista.isEmpty() && !precioPista.isEmpty()) {
            pr.insertar(p);
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

}