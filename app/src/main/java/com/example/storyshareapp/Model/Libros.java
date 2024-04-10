package com.example.storyshareapp.Model;

import java.sql.Date;

public class Libros {

    //declaracion de variables
    String autor;
    Date fechapublicacion;
    String genero;
    String titulo;
    Integer valoracion;
    //crear el constructor vacio
    public Libros (){
    }
    //Crear Constructor
    public Libros (String autor,Date fechapublicacion, String genero, String titulo, Integer valoracion) {
        this.autor = autor;
        this.fechapublicacion = fechapublicacion;
        this.genero = genero;
        this.titulo=titulo;
        this.valoracion=valoracion;
    }

//insertar getters & Setters

    public String getAutor() {
        return autor;
        }
    public void setAutor(String autor) {
        this.autor = autor;
        }
    public Date getfechapublicacion() {
        return fechapublicacion;
    }
    public void setFechapublicacion(Date fechapublicacion) {
        this.fechapublicacion = fechapublicacion;
    }
    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.autor = genero;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getValoracion() {
        return valoracion;
    }
    public void setValoracion(Integer valoracion) {
        this.valoracion = valoracion;
    }
}



