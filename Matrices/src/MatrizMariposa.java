
import java.util.Scanner;

/**
 * Clase MatrizMariposa
 * @author Daniel Alvarez (a3dany)
 */
public class MatrizMariposa {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Dimensión De La Matriz: ");
        int n = in.nextInt();
        mostrarMatriz(generarMatrizMariposa(n, 1), n, n);
    }

    public static int[][] generarMatrizMariposa(int n, int x) {
        int M[][] = new int[n + 1][n + 1];
        int c = n / 2 + 1;
        for (int i = 1; i <= c; i++) {
            for (int j = 1; j <= i; j++) {
                M[i][j] = x;
                M[i][n - j + 1] = x;
                M[n - i + 1][j] = x;
                M[n - i + 1][n - j + 1] = x;
            }
        }
        return M;
    }

    public static void mostrarMatriz(int[][] M, int f, int c) {
        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print("\t" + M[i][j]);
            }
            System.out.println();
        }
    }
}
