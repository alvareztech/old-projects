package a3d;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Clase EventosTeclado
 * @author Daniel Alvarez (a3dany)
 */
public class Teclado implements KeyListener {

    private Grafico nucleo;

    public Teclado(Grafico nucleo) {
        this.nucleo = nucleo;
    }

    public void keyTyped(KeyEvent e) {  // cuando se presiona una combinacion
    }

    public void keyPressed(KeyEvent e) { // cuando se presiona cualquier tecla
        switch (e.getKeyCode()) {
            case 38:    // arriba
                nucleo.moverAdelante();
                break;
            case 40:    // abajo
                nucleo.moverAtras();
                break;
            case 37:    // izquierda
                nucleo.moverIzquierda();
                break;
            case 39:    // derecha
                nucleo.moverDerecha();
                break;
            case 76:    // l
                nucleo.llover();
                break;
            case 83:    // s
                nucleo.solear();
                break;
        }
    }

    public void keyReleased(KeyEvent e) { // cuando se deja de presionar
        //System.out.println("Released");
    }
}
