
import java.util.Scanner;

/**
 * Muestra Una Matriz Cuadrada En Modo Caracol
 * @author Daniel Alvarez (a3dany)
 */
public class MostrarModoCaracol {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Dimesión De La Matriz: ");
        int n = in.nextInt();
        int[][] M = new int[n + 1][n + 1];
        mostrarModoCaracol(llenarMatriz(M, n, n), n);
    }

    public static void mostrarModoCaracol(int[][] M, int n) {
        if (n % 2 == 1) {
            System.out.print(" " + M[n / 2 + 1][n / 2 + 1]);
        }
        for (int a = n / 2; a >= 1; a--) {
            for (int i = a + 1; i <= n - a + 1; i++) {
                System.out.print(" " + M[a][i]);
            }
            for (int i = a + 1; i <= n - a + 1; i++) {
                System.out.print(" " + M[i][n - a + 1]);
            }
            for (int i = n - a; i >= a; i--) {
                System.out.print(" " + M[n - a + 1][i]);
            }
            for (int i = n - a; i >= a; i--) {
                System.out.print(" " + M[i][a]);
            }
        }
    }

    public static int[][] llenarMatriz(int[][] M, int f, int c) {
        int a = 1;
        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= c; j++) {
                M[i][j] = a;
                a++;
            }
        }
        return M;
    }
}
