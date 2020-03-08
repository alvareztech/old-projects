package enteros;

import java.util.Scanner;

/**
 * Clase Lista Simplemente Enlazada
 * @author Daniel Alvarez (a3dany)
 */
public class Lista {

    private Nodo P;

    public Lista() {
        P = null;
    }

    public boolean esVacia() {
        return P == null;
    }

    public void adicionarPrimero(int a) {
        Nodo N = new Nodo(a);   // nuevo nodo a adicionar
        N.setSiguiente(P);
        P = N;
    }

    public void adicionarUltimo(int a) {
        Nodo N = new Nodo(a);   // nuevo nodo a adicionar
        if (esVacia()) {        // la lista esta vacia?
            N.setSiguiente(P);
            P = N;
        } else {
            Nodo X = P;
            while (X.getSiguiente() != null) { // mientras X no sea el ultimo nodo
                X = X.getSiguiente();
            } // ahora X es el ultimo nodo
            X.setSiguiente(N);
        }
    }

    public int eliminarPrimero() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) { // la lista tiene al menos un elemento?
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else {
            dato = P.getDato();
            P = P.getSiguiente();
        }
        return dato;
    }

    public int eliminarUltimo() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else { // tiene al menos un elemento la lista?
            if (P.getSiguiente() == null) { // tiene la lista un solo elemento?
                dato = P.getDato();
                P = null;
            } else {
                Nodo X = P;
                Nodo Y = P.getSiguiente();
                while (Y.getSiguiente() != null) { // mientras Y no sea el ultimo nodo
                    X = Y;
                    Y = Y.getSiguiente();
                } // ahora Y es el ultimo nodo
                dato = Y.getDato();
                X.setSiguiente(null);
                Y = null; // solo para liberar memoria
            }
        }
        return dato;
    }

    public int tamanio() {
        int c = 0;
        Nodo X = P;
        while (X != null) { // mientras X no haya pasado por todos los nodos de la lista
            c++;
            X = X.getSiguiente();
        }
        return c;
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nro.Elementos: ");
        int n = in.nextInt();
        System.out.println("Ingrese Elementos:");
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            adicionarUltimo(a);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo mostrar nada.");
        } else {
            Nodo X = P;
            while (X != null) {
                System.out.print(" " + X.getDato());
                X = X.getSiguiente();
            }
            System.out.println();
        }
    }

    public void ordenar() {
        Nodo X = P;
        while (X.getSiguiente() != null) {
            Nodo Y = X.getSiguiente();
            while (Y != null) {
                if (X.getDato() > Y.getDato()) {
                    int aux = X.getDato();
                    X.setDato(Y.getDato());
                    Y.setDato(aux);
                }
                Y = Y.getSiguiente();
            }
            X = X.getSiguiente();
        }
    }
}
