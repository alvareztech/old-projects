package jpaint;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase VentanaPrincipal
 * @author Daniel Alvarez (a3dany)
 */
public class VentanaPrincipal extends Frame {

    private Menu2 menu;
    private BarraHerramientas toolBar;
    private Dibujo dibujo;
    private BarraInferior barraInferior;

    public VentanaPrincipal() {
        super("JPaint");
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        //setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }

    private void inicializarComponentes() {
        menu = new Menu2(this);
        setMenuBar(menu);
        toolBar = new BarraHerramientas();
        add(toolBar, BorderLayout.NORTH);
        dibujo = new Dibujo(this);
        add(dibujo, BorderLayout.CENTER);
        barraInferior = new BarraInferior();
        add(barraInferior, BorderLayout.SOUTH);
    }

    public void reiniciar() {
        dibujo.reiniciar();
    }

    public int getGrosorPincel() {
        return barraInferior.getSliderGrosor().getSelectedIndex() + 1;
    }

    public Color getColor() {
        String x = barraInferior.getBotonColor().getSelectedItem();
        if (x.equals("Rojo")) {
            return Color.red;
        }
        if (x.equals("Amarillo")) {
            return Color.yellow;
        }
        if (x.equals("Verde")) {
            return Color.green;
        }
        if (x.equals("Azul")) {
            return Color.blue;
        }
        if (x.equals("Naranja")) {
            return Color.orange;
        }
        return Color.BLACK;
    }

    public String getOpcion() {
        return toolBar.getOpcion();
    }

    public boolean esRelleno() {
        return barraInferior.esRelleno();
    }

    public void seleccionar(String opcion) {
        toolBar.setOpcion(opcion);
    }

    public void repintar() {
        dibujo.repaint();
    }

    public void deshacer() {
        dibujo.deshacer();
        dibujo.repaint();
    }
}
