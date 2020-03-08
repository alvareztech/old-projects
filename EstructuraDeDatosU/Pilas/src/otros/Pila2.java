package otros;

import java.util.Scanner;
import java.util.Vector;

/**
 * Clase Pila2
 * @author Daniel
 */
public class Pila2 {

    private Vector<Integer> V;
    private int tamanio;

    public Pila2() {
        V = new Vector<Integer>();
        tamanio = 0;
    }

    public boolean esVacia() {
        return tamanio == 0;
    }

    public void apilar(int a) {
        V.add(tamanio, a);
        tamanio++;
    }

    public int desapilar() {
        if (!esVacia()) {
            tamanio--;
            return V.get(tamanio);
        } else {
            return -1;
        }
    }

    public int nroElementos() {
        return tamanio;
    }

    public void vaciar(Pila2 B) {
        while (!B.esVacia()) {
            apilar(B.desapilar());
        }
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            apilar(a);
        }
    }

    public void mostrar() {
        Pila2 AUX = new Pila2();
        while (!esVacia()) {
            int a = desapilar();
            System.out.println(a);
            AUX.apilar(a);
        }
        vaciar(AUX);
    }
}
