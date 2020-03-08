package enteros;

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

    public void adicionarPrimero(int a) {
        Nodo N = new Nodo(a); // nuevo nodo a adicionar
        if (esVacia()) { // la lista esta vacia?
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
            X = null;
        }
    }

    public void adicionarUltimo(int a) {
        Nodo N = new Nodo(a); // nuevo nodo a adicionar
        if (esVacia()) { // la lista esta vacia?
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

    public int eliminarPrimero() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
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

    public int eliminarUltimo() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
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
                Y = null; // solo para liberar memoria
            }
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
            while (X.getSiguiente() != P) {
                System.out.print(" " + X.getDato());
                X = X.getSiguiente();
            }
            System.out.print(" " + X.getDato());
            System.out.println();
        }
    }
}