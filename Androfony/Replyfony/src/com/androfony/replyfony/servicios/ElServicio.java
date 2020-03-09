package com.androfony.replyfony.servicios;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.os.Vibrator;
import android.widget.Toast;

import com.androfony.replyfony.MainActivity;

public class ElServicio extends Service implements SensorEventListener {
	private long ultimaActualizacion = -1;
	private float ejeX=0, ejeY=0, ejeZ=0;
	private int cantDerecha = 0;
	private Vibrator v;

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	@Override
	public void onCreate() {
		SensorManager sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
		sm.registerListener((SensorEventListener) this,
				sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
				sm.SENSOR_DELAY_NORMAL);
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		Toast.makeText(this, "Servicio Detenido", Toast.LENGTH_LONG).show();
	}
	@Override
	public void onStart(Intent intent, int startid) {
	}
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
	}
	public void onSensorChanged(SensorEvent event) {
		long curTime = System.currentTimeMillis();
		if ((curTime - ultimaActualizacion) > 50) {
			long diffTime = (curTime - ultimaActualizacion);
			ultimaActualizacion = curTime;
			ejeX = event.values[0];
			ejeY = event.values[1];
			ejeZ = event.values[2];
			if (Round(ejeX, 4) > 10.0000) {
				/*Toast.makeText(this, "Sacudida a la derecha detectada",
						Toast.LENGTH_SHORT).show();*/
			} else if (Round(ejeX, 4) < -10.0000) {
				/*Toast.makeText(this, "Sacudida a la izquierda detectada",
						Toast.LENGTH_SHORT).show();*/
				if (cantDerecha == 2) {
					v = (Vibrator) getSystemService("vibrator");
					this.v.vibrate(500);
					Intent i = new Intent(getBaseContext(),
							MainActivity.class);
					i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					getApplication().startActivity(i);
					cantDerecha = 0;
				} else {
					if (cantDerecha > 3) {
						cantDerecha = 0;
					} else {
						cantDerecha = cantDerecha + 1;
					}
				}
			}
		}
	}
	public static float Round(float Rval, int Rpl) {
		float p = (float) Math.pow(10, Rpl);
		Rval = Rval * p;
		float tmp = Math.round(Rval);
		return (float) tmp / p;
	}
}