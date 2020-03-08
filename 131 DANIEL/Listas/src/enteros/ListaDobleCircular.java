package enteros;

import java.util.Scanner;

/**
 * Lista Doblemente Enlazada Circular
 * @author Daniel Alvarez (a3dany)
 */
public class ListaDobleCircular {

    private NodoDoble P;

    public ListaDobleCircular() {
        this.P = null;
    }

    public boolean esVacia() {
        return P == null;
    }

    public void adicionarPrimero(int a) {
        NodoDoble N = new NodoDoble(a);
        if (esVacia()) {
            P = N;
            P.setSiguiente(P);
            P.setAnterior(P);
        } else {
            NodoDoble X = P.getAnterior(); // ahora X es el ultimo nodo
            N.setSiguiente(P);
            N.setAnterior(X);
            P.setAnterior(N);
            P = N;
            X.setSiguiente(P);
        }
    }

    public void adicionarUltimo(int a) {
        NodoDoble N = new NodoDoble(a);
        if (esVacia()) {
            P = N;
            P.setSiguiente(P);
            P.setAnterior(P);
        } else {
            NodoDoble X = P.getAnterior(); // ahora X es el ultimo nodo
            X.setSiguiente(N);
            N.setAnterior(X);
            N.setSiguiente(P);
            P.setAnterior(N);
        }
    }

    public int eliminarPrimero() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else {
            dato = P.getDato();
            if (P.getSiguiente() == P) { // la lista tiene un solo elemento?
                P = null;
            } else {
                NodoDoble X = P.getAnterior(); // ahora X es el ultimo nodo
                P = P.getSiguiente();
                X.setSiguiente(P);
                P.setAnterior(X);
            }
        }
        return dato;
    }

    public int eliminarUltimo() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else {
            if (P.getSiguiente() == P) {
                dato = P.getDato();
                P = null;
            } else {
                NodoDoble X = P.getAnterior(); // ahora X es el ultimo nodo
                dato = X.getDato();
                X = X.getAnterior(); // ahora X es nuevo ultimo nodo
                X.setSiguiente(P);
                P.setAnterior(X);
            }
        }
        return dato;
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
            NodoDoble X = P;
            while (X.getSiguiente() != P) {
                System.out.print(" " + X.getDato());
                X = X.getSiguiente();
            }
            System.out.print(" " + X.getDato());
            System.out.println();
        }
    }
}
