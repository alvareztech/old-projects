package a3d;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

/**
 * Clase BarraInferior
 * @author Daniel Alvarez (a3dany)
 */
public class BarraInferior extends JPanel implements ActionListener {

    private JLabel etiquetaGrosor;
    private JLabel etiquetaColor;
    private JSlider sliderGrosor;
    private JButton botonColor;

    public BarraInferior() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        etiquetaGrosor = new JLabel("Grosor del pincel");
        sliderGrosor = new JSlider(1, 6, 1);
        etiquetaColor = new JLabel("Color");
        botonColor = new JButton();
        botonColor.setBackground(Color.red);
        botonColor.addActionListener(this);
        add(etiquetaColor);
        add(botonColor);
        add(etiquetaGrosor);
        add(sliderGrosor);
    }

    public JSlider getSliderGrosor() {
        return sliderGrosor;
    }

    public void actionPerformed(ActionEvent e) {
        Color color = JColorChooser.showDialog(null, "Seleccione Color", Color.yellow);
        botonColor.setBackground(color);
    }

    public JButton getBotonColor() {
        return botonColor;
    }
}