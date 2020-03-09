package com.zomwi.rutas;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.DatePicker;
import android.widget.ListView;

import com.zomwi.rutas.adaptadores.AdaptadorLista;

public class TipoIntervaloActivity extends FragmentActivity {

	private AdaptadorLista adaptadorLista;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tipo_intervalo);

		adaptadorLista = new AdaptadorLista(this);
		ListView lista = (ListView) findViewById(R.id.lista);
		lista.setAdapter(adaptadorLista);
		adicionarItemsLista();
		lista.setOnItemClickListener(oyenteLista);
	}

	private void adicionarItemsLista() {
		adaptadorLista.adicionarItem(android.R.drawable.ic_menu_today, "Hoy", "Mostrar la ruta del dia de hoy.");
		adaptadorLista.adicionarItem(android.R.drawable.ic_menu_week, "Ayer", "Mostrar la ruta del dia de ayer.");
		adaptadorLista.adicionarItem(android.R.drawable.ic_menu_month, "Fecha", "Mostrar la ruta dada una fecha especifica.");
		adaptadorLista.adicionarItem(android.R.drawable.ic_menu_agenda, "Intervalo",
				"Mostrar la ruta de un intervalo de fechas con horas especificas.");
		adaptadorLista.adicionarItem(android.R.drawable.ic_menu_more, "Todos", "Mostrar todos los puntos almacenados en la base de datos.");

	}

	OnItemClickListener oyenteLista = new OnItemClickListener() {

		public void onItemClick(AdapterView<?> l, View v, int position, long id) {
			switch (position) {
			case 0:
				Intent intentHoy = new Intent(TipoIntervaloActivity.this, MapaActivity.class);
				intentHoy.putExtra("tipo", "hoy");
				Calendar calendario = Calendar.getInstance();
				int anio = calendario.get(Calendar.YEAR);
				int mes = calendario.get(Calendar.MONTH);
				int dia = calendario.get(Calendar.DAY_OF_MONTH);
				intentHoy.putExtra("dia", dia);
				intentHoy.putExtra("mes", mes);
				intentHoy.putExtra("anio", anio);
				startActivity(intentHoy);
				break;
			case 1:
				Intent intentAyer = new Intent(TipoIntervaloActivity.this, MapaActivity.class);
				intentAyer.putExtra("tipo", "ayer");
				Calendar calendarioAyer = Calendar.getInstance();
				calendarioAyer.add(Calendar.DAY_OF_MONTH, -1);
				int anioAyer = calendarioAyer.get(Calendar.YEAR);
				int mesAyer = calendarioAyer.get(Calendar.MONTH);
				int diaAyer = calendarioAyer.get(Calendar.DAY_OF_MONTH);
				intentAyer.putExtra("dia", diaAyer);
				intentAyer.putExtra("mes", mesAyer);
				intentAyer.putExtra("anio", anioAyer);
				startActivity(intentAyer);
				break;
			case 2:
				DialogFragment newFragment = new DatePickerFragment();
				newFragment.show(getSupportFragmentManager(), "datePicker");
				break;
			case 3:
				Intent intentIntervalo = new Intent(TipoIntervaloActivity.this, IntervalosActivity.class);
				startActivity(intentIntervalo);
				break;
			case 4:
				Intent intentTodo = new Intent(TipoIntervaloActivity.this, MapaActivity.class);
				intentTodo.putExtra("tipo", "todo");
				startActivity(intentTodo);
				break;
			}

		}
	};

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
			Intent intentFecha = new Intent(getActivity(), MapaActivity.class);
			intentFecha.putExtra("tipo", "fecha");
			intentFecha.putExtra("dia", day);
			intentFecha.putExtra("mes", month);
			intentFecha.putExtra("anio", year);
			startActivity(intentFecha);
		}
	}

}
