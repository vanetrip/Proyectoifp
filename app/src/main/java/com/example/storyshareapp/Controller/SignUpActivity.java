package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.storyshareapp.R;

public class SignUpActivity extends AppCompatActivity {
    protected TextView textView1;
    protected TextView textView2;
    protected TextView textView3;
    protected TextView textView4;
    protected TextView textView5;
    protected TextView textView6;
    protected TextView textView7;
    protected TextView textView8;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private Button button1;
    private  Button button2;
    private  Button button3;
    private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_up);

        editText1 = (EditText) findViewById(R.id.editText1_SignUp);
        editText2 = (EditText) findViewById(R.id.editText2_SignUp);
        editText3 = (EditText) findViewById(R.id.editText3_SignUp);
        editText4 = (EditText) findViewById(R.id.editText4_SignUp);
        editText5 = (EditText) findViewById(R.id.editText5_SignUp);

        button1 = (Button) findViewById(R.id.button1_signUp);
        button2 = (Button) findViewById(R.id.button2_signUp);
        button3 = (Button) findViewById(R.id.button3_signUp);

        button1.setOnClickListener(new View.OnClickListener() {
            //Boton inicio sesion
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(SignUpActivity.this, SignUpActivity.class);
                finish();
                startActivity(pasarPantalla);

            }


        });
    }}
