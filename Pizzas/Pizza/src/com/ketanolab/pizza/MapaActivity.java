package com.ketanolab.pizza;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Window;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;

public class MapaActivity extends MapActivity {

	private MapView mapa;
	private MapController controladorMapa;
	private OverlayItem overlayItem;

	// ------------------------------------------------
	// LocationManager
	private LocationManager locationManager;

	// Handler
	private Handler handler;

	// Booleanos
	private boolean disponibleGeocoder;
	private boolean usarFino;
	private boolean usarAmbos;

	// Variables para mantener los estados de la IU despues de la rotación
	private static final String CLAVE_FINO = "usar_fino";
	private static final String CLAVE_AMBOS = "usar_ambos";

	// Códigos de la IU
	private static final int ACTUALIZAR_DIRECCION = 1;
	private static final int ACTUALIZAR_LATITUD = 2;
	private static final int ACTUALIZAR_LONGITUD = 3;

	private int sw = 1;

	private double latitudU;
	private double longitudU;

	List<Overlay> overlays;
	Puntos itemizedoverlay;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.mapa);

		mapa = (MapView) findViewById(R.id.mapa);
		mapa.setBuiltInZoomControls(true);

		controladorMapa = mapa.getController();
		// ----
		overlays = mapa.getOverlays();
		Drawable drawable = this.getResources().getDrawable(
				R.drawable.logo_empresa_peque);
		itemizedoverlay = new Puntos(drawable, this);
		double lat = -16.510208;
		double lng = -68.126197;
		GeoPoint point = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
		overlayItem = new OverlayItem(point, getString(R.string.mr_pizza),
				getString(R.string.sucursal) + " 1");
		itemizedoverlay.addOverlay(overlayItem);
		overlays.add(itemizedoverlay);
		controladorMapa.animateTo(point);
		lat = -16.499258;
		lng = -68.133652;
		point = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
		overlayItem = new OverlayItem(point, getString(R.string.mr_pizza),
				getString(R.string.sucursal) + " 2");
		itemizedoverlay.addOverlay(overlayItem);
		overlays.add(itemizedoverlay);

		lat = -16.50355741;
		lng = -68.13074811;
		point = new GeoPoint((int) (lat * 1E6), (int) (lng * 1E6));
		overlayItem = new OverlayItem(point, getString(R.string.mr_pizza),
				getString(R.string.sucursal) + " 3");
		itemizedoverlay.addOverlay(overlayItem);
		overlays.add(itemizedoverlay);

		// mapControler.animateTo (point);
		controladorMapa.setZoom(16);
		// --------------------------------------------------------------LOCALIZACION
		// Handler
		handler = new Handler() {
			public void handleMessage(Message msg) {

				Log.i("pizaa", "pasa--------------------------------------");
				if (sw == 1) {
					latitudU = Double.parseDouble((String) (msg.obj));
					Log.i("pizaa", latitudU + "");
					sw = 2;
				} else {
					longitudU = Double.parseDouble((String) (msg.obj));
					Log.i("pizaa", longitudU + "");
					Toast.makeText(MapaActivity.this, "> " + latitudU + ", "
							+ longitudU, Toast.LENGTH_SHORT);

					ir(new GeoPoint((int) (latitudU * 1E6),
							(int) (longitudU * 1E6)));
					sw = 1;
				}
			}
		};
		// LocationManager
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		usarAmbosProveedores();
	}

	private void ir(GeoPoint punto) {
		controladorMapa.animateTo(punto);
		controladorMapa.setZoom(16);
		overlayItem = new OverlayItem(punto, getString(R.string.mr_pizza),
				getString(R.string.sucursal) + " X");
		Drawable drawable = this.getResources().getDrawable(R.drawable.usuario);
		itemizedoverlay = new Puntos(drawable, this);
		itemizedoverlay.addOverlay(overlayItem);

		overlays.add(itemizedoverlay);
	}

	private void usarAmbosProveedores() {
		usarFino = false;
		usarAmbos = true;
		configurar();

	}

	// Configurar
	public void configurar() {
		Location localizacionGPS = null;
		Location localizacionRED = null;
		locationManager.removeUpdates(escuchador);
		// textoLatitud.setText(R.string.desconocido);
		// textoLongitud.setText(R.string.desconocido);
		// textoDireccion.setText(R.string.desconocido);

		if (usarFino) { // Obtenemos actualizaciones finas solamente
			// Actualizamos botones
			// botonFino.setBackgroundResource(R.drawable.degradado_naranja); //
			// activo
			// botonAmbos.setBackgroundResource(R.drawable.degradado_celeste);
			// // inactivo
			// Obtener la localizacion desde el proveedor GPS
			localizacionGPS = pedirActualizacionesDeProveedor(
					LocationManager.GPS_PROVIDER, R.string.gps_no_soportado);
			// Actualizamos la UI inmediatamente si la localización es obtenida
			if (localizacionGPS != null) {
				actualizarIU(localizacionGPS);
			}
		} else if (usarAmbos) { // Obtener actualizaciones de ambos proveedores
			// Actualizamos botones
			// botonFino.setBackgroundResource(R.drawable.degradado_celeste); //
			// inactivo
			// botonAmbos.setBackgroundResource(R.drawable.degradado_naranja);
			// // activo
			// Obtener la localizacion de ambos proveedores
			localizacionGPS = pedirActualizacionesDeProveedor(
					LocationManager.GPS_PROVIDER, R.string.gps_no_soportado);
			localizacionRED = pedirActualizacionesDeProveedor(
					LocationManager.NETWORK_PROVIDER, R.string.red_no_soportado);
			// Si ambos proveedores retornan la ultima conocida localizacion,
			// compara las dos y usamos la mejor para actualizar la IU, si solo
			// un proveedor retorna una localizacion usa esa.
			if (localizacionGPS != null && localizacionRED != null) {
				actualizarIU(getMejorLocalizacion(localizacionGPS,
						localizacionRED));
			} else if (localizacionGPS != null) {
				actualizarIU(localizacionGPS);
			} else if (localizacionRED != null) {
				actualizarIU(localizacionRED);
			}
		}
	}

	private void actualizarIU(Location localizacion) {
		Message.obtain(handler, ACTUALIZAR_LATITUD,
				localizacion.getLatitude() + "").sendToTarget();

		Message.obtain(handler, ACTUALIZAR_LONGITUD,
				localizacion.getLongitude() + "").sendToTarget();

	}

	private Location pedirActualizacionesDeProveedor(String proveedor,
			int mensajeError) {
		Location localizacion = null;
		if (locationManager.isProviderEnabled(proveedor)) {
			int DIEZ_SEGUNDOS = 10000;
			int DIEZ_METROS = 10;
			locationManager.requestLocationUpdates(proveedor, DIEZ_SEGUNDOS,
					DIEZ_METROS, escuchador);
			localizacion = locationManager.getLastKnownLocation(proveedor);
		} else {
			Toast.makeText(this, mensajeError, Toast.LENGTH_LONG).show();
		}
		return localizacion;
	}

	private final LocationListener escuchador = new LocationListener() {

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

	protected Location getMejorLocalizacion(Location newLocation,
			Location currentBestLocation) {
		int TWO_MINUTES = 1000 * 60 * 2;
		if (currentBestLocation == null) {
			// A new location is always better than no location
			return newLocation;
		}

		// Check whether the new location fix is newer or older
		long timeDelta = newLocation.getTime() - currentBestLocation.getTime();
		boolean isSignificantlyNewer = timeDelta > TWO_MINUTES;
		boolean isSignificantlyOlder = timeDelta < -TWO_MINUTES;
		boolean isNewer = timeDelta > 0;

		// If it's been more than two minutes since the current location, use
		// the new location
		// because the user has likely moved.
		if (isSignificantlyNewer) {
			return newLocation;
			// If the new location is more than two minutes older, it must be
			// worse
		} else if (isSignificantlyOlder) {
			return currentBestLocation;
		}

		// Check whether the new location fix is more or less accurate
		int accuracyDelta = (int) (newLocation.getAccuracy() - currentBestLocation
				.getAccuracy());
		boolean isLessAccurate = accuracyDelta > 0;
		boolean isMoreAccurate = accuracyDelta < 0;
		boolean isSignificantlyLessAccurate = accuracyDelta > 200;

		// Check if the old and new location are from the same provider
		boolean isFromSameProvider = esMismoProveedor(
				newLocation.getProvider(), currentBestLocation.getProvider());

		// Determine location quality using a combination of timeliness and
		// accuracy
		if (isMoreAccurate) {
			return newLocation;
		} else if (isNewer && !isLessAccurate) {
			return newLocation;
		} else if (isNewer && !isSignificantlyLessAccurate
				&& isFromSameProvider) {
			return newLocation;
		}
		return currentBestLocation;
	}

	private boolean esMismoProveedor(String provider1, String provider2) {
		if (provider1 == null) {
			return provider2 == null;
		}
		return provider1.equals(provider2);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}
