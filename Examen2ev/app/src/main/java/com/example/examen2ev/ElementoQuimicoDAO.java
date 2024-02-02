package com.example.examen2ev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class ElementoQuimicoDAO {
    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public ElementoQuimicoDAO(Context context) {
        dbHelper = new DBHelper(context);
    }

    public void abrir() {
        db = dbHelper.getWritableDatabase();
    }

    public void cerrar() {
        dbHelper.close();
    }

    public long insertarElementoQuimico(ElementoQuimico elemento) {
        ContentValues values = new ContentValues();
        values.put("nombre", elemento.getNombre());
        values.put("simbolo", elemento.getSimbolo());
        values.put("num_atomico", elemento.getNumAtomico());
        values.put("estado", elemento.getEstado());

        return db.insert("elementos", null, values);
    }

    public boolean borrarTuplon(String name)
    {
        return db.delete("elementos", "nombre=?", new String[]{name}) > 0;
    }

    public boolean existeNombreElementoQuimico(String nombre) {
        boolean existe = false;
        Cursor cursor = null;

        try {
            abrir();

            cursor = db.query("elementos", null, "nombre=?", new String[]{nombre}, null, null, null);

            if (cursor != null && cursor.getCount() > 0) {
                existe = true;
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            cerrar();
        }

        return existe;
    }
}