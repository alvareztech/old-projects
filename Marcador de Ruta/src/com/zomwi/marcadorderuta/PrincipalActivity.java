package com.zomwi.marcadorderuta;

import java.util.Calendar;

import android.app.AlarmManager;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import com.zomwi.marcadorderuta.adapters.AdaptadorLista;
import com.zomwi.marcadorderuta.db.AdaptadorDB;

public class PrincipalActivity extends FragmentActivity {

	private AdaptadorLista adaptadorLista;
	private AdaptadorDB baseDeDatos;

	private ListView lista;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_principal);

		lista = (ListView) findViewById(R.id.lista);
		adaptadorLista = new AdaptadorLista(this);
		lista.setAdapter(adaptadorLista);
		lista.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> arg0, View v, int position, long arg3) {
				switch (position) {
				case 0:
					empezar(v);
					break;
				case 1:
					Intent intent = new Intent(getApplicationContext(), ContenidoActivity.class);
					startActivity(intent);
					break;
				case 2:
					mostrarMapa(v);
					break;
				case 3:
					showDatePickerDialog(v);
					break;

				}
			}
		});

		baseDeDatos = new AdaptadorDB(getApplicationContext());
		baseDeDatos.abrir();

		adaptadorLista.adicionarItem(android.R.drawable.ic_input_get, "Iniciar", "Guardar puntos de localización");
		adaptadorLista.adicionarItem(android.R.drawable.ic_dialog_info, "Ver base de datos", "Mostrar la base de datos con los puntos");
		adaptadorLista.adicionarItem(android.R.drawable.ic_dialog_map, "Mostrar mapa", "Visualizar mapa con los puntos");
		adaptadorLista.adicionarItem(android.R.drawable.ic_dialog_map, "Mostrar mapa por fecha", "Visualizar mapa con los puntos");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_principal, menu);
		return true;
	}

	public void empezar(View view) {
		Intent intent = new Intent(getApplicationContext(), Cronometro.class);
		PendingIntent pi = PendingIntent.getBroadcast(getApplicationContext(), 0, intent, 0);
		AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);
		am.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + (1 * 1000), pi);
		Toast.makeText(this, "Cronometro colocada", Toast.LENGTH_SHORT).show();
	}

	public void actualizar(View view) {
		baseDeDatos.cargar(adaptadorLista);
	}

	public void mostrarMapa(View view) {
		Intent intent = new Intent(getApplicationContext(), MapaActivity.class);
		startActivity(intent);
	}

	public void showDatePickerDialog(View v) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "datePicker");
	}

	public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);

			return new DatePickerDialog(getActivity(), this, year, month, day);
		}

		public void onDateSet(DatePicker view, int year, int month, int day) {
			Intent intent = new Intent(getActivity(), MapaActivity.class);
			startActivity(intent);
		}
	}
}
