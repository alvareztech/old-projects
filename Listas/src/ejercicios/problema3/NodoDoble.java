package ejercicios.problema3;

/**
 * Clase Nodo Doble
 * @author Daniel Alvarez (a3dany)
 */
public class NodoDoble {

    private NodoDoble anterior;
    private String dato;
    private NodoDoble siguiente;

    public NodoDoble() {
        anterior = null;
        dato = null;
        siguiente = null;
    }

    public NodoDoble(String dato) {
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

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}