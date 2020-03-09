package com.zomwi.rutas;

import android.app.ListActivity;
import android.os.Bundle;

import com.zomwi.rutas.adaptadores.AdaptadorLista;
import com.zomwi.rutas.db.BaseDatos;

public class PuntosActivity extends ListActivity {

	private AdaptadorLista adaptadorLista;
	private BaseDatos db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_puntos);

		adaptadorLista = new AdaptadorLista(this);
		setListAdapter(adaptadorLista);

		db = new BaseDatos(this);
		db.cargar(adaptadorLista);
	}

}
