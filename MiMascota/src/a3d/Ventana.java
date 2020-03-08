package a3d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * Clase VentanaPrincipal
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame implements ActionListener {

    private JLabel imagen;
    private JButton botonComer;
    private JButton botonPasear;
    private JButton botonLeer;

    public Ventana() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Mi Mascota");                            // colocamos titulo a la ventana
        this.setSize(310, 350);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(null);                                   // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        imagen = new JLabel();
        imagen.setIcon(crearImageIcon("imagenes/comer.gif"));
        imagen.setBounds(90, 50, 200, 200);

        botonComer = new JButton();
        botonComer.setText("Comer");
        botonComer.setBounds(20, 280, 80, 30);
        botonComer.addActionListener(this);

        botonPasear = new JButton();
        botonPasear.setText("Pasear");
        botonPasear.setBounds(110, 280, 80, 30);
        botonPasear.addActionListener(this);

        botonLeer = new JButton();
        botonLeer.setText("Leer");
        botonLeer.setBounds(200, 280, 80, 30);
        botonLeer.addActionListener(this);

        add(imagen);
        add(botonComer);
        add(botonPasear);
        add(botonLeer);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonComer) {
            imagen.setIcon(crearImageIcon("imagenes/comer.gif"));
        }
        if (e.getSource() == botonPasear) {
            imagen.setIcon(crearImageIcon("imagenes/pasear.gif"));
        }
        if (e.getSource() == botonLeer) {
            imagen.setIcon(crearImageIcon("imagenes/leer.gif"));
        }
    }

    protected static ImageIcon crearImageIcon(String ruta) {
        URL imgURL = Ventana.class.getResource(ruta);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + ruta);
            return null;
        }
    }
}
