package com.example.examen2ev;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdministrationActivity extends AppCompatActivity {

    private EditText nombreElemento;
    private ElementoQuimicoDAO elementoQuimicoDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administration);

        nombreElemento = findViewById(R.id.nombreElemento);
        elementoQuimicoDAO = new ElementoQuimicoDAO(this);
    }

    //Intent a mainactivity
    public void botonVolver(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Insertar
    public void botonInsertar(View view){
        Intent intent = new Intent(this, Insertar.class);
        startActivity(intent);
    }

    //Modificar
    public void botonModificar(View view){
        if(elementoQuimicoDAO.existeNombreElementoQuimico(nombreElemento.getText().toString())){

            Toast.makeText(this, R.string.correctaModificacion, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, R.string.incorrectaModificacion, Toast.LENGTH_SHORT).show();
        }
    }

    //Borrar
    public void botonBorrar(View view){
        if(elementoQuimicoDAO.existeNombreElementoQuimico(nombreElemento.getText().toString())){
            elementoQuimicoDAO.borrarTuplon(nombreElemento.getText().toString());
            Toast.makeText(this, R.string.correctoBorrado, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, R.string.incorrectoBorrado, Toast.LENGTH_SHORT).show();
        }
    }
}
