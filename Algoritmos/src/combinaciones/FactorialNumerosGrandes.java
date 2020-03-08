package combinaciones;

import java.math.BigInteger;

/**
 * Clase que ejemplifica es uso de BigInteger para el calculo del factorial.
 * @author Daniel Alvarez
 */
public class FactorialNumerosGrandes {

    public static void main(String[] a3d) {
        int n = 300;
        System.out.println(n + "! = " + factorial(n));
    }

    public static BigInteger factorial(int n) {
        BigInteger f = new BigInteger("1");
        for (int i = 1; i <= n; i++) {
            f = f.multiply(new BigInteger(i + ""));
        }
        return f;
    }
}
