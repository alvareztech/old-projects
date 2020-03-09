package com.zomwi.marcadorderuta.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.zomwi.marcadorderuta.adapters.AdaptadorLista;

public class AdaptadorDB {

	private SQLiteDatabase db;
	private AyudanteDB ayudante;

	public AdaptadorDB(Context contexto) {
		ayudante = new AyudanteDB(contexto);
	}

	public void abrir() {
		db = ayudante.getWritableDatabase();
	}

	public void cerrar() {
		ayudante.close();
	}

	public void adicionarProducto(Punto punto) {
		ContentValues valores = new ContentValues();
		valores.put("latitud", punto.getLatitud());
		valores.put("longitud", punto.getLongitud());
		valores.put("fecha", punto.getFecha());
		valores.put("hora", punto.getHora());
		db.insert("puntos", null, valores);
	}

	public void eliminarProducto(int codigo) {
		db.delete("puntos", "codigo=" + codigo, null);
	}

	public void cargar(AdaptadorLista adaptadorLista) {

		adaptadorLista.eliminarTodo();
		String[] campos = { "codigo", "latitud", "longitud", "fecha" };
		Cursor cursor = db.query("puntos", campos, null, null, null, null, null);
		if (cursor.moveToFirst()) {
			do {
				int codigo = cursor.getInt(0);
				String latitud = cursor.getString(1);
				String longitud = cursor.getString(2);
				String fecha = cursor.getString(3);
				adaptadorLista.adicionarItem(latitud + " " + longitud, fecha);
			} while (cursor.moveToNext());
		}
	}

	public List<String> getLatitudes() {
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
		return listaLatitudes;
	}

	public List<String> getLongitudes() {
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
		return listaLongitudes;
	}

	public List<String> getLatitudes(int dia, int mes, int anio) {
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
		return listaLatitudes;
	}

	public List<String> getLongitudes(int dia, int mes, int anio) {
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
		return listaLongitudes;
	}

	public void eliminarTodo() {
		db.delete("puntos", null, null);
	}

}
