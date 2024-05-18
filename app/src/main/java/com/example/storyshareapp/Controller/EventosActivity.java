package com.example.storyshareapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.R;

import java.util.ArrayList;


public class EventosActivity extends AppCompatActivity {

    private ListView listaEventos;
    private String contenidoItem="";

    private ArrayList<String> listaNombresEventos = new ArrayList<>();
    private ArrayAdapter<String> adaptador;
    private BasedeDatos basedeDatos;
    private Intent pasarPantalla;
/*
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        listaEventos = findViewById(R.id.lista_eventos);
        BasedeDatos basedeDatos = new BasedeDatos(this);

        listaNombresEventos = basedeDatos.obtenerEvento();
        adaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaNombresEventos);
        listaEventos.setAdapter(adaptador);

        listaEventos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contenidoItem= parent.getItemAtPosition(position).toString();
                Toast.makeText(EventosActivity.this, "El item tiene "+ contenidoItem, Toast.LENGTH_SHORT).show();

                pasarPantalla= new Intent(EventosActivity.this, EventosActivity.class);
                pasarPantalla.putExtra("VALOR",contenidoItem);
                startActivity(pasarPantalla);

            }
        });
    }*/}