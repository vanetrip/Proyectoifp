package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {


    protected TextView label1;
    protected TextView label2;

    private Intent pasarPantalla;




        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

            label1= (TextView) findViewById(R.id.label1_start);
            label2= (TextView) findViewById(R.id.label2_start);
            TimerTask tt= new TimerTask() {
                @Override
                public void run() {
                    pasarPantalla = new Intent(MainActivity.this, WelcomeActivity.class);
                    finish();
                    startActivity(pasarPantalla);
                }
            };
            Timer t= new Timer();
            t.schedule(tt, 3000);

        }}



