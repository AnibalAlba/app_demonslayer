package com.example.app_demonslayer;


import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.ViewHolder> {

    public interface OnItemClick {
        void onClick(Personaje p);
    }

    private final List<Personaje> lista;
    private final OnItemClick listener;

    public PersonajeAdapter(List<Personaje> lista, OnItemClick listener) {
        this.lista = lista;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_personaje, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder h, int position) {
        Personaje p = lista.get(position);
        int color = Color.parseColor(p.getColor());

        h.imgPersonaje.setImageResource(p.getImagen());
        h.tvNombre.setText(p.getNombre());
        h.tvEstilo.setText(p.getEstilo());
        h.tvEdad.setText("Edad: " + p.getEdad() + " años");
        h.tvPoder.setText("Poder " + p.getPoder() + "%");
        h.barPoder.setProgress(p.getPoder());
        h.barPoder.getProgressDrawable().setTint(color);
        h.franja.setBackgroundColor(color);
        h.tvNombre.setTextColor(color);

        h.itemView.setOnClickListener(v -> listener.onClick(p));
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPersonaje;
        TextView tvNombre, tvEstilo, tvEdad, tvPoder;
        ProgressBar barPoder;
        View franja;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPersonaje = itemView.findViewById(R.id.imgPersonaje);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvEstilo = itemView.findViewById(R.id.tvEstilo);
            tvEdad = itemView.findViewById(R.id.tvEdad);
            tvPoder = itemView.findViewById(R.id.tvPoder);
            barPoder = itemView.findViewById(R.id.barPoder);
            franja = itemView.findViewById(R.id.franja);
        }
    }
}
