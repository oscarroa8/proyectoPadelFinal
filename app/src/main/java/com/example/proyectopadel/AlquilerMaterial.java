package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AlquilerMaterial extends AppCompatActivity {
    Spinner comboMaterial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquiler_material);
        comboMaterial = findViewById(R.id.spinnerAlquilerMaterial);

        // Obtén el array de recursos desde arrays.xml
        String[] elementos = getResources().getStringArray(R.array.combo_material);

// Crea un adaptador utilizando el array de recursos
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, elementos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

// Asigna el adaptador al Spinner
        comboMaterial.setAdapter(adaptador);

        comboMaterial.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int posicion, long id) {
                String elementoSeleccionado = elementos[posicion];

            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Se llama cuando no se ha seleccionado ningún elemento
            }
        });

    }
}