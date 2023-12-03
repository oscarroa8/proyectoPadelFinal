package com.example.proyectopadel.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.entidades.Pista;
import com.example.proyectopadel.back.entidades.Usuario;

import java.util.List;

public class ListAdapterUsuarios extends ArrayAdapter<Usuario> {
    private Context contexto;
    private int resourceLayout;
    public ListAdapterUsuarios(@NonNull Context context, int resource, List<Usuario> objects) {
        super(context, resource, objects);
        this.contexto=context;
        this.resourceLayout = resource;
    }

    //Buscar las vistas de cada elemento
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(contexto).inflate(resourceLayout,null);
        }

        Usuario usu = getItem(position);

        TextView tvNombre = view.findViewById(R.id.tvNombreUsu);
        tvNombre.setText(usu.getNombre());
        TextView tvApellido1 = view.findViewById(R.id.tvApellido1);
        tvApellido1.setText(usu.getApellido1());
        TextView tvApellido2 = view.findViewById(R.id.tvApellido2);
        tvApellido2.setText(usu.getApellido2());
        TextView tvEmail = view.findViewById(R.id.tvemail);
        tvEmail.setText(usu.getMail());


        return view;
    }
    public void setUsuarios(List<Usuario> result) {
        clear();
        addAll(result);
    }
}
