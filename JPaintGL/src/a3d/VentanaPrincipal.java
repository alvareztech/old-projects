package a3d;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;

/**
 * Clase VentanaPrincipal
 * @author Daniel Alvarez (a3dany)
 */
public class VentanaPrincipal extends JFrame {

    private BarraHerramientas barraHerramientas;
    private Lienzo lienzo;
    private BarraInferior barraInferior;

    public VentanaPrincipal() {
        super();
        configurarVentana();
        inicializarComponentes();

    }

    private void configurarVentana() {
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setTitle("JPaintGL | Daniel Alvarez");
        setSize(750, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        GLCapabilities capacidad = new GLCapabilities();
        capacidad.setDoubleBuffered(true);
        lienzo = new Lienzo(this, capacidad);
        barraInferior = new BarraInferior();
        barraHerramientas = new BarraHerramientas();
        add(barraHerramientas, BorderLayout.NORTH);
        add(lienzo, BorderLayout.CENTER);
        add(barraInferior, BorderLayout.SOUTH);
    }

    public int getGrosorPincel() {
        return barraInferior.getSliderGrosor().getValue();
    }

    public Color getColor() {
        return barraInferior.getBotonColor().getBackground();
    }

    public String getOpcion() {
        return barraHerramientas.getOpcion();
    }

    public void seleccionar(String opcion) {
        barraHerramientas.setOpcion(opcion);
    }
}
