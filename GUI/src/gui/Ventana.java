package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame implements ActionListener {

    private JButton boton; 
    private JTextField texto1;
    private JTextField texto2;

    public Ventana() {
        configuraVentana();
        inicializarComponentes();
    }

    private void configuraVentana() {
        setTitle("Esta es una ventana");
        setSize(400, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
    }

    private void inicializarComponentes() {
        texto1 = new JTextField();
        texto1.setBounds(150, 50, 50, 30);
        add(texto1);
        texto2 = new JTextField();
        texto2.setBounds(250, 50, 50, 30);
        add(texto2);

        boton = new JButton("Aceptar");
        boton.setBounds(50, 50, 80, 30);
        boton.addActionListener(this);
        add(boton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int dia = Integer.parseInt(texto1.getText());
        int mes = Integer.parseInt(texto2.getText());
        String signo = signo(dia, mes);
        JOptionPane.showMessageDialog(this, signo);
    }
    
    public String signo(int dia, int mes) {
        String signo = "";
        switch (mes) {
            case 1:
                if (dia > 21) {
                    signo = "ACUARIO";
                } else {
                    signo = "CAPRICORNIO";
                }
                break;
            case 2:
                if (dia > 19) {
                    signo = "PISCIS";
                } else {
                    signo = "ACUARIO";
                }
                break;
            case 3:
                if (dia > 20) {
                    signo = "ARIES";
                } else {
                    signo = "PISCIS";
                }
                break;
            case 4:
                if (dia > 20) {
                    signo = "TAURO";
                } else {
                    signo = "ARIES";
                }
                break;
            case 5:
                if (dia > 21) {
                    signo = "GEMINIS";
                } else {
                    signo = "TAURO";
                }
                break;
            case 6:
                if (dia > 20) {
                    signo = "CANCER";
                } else {
                    signo = "GEMINIS";
                }
                break;
            case 7:
                if (dia > 22) {
                    signo = "LEO";
                } else {
                    signo = "CANCER";
                }
                break;
            case 8:
                if (dia > 21) {
                    signo = "VIRGO";
                } else {
                    signo = "LEO";
                }
                break;
            case 9:
                if (dia > 22) {
                    signo = "LIBRA";
                } else {
                    signo = "VIRGO";
                }
                break;
            case 10:
                if (dia > 22) {
                    signo = "ESCORPION";
                } else {
                    signo = "LIBRA";
                }
                break;
            case 11:
                if (dia > 21) {
                    signo = "SAGITARIO";
                } else {
                    signo = "ESCORPION";
                }
                break;
            case 12:
                if (dia > 21) {
                    signo = "CAPRICORNIO";
                } else {
                    signo = "SAGITARIO";
                }
                break;
        }
        return signo;
    }
}
