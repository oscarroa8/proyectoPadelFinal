package com.example.proyectopadel.back.dao;

import android.util.Log;

import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.interfaces.IPista;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class PistaRepositorio implements IPista<Pista> {
    private final FirebaseFirestore bd;

    private static final String TAG = PistaRepositorio.class.getName();

    public PistaRepositorio(FirebaseFirestore bd) {
        this.bd = bd;
    }

    @Override
    public Task<String> insertar(Pista pista) {
        return bd.collection("pistas")
                .add(pista)
                .continueWith(task -> {
                    if (task.isSuccessful()) {
                        DocumentReference doc = task.getResult();
                        return doc.getId();
                    }
                    else {
                        Log.w(TAG, "Error en consulta de firebase", task.getException());
                        return null;
                    }
                });
    }

    @Override
    public void actualizar(Pista pista) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void borrar(Pista pista) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Pista getById(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task<List<Pista>> findAll() {

        return bd.collection("pistas")
                .get()
                .continueWith( task -> {
                        List<Pista> pistas = new ArrayList<>();
                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {
                                Pista p = new Pista(
                                        document.getId(),
                                        document.get("nombre", String.class),
                                        document.get("material", String.class),
                                        document.get("precio", Integer.class)
                                );
                                pistas.add(p);
                            }
                        }
                        else {
                            Log.w(TAG, "Error en consulta de firebase", task.getException());
                        }
                        return pistas;
                    }
                );
    }

}
