package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Libro;
import com.example.storyshareapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    private ImageView image1;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image10;
    private ImageView image11;
    private ImageView image12;
    private ImageView image13;
    private ImageView image14;
    private ImageView image15;
    private ImageView image16;
    private ImageView image17;
    private ImageView image18;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    private Button button1;
    private Button button2;
    private BasedeDatos basedeDatos;
    private int idUsuario; // Variable para almacenar el idUsuario


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Imagen Storyshare
        image1 = (ImageView) findViewById(R.id.imageView1_home);
        // Imagenfavs
        image3 = findViewById(R.id.imageView3_home);
        textView2 = findViewById(R.id.textView2_home);
        //Imageneventos
        image4 = (ImageView) findViewById(R.id.imageView4_home);
        textView3 = (TextView) findViewById(R.id.textView3_home);
        //Imagenperfil
        image5 = (ImageView) findViewById(R.id.imageView5_home);
        textView4 = (TextView) findViewById(R.id.textView4_home);

        textView5 = (TextView) findViewById(R.id.textView_cerrarsesion);
        button1 = (Button) findViewById(R.id.button1_home);
        button2 = (Button) findViewById(R.id.button30_home);

        image10 = findViewById(R.id.imageView10_Home);
        image11 = findViewById(R.id.imageView11_home);
        image12 = findViewById(R.id.imageView12_home);
        image13 = findViewById(R.id.imageView13_home);
        image14 = findViewById(R.id.imageView14_home);
        image15 = findViewById(R.id.imageView15_home);
        image16 = findViewById(R.id.imageView16_home);
        image17 = findViewById(R.id.imageView17_home);
        image18 = findViewById(R.id.imageView18_home);

        basedeDatos = new BasedeDatos(this);

        // Obtener el idUsuario del Intent que inició esta actividad
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1); // -1 es un valor predeterminado en caso de que no se encuentre el extra
        System.out.println("idUsuario " + idUsuario);

        textView5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, SignInActivity.class);
                intent.putExtra("idUsuario", -1);
                startActivity(intent);
            }
        });

        // MÉTODO ABRIR FAVS
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openFavoritos);
        textView2.setOnClickListener(openFavoritos);
        // IR A HOME
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });
        // MÉTODO ABRIR EVENTOS
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, EventosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image4.setOnClickListener(openEventos);
        textView3.setOnClickListener(openEventos);
        // MÉTODO ABRIR PERFIL
        View.OnClickListener openPerfil = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image5.setOnClickListener(openPerfil);
        textView4.setOnClickListener(openPerfil);


        // Obtener los IDs de los foros más populares
        List<Integer> idForosPopulares = basedeDatos.obtenerIdForosPopulares();
        System.out.println("Idsforospopulares " + idForosPopulares);

        // Obtener los tres foros más populares y mostrar la portada de sus libros asociados
        for (int i = 0; i < idForosPopulares.size() && i < 3; i++) {
            int idForo = idForosPopulares.get(i);
            System.out.println("idForo " + idForo);
            int idLibro = basedeDatos.obtenerIdLibroPorIdForo(idForo);
            System.out.println("idLibro " + idLibro);
            if (idLibro != -1) {
                Libro libro = basedeDatos.obtenerLibro(idLibro);
                if (libro != null) {
                    System.out.println("Portada del libro " + libro.getTitulo() + ": " + libro.getPortada());
                    // Cargar la portada del libro en la imagen correspondiente
                    switch (i) {
                        case 0:
                            cargarImagenPortada(libro.getPortada(), image10, idLibro);
                            image10.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                        case 1:
                            cargarImagenPortada(libro.getPortada(), image11, idLibro);
                            image11.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                        case 2:
                            cargarImagenPortada(libro.getPortada(), image12, idLibro);
                            image12.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                    }
                }
            }
        }
        // Obtener los IDs de los próximos eventos
        List<Integer> idEventosMasRecientes = (List<Integer>) basedeDatos.obtenerIdeventosMasRecientes();

        // Obtener los tres eventos más recientes y mostrar la portada de sus libros asociados
        for (int i = 0; i < idEventosMasRecientes.size() && i < 3; i++) {
            int idEvento = idEventosMasRecientes.get(i);
            Log.d("HomeActivity", "idEvento: " + idEvento);
            int idLibro = basedeDatos.obtenerIdLibroPorIdevento(idEvento);
            Log.d("HomeActivity", "idLibro: " + idLibro);
            if (idLibro != -1) {
                Libro libro = basedeDatos.obtenerLibro(idLibro);
                if (libro != null) {
                    Log.d("HomeActivity", "Portada del libro " + libro.getTitulo() + ": " + libro.getPortada());
                    // Cargar la portada del libro en la imagen correspondiente
                    switch (i) {
                        case 0:
                            cargarImagenPortada(libro.getPortada(), image13,idLibro);
                            image13.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                        case 1:
                            cargarImagenPortada(libro.getPortada(), image14, idLibro);
                            image14.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                        case 2:
                            cargarImagenPortada(libro.getPortada(), image15, idLibro);
                            image15.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                    }
                }
            }
        }

        // Obtener los IDs de los foros abiertos recientemente
        List<Integer> IdForosrecientes = basedeDatos.obtenerIdForosrecientes();
        System.out.println("IdForosrecientes "+IdForosrecientes);

        // Obtener los tres eventos más recientes y mostrar la portada de sus libros asociados
        for (int i = 0; i < IdForosrecientes.size() && i < 3; i++) {
            int idEvento = IdForosrecientes.get(i);
            Log.d("HomeActivity", "idEvento: " + idEvento);
            int idLibro = basedeDatos.obtenerIdLibroPorIdevento(idEvento);
            Log.d("HomeActivity", "idLibro: " + idLibro);
            if (idLibro != -1) {
                Libro libro = basedeDatos.obtenerLibro(idLibro);
                if (libro != null) {
                    Log.d("HomeActivity", "Portada del libro " + libro.getTitulo() + ": " + libro.getPortada());
                    // Cargar la portada del libro en la imagen correspondiente
                    switch (i) {
                        case 0:
                            cargarImagenPortada(libro.getPortada(), image16, idLibro);
                            image16.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                        case 1:
                            cargarImagenPortada(libro.getPortada(), image17, idLibro);
                            image17.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                        case 2:
                            cargarImagenPortada(libro.getPortada(), image18, idLibro);
                            image18.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    abrirInfoBookActivity(idLibro);
                                }
                            });
                            break;
                    }
                }
            }
        }
    }

    private void cargarImagenPortada(String urlPortada, ImageView imageView, int idLibro) {
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
                                    Toast.makeText(HomeActivity.this, "Error al cargar la imagen", Toast.LENGTH_SHORT).show();
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
                    Toast.makeText(HomeActivity.this, "URL de portada no válida", Toast.LENGTH_SHORT).show();
                }
            });
        }
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://magali-martinez.gitbook.io/storyshare";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://magali-martinez.gitbook.io/storyshare/group-1/faqs-preguntas-frecuentes";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    // Método para abrir InfoBookActivity con el id del libro como extra
    private void abrirInfoBookActivity(int idLibro) {
        Intent intent = new Intent(HomeActivity.this, InfoBookActivity.class);
        intent.putExtra("idLibro", idLibro);
        intent.putExtra("idUsuario", idUsuario);
        startActivity(intent);

    }
}



