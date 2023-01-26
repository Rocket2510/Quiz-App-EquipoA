package com.example.quiz_app_equipoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quiz_app_equipoa.R;

public class Pregunta_5_m1 extends AppCompatActivity {
    int d1,d2,d3,d4;
    int calificacion = 0;
    Bundle bundle1, bundle2;
    RadioGroup opciones;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta5_m1);

        opciones = findViewById(R.id.radioGroup);
        bundle1 = getIntent().getExtras();
        calificacion = bundle1.getInt("calificacion");

        Intent recibir_r1 = this.getIntent();
        d1 = recibir_r1.getIntExtra("respuesta1",-1);

        Intent recibir_r2 = this.getIntent();
        d2 = recibir_r2.getIntExtra("respuesta2",-1);

        Intent recibir_r3 = this.getIntent();
        d3 = recibir_r1.getIntExtra("respuesta3",-1);

        Intent recibir_r4 = this.getIntent();
        d4 = recibir_r4.getIntExtra("respuesta4",-1);
    }

    public void btn_Enviar5 (View v){
        int respuesta1 = d1;
        int respuesta2 = d2;
        int respuesta3 = d3;
        int respuesta4 = d4;
        int respuesta5 = 0;
        int idElegido = opciones.getCheckedRadioButtonId();
        switch (idElegido){
            case R.id.rb5_A:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 1", '1').show();
                break;

            case R.id.rb5_B:
                calificacion+=2;
                respuesta5++;
                Toast.makeText(this, "Elegiste la opción 2", '1').show();
                break;

            case R.id.rb5_C:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 3", '1').show();
                break;

            case R.id.rb5_D:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 4", '1').show();
                break;
        }

        Intent resultado = new Intent(this, Resultados_m1.class);
        resultado.putExtra("calificacion", calificacion);
        resultado.putExtra("respuesta1", respuesta1);
        resultado.putExtra("respuesta2", respuesta2);
        resultado.putExtra("respuesta3", respuesta3);
        resultado.putExtra("respuesta4", respuesta4);
        resultado.putExtra("respuesta5", respuesta5);

        startActivity(resultado);
    }
}