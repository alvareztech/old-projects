package jpaint;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase Menu
 * @author Daniel Alvarez
 */
public class Menu2 extends MenuBar implements ActionListener {

    private VentanaPrincipal nucleo;
    private Menu menuArchivo;
    private Menu menuEdicion;
    private Menu menuAyuda;
    private Menu menuLineas;
    private Menu menuFiguras;
    private MenuItem itemNuevo;
    private MenuItem itemDeshacer;
    private MenuItem itemDibujoLibre;
    private MenuItem itemLineaRecta;
    private MenuItem itemArco;
    private MenuItem itemRectangulo;
    private MenuItem itemElipse;
    private MenuItem itemPoligono;
    private MenuItem itemAcercaDe;

    public Menu2(VentanaPrincipal nucleo) {
        this.nucleo = nucleo;
        inicializarComponentes();
    }

    private void inicializarComponentes() {
        //JPopupMenu.setDefaultLightWeightPopupEnabled(false); // para que Canvas no tape al Menu
        menuArchivo = new Menu("Archivo");
        menuEdicion = new Menu("Edicion");
        menuAyuda = new Menu("Ayuda");

        menuLineas = new Menu("Lineas");
        menuFiguras = new Menu("Figuras");

        itemNuevo = new MenuItem("Nuevo");
        itemNuevo.addActionListener(this);

        itemDibujoLibre = new MenuItem("Dibujo Libre");
        itemLineaRecta = new MenuItem("Recta");
        itemArco = new MenuItem("Arco");
        itemRectangulo = new MenuItem("Rectangulo");
        itemElipse = new MenuItem("Elipse");
        itemPoligono = new MenuItem("Poligono");

        itemDeshacer = new MenuItem("Deshacer");
        itemDeshacer.addActionListener(this);

        itemDibujoLibre.addActionListener(this);
        itemLineaRecta.addActionListener(this);
        itemArco.addActionListener(this);
        itemRectangulo.addActionListener(this);
        itemElipse.addActionListener(this);
        itemPoligono.addActionListener(this);

        itemAcercaDe = new MenuItem("Acerca de");
        itemAcercaDe.addActionListener(this);


        // Archivo
        menuArchivo.add(itemNuevo);
        // Edicion
        menuEdicion.add(itemDeshacer);
        menuEdicion.addSeparator();
        menuEdicion.add(itemDibujoLibre);

        menuLineas.add(itemLineaRecta);
        menuLineas.add(itemArco);
        menuEdicion.add(menuLineas);

        menuFiguras.add(itemRectangulo);
        menuFiguras.add(itemElipse);
        menuFiguras.add(itemPoligono);
        menuEdicion.add(menuFiguras);

        // Acerca De
        menuAyuda.add(itemAcercaDe);
        // MENU
        add(menuArchivo);
        add(menuEdicion);
        add(menuAyuda);
    }

    public void actionPerformed(ActionEvent e) {

        if (itemNuevo == e.getSource()) {
            nucleo.reiniciar();
        }
        if (itemDibujoLibre == e.getSource()) {
            nucleo.seleccionar("LAPIZ");
        }
        if (itemLineaRecta == e.getSource()) {
            nucleo.seleccionar("LINEA");
        }
        if (itemArco == e.getSource()) {
            nucleo.seleccionar("ARCO");
        }
        if (itemRectangulo == e.getSource()) {
            nucleo.seleccionar("RECTANGULO");
        }
        if (itemElipse == e.getSource()) {
            nucleo.seleccionar("ELIPSE");
        }
        if (itemPoligono == e.getSource()) {
            nucleo.seleccionar("POLIGONO");
        }
        if (itemDeshacer == e.getSource()) {
            nucleo.deshacer();
        }
        if (itemAcercaDe == e.getSource()) {
            final Dialog mensaje = new Dialog(nucleo);
            Label contenido = new Label("JPaint v.1  |  Daniel Alvarez  |  a3dany@gmail.com");
            mensaje.setTitle("Acerca de JPaint");
            Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
            // Se obtienen las dimensiones en pixels de la ventana.
             mensaje.setSize(300, 100);
            Dimension ventana = mensaje.getSize();
            // Una cuenta para situar la ventana en el centro de la pantalla.
            mensaje.setLocation((pantalla.width - ventana.width) / 2, (pantalla.height - ventana.height) / 2);
           
            mensaje.add(contenido);
            mensaje.setVisible(true);
            mensaje.addWindowListener(new WindowAdapter() {

                public void windowClosing(WindowEvent we) {
                    mensaje.setVisible(false);
                    //System.exit(WindowConstants.DISPOSE_ON_CLOSE);
                }
            });
            //JOptionPane.showMessageDialog(nucleo, "JPaint v.1\nDaniel Alvarez\na3dany@gmail.com", "Acerca de JPaint", JOptionPane.INFORMATION_MESSAGE);
        }
        //nucleo.repintar();
    }
}
