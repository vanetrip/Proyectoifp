package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.Model.Eventos;
import com.example.storyshareapp.R;

public class Profile extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private Button button1;
    private Button button2;

    private ImageView image1;
    private ImageView image2;
    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        SharedPreferences sharedPreferences;
        SharedPreferences.Editor editor;

    editText1 = (EditText) findViewById(R.id.caja_text2_profile);
    editText2 = (EditText) findViewById(R.id.caja_text3_profile);
    editText3 = (EditText) findViewById(R.id.caja_text4_profile);
    editText4= (EditText) findViewById(R.id.caja_text5_profile);
    editText5= (EditText) findViewById(R.id.caja_text6_profile);

    button1= (Button) findViewById(R.id.button1_profile);
    button2= (Button) findViewById(R.id.button2_profile);

    image1 = (ImageView) findViewById(R.id.imageView3_profile);
    image2 = (ImageView) findViewById(R.id.imageView4_profile);

    textView1 = (TextView) findViewById(R.id.textView5_eventos);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Favorito
                Intent intent = new Intent(Profile.this, HomeActivity.class);
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Lógica para abrir la actividad Calendario
                Intent intent = new Intent(Profile.this, Eventos.class);
                startActivity(intent);
            }
        });

        sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        editText1.setText(sharedPreferences.getString("editText1", ""));
        editText2.setText(sharedPreferences.getString("editText2", ""));
        editText3.setText(sharedPreferences.getString("editText3", ""));
        editText4.setText(sharedPreferences.getString("editText4", ""));
        editText5.setText(sharedPreferences.getString("editText5", ""));
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                editor.putString("editText1", editText1.getText().toString());
                editor.apply();
            }
        });

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

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Cancelar lo escrito en los TextViews
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guardar todo lo escrito en SharedPreferences
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("editText1", editText1.getText().toString());
                editor.putString("editText2", editText2.getText().toString());
                editor.putString("editText3", editText3.getText().toString());
                editor.putString("editText4", editText4.getText().toString());
                editor.putString("editText5", editText5.getText().toString());
                editor.apply();
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Eliminar la cuenta
                // Aquí puedes agregar la lógica para eliminar la cuenta del usuario, por ejemplo,
                // cerrar sesión y borrar todos los datos asociados a la cuenta.
            }
        });








    }
}