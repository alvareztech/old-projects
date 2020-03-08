package a3d;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * JConversorSN 2
 * Conversor De Sistemas Numericos
 * @author Daniel Alvarez (a3dany)
 */
public class Conversor extends JFrame implements KeyListener, ItemListener {

    private JTextField tfNumero1;
    private JTextField tfNumero2;
    private JComboBox cbBaseA;
    private JComboBox cbBaseB;
    private JLabel lTexto1;
    private JLabel lTexto2;
    private JLabel lTexto3;
    private JLabel lTexto4;

    public Conversor() {
        super("JConversorSN 2 | SoloInformaticaYAlgoMas.blogspot.com | Daniel Alvarez");
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        getContentPane().setBackground(Color.DARK_GRAY);
        setSize(560, 140);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
    }

    private void inicializarComponentes() {
        // lTexto1
        lTexto1 = new JLabel("Numero a Convertir");
        lTexto1.setForeground(Color.WHITE);
        lTexto1.setFont(new Font("Arial", Font.BOLD, 10));
        lTexto1.setBounds(30, 25, 150, 10);
        // lTexto2
        lTexto2 = new JLabel("Base Origen");
        lTexto2.setForeground(Color.WHITE);
        lTexto2.setFont(new Font("Arial", Font.BOLD, 10));
        lTexto2.setBounds(210, 25, 100, 10);
        // lTexto3
        lTexto3 = new JLabel("Base Destino");
        lTexto3.setForeground(Color.WHITE);
        lTexto3.setFont(new Font("Arial", Font.BOLD, 10));
        lTexto3.setBounds(276, 25, 100, 10);
        // lTexto4
        lTexto4 = new JLabel("Numero Convertido");
        lTexto4.setForeground(Color.WHITE);
        lTexto4.setFont(new Font("Arial", Font.BOLD, 10));
        lTexto4.setBounds(425, 25, 150, 10);
        // tfNumero1
        tfNumero1 = new JTextField();
        tfNumero1.setFont(new Font("Arial", 0, 30));
        tfNumero1.setBackground(Color.DARK_GRAY);
        tfNumero1.setForeground(Color.WHITE);
        tfNumero1.setBounds(30, 40, 180, 40);
        tfNumero1.addKeyListener(this);
        // tfNumero2
        tfNumero2 = new JTextField();
        tfNumero2.setFont(new Font("Arial", 0, 30));
        tfNumero2.setBackground(Color.DARK_GRAY);
        tfNumero2.setForeground(Color.WHITE);
        tfNumero2.setBounds(340, 40, 180, 40);
        tfNumero2.addKeyListener(this);
        // cbBaseA
        cbBaseA = new JComboBox();
        cbBaseA.setFont(new Font("Arial", 0, 18));
        for (int i = 2; i <= 36; i++) {
            cbBaseA.addItem(i);
        }
        cbBaseA.setSelectedIndex(8);
        cbBaseA.setBounds(220, 40, 55, 40);
        cbBaseA.addItemListener(this);
        // cbBaseB
        cbBaseB = new JComboBox();
        cbBaseB.setFont(new Font("Arial", 0, 18));
        for (int i = 2; i <= 36; i++) {
            cbBaseB.addItem(i);
        }
        cbBaseB.setSelectedIndex(0);
        cbBaseB.setBounds(275, 40, 55, 40);
        cbBaseB.addItemListener(this);
        // add
        add(lTexto1);
        add(lTexto2);
        add(lTexto3);
        add(lTexto4);
        add(tfNumero1);
        add(tfNumero2);
        add(cbBaseA);
        add(cbBaseB);
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            String x = convertir(tfNumero1.getText(), cbBaseA.getSelectedIndex() + 2, cbBaseB.getSelectedIndex() + 2);
            tfNumero1.setText(tfNumero1.getText().toUpperCase());
            tfNumero2.setText(x.toUpperCase());
        } catch (Exception ex) {
            tfNumero1.setText("");
            tfNumero2.setText("");
        }
    }

    public static String convertir(String numero, int baseOrigen, int baseDestino) {
        int numeroBase10 = Integer.parseInt(numero, baseOrigen);            // convierte a base 10 cualquier numero en otra base
        String numeroBaseB = Integer.toString(numeroBase10, baseDestino);   // convierte numeroBase10 a otra base
        return numeroBaseB;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        try {
            String x = convertir(tfNumero1.getText(), cbBaseA.getSelectedIndex() + 2, cbBaseB.getSelectedIndex() + 2);
            tfNumero1.setText(tfNumero1.getText().toUpperCase());
            tfNumero2.setText(x.toUpperCase());
        } catch (Exception ex) {
            tfNumero1.setText("");
            tfNumero2.setText("");
        }
    }

    public static void main(String[] args) {
        for (UIManager.LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(laf.getName())) {
                try {
                    UIManager.setLookAndFeel(laf.getClassName());
                } catch (Exception ex) {
                }
            }
        }
        Conversor X = new Conversor();
        X.setVisible(true);
    }
}