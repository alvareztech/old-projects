package objetos;

import java.util.Scanner;

/**
 * Clase Persona
 * @author Daniel Alvarez (a3dany)
 */
public class Persona {

    private String nombre;
    private int ci;

    public Persona() {
        this.nombre = "";
        this.ci = 0;
    }

    public Persona(String nombre, int ci) {
        this.nombre = nombre;
        this.ci = ci;
    } 
    
    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.print(" Nombre: ");
        this.nombre = in.nextLine();
        System.out.print(" CI: ");
        this.ci = in.nextInt();
    }
    
    public void mostrar() {
        System.out.println(" Nombre: " + this.nombre);
        System.out.println(" CI: " + this.ci);
    }
}
