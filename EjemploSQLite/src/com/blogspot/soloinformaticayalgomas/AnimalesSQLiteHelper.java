package com.blogspot.soloinformaticayalgomas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 *
 * @author Daniel Alvarez
 */
public class AnimalesSQLiteHelper extends SQLiteOpenHelper {

    public AnimalesSQLiteHelper(Context contexto, String nombre, CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE animales (codigo INTEGER, nombre TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        
    }
    
}
