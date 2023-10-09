package com.example.proyectopadel.controllers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.entidades.Usuario;

public class activity_newlogin extends AppCompatActivity {
    Button registro ;
    EditText etRegistroNombre,etRegistroApellido1, etRegistroApellido2,etRegistroMail,etRegistroContrasena;
    int id=0;
    Usuario usu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_newlogin);
        registro = findViewById(R.id.btnRegistrar);
        etRegistroNombre=findViewById(R.id.etRegistroNombre);
        etRegistroApellido1=findViewById(R.id.etRegistroApellido1);
        etRegistroApellido2=findViewById(R.id.etRegistroApellido2);
        etRegistroMail=findViewById(R.id.etRegistroMail);
        etRegistroContrasena=findViewById(R.id.etRegistroContrasena);

        registro.setOnClickListener(view -> {
            //Añadimos a la base de datos los registros para crear un usuario nuevo
          //  DbUsuarios db = new DbUsuarios(activity_newlogin.this);
            //long id = db.insertarUsuario(etRegistroNombre.getText().toString(),etRegistroApellido1.getText().toString(),etRegistroApellido2.getText().toString(),etRegistroMail.getText().toString(),etRegistroContrasena.getText().toString());
            if (id>0){
                Toast.makeText(activity_newlogin.this, "REGISTRO GUARDADO", Toast.LENGTH_SHORT).show();
                limpiar();
            }else{
                Toast.makeText(activity_newlogin.this, "ERROR AL GUARDAR EL REGISTRO", Toast.LENGTH_SHORT).show();
            }
        });
    }
    //Metodo para limpiar los registros de los elementos
    private void limpiar(){
        etRegistroNombre.setText("");
        etRegistroApellido1.setText("");
        etRegistroApellido2.setText("");
        etRegistroMail.setText("");
        etRegistroContrasena.setText("");


    }
}