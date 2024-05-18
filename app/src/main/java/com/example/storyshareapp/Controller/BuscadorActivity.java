package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
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
    private EditText editText1;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private int idLibro;
    private String textoBusqueda;
    private List<Libro> listadoLibros= new ArrayList<>();
    private ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscador);
        // Imagen favs
        image1 = (ImageView) findViewById(R.id.imageView3_buscador);
        textView1 = (TextView) findViewById(R.id.textView2_buscador);
        // Imagen eventos
        image2 = (ImageView) findViewById(R.id.imageView4_buscador);
        textView2 = (TextView) findViewById(R.id.textView3_buscador);
        // Imagen perfil
        image3 = (ImageView) findViewById(R.id.imageView5_buscador);
        textView3 = (TextView) findViewById(R.id.textView4_buscador);
        // Imagen logo
        image4 = (ImageView) findViewById(R.id.imageView1_buscador);
        // Botones menú inferior
        boton1 = (Button) findViewById(R.id.button1_buscador);
        boton2 = (Button) findViewById(R.id.button7_buscador);
        boton3 = (Button) findViewById(R.id.button8_buscador);
        // Buscador
        editText1 = findViewById(R.id.editText4_buscador);
        // Text
        list1 = (ListView) findViewById(R.id.listView_buscador);

        basedeDatos = new BasedeDatos(this);
        // Obtener el idUsuario
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1);
        //Obtener el texto de la búsqueda
        textoBusqueda = intent.getStringExtra("textoBusqueda");

        // LISTA DE LIBROS
        listadoLibros= basedeDatos.obtenerLibrosEnOrdenAlfabetico();
        List<String> titulosLibros = new ArrayList<>();

        if (textoBusqueda != null && !textoBusqueda.isEmpty()) {
            List<Integer> idLibros = basedeDatos.buscarIdLibrosPorTitulo(textoBusqueda);
            if (!idLibros.isEmpty()) {
                // Si se encontraron resultados
                for (int idLibro : idLibros) {
                    Libro libro = basedeDatos.obtenerLibro(idLibro);
                    if (libro != null) {
                        titulosLibros.add(libro.getTitulo());
                    }
                }
            } else {
                // Si no se encontraron resultados
                titulosLibros.add("No se encontraron resultados");
            }
        } else {
            // Si no hay texto de búsqueda, obtener todos los libros ordenados alfabéticamente
            List<Libro> listadoLibros = basedeDatos.obtenerLibrosEnOrdenAlfabetico();
            for (Libro libro : listadoLibros) {
                titulosLibros.add(libro.getTitulo());
            }
        }

        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titulosLibros);
        list1.setAdapter(adaptador);

        // MENU SUPERIOR
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image1.setOnClickListener(openFavoritos);
        textView1.setOnClickListener(openFavoritos);
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image2.setOnClickListener(openEventos);
        textView2.setOnClickListener(openEventos);
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openPerfil);
        textView3.setOnClickListener(openPerfil);
        View.OnClickListener openHome = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuscadorActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image4.setOnClickListener(openHome);


        // MENU INFERIOR
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Lógica para abrir la actividad Centro de Ayuda

            }
        });

        // LISTA DE LIBROS
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tituloSeleccionado = (String) parent.getItemAtPosition(position);
                // Realizar la búsqueda en la base de datos por el título
                idLibro = basedeDatos.buscarIdLibroPorTitulo(tituloSeleccionado);
                if (idLibro != -1) {
                    // Pasar a InfoBookActivity
                    Intent intent = new Intent(BuscadorActivity.this, InfoBookActivity.class);
                    intent.putExtra("idUsuario", idUsuario);
                    intent.putExtra("idLibro", idLibro);
                    startActivity(intent);
                } else {
                    // Si no se encontraron resultados
                    Toast.makeText(BuscadorActivity.this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // BUSCADOR
        editText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String textoBusqueda = editText1.getText().toString().trim();

                    // Crear el Intent y pasar a la BuscadorActivity
                    Intent intent = new Intent(BuscadorActivity.this, BuscadorActivity.class);
                    intent.putExtra("textoBusqueda", textoBusqueda);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });
    }
}