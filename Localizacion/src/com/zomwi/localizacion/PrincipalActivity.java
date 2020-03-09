package com.zomwi.localizacion;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PrincipalActivity extends Activity {

	// Controles
	private TextView textoLatitud;
	private TextView textoLongitud;
	private TextView textoDireccion;
	private Button botonFino;
	private Button botonAmbos;

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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		// Recupera el estado de la aplicacion si existe
		if (savedInstanceState != null) {
			usarFino = savedInstanceState.getBoolean(CLAVE_FINO);
			usarAmbos = savedInstanceState.getBoolean(CLAVE_AMBOS);
		} else {
			usarFino = false;
			usarAmbos = false;
		}

		// Obtener Controles
		textoLatitud = (TextView) findViewById(R.id.textoLatitud);
		textoLongitud = (TextView) findViewById(R.id.textoLongitud);
		textoDireccion = (TextView) findViewById(R.id.textoDireccion);
		botonFino = (Button) findViewById(R.id.botonFino);
		botonAmbos = (Button) findViewById(R.id.botonAmbos);

		/*********************************************************/
		// Geocoder
		disponibleGeocoder = true; // Build.VERSION.SDK_INT >= 9;

		// Handler
		handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case ACTUALIZAR_DIRECCION:
					textoDireccion.setText((String) msg.obj);
					break;
				case ACTUALIZAR_LATITUD:
					textoLatitud.setText((String) msg.obj);
					break;
				case ACTUALIZAR_LONGITUD:
					textoLongitud.setText((String) msg.obj);
					break;
				}
			}
		};
		// LocationManager

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putBoolean(CLAVE_FINO, usarFino);
		outState.putBoolean(CLAVE_AMBOS, usarAmbos);
	}

	@Override
	protected void onResume() {
		super.onResume();
		configurar();
	}

	@Override
	protected void onStart() {
		super.onStart();
		// Comprueba si el GPS esta activado en el dispositivo.
		// La verificación debe hacerce en onStart() pues el sistema llama a
		// este método cada vez que el usuario regresa a la actividad, lo
		// que garantiza la comprobación cuando se reanuda despues de una pausa.
		LocationManager locationManager2 = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		boolean gpsHabilitado = locationManager2.isProviderEnabled(LocationManager.GPS_PROVIDER);
		if (!gpsHabilitado) {
			// Contruir un dialogo para permitir al usuario activar el GPS,
			// cuando el usuario acepte se llamara a
			// abrirConfiguracionesUbicacionYSeguridad()
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
			builder.setMessage("¿Quieres activar el GPS?").setCancelable(false).setPositiveButton("Si", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					abrirConfiguracionesUbicacionYSeguridad();
				}
			}).setNegativeButton("No", new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog, int id) {
					dialog.cancel();
				}
			});
			AlertDialog alerta = builder.create();
			alerta.show();
		}
	}

	public void abrirConfiguracionesUbicacionYSeguridad() {
		Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
		startActivity(intent);
	}

	@Override
	protected void onStop() {
		super.onStop();
		locationManager.removeUpdates(escuchador);
	}

	// Configurar
	public void configurar() {
		Location localizacionGPS = null;
		Location localizacionRED = null;
		locationManager.removeUpdates(escuchador);
		textoLatitud.setText(R.string.desconocido);
		textoLongitud.setText(R.string.desconocido);
		textoDireccion.setText(R.string.desconocido);

		if (usarFino) { // Obtenemos actualizaciones finas solamente
			// Actualizamos botones
			botonFino.setBackgroundResource(R.drawable.degradado_naranja); // activo
			botonAmbos.setBackgroundResource(R.drawable.degradado_celeste); // inactivo
			// Obtener la localizacion desde el proveedor GPS
			localizacionGPS = pedirActualizacionesDeProveedor(LocationManager.GPS_PROVIDER, R.string.gps_no_soportado);
			// Actualizamos la UI inmediatamente si la localización es obtenida
			if (localizacionGPS != null) {
				actualizarIU(localizacionGPS);
			}
		} else if (usarAmbos) { // Obtener actualizaciones de ambos proveedores
			// Actualizamos botones
			botonFino.setBackgroundResource(R.drawable.degradado_celeste); // inactivo
			botonAmbos.setBackgroundResource(R.drawable.degradado_naranja); // activo
			// Obtener la localizacion de ambos proveedores
			localizacionGPS = pedirActualizacionesDeProveedor(LocationManager.GPS_PROVIDER, R.string.gps_no_soportado);
			localizacionRED = pedirActualizacionesDeProveedor(LocationManager.NETWORK_PROVIDER, R.string.red_no_soportado);
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
	}

	private Location pedirActualizacionesDeProveedor(String proveedor, int mensajeError) {
		Location localizacion = null;
		if (locationManager.isProviderEnabled(proveedor)) {
			int DIEZ_SEGUNDOS = 10000;
			int DIEZ_METROS = 10;
			locationManager.requestLocationUpdates(proveedor, DIEZ_SEGUNDOS, DIEZ_METROS, escuchador);
			localizacion = locationManager.getLastKnownLocation(proveedor);
		} else {
			Toast.makeText(this, mensajeError, Toast.LENGTH_LONG).show();
		}
		return localizacion;
	}

	public void usarProveedorFino(View view) {
		usarFino = true;
		usarAmbos = false;
		configurar();
	}

	public void usarAmbosProveedores(View view) {
		usarFino = false;
		usarAmbos = true;
		configurar();
	}

	/************************************************/
	private void hacerGeocodificacionReversa(Location location) {
		(new TareaGeocodificacionReversa(this)).execute(new Location[] { location });
	}

	/************************************************/
	private void actualizarIU(Location localizacion) {
		Message.obtain(handler, ACTUALIZAR_LATITUD, localizacion.getLatitude() + "").sendToTarget();

		Message.obtain(handler, ACTUALIZAR_LONGITUD, localizacion.getLongitude() + "").sendToTarget();

		if (disponibleGeocoder) {
			hacerGeocodificacionReversa(localizacion);
		}
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

	/***********************************************************/
	private class TareaGeocodificacionReversa extends AsyncTask<Location, Void, Void> {
		Context contexto;

		public TareaGeocodificacionReversa(Context context) {
			super();
			contexto = context;
		}

		@Override
		protected Void doInBackground(Location... params) {
			Geocoder geocoder = new Geocoder(contexto, Locale.getDefault());

			Location localizacion = params[0];
			List<Address> addresses = null;
			try {
				addresses = geocoder.getFromLocation(localizacion.getLatitude(), localizacion.getLongitude(), 1);
			} catch (IOException e) {
				e.printStackTrace();
				// Actualizacion del campo direccion
				Message.obtain(handler, ACTUALIZAR_DIRECCION, e.toString()).sendToTarget();
			}
			if (addresses != null && addresses.size() > 0) {
				Address address = addresses.get(0);
				// Dar formato y si es posible en nombre del pais
				String addressText = String.format("%s, %s, %s", address.getMaxAddressLineIndex() > 0 ? address.getAddressLine(0) : "",
						address.getLocality(), address.getCountryName());
				// Actualizar la direccion en la IU
				Message.obtain(handler, ACTUALIZAR_DIRECCION, addressText).sendToTarget();
			}
			return null;
		}
	}

}