package a3d;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame {
    
    private Grafico grafico;

    public Ventana() {
        super("JPacManGL");
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        grafico = new Grafico();
        add(grafico, BorderLayout.CENTER);
    }
}
