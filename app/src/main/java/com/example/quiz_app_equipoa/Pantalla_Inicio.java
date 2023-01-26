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


public class Pantalla_Inicio extends AppCompatActivity {
    private TextView txt_TxtQuiz;
    private Button btn_Iniciar;
    private SharedPreferences prefs;
    private Button btn_Modalidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);

        //leer preferencias del usuario
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        IniciarlizarComponetentes();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        Pref_Fuente();
        super.onResume();
    }

    //Metodo para inicializar componentes
    public void IniciarlizarComponetentes(){
        txt_TxtQuiz = (TextView) findViewById(R.id.txt_TxtQuiz);
        btn_Iniciar = (Button) findViewById(R.id.btn_Iniciar);
        btn_Modalidad = (Button) findViewById(R.id.btn_Modalidad);
    }

    //Metodo para cambiar a las Preferencias de Fuente
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Pref_Fuente(){
        String fuente = prefs.getString("reply_Fuente", "Roboto");

        switch (fuente){
            case "Roboto":
                Typeface Roboto = getResources().getFont(R.font.roboto);
                txt_TxtQuiz.setTypeface(Roboto);
                btn_Modalidad.setTypeface(Roboto);
                btn_Iniciar.setTypeface(Roboto);break;
                
            case "Monserrat":
                Typeface mon = getResources().getFont(R.font.ubuntu);
                txt_TxtQuiz.setTypeface(mon);
                btn_Modalidad.setTypeface(mon);
                btn_Iniciar.setTypeface(mon);break;
            case "Play":
                Typeface play = getResources().getFont(R.font.play);
                txt_TxtQuiz.setTypeface(play);
                btn_Modalidad.setTypeface(play);
                btn_Iniciar.setTypeface(play);break;
        }
    }

    public void Btn_Modalidad (View v){
        Intent preferencias = new Intent(this, Pref_modalidad.class);
        startActivity(preferencias);
    }

    public void Btn_IniciarJuego(View sender){
        Intent StartGame = new Intent(this, Pregunta_1_m1.class);
        startActivity(StartGame);
    }


}