package com.example.storyshareapp.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Model.Eventos;
import com.example.storyshareapp.R;

public class ReunionActivity extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;



    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion);

        boton1 = (Button) findViewById(R.id.button4_reunion);
        boton2 = (Button) findViewById(R.id.button5_reunion);
        image1 = (ImageView) findViewById(R.id.imageView3_reunion);
        image2 = (ImageView) findViewById(R.id.imageView4_reunion);
        image3 = (ImageView) findViewById(R.id.imageView5_reunion);
        textView1 = (TextView) findViewById(R.id.textView10_reunion);
        textView1 = (TextView) findViewById(R.id.textView11_reunion);
        textView1 = (TextView) findViewById(R.id.textView12_reunion);


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favorito
                Intent intent = new Intent(ReunionActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(ReunionActivity.this, Eventos.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(ReunionActivity.this, Profile.class);
                startActivity(intent);
            }
        });


    }


}
