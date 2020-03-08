package estructuradedatos;

/**
 * Clase Pila
 * @author Daniel
 */
public class Pila {

    private int tope;
    private int[] V;

    public Pila() {
        tope = 0;
    }

    public void apilar(int e) {
        tope = tope + 1;
        V[tope] = e;
    }

    public void desapilar() {
        int e = V[tope];
        tope = tope - 1;
    }

    public boolean esVacia() {
        if (tope == 0) {
            return true;
        } else {
            return false;
        }
    }
}
