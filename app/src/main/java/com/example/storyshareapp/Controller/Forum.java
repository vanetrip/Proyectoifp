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

import com.example.storyshareapp.R;

public class Forum {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;

    private ListView list1;

    private Button boton1;

    private ArrayAdapter<String> adapter;
    private DBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        image1 = (ImageView) findViewById(R.id.imageView3_forum);
        image2 = (ImageView) findViewById(R.id.imageView4_forum);
        image3 = (ImageView) findViewById(R.id.imageView5_buscador);
        list1= (ListView) findViewById(R.id.listView_forum);
        boton1 = (Button) findViewById(R.id.button10_forum); //falta este evento. Que llevaria a un cuestionario.


        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(adapter);

        dbHelper = new DBHelper(this);
        mostrarEventos();

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
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(Forum.this, Profile.class);
                startActivity(intent);
            }
        });

        private void mostrarEventos() {
            SQLiteDatabase db = dbHelper.getReadableDatabase();
            Cursor cursor = db.query("tabla_eventos", null, null, null, null, null, null);

            while (cursor.moveToNext()) {
                // Suponiendo que tienes una columna llamada "nombre_evento" en tu tabla
                String nombreEvento = cursor.getString(cursor.getColumnIndex("nombre_evento"));
                adapter.add(nombreEvento);
            }

            cursor.close();
        }
    }

    }