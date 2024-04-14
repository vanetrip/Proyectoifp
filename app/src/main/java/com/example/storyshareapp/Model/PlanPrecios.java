package com.example.storyshareapp.Model;

public class PlanPrecios {
    //declaracion de variables
    Integer id;
    String planprecio;

    // constructor vacio
    public PlanPrecios (){
    }
    //Crear Constructor


    public PlanPrecios(Integer id, String plan) {
        this.id = id;
        this.planprecio = plan;
    }

    //insertar getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlan() {
        return planprecio;
    }

    public void setPlan(String plan) {
        this.planprecio = plan;
    }
}
