package com.example.app_demonslayer;

public class Personaje {
    private String nombre;
    private String estilo;
    private int edad;
    private int poder;        // 0 - 100
    private String color;     // color de acento, ej. "#2E7D32"
    private int imagen;       // R.drawable.xxx

    public Personaje(String nombre, String estilo, int edad, int poder, String color, int imagen) {
        this.nombre = nombre;
        this.estilo = estilo;
        this.edad = edad;
        this.poder = poder;
        this.color = color;
        this.imagen = imagen;
    }

    public String getNombre() { return nombre; }
    public String getEstilo() { return estilo; }
    public int getEdad() { return edad; }
    public int getPoder() { return poder; }
    public String getColor() { return color; }
    public int getImagen() { return imagen; }
}