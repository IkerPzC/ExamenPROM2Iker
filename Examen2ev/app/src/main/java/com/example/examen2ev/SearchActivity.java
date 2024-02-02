package com.example.examen2ev;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SearchActivity  extends AppCompatActivity {

    private EditText input;
    private Button buscar;

    private int contador=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Intent intent = getIntent();
        contador = Integer.parseInt(intent.getStringExtra("contador"));
        contador = contador+1;

        input = findViewById(R.id.input);
        buscar = findViewById(R.id.botonBuscar);
    }

    //Intent a mainactivity
    public void botonVolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("contador",contador);
        startActivity(intent);
    }

    //Método buscar
    public void botonBuscar(View view){
        //Si el boton es buscar, busca y si no lo es, limpia
        if(buscar.getText().equals(R.string.botonBuscar)){
            boolean encontrado=false;

            if(encontrado){
                buscar.setText(R.string.botonLimpiar);
            }
        }else{
            limpiar(view);
        }
    }


    //Métdo limpiar
    public void limpiar(View view){
        buscar.setText(R.string.botonBuscar);
    }
}
