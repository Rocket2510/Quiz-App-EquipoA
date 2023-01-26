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
import android.widget.TextView;

import com.example.quiz_app_equipoa.R;

public class Resultados_m1 extends AppCompatActivity {
    int calificacion = 0;
    int d1, d2, d3, d4, d5;
    Bundle bundle1, bundle2;
    TextView txt1_3, txt_R1, txt_R2, txt_R3, txt_R4, txt_R5;
    Button siguiente;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados_m1);

        InicializarComponentes();
        MostrarResultados();
    }

    public void InicializarComponentes(){
        txt1_3 = findViewById(R.id.txt1_3);
        txt_R1 = findViewById(R.id.txt_R1);
        txt_R2 = findViewById(R.id.txt_R2);
        txt_R3 = findViewById(R.id.txt_R3);
        txt_R4 = findViewById(R.id.txt_R4);
        txt_R5 = findViewById(R.id.txt_R5);
        siguiente = findViewById(R.id.button);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        bundle1 = getIntent().getExtras();
        calificacion = bundle1.getInt("calificacion");

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
                txt1_3.setTypeface(Roboto);
                txt_R1.setTypeface(Roboto);
                txt_R2.setTypeface(Roboto);
                txt_R3.setTypeface(Roboto);
                txt_R4.setTypeface(Roboto);
                txt_R5.setTypeface(Roboto);
                siguiente.setTypeface(Roboto);break;
            case "Monserrat":
                Typeface mon = getResources().getFont(R.font.montserrat);
                txt1_3.setTypeface(mon);
                txt_R1.setTypeface(mon);
                txt_R2.setTypeface(mon);
                txt_R3.setTypeface(mon);
                txt_R4.setTypeface(mon);
                txt_R5.setTypeface(mon);
                siguiente.setTypeface(mon);break;
            case "Play":
                Typeface play = getResources().getFont(R.font.play);
                txt1_3.setTypeface(play);
                txt_R1.setTypeface(play);
                txt_R2.setTypeface(play);
                txt_R3.setTypeface(play);
                txt_R4.setTypeface(play);
                txt_R5.setTypeface(play);
                siguiente.setTypeface(play);break;
        }
    }

    public void MostrarResultados(){
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

    public void Btn_PantallaInicio(View v){
        Intent i = new Intent(this, Pantalla_Inicio.class);
        startActivity(i);

    }
}