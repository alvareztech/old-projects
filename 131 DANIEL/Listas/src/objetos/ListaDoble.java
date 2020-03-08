package objetos;

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

    public void adicionarPrimero(Persona dato) {
        NodoDoble N = new NodoDoble(dato); // nuevo nodo a adicionar
        if (esVacia()) {
            P = N;
        } else {
            N.setSiguiente(P);
            P.setAnterior(N);
            P = N;
        }
    }

    public void adicionarUltimo(Persona dato) {
        NodoDoble N = new NodoDoble(dato);
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

    public void adicionar(Persona dato, int posicion) {
        NodoDoble N = new NodoDoble(dato);
        NodoDoble X = P;
        for (int i = 0; i < posicion - 2; i++) {
            X = X.getSiguiente();
        }
        X.setSiguiente(N);
        N.setSiguiente(X.getSiguiente());
        X.setAnterior(N);

    }

    public Persona eliminarPrimero() {
        Persona dato = null;
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

    public Persona eliminarUltimo() {
        Persona dato = null;
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

    public void ordenar() {
        NodoDoble X = P;
        while (X.getSiguiente() != null) {
            NodoDoble Y = X.getSiguiente();
            while (Y != null) {
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
            Persona a = new Persona();
            a.leer();
            adicionarUltimo(a);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Lista Vacia! No se pudo mostrar nada.");
        } else {
            NodoDoble X = P;
            while (X != null) {
                Persona a = X.getDato();
                a.mostrar();
                X = X.getSiguiente();
            }
            System.out.println("");
        }
    }
}
