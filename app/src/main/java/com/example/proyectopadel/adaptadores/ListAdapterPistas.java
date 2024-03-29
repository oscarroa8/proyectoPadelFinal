package com.example.proyectopadel.adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectopadel.R;
import com.example.proyectopadel.back.dao.PistaRepositorio;
import com.example.proyectopadel.back.entidades.Pista;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.List;

public class ListAdapterPistas extends ArrayAdapter<Pista> {
    private Context contexto;
    private int resourceLayout;
    private PistaRepositorio pr;
    public ListAdapterPistas(@NonNull Context context, int resource, List<Pista> objects) {
        super(context, resource, objects);
        this.contexto=context;
        this.resourceLayout = resource;
        this.pr = new PistaRepositorio(FirebaseFirestore.getInstance());
    }

    //Buscar las vistas de cada elemento
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(contexto).inflate(resourceLayout,null);
        }

        Pista pista = getItem(position);

        TextView tvNombre = view.findViewById(R.id.tvNombrePistaRow);
        tvNombre.setText(pista.getNombre());
        TextView tvMaterial = view.findViewById(R.id.tvMaterialRow);
        tvMaterial.setText(pista.getMaterial());
        TextView tvPrecio = view.findViewById(R.id.tvPrecioRow);
        tvPrecio.setText(Integer.toString(pista.getPrecio()));
        ImageView btn_borrar = view.findViewById(R.id.ivBorrar);
        btn_borrar.setOnClickListener((v) -> borrar(pista));

        return view;
    }


    public void setPistas(List<Pista> result) {
        clear();
        addAll(result);
    }

    private void borrar(Pista pista) {
        pr.borrar(pista)
                .addOnCompleteListener(task -> {
                    remove(pista);
                });

    }

}
