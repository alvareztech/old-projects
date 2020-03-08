package enteros;

/**
 * Clase Nodo Doble
 * @author Daniel Alvarez (a3dany)
 */
public class NodoDoble {

    private NodoDoble anterior;
    private int dato;
    private NodoDoble siguiente;

    public NodoDoble() {
        anterior = null;
        dato = Integer.MIN_VALUE;
        siguiente = null;
    }

    public NodoDoble(int dato) {
        this.anterior = null;
        this.dato = dato;
        this.siguiente = null;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}
