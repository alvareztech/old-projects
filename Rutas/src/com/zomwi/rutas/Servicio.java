package com.zomwi.rutas;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.widget.Toast;

import com.zomwi.rutas.db.BaseDatos;

public class Servicio extends Service {

	private Timer timer = new Timer();
	private static final int TIEMPO_ACTUALIZACION = 300000; // 5 minutos
	private Handler handler;
	private BaseDatos db;

	// Localizacion
	private LocationManager locationManager;
	private Handler handlerLocalizacion;
	private static final int ACTUALIZAR_LATITUD_LONGITUD = 1;
	private static final int ACTUALIZAR_LATITUD = 2;
	private static final int ACTUALIZAR_LONGITUD = 3;
	private double latitudActual;
	private double longitudActual;

	@Override
	public void onCreate() {
		super.onCreate();
		db = new BaseDatos(this);

		// Localizacion
		locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
		// Handler
		handlerLocalizacion = new Handler() {
			public void handleMessage(Message msg) {
				latitudActual = msg.getData().getDouble("latitud");
				longitudActual = msg.getData().getDouble("longitud");
				// ********** guardar **********
				Double latitud = latitudActual * 1E6;
				Double longitud = longitudActual * 1E6;
				db.adicionar(latitud.intValue(), longitud.intValue());
				locationManager.removeUpdates(escuchador);
				Toast.makeText(Servicio.this, "Guardando punto... ", Toast.LENGTH_SHORT).show();
			}
		};

		// Servicio
		Toast.makeText(this, "Servicio iniciado", Toast.LENGTH_SHORT).show();
		handler = new Handler() {
			public void handleMessage(Message msg) {
				//Toast.makeText(Servicio.this, "Iniciando captura de  punto...", Toast.LENGTH_SHORT).show();
				configurar();
			}
		};

		// Timer
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				Message.obtain(handler, 0, "Hola").sendToTarget();

			}
		}, 0, TIEMPO_ACTUALIZACION);
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Servicio detenido", Toast.LENGTH_SHORT).show();
		if (timer != null) {
			timer.cancel();
		}
	}

	@Override
	public IBinder onBind(Intent arg0) {
		return null;
	}

	// -------------------------------------------------------------------------
	// LOCALIZACION
	private void actualizarIU(Location localizacion) {
		Bundle bundle = new Bundle();
		bundle.putDouble("latitud", localizacion.getLatitude());
		bundle.putDouble("longitud", localizacion.getLongitude());
		Message mensaje = new Message();
		mensaje.setData(bundle);
		handlerLocalizacion.sendMessage(mensaje);
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
		/*
		if (localizacionGPS != null && localizacionRED != null) {
			actualizarIU(getMejorLocalizacion(localizacionGPS, localizacionRED));
		} else if (localizacionGPS != null) {
			actualizarIU(localizacionGPS);
		} else if (localizacionRED != null) {
			actualizarIU(localizacionRED);
		}
		*/
	}

	private Location pedirActualizacionesDeProveedor(String proveedor, String mensajeError) {
		Location localizacion = null;
		if (locationManager.isProviderEnabled(proveedor)) {
			int DIEZ_SEGUNDOS = 10000;
			int DIEZ_METROS = 10;
			locationManager.requestLocationUpdates(proveedor, 0, 0, escuchador);
			//localizacion = locationManager.getLastKnownLocation(proveedor);
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
