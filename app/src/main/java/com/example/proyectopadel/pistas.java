package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class pistas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pistas);
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
}