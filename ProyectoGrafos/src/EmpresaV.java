
import java.util.Scanner;

public class EmpresaV {

    String nombre, direccion, pais;
    int na;
    ListaVuelo LV=new ListaVuelo();
    ListaAgencia LA=new ListaAgencia();

    public EmpresaV() {
        nombre = direccion = pais = "";
        na = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getNa() {
        return na;
    }

    public void setNa(int na) {
        this.na = na;
    }

    public void leerEm() {
        Scanner in = new Scanner(System.in);
        //super.leerP();
        System.out.println(":::Empresa:::");
        System.out.println("Ingrese nombre : ");
        nombre = in.next();
        //System.out.println("Ingrese pais : ");
        //pais=in.next();
        System.out.println("Ingrese direccion : ");
        direccion = in.next();
        System.out.println("Ingrese numero de agencias : ");
        na = in.nextInt();
        System.out.println("Lista de empleados ");
        LV.leerl();
        System.out.println("Lista de agencia ");
        LA.leerl();
    }

    public void mostrarEm2() {
        //super.mostrarp();
        System.out.println(":::Empresa:::");
        System.out.println("nombre : " + nombre);
        System.out.println("pais : " + pais);
        System.out.println("direccion : " + direccion);
        System.out.println("numero de agencias : " + na);
        System.out.println("Lista de empleados ");
        LV.mostrarl();
        System.out.println("Lista de agencia ");
        LA.mostrarl();

    }

    public String mostrarEm() {
        String c = "";
        c += "\n:::Empresa:::";
        c += "\nnombre : " + nombre;
        c += "\npais : " + pais;
        c += "\ndireccion : " + direccion;
        c += "\nnumero de agencias : " + na;
        c += "\nLista de empleados ";
        LV.mostrarl();
        c += "\nLista de agencia ";
        LA.mostrarl();
        return c;
    }
}
