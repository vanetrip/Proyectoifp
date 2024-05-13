package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

import com.example.storyshareapp.Persistencia.BasedeDatos;
import com.example.storyshareapp.Persistencia.Usuario;


public class SignUpActivity extends AppCompatActivity {
    public EditText editText1;
    public EditText editText2;
    public EditText editText3;
    public EditText editText4;
    public EditText editText5;
    public EditText editText6;
    public Button button1;
    private Intent pasarPantalla;

    private BasedeDatos basedeDatos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        editText1 = (EditText) findViewById(R.id.editText1_SignUp);
        editText2 = (EditText) findViewById(R.id.editText2_SignUp);
        editText3 = (EditText) findViewById(R.id.editText3_SignUp);
        editText4 = (EditText) findViewById(R.id.editText4_SignUp);
        editText5 = (EditText) findViewById(R.id.editText5_SignUp);
        editText6 = (EditText) findViewById(R.id.editText6_SignUp);

        button1 = (Button) findViewById(R.id.button1_signUp);

        basedeDatos = new BasedeDatos();

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = editText1.getText().toString();
                String password = editText2.getText().toString();
                String repeatedPassword = editText3.getText().toString();
                String age = editText4.getText().toString();
                String nombreCompleto = editText5.getText().toString();
                String email = editText6.getText().toString();

                if (!password.equals(repeatedPassword)) {
                    Toast.makeText(SignUpActivity.this, "Las contraseñas no coinciden", Toast.LENGTH_SHORT).show();
                    return;
                }

                int ageInt = Integer.parseInt(age);
                if (ageInt < 18) {
                    Toast.makeText(SignUpActivity.this, "Debes ser mayor de 18 años para registrarte", Toast.LENGTH_SHORT).show();
                    return;
                }

                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.setNombreUsuario(username);
                nuevoUsuario.setContraseña(password);
                nuevoUsuario.setEmail(email);
                nuevoUsuario.setNombre(nombreCompleto);
                nuevoUsuario.setFechaNacimiento(Integer.parseInt(age));

                // Calcular la fecha de inicio del plan (hoy)
                java.util.Date fechaHoy = new java.util.Date();
                nuevoUsuario.setPlanInicio(new java.sql.Date(fechaHoy.getTime()));

                // Calcular la fecha de fin del plan (30 días después de la fecha de inicio)
                java.util.Calendar cal = java.util.Calendar.getInstance();
                cal.setTime(fechaHoy);
                cal.add(java.util.Calendar.DATE, 30); // Sumar 30 días
                java.util.Date fechaFinPlan = cal.getTime();
                nuevoUsuario.setPlanFin(new java.sql.Date(fechaFinPlan.getTime()));

                boolean usuarioInsertado = basedeDatos.insertarUsuario(nuevoUsuario);

                if (usuarioInsertado) {
                    Toast.makeText(SignUpActivity.this, "Usuario creado", Toast.LENGTH_SHORT).show();
                    pasarPantalla = new Intent(SignUpActivity.this, SignInActivity.class);
                    startActivity(pasarPantalla);
                } else {
                    Toast.makeText(SignUpActivity.this, "Error al insertar el usuario", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }}
