package com.example.storyshareapp.Controller;

import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.R;


public class EventosActivity extends AppCompatActivity {
    private BasedeDatos basedeDatos;
    private TextView textView50_eventos;
    private TextView textView51_eventos;
    private TextView textView52_eventos;
    private TextView textView53_eventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide(); // Ocultar la ActionBar
        setContentView(R.layout.activity_eventos);

        basedeDatos = new BasedeDatos(this);
        textView50_eventos = findViewById(R.id.textView50_eventos);
        textView51_eventos = findViewById(R.id.textView51_eventos);
        textView52_eventos = findViewById(R.id.textView52_eventos);
        textView53_eventos = findViewById(R.id.textView53_eventos);
    }

   /* public void mostrarRegistrosEventos() {
        // Obtener el cursor con los registros de eventos
        Cursor cursor = basedeDatos.obtenerRegistrosEventos();

        // Verificar si el cursor no es nulo y contiene datos
        if (cursor != null && cursor.moveToFirst()) {
            do {
                // Obtener los valores de los campos del registro actual
                String fecha = cursor.getString(1);
                String nombreEvento = cursor.getString(2);
                String hora = cursor.getString(3);
                String moderador = cursor.getString(4);

                // Asignar los valores a los TextView correspondientes
                textView50_eventos.append(fecha + "\n");
                textView51_eventos.append(nombreEvento + "\n");
                textView52_eventos.append(hora + "\n");
                textView53_eventos.append(moderador + "\n");
            } while (cursor.moveToNext());

            cursor.close(); // Cerrar el cursor después de usarlo
        }
    }*/
}