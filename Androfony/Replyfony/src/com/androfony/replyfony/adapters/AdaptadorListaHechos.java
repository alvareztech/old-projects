package com.androfony.replyfony.adapters;

import java.util.ArrayList;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androfony.replyfony.R;

public class AdaptadorListaHechos extends BaseAdapter {
	private LayoutInflater inflater;

	private ArrayList<Integer> imagenes;
	private ArrayList<String> titulos;
	private Context context;

	public AdaptadorListaHechos(Context contexto) {
		this.context = contexto;
		inflater = LayoutInflater.from(contexto);
		imagenes = new ArrayList<Integer>();
		titulos = new ArrayList<String>();
	}

	public int getCount() {
		return titulos.size();
	}

	public Object getItem(int position) {
		return position;
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.item_hecho, null);
			holder = new ViewHolder();
			holder.imagenItem = (ImageView) convertView.findViewById(R.id.imagenHechoItem);
			holder.textoTituloItem = (TextView) convertView.findViewById(R.id.textoHechoItem);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.imagenItem.setImageResource(imagenes.get(position));
		holder.textoTituloItem.setText(titulos.get(position));

		Typeface t = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
		holder.textoTituloItem.setTypeface(t);
		return convertView;
	}

	static class ViewHolder {
		ImageView imagenItem;
		TextView textoTituloItem;
	}

	public void adicionarItem(int recurso, String titulo) {
		imagenes.add(recurso);
		titulos.add(titulo);
		notifyDataSetChanged();
	}

	public void eliminarTodo() {
		titulos.clear();
		notifyDataSetChanged();
	}

	public void eliminar(int posicion) {
		titulos.remove(posicion);
		notifyDataSetChanged();
	}
}
