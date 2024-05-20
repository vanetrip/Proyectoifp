package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Foro;
import com.example.storyshareapp.R;

import java.util.List;

public class ForumActivity extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    private EditText buscador;

    private ListView list1;

    private Button boton1;
    private BasedeDatos basedeDatos;
    private List<Foro> foroList;

    private int idUsuario;
    private int idLibro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum);

        image1 = (ImageView) findViewById(R.id.imageView3_forum);
        image2 = (ImageView) findViewById(R.id.imageView4_forum);
        image3 = (ImageView) findViewById(R.id.imageView5_forum);
        image4 = (ImageView) findViewById(R.id.imageView1_forum);
        text1 = (TextView) findViewById(R.id.textView2_forum);
        text2 = (TextView) findViewById(R.id.textView3_forum);
        text3 = (TextView) findViewById(R.id.textView4_forum);
        buscador =(EditText) findViewById(R.id.editText1_forum_buscador);
        list1= (ListView) findViewById(R.id.listView_forum);
        boton1 = (Button) findViewById(R.id.button10_forum);
        basedeDatos = new BasedeDatos(this);
        // OBTENER IDUSUARIO
        Intent intent = getIntent();

        //OBTENER IDLIBRO
        idLibro = intent.getIntExtra("idLibro", -1);
        idUsuario = intent.getIntExtra("idUsuario", -1);

        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ForumActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });

        //Salto de pantalla a Favoritos
        image1.setOnClickListener(openFavoritos);
        text1.setOnClickListener(openFavoritos);
        //Salto de pantalla a Eventos
        image2.setOnClickListener(openEventos);
        text2.setOnClickListener(openEventos);
        //Salto de pantalla a Perfil
        image3.setOnClickListener(openPerfil);
        text3.setOnClickListener(openPerfil);
        buscador.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String textoBusqueda = buscador.getText().toString().trim();

                    // Crear el Intent y pasar a la BuscadorActivity
                    Intent intent = new Intent(ForumActivity.this, BuscadorActivity.class);
                    intent.putExtra("textoBusqueda", textoBusqueda);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        foroList = basedeDatos.obtenerForos();
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Crear Tema
                Intent intent = new Intent(ForumActivity.this, NewForumActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                intent.putExtra("idLibro", idLibro);
                startActivity(intent);
            }
        });


        ArrayAdapter<Foro> adapter = new ArrayAdapter<Foro>(this,
                android.R.layout.simple_list_item_1, foroList) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(android.R.layout.simple_list_item_1, parent, false);
                }

                Foro foro = getItem(position);
                TextView textView = convertView.findViewById(android.R.id.text1);
                textView.setText(foro.getNombre());

                return convertView;
            }
        };
        list1.setAdapter(adapter);

        // Set an item click listener if needed
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Foro foro = foroList.get(position);
                // Handle the click event
                Intent intent = new Intent(ForumActivity.this, ForumActivity.class);
                intent.putExtra("foroId", foro.getId());
                startActivity(intent);
            }
        });

        }
    }
