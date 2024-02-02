package com.example.examen2ev;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static int contador = 0;
    private TextView numeroConsultas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent();
        contador = Integer.parseInt(intent.getStringExtra("contador"));

        numeroConsultas = findViewById(R.id.numeroConsultas);
    }

    //Método salir
    public void botonSalir(View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("ADIOS");
        builder.setMessage(R.string.betiAlaves);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        builder.show();
        AlertDialog alert = builder.create();
        alert.show();
    }

    //Intent a la clase LoginActivity
    public void botonQuimico(View view){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    //Intent a la clase SearchActivty
    public void botonConsultar(View view){
        Intent intent = new Intent(this, SearchActivity.class);
        intent.putExtra("contador" , contador);
        startActivityForResult(intent,contador);

    }


}