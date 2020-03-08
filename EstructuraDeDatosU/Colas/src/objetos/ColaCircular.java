package objetos;

import java.util.Scanner;

/**
 * Clase Cola Circular De Personas
 * @author Daniel Alvarez (a3dany)
 */
public class ColaCircular {

    private final int MAXIMO = 101;
    private Persona[] V;
    private int inicio;
    private int fin;

    public ColaCircular() {
        this.V = new Persona[MAXIMO];
        this.inicio = 0;
        this.fin = 0;
    }

    public boolean esVacia() {
        return inicio == fin;
    }

    public boolean esLlena() {
        return tamanio() == MAXIMO - 1;
    }

    public void adicionar(Persona a) {
        if (esLlena()) {
            System.out.println("Cola Llena! No se pudo adicionar.");
        } else {
            fin = (fin + 1) % MAXIMO;
            V[fin] = a;
        }
    }

    public Persona eliminar() {
        Persona a = null;
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
            Persona a = new Persona();
            a.leer();
            adicionar(a);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Cola Vacia! No se puede mostrar nada.");
        } else {
            ColaCircular X = new ColaCircular();
            while (!esVacia()) {
                Persona a = eliminar();
                a.mostrar();
                X.adicionar(a);
            }
            this.copiar(X);
            System.out.println("");
        }
    }
}