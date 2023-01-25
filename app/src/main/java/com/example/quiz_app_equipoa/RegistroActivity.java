package com.example.quiz_app_equipoa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {
    private EditText txt_PersonName, txt_EmailAddress, txt_PasswordAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        InicializarComponentes();
    }

    public void InicializarComponentes(){
        txt_PersonName = findViewById(R.id.txt_PersonName);
        txt_EmailAddress = findViewById(R.id.txt_EmailAddress);
        txt_PasswordAddress = findViewById(R.id.txt_PasswordAddress);


    }

    public void btn_Registrar(View v){
        ConexionSQLite admin = new ConexionSQLite(this, "Quiz.db", null, 1);
        SQLiteDatabase Registro_DB = admin.getWritableDatabase();

        String nombre = txt_PersonName.getText().toString();
        String email = txt_EmailAddress.getText().toString();
        String password = txt_PasswordAddress.getText().toString();

        if (!nombre.isEmpty() && !email.isEmpty() && !password.isEmpty()){
            ContentValues registro = new ContentValues();
            registro.put("nombre", nombre);
            registro.put("email", email);
            registro.put("password", password);

            Registro_DB.insert("users", null, registro);
            Registro_DB.close();

            txt_PersonName.setText("");
            txt_EmailAddress.setText("");
            txt_PasswordAddress.setText("");

            Toast.makeText(this, "Registro Existoso", Toast.LENGTH_SHORT).show();
            
        }else{
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
}