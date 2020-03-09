package com.zomwi.mapas;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;

public class PrincipalActivity extends MapActivity {

	private MapView mapa;
	private MapController controlMapa;
	private CheckBox checkBox;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mapa = (MapView) findViewById(R.id.mapa);
		mapa.setBuiltInZoomControls(true);
		mapa.setSatellite(false);

		controlMapa = mapa.getController();

		checkBox = (CheckBox) findViewById(R.id.checkBox1);
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	public void irMonoblock(View view) {
		// Monoblock: -16.504666,-68.129995
		Double latitud = -16.504666 * 1E6;
		Double longitud = -68.129995 * 1E6;

		GeoPoint geoPoint = new GeoPoint(latitud.intValue(),
				longitud.intValue());

		controlMapa.animateTo(geoPoint); // controlMapa.setCenter(geoPoint);
		controlMapa.setZoom(18);
	}

	public void irCotaCota(View view) {
		// Cota Cota: -16.539502,-68.06832
		Double latitud = -16.539502 * 1E6;
		Double longitud = -68.06832 * 1E6;

		GeoPoint geoPoint = new GeoPoint(latitud.intValue(),
				longitud.intValue());
		// controlMapa.setCenter(geoPoint);
		controlMapa.animateTo(geoPoint);
		controlMapa.setZoom(18);
	}

	public void cambiarModo(View view) {
		if (checkBox.isChecked()) {
			mapa.setSatellite(true);
		} else {
			mapa.setSatellite(false);
		}
	}
}