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

public class InfoBook extends AppCompatActivity {

    private Button boton1;
    private Button boton2;


    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_book);

        boton1 = (Button) findViewById(R.id.button9_info_book);
        boton2 = (Button) findViewById(R.id.button10_info_book);
        image1 = (ImageView) findViewById(R.id.imageView3_info_book);
        image2 = (ImageView) findViewById(R.id.imageView4_info_book);
        image3 = (ImageView) findViewById(R.id.imageView5_info_book);
        //image4 = (ImageView) findViewById(R.id.imageView6_info_book);
        //textView1 = (TextView) findViewById(R.id.textView5_infoBook);
        textView2 = (TextView) findViewById(R.id.textView10_infoBook);
        textView3 = (TextView) findViewById(R.id.textView12_infoBook);
        textView4 = (TextView) findViewById(R.id.textView15_info_book);
        textView5 = (TextView) findViewById(R.id.textView17_infobook);



        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favoritos
                Intent intent = new Intent(InfoBook.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(InfoBook.this, Eventos.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(InfoBook.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(InfoBook.this, Forum.class);
                startActivity(intent);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Eventos
                Intent intent = new Intent(InfoBook.this, Eventos.class);
                startActivity(intent);
            }
        });


    }

}
