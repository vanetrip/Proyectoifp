package com.example.storyshareapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.storyshareapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class InicioActivity extends AppCompatActivity {
    // declaración de variables
    private Intent pasarPantalla;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    // creamos una tarea de tiempo para pasar de la pantalla actual a otra pantalla.
    TimerTask tt = new TimerTask() {
        @Override
        public void run() {
            pasarPantalla = new Intent(InicioActivity.this, SignInActivity.class);
            finish();
            startActivity(pasarPantalla);
        }};
    Timer t = new Timer();
        t.schedule(tt,3000);

                }}
