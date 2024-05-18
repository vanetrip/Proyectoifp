package com.example.storyshareapp.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;
import com.example.storyshareapp.Model.Eventos;
import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Evento;
import com.example.storyshareapp.Persistencia.Libro;
import com.example.storyshareapp.R;

public class InfoBookActivity extends AppCompatActivity {

    private Button boton1;
    private Button boton2;
    private Button boton3;


    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;


    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private BasedeDatos basedeDatos;
    private int idUsuario;
    private int idLibro;
    private int idEvento;


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
        image5 = (ImageView) findViewById(R.id.imageView6_infoBook);
        textView1 = (TextView) findViewById(R.id.textView5_info_book);
        textView2 = (TextView) findViewById(R.id.textView10_infoBook);
        textView3 = (TextView) findViewById(R.id.textView12_infoBook);
        textView4 = (TextView) findViewById(R.id.textView15_info_book);
        textView5 = (TextView) findViewById(R.id.textView17_infobook);

        basedeDatos = new BasedeDatos(this);

        // Obtener el idUsuario del Intent que inició esta actividad
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1); // -1 es un valor predeterminado en caso de que no se encuentre el extra
        System.out.println("idUsuario " + idUsuario);
        //Obtner el idLibro
        idLibro = intent.getIntExtra("idLibro", -1);
        System.out.println("idLibro " + idLibro);

        Libro libro = basedeDatos.obtenerLibro(idLibro);

        if (libro != null) {
            cargarImagenPortada(libro.getPortada(), image5);
            textView1.setText(libro.getTitulo()); // Título del libro - TITULO
            textView2.setText(libro.getTitulo()); // Título del libro - DESCRIPCION
            textView3.setText(libro.getAutor()); // Autor del libro - DESCRIPCION

        } else {
            Toast.makeText(this, "No se encontró información del libro", Toast.LENGTH_SHORT).show();
        }

        Evento evento = basedeDatos.obtenerEvento(idEvento);
        if (evento != null) {
            textView4.setText(libro.getTitulo()); // FECHA EVENTO - DESCRIPCION
            textView5.setText(libro.getTitulo()); // HORA EVENTO - DESCRIPCION
        } else {
            Toast.makeText(this, "No se encontró información del evento", Toast.LENGTH_SHORT).show();
        }
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image1.setOnClickListener(openFavoritos);
        textView2.setOnClickListener(openFavoritos);

        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image2.setOnClickListener(openEventos);
        textView3.setOnClickListener(openEventos);

        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openPerfil);
        textView4.setOnClickListener(openPerfil);
        View.OnClickListener openHome = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image4.setOnClickListener(openHome);

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Foro
                Intent intent = new Intent(InfoBookActivity.this, Forum.class);
                intent.putExtra("idUsuario", idUsuario);
                intent.putExtra("idLibro", idLibro);
                startActivity(intent);
            }
        });


        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Crear Eventos
                Intent intent = new Intent(InfoBookActivity.this, DiscordActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Ir a Reunion
                Intent intent = new Intent(InfoBookActivity.this, ReunionActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                intent.putExtra("idLibro", idLibro);
                startActivity(intent);
            }
        });
    }

    private void cargarImagenPortada(String urlPortada, ImageView imageView) {
        if (urlPortada != null && !urlPortada.isEmpty()) {
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.logo_blanco)
                    .error(R.drawable.avatar_blanco)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);

            Glide.with(this)
                    .load(urlPortada)
                    .apply(requestOptions)
                    .listener(new RequestListener<Drawable>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Drawable> target, boolean isFirstResource) {
                            // Manejo de errores al cargar la imagen
                            Log.e("TAG", "Error al cargar la imagen: " + e.getMessage(), e);
                            // Puedes mostrar un mensaje de error al usuario si lo deseas
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(InfoBookActivity.this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show();
                                }
                            });
                            return false; // Retornar 'true' si deseas que Glide maneje el error y cargue la imagen de error definida
                        }

                        @Override
                        public boolean onResourceReady(Drawable resource, Object model, Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
                            // La imagen se cargó exitosamente
                            Log.d("TAG", "Imagen cargada con éxito");
                            return false;
                        }
                    })
                    .into(imageView);
        } else {
            // La URL de la imagen es inválida
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(InfoBookActivity.this, "URL de portada no válida", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}
