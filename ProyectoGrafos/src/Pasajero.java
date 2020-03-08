

import java.util.Scanner;


public class Pasajero extends Persona{
String nacionalidad,cod;
String code;
Boleto B=new Boleto();

	public Pasajero() {
		super();
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionaldad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public Boleto getB() {
		return B;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setB(Boleto b) {
		B = b;
	}

	public void leerPas() {
		Scanner in=new Scanner(System.in);
		super.leerP();
    	System.out.println(":::Pasajeros:::");
		System.out.print("Ingrese nacionalidad : ");
		nacionalidad=in.next();
		System.out.print("Ingrese boleto : ");
		B.leerBo();	
		System.out.print("Ingrese codigo de equipaje : ");
		code=in.next();
	}
	public void mostrarPas() {
		System.out.println(":::Pasajeros:::");
		super.mostrarp();
		System.out.println("Nacionalidad : "+nacionalidad);
		B.mostrarBo();
        System.out.println("codigo de equip: "+code);
	}
        public String mostrarPas2() {
	   String c="";
            c+="\n:::Pasajeros:::";
		c+=super.mostrarp();
		c+="\nNacionalidad : "+nacionalidad;
		c+=B.mostrarBo();
        c+="\ncodigo de equip: "+code;
        return c;
	}

}
