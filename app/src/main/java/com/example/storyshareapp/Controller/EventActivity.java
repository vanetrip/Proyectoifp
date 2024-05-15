/*package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Persistencia.Evento;
import com.example.storyshareapp.R;

public class EventActivity extends AppCompatActivity {

    protected TextView nombre_evento;
    protected TextView fecha_evento;
    protected TextView hora_evento;
    protected TextView libro_evento;
    protected Button boton1_evento;


    public void goToFavorites(View view) {
        // Código para ir a la pantalla de favoritos
        Intent intent = new Intent(this, FavoritosActivity.class);
        startActivity(intent);
    }

    public void goToEvents(View view) {
        // Código para ir a la pantalla de eventos
        Intent intent = new Intent(this, ListEventsActivity.class);
        startActivity(intent);
    }

    public void goToProfile(View view) {
        // Código para ir a la pantalla de perfil
        Intent intent = new Intent(this,Profile.class);
        startActivity(intent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_crearevento);

        nombre_evento= (TextView) findViewById(R.id.nombre1_event);
        fecha_evento = (TextView) findViewById(R.id.fecha_event);
        hora_evento = (TextView) findViewById(R.id.hora_event);
        libro_evento = (TextView) findViewById(R.id.libro_event);

        boton1_evento= (Button) findViewById(R.id.button1_event);

        findViewById(R.id.button1_event).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Obtener los datos ingresados por el usuario
                String nombre = nombre_evento.getText().toString();
                String fecha = fecha_evento.getText().toString();
                String hora = hora_evento.getText().toString();
                String libro = libro_evento.getText().toString();

                // Validar que los datos no estén vacíos
                if (nombre.isEmpty() || fecha.isEmpty() || hora.isEmpty() || libro.isEmpty()) {
                    Toast.makeText(EventActivity.this, "Por favor, complete todos los campos", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Crear un objeto Evento con los datos ingresados
                Evento evento = new Evento(nombre, fecha, hora, moderador_id,libro_id);

                // Insertar el evento en la base de datos
                boolean exito = insertarEvento(evento);

                // Mostrar un mensaje dependiendo del resultado
                if (exito) {
                    Toast.makeText(EventActivity.this, "Evento creado exitosamente", Toast.LENGTH_SHORT).show();
                    // Aquí podrías redirigir a otra actividad si lo deseas
                } else {
                    Toast.makeText(EventActivity.this, "Error al crear el evento", Toast.LENGTH_SHORT).show();
                }
            }
        });

        private boolean insertarEvento(Evento evento) {

            // Llamar al método insertarEvento de tu base de datos
            // Deberás implementar la conexión a tu base de datos aquí
        }
    }
}*/
