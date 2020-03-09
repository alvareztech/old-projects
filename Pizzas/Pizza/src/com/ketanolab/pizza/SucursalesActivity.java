package com.ketanolab.pizza;

import android.app.ListActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

public class SucursalesActivity extends ListActivity {

	private AdaptadorLista adaptadorLista;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.main);

		adaptadorLista = new AdaptadorLista(this);
		setListAdapter(adaptadorLista);

		adaptadorLista.adicionarItem(R.drawable.ic_action_call, "Centro",
				"Realiza tu pedido");
		adaptadorLista.adicionarItem(R.drawable.ic_action_call, "Cota Cota",
				"Realiza tu pedido");
		adaptadorLista.adicionarItem(R.drawable.ic_action_call, "Sopocachi",
				"Realiza tu pedido");
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		Intent intent = null;
		switch (position) {
		case 0:
			intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:77665544"));
			break;
		case 1:
			intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:77665544"));
			break;
		case 2:
			intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:77665544"));
			break;
		default:
			break;
		}
		startActivity(intent);
	}
}
