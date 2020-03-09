package com.zomwi.rutas.db;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zomwi.rutas.adaptadores.AdaptadorLista;

public class BaseDatos {

	private SQLiteDatabase db;
	private AyudanteDB ayudante;

	public BaseDatos(Context contexto) {
		ayudante = new AyudanteDB(contexto);
	}

	public void adicionar(int latitud, int longitud) {
		db = ayudante.getWritableDatabase();
		ContentValues valores = new ContentValues();
		valores.put("latitud", latitud);
		valores.put("longitud", longitud);
		Calendar c = Calendar.getInstance();
		int dia = c.get(Calendar.DAY_OF_MONTH);
		int mes = c.get(Calendar.MONTH);
		int anio = c.get(Calendar.YEAR);
		int hora = c.get(Calendar.HOUR_OF_DAY);
		int minuto = c.get(Calendar.MINUTE);
		String fecha = (dia > 9 ? "" + dia : "0" + dia) + "/" + (mes > 9 ? "" + mes : "0" + mes) + "/" + anio;
		String horas = (hora > 9 ? "" + hora : "0" + hora) + ":" + (minuto > 9 ? "" + minuto : "0" + minuto);
		valores.put("fecha", fecha);
		valores.put("hora", horas);
		db.insert("puntos", null, valores);
		db.close();
	}

	public void eliminar(int codigo) {
		db.delete("puntos", "codigo=" + codigo, null);
	}

	public void cargar(AdaptadorLista adaptadorLista) {
		db = ayudante.getWritableDatabase();
		adaptadorLista.eliminarTodo();
		String[] campos = { "codigo", "latitud", "longitud", "fecha", "hora" };
		Cursor cursor = db.query("puntos", campos, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int codigo = cursor.getInt(0);
				String latitud = cursor.getString(1);
				String longitud = cursor.getString(2);
				String fecha = cursor.getString(3);
				String hora = cursor.getString(4);
				adaptadorLista.adicionarItem(fecha + " " + hora, "(" + latitud + ", " + longitud + ")");
			} while (cursor.moveToNext());
		}
		db.close();
	}

	public List<String> getLatitudes() {
		db = ayudante.getWritableDatabase();
		List<String> listaLatitudes = new ArrayList<String>();
		String[] campos = { "codigo", "latitud", "longitud" };
		Cursor cursor = db.query("puntos", campos, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int codigo = cursor.getInt(0);
				String latitud = cursor.getString(1);
				String longitud = cursor.getString(2);
				listaLatitudes.add(latitud);
			} while (cursor.moveToNext());
		}
		db.close();
		return listaLatitudes;
	}

	public List<String> getLongitudes() {
		db = ayudante.getWritableDatabase();
		List<String> listaLongitudes = new ArrayList<String>();
		String[] campos = { "codigo", "latitud", "longitud" };
		Cursor cursor = db.query("puntos", campos, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int codigo = cursor.getInt(0);
				String latitud = cursor.getString(1);
				String longitud = cursor.getString(2);
				listaLongitudes.add(longitud);
			} while (cursor.moveToNext());
		}
		db.close();
		return listaLongitudes;
	}

	public List<Punto> obtenerTodo() {
		db = ayudante.getWritableDatabase();
		List<Punto> listaPuntos = new ArrayList<Punto>();
		String[] campos = { "codigo", "latitud", "longitud", "fecha", "hora" };
		Cursor cursor = db.query("puntos", campos, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int codigo = cursor.getInt(0);
				String latitud = cursor.getString(1);
				String longitud = cursor.getString(2);
				String fecha = cursor.getString(3);
				String hora = cursor.getString(4);
				listaPuntos.add(new Punto(Integer.parseInt(latitud), Integer.parseInt(longitud), fecha, hora));
			} while (cursor.moveToNext());
		}
		db.close();
		return listaPuntos;
	}

	public List<Punto> obtenerPorFecha(int dia, int mes, int anio) {
		db = ayudante.getWritableDatabase();
		List<Punto> listaPuntos = new ArrayList<Punto>();
		String[] campos = { "codigo", "latitud", "longitud", "fecha", "hora" };
		String fech = (dia > 9 ? dia + "" : "0" + dia) + "/" + (mes > 9 ? mes + "" : "0" + mes) +"/"+ (anio);
		String[] args = { fech };
		Cursor cursor = db.query("puntos", campos, "fecha=?", args, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int codigo = cursor.getInt(0);
				String latitud = cursor.getString(1);
				String longitud = cursor.getString(2);
				String fecha = cursor.getString(3);
				String hora = cursor.getString(4);
				listaPuntos.add(new Punto(Integer.parseInt(latitud), Integer.parseInt(longitud), fecha, hora));
			} while (cursor.moveToNext());
		}
		db.close();
		return listaPuntos;
	}

	public void eliminarTodo() {
		db = ayudante.getWritableDatabase();
		db.delete("puntos", null, null);
		db.close();
	}

	public class AyudanteDB extends SQLiteOpenHelper {

		public AyudanteDB(Context context) {
			super(context, "ruta", null, 1);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {
			db.execSQL("CREATE TABLE puntos (codigo INTEGER PRIMARY KEY AUTOINCREMENT,"
					+ " latitud TEXT, longitud TEXT, fecha TEXT, hora TEXT)");
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			db.execSQL("DROP TABLE IF EXISTS puntos");
			onCreate(db);
		}
	}

}
