package com.ketanolab.pizza;

import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AdaptadorViewPager extends PagerAdapter {

	private List<String> listaTitulos;
	private List<String> listaSubtitulos;
	private List<Bitmap> listaBitmaps;
	private Context contexto;

	public AdaptadorViewPager(Context contexto, List<String> listaTitulos,
			List<String> listaSubtitulos, List<Bitmap> listaBitmaps) {
		super();
		this.contexto = contexto;
		this.listaTitulos = listaTitulos;
		this.listaSubtitulos = listaSubtitulos;
		this.listaBitmaps = listaBitmaps;
	}

	@Override
	public Object instantiateItem(View collection, int position) {
		RelativeLayout linearLayout = (RelativeLayout) View.inflate(contexto,
				R.layout.producto, null);

		// titulo
		TextView textoTitulo = (TextView) linearLayout
				.findViewById(R.id.titulo_producto);
		textoTitulo.setText(listaTitulos.get(position));
		// Subtitulo
		TextView textoSubtitulo = (TextView) linearLayout
				.findViewById(R.id.subtitulo_producto);
		textoSubtitulo.setText(listaSubtitulos.get(position));
		// Imagen
		ImageView imagen = (ImageView) linearLayout
				.findViewById(R.id.imageView1);
		imagen.setImageBitmap(listaBitmaps.get(position));

		((ViewPager) collection).addView(linearLayout, 0);
		return linearLayout;
	}

	@Override
	public int getCount() {
		return listaTitulos.size();
	}

	@Override
	public boolean isViewFromObject(View view, Object object) {
		return view == ((RelativeLayout) object);
	}

	@Override
	public void destroyItem(View collection, int position, Object view) {
		((ViewPager) collection).removeView((RelativeLayout) view);
	}

	// Ayudante

}
