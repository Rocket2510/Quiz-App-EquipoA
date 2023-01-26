package com.example.quiz_app_equipoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.quiz_app_equipoa.R;

public class Resultados_m1 extends AppCompatActivity {
    int calificacion = 0;
    int d1, d2, d3, d4, d5;
    Bundle bundle1, bundle2;
    TextView txt1_3, txt_R1, txt_R2, txt_R3, txt_R4, txt_R5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_m1);

        txt1_3 = findViewById(R.id.txt1_3);

        txt_R1 = findViewById(R.id.txt_R1);
        txt_R2 = findViewById(R.id.txt_R2);
        txt_R3 = findViewById(R.id.txt_R3);
        txt_R4 = findViewById(R.id.txt_R4);
        txt_R5 = findViewById(R.id.txt_R5);

        bundle1 = getIntent().getExtras();
        calificacion = bundle1.getInt("calificacion");

        // muestra el puntaje obtenido
        txt1_3.setText("" + calificacion);

        // muestra que respuesta fue correctas o incorrectas

        //r1
        Intent recibir_r1 = this.getIntent();
        d1 = recibir_r1.getIntExtra("respuesta1", -1);

        if (d1 == 1) {
            txt_R1.setText("CORRECTA");
        }else{
            txt_R1.setText("INCORRECTA");
        }

        //r2
        Intent recibir_r2 = this.getIntent();
        d2 = recibir_r2.getIntExtra("respuesta2", -1);

        if (d2 == 1) {
            txt_R2.setText("CORRECTA");
        }else{
            txt_R2.setText("INCORRECTA");
        }

        //r3
        Intent recibir_r3 = this.getIntent();
        d3= recibir_r3.getIntExtra("respuesta3", -1);

        if (d3 == 1) {
            txt_R3.setText("CORRECTA");
        }else{
            txt_R3.setText("INCORRECTA");
        }

        //r4
        Intent recibir_r4 = this.getIntent();
        d4 = recibir_r4.getIntExtra("respuesta4", -1);

        if (d4 == 1) {
            txt_R4.setText("CORRECTA");
        }else{
            txt_R4.setText("INCORRECTA");
        }

        //r5
        Intent recibir_r5 = this.getIntent();
        d5 = recibir_r5.getIntExtra("respuesta5", -1);

        if (d5 == 1) {
            txt_R5.setText("CORRECTA");
        }else{
            txt_R5.setText("INCORRECTA");
        }
    }
}