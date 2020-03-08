package caracteres;

/**
 * Clase Pila De Nodos
 * @author Daniel Alvarez (a3dany)
 */
public class Pila {

    private final int MAXIMO = 100;
    private Nodo[] V;
    private int tope;

    public Pila() {
        this.V = new Nodo[MAXIMO];
        this.tope = -1;
    }

    public boolean esVacia() {
        return tope == -1;
    }

    public boolean esLlena() {
        return tope == MAXIMO - 1;
    }

    public void adicionar(Nodo a) {
        if (esLlena()) {
            System.err.println("Pila Llena! No se pudo apilar.");
        } else {
            tope++;
            V[tope] = a;
        }
    }

    public Nodo eliminar() {
        Nodo a = null;
        if (esVacia()) {
            System.err.println("Pila Vacia! No se pudo desapilar.");
        } else {
            a = V[tope];
            tope--;
        }
        return a;
    }

    public void vaciar(Pila B) {
        while (!B.esVacia()) {
            this.adicionar(B.eliminar());
        }
    }

    public int tamanio() {
        return tope + 1;
    }

    public Nodo cima() {
        return V[tope];
    }
}