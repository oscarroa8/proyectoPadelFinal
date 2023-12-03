package com.example.proyectopadel.back.dao;

import android.util.Log;

import com.example.proyectopadel.back.entidades.Usuario;
import com.example.proyectopadel.back.interfaces.IUsuario;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepositorio implements IUsuario<Usuario> {
    private final FirebaseFirestore bd;
    private static final String TAG = PistaRepositorio.class.getName();
    public UsuarioRepositorio(FirebaseFirestore bd) {
        this.bd = bd;
    }


    @Override
    public Task<String> insertar(Usuario usuario) {
        return bd.collection("usuarios")
                .add(usuario)
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
    public void actualizar(Usuario usuario) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Task<Void> borrar(Usuario usuario) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Usuario getById(Integer id) {
        throw new UnsupportedOperationException();
    }

    //@Override
   public Usuario obtenerUsuarioPorUsuarioYContrasena(String usuario, String contrasena) throws Exception {
       throw new UnsupportedOperationException();
       /* String SQL = contexto.getResources().getString(R.string.OBTENER_USUARIO_POR_USUARIO_Y_CONTRASENA);
        Cursor c = bd.rawQuery(SQL, new String[]{usuario, contrasena});
        c.moveToFirst();
        Usuario usu= cursorAUsuario(c);
        Objects.requireNonNull(c).close();
        return usu;*/
    }

    @Override
    public Usuario obtenerUsuarioPorEmailYContrasena(String email, String contrasena) throws Exception {
      /*  String SQL = contexto.getResources().getString(R.string.OBTENER_USUARIO_POR_EMAIL_Y_CONTRASENA);
        Cursor c = bd.rawQuery(SQL, new String[]{email, contrasena});
        c.moveToFirst();
        Usuario usuario = cursorAUsuario(c);
        Objects.requireNonNull(c).close();
        return usuario;*/
        throw new UnsupportedOperationException();
    }
    @Override
    public Task<List<Usuario>> findAllUsuarios() {

        return bd.collection("usuarios")
                .get()
                .continueWith( task -> {
                            List<Usuario> usuarios = new ArrayList<>();
                            if (task.isSuccessful()) {
                                for (QueryDocumentSnapshot document : task.getResult()) {
                                    Usuario usu = new Usuario(
                                            //document.getId(),
                                            document.get("nombre", String.class),
                                            document.get("apellido1", String.class),
                                            document.get("apellido2", String.class),
                                            document.get("mail", String.class)

                                            );
                                    usuarios.add(usu);
                                }
                            }
                            else {
                                Log.w(TAG, "Error en consulta de firebase", task.getException());
                            }
                            return usuarios;
                        }
                );
    }

}
