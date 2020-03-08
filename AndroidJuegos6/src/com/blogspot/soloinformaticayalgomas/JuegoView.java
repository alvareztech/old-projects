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

/**
 * JuegoView
 * @author Daniel Alvarez
 */
public class JuegoView extends SurfaceView {

    private Bitmap imagen;
    private List<Sprite> sprites;
    private JuegoLoop juegoLoop;
    private SurfaceHolder holder;

    public JuegoView(Context contexto) {
        super(contexto);
        sprites = new ArrayList<Sprite>();
        juegoLoop = new JuegoLoop(this);
        holder = getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {

            public void surfaceCreated(SurfaceHolder sh) {
            }

            public void surfaceChanged(SurfaceHolder sh, int i, int i1, int i2) {
                juegoLoop.setCorriendo(true);
                juegoLoop.start();
            }

            public void surfaceDestroyed(SurfaceHolder sh) {
            }
        });

        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.mujer);
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        imagen = BitmapFactory.decodeResource(getResources(), R.drawable.hombre);
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));
        sprites.add(new Sprite(this, imagen));

    }

    @Override
    public void onDraw(Canvas canvas) {
        canvas.drawColor(Color.BLACK);
        for (Sprite sprite : sprites) {
            sprite.onDraw(canvas);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            for (Sprite sprite : sprites) {
                if (sprite.esColision(event.getX(), event.getY())) {
                    sprites.remove(sprite);
                    break;
                }
            }
        }

        return true;
    }
}
