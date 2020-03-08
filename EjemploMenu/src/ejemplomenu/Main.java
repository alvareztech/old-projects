package ejemplomenu;

import java.awt.*;
import javax.swing.*;

class Ventana extends JFrame {

    private JMenuBar mb;

    Ventana() {
// Se crea una bar ra de men´us
        mb = new JMenuBar();
// Creamos un elemento d e l men´u
        JMenu archivo = new JMenu("Archivo");
        archivo.setFont(new Font("Arial", Font.PLAIN, 20));
// Creamos y a˜nadimos submen´us
        JMenuItem nuevo = new JMenuItem("Nuevo");
        nuevo.setFont(new Font("Arial", Font.PLAIN, 16));
        archivo.add(nuevo);
        JMenuItem abrir = new JMenuItem("Abrir");
        abrir.setFont(new Font("Arial ", Font.PLAIN, 16));
        archivo.add(abrir);
        JMenuItem ver = new JMenuItem("Ver todos");
        ver.setFont(new Font("Arial", Font.PLAIN, 16));
        archivo.add(ver);
// Ahora a˜nadimos ar chi vo a l a bar ra de menus
        mb.add(archivo);
// Creamos ot ro elemento d e l men´u
        JMenu editar = new JMenu("Editar ");
        editar.setFont(new Font("Arial ", Font.PLAIN, 20));
// Creamos y a˜nadimos submen´us
        JMenuItem copiar = new JMenuItem("Copiar");
        copiar.setFont(new Font("Arial", Font.PLAIN, 16));
        editar.add(copiar);
        JMenuItem pegar = new JMenuItem("Pegar");
        pegar.setFont(new Font("Arial", Font.PLAIN, 16));
        editar.add(pegar);
        JMenuItem cortar = new JMenuItem("Cortar");
        cortar.setFont(new Font("Arial", Font.PLAIN, 16));
        editar.add(cortar);
// A˜nadimos e d i t a r a l a bar ra de menu
        mb.add(editar);
        setJMenuBar(mb);
        setSize(500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Ventana();
    }
}
