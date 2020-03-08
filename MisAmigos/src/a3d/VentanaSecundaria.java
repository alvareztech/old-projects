package a3d;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * Clase VentanaSecundaria
 * @author Daniel Alvarez (a3dany)
 */
public class VentanaSecundaria extends JDialog implements ActionListener {

    private JLabel etiquetaNombre;
    private JLabel etiquetaSexo;
    private JLabel etiquetaGustos;
    private JTextField cajaNombre;
    private JRadioButton radioMasculino;
    private JRadioButton radioFemenino;
    private JCheckBox checkFutbol;
    private JCheckBox checkBasket;
    private JCheckBox checkVolley;
    private JButton botonAceptar;
    private VentanaPrincipal nucleo;

    public VentanaSecundaria(VentanaPrincipal parent, boolean modal) {
        super(parent, modal);
        nucleo = parent;
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        this.setTitle("Amigo");
        this.setSize(290, 290);
        this.setLayout(null);
        this.setLocationRelativeTo(nucleo);
    }

    private void inicializarComponentes() {
        etiquetaNombre = new JLabel();
        etiquetaSexo = new JLabel();
        etiquetaGustos = new JLabel();
        radioMasculino = new JRadioButton();
        radioFemenino = new JRadioButton();
        checkFutbol = new JCheckBox();
        checkBasket = new JCheckBox();
        checkVolley = new JCheckBox();
        botonAceptar = new JButton();

        etiquetaNombre.setText("Nombre");
        etiquetaNombre.setBounds(20, 20, 100, 25);

        etiquetaSexo.setText("Sexo");
        etiquetaSexo.setBounds(20, 60, 100, 25);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(80, 20, 170, 25);

        radioMasculino.setText("Masculino");
        radioMasculino.setSelected(true);
        radioMasculino.setBounds(80, 60, 90, 25);

        radioFemenino.setText("Femenino");
        radioFemenino.setBounds(170, 60, 90, 25);

        ButtonGroup grupo = new ButtonGroup();
        grupo.add(radioMasculino);
        grupo.add(radioFemenino);

        etiquetaGustos.setText("Gustos");
        etiquetaGustos.setBounds(20, 100, 100, 20);

        checkFutbol.setText("Futbol");
        checkFutbol.setBounds(80, 100, 100, 20);
        checkBasket.setText("Basketball");
        checkBasket.setBounds(80, 130, 100, 20);
        checkVolley.setText("Voleibol");
        checkVolley.setBounds(80, 160, 100, 20);

        botonAceptar.setText("Aceptar");
        botonAceptar.setBounds(80, 200, 170, 30);
        botonAceptar.addActionListener(this);

        this.add(etiquetaNombre);
        this.add(cajaNombre);
        this.add(etiquetaSexo);
        this.add(radioMasculino);
        this.add(radioFemenino);
        this.add(etiquetaGustos);
        this.add(checkFutbol);
        this.add(checkBasket);
        this.add(checkVolley);
        this.add(botonAceptar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = cajaNombre.getText();
        String sexo = radioMasculino.isSelected() ? "Masculino" : "Femenino";
        boolean gustoFutbol = checkFutbol.isSelected();
        boolean gustoBasket = checkBasket.isSelected();
        boolean gustoVolley = checkVolley.isSelected();
        Amigo A = new Amigo(nombre, sexo, gustoFutbol, gustoBasket, gustoVolley);
        nucleo.adicionarAmigo(A);
        this.setVisible(false);
    }
}
