package maugetk;


class Libro 
{
	private String titulo;
	private String autor;
	private String tipodesc;
	private int cantdesc;
	private int cantconsultas;
	private String fechadesc;
	private String Codigodesc;
	public Libro()
	{
		 titulo="";
		 autor="";
		 tipodesc="";
		 cantdesc=0;
		 cantconsultas=0;
		 fechadesc="";
		 Codigodesc="";
	}
	
	public void leer()
	{
		
		System.out.print("titulo del libro ");
		titulo=Leer.dato();
		System.out.print(" autor del libro ");
		autor=Leer.dato();
        System.out.print(" tipo de descarga ");
		tipodesc=Leer.dato();
		System.out.print(" cantidad de descarga ");
		cantdesc=Leer.datoInt();
		System.out.print(" cantidad de consultas ");
		cantconsultas=Leer.datoInt();
		System.out.print(" dia de descargas  ");
		fechadesc=Leer.dato();
		System.out.print(" Codigo de descarga ");
		Codigodesc=Leer.dato();
		
	}
	public void mostrar()
	{
		
		
		System.out.print(" "+titulo+" ");
		System.out.print(" "+autor+" ");
		System.out.print(" "+tipodesc+" ");
		System.out.print(""+cantdesc+" ");
		System.out.print(""+cantconsultas+" ");
		System.out.print(" "+ fechadesc+" ");
		System.out.print(""+Codigodesc+" ");
	}
	
	
	public String gettit()
	{
		return titulo;
	}
	public String getAut()
	{
		return autor;
	}
	public String gettipdesc()
	{
		return tipodesc;
	}
	public int getcantdesc()
	{
		return cantdesc;
	}
	public int getcantconsult()
	{
		return cantconsultas;
	}
	public String getcod()
	{
		return Codigodesc;
	}
	public String getdia()
	{
		return fechadesc;
	}
}
