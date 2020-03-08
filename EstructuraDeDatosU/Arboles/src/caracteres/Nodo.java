package caracteres;

/**
 * Clase Nodo de Arbol
 * @author Daniel Alvarez (a3dany)
 */
public class Nodo {

    private Nodo izquierdo;
    private char dato;
    private Nodo derecho;

    public Nodo() {
        this.izquierdo = null;
        this.dato = ' ';
        this.derecho = null;
    }

    public Nodo(char dato) {
        this.izquierdo = null;
        this.dato = dato;
        this.derecho = null;
    }

    public char getDato() {
        return dato;
    }

    public void setDato(char dato) {
        this.dato = dato;
    }

    public Nodo getDerecho() {
        return derecho;
    }

    public void setDerecho(Nodo derecho) {
        this.derecho = derecho;
    }

    public Nodo getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(Nodo izquierdo) {
        this.izquierdo = izquierdo;
    }

    public boolean esHoja() {
        return izquierdo == null && derecho == null;
    }
}