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

public class Pregunta_3_m1 extends AppCompatActivity {
    int d1, d2;
    int calificacion= 0;
    Bundle bundle1, bundle2;
    RadioGroup opciones;
    TextView rb1, rb2, rb3, rb4, pregunta;
    Button siguiente;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta3_m1);

        IncializarComponentes();
        opciones = findViewById(R.id.radioGroup);
        bundle1 = getIntent().getExtras();
        calificacion = bundle1.getInt("calificacion");

        Intent recibir_r1 = this.getIntent();
        d1 = recibir_r1.getIntExtra("respuesta1",-1);

        Intent recibir_r2 = this.getIntent();
        d2 = recibir_r2.getIntExtra("respuesta2",-1);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        Pref_Fuente();
        Pref_Quiz();
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
                rb2.setTypeface(Roboto);
                rb3.setTypeface(Roboto);
                rb4.setTypeface(Roboto);
                siguiente.setTypeface(Roboto);break;
            case "Monserrat":
                Typeface mon = getResources().getFont(R.font.ubuntu);
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

    public void Pref_Quiz(){
        String Quiz = prefs.getString("reply_Modalidad", "Biología");

        switch (Quiz){
            case"Historia":
                pregunta.setText(getResources().getString(R.string.txt_3_m1));
                rb1.setText(getResources().getString(R.string.rb3_A_m1));
                rb2.setText(getResources().getString(R.string.rb3_B_m1));
                rb3.setText(getResources().getString(R.string.rb3_C_m1));
                rb4.setText(getResources().getString(R.string.rb3_D_m1)); break;

            case"Biología":
                pregunta.setText(getResources().getString(R.string.txt_3_m2));
                rb1.setText(getResources().getString(R.string.rb3_A_m2));
                rb2.setText(getResources().getString(R.string.rb3_B_m2));
                rb3.setText(getResources().getString(R.string.rb3_C_m2));
                rb4.setText(getResources().getString(R.string.rb3_D_m2)); break;

            case"Deportes":
                pregunta.setText(getResources().getString(R.string.txt_3_m3));
                rb1.setText(getResources().getString(R.string.rb3_A_m3));
                rb2.setText(getResources().getString(R.string.rb3_B_m3));
                rb3.setText(getResources().getString(R.string.rb3_C_m3));
                rb4.setText(getResources().getString(R.string.rb3_D_m3)); break;

            case"Cine":
                pregunta.setText(getResources().getString(R.string.txt_3_m4));
                rb1.setText(getResources().getString(R.string.rb3_B_m4));
                rb2.setText(getResources().getString(R.string.rb3_A_m4));
                rb3.setText(getResources().getString(R.string.rb3_C_m4));
                rb4.setText(getResources().getString(R.string.rb3_D_m4)); break;

        }
    }

    public void IncializarComponentes(){
        //leer preferencias del usuario
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        pregunta = findViewById(R.id.txt_3);
        rb1 = findViewById(R.id.rb3_A);
        rb2 = findViewById(R.id.rb3_B);
        rb3 = findViewById(R.id.rb3_C);
        rb4 = findViewById(R.id.rb3_D);
        siguiente = findViewById(R.id.button3);

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
                calificacion+=2;
                respuesta3++;
                Toast.makeText(this, "Elegiste la opción 2", '1').show();
                break;

            case R.id.rb3_C:
                calificacion+=0;
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