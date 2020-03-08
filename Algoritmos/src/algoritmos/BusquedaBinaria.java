package algoritmos;

/**
 * Clase BusquedaBinaria
 * @author Daniel Alvarez (a3dany)
 */
public class BusquedaBinaria {

    public static void main(String[] args) {
        System.out.println("\n>" + busquedaBinaria(crearVector(9000000), 550));
    }

    public static long busquedaBinaria(int[] V, int elemento) {
        int izquierda = 0;
        int derecha = V.length;
        int medio = 0;
        int posicion = -1;
        while (izquierda <= derecha) {
            medio = (izquierda + derecha) / 2;
            System.out.println(">>> " + medio);
            if (elemento > V[medio]) {
                izquierda = medio;
            } else {
                if (elemento == V[medio]) {
                    posicion = medio;
                    break;
                } else {
                    derecha = medio;
                }
            }
        }
        return posicion;
    }

    public static int[] crearVector(int n) {
        int[] V = new int[n];
        for (int i = 0; i < V.length; i++) {
            V[i] = i * 1;
        }
        return V;
    }
}
