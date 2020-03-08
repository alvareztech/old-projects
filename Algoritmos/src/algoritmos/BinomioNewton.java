package algoritmos;

import java.util.Scanner;

/**
 * Calcula el Binomio de Newton utilizando la formula.
 * @author Daniel Alvarez (a3dany)
 */
public class BinomioNewton {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int a = in.nextInt();
        int n = in.nextInt();
        System.out.println(binomio(x, a, n));
        System.out.println(Math.pow(x + a, n));
    }

    public static int binomio(int x, int a, int n) {
        int sum = 0;
        for (int k = 0; k <= n; k++) {
            sum += combinacion(n, k) * exponente(x, k) * exponente(a, n - k);
        }
        return sum;
    }

    public static int combinacion(int n, int k) {
        return factorial(n) / (factorial(k) * (factorial(n - k)));
    }

    public static int factorial(int n) {
        int f = 1;
        for (int i = 1; i <= n; i++) {
            f *= i;
        }
        return f;
    }

    public static int exponente(int a, int b) {
        int e = 1;
        for (int i = 1; i <= b; i++) {
            e *= a;
        }
        return e;
    }
}
