package pruebas;

/**
 * Clase Permutaciones
 * @author Daniel Alvarez (a3dany)
 */
public class Permutaciones {
    // imprimir las n! permutaciones en desorden
    private static void procesarSolucion(String[] a) {
        for (int i = 0; i < 3; i++) {
            System.out.print(a[i]);
        }
        System.out.println(" ");
    }

    public static boolean esSolucion(int posicionActual) {
        // cuando se llego al final del vector
        // no se puede seguir iterando
        return (posicionActual == 1);
    }

    private static void permutar(
            String[] a, int n) {
        if (esSolucion(n)) {
            procesarSolucion(a);
            return;
        }
        for (int i = 0; i < n; i++) {
            swap(a, i, n - 1);
            permutar(a, n - 1);
            swap(a, i, n - 1);
        }
    }

    private static void swap(String[] a, int i, int j) {
        String c;
        c = a[i];
        a[i] = a[j];
        a[j] = c;
    }

    public static void main(String[] args) {
        String[] a = new String[3];
        a[0] = "a";
        a[1] = "b";
        a[2] = "c";
        permutar(a, 3);
    }
}
