package com.example.storyshareapp.Persistencia;

import java.sql.Date;

public class Usuario {

    private int id;
    private String nombreUsuario;
    private String contraseña;
    private int planId;
    private Date planInicio;
    private Date planFin;
    private String nombre;
    private String apellido;
    private String email;
    private Date fechaNacimiento;

    // Constructor vacío
    public Usuario() {
    }

    // Constructor con todos los parámetros
    public Usuario(int id, String nombreUsuario, String contraseña, int planId, Date planInicio, Date planFin, String nombre, String apellido, String email, Date fechaNacimiento) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.contraseña = contraseña;
        this.planId = planId;
        this.planInicio = planInicio;
        this.planFin = planFin;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
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

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
