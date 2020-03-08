package com.blogspot.soloinformaticayalgomas;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import java.util.List;

public class SpriteTemporal {

    private float x;
    private float y;
    private Bitmap imagen;
    private int life = 15;
    private List<SpriteTemporal> temps;

    public SpriteTemporal(List<SpriteTemporal> temps, Vista vista, float x, float y, Bitmap imagen) {
        this.x = Math.min(Math.max(x - imagen.getWidth() / 2, 0), vista.getWidth() - imagen.getWidth());
        this.y = Math.min(Math.max(y - imagen.getHeight() / 2, 0), vista.getHeight() - imagen.getHeight());
        this.imagen = imagen;
        this.temps = temps;
    }

    public void pintar(Canvas canvas) {
        life--;
        if (life < 1) {
            temps.remove(this);
        }
        canvas.drawBitmap(imagen, x, y, null);
    }
}
