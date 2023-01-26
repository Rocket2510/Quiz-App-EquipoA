package com.example.quiz_app_equipoa;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView txt_1, txt_2, txt_3;
    private EditText txt_EmailAccess, txt_PasswordAccess;
    private Button btn_IniciarSesion, btn_Registrarse;
    private SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //leer preferencias del usuario
        prefs = PreferenceManager.getDefaultSharedPreferences(this);

        InicializarComponentes();

    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onResume() {
        Pref_Fuente();
        super.onResume();
    }

    //Metodo para acceder a la pantalla de inicio (En lo que programamos la validacion)
    public void Btn_IniciarSesion (View v){

        Intent i = new Intent(this, Pantalla_Inicio.class);
        startActivity(i);

    }

    public void Btn_Registrarse (View v){
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }

    public void InicializarComponentes(){
        txt_1 = (TextView) findViewById(R.id.txt_welcome);
        txt_2 = (TextView) findViewById(R.id.txt_Email);
        txt_3 = (TextView) findViewById(R.id.txt_pswd);

        txt_EmailAccess = (EditText) findViewById(R.id.txt_EmailAccess);
        txt_PasswordAccess = (EditText) findViewById(R.id.txt_PasswordAddress);

        btn_IniciarSesion = (Button) findViewById(R.id.btn_IniciarSesion1);
        btn_Registrarse = (Button) findViewById(R.id.btn_Registrate1);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void Pref_Fuente(){
        String fuente = prefs.getString("reply_Fuente", "Roboto");

        switch (fuente){
            case "Roboto":
                Typeface Roboto = getResources().getFont(R.font.roboto);
                txt_1.setTypeface(Roboto);
                txt_2.setTypeface(Roboto);
                txt_3.setTypeface(Roboto);
                txt_EmailAccess.setTypeface(Roboto);
                txt_PasswordAccess.setTypeface(Roboto);
                btn_IniciarSesion.setTypeface(Roboto);
                btn_Registrarse.setTypeface(Roboto); break;

            case "Monserrat":
                Typeface mon = getResources().getFont(R.font.ubuntu);
                txt_1.setTypeface(mon);
                txt_2.setTypeface(mon);
                txt_3.setTypeface(mon);
                txt_EmailAccess.setTypeface(mon);
                txt_PasswordAccess.setTypeface(mon);
                btn_IniciarSesion.setTypeface(mon);
                btn_Registrarse.setTypeface(mon); break;

            case "Play":
                Typeface play = getResources().getFont(R.font.play);
                txt_1.setTypeface(play);
                txt_2.setTypeface(play);
                txt_3.setTypeface(play);
                txt_EmailAccess.setTypeface(play);
                txt_PasswordAccess.setTypeface(play);
                btn_IniciarSesion.setTypeface(play);
                btn_Registrarse.setTypeface(play); break;
        }
    }
}
