
/**
 * Cuadrados Mágicos
 * @author Daniel Alvarez
 */
public class Algoritmos {

    public static int[][] generarCuadradoMagico(int n) {
        if (n % 2 == 1) {
            return generarCuadradoMagicoImpar(n);
        } else {
            if (n % 4 == 0) {
                return generarCuadradoMagicoPar4n(n);
            } else {
                return generarCuadradoMagicoPar4n2(n);
            }
        }
    }

    /**
     * Método de la Loubere
     * @param n dimension de la matriz
     * @return matriz magica
     */
    public static int[][] generarCuadradoMagicoImpar(int n) {
        int[][] A = new int[n + 1][n + 1];
        int f = 1;
        int c = (n + 1) / 2;
        for (int i = 1; i <= n * n; i++) {
            A[f][c] = i;
            if (i % n == 0) {
                f++;
            } else {
                if (f == 1) {
                    f = n;
                } else {
                    f--;
                }
                if (c == n) {
                    c = 1;
                } else {
                    c++;
                }
            }
        }
        return A;
    }

    public static int[][] generarCuadradoMagicoPar4n(int n) {
        int[][] A = new int[n + 1][n + 1];
        int k = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                A[i][j] = k;
                k++;
            }
        }
        for (int i = 1; i <= n / 4; i++) {
            for (int j = 1; j <= n / 2; j++) {
                int aux = A[i][j + (n / 4)];
                A[i][j + (n / 4)] = A[n - i + 1][n - (n / 4) - j + 1];
                A[n - i + 1][n - (n / 4) - j + 1] = aux;
                aux = A[j + (n / 4)][i];
                A[j + (n / 4)][i] = A[n - (n / 4) - j + 1][n - i + 1];
                A[n - (n / 4) - j + 1][n - i + 1] = aux;
            }
        }
        mostrarMatriz(A, n, n);
        return A;
    }

    /**
     * Metodo LUX
     * @param n
     * @return
     */
    public static int[][] generarCuadradoMagicoPar4n2(int n) {
        int m = n / 2;
        char[][] LUX = new char[m + 1][m + 1];
        int k = n / 4 + 1;
        System.out.println("--- " + k);
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                LUX[i][j] = 'L';
                if (i == k + 1) {
                    LUX[i][j] = 'U';
                }
                if (i > k + 1) {
                    LUX[i][j] = 'X';
                }
            }
        }
        mostrarMatriz(LUX, m, m);

        LUX[m / 2 + 1][m / 2 + 1] = 'U';
        LUX[m / 2 + 2][m / 2 + 1] = 'L';

        mostrarMatriz(LUX, m, m);

        int[][] I = generarCuadradoMagicoImpar(m);

        int[][] A = new int[n + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                int a = i * 2 - 1;
                int b = j * 2 - 1;
                switch (LUX[i][j]) {
                    case 'L':
                        A[a][b + 1] = 4 * I[i][j] - 3;
                        A[a + 1][b] = 4 * I[i][j] - 2;
                        A[a + 1][b + 1] = 4 * I[i][j] - 1;
                        A[a][b] = 4 * I[i][j] - 0;
                        break;
                    case 'U':
                        A[a][b] = 4 * I[i][j] - 3;
                        A[a + 1][b] = 4 * I[i][j] - 2;
                        A[a + 1][b + 1] = 4 * I[i][j] - 1;
                        A[a][b + 1] = 4 * I[i][j] - 0;
                        break;
                    case 'X':
                        A[a][b] = 4 * I[i][j] - 3;
                        A[a + 1][b + 1] = 4 * I[i][j] - 2;
                        A[a + 1][b] = 4 * I[i][j] - 1;
                        A[a][b + 1] = 4 * I[i][j] - 0;
                        break;
                }
            }
        }
        return A;
    }

    public static int getConstanteMagica(int n) {
        return (n * (n * n + 1)) / 2;
    }

    /**
     * 
     * @param M
     * @param n
     * @return 
     */
    public static boolean esCuadradoMagico(int[][] M, int n) {
        int m = getConstanteMagica(n);
        int sumF = 0;
        int sumC = 0;
        int sumDP = 0;
        int sumDS = 0;
        System.out.println("M(" + n + ") = " + m);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                sumF += M[i][j];
                sumC += M[j][i];
                if (i == j) {
                    sumDP += M[i][j];
                    sumDS += M[i][n - j + 1];
                }
            }
            if (sumF != m) {
                return false;
            }
            if (sumC != m) {
                return false;
            }
            sumF = 0;
            sumC = 0;
        }
        if (sumDP != m) {
            return false;
        }
        if (sumDS != m) {
            return false;
        }
        return true;
    }

    /**
     * 
     * @param A
     * @param f numero de filas
     * @param c numero de columnas
     */
    public static void mostrarMatriz(int[][] M, int f, int c) {
        System.out.println("");
        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(" " + M[i][j]);
            }
            System.out.println("");
        }
    }

    public static void mostrarMatriz(char[][] M, int f, int c) {
        System.out.println("");
        for (int i = 1; i <= f; i++) {
            for (int j = 1; j <= c; j++) {
                System.out.print(" " + M[i][j]);
            }
            System.out.println("");
        }
    }
}
