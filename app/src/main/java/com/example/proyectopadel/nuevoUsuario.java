package com.example.proyectopadel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopadel.back.Database;
import com.example.proyectopadel.back.dao.PistaRepositorio;
import com.example.proyectopadel.back.dao.UsuarioRepositorio;
import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.entidades.Usuario;

public class nuevoUsuario extends AppCompatActivity {
    EditText etNombre,etApellido1,etApellido2,etCorreo;
    Button btnCrear;
    Database bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_usuario);
        btnCrear = findViewById(R.id.btnCrearUsu);

        bd = new Database(this);


        etNombre = findViewById(R.id.etNombreUsuario);
        etApellido1 = findViewById(R.id.etApellidoUsuario);
        etApellido2 = findViewById(R.id.etSegundoApellidoUsu);
        etCorreo = findViewById(R.id.etCorreoUsu);

    }


    public void insertarUsuario(View view){
        UsuarioRepositorio ur = new UsuarioRepositorio(bd.getWritableDatabase());
        String nombreUsuario = etNombre.getText().toString();
        String apellido1 = etApellido1.getText().toString();
        String apellido2 = etApellido2.getText().toString();
        String correo = etCorreo.getText().toString();

        Usuario usu = new Usuario(nombreUsuario,apellido1,apellido2,correo);

        if (!nombreUsuario.isEmpty() && !apellido1.isEmpty() && !apellido2.isEmpty() && !correo.isEmpty()) {
            ur.insertar(usu);
            Toast.makeText(this, "Datos insertados correctamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this,Usuarios.class);//Falta crear la clase usuarios
            startActivity(intent);
        } else {
            Toast.makeText(this, "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}