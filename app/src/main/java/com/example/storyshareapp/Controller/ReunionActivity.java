package com.example.storyshareapp.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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

import java.text.SimpleDateFormat;
import java.util.Locale;

public class ReunionActivity extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private TextView textView6;
    private TextView textView7;
    private TextView textView8;
    private EditText editText1;
    private int idUsuario;
    private int idLibro;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion);

        // OBTENER IDUSUARIO
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1);
        System.out.println("idUsuario " + idUsuario);

        //OBTENER IDLIBRO
        idLibro = intent.getIntExtra("idLibro", -1);
        System.out.println("idLibro " + idLibro);

        // Botón discord
        boton1 = (Button) findViewById(R.id.button4_reunion);
        // Botón crear reunión
        boton2 = (Button) findViewById(R.id.button5_reunion);
        // Imagenfavs
        image1 = (ImageView) findViewById(R.id.imageView3_reunion);
        textView1 = (TextView) findViewById(R.id.textView1_reunion);
        //Imageneventos
        image2 = (ImageView) findViewById(R.id.imageView4_reunion);
        textView2 = (TextView) findViewById(R.id.textView2_reunion);
        //Imagenperfil
        image3 = (ImageView) findViewById(R.id.imageView5_reunion);
        textView3 = (TextView) findViewById(R.id.textView3_reunion);
        // Imagen Storyshare
        image4 = (ImageView) findViewById(R.id.imageView1_reunion);
        //Texto titulo
        textView4 = (TextView) findViewById(R.id.textView9_reunion);
        //Texto dia
        textView5 = (TextView) findViewById(R.id.textView11_reunion);
        //Texto hora
        textView6 = (TextView) findViewById(R.id.textView13_reunion);
        // Título libro
        textView7 = (TextView) findViewById(R.id.textView5_reunion);
        // Autor libro
        textView8 = (TextView) findViewById(R.id.textView6_reunion);
        // Buscador
        editText1 = findViewById(R.id.editText1_reunion);

        // MÉTODO ABRIR FAVS
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReunionActivity.this, FavoritosActivity.class);
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
                Intent intent = new Intent(ReunionActivity.this, EventosActivity.class);
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
                Intent intent = new Intent(ReunionActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openPerfil);
        textView3.setOnClickListener(openPerfil);

        // ABRIR DISCORD
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReunionActivity.this, DiscordActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });

        // CREAR REUNIÓN
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReunionActivity.this, DiscordActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });

        // IR A HOME
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ReunionActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });

        // OBTENER DATOS LIBRO
        BasedeDatos db = new BasedeDatos(this);
        idLibro = 1;
        Libro libro = db.obtenerLibro(idLibro);

        if (libro != null) {
            textView7.setText(libro.getTitulo()); // Título del libro
            textView8.setText(libro.getAutor()); // Autor del libro
        } else {
            Toast.makeText(this, "No se encontró información del libro", Toast.LENGTH_SHORT).show();
        }

        // OBTENER DATOS EVENTO LIBRO
        int idEvento = db.obtenerIdEventoMasProximo(idLibro);

        // Verificar si se encontró un evento
        if (idEvento != -1) {
            // Obtener los datos del evento utilizando su ID
            Evento evento = db.obtenerEvento(idEvento);

            // Mostrar la información del evento en los TextViews
            if (evento != null) {
                textView4.setText(evento.getNombreEvento()); // Nombre del evento
                textView5.setText(evento.getFecha()); // Fecha del evento
                textView6.setText(evento.getHora()); // Hora del evento
            }

        } else {
            Toast.makeText(this, "No hay eventos próximos para este libro", Toast.LENGTH_SHORT).show();
            textView4.setText("");
            textView5.setText("");
            textView6.setText("");
        }

        // BUSCADOR
        editText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String textoBusqueda = editText1.getText().toString().trim();

                    // Crear el Intent y pasar a la BuscadorActivity
                    Intent intent = new Intent(ReunionActivity.this, BuscadorActivity.class);
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
