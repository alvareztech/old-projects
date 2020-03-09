package com.androfony.replyfony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androfony.replyfony.capas.YoOverlay;
import com.androfony.replyfony.util.SwipeDetector;
import com.androfony.replyfony.util.Util;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class MainActivity extends MapActivity implements TextToSpeech.OnInitListener {
	// , OnCheckedChangeListener {

	// Localización
	private LocationManager locationManager;
	private Handler handler;

	// Mapa
	private MapView mapa;
	private MapController controlMapa;
	private TextView textoTituloMapa;
	private TextView textoSubtituloMapa;

	// Temperatura
	private TextView textoTituloTemperatura;
	private TextView textoNumeroTemperatura;
	private TextView textoEstadoTemperatura;
	private ImageView imagenTemperatura;

	// Partido
	private TextView textoTituloPartido;
	private TextView textoSubtituloPartido;
	private ImageView imagenEquipo1;
	private ImageView imagenEquipo2;
	private TextView textoEquipo1;
	private TextView textoEquipo2;

	// Accidentes
	private TextView textoTituloAccidentes;
	private TextView textoDescripcionAccidentes;

	// Reconocimiento de voz
	private static final int CODIGO_DE_SOLICITUD_RECONOCIMIENTO_DE_VOZ = 1234;
	private ImageButton botonHablar;
	// private TextView textoResultado;
	private TextToSpeech tts;
	private CheckBox check;

	// Images
	private int[] iconosClima = { R.drawable.c0, R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4,
			R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8, R.drawable.c9, R.drawable.c10, R.drawable.c11,
			R.drawable.c12, R.drawable.c13, R.drawable.c14, R.drawable.c15, R.drawable.c16, R.drawable.c17,
			R.drawable.c18, R.drawable.c19, R.drawable.c20, R.drawable.c21, R.drawable.c22, R.drawable.c23,
			R.drawable.c24, R.drawable.c25, R.drawable.c26, R.drawable.c27, R.drawable.c28, R.drawable.c29,
			R.drawable.c30, R.drawable.c31, R.drawable.c32, R.drawable.c33, R.drawable.c34, R.drawable.c35,
			R.drawable.c36, R.drawable.c37, R.drawable.c38, R.drawable.c39, R.drawable.c40, R.drawable.c41,
			R.drawable.c42, R.drawable.c43, R.drawable.c44, R.drawable.c45, R.drawable.c46, R.drawable.c47 };

	private LinearLayout layoutA;
	private LinearLayout layoutB;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Mapa
		mapa = (MapView) findViewById(R.id.mapa);
		controlMapa = mapa.getController();

		textoTituloMapa = (TextView) findViewById(R.id.textoTituloMapa);
		textoSubtituloMapa = (TextView) findViewById(R.id.textoSubtituloMapa);
		textoTituloMapa.setText("Ahora");
		textoSubtituloMapa.setText("Hogar y trabajo");

		// Temperatura
		textoTituloTemperatura = (TextView) findViewById(R.id.tituloTemperatura);
		textoNumeroTemperatura = (TextView) findViewById(R.id.textoNumeroTemperatura);
		textoEstadoTemperatura = (TextView) findViewById(R.id.textoEstadoTemperatura);
		imagenTemperatura = (ImageView) findViewById(R.id.imagenTemperatura);

		// Partido
		textoTituloPartido = (TextView) findViewById(R.id.textoTituloPartido);
		textoSubtituloPartido = (TextView) findViewById(R.id.textoSubtituloPartido);
		imagenEquipo1 = (ImageView) findViewById(R.id.imagenEquipo1);
		imagenEquipo2 = (ImageView) findViewById(R.id.imagenEquipo2);
		textoEquipo1 = (TextView) findViewById(R.id.textoEquipo1);
		textoEquipo2 = (TextView) findViewById(R.id.textoEquipo2);

		// Accidentes
		textoTituloAccidentes = (TextView) findViewById(R.id.textoTituloAccidentes);
		textoDescripcionAccidentes = (TextView) findViewById(R.id.textoDescripcionAccidentes);

		layoutA = (LinearLayout) findViewById(R.id.layoutA);
		layoutB = (LinearLayout)findViewById(R.id.layoutB);
		
		// ***********************************
		final SwipeDetector swipeDetector = new SwipeDetector();
		layoutA.setOnTouchListener(swipeDetector);
		layoutA.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				if (swipeDetector.swipeDetected()) {
					Toast.makeText(getApplicationContext(), "SWIPW", Toast.LENGTH_SHORT).show();
					Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion);
					view.startAnimation(animation);
					animation.setAnimationListener(new AnimationListener() {
						@Override
						public void onAnimationStart(Animation arg0) {
						}
						@Override
						public void onAnimationRepeat(Animation arg0) {
						}
						@Override
						public void onAnimationEnd(Animation arg0) {
							layoutB.setVisibility(View.GONE);
						}
					});
				} else {
					Toast.makeText(getApplicationContext(), "clic", Toast.LENGTH_SHORT).show();
				}
			}
		});
		
		
		
		final SwipeDetector swipeDetector2 = new SwipeDetector();
		layoutB.setOnTouchListener(swipeDetector2);
		layoutB.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view2) {
				if (swipeDetector2.swipeDetected()) {
					Toast.makeText(getApplicationContext(), "SWIPW", Toast.LENGTH_SHORT).show();

					Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion);
					view2.startAnimation(animation);
					animation.setAnimationListener(new AnimationListener() {
						@Override
						public void onAnimationStart(Animation arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationRepeat(Animation arg0) {
							// TODO Auto-generated method stub
							
						}
						
						@Override
						public void onAnimationEnd(Animation arg0) {
							// TODO Auto-generated method stub
							layoutB.setVisibility(View.GONE);
						}
					});

				} else {
					Toast.makeText(getApplicationContext(), "clic", Toast.LENGTH_SHORT).show();
				}
			}
		});

		
		
		
		
		
		
		
		
		// ***

		// lista.setOnItemClickListener(new OnItemClickListener() {
		//
		// @Override
		// public void onItemClick(AdapterView<?> arg0, View view, int position,
		// long arg3) {
		// if (swipeDetector.swipeDetected()) {
		// // Toast.makeText(getApplicationContext(), "Swipe",
		// // Toast.LENGTH_SHORT).show();
		//
		// TranslateAnimation anim = new TranslateAnimation(0, 0, -40, 0);
		// anim.setDuration(1000);
		// anim.setFillAfter(true);
		// view.setAnimation(anim);
		//
		// adaptadorLista.eliminar(position);
		// } else {
		// Toast.makeText(getApplicationContext(), "Clic Normal",
		// Toast.LENGTH_SHORT).show();
		// }
		// }
		// });

		handler = new Handler() {
			public void handleMessage(Message msg) {
				switch (msg.what) {
				case 7:
					Location localizacionEncontrada = (Location) msg.obj;

					int latitud = (int) (localizacionEncontrada.getLatitude() * 1E6);
					int longitud = (int) (localizacionEncontrada.getLongitude() * 1E6);
					GeoPoint geoPoint = new GeoPoint(latitud, longitud);
					controlMapa.animateTo(geoPoint);
					controlMapa.setCenter(geoPoint);
					controlMapa.setZoom(15);
					// Pin
					List<Overlay> capas = mapa.getOverlays();
					capas.clear();
					YoOverlay miCapa = new YoOverlay((int) (localizacionEncontrada.getLatitude() * 1E6),
							(int) (localizacionEncontrada.getLongitude() * 1E6), "yo");

					SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
					int latitudCasa = settings.getInt("latitudCasa", 0);
					int longitudCasa = settings.getInt("longitudCasa", 0);
					int latitudEducacion = settings.getInt("latitudEducacion", 0);
					int longitudEducacion = settings.getInt("longitudEducacion", 0);
					int latitudTrabajo = settings.getInt("latitudTrabajo", 0);
					int longitudTrabajo = settings.getInt("longitudTrabajo", 0);

					YoOverlay miCapa2 = new YoOverlay(latitudCasa, longitudCasa, "casa");
					YoOverlay miCapa3 = new YoOverlay(latitudTrabajo, longitudTrabajo, "trabajo");

					capas.add(miCapa);
					capas.add(miCapa2);
					capas.add(miCapa3);
					mapa.postInvalidate();

					break;
				}
			}
		};

		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		// ***********************************************************************************

		botonHablar = (ImageButton) findViewById(R.id.btnVoz);
		PackageManager pm = getPackageManager();
		List<ResolveInfo> activities = pm
				.queryIntentActivities(new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH), 0);
		if (activities.size() != 0) {
			botonHablar.setOnClickListener(new OnClickListener() {
				public void onClick(View v) {
					iniciarActivityReconocimientoDeVoz();
				}
			});
		}
		// textoResultado = (TextView) findViewById(R.id.textView1);
		tts = new TextToSpeech(this, this);
		// check = (CheckBox)findViewById(R.id.activarSensor);
		// check.setOnCheckedChangeListener(this);
	}

	// Inicia las propiedades para reconocimiento de voz
	private void iniciarActivityReconocimientoDeVoz() {
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "");
		startActivityForResult(intent, CODIGO_DE_SOLICITUD_RECONOCIMIENTO_DE_VOZ);
	}

	// Activity que reconoce la voz y lo almacena en un vector
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent datos) {
		if (requestCode == CODIGO_DE_SOLICITUD_RECONOCIMIENTO_DE_VOZ && resultCode == RESULT_OK) {
			ArrayList<String> resultados = datos.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
			final String[] items = new String[resultados.size()];
			for (int i = 0; i < resultados.size(); i++) {
				items[i] = resultados.get(i);
			}
			String resultado = "";
			Arrays.sort(items);
			if (Arrays.binarySearch(items, "tiempo") > 0) {

				SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
				String temperatura = settings.getString("temperatura", "8");
				String ciudad = settings.getString("ciudad", "La Paz");
				String estadoTemperatura = settings.getString("estadoTemperatura", "Nublado");

				resultado = "En " + ciudad + " la temperatura es " + temperatura + " grados centígrados, con estado "
						+ estadoTemperatura;

			} else {
				if (Arrays.binarySearch(items, "futbol") > 0) {

					SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);

					String equipo1 = settings.getString("equipo1", "Oriente Petrolero");
					String equipo2 = settings.getString("equipo2", "Bolívar");
					String horaPartido = settings.getString("horaPartido", "19:00");

					resultado = "El siguiente partido es " + equipo1 + " versus " + equipo2 + " a " + horaPartido;
				} else {
					resultado = "No se reconoce la palabra, vuelva a intentar de nuevo.";
				}
			}
			// textoResultado.setText(items[0] + "");
			hablar(resultado);
		}
		super.onActivityResult(requestCode, resultCode, datos);
	}

	// Inicializar el TextToSpeech con sus propiedades
	@Override
	public void onInit(int status) {
		if (status == TextToSpeech.SUCCESS) {
			Locale loc = new Locale("es", "BOL");
			int result = tts.setLanguage(loc);
			if (result == TextToSpeech.LANG_MISSING_DATA || result == TextToSpeech.LANG_NOT_SUPPORTED) {
				Toast.makeText(this, "Este lenguaje no esta soportado", Toast.LENGTH_SHORT).show();
			}
		} else {
			Toast.makeText(this, "Fallo en la inicialización", Toast.LENGTH_SHORT).show();
		}
	}

	// Método que sacará de texto a voz.
	public void hablar(String x) {
		// Toast.makeText(this, "Aun no disponible.",
		// Toast.LENGTH_SHORT).show();
		// String text = textoResultado.getText().toString();
		tts.speak(x, TextToSpeech.QUEUE_FLUSH, null);
	}

	@Override
	protected void onStart() {
		super.onStart();

		// Comprobación
		// LocationManager locationManagerExtra = (LocationManager)
		// getSystemService(Context.LOCATION_SERVICE);
		// boolean gpsHabilitado =
		// locationManagerExtra.isProviderEnabled(LocationManager.GPS_PROVIDER);
		// if (!gpsHabilitado) {
		// Util.mostrarAlertaActivarGPS(this);
		// }

		// Iniciar localización
		iniciarLocalizacion();

		cargarDatosPartido();
		cargarDatosTemperatura();
		cargarDatosAccidentes();
	}

	private void cargarDatosAccidentes() {

		HttpClient cliente = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://192.168.43.105/replyfony/web/app.php/api/accidentesTransito");
		get.setHeader("content-type", "application/json");
		try {
			HttpResponse respuesta = cliente.execute(get);
			String res = EntityUtils.toString(respuesta.getEntity());
			JSONObject object = new JSONObject(res);

			int colisiones = (int) object.getDouble("colisiones");
			int atropellos = (int) object.getDouble("atropellos");
			int choques = (int) object.getDouble("choques");
			int vuelcos = (int) object.getDouble("vuelcos");
			int embarrancamientos = (int) object.getDouble("embarrancamientos");
			int caidas = (int) object.getDouble("caidas");
			int incendios = (int) object.getDouble("incendios");

			// Visualizar
			textoTituloAccidentes.setText("Accidentes de tránsito");
			textoDescripcionAccidentes.setText("En promedio al mes hay " + colisiones + " colisiones, " + atropellos
					+ " atropellos, " + choques + " choques, " + vuelcos + " vuelcos, " + embarrancamientos
					+ " embarrancamientos.");

		} catch (Exception ex) {
		}
	}

	private void cargarDatosPartido() {
		textoTituloPartido.setText("Fútbol");
		textoSubtituloPartido.setText("19:00, estadio R. Tahuichi");
		imagenEquipo1.setImageResource(R.drawable.oriente);
		imagenEquipo2.setImageResource(R.drawable.bolivar);
		textoEquipo1.setText("Oriente Petrolero");
		textoEquipo2.setText("Bolivar");
		// Guardar
		SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("equipo1", "Oriente Petrolero");
		editor.putString("equipo2", "Bolívar");
		editor.putString("horaPartido", "19:00");
		editor.commit();
	}

	private void cargarDatosTemperatura() {
		HttpClient cliente = new DefaultHttpClient();
		HttpGet get = new HttpGet("http://192.168.43.105/replyfony/web/app.php/api/tiempo");
		get.setHeader("content-type", "application/json");
		try {
			HttpResponse respuesta = cliente.execute(get);
			String res = EntityUtils.toString(respuesta.getEntity());
			JSONObject object = new JSONObject(res);
			String codigo = object.getString("codigo");
			String estado = object.getString("estado");
			
			estado = estado.replace("&eacute;", "é");
			String temperatura = object.getString("temperatura");

			// Visualizar
			textoTituloTemperatura.setText("La Paz");
			textoNumeroTemperatura.setText(temperatura + "°");
			textoEstadoTemperatura.setText(estado);

			imagenTemperatura.setImageResource(iconosClima[Integer.parseInt(codigo)]);

			// Guardar
			SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putString("cuidad", "La Paz");
			editor.putString("temperatura", temperatura);
			editor.putString("estadoTemperatura", estado);
			editor.commit();

		} catch (Exception ex) {
		}

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
		// El numero 7 solo simbolico
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

	// MENU
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Intent intent = new Intent(this, ConfiguracionActivity.class);
		startActivity(intent);
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
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

	public void creditos(View view) {
		Toast.makeText(this, "Desarrollado por ANDROFONY", Toast.LENGTH_LONG).show();
	}

	public void iniciarCheckIn(View view) {
		Intent intent = new Intent(this, CheckInActivity.class);
		startActivity(intent);
	}

	/*
	 * @Override public void onCheckedChanged(CompoundButton buttonView, boolean
	 * isChecked) { if(isChecked){ check.setText("Esta activado el sensor");
	 * startService(new Intent(this, ElServicio.class)); }else{
	 * check.setText("Esta desactivado el sensor"); stopService(new Intent(this,
	 * ElServicio.class)); } }
	 */

}
