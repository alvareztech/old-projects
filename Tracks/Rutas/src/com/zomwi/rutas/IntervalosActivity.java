package com.zomwi.rutas;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class IntervalosActivity extends FragmentActivity {

	public static Button botonFechaInicio;
	public static Button botonHoraInicio;
	public static Button botonFechaFin;
	public static Button botonHoraFin;

	public static int diaInicio = 1;
	public static int mesInicio = 0;
	public static int anioInicio = 2012;
	public static int horaInicio = 24;
	public static int minutoInicio = 59;

	public static int diaFin = 1;
	public static int mesFin = 0;
	public static int anioFin = 2012;
	public static int horaFin = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
	public static int minutoFin = Calendar.getInstance().get(Calendar.MINUTE);

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intervalos);

		botonFechaInicio = (Button) findViewById(R.id.botonFechaInicio);
		botonHoraInicio = (Button) findViewById(R.id.botonHoraInicio);
		botonFechaFin = (Button) findViewById(R.id.botonFechaFin);
		botonHoraFin = (Button) findViewById(R.id.botonHoraFin);
	}

	public void abrirDialogoFechaInicio(View view) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "datePickerInicio");
	}

	public void abrirDialogoFechaFin(View view) {
		DialogFragment newFragment = new DatePickerFragment();
		newFragment.show(getSupportFragmentManager(), "datePickerFin");
	}

	public void abrirDialogoHoraInicio(View view) {
		DialogFragment newFragment = new TimePickerFragment();
		newFragment.show(getSupportFragmentManager(), "timePickerInicio");
	}

	public void abrirDialogoHoraFin(View view) {
		DialogFragment newFragment = new TimePickerFragment();
		newFragment.show(getSupportFragmentManager(), "timePickerFin");
	}

	public static class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar c = Calendar.getInstance();
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);

			return new TimePickerDialog(getActivity(), this, hour, minute, DateFormat.is24HourFormat(getActivity()));
		}

		public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
			if (getTag().equals("timePickerInicio")) {
				botonHoraInicio.setText(hourOfDay + ":" + minute);
				horaInicio = hourOfDay;
				minutoInicio = minute;
			} else if (getTag().equals("timePickerFin")) {
				botonHoraFin.setText(hourOfDay + ":" + minute);
				horaFin = hourOfDay;
				minutoFin = minute;
			}
		}
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
			if (getTag().equals("datePickerInicio")) {
				botonFechaInicio.setText(day + "/" + (month + 1) + "/" + year);
				diaInicio = day;
				mesInicio = month;
				anioInicio = year;
			} else if (getTag().equals("datePickerFin")) {
				botonFechaFin.setText(day + "/" + (month + 1) + "/" + year);
				diaFin = day;
				mesFin = month;
				anioFin = year;
			}
		}
	}

	public void mostrarMapa(View view) {
		Intent intentMapa = new Intent(this, MapaActivity.class);
		intentMapa.putExtra("tipo", "intervalo");
		intentMapa.putExtra("diaInicio", diaInicio);
		intentMapa.putExtra("mesInicio", mesInicio);
		intentMapa.putExtra("anioInicio", anioInicio);
		intentMapa.putExtra("horaInicio", horaInicio);
		intentMapa.putExtra("minutoInicio", minutoInicio);

		intentMapa.putExtra("diaFin", diaFin);
		intentMapa.putExtra("mesFin", mesFin);
		intentMapa.putExtra("anioFin", anioFin);
		intentMapa.putExtra("horaFin", horaFin);
		intentMapa.putExtra("minutoFin", minutoFin);
		
		startActivity(intentMapa);
	}

}
