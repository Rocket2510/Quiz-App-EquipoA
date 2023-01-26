package com.example.quiz_app_equipoa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz_app_equipoa.R;

public class Pregunta_4_m1 extends AppCompatActivity {
    int calificacion= 0;
    int d1, d2, d3;
    Bundle bundle1, bundle2;
    RadioGroup opciones;
    TextView rb1, rb2, rb3, rb4, pregunta;
    Button siguiente;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta4_m1);
        IncializarComponentes();

        opciones = findViewById(R.id.radioGroup);
        bundle1 = getIntent().getExtras();
        calificacion = bundle1.getInt("calificacion");

        Intent recibir_r1 = this.getIntent();
        d1 = recibir_r1.getIntExtra("respuesta1",-1);

        Intent recibir_r2 = this.getIntent();
        d2 = recibir_r2.getIntExtra("respuesta2",-1);

        Intent recibir_r3 = this.getIntent();
        d3 = recibir_r1.getIntExtra("respuesta3",-1);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        Pref_Fuente();
        super.onResume();
    }

    //Metodo para cambiar a las Preferencias de Fuente
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Pref_Fuente(){
        String fuente = prefs.getString("reply_Fuente", "Roboto");

        switch (fuente){
            case "Roboto":
                Typeface Roboto = getResources().getFont(R.font.roboto);
                pregunta.setTypeface(Roboto);
                rb1.setTypeface(Roboto);
                rb3.setTypeface(Roboto);
                rb4.setTypeface(Roboto);
                rb4.setTypeface(Roboto);
                siguiente.setTypeface(Roboto);break;
            case "Monserrat":
                Typeface mon = getResources().getFont(R.font.montserrat);
                pregunta.setTypeface(mon);
                rb1.setTypeface(mon);
                rb2.setTypeface(mon);
                rb3.setTypeface(mon);
                rb4.setTypeface(mon);
                siguiente.setTypeface(mon);break;
            case "Play":
                Typeface play = getResources().getFont(R.font.play);
                pregunta.setTypeface(play);
                rb1.setTypeface(play);
                rb2.setTypeface(play);
                rb3.setTypeface(play);
                rb4.setTypeface(play);
                siguiente.setTypeface(play);break;
        }
    }

    public void IncializarComponentes(){
        //leer preferencias del usuario
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        pregunta = findViewById(R.id.txt_4_m1);
        rb1 = findViewById(R.id.rb4_A_m1);
        rb2 = findViewById(R.id.rb4_B_m1);
        rb3 = findViewById(R.id.rb4_C_m1);
        rb4 = findViewById(R.id.rb4_D_m1);
        siguiente = findViewById(R.id.button4);

    }

    public void btn_Enviar4 (View v){
        int respuesta1 = d1;
        int respuesta2 = d2;
        int respuesta3 = d3;
        int respuesta4=0;
        int idElegido = opciones.getCheckedRadioButtonId();
        switch (idElegido){
            case R.id.rb4_A_m1:
                calificacion+=2;
                respuesta4++;
                Toast.makeText(this, "Elegiste la opción 1", '1').show();
                break;

            case R.id.rb4_B_m1:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 2", '1').show();
                break;

            case R.id.rb4_C_m1:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 3", '1').show();
                break;

            case R.id.rb4_D_m1:
                calificacion+=0;
                Toast.makeText(this, "Elegiste la opción 4", '1').show();
                break;
        }

        Intent siquiente4 = new Intent(this, Pregunta_5_m1.class);
        siquiente4.putExtra("calificacion", calificacion);
        siquiente4.putExtra("respuesta1", respuesta1);
        siquiente4.putExtra("respuesta2", respuesta2);
        siquiente4.putExtra("respuesta3", respuesta3);
        siquiente4.putExtra("respuesta4", respuesta4);

        startActivity(siquiente4);
    }

}