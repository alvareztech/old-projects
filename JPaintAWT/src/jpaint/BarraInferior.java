package jpaint;

import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.Label;
import java.awt.Panel;

/**
 * Clase BarraInferior
 * @author Daniel Alvarez (a3dany)
 */
public class BarraInferior extends Panel {

    private Label etiquetaGrosor;
    private Label etiquetaColor;
    private Choice sliderGrosor;
    private Choice botonColor;
    private Checkbox checkBoxRelleno;

    public BarraInferior() {
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        etiquetaGrosor = new Label("Grosor del pincel");
        sliderGrosor = new Choice();
        for (int i = 1; i <= 30; i++) {
            sliderGrosor.addItem(i + "");
        }
        etiquetaColor = new Label("Color");
        botonColor = new Choice();
        botonColor.addItem("Rojo");
        botonColor.addItem("Amarillo");
        botonColor.addItem("Verde");
        botonColor.addItem("Naranja");
        botonColor.addItem("Azul");
        botonColor.addItem("Negro");
       // botonColor.setBackground(Color.red);
        checkBoxRelleno = new Checkbox("Relleno");
        add(etiquetaColor);
        add(botonColor);
        add(etiquetaGrosor);
        add(sliderGrosor);
        add(checkBoxRelleno);
    }

    public Choice getSliderGrosor() {
        return sliderGrosor;
    }

    public Choice getBotonColor() {
        return botonColor;
    }

    public boolean esRelleno() {
        return checkBoxRelleno.getState();
    }
}
