package swing;

import javax.swing.JFrame;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame {

    public Ventana() {
        super("Mi Primera Ventana");
        this.setSize(400, 200);              // (ancho, alto)
        this.setLocationRelativeTo(null);    // posiciona el JFrame en el centro de la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void inicializarComponentes() {
        
    }
    
}
