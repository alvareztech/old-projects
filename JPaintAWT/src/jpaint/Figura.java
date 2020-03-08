package jpaint;

import java.awt.Color;
import java.awt.Shape;

/**
 * Clase Figura
 * @author Daniel Alvarez (a3dany)
 */
public class Figura {

    private Shape shape;
    private Color color;
    private int grosor;
    private boolean relleno;

    public Figura(Shape shape, Color color, int grosor, boolean relleno) {
        this.shape = shape;
        this.color = color;
        this.grosor = grosor;
        this.relleno = relleno;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getGrosor() {
        return grosor;
    }

    public void setGrosor(int grosor) {
        this.grosor = grosor;
    }

    public boolean isRelleno() {
        return relleno;
    }

    public void setRelleno(boolean relleno) {
        this.relleno = relleno;
    }

    public Shape getShape() {
        return shape;
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }
}
