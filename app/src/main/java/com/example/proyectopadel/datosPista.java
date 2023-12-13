package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.GridLayout;
import android.widget.TextView;

import com.example.proyectopadel.back.dao.ReservaRepositorio;
import com.example.proyectopadel.back.entidades.ReservarPista;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class datosPista extends AppCompatActivity {
    GridLayout gridLayoutReservas;
    Button btnCalendario, btnReserva;
    TextView tvPista;
    String nombrePista, idPista;
    int precioPista;
    boolean datePicked = false;
    Date fechaSeleccionada;
    FirebaseFirestore bd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_pista);
        bd = FirebaseFirestore.getInstance();

        Intent intent = getIntent();
        nombrePista = intent.getStringExtra("nombrePista");
        idPista = intent.getStringExtra("idPista");
        precioPista = intent.getIntExtra("precioPista", 0);

        gridLayoutReservas = findViewById(R.id.gridLayoutReservas);


        FirebaseFirestore bd = FirebaseFirestore.getInstance();
        ReservaRepositorio rr = new ReservaRepositorio(bd);


        rr.findAllByPista(idPista).addOnCompleteListener(task -> {
            List<ReservarPista> listaReservas = task.getResult();
            rellenarGrid(listaReservas);
        });

        btnCalendario=findViewById(R.id.btnCalendario);
        btnReserva = findViewById(R.id.btnReserva);
        tvPista = findViewById(R.id.tvPista);
        tvPista.setText(nombrePista);
    }

    private void rellenarGrid(List<ReservarPista> listaReservas) {
        for (ReservarPista reserva : listaReservas) {
            // Crear TextViews para cada celda en la fila
            TextView textViewNombreCliente = new TextView(this);
            textViewNombreCliente.setText(reserva.getNombreCliente());

            TextView textViewTelefonoCliente = new TextView(this);
            textViewTelefonoCliente.setText(reserva.getTelefonoCliente());

            TextView textViewNombrePista = new TextView(this);
            textViewNombrePista.setText(nombrePista);

            TextView textViewHoraInicio = new TextView(this);
            textViewHoraInicio.setText(reserva.getHoraInicio() + ":" + reserva.getMinutoInicio());

            TextView textViewDuracionReserva = new TextView(this);
            textViewDuracionReserva.setText(duracionReserva(reserva.getMinutosReserva()));

            // Crea parámetros de diseño para cada TextView con columnSpecs diferentes
            GridLayout.Spec colSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f); // Columna no definida, ocupando 1 parte del espacio disponible

            GridLayout.LayoutParams paramsNombreCliente = new GridLayout.LayoutParams();
            paramsNombreCliente.width = GridLayout.LayoutParams.WRAP_CONTENT;
            paramsNombreCliente.height = GridLayout.LayoutParams.WRAP_CONTENT;
            paramsNombreCliente.setMargins(5, 5, 5, 5);
            paramsNombreCliente.columnSpec = colSpec;

            GridLayout.LayoutParams paramsTelefonoCliente = new GridLayout.LayoutParams(paramsNombreCliente);
            GridLayout.LayoutParams paramsNombrePista = new GridLayout.LayoutParams(paramsNombreCliente);
            GridLayout.LayoutParams paramsHoraInicio = new GridLayout.LayoutParams(paramsNombreCliente);
            GridLayout.LayoutParams paramsDuracionReserva = new GridLayout.LayoutParams(paramsNombreCliente);

            // Agrega las vistas al GridLayout con los parámetros de diseño correspondientes
            gridLayoutReservas.addView(textViewNombreCliente, paramsNombreCliente);
            gridLayoutReservas.addView(textViewTelefonoCliente, paramsTelefonoCliente);
            gridLayoutReservas.addView(textViewNombrePista, paramsNombrePista);
            gridLayoutReservas.addView(textViewHoraInicio, paramsHoraInicio);
            gridLayoutReservas.addView(textViewDuracionReserva, paramsDuracionReserva);
        }
    }



    private String duracionReserva(int minutosReserva) {
        int horas = minutosReserva / 60;
        int minutosRestantes = minutosReserva % 60;

        // Construye la cadena para las horas
        String horasString = horas == 1 ? "hora" : "horas";
        String minutosString = minutosRestantes == 1 ? "minuto" : "minutos";

        return (horas > 0 ? String.format("%d %s", horas, horasString) : "") +
                (horas > 0 && minutosRestantes > 0 ? " y " : "") +
                (minutosRestantes > 0 ? String.format("%d %s", minutosRestantes, minutosString) : "");
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
                btnCalendario.setText(fecha);
            }
        },anio,mes,dia);
        dpd.show();
        datePicked = true;
        cal.set(anio, mes, dia);
        fechaSeleccionada =  cal.getTime();
    }

    public void irAReservar(View v){
        if(!datePicked){
            Snackbar.make(findViewById(android.R.id.content),"No has seleccionado fecha!",Snackbar.LENGTH_SHORT).show();
        }else{
            Intent intent = new Intent(this,ReservaPista.class);
            intent.putExtra("idPista", idPista);
            intent.putExtra("fechaReserva", fechaSeleccionada.toString());
            intent.putExtra("precioPista", precioPista);
            intent.putExtra("nombrePista", nombrePista);
            startActivity(intent);
        }
    }



}