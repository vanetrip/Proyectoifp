package com.example.storyshareapp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Evento;
import com.example.storyshareapp.Persistencia.Libro;
import com.example.storyshareapp.R;

import java.util.ArrayList;
import java.util.List;


public class EventosActivity extends AppCompatActivity {

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private ListView listView1;
    private EditText editText1;
    private ArrayAdapter<String> adaptador;
    private BasedeDatos basedeDatos;
    private int idUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);

        // OBTENER IDUSUARIO
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1);

        basedeDatos = new BasedeDatos(this);

        // Imagenfavs
        image1 = (ImageView) findViewById(R.id.imageView1_eventos);
        textView1 = (TextView) findViewById(R.id.textView1_eventos);
        //Imageneventos
        image2 = (ImageView) findViewById(R.id.imageView2_eventos);
        textView2 = (TextView) findViewById(R.id.textView2_eventos);
        //Imagenperfil
        image3 = (ImageView) findViewById(R.id.imageView3_eventos);
        textView3 = (TextView) findViewById(R.id.textView3_eventos);
        // Imagen Storyshare
        image4 = (ImageView) findViewById(R.id.imageView4_eventos);
        // Buscador
        editText1 = findViewById(R.id.editText1_eventos);

        listView1 = (ListView) findViewById(R.id.listView1_eventos);

        // MÉTODO ABRIR FAVS
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventosActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image1.setOnClickListener(openFavoritos);
        textView1.setOnClickListener(openFavoritos);


        // MÉTODO ABRIR EVENTOS
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventosActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image2.setOnClickListener(openEventos);
        textView2.setOnClickListener(openEventos);

        // MÉTODO ABRIR PERFIL
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventosActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openPerfil);
        textView3.setOnClickListener(openPerfil);

        // IR A HOME
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EventosActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });

        // BUSCADOR
        editText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String textoBusqueda = editText1.getText().toString().trim();

                    // Crear el Intent y pasar a la BuscadorActivity
                    Intent intent = new Intent(EventosActivity.this, BuscadorActivity.class);
                    intent.putExtra("textoBusqueda", textoBusqueda);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        // OBTENER LIBROS FAVORITOS PARA LISTVIEW

        List<Evento> eventos = basedeDatos.obtenerEventosOrdenadosPorFecha();
        List<String> detallesEventos = new ArrayList<>();

        for (Evento evento : eventos) {
            String detalle = evento.getNombreEvento();
            detallesEventos.add(detalle);
        }

        if (detallesEventos.isEmpty()) {
            detallesEventos.add("No hay eventos próximos");
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, detallesEventos);
        listView1.setAdapter(adapter);

        // Configurar el listener para los elementos de la lista
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String detalleSeleccionado = (String) parent.getItemAtPosition(position);
                Evento eventoSeleccionado = basedeDatos.buscarEventoPorNombre(detalleSeleccionado);
                if (eventoSeleccionado != null) {
                    Intent intent = new Intent(EventosActivity.this, ReunionActivity.class);
                    intent.putExtra("idUsuario", idUsuario);
                    intent.putExtra("idEvento", eventoSeleccionado.getId());
                    intent.putExtra("idLibro", eventoSeleccionado.getLibroId());
                    startActivity(intent);
                } else {
                    Toast.makeText(EventosActivity.this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}