package com.example.storyshareapp.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Model.Eventos;
import com.example.storyshareapp.R;

public class InfoBook extends AppCompatActivity {

    private Button boton1;
    private Button boton2;


    private ImageView image1;
    private ImageView image2;
    private ImageView image3;

    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_book);

        boton1 = (Button) findViewById(R.id.button9_info_book);
        boton2 = (Button) findViewById(R.id.button10_info_book);
        image1 = (ImageView) findViewById(R.id.imageView3_info_book);
        image2 = (ImageView) findViewById(R.id.imageView4_info_book);
        image3 = (ImageView) findViewById(R.id.imageView5_info_book);
        textView1 = (TextView) findViewById(R.id.textView10_infoBook);
        textView1 = (TextView) findViewById(R.id.textView12_infoBook);
        textView1 = (TextView) findViewById(R.id.textView15_info_book);
        textView1 = (TextView) findViewById(R.id.textView16_info_book);



        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favoritos
                Intent intent = new Intent(InfoBook.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(InfoBook.this, Eventos.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(InfoBook.this, Profile.class);
                startActivity(intent);
            }
        });
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(InfoBook.this, Forum.class);
                startActivity(intent);
            }
        });
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(InfoBook.this, Eventos.class);
                startActivity(intent);
            }
        });


        /*

Aqui habria que poner la consulta de la base de datos para que salga la información del libro, el autor, la hora y el dia de la reunion

        DBHelper dbHelper = new DBHelper(this);

// Suponiendo que tienes métodos en tu DBHelper para obtener los datos de la base de datos
        String tituloLibro = dbHelper.getTituloLibro(); // Método para obtener el título del libro desde la base de datos
        String autorLibro = dbHelper.getAutorLibro(); // Método para obtener el autor del libro desde la base de datos
        String diaEvento = dbHelper.getDiaEvento(); // Método para obtener el día del evento desde la base de datos
        String horaEvento = dbHelper.getHoraEvento(); // Método para obtener la hora del evento desde la base de datos

// Asignar los valores a los TextView
        textView1.setText(tituloLibro);
        textView2.setText(autorLibro);
        textView3.setText(diaEvento);
        textView4.setText(horaEvento);

        */
    }

}
