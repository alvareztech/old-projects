package listas;

/**
 *
 * @author Daniel
 */
public class Nodo {

    private Nodo siguiente;
    private int dato;

    public Nodo() {
        siguiente = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

}
