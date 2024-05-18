package com.example.storyshareapp.Persistencia;

import java.util.Date;

public class Foro {
    private int id;
    private String nombre;
    private int creadorId;
    private int idLibro;
    private Date fechaCreacion;

    // Constructor vacío
    public Foro() {
    }

    // Constructor con todos los parámetros
    public Foro(int id, String nombre, int creadorId, int idLibro, Date fechaCreacion) {
        this.id = id;
        this.nombre = nombre;
        this.creadorId = creadorId;
        this.idLibro = idLibro;
        this.fechaCreacion = fechaCreacion;
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

    public int getCreadorId() {
        return creadorId;
    }

    public void setCreadorId(int creadorId) {
        this.creadorId = creadorId;
    }

    public int getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(int idLibro) {
        this.idLibro = idLibro;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
