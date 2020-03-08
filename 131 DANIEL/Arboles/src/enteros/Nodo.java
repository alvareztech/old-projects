package enteros;

/**
 * Clase Nodo de Arbol
 * @author Daniel Alvarez (a3dany)
 */
public class Nodo {

    private Nodo izquierdo;
    private int dato;
    private Nodo derecho;

    public Nodo() {
        this.izquierdo = null;
        this.dato = Integer.MIN_VALUE;
        this.derecho = null;
    }

    public Nodo(int dato) {
        this.izquierdo = null;
        this.dato = dato;
        this.derecho = null;
    }

    public int getDato() {
        return dato;
    }

    public void setDato(int dato) {
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