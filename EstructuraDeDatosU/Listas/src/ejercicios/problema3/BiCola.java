package ejercicios.problema3;

/**
 * Clase BiCola Basada En Una Lista Doblemente Enlazada
 * @author Daniel Alvarez (a3dany)
 */
public class BiCola {

    private NodoDoble P;

    public BiCola() {
        this.P = null;
    }

    public boolean esVacia() {
        return P == null;
    }

    public void adicionarIzquierda(String dato) {
        NodoDoble N = new NodoDoble(dato); // nuevo nodo a adicionar
        if (esVacia()) {
            P = N;
        } else {
            N.setSiguiente(P);
            P.setAnterior(N);
            P = N;
        }
    }

    public void adicionarDerecha(String dato) {
        NodoDoble N = new NodoDoble(dato);
        if (esVacia()) { // la bicola esta vacia?
            P = N;
        } else {
            NodoDoble X = P;
            while (X.getSiguiente() != null) { // mientras X no sea el ultimo
                X = X.getSiguiente();
            } // ahora X es el ultimo nodo
            X.setSiguiente(N);
            N.setAnterior(X);
        }
    }

    public String eliminarIzquierda() {
        String dato = null;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else {
            dato = P.getDato();
            if (P.getSiguiente() == null) { // la bicola tiene un solo elemento?
                P = null;
            } else {
                P = P.getSiguiente();
                P.setAnterior(null);
            }
        }
        return dato;
    }

    public String eliminarDerecha() {
        String dato = null;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else {
            if (P.getSiguiente() == null) { // la bicola tiene un solo nodo?
                dato = P.getDato();
                P = null;
            } else {
                NodoDoble X = P;
                while (X.getSiguiente() != null) { // mientras X no sea el ultimo nodo
                    X = X.getSiguiente();
                } // ahora X es el ultimo nodo
                dato = X.getDato();
                NodoDoble Y = X.getAnterior();
                Y.setSiguiente(null);
            }
        }
        return dato;
    }

    public void desplazar() {
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo mostrar nada.");
        } else {
            NodoDoble X = P;
            while (X != null) {
                String a = X.getDato();
                System.out.print(" "  + a);
                X = X.getSiguiente();
            }
            System.out.println();
        }
    }
}
