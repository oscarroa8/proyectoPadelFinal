package com.example.proyectopadel;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.proyectopadel.back.entidades.Pista;

import java.util.List;

public class ListAdapter extends ArrayAdapter<Pista> {
    private List<Pista> listaPistas;
    private Context contexto;
    private int resourceLayout;
    public ListAdapter(@NonNull Context context, int resource, List<Pista> objects) {
        super(context, resource, objects);
        this.listaPistas=objects;
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

        Pista pista = listaPistas.get(position);

        TextView tvNombre = view.findViewById(R.id.tvNombrePistaRow);
        tvNombre.setText(pista.getNombrePista());
        TextView tvMaterial = view.findViewById(R.id.tvMaterialRow);
        tvMaterial.setText(pista.getMaterial());
        TextView tvPrecio = view.findViewById(R.id.tvPrecioRow);
        tvPrecio.setText(pista.getPrecio());


        return view;
    }
}
