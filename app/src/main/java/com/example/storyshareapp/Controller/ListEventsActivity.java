package com.example.storyshareapp.Controller;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Persistencia.Evento;
import com.example.storyshareapp.R;

public class ListEventsActivity extends AppCompatActivity {

    private TextView tituloLibro;
    private TextView autor;
    private TextView fecha;
    private TextView hora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_eventos);

        tituloLibro = findViewById(R.id.titulo_eventos);
        autor = findViewById(R.id.autor_eventos);
        fecha = findViewById(R.id.dia_eventos);
        hora = findViewById(R.id.hora_eventos);

        Evento evento = obtenerDatosEvento();

        tituloLibro.setText(evento.getNombreEvento());
        autor.setText(evento.getAutor());
        fecha.setText(evento.getFecha());
        hora.setText(evento.getHora());

        private Evento obtenerDatosEvento() {

            // Si estás utilizando MySQL, podrías hacer una solicitud HTTP a tu API para obtener los datos
            
            return new Evento("El nombre del libro", "El autor del libro", "2024-05-15", "18:00");
        }
    }
}
