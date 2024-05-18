package com.example.storyshareapp.Model;

import java.sql.Date;

public class Eventos {

    //declaracion de variables
    Integer id;
    String nombre;
    Date fecha;
    Date hora;
    Integer moderador_id;
    Integer libro_id;


    // constructor vacio
    public Eventos (){
    }
    //Crear Constructor

    public Eventos(Integer id, String nombre_evento, Date fecha, Date hora, Integer moderador_id, Integer libro_id) {
        this.id = id;
        this.nombre = nombre;
        this.fecha = fecha;
        this.hora = hora;
        this.moderador_id = moderador_id;
        this.libro_id = libro_id;
    }


    //insertar getters & Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_evento() {
        return nombre;
    }

    public void setNombre_evento(String nombre_evento) {
        this.nombre = nombre_evento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        hora = hora;
    }

    public Integer getModerador_id() {
        return moderador_id;
    }

    public void setModerador_id(Integer moderador_id) {
        this.moderador_id = moderador_id;
    }

    public Integer getLibro_id() {
        return libro_id;
    }

    public void setLibro_id(Integer libro_id) {
        this.libro_id = libro_id;
    }
}
