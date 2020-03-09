package com.zomwi.marcadorderuta;

import com.zomwi.marcadorderuta.adapters.AdaptadorLista;
import com.zomwi.marcadorderuta.db.AdaptadorDB;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

public class ContenidoActivity extends Activity {
	
	private ListView lista;
	private AdaptadorLista adaptadorLista;
	private AdaptadorDB baseDeDatos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);
		
		lista = (ListView) findViewById(R.id.lista);
		adaptadorLista = new AdaptadorLista(this);
		lista.setAdapter(adaptadorLista);
		
		
		baseDeDatos = new AdaptadorDB(this);
		baseDeDatos.abrir();
		baseDeDatos.cargar(adaptadorLista);
		
		
	}

}
