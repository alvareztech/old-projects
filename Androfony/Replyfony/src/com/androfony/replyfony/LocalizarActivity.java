package com.androfony.replyfony;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class LocalizarActivity extends MapActivity {

	private MapView mapa;

	private String tipo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localizar);

		mapa = (MapView) findViewById(R.id.mapa);

		mapa.setClickable(true);

		tipo = getIntent().getStringExtra("tipo");
	}

	@Override
	protected boolean isRouteDisplayed() {
		return false;
	}

	public void aceptar(View view) {
		GeoPoint geoPoint = mapa.getMapCenter();

		SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
		SharedPreferences.Editor editor = settings.edit();

		if (tipo.equals("casa")) {
			editor.putInt("latitudCasa", geoPoint.getLatitudeE6());
			editor.putInt("longitudCasa", geoPoint.getLongitudeE6());
		} else if (tipo.equals("educacion")) {
			editor.putInt("latitudEducacion", geoPoint.getLatitudeE6());
			editor.putInt("longitudEducacion", geoPoint.getLongitudeE6());
		} else if (tipo.equals("trabajo")) {
			editor.putInt("latitudTrabajo", geoPoint.getLatitudeE6());
			editor.putInt("longitudTrabajo", geoPoint.getLongitudeE6());
		}

		editor.commit();

		Intent intentRetorno = new Intent(this, ConfiguracionActivity.class);
		startActivity(intentRetorno);

		finish();
	}

	public void cancelar(View view) {
		Intent intentRetorno = new Intent(this, ConfiguracionActivity.class);
		startActivity(intentRetorno);
		finish();
	}

}
