package ejemplojuego;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Planificador {

    Timer timer;
    int counter1 = 0;
    int counter2 = 0;
    Date fecha;
    boolean finTarea = false;

    public Planificador() {

        //se crea un planificador que planificara 2 tareas

        timer = new Timer();

        //la Tarea1 se ejecuta pasado 1 segundo y luego periódicamente cada segundo

        timer.schedule(new Tarea1(), 1000, 1000);

        //la Tarea2 se ejecuta pasado 5 segundos y luego periodicamente cada segundo

        timer.schedule(new Tarea2(), 5000, 1000);

    }

    //Tarea1: Muestra el valor de un contador y lo incrementa
    //cuando el contador llega a 10 se desplanifica la tarea
    class Tarea1 extends TimerTask {

        public void run() {

            System.out.println("Ejecucion nº " + counter1 + "de la Tarea1");

            if (counter1 < 5) {

                System.out.println("El contador tiene valor: " + counter1);

                counter1++;

            } else {

                //Si la otra tarea ya ha acabado mata al planificador

                if (finTarea) {

                    System.out.println("***Fin Planificador***");

                    timer.cancel();

                } //Si la otra tarea todavia no ha acabado solo se desplanifica, el
                //planificador sigue funcionando
                else {

                    System.out.println("***Fin Tarea1***");

                    this.cancel();

                    System.out.println("Tarea1 desplanificada.");

                    finTarea = true;

                }

            }

        }
    }

    //Tarea2: Muestra la fecha actual
    //cuando el contador llega a 10 se desplanifica la tarea
    class Tarea2 extends TimerTask {

        public void run() {

            System.out.println("Ejecucion nº " + counter2 + "  de la Tarea2");

            fecha = new Date();

            if (counter2 < 5) {

                System.out.println(" Fecha: " + fecha);

                counter2++;

            } else {

                //Si la otra tarea ya ha acabado mata al planificador

                if (finTarea) {

                    System.out.println("     ***Fin Planificador***");

                    timer.cancel();

                } //Si la otra tarea todavia no ha acabado solo se desplanifica, el
                //planificador sigue funcionando
                else {

                    System.out.println("     ***Fin Tarea2***");

                    this.cancel();

                    System.out.println("Tarea2 desplanificada.");

                    finTarea = true;

                }

            }

        }
    }

    public static void main(String args[]) {

        System.out.println("   Iniciamos el Planificador");

        new Planificador();

    }
}
