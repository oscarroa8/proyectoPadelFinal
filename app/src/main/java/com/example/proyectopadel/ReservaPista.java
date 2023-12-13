package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.proyectopadel.back.dao.ReservaRepositorio;
import com.example.proyectopadel.back.entidades.ReservarPista;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ReservaPista extends AppCompatActivity {
    EditText etNombre, etTelefono;
    Button btnReserva, btnCancelarReserva;
    TimePicker pickerHoraInicio, pickerHoraFin;
    String idPista, nombrePista, fechaReservaString;
    int precioPista;
    Date fechaReserva;
    int horaInicio, minutoInicio, horaFin, minutoFin;

    FirebaseFirestore bd;
    private ReservaRepositorio rr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva_pista);

        bd = FirebaseFirestore.getInstance();
        rr = new ReservaRepositorio(bd);
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        btnReserva = findViewById(R.id.btnReservar);
        btnCancelarReserva = findViewById(R.id.btnCancelar);
        pickerHoraInicio = findViewById(R.id.timePickerHoraInicio);
        pickerHoraFin = findViewById(R.id.timePickerHoraFin);

        Intent intent = getIntent();
        idPista = intent.getStringExtra("idPista");
        fechaReservaString = intent.getStringExtra("fechaReserva");
        precioPista = intent.getIntExtra("precioPista", 0);
        nombrePista = intent.getStringExtra("nombrePista");
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);

        try {
            fechaReserva = dateFormat.parse(fechaReservaString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
    public void realizarReserva(View v) {
        ReservaRepositorio rr = new ReservaRepositorio(bd);
        String nombreCliente = etNombre.getText().toString();
        String telefonoCliente = etTelefono.getText().toString();

        horaInicio = pickerHoraInicio.getCurrentHour();
        minutoInicio = pickerHoraInicio.getCurrentMinute();

        horaFin = pickerHoraFin.getCurrentHour();
        minutoFin = pickerHoraFin.getCurrentMinute();

        if (horaFin < horaInicio) {
            Snackbar.make(findViewById(android.R.id.content), "La hora de fin no puede ser inferior a la hora de inicio", Snackbar.LENGTH_LONG).show();
        } else {
            int totalMinutosInicio = (horaInicio * 60) + minutoInicio;
            int totalMinutosFin = (horaFin * 60) + minutoFin;

            int diferenciaMinutos = Math.abs(totalMinutosFin - totalMinutosInicio);

            double horasCompletas = diferenciaMinutos / 60.0;

            double precioFinal = horasCompletas * precioPista;


            ReservarPista nuevaReserva = new ReservarPista(idPista, nombreCliente, telefonoCliente, fechaReserva, horaInicio, minutoInicio, diferenciaMinutos, precioFinal);

            comprobarReservasPista(nuevaReserva).addOnSuccessListener(result -> {
                if (result) {
                    if (comprobarParametros(nuevaReserva)) {
                        rr.insertar(nuevaReserva);
                        Snackbar.make(findViewById(android.R.id.content), "Datos insertados correctamente", Snackbar.LENGTH_SHORT).show();
                        Intent intent = new Intent(this, pistas.class);
                        startActivity(intent);
                    } else {
                        Snackbar.make(findViewById(android.R.id.content), "Por favor, completa todos los campos", Snackbar.LENGTH_SHORT).show();
                    }
                } else {
                    Snackbar.make(findViewById(android.R.id.content), "La pista en la hora seleccionada ya esta reservada", Snackbar.LENGTH_SHORT).show();
                }
            });
        }
    }
    private Task<Boolean> comprobarReservasPista(ReservarPista nuevaReserva) {
        TaskCompletionSource<Boolean> taskCompletionSource = new TaskCompletionSource<>();
        rr.findAllByPista(idPista).addOnCompleteListener(task -> {
            List<ReservarPista> reservarPistaList = task.getResult();
            boolean response = true;
            if (!reservarPistaList.isEmpty()) {
                for (ReservarPista reserva : reservarPistaList) {
                    // Comprobar si las fechas coinciden

                    Calendar calendarReserva = Calendar.getInstance();
                    calendarReserva.setTime(reserva.getFechaReserva());

                    Calendar calendarNuevaReserva = Calendar.getInstance();
                    calendarNuevaReserva.setTime(nuevaReserva.getFechaReserva());

                    if (calendarReserva.get(Calendar.YEAR) == calendarNuevaReserva.get(Calendar.YEAR) &&
                            calendarReserva.get(Calendar.MONTH) == calendarNuevaReserva.get(Calendar.MONTH) &&
                            calendarReserva.get(Calendar.DAY_OF_MONTH) == calendarNuevaReserva.get(Calendar.DAY_OF_MONTH)) {
                        // Calcular el tiempo de finalización para ambas reservas
                        int minutosInicioReservaExistente = reserva.getHoraInicio() * 60 + reserva.getMinutoInicio();
                        int minutosFinReservaExistente = minutosInicioReservaExistente + reserva.getMinutosReserva();
                        int minutosInicioNuevaReserva = nuevaReserva.getHoraInicio() * 60 + nuevaReserva.getMinutoInicio();
                        int minutosFinNuevaReserva = minutosInicioNuevaReserva + nuevaReserva.getMinutosReserva();

                        // Verificar si hay solapamiento entre las reservas
                        if ((minutosInicioNuevaReserva >= minutosInicioReservaExistente && minutosInicioNuevaReserva < minutosFinReservaExistente) ||
                                (minutosFinNuevaReserva > minutosInicioReservaExistente && minutosFinNuevaReserva <= minutosFinReservaExistente) ||
                                (minutosInicioNuevaReserva <= minutosInicioReservaExistente && minutosFinNuevaReserva >= minutosFinReservaExistente)) {
                            response = false;// Existe solapamiento, no se puede crear la nueva reserva
                            break; //No es necesario continuar la iteracion.
                        }
                    }
                }

                taskCompletionSource.setResult(response);
            }
        });
        return taskCompletionSource.getTask();
    }

    private boolean comprobarParametros(ReservarPista nuevaReserva) {
        return !(nuevaReserva.getIdPista().isEmpty() ||
                nuevaReserva.getFechaReserva() == null ||
                nuevaReserva.getNombreCliente().isEmpty() ||
                nuevaReserva.getTelefonoCliente().isEmpty() ||
                nuevaReserva.getMinutosReserva() < 0 ||
                nuevaReserva.getPrecioFinal() < 0);
    }

    public void cancelarReserva(View v) {
        Intent intent = new Intent(this, pistas.class);
        startActivity(intent);
    }
}