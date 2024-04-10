package com.example.storyshareapp.Model;

import java.sql.Date;

public class Usuarios {
    //declaracion de variables
    Integer id;
    String nombreUsuario;
    String contraseña;
    Integer plan_id;
    Date plan_inicio;
    Date plan_fin;
    String nombre;
    String apellido;
    String email;
    Date fecha_nacimiento;

    // constructor vacio
    public Usuarios (){
    }
    //Crear Constructor

    public Usuarios(Integer id, String nombreUsuario, String contraseña, Integer plan_id, Date plan_inicio, Date plan_fin, String nombre, String apellido, String email, Date fecha_nacimiento) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.plan_id = plan_id;
        this.plan_inicio = plan_inicio;
        this.plan_fin = plan_fin;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fecha_nacimiento = fecha_nacimiento;
    }

    //insertar getters & Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Integer getPlan_id() {
        return plan_id;
    }

    public void setPlan_id(Integer plan_id) {
        this.plan_id = plan_id;
    }

    public Date getPlan_inicio() {
        return plan_inicio;
    }

    public void setPlan_inicio(Date plan_inicio) {
        this.plan_inicio = plan_inicio;
    }

    public Date getPlan_fin() {
        return plan_fin;
    }

    public void setPlan_fin(Date plan_fin) {
        this.plan_fin = plan_fin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }
}
