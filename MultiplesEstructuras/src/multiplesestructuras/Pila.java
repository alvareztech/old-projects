package multiplesestructuras;

import java.util.Scanner;

/**
 * Clase Pila
 * @author Daniel Alvarez (a3dany)
 */
public class Pila {

    private final int MAXIMO = 100;
    private int[] V;
    private int tope;

    public Pila() {
        this.V = new int[MAXIMO];
        this.tope = -1;
    }

    public boolean esVacia() {
        return tope == -1;
    }

    public boolean esLlena() {
        return tope == MAXIMO - 1;
    }

    public void apilar(int a) {
        if (esLlena()) {
            System.out.println("Pila Llena! No se pudo apilar.");
        } else {
            tope++;
            V[tope] = a;
        }
    }

    public int desapilar() {
        int a = Integer.MIN_VALUE;
        if (esVacia()) {
            System.out.println("Pila Vacia! No se pudo desapilar.");
        } else {
            a = V[tope];
            tope--;
        }
        return a;
    }

    public void vaciar(Pila B) {
        while (!B.esVacia()) {
            this.apilar(B.desapilar());
        }
    }

    public int tamanio() {
        return tope + 1;
    }

    public int cima() {
        return V[tope];
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nro.Elementos: ");
        int n = in.nextInt();
        System.out.println("Ingrese elementos:");
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            apilar(a);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Pila Vacia! No se pudo mostrar nada.");
        } else {
            Pila X = new Pila();
            while (!esVacia()) {
                int a = desapilar();
                System.out.println(" " + a);
                X.apilar(a);
            }
            this.vaciar(X);
            System.out.println("");
        }
    }

    public void vaciar(Pila B, int ne) {
        for (int i = 0; i < ne; i++) {
            this.apilar(B.desapilar());
        }
    }

    public void separarParesImpares(Pila B) {
        this.vaciar(B);
        int r = this.tamanio() + B.tamanio();
        int cp = 0;
        for (int i = r; i > 0; i--) {
            int a = this.desapilar();
            System.out.println(">>> " + a);
            if (a % 2 == 1) {
                B.apilar(a);
                cp++;
            } else {
                B.vaciar(this, i - 1);
                this.apilar(a);
                this.vaciar(B, i - 1);
            }
        }
    }

    /**
     * Ordenar la Pila ascendentemente (metodoso nativos)
     */
    public void ordenar() {
        Pila X = new Pila();
        Pila Y = new Pila();
        while (!esVacia()) {
            int e = desapilar();
            while (!esVacia()) {
                int a = desapilar();
                if (e > a) {
                    int aux = a;
                    a = e;
                    e = aux;
                }
                Y.apilar(a);
            }
            X.apilar(e);
            this.vaciar(Y);
        }
        this.vaciar(X);
    }

    /**
     * Ordenar la Pila ascendentemente (metodoso nativos)
     * NO FUNCIONA IMPLEMENTAR VACIAR ESPECIAL
     */
    public void ordenar2() {
        Pila X = new Pila();
        while (!esVacia()) {
            int e = desapilar();
            for (int i = 0; i < this.tamanio(); i++) {
                int a = desapilar();
                if (e > a) {
                    int aux = a;
                    a = e;
                    e = aux;
                }
                //this.apilar(a);
            }
            X.apilar(e);
        }
        this.vaciar(X);
    }
}
