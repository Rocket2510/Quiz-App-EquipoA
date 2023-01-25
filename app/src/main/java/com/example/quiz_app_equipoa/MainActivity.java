package com.example.quiz_app_equipoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Comentario en el main activity.
        //Otro comentario.

    }

    //Metodo para acceder a la pantalla de inicio (En lo que programamos la validacion)
    public void IniciarSesion (View v){
        Intent i = new Intent(this, Pantalla_Inicio.class);
        startActivity(i);
    }
}