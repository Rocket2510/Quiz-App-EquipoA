package com.example.quiz_app_equipoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quiz_app_equipoa.R;

public class Pregunta_3_m1 extends AppCompatActivity {
    int d1, d2;
    int calificacion= 0;
    Bundle bundle1, bundle2;
    RadioGroup opciones;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3_m1);

        opciones = findViewById(R.id.radioGroup);
        bundle1 = getIntent().getExtras();
        calificacion = bundle1.getInt("calificacion");

        Intent recibir_r1 = this.getIntent();
        d1 = recibir_r1.getIntExtra("respuesta1",-1);

        Intent recibir_r2 = this.getIntent();
        d2 = recibir_r2.getIntExtra("respuesta2",-1);
    }

    public void btn_Enviar3 (View v){
        int respuesta1 = d1;
        int respuesta2 = d2;
        int respuesta3=0;
        int idElegido = opciones.getCheckedRadioButtonId();
        switch (idElegido){
            case R.id.rb3_A:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 1", '1').show();
                break;

            case R.id.rb3_B:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 2", '1').show();
                break;

            case R.id.rb3_C:
                calificacion+=2;
                respuesta3++;
                Toast.makeText(this, "Elegiste la opción 3", '1').show();
                break;

            case R.id.rb3_D:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 4", '1').show();
                break;
        }

        Intent siquiente3 = new Intent(this, Pregunta_4_m1.class);
        siquiente3.putExtra("calificacion", calificacion);
        siquiente3.putExtra("respuesta1", respuesta1);
        siquiente3.putExtra("respuesta2", respuesta2);
        siquiente3.putExtra("respuesta3", respuesta3);

        startActivity(siquiente3);
    }
}