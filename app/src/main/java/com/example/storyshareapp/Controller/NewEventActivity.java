package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Evento;
import com.example.storyshareapp.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class NewEventActivity extends AppCompatActivity {

    View.OnClickListener openFavoritos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(NewEventActivity.this, FavoritosActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener openEventos = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(NewEventActivity.this, EventosActivity.class);
            startActivity(intent);
        }
    };
    View.OnClickListener openPerfil = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(NewEventActivity.this, ProfileActivity.class);
            startActivity(intent);
        }
    };
    protected TextView nombre;
    protected TextView fecha;
    protected TextView hora;
    protected TextView libro;
    protected Button boton1;
    private SQLiteDatabase db;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    protected TextView text1;
    protected TextView text2;
    protected TextView text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearevento);

        nombre= (TextView) findViewById(R.id.editTextText1_creareventos);
        fecha = (TextView) findViewById(R.id.editTextText_crearevento);
        hora = (TextView) findViewById(R.id.editTextText2_creareventos);
        libro = (TextView) findViewById(R.id.editTextText3_crearevento);
        boton1= (Button) findViewById(R.id.button1_Crearevento);
        image1 = (ImageView) findViewById(R.id.imageView6_newEvent6);
        image2 = (ImageView) findViewById(R.id.imageView7_newEvent7);
        image3= (ImageView) findViewById(R.id.imageView8_newEvent8);
        /*
        //Salto de pantalla a Favoritos
        image1.setOnClickListener(openFavoritos);
        text1.setOnClickListener(openFavoritos);
        //Salto de pantalla a Eventos
        image2.setOnClickListener(openEventos);
        text2.setOnClickListener(openEventos);
        //Salto de pantalla a Perfil
        image3.setOnClickListener(openPerfil);
        text3.setOnClickListener(openPerfil);
    */
        BasedeDatos basedeDatos = new BasedeDatos(this);

        idUsuario = getIntent().getIntExtra("idUsuario", -1);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombreEvento = nombre.getText().toString();
                String fechaEventoStr = fecha.getText().toString();
                String horaEventoStr = hora.getText().toString();
                String libroIdStr = libro.getText().toString();



                if (nombreEvento.isEmpty() || fechaEventoStr.isEmpty() || horaEventoStr.isEmpty() || libroIdStr.isEmpty()) {
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
                    libroId = Integer.parseInt(libroIdStr);
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