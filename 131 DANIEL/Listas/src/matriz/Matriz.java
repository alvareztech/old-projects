package matriz;

import java.util.Scanner;

/**
 *
 * @author Daniel Alvarez
 */
public class Matriz {

    private Nodo P;

    public Matriz() {
        P = null;
    }

    public Matriz(Nodo P) {
        this.P = P;
    }

    public boolean esVacia() {
        return P == null;
    }

    int nroNodos() {
        int cont = 0;
        Nodo q = P;
        while (q != null) {
            cont++;
            q = q.getDerecha();
        }
        return (cont * cont);
    }

    void adicionarPrincipio(int a) {
        Nodo w = new Nodo(a);
        w.setDerecha(P);
        if (P != null) {
            P.setIzquierda(w);
        }
        P = w;
    }

    void adicionarAbajoDe(int a, int i) {
        int cont = 1;
        Nodo q = P;
        Nodo w = new Nodo(a);
        while (cont != i) {
            q = q.getDerecha();
            cont++;
        }
        while (q.getAbajo() != null) {
            q = q.getAbajo();
        }
        q.setAbajo(w);
        w.setArriba(q);
        Nodo r = q;
        if (q.getIzquierda() != null) {
            q = q.getIzquierda();
            if (q.getAbajo() != null) {
                q = q.getAbajo();
                q.setDerecha(w);
                w.setIzquierda(q);
            }
        }
        if (r.getDerecha() != null) {
            r = r.getDerecha();
            if (r.getAbajo() != null) {
                r = r.getAbajo();
                r.setIzquierda(w);
                w.setDerecha(r);
            }
        }
    }

    void adicionarFinal(int a) {
        Nodo w = new Nodo(a);
        Nodo r;
        if (esVacia()) {
            P = w;
        } else {
            r = P;
            while (r.getDerecha() != null) {
                r = r.getDerecha();
            }
            r.setDerecha(w);
            w.setIzquierda(r);
        }
    }

    void leer(int n) {
        Scanner in = new Scanner(System.in);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(" (" + i + ", " + j + ") = ");
                int k = in.nextInt();
                if (i == 1) {
                    adicionarFinal(k);
                } else {
                    adicionarAbajoDe(k, j);
                }
            }
        }
    }

    void leer1(int n) {
        int i;
        for (i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1) {
                    int k = (int) (Math.random() * 10);

                    adicionarFinal(k);

                } else {

                    int k = (int) (Math.random() * 10);

                    adicionarAbajoDe(k, j);
                }
            }
        }
    }

    public void mostrar() {
        int cont = 1;
        Nodo r;
        Nodo k = P;
        while (k != null) {
            r = k;
            while (r != null) {
                System.out.print(" " + r.getDato());
                r = r.getDerecha();
                cont++;
            }
            System.out.println("");
            k = k.getAbajo();
        }
    }
    /*
    void mostrarDiagonalP() {
    int ck = 1;
    Nodo r;
    Nodo k = p;
    while (k != null) {
    r = k;
    System.out.println(" ");
    int cont = 1;
    while (r != null) {
    if (cont == ck) {
    System.out.print(r.nroAleatorio + "  ");
    }
    System.out.print("  ");
    r = r.DirSig;
    cont++;
    }
    k = k.DirAbajo;
    ck++;
    }
    System.out.println("");
    }
    
    void mostrarDiagonalS() {
    int ck = (int) (Math.sqrt(nronodos()));
    Nodo r;
    Nodo k = p;
    while (k != null) {
    r = k;
    System.out.println();
    int cont = 1;
    while (r != null) {
    if (cont == ck) {
    System.out.print(r.nroAleatorio + "  ");
    }
    System.out.print("  ");
    r = r.DirSig;
    cont++;
    }
    k = k.DirAbajo;
    ck--;
    }
    System.out.println("");
    }
    /*
    public void ESMagica() {
    Nodo r;
    Nodo k = p;
    int cont = 0;
    int sw = 0;
    int sumaG = 0;
    int suma;
    while (k != null) {
    r = k;
    if (cont == 0) {
    while (r != null) {
    sumaG = sumaG + r.nroAleatorio;
    r = r.DirSig;
    }
    cont++;
    } else {
    suma = 0;
    while (r != null) {
    suma = suma + r.nroAleatorio;
    r = r.DirSig;
    }
    if (sumaG != suma) {
    sw = 1;
    }
    }
    k = k.DirAbajo;
    }
    k = p;
    while (k != null) {
    r = k;
    suma = 0;
    while (r != null) {
    suma = suma + r.nroAleatorio;
    r = r.DirAbajo;
    }
    if (sumaG != suma) {
    sw = 1;
    }
    k = k.DirSig;
    }
    if (sw != 1) {
    System.out.print(" La matriz es magica");
    } else {
    System.out.print(" La matriz No es magica");
    }
    System.out.println("  ");
    System.out.println("  ");
    }
     * 
     */
}
