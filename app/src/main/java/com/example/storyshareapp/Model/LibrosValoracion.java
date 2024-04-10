package com.example.storyshareapp.Model;

public class LibrosValoracion {

    //declaracion de variables
    String comentario;
    String usuario_valoracion;
    Integer valoracion;

    //crear el constructor vacio
    public LibrosValoracion (){
    }
    //Crear Metodo
    public LibrosValoracion (String comentario, String usuario_valoracion, Integer valoracion){
        this.comentario = comentario;
        this.usuario_valoracion=usuario_valoracion;
        this.valoracion=valoracion;
    }


//insertar getters & Setters

    public String getComentario() {
        return comentario;
    }
    public void setComentario(String comentario) {
        this.comentario= comentario;
    }
    public String getUsuario_valoracion() {
        return usuario_valoracion;
    }
    public void setUsuario_valoracion(String usuario_valoracion) {
        this.usuario_valoracion= usuario_valoracion;
    }
}