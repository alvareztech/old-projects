package com.androfony.replyfony.capas;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

import com.androfony.replyfony.R;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;

public class CentroOverlay extends Overlay {
	@Override
	public void draw(Canvas canvas, MapView mapView, boolean shadow) {

		Bitmap bitmap = BitmapFactory.decodeResource(mapView.getResources(), R.drawable.ic_action_lugar);

		canvas.drawBitmap(bitmap, mapView.getWidth() / 2, mapView.getHeight() / 2 - bitmap.getHeight(), null);

	}
}
