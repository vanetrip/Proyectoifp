package com.example.storyshareapp.Controller;

import static com.example.storyshareapp.Persistencia.BasedeDatos.*;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Model.Eventos;
import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Usuario;
import com.example.storyshareapp.R;

public class ProfileActivity extends AppCompatActivity {

    //Declaramos variables
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;

    private Button button1;
    private Button button2;

    private ImageView image1;
    private ImageView image3;
    private ImageView image4;
    private ImageView image5;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private int idUsuario;
    private BasedeDatos basedeDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Inicializar la base de datos
        basedeDatos = new BasedeDatos(ProfileActivity.this);
        // Obtener el ID de usuario de los extras del intent
        Intent intent = getIntent();
        idUsuario = intent.getIntExtra("idUsuario", -1);

        // Buscar vistas
        editText2 = findViewById(R.id.caja_text2_profile);
        editText3 = findViewById(R.id.caja_text3_profile);
        editText4 = findViewById(R.id.caja_text4_profile);
        editText5 = findViewById(R.id.caja_text5_profile);
        editText6 = findViewById(R.id.caja_text6_profile);
        button1 = findViewById(R.id.button11a_profile);
        button2 = findViewById(R.id.button10a_profile);
        image1 = findViewById(R.id.imageView6_profile);

        // Imagenfavs
        image3 = (ImageView) findViewById(R.id.imageView3_profile);
        textView2 = (TextView) findViewById(R.id.textView2_profile);
        //Imageneventos
        image4 = (ImageView) findViewById(R.id.imageView4_profile);
        textView3 = (TextView) findViewById(R.id.textView3_profile);
        //Imagenperfil
        image5 = (ImageView) findViewById(R.id.imageView5_profile);
        textView4 = (TextView) findViewById(R.id.textView4_profile);
        // Imagen Storyshare
        image1 = (ImageView) findViewById(R.id.imageView1_profile);

        // Cargar información del usuario
        cargarInformacionUsuario();

        // Imagenfavs
        image3 = (ImageView) findViewById(R.id.imageView3_profile);
        textView2 = (TextView) findViewById(R.id.textView2_profile);
        //Imageneventos
        image4 = (ImageView) findViewById(R.id.imageView4_profile);
        textView3 = (TextView) findViewById(R.id.textView3_profile);
        //Imagenperfil
        image5 = (ImageView) findViewById(R.id.imageView5_profile);
        textView4 = (TextView) findViewById(R.id.textView3_profile);
        // Imagen Storyshare
        image1 = (ImageView) findViewById(R.id.imageView1_profile);

        // MÉTODO ABRIR FAVS
        View.OnClickListener openFavoritos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, FavoritosActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image3.setOnClickListener(openFavoritos);
        textView2.setOnClickListener(openFavoritos);


        // MÉTODO ABRIR EVENTOS
        View.OnClickListener openEventos = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, EventosActivity.class);
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
                Intent intent = new Intent(ProfileActivity.this, ProfileActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        };

        image5.setOnClickListener(openPerfil);
        textView4.setOnClickListener(openPerfil);

        // IR A HOME
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario);
                startActivity(intent);
            }
        });

        // Configurar Listener del botón Guardar
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Actualizar datos del usuario en la base de datos y en las vistas
                actualizarUsuario();
            }
        });

        // Configurar Listener del botón Cancelar
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Regresar a la pantalla HomeActivity
                Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
                intent.putExtra("idUsuario", idUsuario); // Mantener el ID de usuario
                startActivity(intent);
                finish(); // Finalizar la actividad
            }
        });
    }

    private void cargarInformacionUsuario() {
        // Obtener información del usuario desde la base de datos
        Usuario usuario = basedeDatos.obtenerUsuario(idUsuario);

        // Mostrar la información del usuario en las vistas
        if (usuario != null) {
            editText2.setText(usuario.getNombreUsuario());
            editText3.setText(String.valueOf(usuario.getEdad()));
            editText4.setText(usuario.getNombre());
            editText5.setText(usuario.getEmail());
            // No se muestra la contraseña en un EditText por motivos de seguridad
            // editText6.setText(usuario.getContraseña());
        }
    }

    private void actualizarUsuario() {
        // Obtener los nuevos datos del usuario desde las vistas
        String nuevoUsername = editText2.getText().toString();
        String nuevaContraseña = editText6.getText().toString(); // No se recomienda mostrar la contraseña en un EditText
        String nuevoNombreCompleto = editText4.getText().toString();
        int nuevaEdad = Integer.parseInt(editText3.getText().toString());

        // Actualizar los datos del usuario en la base de datos
        basedeDatos.updateUsuario(idUsuario, nuevoUsername, nuevaContraseña, nuevoNombreCompleto, nuevaEdad);

        // Mostrar mensaje de éxito
        Toast.makeText(ProfileActivity.this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();

        // Cambiar a la pantalla HomeActivity
        Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
        intent.putExtra("idUsuario", idUsuario); // Mantener el ID de usuario
        startActivity(intent);
        finish(); // Finalizar la actividad
    }
}