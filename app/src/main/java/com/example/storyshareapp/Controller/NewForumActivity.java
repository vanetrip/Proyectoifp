package com.example.storyshareapp.Controller;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NewForumActivity extends AppCompatActivity {


    protected TextView nombre;
    protected TextView fecha;
    protected TextView libro;
    protected EditText buscador;
    protected Button boton1;
    private SQLiteDatabase db;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private int idLibro;
    private int idLibroSeleccionado = -1; // Añadir esta variable para el libro seleccionado

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    protected TextView text1;
    protected TextView text2;
    protected TextView text3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newforum);
        // OBTENER IDUSUARIO
        Intent intent = getIntent();

        //OBTENER IDLIBRO
        idLibro = intent.getIntExtra("idLibro", -1);
        idUsuario = intent.getIntExtra("idUsuario", -1); // -1 es un valor predeterminado en caso de que no se encuentre el extra

        nombre = (TextView) findViewById(R.id.nombre1_event_theme);
        fecha =(TextView) findViewById(R.id.fecha_theme);
        libro =(TextView) findViewById(R.id.libro_event_theme);
        boton1 = (Button) findViewById(R.id.button1_event_theme);
        image1 = (ImageView) findViewById(R.id.imageView6_theme);
        image2 = (ImageView)findViewById(R.id.imageView7_theme);
        image3 = (ImageView)findViewById(R.id.imageView8_theme);
        image4 = (ImageView)findViewById(R.id.imageView4_theme);
        text1 = (TextView) findViewById(R.id.textView18_theme);
        text2 = (TextView)findViewById(R.id.textView19_theme);
        text3 = (TextView)findViewById(R.id.textView20_theme);
        buscador=(EditText) findViewById(R.id.editText1_crearTemaBuscador) ;
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewForumActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewForumActivity.this, EventosActivity.class);
                startActivity(intent);
            }
        };
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewForumActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        };
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewForumActivity.this, HomeActivity.class);
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
                    Intent intent = new Intent(NewForumActivity.this, BuscadorActivity.class);
                    intent.putExtra("textoBusqueda", textoBusqueda);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        String nombreLibro = intent.getStringExtra("nombreLibro");
        basedeDatos = new BasedeDatos(this);
        libro.setText(nombreLibro);

        // Guardar el tema y redirigir a EventosActivity cuando se hace clic en el botón
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarTema();
            }
        });
    }

    private void guardarTema() {
        String nombreTema = nombre.getText().toString();
        String fechaTemaStr = fecha.getText().toString();
        String libroTema= libro.getText().toString();

        if (nombreTema.isEmpty() || fechaTemaStr.isEmpty() || libroTema.isEmpty()) {
            Toast.makeText(NewForumActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
            return;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaTema;
        try {
            fechaTema = dateFormat.parse(fechaTemaStr);
        } catch (ParseException e) {
            Toast.makeText(NewForumActivity.this, "Formato de fecha incorrecto", Toast.LENGTH_SHORT).show();
            return;
        }

        ContentValues values = new ContentValues();
        values.put("nombre", nombreTema);
        values.put("creador_id", idUsuario);
        values.put("id_libro", idLibroSeleccionado);
        values.put("fecha_creacion", dateFormat.format(fechaTema));

        db = basedeDatos.getWritableDatabase();
        long id = db.insert("Foros", null, values);
        if (id != -1) {
            Toast.makeText(NewForumActivity.this, "Tema guardado exitosamente", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(NewForumActivity.this, ForumActivity.class);
            intent.putExtra("id_usuario", idUsuario);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(NewForumActivity.this, "Error al guardar el tema", Toast.LENGTH_SHORT).show();
        }
        // BUSCADOR


    }
}