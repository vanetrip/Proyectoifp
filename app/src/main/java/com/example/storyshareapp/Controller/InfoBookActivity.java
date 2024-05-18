package com.example.storyshareapp.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.icu.text.IDNA;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
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
    private TextView textView6;
    private TextView textView7;
    private EditText editText1;
    private ImageButton imageButton1;
    private BasedeDatos db;
    private int idUsuario;
    private int idLibro;
    private int idEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_book);

        // OBTENER IDUSUARIO
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1);
        //OBTENER IDLIBRO
        idLibro = intent.getIntExtra("idLibro", -1);

        // Boton acceder foro
        boton1 = (Button) findViewById(R.id.button9_info_book);
        // Boton ir a crear evento
        boton2 = (Button) findViewById(R.id.button10_info_book);
        // Boton ir
        boton3 = (Button) findViewById(R.id.button11_info_book);
        // Boton favs
        image1 = (ImageView) findViewById(R.id.imageView3_info_book);
        textView1 = (TextView) findViewById(R.id.textView2_info_book);
        // Boton eventos
        image2 = (ImageView) findViewById(R.id.imageView4_info_book);
        textView2 = (TextView) findViewById(R.id.textView3_info_book);
        // Boton perfil
        image3 = (ImageView) findViewById(R.id.imageView5_info_book);
        textView3 = (TextView) findViewById(R.id.textView4_info_book);
        // img logo
        image4 = (ImageView) findViewById(R.id.imageView1_info_book);
        // Buscador
        editText1 = findViewById(R.id.editText1_info_book);
        // Título, autor, portada
        textView4 = (TextView) findViewById(R.id.textView10_infoBook);
        textView5 = (TextView) findViewById(R.id.textView12_infoBook);
        image5 = (ImageView) findViewById(R.id.imageView6_infoBook);
        // Datos evento
        textView6 = (TextView) findViewById(R.id.textView15_info_book);
        textView7 = (TextView) findViewById(R.id.textView17_infobook);
        // Boton estrella
        imageButton1 = (ImageButton) findViewById(R.id.imageButton_info_book);

        // MÉTODO ABRIR FAVS
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookActivity.this, FavoritosActivity.class);
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
                Intent intent = new Intent(InfoBookActivity.this, EventosActivity.class);
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
                Intent intent = new Intent(InfoBookActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openPerfil);
        textView3.setOnClickListener(openPerfil);

        // IR A HOME
        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(InfoBookActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });

        // BUSCADOR
        editText1.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                    String textoBusqueda = editText1.getText().toString().trim();

                    // Crear el Intent y pasar a la BuscadorActivity
                    Intent intent = new Intent(InfoBookActivity.this, BuscadorActivity.class);
                    intent.putExtra("textoBusqueda", textoBusqueda);
                    intent.putExtra("idUsuario", idUsuario);
                    startActivity(intent);
                    return true;
                }
                return false;
            }
        });

        db = new BasedeDatos(this);

        // INFORMACIÓN LIBRO
        Libro libro = db.obtenerLibro(idLibro);
        if (libro != null) {
            cargarImagenPortada(libro.getPortada(), image5);
            textView4.setText(libro.getTitulo()); // Título
            textView5.setText(libro.getAutor()); // Autor

        } else {
            Toast.makeText(this, "No se encontró información del libro", Toast.LENGTH_SHORT).show();
        }

        // INFORMACIÓN EVENTO
        idEvento = db.obtenerIdEventoMasProximo(idLibro);
        // Verificar si se encontró un evento
        if (idEvento != -1) {
            // Obtener los datos del evento utilizando su ID
            Evento evento = db.obtenerEvento(idEvento);
            if (evento != null) {
                textView6.setText(evento.getFecha()); // Fecha
                textView7.setText(evento.getHora()); // Hora
            }
        } else {
            Toast.makeText(this, "No se encontró información del evento", Toast.LENGTH_SHORT).show();
            textView6.setText("--"); // Fecha
            textView7.setText("--"); // Hora
        }

        // BOTON ACCEDER AL FORO
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

        // BOTON CREAR EVENTO
        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Crear Eventos
                Intent intent = new Intent(InfoBookActivity.this, DiscordActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                intent.putExtra("idLibro", idLibro);
                startActivity(intent);
            }
        });

        // BOTON IR AL EVENTO
        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEvento != -1) {
                    // abrir la actividad Ir a Reunion
                    Intent intent = new Intent(InfoBookActivity.this, ReunionActivity.class);
                    intent.putExtra("idUsuario", idUsuario);
                    intent.putExtra("idEvento", idEvento);
                    intent.putExtra("idLibro", idLibro);
                    startActivity(intent);
                } else {
                    Toast.makeText(InfoBookActivity.this, "No hay evento próximo", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

        // Favorito
        imageButton1.setOnClickListener(v -> {
            boolean esFavorito = db.libroFavorito(idUsuario, idLibro);
            if (esFavorito) {
                db.eliminarFavorito(idUsuario, idLibro);
                Toast.makeText(this, "Eliminado de favoritos", Toast.LENGTH_SHORT).show();
            } else {
                db.agregarFavorito(idUsuario, idLibro);
                Toast.makeText(this, "Añadido a favoritos", Toast.LENGTH_SHORT).show();
            }
            actualizarEstadoFavorito();
        });
    }

    private void actualizarEstadoFavorito() {
        boolean esFavorito = db.libroFavorito(idUsuario, idLibro);
        if (esFavorito) {
            imageButton1.setImageResource(R.drawable.estrella_amarilla);
        } else {
            imageButton1.setImageResource(R.drawable.estrella_blanca);
        }
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
