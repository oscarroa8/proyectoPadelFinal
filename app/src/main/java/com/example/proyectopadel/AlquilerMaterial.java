package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AlquilerMaterial extends AppCompatActivity {
    Spinner comboMaterial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alquiler_material);
        comboMaterial = findViewById(R.id.spinnerAlquilerMaterial);

        //Cargar el spinner con los valores  fichero de opciones que creamos
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.combo_material, android.R.layout.simple_spinner_item);

        //Cargamos el combo con el adaptador
        comboMaterial.setAdapter(adapter);
    }
}