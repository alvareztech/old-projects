package com.androfony.replyfony;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.androfony.replyfony.adapters.AdaptadorListaHechos;
import com.androfony.replyfony.capas.YoOverlay;
import com.androfony.replyfony.util.Util;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class CheckInActivity extends MapActivity {

	// Mapa
	private MapView mapa;
	private MapController controlMapa;
	// Lista
	private ListView lista;
	private AdaptadorListaHechos adaptadorLista;

	// Localización
	private LocationManager locationManager;
	private Handler handler;

	private Location ubicacionActual;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checkin);

		mapa = (MapView) findViewById(R.id.mapa);
		controlMapa = mapa.getController();

		lista = (ListView) findViewById(R.id.lista);
		adaptadorLista = new AdaptadorListaHechos(this);
		lista.setAdapter(adaptadorLista);
		lista.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
				Intent intent = new Intent(getApplicationContext(), CheckInExtrasActivity.class);

				TextView textView = (TextView) view.findViewById(R.id.textoHechoItem);
				intent.putExtra("tipo", textView.getText().toString());

				GeoPoint geoPoint = mapa.getMapCenter();
				intent.putExtra("latitud", geoPoint.getLatitudeE6());
				intent.putExtra("longitud", geoPoint.getLongitudeE6());

				startActivity(intent);
			}
		});

		handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 7:
					Location localizacionEncontrada = (Location) msg.obj;
					colocarPinEnMapa(localizacionEncontrada);
					break;
				}
			}

		};

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		// Set datas
		adaptadorLista.adicionarItem(R.drawable.ic_action_suicidio, "Suicidio");
		adaptadorLista.adicionarItem(R.drawable.ic_action_agresion, "Agresión");
		adaptadorLista.adicionarItem(R.drawable.ic_action_droga, "Consumo de droga");
		adaptadorLista.adicionarItem(R.drawable.ic_action_robo, "Robo");
		adaptadorLista.adicionarItem(R.drawable.ic_action_roboconarma, "Robo con arma");
		adaptadorLista.adicionarItem(R.drawable.ic_action_hechodetransito, "Hecho de transito");
		adaptadorLista.adicionarItem(R.drawable.ic_action_incendio, "Incendio");
		adaptadorLista.adicionarItem(R.drawable.ic_action_homicidio, "Homicidio");
		adaptadorLista.adicionarItem(R.drawable.ic_action_personadesaparecida, "Persona desaparacida");

	}

	@Override
	protected void onStart() {
		super.onStart();
		iniciarLocalizacion();

	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

	private void iniciarLocalizacion() {
		Location localizacionGPS = null;
		Location localizacionRED = null;
		locationManager.removeUpdates(oyenteUbicaciones);

		localizacionGPS = pedirActualizacionesDeProveedor(LocationManager.GPS_PROVIDER, R.string.gpsNoSoportado);
		localizacionRED = pedirActualizacionesDeProveedor(LocationManager.NETWORK_PROVIDER, R.string.redNoSoportado);

		if (localizacionGPS != null && localizacionRED != null) {
			actualizarIU(Util.getMejorLocalizacion(localizacionGPS, localizacionRED));
		} else if (localizacionGPS != null) {
			actualizarIU(localizacionGPS);
		} else if (localizacionRED != null) {
			actualizarIU(localizacionRED);
		}
	}

	private void actualizarIU(Location localizacion) {
		// muestra en el mapa
		Message.obtain(handler, 7, localizacion).sendToTarget();
	}

	private Location pedirActualizacionesDeProveedor(String proveedor, int mensajeError) {
		Location localizacion = null;
		if (locationManager.isProviderEnabled(proveedor)) {
			int DIEZ_SEGUNDOS = 10000;
			int DIEZ_METROS = 10;
			locationManager.requestLocationUpdates(proveedor, DIEZ_SEGUNDOS, DIEZ_METROS, oyenteUbicaciones);
			localizacion = locationManager.getLastKnownLocation(proveedor);
		} else {
			Toast.makeText(this, mensajeError, Toast.LENGTH_LONG).show();
		}
		return localizacion;
	}

	private final LocationListener oyenteUbicaciones = new LocationListener() {

		public void onLocationChanged(Location location) {
			actualizarIU(location);
		}

		public void onProviderDisabled(String provider) {

		}

		public void onProviderEnabled(String provider) {

		}

		public void onStatusChanged(String provider, int status, Bundle extras) {

		}

	};

	public void colocarPinEnMapa(Location ubicacion) {
		Location ubicacionActual = ubicacion;
		GeoPoint geoPoint = new GeoPoint((int) (ubicacion.getLatitude() * 1E6), (int) (ubicacion.getLongitude() * 1E6));
		controlMapa.animateTo(geoPoint); // controlMapa.setCenter(geoPoint);
		controlMapa.setZoom(16);

		List<Overlay> capas = mapa.getOverlays();
		capas.clear();
		YoOverlay miCapa = new YoOverlay((int) (ubicacion.getLatitude() * 1E6), (int) (ubicacion.getLongitude() * 1E6),
				"yo");
		capas.add(miCapa);
		mapa.postInvalidate();
	}

}
