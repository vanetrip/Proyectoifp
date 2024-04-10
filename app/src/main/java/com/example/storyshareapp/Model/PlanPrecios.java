package com.example.storyshareapp.Model;

public class PlanPrecios {
    //declaracion de variables
    Integer id;
    String plan;

    // constructor vacio
    public PlanPrecios (){
    }
    //Crear Constructor


    public PlanPrecios(Integer id, String plan) {
        this.id = id;
        this.plan = plan;
    }

    //insertar getters & Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
