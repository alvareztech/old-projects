package a3d;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Clase PrincipalFrame
 * @author Daniel Alvarez (a3dany)
 */
public class PrincipalFrame extends JFrame {

    private JLabel lblImagen;
    private JTextPane txtTweet;
    private JButton btnTweet;

    public PrincipalFrame() {
        super();
        configurarFrame();
        inicializarComponentes();
    }

    private void configurarFrame() {
        this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        lblImagen = new JLabel();
        txtTweet = new JTextPane();
        btnTweet = new JButton();
        
        lblImagen.setText("Imagen");
        
        txtTweet.setText("xxx");
        
        btnTweet.setText("Tweet");

        this.add(lblImagen);
        this.add(txtTweet);
        this.add(btnTweet);
    }
}
