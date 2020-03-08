package listas;

/**
 *
 * @author Daniel
 */
public class ListaSimple {

    private Nodo p;

    public ListaSimple() {
        p = null;
    }

    public boolean esVacia() {
        if (p == null) {
            return true;
        } else {
            return false;
        }
    }

    public void adicionarPrimero(int e) {
        Nodo x = new Nodo();
        x.setDato(e);
        x.setSiguiente(p);
        p = x;
    }
}
