package dibujarlineas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clase DibujarLineas
 * @author Daniel Alvarez (a3dany)
 */
public class DibujarLineas extends JComponent {

    private Point inicioArrastre;
    private Point finArrastre;
    private ArrayList<Shape> lineas = new ArrayList<Shape>();

    public DibujarLineas() {
        super();
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                inicioArrastre = new Point(e.getX(), e.getY());
                finArrastre = inicioArrastre;
                repaint();
            }

            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse
                Shape linea = crearLinea(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
                lineas.add(linea);
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
        for (Shape linea : lineas) { // dibuja todos las elipses
            g2.draw(linea);
        }
        if (inicioArrastre != null && finArrastre != null) { // se esta arrastrando el raton?
            Shape linea = crearLinea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
            g2.draw(linea);
        }
    }

    private Line2D.Float crearLinea(int x1, int y1, int x2, int y2) {
        return new Line2D.Float(x1, y1, x2, y2);
    }

    public static void main(String[] a3d) {
        JFrame ventana = new JFrame("Dibujar Lineas");
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new DibujarLineas());
        ventana.setVisible(true);
    }
}
