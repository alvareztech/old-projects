package com.ketanolab.pizza;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class DashboardActivity extends Activity {
	private Button boton1;
	private Button boton2;
	private Button boton3;
	private Button boton4;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.dashboard);
		boton1 = (Button) findViewById(R.id.boton1_inicio);
		boton2 = (Button) findViewById(R.id.boton2_inicio);
		boton3 = (Button) findViewById(R.id.boton3_inicio);
		boton4 = (Button) findViewById(R.id.boton4_inicio);
	}

	public void pedir(View view) {
		Intent intent = new Intent(this, SucursalesActivity.class);
		startActivity(intent);
	}

	public void verCarta(View view) {
		Intent intent = new Intent(this, ProductosActivity.class);
		startActivity(intent);
	}

	public void localizar(View view) {
		Intent intent = new Intent(this, MapaActivity.class);
		startActivity(intent);
	}

	public void obtenerPromocion(View view) {

		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
		startActivityForResult(intent, 0);

	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
		if (requestCode == 0) {
			if (resultCode == RESULT_OK) {
				String contents = intent.getStringExtra("SCAN_RESULT");
				//Toast.makeText(DashboardActivity.this, contents, Toast.LENGTH_LONG).show();
				Intent i = new Intent(this, OfertaActivity.class);
				i.putExtra("texto", contents);
				startActivity(i);
				
			} else if (resultCode == RESULT_CANCELED) {
			}
		}
	}

}
