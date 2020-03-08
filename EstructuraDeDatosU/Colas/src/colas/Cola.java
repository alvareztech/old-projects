package colas;

import java.util.Scanner;

/**
 * Clase Cola
 * @author Daniel Alvarez (a3dany)
 */
public class Cola {

    private final int MAXIMO = 100;
    private int[] V;
    private int inicio;
    private int fin;

    public Cola() {
        this.V = new int[MAXIMO + 1];
        this.inicio = 0;
        this.fin = 0;
    }

    public boolean esVacia() {
        return inicio == fin;
    }

    public boolean esLlena() {
        return fin == MAXIMO - 1;
    }

    public void adicionar(int a) {
        if (esLlena()) {
            System.out.println("Cola Llena! No se pudo adicionar.");
        } else {
            fin++;
            V[fin] = a;
        }
    }

    public int eliminar() {
        int a = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Cola Vacia! No se pudo eliminar.");
        } else {
            inicio++;
            a = V[inicio];
        }
        return a;
    }

    public int tamanio() {
        return fin - inicio;
    }

    private void copiar(Cola B) {
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
            System.out.println("Cola Vacia! No se pudo mostrar nada.");
        } else {
            Cola X = new Cola();
            while (!esVacia()) {
                int a = eliminar();
                System.out.print(" " + a);
                X.adicionar(a);
            }
            this.copiar(X);
            System.out.println("");
        }
    }

    public void colocarParesAlPrincipio() {

        for (int i = 0; i < tamanio(); i++) {
        }
    }
}
