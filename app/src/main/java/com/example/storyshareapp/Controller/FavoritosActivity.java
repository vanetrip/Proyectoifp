package com.example.storyshareapp.Controller;

import android.content.Intent;
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

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Libro;
import com.example.storyshareapp.R;

import java.util.ArrayList;
import java.util.List;

public class FavoritosActivity extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private EditText editText1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private ListView listView1;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private int idLibro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritos);

        // OBTENER IDUSUARIO
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1);

        basedeDatos = new BasedeDatos(this);

        //Imagen logo
        image1 = (ImageView) findViewById(R.id.imageView1_favoritos);

        //Favs
        image2 = (ImageView) findViewById(R.id.imageView2_favoritos);
        textView2 = (TextView) findViewById(R.id.textView2_favoritos);

        // Eventos
        image3 = (ImageView) findViewById(R.id.imageView3_favoritos);
        textView3 = (TextView) findViewById(R.id.textView3_favoritos);

        // Profile
        image4 = (ImageView) findViewById(R.id.imageView4_favoritos);
        textView4 = (TextView) findViewById(R.id.textView4_favoritos);

        listView1 = (ListView) findViewById(R.id.listView_favs);

        // Buscador
        editText1 = findViewById(R.id.editText1_favoritos);


        // MÉTODO ABRIR FAVS
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritosActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image2.setOnClickListener(openFavoritos);
        textView2.setOnClickListener(openFavoritos);


        // MÉTODO ABRIR EVENTOS
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritosActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openEventos);
        textView3.setOnClickListener(openEventos);

        // MÉTODO ABRIR PERFIL
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritosActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image4.setOnClickListener(openPerfil);
        textView4.setOnClickListener(openPerfil);

        // IR A HOME
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FavoritosActivity.this, HomeActivity.class);
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
                    Intent intent = new Intent(FavoritosActivity.this, BuscadorActivity.class);
                    intent.putExtra("textoBusqueda", textoBusqueda);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        // OBTENER LIBROS FAVORITOS PARA LISTVIEW

        List<Integer> librosFavoritosIds = basedeDatos.obtenerLibrosFavoritos(idUsuario);
        System.out.println("librosFavoritosIds " + librosFavoritosIds);
        List<String> titulosLibros = new ArrayList<>();

        for (int libroId : librosFavoritosIds) {
            Libro libro = basedeDatos.obtenerLibro(libroId);
            if (libro != null) {
                titulosLibros.add(libro.getTitulo());
            }
        }
        if (titulosLibros.isEmpty()) {
            titulosLibros.add("No hay libros favoritos");
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, titulosLibros);
        listView1.setAdapter(adapter);

        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String tituloSeleccionado = (String) parent.getItemAtPosition(position);
                idLibro = basedeDatos.buscarIdLibroPorTitulo(tituloSeleccionado);
                if (idLibro != -1) {
                    Intent intent = new Intent(FavoritosActivity.this, InfoBookActivity.class);
                    intent.putExtra("idUsuario", idUsuario);
                    intent.putExtra("idLibro", idLibro);
                    startActivity(intent);
                } else {
                    Toast.makeText(FavoritosActivity.this, "No se encontraron resultados", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}