package colas;

import java.util.Scanner;

/**
 * Clase Cola Circular
 * @author Daniel Alvarez (a3dany)
 */
public class ColaCircular {

    private final int MAXIMO = 100;
    private int[] V;
    private int inicio;
    private int fin;

    public ColaCircular() {
        this.V = new int[MAXIMO + 1];
        this.inicio = 0;
        this.fin = 0;
    }

    public boolean esVacia() {
        return inicio == fin;
    }

    public boolean esLlena() {
        return tamanio() == MAXIMO - 1;
    }

    public void adicionar(int a) {
        if (esLlena()) {
            System.out.println("Cola Llena! No se pudo adicionar.");
        } else {
            fin = (fin + 1) % MAXIMO;
            V[fin] = a;
        }
    }

    public int eliminar() {
        int a = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Cola Vacia! No se pudo eliminar.");
        } else {
            inicio = (inicio + 1) % MAXIMO;
            a = V[inicio];
        }
        return a;
    }

    public int tamanio() {
        return (fin - inicio + MAXIMO) % MAXIMO;
    }

    private void copiar(ColaCircular B) {
        while (!B.esVacia()) {
            adicionar(B.eliminar());
        }
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nro.Elementos: ");
        int n = in.nextInt();
        System.out.println("Ingrese elementos:");
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            adicionar(a);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Cola Vacia! No se puede mostrar nada.");
        } else {
            ColaCircular X = new ColaCircular();
            while (!esVacia()) {
                int a = eliminar();
                System.out.print(" " + a);
                X.adicionar(a);
            }
            this.copiar(X);
            System.out.println("");
        }
    }

    /**
     * Ordena la Cola Circular de acuerdo al elemento que tenga. (metodos nativos)
     */
    public void ordenar() {
        ColaCircular X = new ColaCircular();
        ColaCircular Y = new ColaCircular();
        while (!esVacia()) {
            int e = eliminar();
            while (!esVacia()) {
                int a = eliminar();
                if (e > a) {
                    int aux = a;
                    a = e;
                    e = aux;
                }
                Y.adicionar(a);
            }
            X.adicionar(e);
            this.copiar(Y);
        }
        this.copiar(X);
    }

    /**
     * Ordena la Cola Circular de acuerdo al elemento que tenga. (metodo tamanio())
     */
    public void ordenar2() {
        ColaCircular X = new ColaCircular();
        while (!esVacia()) {
            int e = eliminar();
            for (int j = 0; j < this.tamanio(); j++) {
                int a = eliminar();
                if (e > a) {
                    int aux = a;
                    a = e;
                    e = aux;
                }
                adicionar(a);
            }
            X.adicionar(e);
        }
        this.copiar(X);
    }
}
