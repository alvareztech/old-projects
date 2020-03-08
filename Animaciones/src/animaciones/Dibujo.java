package animaciones;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

/**
 * Clase Dibujo
 * @author Daniel Alvarez (a3dany)
 */
public class Dibujo extends JPanel implements Runnable {

    private int x;
    private int y;
    private Thread hilo;
    
    public Dibujo() {
        hilo = new Thread(this);
        hilo.start();
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        Rectangle2D r = new Rectangle2D.Double(x, 50, x+100, 100);
        g2d.fill(r);
    }

    public void run() {
        while (true) {
            try {
                hilo.sleep(15);
                x++;
                repaint();
            } catch (InterruptedException ex) {
                Logger.getLogger(Animacion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
