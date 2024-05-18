package com.example.storyshareapp.Persistencia;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.Time;
import java.util.Locale;

public class Evento {
    private int id;
    private String nombreEvento;
    private Date fecha;
    private Time hora;
    private int moderadorId;
    private int libroId;

    // Constructor vacío
    public Evento() {
    }

    // Constructor con todos los parámetros
    public Evento(int id, String nombreEvento, Date fecha, Time hora, int moderadorId, int libroId) {
        this.id = id;
        this.nombreEvento = nombreEvento;
        this.fecha = fecha;
        this.hora = hora;
        this.moderadorId = moderadorId;
        this.libroId = libroId;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public String getFecha() {
        if (fecha != null) {
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            return dateFormat.format(this.fecha);
        } else {
            return "Fecha no disponible";
        }
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return timeFormat.format(this.hora);
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public int getModeradorId() {
        return moderadorId;
    }

    public void setModeradorId(int moderadorId) {
        this.moderadorId = moderadorId;
    }

    public int getLibroId() {
        return libroId;
    }

    public void setLibroId(int libroId) {
        this.libroId = libroId;
    }
}
