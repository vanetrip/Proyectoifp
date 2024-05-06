package com.example.storyshareapp.Persistencia;

public class PlanPrecio {
    private int id;
    private String nombre;
    private double precio;

    // Constructor vacío
    public PlanPrecio() {
    }

    // Constructor con elementos
    public PlanPrecio(int id, String nombre, double precio) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
