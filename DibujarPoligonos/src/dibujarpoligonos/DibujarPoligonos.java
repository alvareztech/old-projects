package dibujarpoligonos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clase DibujarPoligonos
 * @author Daniel Alvarez (a3dany)
 */
public class DibujarPoligonos extends JComponent {

    private Point inicio;
    private Point fin;
    private Polygon poligono;
    private ArrayList<Shape> poligonos = new ArrayList<Shape>();
    private boolean sw;

    public DibujarPoligonos() {
        super();
        sw = true;
        poligono = new Polygon();
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                if (sw) {
                    inicio = new Point(e.getX(), e.getY());
                    poligono.addPoint(e.getX(), e.getY());
                    sw = false;
                } else {
                    fin = new Point(e.getX(), e.getY());
                    poligono.addPoint(e.getX(), e.getY());
                }
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        if (inicio != null && fin != null && inicio.x > fin.x - 5 && inicio.x < fin.x + 5 && inicio.y > fin.y - 5 && inicio.y < fin.y + 5) {
            poligonos.add(poligono);
            poligono = new Polygon();
            inicio = null;
            sw = true;
        } else {
            g2.drawPolygon(poligono);
        }
        for (Shape p : poligonos) {
            g2.drawPolygon((Polygon) p);
        }
    }

    public static void main(String[] a3d) {
        JFrame ventana = new JFrame("Dibujar Poligonos");
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new DibujarPoligonos());
        ventana.setVisible(true);
    }
}
