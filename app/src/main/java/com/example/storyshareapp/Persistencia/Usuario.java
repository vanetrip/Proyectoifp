package com.example.storyshareapp.Persistencia;

import java.sql.Date;

public class Usuario {

    private int id;
    private String nombreUsuario;
    private String contraseña;
    private int planId;
    private Date planInicio;
    private Date planFin;
    private String email;
    private int edad;
    private String nombre;

    // Constructor vacío

    public Usuario() {
    }

    // Constructor con todos los parámetros
    public Usuario(int id, String nombreUsuario, String contraseña, int planId, Date planInicio, Date planFin, String email, int edad, String nombre) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.planId = planId;
        this.planInicio = planInicio;
        this.planFin = planFin;
        this.email = email;
        this.edad = edad;
        this.nombre = nombre;
    }
    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public int getPlanId() {
        return planId;
    }

    public void setPlanId(int planId) {
        this.planId = planId;
    }

    public Date getPlanInicio() {
        return planInicio;
    }

    public void setPlanInicio(Date planInicio) {
        this.planInicio = planInicio;
    }

    public Date getPlanFin() {
        return planFin;
    }

    public void setPlanFin(Date planFin) {
        this.planFin = planFin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}


