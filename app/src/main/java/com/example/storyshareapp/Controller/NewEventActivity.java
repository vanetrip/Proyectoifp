package com.example.storyshareapp.Controller;

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
import com.example.storyshareapp.Persistencia.Evento;
import com.example.storyshareapp.Persistencia.Libro;
import com.example.storyshareapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NewEventActivity extends AppCompatActivity {


    private TextView nombre;
    private TextView fecha;
    private TextView hora;
    private EditText buscador;
    private TextView libroTextView;
    private Button boton1;
    private SQLiteDatabase db;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private int idLibro;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private TextView text1;
    private TextView text2;
    private TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newevent);

        nombre= (TextView) findViewById(R.id.editTextText1_creareventos);
        fecha = (TextView) findViewById(R.id.editTextText_crearevento);
        hora = (TextView) findViewById(R.id.editTextText2_creareventos);
        libroTextView = (TextView) findViewById(R.id.textView22_crearevento);
        boton1= (Button) findViewById(R.id.button1_Crearevento);
        image1 = (ImageView) findViewById(R.id.imageView6_newEvent6);
        image2 = (ImageView) findViewById(R.id.imageView7_newEvent7);
        image3= (ImageView) findViewById(R.id.imageView3_newEvent8);
        image4 = (ImageView) findViewById(R.id.imageView4_Creareventos);
        text1 = (TextView) findViewById(R.id.textView18_crearevento);
        text2 = (TextView) findViewById(R.id.textView19_crearevento);
        text3 = (TextView) findViewById(R.id.textView20_crearevento);
        buscador = (EditText) findViewById(R.id.editText1_crearEvento);

        // MÉTODO ABRIR FAVS
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewEventActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image1.setOnClickListener(openFavoritos);
        text1.setOnClickListener(openFavoritos);
        // IR A HOME
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewEventActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });
        // MÉTODO ABRIR EVENTOS
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewEventActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image2.setOnClickListener(openEventos);
        text2.setOnClickListener(openEventos);
        // MÉTODO ABRIR PERFIL
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewEventActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };


        image3.setOnClickListener(openPerfil);
        text3.setOnClickListener(openPerfil);

        //Buscador
        buscador.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String textoBusqueda = buscador.getText().toString().trim();

                    // Crear el Intent y pasar a la BuscadorActivity
                    Intent intent = new Intent(NewEventActivity.this, BuscadorActivity.class);
                    intent.putExtra("textoBusqueda", textoBusqueda);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        BasedeDatos basedeDatos = new BasedeDatos(this);

        idUsuario = getIntent().getIntExtra("idUsuario", -1);
        idLibro = getIntent().getIntExtra("idLibro", -1);

        Libro libro = basedeDatos.obtenerLibro(idLibro);
        if (libro != null) {
            String tituloLibro = libro.getTitulo();
            if (tituloLibro != null) {
                libroTextView.setText(tituloLibro);
            } else {
                Toast.makeText(NewEventActivity.this, "El título del libro es nulo", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(NewEventActivity.this, "No se encontró el libro con el ID especificado", Toast.LENGTH_SHORT).show();
        }

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreEvento = nombre.getText().toString();
                String fechaEventoStr = fecha.getText().toString();
                String horaEventoStr = hora.getText().toString();

                if (nombreEvento.isEmpty() || fechaEventoStr.isEmpty() || horaEventoStr.isEmpty() || idLibro == -1) {
                    Toast.makeText(NewEventActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
                Date fechaEvento = null;
                java.sql.Time horaEvento = null;
                int libroId;

                try {
                    fechaEvento = dateFormat.parse(fechaEventoStr);
                    horaEvento = new java.sql.Time(timeFormat.parse(horaEventoStr).getTime());
                    libroId = idLibro;
                } catch (ParseException e) {
                    Toast.makeText(NewEventActivity.this, "Formato de fecha u hora incorrecto", Toast.LENGTH_SHORT).show();
                    return;
                } catch (NumberFormatException e) {
                    Toast.makeText(NewEventActivity.this, "ID del libro debe ser un número", Toast.LENGTH_SHORT).show();
                    return;
                }

                Evento nuevoEvento = new Evento(0, nombreEvento, new java.sql.Date(fechaEvento.getTime()), horaEvento, 1, libroId); // Suponiendo moderadorId = 1 por ahora

                long id = basedeDatos.insertarEvento(nuevoEvento);
                if (id != -1) {
                    Toast.makeText(NewEventActivity.this, "Evento guardado exitosamente", Toast.LENGTH_SHORT).show();
                    // Redirigir a EventosActivity
                    Intent intent = new Intent(NewEventActivity.this, EventosActivity.class);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    finish(); // Cerrar la actividad actual
                } else {
                    Toast.makeText(NewEventActivity.this, "Error al guardar el evento", Toast.LENGTH_SHORT).show();
                }

            }

        });

        }
}