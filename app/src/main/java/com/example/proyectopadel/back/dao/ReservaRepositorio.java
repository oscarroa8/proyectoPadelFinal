package com.example.proyectopadel.back.dao;

import android.util.Log;

import com.example.proyectopadel.back.entidades.ReservarPista;
import com.example.proyectopadel.back.interfaces.IReservarPista;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReservaRepositorio implements IReservarPista<ReservarPista> {
    private final FirebaseFirestore bd;

    private static final String TAG = ReservaRepositorio.class.getName();

    public ReservaRepositorio(FirebaseFirestore bd) {
        this.bd=bd;
    }
    @Override
    public Task<String> insertar(ReservarPista reserva) {
        return bd.collection("reservas")
                .add(reserva)
                .continueWith(task -> {
                    if (task.isSuccessful()) {
                        DocumentReference doc = task.getResult();
                        return doc.getId();
                    } else {
                        Log.w(TAG, "Error en consulta de firebase", task.getException());
                        return null;
                    }
                });
    }

    @Override
    public void actualizar(ReservarPista reserva) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task<Void> borrar(ReservarPista reserva) {
        return bd.collection("reservas")
                .document(reserva.getIdReserva())
                .delete()
                .continueWith(task -> {
                    if (!task.isSuccessful()) {
                        Log.w(TAG, "Error en consulta de firebase", task.getException());
                    }
                    return null;
                });
    }

    @Override
    public ReservarPista getById(Integer id) {
        return null;
    }

    @Override
    public Task<List<ReservarPista>> findAllByPista(String idPista) {
        return bd.collection("reservas")
                .whereEqualTo("idPista", idPista)
                .get()
                .continueWith(task -> {
                    List<ReservarPista> reservas = new ArrayList<>();
                    if (task.isSuccessful()) {
                        for (QueryDocumentSnapshot document : task.getResult()) {
                            ReservarPista p = null;
                            Object fechaReservaObj = document.get("fechaReserva", Date.class);
                            if(fechaReservaObj instanceof Date){
                                p = new ReservarPista(
                                        document.getId(),
                                        document.get("nombreCliente", String.class),
                                        document.get("telefonoCliente", String.class),
                                        (Date) fechaReservaObj,
                                        document.get("horaInicio", Integer.class),
                                        document.get("minutoInicio", Integer.class),
                                        document.get("minutosReserva", Integer.class),
                                        document.get("precioFinal", Double.class)
                                );
                            }else{
                                Log.e(TAG, "El valor de fechaReserva no es un Date");
                            }

                            if (p != null) {
                                reservas.add(p);
                            }
                        }
                    } else {
                        Log.w(TAG, "Error en consulta de Firebase", task.getException());
                    }
                    return reservas;
                });
    }
}
