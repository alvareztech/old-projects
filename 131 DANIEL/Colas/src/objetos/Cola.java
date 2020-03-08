package objetos;

import java.util.Scanner;

/**
 * Clase Cola De Personas
 * @author Daniel Alvarez (a3dany)
 */
public class Cola {
    
    private final int MAXIMO = 101;
    private Persona[] V;
    private int inicio;
    private int fin;
    
    public Cola() {
        this.V = new Persona[MAXIMO];
        this.inicio = 0;
        this.fin = 0;
    }
    
    public boolean esVacia() {
        return inicio == fin;
    }
    
    public boolean esLlena() {
        return fin == MAXIMO - 1;
    }
    
    public void adicionar(Persona a) {
        if (esLlena()) {
            System.out.println("Cola Llena! No se pudo adicionar.");
        } else {
            fin++;
            V[fin] = a;
        }
    }
    
    public Persona eliminar() {
        Persona a = null;
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
            Persona a = new Persona();
            a.leer();
            adicionar(a);
        }
    }

    public void mostrar() {
        if (esVacia()) {
            System.out.println("Cola Vacia! No se pudo mostrar nada.");
        } else {
            Cola X = new Cola();
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
