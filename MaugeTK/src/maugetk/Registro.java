package maugetk;


public class Registro {
	private String nombre;
	private String correo;
	private String hora;
	private String fecha;
	private String sugerencia;
	private String codigodesc;
	Registro()
	{
		 nombre="";
		 correo="";
		 hora="";
		 fecha="";
		 sugerencia="";
		 codigodesc="";
	}
	
	 public void leer ()
	    {
		System.out.print("Nombre ");
		nombre= Leer.dato ();
		System.out.print ("correo ");
		correo = Leer.dato ();
		System.out.print ("hora ");
		hora= Leer.dato ();
		System.out.print("fecha ");
		fecha = Leer.dato ();
		System.out.print("sugerencia ");
		sugerencia= Leer.dato ();
		System.out.print("codigo de descarga del libro o documento");
		codigodesc= Leer.dato ();
	    }


	    public void mostrar ()
	    {
		System.out.print ("\t" + nombre);
		System.out.print ("\t" + correo);
		System.out.print("\t" + hora);
		System.out.print ("\t" +fecha);
		System.out.print ("\t" +sugerencia);
		System.out.print ("\t" +codigodesc);
	    }
	    
	public String getnom() {
		return nombre;
	}
	public void setnom(String nom) {
		this.nombre = nom;
	}
	public String getcorreo() {
		return correo;
	}
	
	public String gethora() {
		return hora;
	}
	
	public String getfecha() {
		return fecha;
	}
	
	public String getsug() {
		return sugerencia;
	}
	public String getcod() {
		return codigodesc;
	}
	
	

}
