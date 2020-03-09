package com.ketanolab.pizza;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ListView;
import android.widget.Toast;

public class ProductosActivity extends Activity {

	private ViewPager viewPager;
	private AdaptadorViewPager adaptadorViewPager;
	// Carrito
	private Dialog dialogoCarrito;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.productos);

		viewPager = (ViewPager) findViewById(R.id.viewPager);

		List<String> listaTitulos = new ArrayList<String>();
		List<String> listaSubtitulos = new ArrayList<String>();
		List<Bitmap> listaBitmaps = new ArrayList<Bitmap>();
		listaTitulos.add("Pizza Hawaiana");
		listaTitulos.add("Pizza Jamon y Queso");
		listaTitulos.add("Pizza Mozarela");
		listaTitulos.add("Pizza Jamon y Queso");
		listaSubtitulos
				.add("Contiene las mejores ingredientes de la ciudad, etc.");
		// listaSubtitulos.add("El mejor queso de la ciudad, y el mejor jamon.");
		listaSubtitulos.add("El mejor.");
		listaSubtitulos
				.add("Una pizza con sabor exquisito para degustarlo con la familia");
		listaSubtitulos.add("El mejor.");
		listaBitmaps.add(obtenerBitmapDeAsset("pizza1.png"));
		listaBitmaps.add(obtenerBitmapDeAsset("pizza2.png"));
		listaBitmaps.add(obtenerBitmapDeAsset("pizza3.png"));
		listaBitmaps.add(obtenerBitmapDeAsset("pizza2.png"));

		adaptadorViewPager = new AdaptadorViewPager(this, listaTitulos,
				listaSubtitulos, listaBitmaps);

		viewPager.setAdapter(adaptadorViewPager);

		// Dialogo Carrito
		dialogoCarrito = new Dialog(this);
		dialogoCarrito.setContentView(R.layout.carrito);
		dialogoCarrito.setTitle("Carrito de compras");
		dialogoCarrito.getWindow().setLayout(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);
	}

	private Bitmap obtenerBitmapDeAsset(String strName) {
		Bitmap bitmap = null;
		AssetManager assetManager = getAssets();
		InputStream istr;
		try {
			istr = assetManager.open(strName);
			bitmap = BitmapFactory.decodeStream(istr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return bitmap;
	}

	public void abrirCarrito(View view) {
		dialogoCarrito.show();

		ListView listaCarrito = (ListView) dialogoCarrito
				.findViewById(R.id.lista_carrito);
		AdaptadorLista adaptadorLista = new AdaptadorLista(this);
		listaCarrito.setAdapter(adaptadorLista);
		adaptadorLista.adicionarItem("Pizza Mozarela", "Tamaño pequeño");
		adaptadorLista.adicionarItem("Pizza Jamon y queso", "Tamaño grande");
		adaptadorLista.adicionarItem("Pizza Jamon y queso", "Tamaño mediana");
	}

	public void adicionarCarrito(View view) {
		final CharSequence[] items = { "Pequeña", "Mediana", "Grande" };

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Seleccione el tamaño");
		builder.setSingleChoiceItems(items, -1,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int item) {
						Toast.makeText(getApplicationContext(), "Usted selecciono una pizza " + items[item],
								Toast.LENGTH_SHORT).show();
						dialog.dismiss();
					}
				});
		AlertDialog alert = builder.create();
		alert.show();
	}

}
