package com.example.storyshareapp;

import org.junit.Test;

import static org.junit.Assert.*;

import static org.mockito.Mockito.*;

import android.content.Context;
import android.widget.EditText;

import com.example.storyshareapp.Controller.SignUpActivity;
import com.example.storyshareapp.Persistencia.BasedeDatos;

import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

@RunWith(MockitoJUnitRunner.class)
public class AuthenticationUnitTest {

    @Mock
    Context mockContext;

    @Mock
    EditText mockUsernameEditText;

    @Mock
    EditText mockPasswordEditText;

    @Test
    public void testInvalidCredentials() {
        when(mockUsernameEditText.getText().toString()).thenReturn("username");
        when(mockPasswordEditText.getText().toString()).thenReturn("password");

        assertFalse(BasedeDatos.verificarCredenciales("username", "password"));
    }

    @Test
    public void testValidUserCreation() {
        SignUpActivity signUpActivity = new SignUpActivity();
        signUpActivity.onCreate(null);

        signUpActivity.editText1.setText("newUser");
        signUpActivity.editText2.setText("password");
        signUpActivity.editText3.setText("password");
        signUpActivity.editText4.setText("20");
        signUpActivity.editText5.setText("Full Name");
        signUpActivity.editText6.setText("email@example.com");

        signUpActivity.button1.performClick();

        // verificar si la base de datos tiene el nuevo usuario creado
    }

    @Test
    public void testUnderageUserCreation() {
        SignUpActivity signUpActivity = new SignUpActivity();
        signUpActivity.onCreate(null);

        signUpActivity.editText1.setText("underageUser");
        signUpActivity.editText2.setText("password");
        signUpActivity.editText3.setText("password");
        signUpActivity.editText4.setText("15"); // Menor de 18 años
        signUpActivity.editText5.setText("Full Name");
        signUpActivity.editText6.setText("email@example.com");

        signUpActivity.button1.performClick();

        // verificar si se mostró un mensaje de error adecuado
    }
}