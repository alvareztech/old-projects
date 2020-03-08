
import javax.swing.JButton;
import javax.swing.JFrame;


public class VentanaX extends JFrame {
    
    public VentanaX() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setSize(400, 300);
        setVisible(true);
        setTitle("Holas");
        setLayout(null);
    }

    private void inicializarComponentes() {
        JButton boton = new JButton();
        boton.setText("ACEPTAR");
        boton.setBounds(5, 5, 100, 30);
        
        add(boton);
    }
    
}
