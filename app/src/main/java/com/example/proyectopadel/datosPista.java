package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.sql.Date;
import java.util.Calendar;

public class datosPista extends AppCompatActivity {
    Button btn;
    TextView tvPista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_pista);
        btn=findViewById(R.id.btnCalendario);
        tvPista = findViewById(R.id.tvPista);
    }
    public void calendario (View view){
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        int mes = cal.get(Calendar.MONTH);
        int dia = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dpd = new DatePickerDialog(datosPista.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                String fecha = dia + "/"+ mes +"/"+anio;
                btn.setText(fecha);
            }
        },anio,mes,dia);
        dpd.show();

    }


}