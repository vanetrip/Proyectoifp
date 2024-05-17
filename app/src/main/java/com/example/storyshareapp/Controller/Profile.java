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
import com.example.storyshareapp.R;

public class Profile extends AppCompatActivity {

    //Declaramos variables
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;

    private Button button1;
    private Button button2;

    private ImageView image1;
    private SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;
        Intent intent = getIntent();
        int idUsuario = intent.getIntExtra("idUsuario", -1); // -1 es un valor predeterminado en caso de que no se encuentre el extra

        // se instancian
        editText2 = (EditText) findViewById(R.id.caja_text2_profile);
        editText3 = (EditText) findViewById(R.id.caja_text3_profile);
        editText4 = (EditText) findViewById(R.id.caja_text4_profile);
        editText5= (EditText) findViewById(R.id.caja_text5_profile);
        editText6= (EditText) findViewById(R.id.caja_text6_profile);
        button2= (Button) findViewById(R.id.button10a_profile);
        button1= (Button) findViewById(R.id.button11a_profile);
        image1  = (ImageView) findViewById(R.id.imageView6_profile);

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editText2.setText(sharedPreferences.getString("editText2", ""));
        editText3.setText(sharedPreferences.getString("editText3", ""));
        editText4.setText(sharedPreferences.getString("editText4", ""));
        editText5.setText(sharedPreferences.getString("editText5", ""));
        editText6.setText(sharedPreferences.getString("editText6", ""));

        // Guarda automáticamente el texto ingresado en editText1 en el SharedPreferences
        // cada vez que el texto cambia
        editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("editText2", editText2.getText().toString());
                editor.apply();
            }
        });
        editText3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("editText3", editText3.getText().toString());
                editor.apply();
            }
        });
        editText4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("editText4", editText4.getText().toString());
                editor.apply();
            }
        });
        editText5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("editText5", editText5.getText().toString());
                editor.apply();
            }
        });
        editText6.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("editText6", editText6.getText().toString());
                editor.apply();
            }
        });

        // Configurar el Listener del botón Guardar
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Verificar si los campos están vacíos
                if (editText2.getText().toString().isEmpty() ||
                        editText3.getText().toString().isEmpty() ||
                        editText4.getText().toString().isEmpty() ||
                        editText5.getText().toString().isEmpty() ||
                        editText6.getText().toString().isEmpty()) {
                    // Mostrar un mensaje al usuario indicando que debe completar todos los campos
                    Toast.makeText(Profile.this, "Por favor, complete todos los campos antes de guardar", Toast.LENGTH_SHORT).show();
                } else {
                    // Guardar todo lo escrito en SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("editText2", editText2.getText().toString());
                    editor.putString("editText3", editText3.getText().toString());
                    editor.putString("editText4", editText4.getText().toString());
                    editor.putString("editText5", editText5.getText().toString());
                    editor.putString("editText6", editText6.getText().toString());
                    editor.apply();

                    // Actualizar los datos en la base de datos
                    // Inicializar BasedeDatos
                    BasedeDatos basedeDatos = new BasedeDatos(Profile.this);
                    // Obtener instancia de SQLiteDatabase
                    SQLiteDatabase db = basedeDatos.getWritableDatabase();

                    // Actualizar los datos en la base de datos
                    basedeDatos.updateUsuario(
                            idUsuario,
                            editText2.getText().toString(),
                            editText5.getText().toString(),
                            editText4.getText().toString(),
                            Integer.parseInt(editText3.getText().toString())
                    );
                    Toast.makeText(Profile.this, "Datos actualizados correctamente", Toast.LENGTH_SHORT).show();
                    // Cambiar a la pantalla HomeActivity
                    Intent intent = new Intent(Profile.this, HomeActivity.class);
                    startActivity(intent);
                    finish(); // Finalizar la actividad actual si no deseas volver a ella con el botón de retroceso
                }
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cancelar lo escrito en los TextViews
                //editText2.setText("");
                // editText3.setText("");
                //editText4.setText("");
                //editText5.setText("");
                //vanessaeditText6.setText("");
                // Cambiar a la pantalla HomeActivity
                intent.putExtra("idUsuario", idUsuario); // Mantener el ID de usuario
                Intent intent = new Intent(Profile.this, HomeActivity.class);

                startActivity(intent);
                finish(); // Finalizar la actividad
            }
        });}}