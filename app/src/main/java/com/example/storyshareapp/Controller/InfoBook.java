package com.example.storyshareapp.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Model.Eventos;
import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Evento;
import com.example.storyshareapp.Persistencia.Libro;
import com.example.storyshareapp.R;

public class InfoBook extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private Button boton3;


    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private int idLibro;
    private int idEvento;
    private String paquete1="";
    private Bundle extras;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_book);

        boton1 = (Button) findViewById(R.id.button9_info_book);
        boton2 = (Button) findViewById(R.id.button10_info_book);
        boton3 = (Button) findViewById(R.id.button11_info_book);
        image1 = (ImageView) findViewById(R.id.imageView3_info_book);
        image2 = (ImageView) findViewById(R.id.imageView4_info_book);
        image3 = (ImageView) findViewById(R.id.imageView5_info_book);
        image4 = (ImageView) findViewById(R.id.imageView1_info_book);
        textView1 = (TextView) findViewById(R.id.textView5_info_book);
        textView2 = (TextView) findViewById(R.id.textView10_infoBook);
        textView3 = (TextView) findViewById(R.id.textView12_infoBook);
        textView4 = (TextView) findViewById(R.id.textView15_info_book);
        textView5 = (TextView) findViewById(R.id.textView17_infobook);

        basedeDatos = new BasedeDatos(this);

        // Obtener el idUsuario del Intent que inició esta actividad
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1); // -1 es un valor predeterminado en caso de que no se encuentre el extra
        System.out.println("idUsuario "+idUsuario);
        //Obtner el idLibro
        idLibro = intent.getIntExtra("idLibro", -1);
        System.out.println("idLibro "+idLibro);

        Libro libro = basedeDatos.obtenerLibro(idLibro);

        if (libro != null) {
            textView1.setText(libro.getTitulo()); // Título del libro - TITULO
            textView2.setText(libro.getTitulo()); // Título del libro - DESCRIPCION
            textView3.setText(libro.getAutor()); // Autor del libro - DESCRIPCION
            //textView4.setText(libro.getTitulo()); // FECHA EVENTO - DESCRIPCION
            //textView5.setText(libro.getTitulo()); // HORA EVENTO - DESCRIPCION
        } else {
            Toast.makeText(this, "No se encontró información del libro", Toast.LENGTH_SHORT).show();
        }

        Evento evento =basedeDatos.obtenerEvento(idEvento);
        if (evento != null) {
            textView4.setText(libro.getTitulo()); // FECHA EVENTO - DESCRIPCION
            textView5.setText(libro.getTitulo()); // HORA EVENTO - DESCRIPCION
        } else {
            Toast.makeText(this, "No se encontró información del evento", Toast.LENGTH_SHORT).show();
        }
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBook.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image1.setOnClickListener(openFavoritos);
        textView2.setOnClickListener(openFavoritos);

        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBook.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image2.setOnClickListener(openEventos);
        textView3.setOnClickListener(openEventos);

        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBook.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openPerfil);
        textView4.setOnClickListener(openPerfil);
        View.OnClickListener openHome = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBook.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image4.setOnClickListener(openHome);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Foro
                Intent intent = new Intent(InfoBook.this, Forum.class);
                intent.putExtra("idUsuario", idUsuario);
                intent.putExtra("idLibro", idLibro);
                startActivity(intent);
            }
        });


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Crear Eventos
                Intent intent = new Intent(InfoBook.this, NewEventActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Ir a Reunion
                Intent intent = new Intent(InfoBook.this, ReunionActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                intent.putExtra("idLibro", idLibro);
                startActivity(intent);
            }
        });


    }

}
