package a3d;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame {

    private Grafico grafico;
    private int victoriasHumano;
    private int victoriasComputadora;
    private JLabel lblHumano;
    private JLabel lblComputadora;

    public Ventana() {
        super("JTresEnRayaGL | Daniel Alvarez (a3dany)");
        victoriasHumano = 0;
        victoriasComputadora = 0;
        setSize(400, 420);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        grafico = new Grafico(this);
        add(grafico, BorderLayout.CENTER);
        lblHumano = new JLabel("Ganados: " + victoriasHumano);
        lblComputadora = new JLabel("   Perdidos: " + victoriasComputadora);
        JPanel resultados = new JPanel();
        resultados.add(lblHumano);
        resultados.add(lblComputadora);
        add(resultados, BorderLayout.SOUTH);
    }

    void mostrarMensaje(String string) {
        JOptionPane.showMessageDialog(this, string, "Termino El Juego!", JOptionPane.INFORMATION_MESSAGE);
    }

    void reiniciar(char c) {
        remove(grafico);
        grafico = new Grafico(this);
        add(grafico, BorderLayout.CENTER);
        if (c == 'x') {
            victoriasHumano++;
        } else {
            if (c == 'o') {
                victoriasComputadora++;
            }
        }
        lblHumano.setText("Ganados: " + victoriasHumano);
        lblComputadora.setText("   Perdidos: " + victoriasComputadora);
        setVisible(true);
    }
}
