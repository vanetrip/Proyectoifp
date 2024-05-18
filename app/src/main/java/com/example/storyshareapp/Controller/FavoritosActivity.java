package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

public class FavoritosActivity extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private ImageView image6;
    private ImageView image7;
    private ImageView image8;
    private ImageView image9;
    private ImageView image10;
    private ImageView image11;
    private ImageView image12;

    private Button boton1;
    private Button boton2;
    private Button boton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_favoritos);
        image1 = (ImageView) findViewById(R.id.imageView18_favoritos);
        image2 = (ImageView) findViewById(R.id.imageView7_favoritos);
        image3 = (ImageView) findViewById(R.id.imageView8_favoritos);
        image4 = (ImageView) findViewById(R.id.imageView9_favoritos);
        image5 = (ImageView) findViewById(R.id.imageView10_favoritos);
        image6 = (ImageView) findViewById(R.id.imageView11_favoritos);
        image7 = (ImageView) findViewById(R.id.imageView12_favoritos);
        image8 = (ImageView) findViewById(R.id.imageView13_favoritos);
        image9 = (ImageView) findViewById(R.id.imageView14_favoritos);
        image10 = (ImageView) findViewById(R.id.imageView15_favoritos);
        image11 = (ImageView) findViewById(R.id.imageView16_favoritos);
        image12 = (ImageView) findViewById(R.id.imageView17_favoritos);
        boton1 = (Button) findViewById(R.id.button9_favoritos);
        boton2 = (Button) findViewById(R.id.button10_favoritos);
        boton3 = (Button) findViewById(R.id.button11_favoritos);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favoritos
                Intent intent = new Intent(FavoritosActivity.this, FavoritosActivity.class);
                startActivity(intent);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Eventos
                Intent intent = new Intent(FavoritosActivity.this, EventosActivity.class);
                startActivity(intent);
            }
        });
        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Perfil
                Intent intent = new Intent(FavoritosActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
        image12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para ir a la info del libro
                Intent intent = new Intent(FavoritosActivity.this, InfoBook.class);
                startActivity(intent);
            }
        });
    }
}

