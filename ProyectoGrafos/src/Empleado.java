

import java.util.Scanner;


public class Empleado extends Persona {
String cargo;
int item;
int sueldo;
	public String getCargo() {
	return cargo;
}
public void setCargo(String cargo) {
	this.cargo = cargo;
}
public int getItem() {
	return item;
}
public void setItem(int item) {
	this.item = item;
}
public int getSueldo() {
	return sueldo;
}
public void setSueldo(int sueldo) {
	this.sueldo = sueldo;
}
	public Empleado(String c,int i,int s) {
		super();
		cargo=c;
		item=i;
		sueldo=s;
	}
	public Empleado() {
		// TODO Auto-generated constructor stub
	}
	void mostrarE2()
	{
		System.out.println(":::Empleado:::");
		mostrarp();
		System.out.println("Cargo : "+cargo);
		System.out.println( " item : "+item);
		System.out.println("sueldo : "+sueldo);
	}
        String mostrarE()
	{
            String c="";
		c+="\n:::Empleado:::";
		c=c+mostrarp();
		c+="\nitem : "+item;
		c+="\nsueldo : "+sueldo;
                return c;
	}
	void leerE()
	{
		super.leerP();
		Scanner in=new Scanner(System.in);
		System.out.println(":::Empleado:::");
		System.out.print("cargo : ");
		cargo=in.nextLine();
		System.out.print("item : ");
		item=in.nextInt();
		System.out.print("sueldo : ");
		sueldo=in.next().charAt(0);
	}

}
