package arrays;

/**
 * Clase Principal
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] a3d) {
        //int[] V1 = new int[100];
        //int[] V2 = new int[100];
        int[] V1 = {1, 3, 5, 7, 9};
        int[] V2 = {2, 4, 6, 8, 10};
        intercalar(V1, V2);
    }

    public static void intercalar(int[] V1, int[] V2) {
        for (int i = 0; i < V2.length; i++) {
            System.out.println(" " + V1[i]);
            System.out.println(" " + V2[i]);

        }
    }
}
