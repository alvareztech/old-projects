
import java.util.Scanner;

public class Docente extends Persona {

    private String Carrera;
    private int Horario;
    private double Sueldo;

    public Docente(String n, int c, int e, boolean s, String Carrera, int Horario, double Sueldo) {
        super(n, c, e, s);
        this.Carrera = Carrera;
        this.Horario = Horario;
        this.Sueldo = Sueldo;
    }

    public void leer() {
        super.leer();
        Scanner in = new Scanner(System.in);
        System.out.println("DOCENTE");
        System.out.print(" Carrera: ");
        Carrera = in.nextLine();
        System.out.print(" Horario: ");
        Horario = in.nextInt();
        System.out.print(" Sueldo: ");
        Sueldo = in.nextDouble();
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("DOCENTE");
        System.out.println(" Carrera: " + Carrera);
        System.out.println(" Horario: " + Horario);
        System.out.println(" Sueldo: " + Sueldo);
    }

    public String getCarrera() {
        return Carrera;
    }

    public void setCarrera(String Carrera) {
        this.Carrera = Carrera;
    }

    public int getHorario() {
        return Horario;
    }

    public void setHorario(int Horario) {
        this.Horario = Horario;
    }

    public double getSueldo() {
        return Sueldo;
    }

    public void setSueldo(double Sueldo) {
        this.Sueldo = Sueldo;
    }

    @Override
    public double promedioNotas() {
        return 0;
    }
    public int Sumatoria() {
        return 0;
    }
}
