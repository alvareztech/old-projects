package jpaint;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Clase Dibujo
 * @author Daniel Alvarez (a3dany)
 */
public class Dibujo extends Canvas implements MouseListener, MouseMotionListener {

    private VentanaPrincipal nucleo;
    private Point inicioArrastre;
    private Point finArrastre;
    private GeneralPath poligono;
    private ArrayList<Figura> figuras = new ArrayList<Figura>();
    private boolean sw;

    public Dibujo(VentanaPrincipal nucleo) {
        this.sw = true; // para los poligonos
        this.poligono = new GeneralPath();
        this.nucleo = nucleo;
        this.setBackground(Color.WHITE);
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        //super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        String opcion = nucleo.getOpcion();

        for (Figura figura : figuras) { // dibuja todos las figuras
            g2.setColor(figura.getColor());
            g2.setStroke(new BasicStroke(figura.getGrosor()));
            if (figura.isRelleno() && !(figura.getShape() instanceof Line2D.Float)) {
                g2.fill(figura.getShape());
            } else {
                g2.draw(figura.getShape());
            }

        }
        if (opcion.equals("POLIGONO")) {
            if (inicioArrastre != null && finArrastre != null && inicioArrastre.x > finArrastre.x - 10 && inicioArrastre.x < finArrastre.x + 10 && inicioArrastre.y > finArrastre.y - 10 && inicioArrastre.y < finArrastre.y + 10) {
                figuras.add(new Figura(poligono, nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno()));
                poligono = new GeneralPath();
                inicioArrastre = null;
                finArrastre = null;
                sw = true;
                repaint();
            } else {
                g2.setColor(nucleo.getColor());
                g2.setStroke(new BasicStroke(nucleo.getGrosorPincel()));
                g2.draw(poligono);
            }
        }
        if (inicioArrastre != null && finArrastre != null) { // se esta arrastrando el raton?
            g2.setColor(nucleo.getColor());
            if (opcion.equals("LAPIZ")) {
            } else if (opcion.equals("LINEA")) {
                Figura linea = crearLinea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
                g2.setStroke(new BasicStroke(linea.getGrosor()));
                g2.draw(linea.getShape());
            } else if (opcion.equals("RECTANGULO")) {
                Figura rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
                g2.setStroke(new BasicStroke(rectangulo.getGrosor()));
                g2.draw(rectangulo.getShape());
            } else if (opcion.equals("ELIPSE")) {
                Figura elipse = crearElipse(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
                g2.setStroke(new BasicStroke(elipse.getGrosor()));
                g2.draw(elipse.getShape());
            } else if (opcion.equals("ARCO")) {
                Figura arco = crearArco(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
                g2.setStroke(new BasicStroke(arco.getGrosor()));
                g2.draw(arco.getShape());
            }
        }
    }

    public void mouseDragged(MouseEvent e) {
        String opcion = nucleo.getOpcion();
        if (opcion.equals("LAPIZ")) {
            finArrastre = new Point(e.getX(), e.getY());
            Figura linea = crearLinea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
            figuras.add(linea);
            inicioArrastre = new Point(finArrastre.x, finArrastre.y);
            repaint();
        } else if (opcion.equals("LINEA")) {
            finArrastre = new Point(e.getX(), e.getY());
            repaint();
        } else if (opcion.equals("RECTANGULO")) {
            finArrastre = new Point(e.getX(), e.getY());
            repaint();
        } else if (opcion.equals("ELIPSE")) {
            finArrastre = new Point(e.getX(), e.getY());
            repaint();
        } else if (opcion.equals("ARCO")) {
            finArrastre = new Point(e.getX(), e.getY());
            repaint();
        }
    }

    public void mouseMoved(MouseEvent e) {
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        String opcion = nucleo.getOpcion();
        if (opcion.equals("LAPIZ")) {
            inicioArrastre = new Point(e.getX(), e.getY());
            repaint();
        } else if (opcion.equals("LINEA")) {
            inicioArrastre = new Point(e.getX(), e.getY());
            finArrastre = inicioArrastre;
            repaint();
        } else if (opcion.equals("RECTANGULO")) {
            inicioArrastre = new Point(e.getX(), e.getY());
            finArrastre = inicioArrastre;
            repaint();
        } else if (opcion.equals("ELIPSE")) {
            inicioArrastre = new Point(e.getX(), e.getY());
            finArrastre = inicioArrastre;
            repaint();
        } else if (opcion.equals("ARCO")) {
            inicioArrastre = new Point(e.getX(), e.getY());
            finArrastre = inicioArrastre;
            repaint();
        } else if (opcion.equals("POLIGONO")) {
            if (sw) {
                inicioArrastre = new Point(e.getX(), e.getY());
                poligono.moveTo(e.getX(), e.getY());
                sw = false;
            } else {
                finArrastre = new Point(e.getX(), e.getY());
                poligono.lineTo(e.getX(), e.getY());
            }
            repaint();
        }
    }

    public void mouseReleased(MouseEvent e) {
        String opcion = nucleo.getOpcion();
        if (opcion.equals("LAPIZ")) {
            finArrastre = new Point(e.getX(), e.getY());
            Figura linea = crearLinea(inicioArrastre.x, inicioArrastre.y, finArrastre.x, finArrastre.y, nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
            figuras.add(linea);
            repaint();
        } else if (opcion.equals("LINEA")) {
            Figura linea = crearLinea(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY(), nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
            figuras.add(linea);
            inicioArrastre = null;
            finArrastre = null;
            repaint();
        } else if (opcion.equals("RECTANGULO")) {
            Figura rectangulo = crearRectangulo(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY(), nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
            figuras.add(rectangulo);
            inicioArrastre = null;
            finArrastre = null;
            repaint();
        } else if (opcion.equals("ELIPSE")) {
            Figura elipse = crearElipse(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY(), nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
            figuras.add(elipse);
            inicioArrastre = null;
            finArrastre = null;
            repaint();
        } else if (opcion.equals("ARCO")) {
            Figura arco = crearArco(inicioArrastre.x, inicioArrastre.y, e.getX(), e.getY(), nucleo.getColor(), nucleo.getGrosorPincel(), nucleo.esRelleno());
            figuras.add(arco);
            inicioArrastre = null;
            finArrastre = null;
            repaint();
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    private Figura crearRectangulo(int x1, int y1, int x2, int y2, Color color, int grosor, boolean relleno) {
        return new Figura(new Rectangle2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2)), color, grosor, relleno);
    }

    private Figura crearElipse(int x1, int y1, int x2, int y2, Color color, int grosor, boolean relleno) {
        return new Figura(new Ellipse2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2)), color, grosor, relleno);
    }

    private Figura crearLinea(int x1, int y1, int x2, int y2, Color color, int grosor, boolean relleno) {
        return new Figura(new Line2D.Float(x1, y1, x2, y2), color, grosor, relleno);
    }

    private Figura crearArco(int x1, int y1, int x2, int y2, Color color, int grosor, boolean relleno) {
        int gradoInicio = 0;
        int gradoFin = 90;
        if (x1 > x2 && y1 < y2) {
            gradoInicio = 90;
        }
        if (x1 < x2 && y1 > y2) {
            gradoFin = -90;
        }
        if (x1 > x2 && y1 > y2) {
            gradoInicio = 180;
            gradoFin = 90;
        }
        return new Figura(new Arc2D.Float(Math.min(x1, x2), Math.min(y1, y2), Math.abs(x1 - x2), Math.abs(y1 - y2), gradoInicio, gradoFin, Arc2D.OPEN), color, grosor, relleno);
    }

    public void reiniciar() {
        figuras.clear();
        repaint();
    }

    public boolean deshacer() {
        if (!figuras.isEmpty()) {
            figuras.remove(figuras.size()-1);
            return true;
        } else {
            return false;
        }
    }
}
