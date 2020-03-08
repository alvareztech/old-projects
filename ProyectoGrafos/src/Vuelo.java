

import java.util.Scanner;


public class Vuelo  {
Avion Av=new Avion();
String fecha,hora,destino;
Lspasajero LP=new Lspasajero();
	
	public Avion getAv() {
		return Av;
	}
	public void setAv(Avion av) {
		this.Av=av;
	}

	/*public Lspasajero getLP() {
		return LP;
	}
	public void setLP( Lspasajero LP) {
		this.LP=LP;
	}*/
	
	public void leerVu() {
		System.out.println(":::Vuelo:::");
		Scanner in=new Scanner(System.in);
		System.out.println("Ingrese Avion : ");
		Av.leerAv();
		System.out.println("Ingrese fecha : ");
		fecha=in.next();
		System.out.println("Ingrese hora : ");
		hora=in.next();
		System.out.println("Ingrese destino : ");
		destino=in.next();
		System.out.println("Ingrese Lista pasajero : ");
		LP.leer();
		//this.LP.mostrar();
		
	}
	public void mostrarVu2() {
		//super.mostrarp();
		System.out.println(":::Vuelo:::");
		System.out.print("Avion : ");
		Av.mostrarAv();
		System.out.println("fecha : "+fecha);
		System.out.println("hora : "+hora);
		System.out.println("destino : "+destino);
		System.out.print("Lista pasajero : ");
		this.LP.mostrar();
	}
        String mostrarVu() {
		String c="";
		c+="\n:::Vuelo:::";
		c+="\n Avion : ";
		c+=Av.mostrarAv();
		c+="\n fecha : "+fecha;
		c+="\n hora : "+hora;
		c+="\n destino : "+destino;
		c+="\n Lista pasajero : ";
		c+=this.LP.mostrar();
                return c;
	}
	
}
