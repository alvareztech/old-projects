package recursividad;

/**
 * Clase Recursividad
 * @author Daniel Alvarez (a3dany)
 */
public class Recursividad {

    public static int[][] matrizCaracol(int[][] M, int n, int a, int f, int c, int x) {
        if (n / 2 == f && n / 2 == c) {
            return M;
        } else {
            if (c != n) {
                M[f][c] = a;
                matrizCaracol(M, n, a++, f++, c, 1);
            } else {
                if (f == n) {
                    M[f][c] = a;
                    matrizCaracol(M, n, a++, f, c, 2);
                } else {
                }
            }
        }
        return null;
    }

    public static void mostrar(int n) {
        if (n > 0) {
            mostrar(--n);
            System.out.println(" " + n);
            
        }
    }

    public static void main(String[] args) {
        //System.out.println(mostrar(7));
        mostrar(7);
    }

    public static String invertir(String cadena) {
        if (cadena.equals("")) {
            return "";
        } else {
            System.out.println(cadena);
            return invertir(cadena.substring(1, cadena.length())) + cadena.charAt(0);
        }
    }

    public static String invertir2(String cadena) {
        for (int i = 0; i < cadena.length()-1; i++) {
            cadena = cadena.substring(1, cadena.length()) + cadena.charAt(0);
            System.out.println(cadena);
        }
        return cadena;
    }

    public static int numeroDigitos(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (1 + numeroDigitos(n / 10));
        }
    }

    public static int sumarDigitos(int n) {
        if (n == 0) {
            return 0;
        } else {
            return (n % 10 + sumarDigitos(n / 10));
        }
    }
}
