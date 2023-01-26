package com.example.quiz_app_equipoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quiz_app_equipoa.R;

public class Pregunta_1_m1 extends AppCompatActivity {
    private int calificacion=0, respuesta1=0;
    private RadioGroup opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta1_m1);

        opciones = findViewById(R.id.radioGroup);
    }

    public void btn_Enviar1(View sender){
        int idElegido = opciones.getCheckedRadioButtonId();
        switch (idElegido){
            case R.id.rb1_A:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 1", '1').show();

                break;

            case R.id.rb1_B:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 2", '1').show();

                break;

            case R.id.rb1_C:
                calificacion+=2;
                respuesta1++;
                Toast.makeText(this, "Elegiste la opción 3", '1').show();

                break;

            case R.id.rb1_D:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 4", '1').show();
                break;
            }

            Intent siquiente1 = new Intent(this, Pregunta_1_m1.class);
            siquiente1.putExtra("calificacion", calificacion);
            siquiente1.putExtra("respuesta1", respuesta1);
            startActivity(siquiente1);
    }
}