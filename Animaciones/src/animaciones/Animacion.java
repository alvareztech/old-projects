package animaciones;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 * Clase Animacion
 * @author Daniel Alvarez (a3dany)
 */
public class Animacion extends JFrame {

    private JPanel dibujo;

    public Animacion() {
        super("Animacion");
        setSize(400, 300);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        dibujo = new Dibujo();
        add(dibujo);

    }

    public static void main(String[] args) {
        new Animacion();
    }
}
