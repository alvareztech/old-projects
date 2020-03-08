package jpaint;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase BarraHerramientas
 * @author Daniel Alvarez (a3dany)
 */
public class BarraHerramientas extends Panel implements ActionListener {

    private String opcion;
    private Button botonLapiz;
    private Button botonLinea;
    private Button botonRectangulo;
    private Button botonElipse;
    private Button botonArco;
    private Button botonPoligono;

    public BarraHerramientas() {
        // setRollover(true);
        opcion = "LAPIZ";
        //setFloatable(false);
        inicializarComponentes();
       // actualizarEstadoBotones();
    }

    private void inicializarComponentes() {
        botonLapiz = new Button("LAPIZ");
        botonLinea = new Button("LINEA");
        botonRectangulo = new Button("RECTANGULO");
        botonElipse = new Button("ELIPSE");
        botonArco = new Button("ARCO");
        botonPoligono = new Button("POLIGONO");
        botonLapiz.setBackground(Color.red);
        botonLinea.setBackground(Color.orange);
        botonRectangulo.setBackground(Color.yellow);
        botonElipse.setBackground(Color.green);
        botonArco.setBackground(Color.blue);
        botonPoligono.setBackground(Color.cyan);
        botonLapiz.addActionListener(this);
        botonLinea.addActionListener(this);
        botonRectangulo.addActionListener(this);
        botonElipse.addActionListener(this);
        botonArco.addActionListener(this);
        botonPoligono.addActionListener(this);
        add(botonLapiz);
        add(botonLinea);
        add(botonArco);
        add(botonRectangulo);
        add(botonElipse);
        add(botonPoligono);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonLapiz) {
            opcion = "LAPIZ";
        } else if (e.getSource() == botonLinea) {
            opcion = "LINEA";
        } else if (e.getSource() == botonRectangulo) {
            opcion = "RECTANGULO";
        } else if (e.getSource() == botonElipse) {
            opcion = "ELIPSE";
        } else if (e.getSource() == botonArco) {
            opcion = "ARCO";
        } else if (e.getSource() == botonPoligono) {
            opcion = "POLIGONO";
        }
     //   actualizarEstadoBotones();
    }

    public String getOpcion() {
        return opcion;
    }
/*
    private void actualizarEstadoBotones() {
        if (opcion.equals("LAPIZ")) {
            botonLapiz.setSelected(true);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("LINEA")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(true);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("RECTANGULO")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(true);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("ELIPSE")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(true);
            botonArco.setSelected(false);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("ARCO")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(true);
            botonPoligono.setSelected(false);
        } else if (opcion.equals("POLIGONO")) {
            botonLapiz.setSelected(false);
            botonLinea.setSelected(false);
            botonRectangulo.setSelected(false);
            botonElipse.setSelected(false);
            botonArco.setSelected(false);
            botonPoligono.setSelected(true);
        }
    }*/
    public void setOpcion(String opcion) {
        this.opcion = opcion;
       // actualizarEstadoBotones();
    }
}
