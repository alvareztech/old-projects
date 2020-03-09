package com.ketanolab.pizza;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

public class OfertaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.oferta);
		
		Bundle bundle = getIntent().getExtras();
		TextView textView  = (TextView) findViewById(R.id.texto);
		textView.setText(bundle.getString("texto"));
	}

}
