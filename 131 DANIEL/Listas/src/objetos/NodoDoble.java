package objetos;

/**
 * Clase Nodo Doble
 * @author Daniel Alvarez (a3dany)
 */
public class NodoDoble {

    private NodoDoble anterior;
    private Persona dato;
    private NodoDoble siguiente;

    public NodoDoble() {
        anterior = null;
        dato = null;
        siguiente = null;
    }

    public NodoDoble(Persona dato) {
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

    public Persona getDato() {
        return dato;
    }

    public void setDato(Persona dato) {
        this.dato = dato;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }
}