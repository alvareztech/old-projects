package com.zomwi.rutas;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.zomwi.rutas.db.BaseDatos;
import com.zomwi.rutas.db.Punto;

public class MapaActivity extends MapActivity {

	private MapView mapa;
	private MapController controladorMapa;
	private BaseDatos db;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mapa);
		
		db = new BaseDatos(this);
		
		List<Punto> listaPuntos = new ArrayList<Punto>();

		String tipo = getIntent().getStringExtra("tipo");
		if (tipo.equals("hoy")) {
			int dia = getIntent().getIntExtra("dia", 0);
			int mes = getIntent().getIntExtra("mes", 0);
			int anio = getIntent().getIntExtra("anio", 0);
			Toast.makeText(this, "Hoy " + dia + "/" + mes + "/" + anio, Toast.LENGTH_LONG).show();
			listaPuntos = db.obtenerPorFecha(dia, mes, anio);
		} else if (tipo.equals("ayer")) {
			int dia = getIntent().getIntExtra("dia", 0);
			int mes = getIntent().getIntExtra("mes", 0);
			int anio = getIntent().getIntExtra("anio", 0);
			Toast.makeText(this, "Ayer " + dia + "/" + mes + "/" + anio, Toast.LENGTH_LONG).show();
			listaPuntos = db.obtenerPorFecha(dia, mes, anio);
		} else if (tipo.equals("fecha")) {
			int dia = getIntent().getIntExtra("dia", 0);
			int mes = getIntent().getIntExtra("mes", 0);
			int anio = getIntent().getIntExtra("anio", 0);
			Toast.makeText(this, "Fecha " + dia + "/" + mes + "/" + anio, Toast.LENGTH_LONG).show();
			listaPuntos = db.obtenerPorFecha(dia, mes, anio);
		} else if (tipo.equals("intervalo")) {
			int diaInicio = getIntent().getIntExtra("diaInicio", 0);
			int mesInicio = getIntent().getIntExtra("mesInicio", 0);
			int anioInicio = getIntent().getIntExtra("anioInicio", 0);
			int horaInicio = getIntent().getIntExtra("horaInicio", 0);
			int minutoInicio = getIntent().getIntExtra("minutoInicio", 0);

			int diaFin = getIntent().getIntExtra("diaFin", 0);
			int mesFin = getIntent().getIntExtra("mesFin", 0);
			int anioFin = getIntent().getIntExtra("anioFin", 0);
			int horaFin = getIntent().getIntExtra("horaFin", 0);
			int minutoFin = getIntent().getIntExtra("minutoFin", 0);

			/*
			String fecha = diaInicio + "/" + mesInicio + "/" + anioInicio + " " + horaInicio + ":" + minutoInicio;
			String fecha2 = diaFin + "/" + mesFin + "/" + anioFin + " " + horaFin + ":" + minutoFin;
			Toast.makeText(this, "Intervalo: " + fecha + " --- " + fecha2, Toast.LENGTH_LONG).show();
			*/
			
			Calendar calendarioInicio = Calendar.getInstance();
			Calendar calendarioFin = Calendar.getInstance();
			calendarioInicio.set(anioInicio, mesInicio, diaInicio, horaInicio, minutoInicio);
			calendarioFin.set(anioFin, mesFin, diaFin, horaFin, minutoFin);
			
			List<Punto> listaTemporal = db.obtenerTodo();
			listaPuntos = new ArrayList<Punto>();
			for (int i = 0; i < listaTemporal.size(); i++) {
				Calendar calendario = Calendar.getInstance();
				String fecha = listaTemporal.get(i).getFecha();
				String horas = listaTemporal.get(i).getHora();
				int dia = Integer.parseInt(fecha.substring(0, 2));
				int mes = Integer.parseInt(fecha.substring(3, 5));
				int anio = Integer.parseInt(fecha.substring(6, 10));
				int hora = Integer.parseInt(horas.substring(0, 2));
				int minuto = Integer.parseInt(horas.substring(3, 5));
				calendario.set(anio, mes, dia, hora, minuto);
				if (calendario.after(calendarioInicio) && calendario.before(calendarioFin)) {
					listaPuntos.add(listaTemporal.get(i));
				}
				
			}
			
		} else if (tipo.equals("todo")) {
			Toast.makeText(this, "Todo", Toast.LENGTH_SHORT).show();
			listaPuntos = db.obtenerTodo(); // todo
			
		}

		mapa = (MapView) findViewById(R.id.mapa);
		mapa.setBuiltInZoomControls(true);
		mapa.setSatellite(false);
		controladorMapa = mapa.getController();

		
		
		int ultimoIndex = listaPuntos.size() - 1;

		if (listaPuntos.size() > 0) {
			GeoPoint geoPoint = new GeoPoint(listaPuntos.get(ultimoIndex).getLatitud(), listaPuntos.get(ultimoIndex).getLongitud());
			controladorMapa.animateTo(geoPoint);
			controladorMapa.setZoom(18);
		}

		List<Overlay> capas = mapa.getOverlays();
		Trazo capa1 = new Trazo(listaPuntos);
		capas.add(capa1);

		// Actualizar mapa
		mapa.postInvalidate();
	}

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}

}