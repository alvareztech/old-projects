package objetos;

import java.util.Scanner;

/**
 * Lista Simplemente Enlazada Circular
 * @author Daniel Alvarez (a3dany)
 */
public class ListaCircular {

    private Nodo P;

    public ListaCircular() {
        P = null;
    }

    public boolean esVacia() {
        return P == null;
    }

    /**
     * 
     * @param dato 
     */
    public void adicionarPrimero(Persona dato) {
        Nodo N = new Nodo(dato);    // nuevo nodo a adicionar
        if (esVacia()) {            // la lista esta vacia?
            P = N;
            P.setSiguiente(P);
        } else {
            Nodo X = P;
            while (X.getSiguiente() != P) { // mientras X no sea el ultimo nodo
                X = X.getSiguiente();
            } // ahora X es el ultimo nodo
            N.setSiguiente(P);
            P = N;
            X.setSiguiente(P);
        }
    }

    public void adicionarUltimo(Persona dato) {
        Nodo N = new Nodo(dato);    // nuevo nodo a adicionar
        if (esVacia()) {            // la lista esta vacia?
            P = N;
            P.setSiguiente(P);
        } else {
            Nodo X = P;
            while (X.getSiguiente() != P) { // mientras X no sea el ultimo nodo
                X = X.getSiguiente();
            } // ahora X es el ultimo nodo
            X.setSiguiente(N);
            N.setSiguiente(P);
        }
    }

    public void adicionar(Persona dato, int posicion) {
        if (posicion > 0 && posicion <= tamanio() + 1) { // i esta en el rango?
            if (posicion == 1) {
                adicionarPrimero(dato);
            } else {
                Nodo N = new Nodo(dato);   // nuevo nodo a adicionar
                Nodo X = P;
                for (int i = 0; i < posicion - 2; i++) {
                    X = X.getSiguiente();
                } // ahora X es un nodo antes de la posicion dada
                N.setSiguiente(X.getSiguiente());
                X.setSiguiente(N);
            }
        } else {
            System.err.println("La Posicion " + posicion + " esta fuera de rango.");
        }
    }

    public Persona eliminarPrimero() {
        Persona dato = null;
        if (esVacia()) {
            System.err.println("Lista Vacia! No se pudo eliminar.");
        } else {
            dato = P.getDato();
            if (P.getSiguiente() == P) { // tiene la lista un solo elemento?
                P = null;
            } else {
                Nodo X = P;
                while (X.getSiguiente() != P) { // mientras X no sea el ultimo nodo
                    X = X.getSiguiente();
                } // ahora X es el ultimo nodo
                P = P.getSiguiente();
                X.setSiguiente(P);
            }
        }
        return dato;
    }

    public Persona eliminarUltimo() {
        Persona dato = null;
        if (esVacia()) {
            System.err.println("Lista Vacia! No se pudo eliminar.");
        } else {
            if (P.getSiguiente() == P) { // tiene la lista un solo elemento?
                dato = P.getDato();
                P = null;
            } else {
                Nodo X = P;
                Nodo Y = P.getSiguiente();
                while (Y.getSiguiente() != P) { // mientras Y no sea el ultimo nodo
                    X = Y;
                    Y = Y.getSiguiente();
                } // ahora Y es el ultimo nodo
                dato = Y.getDato();
                X.setSiguiente(P);
            }
        }
        return dato;
    }

    public Persona eliminar(int posicion) {
        Persona dato = null;
        if (posicion > 0 && posicion <= tamanio()) { // i esta en el rango?
            if (posicion == 1) {
                dato = eliminarPrimero();
            } else {
                Nodo X = P;
                for (int i = 0; i < posicion - 2; i++) {
                    X = X.getSiguiente();
                } // ahora X es un nodo antes de la posicion dada
                dato = X.getSiguiente().getDato();
                X.setSiguiente(X.getSiguiente().getSiguiente());
            }
        } else {
            System.err.println("La Posicion " + posicion + " esta fuera de rango.");
        }
        return dato;
    }

    public int tamanio() {
        if (esVacia()) {
            return 0;
        } else {
            int c = 1;
            Nodo X = P;
            while (X.getSiguiente() != P) { // mientras X no sea el ultimo
                c++;
                X = X.getSiguiente();
            }
            return c;
        }
    }

    public void ordenar() {
        Nodo X = P;
        while (X.getSiguiente() != P) {
            Nodo Y = X.getSiguiente();
            while (Y != P) {
                if (X.getDato().getEdad() > Y.getDato().getEdad()) {
                    Persona aux = X.getDato();
                    X.setDato(Y.getDato());
                    Y.setDato(aux);
                }
                Y = Y.getSiguiente();
            }
            X = X.getSiguiente();
        }
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nro.Elementos: ");
        int n = in.nextInt();
        System.out.println("Ingrese Elementos:");
        for (int i = 0; i < n; i++) {
            Persona dato = new Persona();
            dato.leer();
            adicionarUltimo(dato);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.err.println("Lista Vacia! No se pudo mostrar nada.");
        } else {
            Nodo X = P;
            while (X.getSiguiente() != P) {
                Persona dato = X.getDato();
                dato.mostrar();
                X = X.getSiguiente();
            }
            X.getDato().mostrar();
            System.out.println();
        }
    }
}