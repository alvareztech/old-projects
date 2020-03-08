package enteros;

import java.util.Scanner;

/**
 * Clase Arbol De Enteros
 * @author Daniel Alvarez (a3dany)
 */
public class Arbol {

    private Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public boolean esVacia() {
        return raiz == null;
    }

    public void adicionar(int a) {
        Nodo N = new Nodo(a);
        //N.dato=a;
        if (esVacia()) {
            raiz = N;
        } else {
            Nodo X = raiz;
            boolean sw = true;
            while (sw) {
                if (a > X.getDato()) {
                    if (X.getDerecho() == null) {//x.der==null
                        X.setDerecho(N); // X.der=N
                        sw = false;
                    } else {
                        X = X.getDerecho();
                    }
                } else {
                    if (X.getIzquierdo() == null) {
                        X.setIzquierdo(N);
                        sw = false;
                    } else {
                        X = X.getIzquierdo();
                    }
                }
            }
        }
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        Nodo X, Y = null;
        Nodo R = new Nodo();
        Pila pila = new Pila();
        Pila pilaTemporal = new Pila();
        System.out.print(" Raiz: ");
        R.setDato(in.nextInt());
        pila.adicionar(R);
        while (!pila.esVacia()) {
            X = pila.eliminar();
            System.out.print(" (" + X.getDato() + ") tiene nodo izquierdo? ");
            String respuesta = in.next();
            if (respuesta.equals("s")) {
                Y = new Nodo();
                System.out.print("     Nodo Izquierdo: ");
                Y.setDato(in.nextInt());
                X.setIzquierdo(Y);
                pilaTemporal.adicionar(Y);
            } else {
                X.setIzquierdo(null);
            }
            System.out.print(" (" + X.getDato() + ") tiene nodo derecho? ");
            respuesta = in.next();
            if (respuesta.equals("s")) {
                Y = new Nodo();
                System.out.print("     Nodo Derecho: ");
                Y.setDato(in.nextInt());
                X.setDerecho(Y);
                pilaTemporal.adicionar(Y);
            } else {
                X.setDerecho(null);
            }
            pila.vaciar(pilaTemporal);
        }
        raiz = R;
    }

    public void recorridoPorNiveles() {
        Pila nodosNivel = new Pila();
        Pila nodosDescendientes = new Pila();
        nodosNivel.adicionar(raiz);
        while (!nodosNivel.esVacia()) {
            while (!nodosNivel.esVacia()) {
                Nodo X = nodosNivel.eliminar();
                System.out.print(" " + X.getDato());
                if (X.getIzquierdo() != null) {
                    nodosDescendientes.adicionar(X.getIzquierdo());
                }
                if (X.getDerecho() != null) {
                    nodosDescendientes.adicionar(X.getDerecho());
                }
            }
            nodosNivel.vaciar(nodosDescendientes);
            System.out.println();
        }
    }

    public void recorridoPreOrden() {
        Pila pila = new Pila();
        pila.adicionar(raiz);
        while (!pila.esVacia()) { // mientras la Pila no este vacia.
            Nodo X = pila.eliminar();
            System.out.print(" " + X.getDato());
            if (X.getDerecho() != null) {
                pila.adicionar(X.getDerecho());
            }
            if (X.getIzquierdo() != null) {
                pila.adicionar(X.getIzquierdo());
            }
        }
    }

    public void recorridoInOrden() {
        Pila pila = new Pila();
        pila.adicionar(null);
        Nodo X = raiz;
        while (!pila.esVacia()) { // mientras la pila de nodos no sea vacia
            while (X != null) {
                pila.adicionar(X);
                X = X.getIzquierdo();
            }
            X = pila.eliminar(); // ahora X es el mas de la izquierda
            if (X != null) {
                System.out.print(" " + X.getDato());
                X = X.getDerecho();
            }
        }
    }

    public void recorridoPostOrden() {
        Pila pila = new Pila();
        Nodo X = raiz;
        pila.adicionar(null);
        while (!pila.esVacia()) {
            while (X != null) {
                pila.adicionar(X);
                if (X.getDerecho() != null) {
                    pila.adicionar(X.getDerecho());
                    pila.adicionar(null);
                }
                X = X.getIzquierdo();
            }
            X = pila.eliminar();
            while (X != null) {
                System.out.print(" " + X.getDato());
                X = pila.eliminar();
            }
            if (!pila.esVacia()) {
                X = pila.eliminar();
            }
        }
    }

    public void recorridoPreOrden(Nodo X) {
        if (X != null) {
            System.out.print(" " + X.getDato());
            recorridoPreOrden(X.getIzquierdo());
            recorridoPreOrden(X.getDerecho());
        }
    }

