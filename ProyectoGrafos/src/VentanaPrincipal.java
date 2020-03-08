

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VentanaPrincipal extends JFrame {

    private Dibujo dibujo;
    private JButton botonAdicionar;
    private JTextField cajaEmpresaNombre;
    private JTextField cajaEmpresaCiudad;
    

    public VentanaPrincipal() {
        super("JPaint");
        configurarVentana();
        inicializarComponentes();
        
    }

    private void configurarVentana() {
        //setExtendedState(JFrame.MAXIMIZED_BOTH);
        //setUndecorated(true);
        setSize(750, 550);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        dibujo = new Dibujo(this);
        add(dibujo, BorderLayout.CENTER);
        
        cajaEmpresaNombre =  new JTextField(10);
        cajaEmpresaCiudad =  new JTextField(10);
        botonAdicionar = new JButton("Adicionar Empresa");
        botonAdicionar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = cajaEmpresaNombre.getText();
                String ciudad = cajaEmpresaCiudad.getText();
                System.out.println(nombre);
                
            }
        });
        
        
        
        JPanel panelAbajo = new JPanel();
        panelAbajo.add(cajaEmpresaNombre);
        panelAbajo.add(cajaEmpresaCiudad);
        panelAbajo.add(botonAdicionar);
        
        add(panelAbajo, BorderLayout.SOUTH);
    }


    public void repintar() {
        dibujo.repaint();
    }

    public void deshacer() {
        dibujo.repaint();
    }
}
