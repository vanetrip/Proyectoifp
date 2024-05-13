package com.example.storyshareapp.Controller;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

public class FavoritosActivity extends AppCompatActivity {
    private ImageView image1;
    private ImageView image2;
    private ImageView image3;

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
        boton1 = (Button) findViewById(R.id.button9_favoritos);
        boton2 = (Button) findViewById(R.id.button10_favoritos);
        boton3 = (Button) findViewById(R.id.button11_favoritos);
    }
}

