package com.example.examen2ev;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Insertar extends AppCompatActivity {

    private EditText campoId, campoNumAtomico,campoNombre, campoSimbolo, campoEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        campoId = findViewById(R.id.campoId);
        campoNumAtomico = findViewById(R.id.campoNumAtomico);
        campoNombre = findViewById(R.id.campoNombre);
        campoSimbolo = findViewById(R.id.campoSimbolo);
        campoEstado = findViewById(R.id.campoEstado);
    }

    //Insertar en bbdd
    public void botonInsertar(View view){
        Integer id = Integer.parseInt(campoId.getText().toString());
        Integer numAtomico = Integer.parseInt(campoNumAtomico.getText().toString());
        String nombre = campoNombre.getText().toString();
        String simbolo = campoSimbolo.getText().toString();
        String estado = campoEstado.getText().toString();

        ElementoQuimico elementoQuimico = new ElementoQuimico(id, nombre, simbolo, numAtomico, estado);
        ElementoQuimicoDAO elementoQuimicoDAO = new ElementoQuimicoDAO(this);

        if(!elementoQuimicoDAO.existeNombreElementoQuimico(nombre)){
            try {
                elementoQuimicoDAO.abrir();

                long resultado = elementoQuimicoDAO.insertarElementoQuimico(elementoQuimico);

                if (resultado != -1) {
                    Toast.makeText(this, R.string.insercionCorrecta, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, R.string.insercionIncorrecta, Toast.LENGTH_SHORT).show();
                }
            } finally {
                elementoQuimicoDAO.cerrar();
            }
        }else{
            mismoNombreDialog();
        }
    }

    //Volver
    public void botonVolver(View view){
        Intent intent = new Intent(this, AdministrationActivity.class);
        startActivity(intent);
    }


    private void mismoNombreDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.elementoExistente)
                .setTitle(R.string.tituloError);

        builder.setCancelable(false);  // Hacer el diálogo modal

        builder.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.show();
    }
}
