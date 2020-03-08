package jcaratula;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

public class Ventana extends JFrame implements ActionListener {

    private JLabel lblTitulo;
    private JLabel lblSubTitulo;
    private JTextField txtTitulo;
    private JTextField txtSubTitulo;
    private JButton btnGenerar;
    private JComboBox cbxTipos;

    public Ventana() throws FileNotFoundException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        }
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(500, 400);
        setTitle("JCaratula");
        initComponents();
        setVisible(true);
    }

    private void initComponents() throws FileNotFoundException {

        Scanner e = new Scanner(new File("C:\\daniel.txt"));

        String[] proy = new String[10];
        int x = 0;
        System.out.print("*");
        System.out.print(e.toString());
        while (e.hasNextLine()) {
            proy[x++] = e.nextLine();
        }

        lblTitulo = new JLabel("Titulo");
        lblSubTitulo = new JLabel("SubTitulo");
        txtTitulo = new JTextField();
        txtSubTitulo = new JTextField();
        cbxTipos = new JComboBox(proy);
        btnGenerar = new JButton("Generar");

        lblTitulo.setFont(new Font("Candara", 0, 12));
        lblSubTitulo.setFont(new Font("Candara", 0, 12));
        txtTitulo.setFont(new Font("Arial Narrow", Font.BOLD, 20));
        txtSubTitulo.setFont(new Font("Arial Narrow", 0, 16));

        txtTitulo.setHorizontalAlignment(JTextField.CENTER);
        txtTitulo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        txtSubTitulo.setHorizontalAlignment(JTextField.CENTER);
        txtSubTitulo.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));

        lblTitulo.setBounds(15, 8, 100, 10);
        txtTitulo.setBounds(15, 20, 455, 30);
        lblSubTitulo.setBounds(15, 58, 100, 10);
        txtSubTitulo.setBounds(15, 70, 300, 25);
        cbxTipos.setBounds(15, 120, 200, 25);
        btnGenerar.setBounds(30, 180, 100, 30);

        btnGenerar.addActionListener(this);

        add(lblTitulo);
        add(txtTitulo);
        add(lblSubTitulo);
        add(txtSubTitulo);
        add(btnGenerar);
        add(cbxTipos);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            Caratula C = new Caratula(txtTitulo.getText(), txtSubTitulo.getText());
            C.generarPdf();
        } catch (Exception ex) {
        }
    }
}
