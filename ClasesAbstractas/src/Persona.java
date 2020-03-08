
import java.util.Scanner;

public abstract class Persona {

    protected String nombre;
    protected int ci;
    protected int edad;
    protected boolean sexo;

    public Persona(String nombre, int ci, int edad, boolean sexo) {
        this.nombre = nombre;
        this.ci = ci;
        this.edad = edad;
        this.sexo = sexo;
    }

    public void leer() {
        Scanner in = new Scanner(System.in);
        System.out.println("PERSONA");
        System.out.print(" nombre: ");
        nombre = in.nextLine();
        System.out.print(" ci: ");
        ci = in.nextInt();
        System.out.print(" edad: ");
        edad = in.nextInt();
        System.out.println(" Digite 1 si es sexo femenino ");
        System.out.println(" Digite 2 si es sexo Masculino: ");
        int d;
        d = in.nextInt();
        if (d == 1) {
            sexo = false;
        } else {
            sexo = true;
        }


    }

    public void mostrar() {
        System.out.println("PERSONA");
        System.out.println(" nombre: " + nombre);
        System.out.println(" ci: " + ci);
        System.out.println(" edad: " + edad);
        System.out.println(" sexo: " + sexo);
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public int getEdad() {
        return edad;
    }

    public void setedad(int edad) {
        this.edad = edad;
    }

    public boolean getsexo() {
        return sexo;
    }

    public void setsexo(boolean sexo) {
        this.sexo = sexo;
    }

    public abstract double promedioNotas();

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public abstract int Sumatoria() ;
}