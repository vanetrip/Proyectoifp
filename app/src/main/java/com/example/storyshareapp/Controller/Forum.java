package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

public class Forum extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;

    private ListView list1;

    private Button boton1;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        image1 = (ImageView) findViewById(R.id.imageView3_forum);
        image2 = (ImageView) findViewById(R.id.imageView4_forum);

        list1= (ListView) findViewById(R.id.listView_forum);
        boton1 = (Button) findViewById(R.id.button10_forum); //falta este evento. Que llevaria a un cuestionario.




        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favorito
                Intent intent = new Intent(Forum.this, FavoritoActivity.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(Forum.this, CalendarioActivity.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Perfil
                Intent intent = new Intent(Forum.this, Profile.class);
                startActivity(intent);
            }
        });


    }

    }