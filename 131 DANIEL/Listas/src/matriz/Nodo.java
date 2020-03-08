package matriz;

/**
 * Nodo de Matriz
 * @author Daniel Alvarez
 */
public class Nodo {

    private int dato;
    private Nodo arriba;
    private Nodo izquierda;
    private Nodo derecha;
    private Nodo abajo;

    public Nodo(int a) {
        dato = a;
        arriba = null;
        izquierda = null;
        derecha = null;
        abajo = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getAbajo() {
        return abajo;
    }

    public void setAbajo(Nodo abajo) {
        this.abajo = abajo;
    }

    public Nodo getArriba() {
        return arriba;
    }

    public void setArriba(Nodo arriba) {
        this.arriba = arriba;
    }

    public Nodo getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    public Nodo getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }
}
