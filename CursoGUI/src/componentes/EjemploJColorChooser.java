package componentes;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JFrame;

/**
 * Clase EjemploJColorChooser
 * @author Daniel Alvarez (a3dany)
 */
public class EjemploJColorChooser extends JFrame {

    public EjemploJColorChooser() {
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color color = JColorChooser.showDialog(null, "Seleccione Color", Color.yellow);
        
    }
    
    public static void main(String[] args) {
        EjemploJColorChooser V =new EjemploJColorChooser();
        V.setVisible(true);
    }
}
