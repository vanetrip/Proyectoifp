package com.example.storyshareapp.Model;

public class Mensajes {

    //declaracion de variables
    Integer id;
    Integer usuario_destino_id;
    Integer usuario_origen_id;

    String texto_sms;
    Boolean borrar_sms;


    // constructor vacio
    public Mensajes (){
    }
    //Crear Constructor


    public Mensajes(Integer id, Integer usuario_destino_id, Integer usuario_origen_id, String texto_sms, Boolean borrar_sms) {
        this.id = id;
        this.usuario_destino_id = usuario_destino_id;
        this.usuario_origen_id = usuario_origen_id;
        this.texto_sms = texto_sms;
        this.borrar_sms = borrar_sms;
    }
    //insertar getters & Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUsuario_destino_id() {
        return usuario_destino_id;
    }

    public void setUsuario_destino_id(Integer usuario_destino_id) {
        this.usuario_destino_id = usuario_destino_id;
    }

    public Integer getUsuario_origen_id() {
        return usuario_origen_id;
    }

    public void setUsuario_origen_id(Integer usuario_origen_id) {
        this.usuario_origen_id = usuario_origen_id;
    }

    public String getTexto_sms() {
        return texto_sms;
    }

    public void setTexto_sms(String texto_sms) {
        this.texto_sms = texto_sms;
    }

    public Boolean getBorrar_sms() {
        return borrar_sms;
    }

    public void setBorrar_sms(Boolean borrar_sms) {
        this.borrar_sms = borrar_sms;
    }
}
