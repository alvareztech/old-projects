

import java.util.Scanner;


public class Persona {
 String nombre;
 int ci;
 char sexo;
	public Persona() {
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCi() {
		return ci;
	}
	public void setCi(int ci) {
		this.ci = ci;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	void mostrarp2()
	{
		System.out.println(":::Persona:::");
		System.out.println("Nombre : "+nombre);
		System.out.println("c.i : "+ci);
		System.out.println("Sexo : "+sexo);
	}
        String mostrarp()
	{
            String c="";
		c+="\n:::Persona:::";
		c+="\nNombre : "+nombre;
		c+="\nc.i : "+ci;
		c+="\nSexo : "+sexo;
                return c;
	}

	void leerP()
	{
		System.out.println(":::Persona:::");
		Scanner in=new Scanner(System.in);
		System.out.print("Ingrese nombre : ");
		
		nombre=in.nextLine();
		System.out.print("Ingrese c.i : ");
		
		ci=in.nextInt();
		System.out.print("Ingrese Sexo : ");
		sexo=in.next().charAt(0);
	}
}
