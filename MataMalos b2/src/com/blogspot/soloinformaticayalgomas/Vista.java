package com.blogspot.soloinformaticayalgomas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.List;

public class Vista extends SurfaceView {

    private List<Sprite> sprites;
    private Animacion animacion;

    public Vista(Context contexto) {
        super(contexto);
        animacion = new Animacion(this);
        sprites = new ArrayList<Sprite>();
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
        Bitmap imagen;
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.bueno1);
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.bueno2);
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.bueno3);
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.bueno4);
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.malo1);
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.malo2);
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.malo3);
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.malo4);
        sprites.add(new Sprite(this, imagen));
    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        for (Sprite sprite : sprites) {
            sprite.pintar(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        synchronized (getHolder()) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                for (int i = sprites.size() - 1; i >= 0; i--) {
                    Sprite sprite = sprites.get(i);
                    if (sprite.esTocado(event.getX(), event.getY())) {
                        sprites.remove(i);
                        break;
                    }
                }
            }
        }
        return true;
    }
}
