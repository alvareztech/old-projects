package com.ketanolab.pizza;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ListView;

public class PrincipalActivity extends ListActivity {

	private AdaptadorLista adaptadorLista;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		adaptadorLista = new AdaptadorLista(this);
		setListAdapter(adaptadorLista);

		adaptadorLista.adicionarItem(R.drawable.ic_action_edit, "Hacer pedido",
				"Realiza tu pedido");
		adaptadorLista.adicionarItem(R.drawable.ic_action_paste, "Ver carta",
				"Ve nuestra ofertas");
		adaptadorLista.adicionarItem(R.drawable.ic_action_locate,
				"Lozalizar restaurante", "Disfruta donde quieras");
		adaptadorLista.adicionarItem(R.drawable.ic_action_photo,
				"Con c'odigo QR", "Captura promociones");
		
		
		ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) getListView().getLayoutParams();

		mlp.setMargins(10, 10, 10, 10);
		
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(this, SucursalesActivity.class);
			break;
		case 1:
			intent = new Intent(this, ProductosActivity.class);
			break;
		case 2:
			intent = new Intent(this, MapaActivity.class);
			break;
		case 3:

			break;
		}
		
		startActivity(intent);
	}

}