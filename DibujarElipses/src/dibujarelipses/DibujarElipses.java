package dibujarelipses;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clase DibujarElipses
 * @author Daniel Alvarez (a3dany)
 */
public class DibujarElipses extends JComponent {

    private Point inicioArrastre;
    private Point finArrastre;
    private ArrayList<Shape> elipses = new ArrayList<Shape>();

    public DibujarElipses() {
        super();
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                inicioArrastre = new Point(e.getX(), e.getY());
                finArrastre = inicioArrastre;
                repaint();
            }

            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse
                Shape elipse = crearElipse(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
                elipses.add(elipse);
                inicioArrastre = null;
                finArrastre = null;
                repaint();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {

            public void mouseDragged(MouseEvent e) { // cuando se esta arrastrando el mouse
                finArrastre = new Point(e.getX(), e.getY());
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        for (Shape elipse : elipses) { // dibuja todos las elipses
            g2.fill(elipse);
        }
        if (inicioArrastre != null && finArrastre != null) { // se esta arrastrando el raton?
            Shape elipse = crearElipse(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
            g2.draw(elipse);
        }
    }

    private Ellipse2D.Float crearElipse(int x1, int y1, int x2, int y2) {
        // ajusta la elipse
        return new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public static void main(String[] a3d) {
        JFrame ventana = new JFrame("Dibujar Elipses");
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new DibujarElipses());
        ventana.setVisible(true);
    }
}
