package pruebas;

/**
 * Clase PermutacionesEnOrden
 * @author Daniel Alvarez (a3dany)
 */
import java.util.Vector;

public class PermutacionesEnOrden {

    private static void procesarSolucion(Vector a) {
        System.out.println(a);
    }

    public static boolean esSolucion(int posicionActual) {
        // cuando se llego al final del vector
        // no se puede seguir iterando
        return (posicionActual == 0);
    }

    private static void permutar(Vector auxiliar, Vector original) {
        int N = original.size();
        if (esSolucion(N)) {
            procesarSolucion(auxiliar);
        } else {
            for (int i = 0; i < N; i++) {
                String proximo = (String) original.remove(i);
                auxiliar.add(proximo);
                permutar(auxiliar, original);
                original.add(i, proximo);
                auxiliar.remove(proximo);
            }
        }
    }

    public static void main(String[] args) {
        Vector v = new Vector();
        String[] a = new String[3];
        a[0] = "a";
        a[1] = "b";
        a[2] = "c";
        for (int i = 0; i < a.length; i++) {
            String s = a[i];
            v.add(s);
        }
        permutar(new Vector(), v);
    }
}