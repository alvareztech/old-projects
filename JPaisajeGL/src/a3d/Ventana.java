package a3d;

import java.awt.BorderLayout;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame {

    private Grafico grafico;

    public Ventana() {
        super("JPaisajeGL | Daniel Alvarez (a3dany)");
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setSize(650, 500);
        //setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        GLCapabilities miCapacidad = new GLCapabilities();
        miCapacidad.setDoubleBuffered(true);
        grafico = new Grafico(miCapacidad);
        add(grafico, BorderLayout.CENTER);
    }
}
