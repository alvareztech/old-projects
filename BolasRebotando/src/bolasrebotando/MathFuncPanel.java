package bolasrebotando;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.LinkedList;
import java.util.Random;

public class MathFuncPanel extends DBPanel implements KeyListener {

    private LinkedList<Ball> mElementos = new LinkedList<Ball>();

    private boolean mLimpiarFondo = true;

    int ultimoK = 5;

    public MathFuncPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void jbInit() throws Exception {
        this.setLayout(null);
    }

    public void keyTyped(KeyEvent e) {
    }

    LinkedList<Ball> finalizadas = new LinkedList<Ball>();
        
    public void actualizarEstado() {

        boolean fuera = false; 
        
        finalizadas.clear();
        
        for (Ball e : mElementos) {
            e.actualizarEstado();
            if( e.isOutOfArea() )    {
                fuera = true; 
                finalizadas.add(e);
            }
        }
        
        for( Ball e : finalizadas ) {
            mElementos.remove(e);
        }

    }

    public void dibujarBuffer() {

        if (mLimpiarFondo) {
            this.bufferG.clearRect(0, 0, buffer.getWidth(),
                                   buffer.getHeight());
        }

        for (Ball e : mElementos) {
            e.dibujarse(this.bufferG);
        }

    }

    private void iniciarFunc() {

        if (isRunning) {
            return;
        }

        Ball b = new Ball();

        b.setH( this.getHeight() );
    
        b.setArea(this);
        
        mElementos.add(b);

        this.iniciar();

    }

    public Color getRandColor() {
        int r = (int)(Math.random() * 255);
        int g = (int)(Math.random() * 255);
        int b = (int)(Math.random() * 255);
        return new Color(r, g, b);
    }

    void agregarBola() {

        Ball b = new Ball();
        
        b.setH( this.getHeight() );
        
        b.setArea(this);
        
        b.setColor(getRandColor());
        
        Random r = new Random();
        
        b.setVX( ( r.nextDouble() + 0.5 ) * 2 );
        
        b.setK(  ( r.nextDouble() * 0.5 ) + 0.1 );
        
        b.setAY( ( r.nextDouble() * 0.5 ) + 0.1 );
        
        b.setRadioBola( r.nextInt(10) + 2 );
        
        mElementos.add(b);

    }


    void cambiarColores() {
        for (Ball e : mElementos) {
            e.setColor(getRandColor());
        }
    }

    void quitarBola() {
        if (mElementos.size() > 1) {
            mElementos.removeLast();
        }
    }


    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_S:
            {
                iniciarFunc();
                break;
            }
        case KeyEvent.VK_F:
            {
                mLimpiarFondo = !mLimpiarFondo;
                break;
            }
        case KeyEvent.VK_R:
            {
                quitarBola();
                break;
            }
        case KeyEvent.VK_C:
            {
                cambiarColores();
                break;
            }
        case KeyEvent.VK_A:
            {
                agregarBola();
                break;
            }        
        }
    }


    public void keyReleased(KeyEvent e) {
    }
}