    public void recorridoInOrden(Nodo X) {
        if (X != null) {
            recorridoInOrden(X.getIzquierdo());
            System.out.print(" " + X.getDato());
            recorridoInOrden(X.getDerecho());
        }
    }

    public void recorridoPostOrden(Nodo X) {
        if (X != null) {
            recorridoPostOrden(X.getIzquierdo());
            recorridoPostOrden(X.getDerecho());
            System.out.print(" " + X.getDato());
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo raiz) {
        this.raiz = raiz;
    }

    public void buscar(int a) {
        Nodo X = raiz;
        while (X != null) {
            if (a < X.getDato()) {
                if (X.getIzquierdo() == null) {
                    System.out.println(" > No se encuentra " + a + ".");
                }
                X = X.getIzquierdo();
            } else {
                if (a > X.getDato()) {
                    if (X.getDerecho() == null) {
                        System.out.println(" > No se encuentra " + a + ".");
                    }
                    X = X.getDerecho();
                } else {
                    System.out.println(" > Se encontro " + a + ".");
                    X = null;
                }
            }
        }
    }

    public void mostrarHojas() {
        Pila P = new Pila();
        Pila A = new Pila();
        P.adicionar(raiz);
        while (!P.esVacia()) {
            while (!P.esVacia()) {
                Nodo X = P.eliminar();
                if (X.esHoja()) {
                    System.out.println(" > " + X.getDato());
                }
                if (X.getIzquierdo() != null) {
                    A.adicionar(X.getIzquierdo());
                }
                if (X.getDerecho() != null) {
                    A.adicionar(X.getDerecho());
                }
            }
            P.vaciar(A);
        }
    }

    public Nodo existe(int dato) {
        Pila nivel = new Pila();
        Pila desc = new Pila();
        if (!esVacia()) {
            nivel.adicionar(raiz);
        }
        while (!nivel.esVacia()) {
            while (!nivel.esVacia()) {
                Nodo e = nivel.eliminar();
                if (e.getDato() == dato) {
                    return e;
                }
                if (e.getIzquierdo() != null) {
                    desc.adicionar(e.getIzquierdo());
                }
                if (e.getDerecho() != null) {
                    desc.adicionar(e.getDerecho());
                }
            }
            nivel.vaciar(desc);
        }
        return null;
    }

    /**
     * Compara 2 arboles y determina si son iguales
     * @param Z 
     */
    public void esIgual(Arbol Z) {
        Pila niv1 = new Pila();
        Pila niv2 = new Pila();
        Pila des1 = new Pila();
        Pila des2 = new Pila();
        boolean sw = true;
        if (!esVacia() && !Z.esVacia()) {
            niv1.adicionar(raiz);
            niv2.adicionar(Z.getRaiz());
        } else {
            if (esVacia() || Z.esVacia()) {
                sw = false;
            }
        }
        while (!niv1.esVacia()) {
            while (!niv2.esVacia()) {
                Nodo n1 = niv1.eliminar();
                Nodo n2 = niv2.eliminar();
                if (n1.getDato() != n2.getDato()) {
                    sw = false;
                }
                if (n1.getIzquierdo() != null && n2.getIzquierdo() != null) {
                    des1.adicionar(n1.getIzquierdo());
                    des2.adicionar(n2.getIzquierdo());
                } else {
                    if (n1.getIzquierdo() != null || n2.getIzquierdo() != null) {
                        sw = false;
                    }
                }
                if (n1.getDerecho() != null && n2.getDerecho() != null) {
                    des1.adicionar(n1.getDerecho());
                    des2.adicionar(n2.getDerecho());
                } else {
                    if (n1.getDerecho() != null || n2.getDerecho() != null) {
                        sw = false;
                    }
                }
            }
            niv1.vaciar(des1);
            niv2.vaciar(des2);
        }
        if (sw) {
            System.out.print("\nSon Iguales\n");
        } else {
            System.out.print("\n<No son Iguales>\n");
        }
    }

    /**
     * Obtiene el padre de cualquier nodo
     * @param x
     * @return 
     */
    public Nodo getPadre(Nodo X) {
        Pila nodosNivel = new Pila();
        Pila nodosDescendientes = new Pila();
        nodosNivel.adicionar(raiz);
        while (!nodosNivel.esVacia()) {
            while (!nodosNivel.esVacia()) {
                Nodo e = nodosNivel.eliminar();
                if (e.getIzquierdo() != null) {
                    if (e.getIzquierdo() == X) {
                        return e;
                    }
                    nodosDescendientes.adicionar(e.getIzquierdo());
                }
                if (e.getDerecho() != null) {
                    if (e.getDerecho() == X) {
                        return e;
                    }
                    nodosDescendientes.adicionar(e.getDerecho());
                }
            }
            nodosNivel.vaciar(nodosDescendientes);
        }
        return null;
    }

    public void eliTerminal(Nodo x) {
        if (getPadre(x) != null) {
            Nodo p = getPadre(x);
            if (p.getDerecho() == x) {
                p.setDerecho(null);
            } else {
                p.setIzquierdo(null);
            }
        }
        if (x == raiz) {
            raiz = null;
        }
    }

    public void eliUnDesc(Nodo x) {
        if (getPadre(x) != null) {
            Nodo p = getPadre(x);
            if (p.getIzquierdo() == x) {
                if (x.getIzquierdo() != null) {
                    p.setIzquierdo(x.getIzquierdo());
                } else {
                    p.setDerecho(x.getDerecho());
                }
            } else {
                if (x.getDerecho() != null) {
                    p.setDerecho(x.getDerecho());
                } else {
                    p.setDerecho(x.getIzquierdo());
                }
            }
        } else {
            if (x == raiz) {
                if (x.getDerecho() != null) {
                    raiz = x.getDerecho();
                } else {
                    raiz = x.getIzquierdo();
                }
            }
        }
    }

    public void eliDosDesc(Nodo x) {
        Nodo r = x.getDerecho();
        while (r.getIzquierdo() != null) {
            r = r.getIzquierdo();
        }
        x.setDato(r.getDato());
        if (r.getDerecho() == null && r.getIzquierdo() == null) {
            eliTerminal(r);
        } else {
            eliUnDesc(r);
        }
    }

    public void eliminar(int id) {
        if (existe(id) != null) {
            Nodo x = existe(id);
            if (x.getDerecho() == null && x.getIzquierdo() == null) {
                eliTerminal(x);
            } else {
                if (x.getDerecho() != null && x.getIzquierdo() != null) {
                    eliDosDesc(x);
                } else {
                    eliUnDesc(x);
                }
            }
        }
    }

    public boolean tieneNieto(Nodo X) {
        if (X.getDerecho() != null) {
            if (X.getDerecho().getDerecho() != null) {
                return true;
            } else {
                if (X.getDerecho().getIzquierdo() != null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        if (X.getIzquierdo() != null) {
            if (X.getIzquierdo().getDerecho() != null) {
                return true;
            } else {
                if (X.getIzquierdo().getIzquierdo() != null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Muestra todos los nodos abuelos
     */
    public void mostrarAbuelos() {
        Pila nivel = new Pila();
        Pila descendientes = new Pila();
        nivel.adicionar(raiz);
        System.out.println("Abuelos");
        while (!nivel.esVacia()) {
            while (!nivel.esVacia()) {
                Nodo x = nivel.eliminar();
                if (tieneNieto(x)) {
                    System.out.print(" (" + x.getDato() + ")");
                }
                if (x.getIzquierdo() != null) {
                    descendientes.adicionar(x.getIzquierdo());
                }
                if (x.getDerecho() != null) {
                    descendientes.adicionar(x.getDerecho());
                }
            }
            nivel.vaciar(descendientes);
        }
    }

    public boolean esNieto(Nodo X) {
        Nodo padre = getPadre(X);
        if (padre != null) {
            if (getPadre(padre) != null) {
                return true;
            }
            return false;
        }
        return false;
    }

    /**
     * Muestra a todos los nietos
     */
    public void mostrarNietos() {
        Pila nivel = new Pila();
        Pila descendientes = new Pila();
        nivel.adicionar(raiz);
        System.out.print("Nietos");
        while (!nivel.esVacia()) {
            while (!nivel.esVacia()) {
                Nodo X = nivel.eliminar();
                if (esNieto(X)) {
                    System.out.print(" (" + X.getDato() + ")");
                }
                if (X.getIzquierdo() != null) {
                    descendientes.adicionar(X.getIzquierdo());
                }
                if (X.getDerecho() != null) {
                    descendientes.adicionar(X.getDerecho());
                }
            }
            nivel.vaciar(descendientes);
        }
    }

    public void nroHojas() {
        Pila nodosNivel = new Pila();
        Pila nodosDescendientes = new Pila();
        int ch = 0;
        nodosNivel.adicionar(raiz);
        while (!nodosNivel.esVacia()) {
            while (!nodosNivel.esVacia()) {
                Nodo e = nodosNivel.eliminar();
                if (e.getIzquierdo() == null && e.getDerecho() == null) {
                    ch++;
                } else {
                    if (e.getDerecho() != null) {
                        nodosDescendientes.adicionar(e.getDerecho());
                    }
                    if (e.getIzquierdo() != null) {
                        nodosDescendientes.adicionar(e.getIzquierdo());
                    }
                }
            }
            nodosNivel.vaciar(nodosDescendientes);
        }
        System.out.print("\nExisten " + ch + " Nodos Hoja.");
    }

    private int cuantosHay(Nodo x) {
        Pila nivel = new Pila();
        Pila desc = new Pila();
        int ch = 0;
        nivel.adicionar(raiz);
        while (!nivel.esVacia()) {
            while (!nivel.esVacia()) {
                Nodo e = nivel.eliminar();
                if (e.getDato() == x.getDato()) {
                    ch++;
                }
                if (e.getDerecho() != null) {
                    desc.adicionar(e.getDerecho());
                }
                if (e.getIzquierdo() != null) {
                    desc.adicionar(e.getIzquierdo());
                }
            }
            nivel.vaciar(desc);
        }
        return ch;
    }

    public void eliminaRepetidos() {
        Scanner lee = new Scanner(System.in);
        Pila nivel = new Pila();
        Pila desc = new Pila();
        nivel.adicionar(raiz);
        while (!nivel.esVacia()) {
            while (!nivel.esVacia()) {
                Nodo e = nivel.eliminar();
                int n = cuantosHay(e);
                if (n > 1) {
                    eliminar(e.getDato());
                }
                if (e.getDerecho() != null) {
                    desc.adicionar(e.getDerecho());
                }
                if (e.getIzquierdo() != null) {
                    desc.adicionar(e.getIzquierdo());
                }
            }
            nivel.vaciar(desc);
        }
        System.out.print("\nPresione una tecla para ver los Cambios\n");
        lee.next();
        recorridoPorNiveles();
        System.out.print("\nPresione una tecla para terminar\n");
        lee.next();
    }

    public int cuantosExisteNivel(int nivel) {
        Pila nodosNivel = new Pila();
        Pila nodosDescendientes = new Pila();
        nodosNivel.adicionar(raiz);
        int nroNivel = 0;
        int c = 0;
        while (!nodosNivel.esVacia()) {
            while (!nodosNivel.esVacia()) {
                Nodo e = nodosNivel.eliminar();
                if (nroNivel == nivel) {
                    c++;
                }
                if (e.getIzquierdo() != null) {
                    nodosDescendientes.adicionar(e.getIzquierdo());
                }
                if (e.getDerecho() != null) {
                    nodosDescendientes.adicionar(e.getDerecho());
                }
            }
            nroNivel++;
            nodosNivel.vaciar(nodosDescendientes);
        }
        return c;
    }

    private int maxElemNivel() {
        Pila nodosNivel = new Pila();
        Pila nodosDescendientes = new Pila();
        nodosNivel.adicionar(raiz);
        int max = Integer.MIN_VALUE;
        while (!nodosNivel.esVacia()) {
            int c = 0;
            while (!nodosNivel.esVacia()) {
                Nodo e = nodosNivel.eliminar();
                c++;
                if (e.getIzquierdo() != null) {
                    nodosDescendientes.adicionar(e.getIzquierdo());
                }
                if (e.getDerecho() != null) {
                    nodosDescendientes.adicionar(e.getDerecho());
                }
            }
            nodosNivel.vaciar(nodosDescendientes);
            if (c > max) {
                max = c;
            }
        }
        return max;
    }

    public void nivelesMasNodos() {
        int max = maxElemNivel();
        Pila nivel = new Pila();
        Pila des = new Pila();
        nivel.adicionar(raiz);
        int c = 0;
        while (!nivel.esVacia()) {
            boolean sw = false;
            if (max == cuantosExisteNivel(c)) {
                sw = true;
                System.out.print("\nNivel= " + c + "\n");
            }
            while (!nivel.esVacia()) {
                Nodo e = nivel.eliminar();
                if (sw) {
                    System.out.print(e.getDato() + "\t");
                }
                if (e.getIzquierdo() != null) {
                    des.adicionar(e.getIzquierdo());
                }
                if (e.getDerecho() != null) {
                    des.adicionar(e.getDerecho());
                }
            }
            c++;
            nivel.vaciar(des);
        }
    }

    public void nroNodos(Nodo r) {
        Pila nivel = new Pila();
        Pila desc = new Pila();
        int c = 0;
        nivel.adicionar(r);
        while (!nivel.esVacia()) {
            while (!nivel.esVacia()) {
                Nodo x = nivel.eliminar();
                c++;
                if (x.getIzquierdo() != null) {
                    desc.adicionar(x.getIzquierdo());
                }
                if (x.getDerecho() != null) {
                    desc.adicionar(x.getDerecho());
                }
            }
            nivel.vaciar(desc);
        }
        System.out.print("\nExisten " + c + " Nodos.");
    }

    public void interRaizMasIzquierdo() {
        if (raiz.getIzquierdo() != null) {
            Nodo t = raiz.getIzquierdo();
            while (t.getIzquierdo() != null) {
                t = t.getIzquierdo();
            }
            int aux = raiz.getDato();
            raiz.setDato(t.getDato());
            t.setDato(aux);
        }
    }
}
