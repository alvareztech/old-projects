package ejercicios.problema2;

/**
 * Lista Simplemente Enlazada Circular
 * Con Todas Las Operaciones Realizadas En El Nodo "actual"
 * @author Daniel Alvarez (a3dany)
 */
public class ListaCircular {

    private Nodo actual;

    public ListaCircular() {
        actual = null;
    }

    public void insertar(String dato) {
        Nodo N = new Nodo(dato);    // nuevo nodo a insertar
        if (actual == null) {       // la lista esta vacia?
            actual = N;
            actual.setSiguiente(actual);
        } else {
            N.setSiguiente(actual.getSiguiente());
            actual.setSiguiente(N);
        }
    }

    public int buscar(String dato) {
        int posicion = -1;
        Nodo X = actual;
        int c = 1;
        while (X.getSiguiente() != actual) {
            if (X.getDato().equals(dato)) {
                posicion = c;
            }
            X = X.getSiguiente();
            c++;
        }
        if (X.getDato().equals(dato)) {
            posicion = c;
        }
        return posicion;
    }

    public String eliminar() {
        String dato = "";
        if (actual == null) {
            System.err.println("Lista Vacia! No se pudo eliminar.");
        } else {
            dato = actual.getDato();
            if (actual.getSiguiente() == actual) { // tiene la lista un solo elemento?
                actual = null;
            } else {
                Nodo X = actual;
                while (X.getSiguiente() != actual) { // mientras X no sea el ultimo nodo
                    X = X.getSiguiente();
                } // ahora X es el ultimo nodo
                actual = actual.getSiguiente();
                X.setSiguiente(actual);
            }
        }
        return dato;
    }

    public void desplegar() {
        Nodo X = actual;
        while (X.getSiguiente() != actual) {
            System.out.print("   " + X.getDato());
            X = X.getSiguiente();
        }
        System.out.println("   " + X.getDato());
    }

    public void avanzar() {
        actual = actual.getSiguiente();
    }
}
