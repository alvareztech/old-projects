package pruebas;

/**
 * Clase Grafo2
 * @author Daniel Alvarez (a3dany)
 */
import java.util.Stack;

public class Grafo2 {

    public static void camino(int[][] g) {
        Stack<Integer> pila = new Stack();
        boolean[] v = new boolean[g.length];        // visitados
        int i = 0;                                  // primera posicion
        while (v[v.length - 1] == false) {          // mientras G este sin visitar
            pila.push(i);
            v[i] = true;
            i = buscar(g, v, i);
            if ((i == -1) && (v[v.length - 1] == false)) {
                if (pila.empty()) {
                    System.out.println("No Hay Ruta ");
                    System.exit(0);
                } else {
                    //bactracking al anterior
                    pila.pop();
                    i = (int) pila.pop();
                }
            }
        }
        System.out.println("Ruta en Orden Inverso ");
        while (!pila.empty()) {
            i = (int) pila.pop();
            System.out.print(" " + i);
        }
    }

    public static int buscar(int[][] g, boolean[] v, int fila) {
        int hallo = -1;
        for (int i = 0; i < g.length; i++) {
            // System.out.println("busca ="+g[fila][i]);
            if ((g[fila][i] == 1) && (v[i] == false)) {
                hallo = i;
                break;
            }
        }
        // System.out.println("Hallo ="+hallo);
        return hallo;
    }

    public static void main(String[] args) {
        int[][] g = new int[7][7];
        // Nodos A=0, B=1, C=2, D=3, E=4, F=5, G=6
        g[0][1] = 1;
        g[0][4] = 1;
        g[1][4] = 1;
        g[1][5] = 1;
        g[2][3] = 1;
        g[4][2] = 1;
        g[4][5] = 1;
        g[5][3] = 1;
        g[5][6] = 1;
        camino(g);
    }
}
