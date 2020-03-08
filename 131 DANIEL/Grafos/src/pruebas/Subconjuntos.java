package pruebas;

/**
 * Clase Subconjuntos
 * @author Daniel Alvarez (a3dany)
 */
public class Subconjuntos {

    private static void procesarSolucion(boolean[] conjuntos) {
        // imprimir la solucion,
        // conjuntos indica cuales imprimir
        System.out.print("{");
        for (int i = 0; i < conjuntos.length; i++) {
            if (conjuntos[i]) {
                System.out.print((i + 1) + " ");
            }
        }
        System.out.println("}");
    }

    public static boolean esSolucion(boolean[] conjuntos, int posicionActual) {
        // cuando se llego al final del vector
        // no se puede seguir iterando
        return (conjuntos.length == posicionActual);
    }

    public static void imprimeSubconjuntos(boolean[] conjuntos, int posicionActual) {
        if (esSolucion(conjuntos, posicionActual)) {
            procesarSolucion(conjuntos);
        } else {
            conjuntos[posicionActual] = true;
            // procesar una nueva solucion
            imprimeSubconjuntos(conjuntos, posicionActual + 1);
            // retornar (bactrack) al caso anterior
            conjuntos[posicionActual] = false;
            imprimeSubconjuntos(conjuntos, posicionActual + 1);
        }
    }

    public static void main(String[] args) {
        boolean[] conjuntos = new boolean[3]; // Inicialmente conjuntos esta todo en false
        imprimeSubconjuntos(conjuntos, 0);
    }
}