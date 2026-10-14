package com.example.app_demonslayer;

import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Personaje> lista = new ArrayList<>();
        lista.add(new Personaje("Tanjiro Kamado", "Danza del Dios del Fuego", 15, 85, "#2E7D32", R.drawable.tanjiro));
        lista.add(new Personaje("Nezuko Kamado", "Arte Demoníaco de Sangre", 14, 80, "#EC407A", R.drawable.nezuko));
        lista.add(new Personaje("Zenitsu Agatsuma", "Respiración del Trueno", 16, 78, "#FBC02D", R.drawable.zenitsu));
        lista.add(new Personaje("Inosuke Hashibira", "Respiración de la Bestia", 15, 76, "#5C6BC0", R.drawable.inosuke));
        lista.add(new Personaje("Giyu Tomioka", "Respiración del Agua", 21, 92, "#0288D1", R.drawable.giyuu));
        lista.add(new Personaje("Kyojuro Rengoku", "Respiración de la Llama", 20, 95, "#E64A19", R.drawable.rengoku));

        RecyclerView rv = findViewById(R.id.recyclerView);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(new PersonajeAdapter(lista, p ->
                new AlertDialog.Builder(this)
                        .setTitle(p.getNombre())
                        .setIcon(p.getImagen())
                        .setMessage("Estilo: " + p.getEstilo()
                                + "\nEdad: " + p.getEdad() + " años"
                                + "\nNivel de poder: " + p.getPoder() + "%")
                        .setPositiveButton("Cerrar", null)
                        .show()));
    }
}