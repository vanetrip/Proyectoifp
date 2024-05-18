package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Libro;
import com.example.storyshareapp.R;

import java.util.ArrayList;
import java.util.List;

public class BuscadorActivity extends AppCompatActivity {

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ListView list1;
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private int idLibro;
    private List<Libro> listadoLibros= new ArrayList<String>();
    private ArrayAdapter<String> adaptador;
    private String contenidoItem="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_buscador);
        image1 = (ImageView) findViewById(R.id.imageView3_buscador);
        image2 = (ImageView) findViewById(R.id.imageView4_buscador);
        image3 = (ImageView) findViewById(R.id.imageView5_buscador);
        image4 = (ImageView) findViewById(R.id.imageView1_buscador);
        boton1 = (Button) findViewById(R.id.button1_buscador);
        boton2 = (Button) findViewById(R.id.button7_buscador);
        boton3 = (Button) findViewById(R.id.button8_buscador);
        textView2 = (TextView) findViewById(R.id.textView10_infoBook);
        textView3 = (TextView) findViewById(R.id.textView12_infoBook);
        textView4 = (TextView) findViewById(R.id.textView15_info_book);
        list1 = (ListView) findViewById(R.id.listView_buscador);

        basedeDatos = new BasedeDatos(this);
        // Obtener el idUsuario del Intent que inició esta actividad
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1); // -1 es un valor predeterminado en caso de que no se encuentre el extra
        System.out.println("idUsuario "+idUsuario);
        //Obtner el idLibro
        idLibro = intent.getIntExtra("idLibro", -1);
        System.out.println("idLibro "+idLibro);

        listadoLibros= basedeDatos.obtenerLibrosEnOrdenAlfabetico();

        adaptador= new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listadoLibros);
        list1.setAdapter(adaptador);




        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image1.setOnClickListener(openFavoritos);
        textView2.setOnClickListener(openFavoritos);
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image2.setOnClickListener(openEventos);
        textView3.setOnClickListener(openEventos);
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, Profile.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openPerfil);
        textView4.setOnClickListener(openPerfil);
        View.OnClickListener openHome = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image4.setOnClickListener(openHome);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para abrir la actividad Centro de Ayuda

            }
        });

        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contenidoItem = parent.getItemAtPosition(position).toString();
                Intent intent = new Intent(BuscadorActivity.this, InfoBook.class);
                intent.putExtra("idUsuario", idUsuario);
                intent.putExtra("idLibro", idLibro);
                startActivity(intent);

            }
        });
    }
}