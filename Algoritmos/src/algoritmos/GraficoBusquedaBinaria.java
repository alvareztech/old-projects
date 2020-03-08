package algoritmos;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;

public class GraficoBusquedaBinaria {

    public static void main(String[] args) {
        TextFrame frame = new TextFrame();
        frame.setSize(640, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

class TextFrame extends JFrame {

    public TextFrame() {
        setTitle("b´usqueda Binaria");
        DocumentListener listener = new TextoFieldListener();
// agregar un panel con el texto a buscar
        JPanel panel = new JPanel();
        panel.add(new JLabel("Buscar:"));
        queBuscaField = new JTextField("30", 5);
        panel.add(queBuscaField);
        queBuscaField.getDocument().addDocumentListener(listener);
        add(panel, BorderLayout.NORTH);
// agregar el grafico
        muestra = new DrawPanel();
        add(muestra, BorderLayout.CENTER);
        pack();
    }
// recuperar el valor a buscar
    public void setTexto() {
        try {
            int queBuscas = Integer.parseInt(
                    queBuscaField.getText().trim());
            muestra.muestra(queBuscas);
        } catch (NumberFormatException e) {
        }
//no se reliza nada si no se puede interpretar los datos
    }
    public static final int DEFAULT_WIDTH = 640;
    public static final int DEFAULT_HEIGHT = 480;
    private JTextField queBuscaField;
    private DrawPanel muestra;

    private class TextoFieldListener
            implements DocumentListener {

        public void insertUpdate(DocumentEvent event) {
            setTexto();
        }

        public void removeUpdate(DocumentEvent event) {
            setTexto();
        }

        public void changedUpdate(DocumentEvent event) {
        }
    }
}

class DrawPanel extends JPanel {

    int t = 30, incrementos = 20,
            medio = 0, maximo = 30;
    int[] v = new int[maximo + 1];

    public DrawPanel() {
        for (int i = 0; i <= maximo; i++) {
            v[i] = i * 2;
        }
    }

    public void muestra(int x) {
        t = x;
        repaint();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        int desde = 20, topY = 100,
                hasta = 600, l = 0, u = maximo, m = 0;
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.WHITE);
        g2.fillRect(0, 0, 640, 480);
        g2.setColor(Color.BLACK);
        int hallo = -1, contador = 0;
// dibujar
        String explica = "Las lineas representan el "
                + "rango en el cual se busca";
        g.drawString(explica,
                ((desde + hasta) / 2) - (explica.length() * 3), topY);
        while (l <= u) {
            topY += incrementos;
            m = (l + u) / 2;
            medio = (hasta + desde) / 2;
            g.drawString("" + contador++, 5, topY);
            g.drawString("" + v[l], desde, topY);
            g.drawString("" + v[u], hasta, topY);
            g.drawString("" + v[m], medio, topY);
            g2.draw(new Line2D.Double(desde, topY, hasta, topY));
            if (v[m] < t) {
                l = m + 1;
                desde = medio + 1;
            } else if (v[m] == t) {
                topY += incrementos;
                g.drawString("" + contador++, 5, topY);
                g.drawString("" + v[m], (hasta + desde) / 2, topY);
                hallo = m;
                break;
            } else {
                u = m - 1;
                hasta = medio - 1;
            }
        }
    }
}