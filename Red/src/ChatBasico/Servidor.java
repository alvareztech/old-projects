package ChatBasico;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Clase Servidor
 * @author Daniel Alvarez (a3dany)
 */
public class Servidor extends JFrame {

    private JTextField txtMensaje;
    private JTextArea txtPantalla;
    private ObjectInputStream entrada;
    private ObjectOutputStream salida;
    private ServerSocket servidor;
    private Socket conexion;

    public Servidor() {
        super("Servidor");
        inicializarComponentes();
        configurarVentana();
    }

    private void inicializarComponentes() {
        txtMensaje = new JTextField();
        txtPantalla = new JTextArea();
        add(txtMensaje, BorderLayout.NORTH);
        add(txtPantalla, BorderLayout.CENTER);
    }

    private void configurarVentana() {
        setSize(300, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void ejecutar() throws IOException {
        servidor = new ServerSocket(9999);
        mostrar("Esperando Conexion...");
        conexion = servidor.accept();
        mostrar("Cliente Aceptado...");
        salida = new ObjectOutputStream(conexion.getOutputStream());
        salida.flush();
        entrada = new ObjectInputStream(conexion.getInputStream());
        mostrar("Flujos Recibidos...");
        String mensaje = "holas";

        salida.writeObject("Servidor: " + mensaje);
        salida.flush();
        mostrar("Servidor: " + mensaje);

        
    }

    public void cerrarConexion() throws IOException {
        entrada.close();
        salida.close();
        conexion.close();
        servidor.close();
    }

    public void mostrar(String mensaje) {
        txtPantalla.append(mensaje + "\n");
    }

    public static void main(String[] args) throws IOException {
        Servidor V = new Servidor();
        V.ejecutar();
        V.setVisible(true);

    }
}
