package ventanas;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 * Clase VentanaPrincipal
 * @author Daniel Alvarez (a3dany)
 */
public class VentanaPrincipal extends JFrame implements ActionListener {

    private JDialog ventanaSecundaria;
    private JButton boton;

    public VentanaPrincipal() {
        super("Mi Primera Vensstana");
        this.setSize(400, 200);              // (ancho, alto)
        this.setLocationRelativeTo(null);    // posiciona el JFrame en el centro de la pantalla
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        boton = new JButton("Holas");
        boton.addActionListener(this);
        //boton.setBounds(50, 50, 100, 30);
        add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton) {
            ventanaSecundaria = new JDialog(this);
            ventanaSecundaria.setVisible(true);
        }
    }
}
