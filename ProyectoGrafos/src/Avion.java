

import java.util.LinkedList;
import java.util.Scanner;
public class Avion {
int nroAsientos;
String modelo,tipo;
int n;
LinkedList<Empleado> LP=new LinkedList<Empleado>();
Scanner in=new Scanner(System.in);
Scanner in1=new Scanner(System.in);
	public Avion() {
		 nroAsientos=0;
		 modelo="";
		tipo="";
		//LE=null;
	}
	public int getnroAsientos() {
		return nroAsientos;
	}
	public void setnroAsientos(int nroAsientos) {
		this.nroAsientos=nroAsientos;
	}

	public String getmodelo() {
		return modelo;
	}
	public void setmodelo(String modelo) {
		this.modelo=modelo;
	}
	public String gettipo() {
		return tipo;
	}
	public void settipo(String tipo) {
		this.tipo=tipo;
	}	
	public  void leerAv() {
	
		//super.leerP();
		System.out.println(":::Avion:::");
		System.out.print("Ingrese no Asientos : ");
		nroAsientos=in.nextInt();
		System.out.print("Ingrese modelo : ");
		modelo=in1.next();
		System.out.print("Ingrese tipo : ");
		tipo=in1.next();
		Scanner in=new Scanner(System.in);
    	System.out.print("Ingrese lista empleados : ");
    	 n=in.nextInt();
    	for(int i=1;i<=n;i++)
    	{
    		Empleado P=new Empleado();
    		P.leerE();
    		LP.add(P);
    	}
	}
	public void mostrarAv2() {
		System.out.println(":::Avion:::");
		System.out.println("nro asiento : "+nroAsientos);
		System.out.println("modelo : "+modelo);
		System.out.println("tipo : "+tipo);
		for(int i=1;i<=n;i++)
    	{
    		Empleado P=LP.removeFirst();
    		P.mostrarE();
    		LP.addLast(P);
    	}
	}

        public String mostrarAv() {
            String c="";
		c+="\n:::Avion:::";
		c+="\nnro asiento : "+nroAsientos;
		c+="\nmodelo : "+modelo;
		c+="\ntipo : "+tipo;
		for(int i=1;i<=n;i++)
    	        {
    		     Empleado P=LP.removeFirst();
    		     c+= P.mostrarE();
    		    LP.addLast(P);
    	      }
                return c;
	}
}
