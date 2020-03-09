package com.zomwi.marcadorderuta;

import java.util.Date;

import com.zomwi.marcadorderuta.db.AdaptadorDB;
import com.zomwi.marcadorderuta.db.Punto;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.format.Time;
import android.widget.Toast;

public class Cronometro extends BroadcastReceiver {

	// LocationManager
	private LocationManager locationManager;
	private Handler handler;

	private Context context;
	private static final int ACTUALIZAR_LATITUD = 2;
	private static final int ACTUALIZAR_LONGITUD = 3;
	private int sw = 1;
	private double latitudActual;
	private double longitudActual;

	private AdaptadorDB baseDeDatos;

	@Override
	public void onReceive(final Context context, Intent intent) {
		this.context = context;
		baseDeDatos = new AdaptadorDB(context);
		Toast.makeText(context, "Guardando punto...", Toast.LENGTH_LONG).show();

		// LocationManager
		locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		// Handler
		handler = new Handler() {
			public void handleMessage(Message msg) {
				if (sw == 1) {
					latitudActual = Double.parseDouble((String) (msg.obj));
					sw = 2;
				} else {
					longitudActual = Double.parseDouble((String) (msg.obj));
					Toast.makeText(context, "> " + latitudActual + " " + longitudActual, Toast.LENGTH_LONG).show();
					sw = 1;
					// ********** guardar **********
					Double latitud = latitudActual * 1E6;
					Double longitud = longitudActual * 1E6;
					Date fecha = new Date();
					baseDeDatos.adicionarProducto(new Punto(latitud.intValue(), longitud.intValue(), fecha.getDay() + " " + fecha.getMonth() + " " + fecha.getYear(), ""));
				}
			}
		};

		baseDeDatos.abrir();
		configurar();
	}

	// -------------------------------------------------------------------------
	// LOCALIZACION
	private void actualizarIU(Location localizacion) {
		Message.obtain(handler, ACTUALIZAR_LATITUD, localizacion.getLatitude() + "").sendToTarget();
		Message.obtain(handler, ACTUALIZAR_LONGITUD, localizacion.getLongitude() + "").sendToTarget();
	}

	// Configurar
	public void configurar() {
		Location localizacionGPS = null;
		Location localizacionRED = null;
		locationManager.removeUpdates(escuchador);
		// textoLatitud.setText(R.string.desconocido);
		// textoLongitud.setText(R.string.desconocido);
		// textoDireccion.setText(R.string.desconocido);

		// Actualizamos botones
		// botonFino.setBackgroundResource(R.drawable.degradado_celeste); //
		// botonAmbos.setBackgroundResource(R.drawable.degradado_naranja); //
		// Obtener la localizacion de ambos proveedores
		localizacionGPS = pedirActualizacionesDeProveedor(LocationManager.GPS_PROVIDER, "GPS no soportado");
		localizacionRED = pedirActualizacionesDeProveedor(LocationManager.NETWORK_PROVIDER, "RED no soportado");
		// Si ambos proveedores retornan la ultima conocida localizacion,
		// compara las dos y usamos la mejor para actualizar la IU, si solo
		// un proveedor retorna una localizacion usa esa.
		if (localizacionGPS != null && localizacionRED != null) {
			actualizarIU(getMejorLocalizacion(localizacionGPS, localizacionRED));
		} else if (localizacionGPS != null) {
			actualizarIU(localizacionGPS);
		} else if (localizacionRED != null) {
			actualizarIU(localizacionRED);
		}
	}

	private Location pedirActualizacionesDeProveedor(String proveedor, String mensajeError) {
		Location localizacion = null;
		if (locationManager.isProviderEnabled(proveedor)) {
			int DIEZ_SEGUNDOS = 10000;
			int DIEZ_METROS = 10;
			locationManager.requestLocationUpdates(proveedor, DIEZ_SEGUNDOS, DIEZ_METROS, escuchador);
			localizacion = locationManager.getLastKnownLocation(proveedor);
		} else {
			Toast.makeText(context, mensajeError, Toast.LENGTH_LONG).show();
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

	protected Location getMejorLocalizacion(Location nuevaLocalizacion, Location currentBestLocation) {
		int TWO_MINUTES = 1000 * 60 * 2;
		if (currentBestLocation == null) {
			return nuevaLocalizacion;
		}
		long timeDelta = nuevaLocalizacion.getTime() - currentBestLocation.getTime();
		boolean isSignificantlyNewer = timeDelta > TWO_MINUTES;
		boolean isSignificantlyOlder = timeDelta < -TWO_MINUTES;
		boolean isNewer = timeDelta > 0;
		if (isSignificantlyNewer) {
			return nuevaLocalizacion;
		} else if (isSignificantlyOlder) {
			return currentBestLocation;
		}
		int accuracyDelta = (int) (nuevaLocalizacion.getAccuracy() - currentBestLocation.getAccuracy());
		boolean isLessAccurate = accuracyDelta > 0;
		boolean isMoreAccurate = accuracyDelta < 0;
		boolean isSignificantlyLessAccurate = accuracyDelta > 200;
		boolean isFromSameProvider = esMismoProveedor(nuevaLocalizacion.getProvider(), currentBestLocation.getProvider());
		if (isMoreAccurate) {
			return nuevaLocalizacion;
		} else if (isNewer && !isLessAccurate) {
			return nuevaLocalizacion;
		} else if (isNewer && !isSignificantlyLessAccurate && isFromSameProvider) {
			return nuevaLocalizacion;
		}
		return currentBestLocation;
	}

	private boolean esMismoProveedor(String provider1, String provider2) {
		if (provider1 == null) {
			return provider2 == null;
		}
		return provider1.equals(provider2);
	}

}
