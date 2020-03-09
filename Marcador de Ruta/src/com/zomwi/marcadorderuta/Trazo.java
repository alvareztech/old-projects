package com.zomwi.marcadorderuta;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;

public class Trazo extends Overlay {

	private List<String> listaLatitudes;
	private List<String> listaLongitudes;

	public Trazo(List<String> listaLatitudes, List<String> listaLongitudes) {
		super();
		this.listaLatitudes = listaLatitudes;
		this.listaLongitudes = listaLongitudes;
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);

		Projection projection = mapView.getProjection();

		if (shadow == false) {
			
			Paint paint = new Paint();
			paint.setColor(Color.BLUE);

			Point inicial = new Point();
			GeoPoint geoPoint2 = new GeoPoint(Integer.parseInt(listaLatitudes.get(0)), Integer.parseInt(listaLongitudes.get(0)));
			projection.toPixels(geoPoint2, inicial);
			for (int i = 0; i < listaLatitudes.size(); i++) {
				GeoPoint geoPoint = new GeoPoint(Integer.parseInt(listaLatitudes.get(i)), Integer.parseInt(listaLongitudes.get(i)));
				Point centro = new Point();
				projection.toPixels(geoPoint, centro);
				canvas.drawCircle(centro.x, centro.y, 5, paint);
				canvas.drawLine(inicial.x, inicial.y, centro.x, centro.y, paint);
				//cambio
				inicial.x = centro.x;
				inicial.y = centro.y;
			}

			// canvas.drawText("La Paz", centro.x + 10, centro.y + 5, p);

		}
	}

}
