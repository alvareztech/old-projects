package com.zomwi.marcadorderuta;

import java.util.List;

import android.os.Bundle;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.zomwi.marcadorderuta.db.AdaptadorDB;

public class MapaActivity extends MapActivity {

	private MapView mapa;
	private MapController controladorMapa;
	private AdaptadorDB db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);

		Bundle bundle = getIntent().getExtras();
		if (bundle != null) {
			int dia = bundle.getInt("dia");
			int mes = bundle.getInt("mes");
			int anio = bundle.getInt("anio");
		}

		mapa = (MapView) findViewById(R.id.mapa);
		mapa.setBuiltInZoomControls(true);
		mapa.setSatellite(false);
		controladorMapa = mapa.getController();

		db = new AdaptadorDB(this);
		db.abrir();
		List<String> listaLatitudes = db.getLatitudes();
		List<String> listaLongitudes = db.getLongitudes();
		// List<String> listaLatitudes = baseDeDatos.getLatitudes(dia, mes,
		// anio);
		// List<String> listaLongitudes = baseDeDatos.getLongitudes(dia, mes,
		// anio);

		GeoPoint geoPoint = new GeoPoint(Integer.parseInt(listaLatitudes.get(0)), Integer.parseInt(listaLongitudes.get(0)));
		controladorMapa.animateTo(geoPoint);
		controladorMapa.setZoom(18);

		List<Overlay> capas = mapa.getOverlays();
		Trazo capa1 = new Trazo(listaLatitudes, listaLongitudes);
		capas.add(capa1);
		mapa.postInvalidate();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}