
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * Clase Dibujo
 * @author Daniel Alvarez (a3dany)
 */
public class Dibujo extends JPanel {

    private VentanaPrincipal nucleo;
    private JButton boton;

    public Dibujo(VentanaPrincipal nucleo) {
        this.nucleo = nucleo;
        this.setBackground(Color.WHITE);
        
        boton.setBounds(50, 10, 20, 20);
        boton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(this, "kaksjdhk");
            }
        });
        
        add(boton);
    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;


        //g2.fillRect(5, 5, 50, 100);
        //g2.
        g2.setColor(Color.red);
        g2.setStroke(new BasicStroke(5));
        g2.drawLine(5, 5, 100, 100);

        g2.fillRect(50, 50, 40, 100);
        g2.setColor(Color.GRAY);
        g2.fillRect(55, 55, 30, 90);


        g2.setColor(Color.blue);
        g2.setStroke(new BasicStroke(7));
        g2.drawLine(50, 50, 300, 300);


        g2.fillRect(150, 150, 40, 100);
        g2.setColor(Color.GRAY);
        g2.fillRect(155, 155, 30, 90);

    }

    protected static ImageIcon crearImageIcon(String path) {
        java.net.URL imgURL = Dibujo.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("No se pudo encontrar el archivo: " + path);
            return null;
        }
    }
}
