package objetos;

import java.util.Scanner;

/**
 * Clase Pila De Personas
 * @author Daniel Alvarez (a3dany)
 */
public class Pila {

    private final int MAXIMO = 100;
    private Persona[] V;
    private int tope;

    public Pila() {
        this.V = new Persona[MAXIMO];
        this.tope = -1;
    }

    public boolean esVacia() {
        return tope == -1;
    }

    public boolean esLlena() {
        return tope == MAXIMO - 1;
    }

    public void apilar(Persona a) {
        if (esLlena()) {
            System.out.println("Pila Llena! No se pudo apilar.");
        } else {
            tope++;
            V[tope] = a;
        }
    }

    public Persona desapilar() {
        Persona a = null;
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

    public Persona cima() {
        return V[tope];
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.print("Nro.Elementos: ");
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            Persona a = new Persona();
            a.leer();
            apilar(a);
        }
    }
    public void mostrar() {
        if (esVacia()) {
            System.out.println("Pila Vacia! No se pudo mostrar nada.");
        } else {
            Pila X = new Pila();
            while (!esVacia()) {
                Persona a = desapilar();
                a.mostrar();
                X.apilar(a);
            }
            this.vaciar(X);
            System.out.println("");
        }
    }
}