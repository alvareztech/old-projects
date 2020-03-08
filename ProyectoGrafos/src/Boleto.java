

import java.util.Scanner;

public class Boleto  {
	int costo;
	String CodBo,categoria,destino;
	public Boleto() {
		costo=0;
		CodBo="";
		categoria="";
		destino="";

	}
	public int getCosto() {
		return costo;
	}
	public void setCosto(int costo) {
		this.costo=costo;
	}

	public String getCodBo() {
		return CodBo;
	}
	public void setCoBo(String Codbo) {
		this.CodBo=Codbo;
	}
	public String getcategoria() {
		return categoria;
	}
	public void setcategoria(String categor) {
		this.categoria=categor;
	}
	public String getdestino() {
		return destino;
	}

	public void setdestino(String destin) {
		this.destino= destin;
	}


	public void leerBo() {
		Scanner in=new Scanner(System.in);
		//super.leerP();
		System.out.println(":::Boleto:::");
		System.out.print("Ingrese costo : ");
		costo=in.nextInt();
		System.out.print("Ingrese Codigo boleto : ");
		CodBo=in.next();
		System.out.print("Ingrese Categor�a : ");
		categoria=in.next();
		System.out.print("Ingrese Destino : ");
		destino=in.next();
	}
	public void mostrarBo2() {
		//super.mostrarp();
		System.out.println(":::Boleto:::");
		System.out.println("Costo : "+costo);
		System.out.println("C�digo boleto : "+CodBo);
		System.out.println("Categoria : "+categoria);
		System.out.println("Destino : "+destino);
	}
        public String  mostrarBo() {
		String c="";//super.mostrarp();
		c+="\n:::Boleto:::";
		c+="\nCosto : "+costo;
		c+="\nC�digo boleto : "+CodBo;
		c+="\nCategoria : "+categoria;
		c+="\nDestino : "+destino;
                return c;
	}
}
