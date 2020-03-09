package com.zomwi.marcadorderuta.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AyudanteDB extends SQLiteOpenHelper {

	public AyudanteDB(Context context) {
		super(context, "ruta", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE puntos (codigo INTEGER PRIMARY KEY AUTOINCREMENT," + " latitud TEXT, longitud TEXT, fecha TEXT, hora TEXT)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS puntos");
		onCreate(db);
	}
}
