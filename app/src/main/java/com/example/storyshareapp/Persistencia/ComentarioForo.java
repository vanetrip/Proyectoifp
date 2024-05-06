package com.example.storyshareapp.Persistencia;

import java.sql.Date;
import java.sql.Time;

public class ComentarioForo {
    private int id;
    private int idForo;
    private int idUsuario;
    private String comentario;
    private Date fecha;
    private Time hora; // Nuevo campo para la hora del comentario

    // Constructor vacío
    public ComentarioForo() {
    }

    // Constructor con elementos
    public ComentarioForo(int id, int idForo, int idUsuario, String comentario, Date fecha, Time hora) {
        this.id = id;
        this.idForo = idForo;
        this.idUsuario = idUsuario;
        this.comentario = comentario;
        this.fecha = fecha;
        this.hora = hora;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdForo() {
        return idForo;
    }

    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }
}
