package recursividad;

import java.io.File;

/**
 * Clase con metodos estaticos recursivos.
 * @author Daniel
 */
public class Main {

    /**
     * @param a3d the command line arguments
     */
    public static void main(String[] a3d) {
//        System.out.println("7! = " + factorial(7));
//        System.out.println("2^5 = " + exponente(2, 5));
//        for (int i = 0; i < 10; i++) {
//            System.out.print(" " + fibonacci(i));
//        }
//        int n = 1;
//        int[][] M = generarCuadradoMagica(n);
//        System.out.println("\n");
//        for (int i = 1; i <= n; i++) {
//            for (int j = 1; j <= n; j++) {
//                System.out.print("  " + M[i][j]);
//            }
//            System.out.println("");
//        }
//        
//        for (int i = 2; i < 350; i += 2) {
//            if (i % 4 == 0) {
//                System.out.println(" " + i);
//                //   System.out.println(" " + (i + 2));
//            }
//
//        }

    }

    public static int exponente(int b, int e) {
        if (e == 0) {
            return 1;
        } else {
            return b * exponente(b, e - 1);
        }
    }

    public static int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else {
            if (n == 1) {
                return 1;
            } else {
                return fibonacci(n - 1) + fibonacci(n - 2);
            }
        }
    }

  
}
