

import java.util.Scanner;

public class Agencia {
String ciudad,direccion;
lsempleado LE=new lsempleado();
	public Agencia() {
		ciudad=direccion="";
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public  void leerAg() {
		System.out.println(":::Agencia:::");
		
		Scanner in=new Scanner(System.in);
		System.out.println("Ingrese direccion : ");
		direccion=in.next();
		System.out.println("Ingrese ciudad : ");
		ciudad=in.next();
		System.out.println("Ingrese lista empleados : ");
    	LE.leere();
	}
	public void mostrarAg() {
		//super.mostrarp();
		//lsempleado a=new lsempleado();
		System.out.println(":::Agencia:::");
		System.out.println("direccion : "+direccion);
		System.out.println("ciudad: "+ciudad);
		LE.mostrare();
	}
        public String mostrarAg2() {
		String c="";
		c=c+":::Agencia:::\n";
		c=c+"  direccion : "+direccion;
		c=c+"\n ciudad: "+ciudad;
		c=c+LE.mostrare();
                return c;
	}

}
