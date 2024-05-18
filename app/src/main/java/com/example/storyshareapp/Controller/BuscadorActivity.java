package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

public class BuscadorActivity extends AppCompatActivity {

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ListView list1;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscador);
        image1 = (ImageView) findViewById(R.id.imageView3_buscador);
        image2 = (ImageView) findViewById(R.id.imageView4_buscador);
        image3 = (ImageView) findViewById(R.id.imageView5_buscador);
        boton1 = (Button) findViewById(R.id.button1_buscador);
        boton2 = (Button) findViewById(R.id.button7_buscador);
        boton3 = (Button) findViewById(R.id.button8_buscador);
        list1 = (ListView) findViewById(R.id.listView_buscador);

       /* db= new GestorDB(this);
        listadoAudios= db.getAudios();
        adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listadoAudios);
        lista1.setAdapter(adaptador);


        lista1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contenidoItem= parent.getItemAtPosition(position).toString();
                String selectedItem = listadoAudios.get(position);

                pasarPantalla = new Intent(MainActivity.this, ReproducirActivity.class);
                pasarPantalla.putExtra("VALOR", contenidoItem);
                startActivity(pasarPantalla);
            }

        });*/


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favoritos
                Intent intent = new Intent(BuscadorActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Eventos
                Intent intent = new Intent(BuscadorActivity.this, EventosActivity.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Perfil
                Intent intent = new Intent(BuscadorActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para abrir la actividad Centro de Ayuda

            }
        });
    }
}