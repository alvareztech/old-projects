
/**
 * Cuadrados Magicos
 * @author Daniel Alvarez
 */
public class Principal {

    public static void main(String[] args) {
        int[][] M = Algoritmos.generarCuadradoMagicoImpar(5);
        Algoritmos.mostrarMatriz(M, 5, 5);
        //System.out.println(Algoritmos.esCuadradoMagico(M, 5) ? "SI" : "NO");
    }
}
