package dibujararcos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clase Dibujararcos
 * @author Daniel Alvarez (a3dany)
 */
public class DibujarArcos extends JComponent {

    private Point inicioArrastre;
    private Point finArrastre;
    private ArrayList<Shape> arcos = new ArrayList<Shape>();

    public DibujarArcos() {
        super();
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                inicioArrastre = new Point(e.getX(), e.getY());
                finArrastre = inicioArrastre;
                repaint();
            }

            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse
                Shape arco = crearArco(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
                arcos.add(arco);
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
        for (Shape arco : arcos) { // dibuja todos las elipses
            g2.draw(arco);
        }
        if (inicioArrastre != null && finArrastre != null) { // se esta arrastrando el raton?
            Shape arco = crearArco(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
            g2.draw(arco);
        }
    }

    private Arc2D.Float crearArco(int x1, int y1, int x2, int y2) {
        int gradoInicio = 0;
        int gradoFin = 90;
        if (x1 > x2 && y1 < y2)  {
            gradoInicio = 90;
        }
        if (x1 < x2 && y1 > y2)  {
            gradoFin = -90;
        }
        if (x1 > x2 && y1 > y2)  {
            gradoInicio = 180;
            gradoFin = 90;
        }
        return new Arc2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2), gradoInicio, gradoFin, Arc2D.OPEN);
    }

    public static void main(String[] a3d) {
        JFrame ventana = new JFrame("Dibujar arcos");
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new DibujarArcos());
        ventana.setVisible(true);
    }
}
