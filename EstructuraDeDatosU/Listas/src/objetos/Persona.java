package objetos;

import java.util.Scanner;

/**
 * Clase Persona
 * @author Daniel Alvarez (a3dany)
 */
public class Persona {

    private String nombre;
    private int edad;

    public Persona() {
        this.nombre = "";
        this.edad = 0;
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.print(" Nombre: ");
        this.nombre = in.nextLine();
        System.out.print(" Edad: ");
        this.edad = in.nextInt();
    }

    public void mostrar() {
        System.out.println(" Nombre: " + this.nombre);
        System.out.println(" Edad: " + this.edad);
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
