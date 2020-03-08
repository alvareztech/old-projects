
/**
 * Clase Palabras
 * @author Daniel Alvarez (a3dany)
 */
public class Palabras {

    public static void main(String[] args) {
        String cadena = "Hola amigos espero que estén bien";
        System.out.println("\"" + cadena + "\"");
        System.out.println("Tiene " + contarPalabras(cadena) + " palabras.");
        System.out.println("Sin la tercera para es \"" + eliminarPalabra(cadena, 3) + "\"");
        System.out.println("Con palabras invertidas es \"" + invertirPalabras(cadena) + "\"");
    }

    public static int contarPalabras(String cadena) {
        cadena += " ";
        int c = 0;
        for (int i = 0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == ' ') {
                c++;
            }
        }
        return c;
    }

    public static String eliminarPalabra(String cadena, int k) {
        cadena += " ";
        String nuevaCadena = "";
        int c = 0;
        String palabra = "";
        for (int i = 0; i < cadena.length(); i++) {
            palabra += cadena.charAt(i);
            if (cadena.charAt(i) == ' ') {
                c++;
                if (c != k) {
                    nuevaCadena += palabra;
                }
                palabra = "";
            }
        }
        return nuevaCadena.trim();
    }

    public static String invertirPalabras(String cadena) {
        cadena += " ";
        String palabra = "";
        String nuevaCadena = "";
        for (int i = 0; i < cadena.length(); i++) {
            palabra = cadena.charAt(i) + palabra;
            if (cadena.charAt(i) == ' ') {
                nuevaCadena += palabra;
                palabra = "";
            }
        }
        return nuevaCadena.trim();
    }
}
