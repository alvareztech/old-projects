package a3d;

import com.sun.opengl.util.FPSAnimator;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame {

    private Canvas canvas;

    public Ventana() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("JAumovil2GL | Daniel Alvarez");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        GLCapabilities capacidad = new GLCapabilities();
        capacidad.setDoubleBuffered(true);
        canvas = new Canvas(capacidad);
        add(canvas);
    }

    public static void main(String[] args) {
        Ventana V = new Ventana();
        V.setVisible(true);
    }
}
