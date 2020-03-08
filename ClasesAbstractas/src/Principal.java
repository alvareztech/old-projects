
import java.util.*;

public class Principal {

    public static void main(String[] args) {
        int opc;
        double may;
        boolean signo = true;
        Scanner P = new Scanner(System.in);
        
//        int[] notasP1 = new int[100];
//        notasP1[0] = 45;
//        notasP1[1] = 54;
        
        int[] notasP1 = {45, 54, 12, 12};
        int[] notasP2 = {2, 1, 12, 12};
        int[] notasP3 = {90, 54, 69, 90};
        
        String[] materiasP1 = {"Inf-111", "Inf-112", "Inf-113", "Inf-114"};
        String[] materiasP2 = {"Inf-111", "Inf-112", "Inf-113", "Inf-114"};
        String[] materiasP3 = {"Inf-111", "Inf-112", "Inf-113", "Inf-114"};
        
        
        Persona P1 = new Estudiante("Daniel", 6120049, 47, true, "Informatica", "octavo", 4, notasP1, materiasP1);
        Persona P2 = new Estudiante("Fabiola", 6120049, 47, false, "Informatica", "octavo", 4, notasP2, materiasP2);
        Persona P3 = new Estudiante("Alejandro", 6120049, 47, true, "Informatica", "octavo", 4, notasP3, materiasP3);

        System.out.println("INTRODUSCA LA OPCION ==> ");
        System.out.println("1.Docente");
        System.out.println("2.Estudiante");
        int ne = P.nextInt();

        if (ne == 1) {

            while (signo) {
                System.out.println("1.Leer");
                System.out.println("2.Mostrar");
                System.out.println("3.Salir");
                System.out.println("INTRODUSCA LA OPCION ==> ");
                opc = P.nextInt();

                switch (opc) {
                    case 1:
                        P1.leer();
                        break;
                    case 2:
                        P1.mostrar();
                        break;
                    case 3:
                        signo = false;
                        break;
                }
            }
        } else {
            while (signo) {
                System.out.println("1.Leer");
                System.out.println("2.Mostrar");
                System.out.println("3.promedioNotas");
                System.out.println("4.Salir");

                System.out.println("INTRODUSCA LA OPCION ==> ");
                opc = P.nextInt();

                switch (opc) {
                    case 1:
                        P1.leer();
                        P2.leer();
                        P3.leer();
                        break;
                    case 2:
                        P1.mostrar();
                        break;
                    case 3:
                        System.out.println("*************************");
                        P1.promedioNotas();

                        if (P1.promedioNotas() > P2.promedioNotas()) {
                            may = P1.promedioNotas();

                            if (P1.promedioNotas() < P3.promedioNotas()) {
                                may = P3.promedioNotas();
                                System.out.println("el mayor es:" + P3.getNombre());
                            }
                        } else {
                            may = P2.promedioNotas();
                            if (P3.promedioNotas() < P2.promedioNotas()) {
                                may = P2.promedioNotas();
                                System.out.println("el mayor es:" + P2.getNombre());
                            }
                        }
                        break;

                    case 4:
                        signo = false;
                        break;


                }
            }
        }
    }
}
