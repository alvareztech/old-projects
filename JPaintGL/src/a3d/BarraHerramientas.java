package a3d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

/**
 * Clase BarraHerramientas
 * @author Daniel Alvarez (a3dany)
 */
public class BarraHerramientas extends JToolBar implements ActionListener {

    private String opcion;
    private JToggleButton botonLinea;
    private JToggleButton botonRectangulo;
    private JToggleButton botonElipse;

    public BarraHerramientas() {
        // setRollover(true);
        opcion = "LINEA";
        setFloatable(false);
        inicializarComponentes();
        actualizarEstadoBotones();
    }

    private void inicializarComponentes() {
        botonLinea = new JToggleButton();
        botonRectangulo = new JToggleButton();
        botonElipse = new JToggleButton();
        botonLinea.setText("Linea");
        botonLinea.setIcon(crearImageIcon("imagenes/linea.png"));
        botonLinea.addActionListener(this);
        botonRectangulo.setText("Rectangulo");
        botonRectangulo.setIcon(crearImageIcon("imagenes/rectangulo.png"));
        botonRectangulo.addActionListener(this);
        botonElipse.setText("Elipse");
        botonElipse.setIcon(crearImageIcon("imagenes/elipse.png"));
        botonElipse.addActionListener(this);
        add(botonLinea);
        add(botonRectangulo);
        add(botonElipse);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLinea) {
            opcion = "LINEA";
        } else if (e.getSource() == botonRectangulo) {
            opcion = "RECTANGULO";
        } else if (e.getSource() == botonElipse) {
            opcion = "ELIPSE";
        }
        actualizarEstadoBotones();
    }

    public String getOpcion() {
        return opcion;
    }

    private void actualizarEstadoBotones() {
        if (opcion.equals("LINEA")) {
            botonLinea.setSelected(true);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
        } else if (opcion.equals("RECTANGULO")) {
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(true);
            botonElipse.setSelected(false);
        } else if (opcion.equals("ELIPSE")) {
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(true);
        }
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
        actualizarEstadoBotones();
    }

    protected static ImageIcon crearImageIcon(String path) {
        java.net.URL imgURL = BarraHerramientas.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + path);
            return null;
        }
    }
}
