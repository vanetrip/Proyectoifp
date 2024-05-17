package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

import com.example.storyshareapp.Persistencia.BasedeDatos;

public class SignInActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button button1;
    private  Button button4;
    private Intent pasarPantalla;

    private BasedeDatos basedeDatos;
    private SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        // Inicializar BasedeDatos
        BasedeDatos basedeDatos = new BasedeDatos(this);
        // Obtener instancia de SQLiteDatabase
        db = basedeDatos.getWritableDatabase();
        basedeDatos.eliminarBaseDeDatos();

        editText1 = findViewById(R.id.editText1_signIn);
        editText2 = findViewById(R.id.editText2_signIn);
        button1 = findViewById(R.id.button1_signIn);
        button4 = findViewById(R.id.button4_signIn);

        editText2.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);

        // Inicio sesión
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();

                boolean credencialesCorrectas = BasedeDatos.verificarCredenciales(db, username, password);

                if (credencialesCorrectas) {
                    int idUsuario = BasedeDatos.obtenerId(db, username);
                    Toast.makeText(SignInActivity.this, "Sesión iniciada", Toast.LENGTH_SHORT).show();
                    pasarPantalla = new Intent(SignInActivity.this, HomeActivity.class);
                    // AQUI OS PASO EL ID PARA LA PANTALLA DEL HOME
                    pasarPantalla.putExtra("idUsuario", idUsuario); // Pasa el ID del usuario como un extra
                    startActivity(pasarPantalla);
                } else {
                    Toast.makeText(SignInActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            //Boton Registarse
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(SignInActivity.this, SignUpActivity.class);
                finish();
                startActivity(pasarPantalla);
            }
        });
    }}