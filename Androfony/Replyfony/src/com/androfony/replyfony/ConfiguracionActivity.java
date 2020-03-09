package com.androfony.replyfony;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

import com.androfony.replyfony.adapters.AdaptadorListaConfiguraciones;
import com.androfony.replyfony.servicios.ElServicio;

public class ConfiguracionActivity extends Activity implements OnItemClickListener {

	// private MapView mapa;

	private ListView lista;
	private AdaptadorListaConfiguraciones adaptadorLista;

	private CheckBox checkBox;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_configuracion);

		lista = (ListView) findViewById(R.id.lista);

		adaptadorLista = new AdaptadorListaConfiguraciones(this);

		lista.setAdapter(adaptadorLista);
		lista.setOnItemClickListener(this);

		checkBox = (CheckBox) findViewById(R.id.checkBox);
	
		startService(new Intent(this, ElServicio.class));
	
	}
	

	@Override
	protected void onStart() {
		super.onStart();
		SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
		int latitudCasa = settings.getInt("latitudCasa", 0);
		int longitudCasa = settings.getInt("longitudCasa", 0);
		int latitudEducacion = settings.getInt("latitudEducacion", 0);
		int longitudEducacion = settings.getInt("longitudEducacion", 0);
		int latitudTrabajo = settings.getInt("latitudTrabajo", 0);
		int longitudTrabajo = settings.getInt("longitudTrabajo", 0);

		boolean estadoServicio = settings.getBoolean("estadoServicio", false);
		if (estadoServicio) {
			checkBox.setChecked(true);
		} else {
			checkBox.setChecked(false);
		}

		adaptadorLista.eliminarTodo();
		adaptadorLista.adicionarItem(R.drawable.ic_action_persona, "Sexo", "Masculino");
		adaptadorLista.adicionarItem(R.drawable.ic_action_persona, "Hogar", latitudCasa + ", " + longitudCasa);
		adaptadorLista.adicionarItem(R.drawable.ic_action_persona, "Lugar de Estudio", latitudEducacion + ", "
				+ longitudEducacion);
		adaptadorLista.adicionarItem(R.drawable.ic_action_persona, "Lugar de Trabajo", latitudTrabajo + ", "
				+ longitudTrabajo);

	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View view, int position, long arg3) {
		switch (position) {
		case 0:

			break;
		case 1:
			Intent intentCasa = new Intent(this, LocalizarActivity.class);
			intentCasa.putExtra("tipo", "casa");
			startActivity(intentCasa);
			finish();
			break;
		case 2:
			Intent intentEducacion = new Intent(this, LocalizarActivity.class);
			intentEducacion.putExtra("tipo", "educacion");
			startActivity(intentEducacion);
			finish();
			break;
		case 3:
			Intent intentTrabajo = new Intent(this, LocalizarActivity.class);
			intentTrabajo.putExtra("tipo", "trabajo");
			startActivity(intentTrabajo);
			finish();
			break;
		case 4:

			break;

		}
	}

	public void activarServicio(View view) {
		if (checkBox.isChecked()) {
			stopService(new Intent(this, ElServicio.class));

			Toast.makeText(this, "Se desactivo el servicio.", Toast.LENGTH_SHORT).show();
			SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putBoolean("estadoServicio", false);
			editor.commit();
		} else {
			startService(new Intent(this, ElServicio.class));
			Toast.makeText(this, "Se activo el servicio.", Toast.LENGTH_SHORT).show();
			
			SharedPreferences settings = getSharedPreferences("MisPreferencias", 0);
			SharedPreferences.Editor editor = settings.edit();
			editor.putBoolean("estadoServicio", true);
			editor.commit();
		}

	}
}
