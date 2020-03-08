package a3d;

import java.util.HashSet;
import java.util.Set;
import javax.swing.JTextField;

/**
 * Clase Sudoku
 * @author Daniel Alvarez (a3dany)
 */
public class Sudoku {

    private int dimension;
    private int tamanio;
    private int[][] valores;

    public Sudoku(int[][] valores) {
        this.dimension = 3;
        this.tamanio = 9;
        this.valores = valores;
    }

    public int noDuplicadosFila(int fila) {
        Set<Integer> unicos = new HashSet<Integer>();
        for (int i = 0; i < tamanio; i++) {
            unicos.add(valores[fila][i]);
        }
        return unicos.size();
    }

    public int noDuplicadosColumna(int columna) {
        Set<Integer> unicos = new HashSet<Integer>();
        for (int i = 0; i < tamanio; i++) {
            unicos.add(valores[i][columna]);
        }
        return unicos.size();
    }

    public int numeroRepeticionesFilas() {
        int c = 0;
        for (int i = 0; i < tamanio; i++) {
            c += noDuplicadosFila(i);
        }
        return c;
    }

    public int numeroRepeticionesColumnas() {
        int c = 0;
        for (int i = 0; i < tamanio; i++) {
            c += noDuplicadosColumna(i);
        }
        return c;
    }

    public int noDuplicadosCuadrado(int fila, int columna) {
        Set<Integer> unicos = new HashSet<Integer>();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                unicos.add(valores[i + (dimension * fila)][j + (dimension * columna)]);
            }
        }
        return unicos.size();
    }

    public int numeroRepeticionesCuadrados() {
        int c = 0;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                c += noDuplicadosCuadrado(i, j);
            }
        }
        return c;
    }

    public boolean canSolveSudokuTemplate(Sudoku template) {
        boolean canSolve = true;
        int[][] templateValues = template.valores;
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (templateValues[i][j] != 0) {
                    if (templateValues[i][j] != valores[i][j]) {
                        canSolve = false;
                    }
                }
            }
        }
        return canSolve;
    }

    public void mostrar() {
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                System.out.print(" " + valores[i][j]);
            }
            System.out.println("");
        }
    }

    public void mostrar(JTextField[] cajas) {
        int k = 0;
        for (int i = 0; i < tamanio; i++) {
            for (int j = 0; j < tamanio; j++) {
                cajas[k].setText(valores[i][j] + "");
                k++;
            }
        }
    }
}
