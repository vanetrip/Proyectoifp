package com.example.storyshareapp.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.storyshareapp.R;

public class SignInActivity extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private Button button1;
    private  Button button2;
    private  Button button3;
    private  Button button4;
    protected TextView textView1;
    protected TextView textView2;
    protected TextView textView3;
    protected TextView textView4;
    protected TextView textView5;
    protected TextView textView6;
    private Intent pasarPantalla;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);

        editText1 = (EditText) findViewById(R.id.editText1_signIn);
        editText2 = (EditText) findViewById(R.id.editText2_signIn);
        button1 = (Button) findViewById(R.id.button1_signIn);
        button2 = (Button) findViewById(R.id.button2_signIn);
        button3 = (Button) findViewById(R.id.button3_signIn);
        button4 = (Button) findViewById(R.id.button4_signIn);

        button1.setOnClickListener(new View.OnClickListener() {
            //Boton inicio sesion
            @Override
            public void onClick(View v) {
                pasarPantalla = new Intent(SignInActivity.this, SignUpActivity.class);
                finish();
                startActivity(pasarPantalla);

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