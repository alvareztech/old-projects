package a3d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame implements ActionListener {

    private JPanel centro;
    private JPanel inferior;
    private JLabel logo;
    private JLabel mensaje;
    private JButton botonCargarLogo;
    private JButton botonColorFondo;
    private JButton botonMensaje;

    public Ventana() {
        super();
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Mi Tarjeta");                            // colocamos titulo a la ventana
        this.setSize(500, 400);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);                       // centramos la ventana en la pantalla
        this.setLayout(new BorderLayout());                     // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        this.setResizable(false);                               // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {
        logo = new JLabel();
        logo.setIcon(crearImageIcon("imagenes/umsa.png"));
        logo.setBounds(80, 50, 200, 200);

        mensaje = new JLabel();
        mensaje.setText("Aqui va tu mensaje");
        mensaje.setBounds(300, 100, 200, 50);

        botonCargarLogo = new JButton();
        botonCargarLogo.setText("Cargar Imagen");
        botonCargarLogo.addActionListener(this);

        botonColorFondo = new JButton();
        botonColorFondo.setText("Color Fondo");
        botonColorFondo.addActionListener(this);

        botonMensaje = new JButton();
        botonMensaje.setText("Mensaje");
        botonMensaje.addActionListener(this);

        centro = new JPanel();
        centro.setLayout(null);
        centro.add(logo);
        centro.add(mensaje);

        inferior = new JPanel();
        inferior.setLayout(new FlowLayout());
        inferior.add(botonCargarLogo);
        inferior.add(botonColorFondo);
        inferior.add(botonMensaje);

        add(centro, BorderLayout.CENTER);
        add(inferior, BorderLayout.NORTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonCargarLogo) {
            cargarLogo();
        }
        if (e.getSource() == botonColorFondo) {
            cambiarColor();
        }
        if (e.getSource() == botonMensaje) {
            cambiarMensaje();
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

    private void cambiarColor() {
        Color color = JColorChooser.showDialog(null, "Seleccione Color", Color.yellow);
        centro.setBackground(color);
    }

    private void cargarLogo() {
        JFileChooser fc = new JFileChooser();
        int respuesta = fc.showOpenDialog(this);
        if (respuesta == JFileChooser.APPROVE_OPTION) {
            File archivo = fc.getSelectedFile();
            ImageIcon imagen = getImageIconDesdeArchivo(archivo);
            logo.setIcon(imagen);
        } else {
        }
    }

    public ImageIcon getImageIconDesdeArchivo(File archivo) {
        Image imagen = Toolkit.getDefaultToolkit().getImage(archivo.getAbsolutePath());
        imagen = imagen.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
        return new ImageIcon(imagen);
    }

    private void cambiarMensaje() {
        String m = JOptionPane.showInputDialog("Inserte nuevo Mensaje");
        mensaje.setText(m);
    }
}
