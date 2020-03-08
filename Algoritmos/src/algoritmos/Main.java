/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritmos;

import java.util.Scanner;

/**
 *
 * @author Daniel
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int d = in.nextInt();
        int m = in.nextInt();
        System.out.print(getSignoZodiacal(d, m));
    }

    /**
     * Metodo que retorna el signo zodiacal dada una fecha de nacimiento.
     * @param d dia de nacimiento
     * @param m mes de nacimiento
     * @return String con el signo zodiacal.
     */
    public static String getSignoZodiacal(int d, int m) {
        String signo = "";
        switch (m) {
            case 1: // enero
                if (d > 20) {
                    signo = "acuario";
                } else {
                    signo = "capricornio";
                }
                break;
            case 2: // febrero
                if (d > 19) {
                    signo = "piscis";
                } else {
                    signo = "acuario";
                }
                break;
            case 3: // marzo
                if (d > 20) {
                    signo = "aries";
                } else {
                    signo = "piscis";
                }
                break;
            case 4: // abril
                if (d > 20) {
                    signo = "tauro";
                } else {
                    signo = "aries";
                }
                break;
            case 5: // mayo
                if (d > 21) {
                    signo = "géminis";
                } else {
                    signo = "tauro";
                }
                break;
            case 6: // junio
                if (d > 21) {
                    signo = "cáncer";
                } else {
                    signo = "géminis";
                }
                break;
            case 7: // julio
                if (d > 22) {
                    signo = "leo";
                } else {
                    signo = "cáncer";
                }
                break;
            case 8: // agosto
                if (d > 21) {
                    signo = "virgo";
                } else {
                    signo = "leo";
                }
                break;
            case 9: // septiembre
                if (d > 22) {
                    signo = "libra";
                } else {
                    signo = "virgo";
                }
                break;
            case 10: // octubre
                if (d > 23) {
                    signo = "escorpio";
                } else {
                    signo = "libra";
                }
                break;
            case 11: // noviembre
                if (d > 20) {
                    signo = "sagitario";
                } else {
                    signo = "escorpio";
                }
                break;
            case 12: // diciembre
                if (d > 21) {
                    signo = "capricornio";
                } else {
                    signo = "sagitario";
                }
                break;
        }
        return signo;
    }
}
