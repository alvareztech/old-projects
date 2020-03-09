package com.androfony.replyfony.adapters;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.androfony.replyfony.R;

public class AdaptadorListaConfiguraciones extends BaseAdapter {
	private LayoutInflater inflater;

	private ArrayList<Integer> imagenes;
	private ArrayList<String> titulos;
	private ArrayList<String> subtitulos;
	private Context context;

	public AdaptadorListaConfiguraciones(Context contexto) {
		this.context = contexto;
		inflater = LayoutInflater.from(contexto);
		imagenes = new ArrayList<Integer>();
		titulos = new ArrayList<String>();
		subtitulos = new ArrayList<String>();
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
			convertView = inflater.inflate(R.layout.item_configuracion, null);
			holder = new ViewHolder();
			holder.imagenItem = (ImageView) convertView.findViewById(R.id.imagenItem);
			holder.textoTituloItem = (TextView) convertView.findViewById(R.id.textoTituloItem);
			holder.textoSubtituloItem = (TextView) convertView.findViewById(R.id.textoSubtituloItem);

			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		holder.imagenItem.setImageResource(imagenes.get(position));
		holder.textoTituloItem.setText(titulos.get(position));
		holder.textoSubtituloItem.setText(subtitulos.get(position));

		Typeface t = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Light.ttf");
		holder.textoSubtituloItem.setTypeface(t);
		return convertView;
	}

	static class ViewHolder {
		ImageView imagenItem;
		TextView textoTituloItem;
		TextView textoSubtituloItem;
	}

	public void adicionarItem(int recurso, String titulo, String subtitulo) {
		imagenes.add(recurso);
		titulos.add(titulo);
		subtitulos.add(subtitulo);
		notifyDataSetChanged();
	}

	public void adicionarItem(String titulo, CharSequence subtitulo) {
		titulos.add(titulo);
	}

	public void adicionarItem(String titulo) {
		titulos.add(titulo);
	}

	public void eliminarTodo() {
		titulos.clear();
		notifyDataSetChanged();
	}
	
	public void actualizarSubtitulo(int position) {
	}

	public void eliminar(int posicion) {
		titulos.remove(posicion);
		notifyDataSetChanged();
	}
}
