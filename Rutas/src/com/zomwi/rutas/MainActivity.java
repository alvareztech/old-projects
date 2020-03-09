package com.zomwi.rutas;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.Dialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;

import com.zomwi.rutas.adaptadores.AdaptadorLista;

public class MainActivity extends ListActivity {

	private AdaptadorLista adaptadorLista;
	private Dialog dialogoFecha;
	private Dialog dialogoIntervalo;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		adaptadorLista = new AdaptadorLista(this);
		setListAdapter(adaptadorLista);
		adicionarItemsLista();
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			if (estaMiServicioEjecutandose()) {
				Intent intentDetener = new Intent(this, Servicio.class);
				stopService(intentDetener);
			} else {
				Intent intentIniciar = new Intent(this, Servicio.class);
				startService(intentIniciar);
			}
			adaptadorLista.eliminarTodo();
			adicionarItemsLista();
			break;
		case 1:
			Intent intent = new Intent(this, PuntosActivity.class);
			startActivity(intent);
			break;
		case 2:
			Intent intentMapaFecha = new Intent(this, TipoIntervaloActivity.class);
			startActivity(intentMapaFecha);
			break;
		}

	}

	public void adicionarItemsLista() {
		if (estaMiServicioEjecutandose()) {
			adaptadorLista.adicionarItem(android.R.drawable.ic_media_pause, "Detener",
					"El servicio esta ejecutandose en segundo plano, esta obteniendo puntos geográficos.");
		} else {
			adaptadorLista.adicionarItem(android.R.drawable.ic_media_play, "Iniciar",
					"Iniciar el servicio para la obtención de puntos geográficos.");
		}
		adaptadorLista.adicionarItem(android.R.drawable.ic_dialog_info, "Mostrar todos los puntos",
				"Todos los puntos almacenados en la base de datos.");
		adaptadorLista.adicionarItem(android.R.drawable.ic_dialog_map, "Mostrar mapa", "Mapa con los puntos y trazos del recorrido.");

		// adaptadorLista.adicionarItem(android.R.drawable.ic_dialog_map,
		// "Mostrar mapa por intervalo de fechas",
		// "Mapa con los puntos y trazos del recorrido.");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	private boolean estaMiServicioEjecutandose() {
		ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
		for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
			if ("com.zomwi.rutas.Servicio".equals(service.service.getClassName())) {
				return true;
			}
		}
		return false;
	}

}
