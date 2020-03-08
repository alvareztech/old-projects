package objetos;

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

    /**
     * Retorna true si es la Lista esta vacia caso contrario retorna false.
     * @return boolean
     */
    public boolean esVacia() {
        return P == null;
    }

    /**
     * Adiciona un objeto "Persona" al principo de la Lista.
     * @param a objeto "Persona".
     */
    public void adicionarPrimero(Persona dato) {
        Nodo N = new Nodo(dato); // nuevo nodo a adicionar
        N.setSiguiente(P);
        P = N;
    }

    /**
     * Adicionar un objeto "Persona" al final de la Lista.
     * @param a objeto "Persona".
     */
    public void adicionarUltimo(Persona dato) {
        Nodo N = new Nodo(dato);   // nuevo nodo a adicionar
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

    /**
     * Adiciona un objeto "Persona" a la Lista en la posicion indicada.
     * @param dato objeto "Persona".
     * @param i posicion.
     */
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

    /**
     * Elimina y retorna el primer objeto de la Lista.
     * @return Persona
     */
    public Persona eliminarPrimero() {
        Persona a = null;
        if (esVacia()) {    // la lista esta vacia?
            System.err.println("Lista Vacia! No se pudo eliminar.");
        } else {
            a = P.getDato();
            P = P.getSiguiente();
        }
        return a;
    }

    /**
     * Elimina y retorna el ultimo objeto de la Lista.
     * @return Persona
     */
    public Persona eliminarUltimo() {
        Persona dato = null;
        if (esVacia()) {
            System.err.println("Lista Vacia! No se pudo eliminar.");
        } else { // tiene al menos un elemento la lista
            if (P.getSiguiente() == null) { // tiene la lista un solo elemento?
                dato = P.getDato();
                P = null;
            } else {
                Nodo X = P;
                Nodo Y = P.getSiguiente();
                while (Y.getSiguiente() != null) { // mientras Y no sea el ultimo nodo
                    X = Y;
                    Y = Y.getSiguiente();
                } // ahora Y es el ultimo nodo y X es el penultimo
                dato = Y.getDato();
                X.setSiguiente(null);
            }
        }
        return dato;
    }

    /**
     * Elimina y retorna el objeto en la posicion indicada.
     * @param posicion
     * @return Persona
     */
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

    /**
     * 
     * @param posicion
     * @return 
     */
    public Persona eliminar2(int posicion) {
        Persona dato = null;
        if (posicion > 0 && posicion <= tamanio()) { // i esta en el rango?
            if (posicion == 1) {
                dato = eliminarPrimero();
            } else {
                Nodo X = P;
                Nodo Y = P.getSiguiente();
                for (int i = 0; i < posicion - 2; i++) {
                    X = Y;
                    Y = Y.getSiguiente();
                } // ahora Y es el nodo en la posicion dada y X es una posicion antes
                dato = Y.getDato();
                X.setSiguiente(Y.getSiguiente());
            }
        } else {
            System.err.println("La posicion " + posicion + " esta fuera de rango.");
        }
        return dato;
    }

    /**
     * Retorna el numero de elementos existentes en la Lista.
     * @return int
     */
    public int tamanio() {
        int c = 0;
        Nodo X = P;
        while (X != null) { // mientras X no haya pasado por todos los nodos de la lista
            c++;
            X = X.getSiguiente();
        }
        return c;
    }

    /**
     * Lee datos por consola.
     */
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

    /**
     * Muestra datos por consola
     */
    public void mostrar() {
        if (esVacia()) {
            System.err.println("Lista Vacia! No se pudo mostrar nada.");
        } else {
            Nodo X = P;
            while (X != null) {
                Persona a = X.getDato();
                a.mostrar();
                X = X.getSiguiente();
            }
            System.out.println();
        }
    }

    /**
     * Ordena ascendentemente la Lista
     */
    public void ordenar() {
        Nodo X = P;
        while (X.getSiguiente() != null) {
            Nodo Y = X.getSiguiente();
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
}
