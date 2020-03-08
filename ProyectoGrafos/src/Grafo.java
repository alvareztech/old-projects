

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import javax.swing.JButton;

/**
 * Clase Grafo
 * @author Daniel Alvarez (a3dany)
 */
public class Grafo {

    private int nroVertices;
    private int[][] pesos;
    private boolean[][] adyacencias;
    private EmpresaV[] empresas;
    

    public Grafo() {
        nroVertices = 0;
        adyacencias = new boolean[100][100];
        pesos = new int[100][100];
        boton = new JButton();
        
    }

    public Grafo(int n) {
        nroVertices = n;
        adyacencias = new boolean[nroVertices][nroVertices];
        pesos = new int[nroVertices][nroVertices];
    }

    public void adicionarVectice(int origen, int destino, Empresa E) {
        adyacencias[origen][destino] = true;
        pesos[origen][destino] = 1;
        nroEmpresas++;
        empresas[nroEmpresas] = E;
        
    }

    public void adicionarVectice(int origen, int destino, int peso) {
        adyacencias[origen][destino] = true;
        pesos[origen][destino] = peso;
    }

    public void mostrarCamino(int origen, int destino) {
        Stack<Integer> pila = new Stack();
        boolean[] visitados = new boolean[nroVertices];
        int i = origen;                                // primera posicion
        while (visitados[destino] == false) {
            pila.push(i);
            visitados[i] = true;
            i = buscar(visitados, i);
            if ((i == -1) && (visitados[destino] == false)) {
                if (pila.empty()) {
                    System.out.println("No Hay Ruta ");
                    break;
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

    public int buscar(boolean[] visitados, int vertice) {
        int indicador = -1;
        for (int i = 0; i < nroVertices; i++) {
            if ((adyacencias[vertice][i] == true) && (visitados[i] == false)) {
                indicador = i;
                break;
            }
        }
        return indicador;
    }

    public void busquedaEnAmplitud(int origen, int destino) {
        boolean[] visitados = new boolean[nroVertices];
        Queue cola = new LinkedList<Integer>();
        int i = origen;
        visitados[i] = true;
        int a;
        while (visitados[destino] == false) {
            a = buscar(visitados, i);
            if (a != -1) {
                System.out.println("->" + a);
                cola.add(a);
                visitados[a] = true;
            } else {
                i = (Integer) cola.poll();
            }
        }
    }

    public void busquedaEnProfundidad(int origen, int destino) {
        boolean[] visitados = new boolean[nroVertices];
        Stack<Integer> pila = new Stack();
        int i = origen;
        while (visitados[destino] == false) {
            pila.push(i);
            System.out.print(" " + i);
            visitados[i] = true;
            i = buscar(visitados, i);
            if ((i == -1) && (visitados[destino] == false)) {
                if (pila.empty()) {
                    System.out.println("No Hay Ruta ");
                    break;
                } else {
                    pila.pop();
                    i = (int) pila.pop();
                }
            }
        }
    }
}