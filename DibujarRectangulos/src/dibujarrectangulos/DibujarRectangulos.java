package dibujarrectangulos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clase DibujarRectangulos
 * @author Daniel Alvarez (a3dany)
 */
public class DibujarRectangulos extends JComponent {

    private Point inicioArrastre;
    private Point finArrastre;
    private ArrayList<Shape> rectangulos = new ArrayList<Shape>();

    public DibujarRectangulos() {
        super();
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                inicioArrastre = new Point(e.getX(), e.getY());
                finArrastre = inicioArrastre;
                repaint();
            }

            public void mouseReleased(MouseEvent e) { // cuando se deja de presionar el mouse
                Shape rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY());
                rectangulos.add(rectangulo);
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
        for (Shape rectangulo : rectangulos) { // dibuja todos los rectangulos
            g2.fill(rectangulo);
        }
        if (inicioArrastre != null && finArrastre != null) { // se esta arrastrando el raton?
            Shape rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y);
            g2.draw(rectangulo);
        }
    }

    private Rectangle2D.Float crearRectangulo(int x1, int y1, int x2, int y2) {
        // ajusta el rectangulo
        return new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2));
    }

    public static void main(String[] a3d) {
        JFrame ventana = new JFrame("Dibujar Rectangulos");
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new DibujarRectangulos());
        ventana.setVisible(true);
    }
}