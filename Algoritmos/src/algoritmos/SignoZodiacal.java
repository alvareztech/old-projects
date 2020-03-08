package algoritmos;

/**
 * @author Daniel Alvarez
 */
public class SignoZodiacal {

    public static void main(String[] args) {
        System.out.println(signoZodiacal(17, 2));
    }
    
    public static String signo(int dia, int mes) {
        switch (mes) {
            case 1:
                if (dia> 21) {
                    return "";
                } else {
                    return "";
                }
            
        }
        return "";
    }

    public static String signoZodiacal(int dia, int mes) {
        if (mes == 1) {
            if (dia > 21) {
                return "ACUARIO";
            } else {
                return "CAPRICORNIO";
            }
        }
        if (mes == 2) {
            if (dia > 19) {
                return "PISCIS";
            } else {
                return "ACUARIO";
            }
        }
        if (mes == 3) {
            if (dia > 20) {
                return "ARIES";
            } else {
                return "PISCIS";
            }
        }
        if (mes == 4) {
            if (dia > 20) {
                return "TAURO";
            } else {
                return "ARIES";
            }
        }
        if (mes == 5) {
            if (dia > 21) {
                return "GEMINIS";
            } else {
                return "TAURO";
            }
        }
        if (mes == 6) {
            if (dia > 20) {
                return "CANCER";
            } else {
                return "GEMINIS";
            }
        }
        if (mes == 7) {
            if (dia > 22) {
                return "LEO";
            } else {
                return "CANCER";
            }
        }
        if (mes == 8) {
            if (dia > 21) {
                return "VIRGO";
            } else {
                return "LEO";
            }
        }
        if (mes == 9) {
            if (dia > 22) {
                return "LIBRA";
            } else {
                return "VIRGO";
            }
        }
        if (mes == 10) {
            if (dia > 22) {
                return "ESCORPION";
            } else {
                return "LIBRA";
            }
        }
        if (mes == 11) {
            if (dia > 21) {
                return "SAGITARIO";
            } else {
                return "ESCORPION";
            }
        }
        if (mes == 12) {
            if (dia > 21) {
                return "CAPRICORNIO";
            } else {
                return "SAGITARIO";
            }
        }
        return "";
    }
}
