package com.blogspot.soloinformaticayalgomas;

import android.graphics.Canvas;

/**
 *
 * @author Daniel Alvarez
 */
public class JuegoLoop extends Thread {

    private JuegoView vista;
    private boolean corriendo;
    public final long FPS = 10;

    public JuegoLoop(JuegoView vista) {
        this.vista = vista;
        this.corriendo = false;
    }

    public boolean isCorriendo() {
        return corriendo;
    }

    public void setCorriendo(boolean corriendo) {
        this.corriendo = corriendo;
    }

    @Override
    public void run() {
        long ticksPS = 1000 / FPS;
        long tiempoInicio;
        long tiempoDormido;
        while (corriendo) {
            Canvas c = null;
            tiempoInicio = System.currentTimeMillis();
            try {
                c = vista.getHolder().lockCanvas();
                synchronized (vista.getHolder()) {
                    vista.onDraw(c);
                }
            } finally {
                if (c != null) {
                    vista.getHolder().unlockCanvasAndPost(c);
                }
            }
            tiempoDormido = ticksPS - (System.currentTimeMillis() - tiempoInicio);
            try {
                if (tiempoDormido > 0) {
                    sleep(tiempoDormido);
                } else {
                    sleep(10);
                }
            } catch (Exception e) {
            }
        }
    }
}
