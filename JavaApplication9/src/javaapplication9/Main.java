package javaapplication9;

import java.util.Scanner;

/**
 * Clase Principal
 * @author Daniel Alvarez (a3dany)
 */
public class Main {

    public static void main(String[] a3d) {
        Scanner e = new Scanner(System.in);
        String cad = e.nextLine();
        while (!cad.equals("*")) { // cad != "*"
            cad = cad.trim(); // quita espacios adelante y atras
            char primeraLetra = cad.charAt(0);
            int espacios = 0;
            int cont = 0;
            for (int i = 0; i < cad.length(); i++) {
                if (cad.charAt(i) == ' ') { // es espacio?
                    espacios = espacios + 1;
                    if (cad.charAt(i + 1) == primeraLetra || cad.charAt(i + 1) == primeraLetra + 32 || cad.charAt(i + 1) == primeraLetra - 32) {
                        cont++;
                    }
                }
            }
            if (espacios == cont) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
            cad = e.nextLine();
        }
    }
}
