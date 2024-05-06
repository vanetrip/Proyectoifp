package com.example.storyshareapp.Persistencia;

import java.sql.Date;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private Date fechaPublicacion;
    private int valoracion;
    private String portada; // Nuevo atributo para la portada del libro

    // Constructor vacío
    public Libro() {
    }

    // Constructor con elementos
    public Libro(int id, String titulo, String autor, String genero, Date fechaPublicacion, int valoracion, String portada) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.fechaPublicacion = fechaPublicacion;
        this.valoracion = valoracion;
        this.portada = portada;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}