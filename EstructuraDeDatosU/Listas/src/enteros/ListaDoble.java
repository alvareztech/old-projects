package enteros;

import java.util.Scanner;

/**
 * Clase Lista Doblemente Enlazada
 * @author Daniel Alvarez (a3dany)
 */
public class ListaDoble {

    private NodoDoble P;

    public ListaDoble() {
        this.P = null;
    }

    public boolean esVacia() {
        return P == null;
    }

    public void adicionarPrimero(int a) {
        NodoDoble N = new NodoDoble(a); // nuevo nodo a adicionar
        if (esVacia()) {
            P = N;
        } else {
            N.setSiguiente(P);
            P.setAnterior(N);
            P = N;
        }
    }

    public void adicionarUltimo(int a) {
        NodoDoble N = new NodoDoble(a);
        if (esVacia()) { // la lista esta vacia?
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

    public int eliminarPrimero() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else {
            dato = P.getDato();
            if (P.getSiguiente() == null) { // la lista tiene un solo elemento?
                P = null;
            } else {
                P = P.getSiguiente();
                P.setAnterior(null);
            }
        }
        return dato;
    }

    public int eliminarUltimo() {
        int dato = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo eliminar.");
        } else {
            if (P.getSiguiente() == null) { // la lista tiene un solo nodo?
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

    public int tamanio() {
        int c = 0;
        NodoDoble X = P;
        while (X != null) {
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
            NodoDoble X = P;
            while (X != null) {
                System.out.print(" " + X.getDato());
                X = X.getSiguiente();
            }
            System.out.println("");
        }
    }
}
