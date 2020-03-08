package com.blogspot.soloinformaticayalgomas;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends Activity {

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        AnimalesSQLiteHelper u = new AnimalesSQLiteHelper(this, "dbanimales", null, 1);
        SQLiteDatabase db = u.getWritableDatabase();
        if (db != null) {
            for (int i = 0; i < 5; i++) {
                int codigo = i;
                String nombre = "Daniel" + i;
                db.execSQL("INSERT INTO animales (codigo, nombre) VALUES (" + codigo + ", " + nombre + ")");
            }
            db.close();
        }
    }
}
