package javaapplication9;

/**
 * Clase NewClass
 * @author Daniel Alvarez (a3dany)
 */
public class NewClass {
    public static void main(String[] args) {
        String cad = "hola como estas";
        String nueva = "";
        for (int i = 0; i < cad.length(); i++) {
            if (cad.charAt(i) != 'a') {
                nueva = nueva + cad.charAt(i);
            }
        }
        cad = nueva;
        System.out.println(cad);
    }
}