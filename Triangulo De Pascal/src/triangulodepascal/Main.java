package triangulodepascal;

/**
 *
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static long[][] M;
    public static int MAXIMO = 4073;

    public static void main(String[] a3d) {
        generarTrianguloDePascal();
        int n = 1000;
        int k = 123;
        System.out.println(" C(" + n + "," + k + ") = " + combinacion(4072, 100));
        for (int i = 0; i < MAXIMO; i++) {
            for (int j = 0; j < MAXIMO; j++) {
                System.out.print(" " + M[i][j]);

            }
            System.out.println("");
        }
    }

    public static long combinacion(int n, int k) {
        return M[n][k];
    }

    public static void generarTrianguloDePascal() {
        M = new long[MAXIMO][MAXIMO];
        for (int i = 0; i < MAXIMO; i++) {
            M[i][0] = 1;
        }
        for (int i = 0; i < MAXIMO; i++) {
            M[i][i] = 1;
        }
        for (int i = 1; i < MAXIMO; i++) {
            for (int j = 1; j <= i; j++) {
                M[i][j] = M[i - 1][j - 1] + M[i - 1][j];
            }
        }
    }
}
