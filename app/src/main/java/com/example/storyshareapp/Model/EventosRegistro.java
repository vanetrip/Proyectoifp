package com.example.storyshareapp.Model;

public class EventosRegistro {

    //declaracion de variables
    Integer id;
    Integer evento_id;
    Integer Usuario_id;
    // constructor vacio
    public EventosRegistro (){
    }
    //Crear Constructor

    public EventosRegistro(Integer id, Integer evento_id, Integer usuario_id) {
        this.id = id;
        this.evento_id = evento_id;
        Usuario_id = usuario_id;
    }

    //insertar getters & Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEvento_id() {
        return evento_id;
    }

    public void setEvento_id(Integer evento_id) {
        this.evento_id = evento_id;
    }

    public Integer getUsuario_id() {
        return Usuario_id;
    }

    public void setUsuario_id(Integer usuario_id) {
        Usuario_id = usuario_id;
    }
}
