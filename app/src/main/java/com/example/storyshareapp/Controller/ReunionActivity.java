package com.example.storyshareapp.Controller;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

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
    private int idUsuario;
    private int idLibro;

    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reunion);

        // OBTENER IDUSUARIO
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1);
        System.out.println("idUsuario "+idUsuario);

        //OBTENER IDLIBRO
        idLibro = intent.getIntExtra("idLibro", -1);
        System.out.println("idLibro "+idLibro);

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
        textView4 = (TextView) findViewById(R.id.textView6_reunion);
        //Texto dia
        textView5 = (TextView) findViewById(R.id.textView9_reunion);
        //Texto hora
        textView6 = (TextView) findViewById(R.id.textView11_reunion);


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

    }
}
