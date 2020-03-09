package com.androfony.replyfony.capas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.location.Location;

import com.androfony.replyfony.R;
import com.androfony.replyfony.R.drawable;
import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class YoOverlay extends Overlay {

	private int latitud;
	private int longitud;
	private String tipo;

	public YoOverlay(int latitud, int longitud, String tipo) {
		this.latitud = latitud;
		this.longitud = longitud;
		this.tipo = tipo;
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		Projection proyeccion = mapView.getProjection();
		GeoPoint geoPoint = new GeoPoint(latitud, longitud);

		Point puntoCentro = new Point();
		proyeccion.toPixels(geoPoint, puntoCentro);

		Bitmap bitmap = null;
		if (tipo.equals("yo")) {
			bitmap = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.guia);
		} else if (tipo.equals("trabajo")) {
			bitmap = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.guiawork);
		} else if (tipo.equals("casa")) {
			bitmap = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.guiacasa);
		}

		canvas.drawBitmap(bitmap, puntoCentro.x - bitmap.getWidth(), puntoCentro.y - bitmap.getHeight(), null);

	}

}
