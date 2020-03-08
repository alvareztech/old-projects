package dibujarpoligonos;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.GeneralPath;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 * Clase DibujarPoligonos2D
 * @author Daniel Alvarez (a3dany)
 */
public class DibujarPoligonos2D extends JComponent {

    private Point inicio;
    private Point fin;
    private GeneralPath poligono;
    private ArrayList<Shape> poligonos = new ArrayList<Shape>();
    private boolean sw;

    public DibujarPoligonos2D() {
        super();
        sw = true;
        poligono = new GeneralPath();
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) { // cuando se presiona el mouse
                if (sw) {
                    inicio = new Point(e.getX(), e.getY());
                    poligono.moveTo(e.getX(), e.getY());
                    sw = false;
                } else {
                    fin = new Point(e.getX(), e.getY());
                    poligono.lineTo(e.getX(), e.getY());
                }
                repaint();
            }
        });
    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.RED);
        g2.setStroke(new BasicStroke(2));
        if (inicio != null && fin != null && inicio.x > fin.x - 5 && inicio.x < fin.x + 5 && inicio.y > fin.y - 5 && inicio.y < fin.y + 5) {
            poligonos.add(poligono);
            poligono = new GeneralPath();
            inicio = null;
            fin = null;
            sw = true;
        } else {
            g2.draw(poligono);
        }
        for (Shape p : poligonos) {
            g2.draw(p);
        }
    }

    public static void main(String[] a3d) {
        JFrame ventana = new JFrame("Dibujar Poligonos");
        ventana.setSize(400, 300);
        ventana.setLocationRelativeTo(null);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.add(new DibujarPoligonos2D());
        ventana.setVisible(true);
    }
}
