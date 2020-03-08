package ejemplojuego;

import java.awt.*;
import javax.swing.*;

public class Demo1 extends JComponent {

    private final static int ANCHO = 512;
    private final static int ALTO = 384;
    private final static int DIAMETRO = 40;
    private float x, y;
    private float vx, vy;

    public Demo1() {
        setPreferredSize(new Dimension(ANCHO, ALTO));
        x = 10;
        y = 20;
        vx = 300;
        vy = 400;
    }

    private void fisica(float dt) {
        x += vx * dt;
        y += vy * dt;
        if (vx < 0 && x <= 0 || vx > 0 && x + DIAMETRO >= ANCHO) {
            vx = -vx;
        }
        if (vy < 0 && y < 0 || vy > 0 && y + DIAMETRO >= ALTO) {
            vy = -vy;
        }
    }

    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, ANCHO, ALTO);
        g.setColor(Color.RED);
        g.fillOval(Math.round(x), Math.round(y), DIAMETRO, DIAMETRO);
    }

    private void dibuja() throws Exception {
        SwingUtilities.invokeAndWait(new Runnable() {

            public void run() {
                paintImmediately(0, 0, ANCHO, ALTO);
            }
        });
    }

    public void cicloPrincipalJuego() throws Exception {
        long tiempoViejo = System.nanoTime();
        while (true) {
            long tiempoNuevo = System.nanoTime();
            float dt = (tiempoNuevo - tiempoViejo) / 1000000000f;
            tiempoViejo = tiempoNuevo;
            fisica(dt);
            dibuja();
        }
    }

    public static void main(String[] args) throws Exception {
        JFrame jf = new JFrame("Demo1");
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setResizable(false);
        Demo1 demo1 = new Demo1();
        jf.getContentPane().add(demo1);
        jf.pack();
        jf.setVisible(true);
        demo1.cicloPrincipalJuego();
    }
}
