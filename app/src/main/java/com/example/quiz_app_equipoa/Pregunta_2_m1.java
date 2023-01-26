package com.example.quiz_app_equipoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.quiz_app_equipoa.R;

public class Pregunta_2_m1 extends AppCompatActivity {
    int calificacion= 0;
    int d1;
    RadioGroup opciones;
    Bundle bundle1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta2_m1);

        opciones = findViewById(R.id.radioGroup);
        bundle1 = getIntent().getExtras();
        calificacion = bundle1.getInt("calificacion");

        Intent recibir_r1 = this.getIntent();
        d1 = recibir_r1.getIntExtra("respuesta1",-1);
    }

    public void Btn_Enviar2(View v){

        int respuesta1= d1;
        int respuesta2=0;
        int idElegido = opciones.getCheckedRadioButtonId();

        switch (idElegido){
            case R.id.rb2_A:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 1", '1').show();
                break;

            case R.id.rb2_B:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 2", '1').show();
                break;

            case R.id.rb2_C:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 3", '1').show();
                break;

            case R.id.rb2_D:
                calificacion+=2;
                respuesta2++;
                Toast.makeText(this, "Elegiste la opción 4", '1').show();
                break;
        }

        Intent siquiente2 = new Intent(this, Pregunta_3_m1.class);
        siquiente2.putExtra("calificacion", calificacion);
        siquiente2.putExtra("respuesta1", respuesta1);
        siquiente2.putExtra("respuesta2", respuesta2);
        startActivity(siquiente2);
    }
}