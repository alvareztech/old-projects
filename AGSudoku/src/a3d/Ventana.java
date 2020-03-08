package a3d;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame implements ActionListener {

    private JTextField[] cajas;
    private JButton botonNuevo;
    private JButton botonSolucionar;
    private JTextArea areaDeTexto;
    private JScrollPane areaDeTextoScroll;
    private Solucion solucion;
    private static final int[] SUDOKU = {
        0, 0, 6, 4, 2, 8, 0, 0, 0,
        4, 5, 0, 1, 7, 6, 0, 3, 2,
        0, 8, 7, 3, 9, 5, 0, 4, 1,
        0, 9, 3, 5, 8, 0, 7, 0, 0,
        0, 4, 0, 2, 0, 7, 0, 9, 3,
        7, 2, 0, 9, 0, 0, 5, 6, 0,
        5, 6, 8, 0, 3, 4, 2, 0, 9,
        0, 1, 0, 8, 0, 0, 3, 7, 6,
        0, 7, 0, 6, 1, 0, 4, 8, 0
    };

    public Ventana() {
        super();
        configurarVentana();
        inicializarComponentes();
        pack();
        this.setLocationRelativeTo(null);
    }

    private void configurarVentana() {
        this.setTitle("Solucionador De Sudokus | Daniel Alvarez");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        cajas = new JTextField[81];
        botonNuevo = new JButton();
        botonSolucionar = new JButton();
        areaDeTexto = new JTextArea();

        JPanel centro = new JPanel(new GridLayout(9, 9, 2, 2));
        for (int i = 0; i < 81; i++) {
            cajas[i] = new JTextField();
            cajas[i].setHorizontalAlignment(JTextField.CENTER);
            if (SUDOKU[i] == 0) {
                cajas[i].setText("");
            } else {
                cajas[i].setText(SUDOKU[i] + "");
            }

            cajas[i].setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 20));
            centro.add(cajas[i]);
        }
        cajas[3].setBackground(Color.ORANGE);
        cajas[4].setBackground(Color.ORANGE);
        cajas[5].setBackground(Color.ORANGE);
        cajas[12].setBackground(Color.ORANGE);
        cajas[13].setBackground(Color.ORANGE);
        cajas[14].setBackground(Color.ORANGE);
        cajas[21].setBackground(Color.ORANGE);
        cajas[22].setBackground(Color.ORANGE);
        cajas[23].setBackground(Color.ORANGE);
        
        cajas[27].setBackground(Color.ORANGE);
        cajas[28].setBackground(Color.ORANGE);
        cajas[29].setBackground(Color.ORANGE);
        cajas[33].setBackground(Color.ORANGE);
        cajas[34].setBackground(Color.ORANGE);
        cajas[35].setBackground(Color.ORANGE);
        
        cajas[36].setBackground(Color.ORANGE);
        cajas[37].setBackground(Color.ORANGE);
        cajas[38].setBackground(Color.ORANGE);
        cajas[42].setBackground(Color.ORANGE);
        cajas[43].setBackground(Color.ORANGE);
        cajas[44].setBackground(Color.ORANGE);
        
        cajas[45].setBackground(Color.ORANGE);
        cajas[46].setBackground(Color.ORANGE);
        cajas[47].setBackground(Color.ORANGE);
        cajas[51].setBackground(Color.ORANGE);
        cajas[52].setBackground(Color.ORANGE);
        cajas[53].setBackground(Color.ORANGE);
        
        cajas[57].setBackground(Color.ORANGE);
        cajas[58].setBackground(Color.ORANGE);
        cajas[59].setBackground(Color.ORANGE);
        cajas[66].setBackground(Color.ORANGE);
        cajas[67].setBackground(Color.ORANGE);
        cajas[68].setBackground(Color.ORANGE);
        cajas[75].setBackground(Color.ORANGE);
        cajas[76].setBackground(Color.ORANGE);
        cajas[77].setBackground(Color.ORANGE);
        
        centro.setPreferredSize(new Dimension(400, 400));

        areaDeTexto.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        areaDeTexto.setText("Solucionador De Sudokus\nCon Algoritmos Geneticos\n\n");
        areaDeTexto.setColumns(40);
        areaDeTexto.setRows(5);
        //areaDeTexto.setPreferredSize(new Dimension(150, 400));
        areaDeTextoScroll = new JScrollPane(areaDeTexto);
        areaDeTextoScroll.setViewportView(areaDeTexto);


        botonNuevo.setText("Nuevo");
        botonNuevo.addActionListener(this);

        botonSolucionar.setText("Solucionar");
        botonSolucionar.addActionListener(this);

        JPanel abajo = new JPanel(new FlowLayout());
        abajo.add(botonNuevo);
        abajo.add(botonSolucionar);

        this.add(centro, BorderLayout.CENTER);
        this.add(areaDeTextoScroll, BorderLayout.EAST);
        this.add(abajo, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonSolucionar) {
            int[] valores = new int[81];
            for (int i = 0; i < 81; i++) {
                if (cajas[i].getText().equals("")) {
                    valores[i] = 0;
                } else {
                    valores[i] = Integer.parseInt(cajas[i].getText());
                }
            }

            solucion = new Solucion(cajas, areaDeTexto, valores);
            solucion.start();
        }
        if (e.getSource() == botonNuevo) {
            areaDeTexto.setText("Solucionador De Sudokus\nCon Algoritmos Geneticos\n\n");
            for (int i = 0; i < 81; i++) {
                cajas[i].setText("");
            }
        }
    }
}
