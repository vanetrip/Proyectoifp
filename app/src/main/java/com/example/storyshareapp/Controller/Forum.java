package com.example.storyshareapp.Controller;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.storyshareapp.R;

public class Forum {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;

    private ListView list1;

    private Button boton1;

    private ArrayAdapter<String> adapter;
}
    /*    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        image1 = (ImageView) findViewById(R.id.imageView3_forum);
        image2 = (ImageView) findViewById(R.id.imageView4_forum);
        image3 = (ImageView) findViewById(R.id.imageView5_forum);
        list1= (ListView) findViewById(R.id.listView_forum);
        boton1 = (Button) findViewById(R.id.button10_forum); //falta este evento. Que llevaria a un cuestionario.

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favorito
                Intent intent = new Intent(Forum.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(Forum.this, EventosActivity.class);
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

            cursor.close();
        }
    }*/
