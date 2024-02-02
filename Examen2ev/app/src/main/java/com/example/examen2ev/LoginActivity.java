package com.example.examen2ev;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity  extends AppCompatActivity {

    private EditText nombre;
    private EditText password;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        nombre = findViewById(R.id.nombre);
        password = findViewById(R.id.password);
        imageView = findViewById(R.id.imageView);
    }

    public void botonLogin(View view){
        if(nombre.getText().toString().equals("admin")&&password.getText().toString().equals("admin")){
            imageView.setVisibility(View.INVISIBLE);
            Intent intent = new Intent(this, AdministrationActivity.class);
            startActivity(intent);
        }else{
            imageView.setVisibility(View.VISIBLE);
            limpiar(view);
            showExitConfirmationDialog();
        }
    }

    //Intent a mainactivity
    public void botonCancelar(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    //Limpiar campos en error
    public void limpiar(View view){
        nombre.setText("");
        password.setText("");
    }

    private void showExitConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.textoError)
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