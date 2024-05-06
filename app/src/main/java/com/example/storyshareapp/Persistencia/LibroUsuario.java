package com.example.storyshareapp.Persistencia;

import java.sql.Date;

public class LibroUsuario {
    private int id;
    private int usuarioId;
    private int libroId;
    private Date fechaLectura;
    private int valoracion;
    private String comentario;

    // Constructor vacío
    public LibroUsuario() {
    }

    // Constructor con elementos
    public LibroUsuario(int id, int usuarioId, int libroId, Date fechaLectura, int valoracion, String comentario) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.libroId = libroId;
        this.fechaLectura = fechaLectura;
        this.valoracion = valoracion;
        this.comentario = comentario;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }

    public Date getFechaLectura() {
        return fechaLectura;
    }

    public void setFechaLectura(Date fechaLectura) {
        this.fechaLectura = fechaLectura;
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
