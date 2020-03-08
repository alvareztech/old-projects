package com.blogspot.soloinformaticayalgomas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class Vista extends SurfaceView {

    private Sprite sprite;
    private Animacion animacion;

    public Vista(Context contexto) {
        super(contexto);
        animacion = new Animacion(this);
        SurfaceHolder holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            public void surfaceCreated(SurfaceHolder sh) {
                crearSprites();
                animacion.setCorriendo(true);
                animacion.start();
            }

            public void surfaceChanged(SurfaceHolder sh, int i, int i1, int i2) {
            }

            public void surfaceDestroyed(SurfaceHolder sh) {
            }
        });
    }

    private void crearSprites() {
        Bitmap imagen = BitmapFactory.decodeResource(getResources(), R.drawable.bueno1);
        sprite = new Sprite(this, imagen);
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        sprite.pintar(canvas);
    }
}
