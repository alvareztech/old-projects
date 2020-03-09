package com.zomwi.rutas;

import java.util.List;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.Projection;
import com.zomwi.rutas.db.Punto;

public class Trazo extends Overlay {

	private List<Punto> listaPuntos;

	public Trazo(List<Punto> listaPuntos) {
		super();
		this.listaPuntos = listaPuntos;
	}

	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {
		super.draw(canvas, mapView, shadow);

		Projection projection = mapView.getProjection();

		// if (shadow == false)
		Paint paint = new Paint();
		paint.setColor(Color.RED);

		if (listaPuntos.size() != 0) {
			Point inicial = new Point();
			GeoPoint geoPoint2 = new GeoPoint(listaPuntos.get(0).getLatitud(), listaPuntos.get(0).getLongitud());
			projection.toPixels(geoPoint2, inicial);

			GeoPoint geoPoint;

			// Para el primero
			geoPoint = new GeoPoint(listaPuntos.get(0).getLatitud(), listaPuntos.get(0).getLongitud());
			Point centro = new Point();
			projection.toPixels(geoPoint, centro);
			canvas.drawCircle(centro.x, centro.y, 7, paint);
			canvas.drawText("Inicio", centro.x + 10, centro.y + 5, paint);
			canvas.drawLine(inicial.x, inicial.y, centro.x, centro.y, paint);
			inicial.x = centro.x;
			inicial.y = centro.y;

			paint.setColor(Color.BLUE);
			int i = 1;
			for (i = 1; i < listaPuntos.size() - 1; i++) {
				geoPoint = new GeoPoint(listaPuntos.get(i).getLatitud(), listaPuntos.get(i).getLongitud());
				centro = new Point();
				projection.toPixels(geoPoint, centro);
				canvas.drawCircle(centro.x, centro.y, 5, paint);
				canvas.drawText(listaPuntos.get(i).getHora(), centro.x + 10, centro.y + 5, paint);
				canvas.drawLine(inicial.x, inicial.y, centro.x, centro.y, paint);
				inicial.x = centro.x;
				inicial.y = centro.y;
			}
			paint.setColor(Color.RED);
			// Para el ultimo
			geoPoint = new GeoPoint(listaPuntos.get(i).getLatitud(), listaPuntos.get(i).getLongitud());
			centro = new Point();
			projection.toPixels(geoPoint, centro);
			canvas.drawCircle(centro.x, centro.y, 7, paint);
			canvas.drawText("Fin", centro.x + 10, centro.y + 5, paint);
			canvas.drawLine(inicial.x, inicial.y, centro.x, centro.y, paint);
		}

		// canvas.drawText("La Paz", centro.x + 10, centro.y + 5, p);

	}
}
