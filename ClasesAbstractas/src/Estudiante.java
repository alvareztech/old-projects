
import java.util.Scanner;

public class Estudiante extends Persona {

    private String carrera;
    private String semestre;
    private int nro;
    private int[] notas;
    private String[] materias;

    public Estudiante(String n, int c, int e, boolean s, String ca, String se) {
        super(n, c, e, s);
        carrera = ca;
        semestre = se;
        nro = 0;
        notas = new int[100];
        materias = new String[100];
    }

    public Estudiante(String n, int c, int e, boolean s, String ca, String se, int nr, int[] not, String[] mat) {
        super(n, c, e, s);
        carrera = ca;
        semestre = se;
        nro = nr;
        notas = not;
        materias = mat;
    }

    public void leer() {
        super.leer();
        Scanner in = new Scanner(System.in);
        System.out.println("ESTUDIANTE");
        System.out.print(" carrera: ");
        carrera = in.nextLine();
        System.out.print(" semestre: ");
        semestre = in.nextLine();
        System.out.println(" notas");
        System.out.print(" nro: ");
        nro = in.nextInt();
        System.out.println(" Notas");
        for (int i = 0; i < nro; i++) {
            notas[i] = in.nextInt();
        }
        System.out.println(" Materias");
        for (int i = 0; i < nro; i++) {
            materias[i] = in.next();
        }
    }

    public void mostrar() {
        super.mostrar();
        System.out.println("ESTUDIANTE");
        System.out.println(" carrera: " + carrera);
        System.out.println(" semestre: " + semestre);
        System.out.println(" notas:");
        for (int i = 0; i < nro; i++) {
            System.out.println("  [" + i + "] " + notas[i]);
        }
        System.out.println(" materias:");
        for (int i = 0; i < nro; i++) {
            System.out.println("  [" + i + "] " + materias[i]);
        }
    }

    public String getcarrera() {
        return carrera;
    }

    public void setcarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getsemestre() {
        return semestre;
    }

    public void setsemestre(String semestre) {
        this.semestre = semestre;
    }

    public int[] getnotas() {
        return notas;
    }

    public void setnotas(int[] notas) {
        this.notas = notas;
    }

    public String[] getmaterias() {
        return materias;
    }

    public void setmaterias(String[] materias) {
        this.materias = materias;
    }

    public double promedioNotas() {
        int c = 0;
        double prom;
        for (int i = 0; i < nro; i++) {
            c = c + notas[i];
            
        }
        prom=c/nro;
        return prom;
    }
    public int Sumatoria() {
        int c = 0;
        double prom;
        for (int i = 0; i < nro; i++) {
            c = c + notas[i];
            
        }
       
        return c;
    }
}