package maugetk;

class manejo
{
    
    public static void main (String args [])
    {
	LSNormalG a=new LSNormalG();
	LSNormalP b=new LSNormalP();
	System.out.println("LISTA DE SECCCIONES DE LA BIBLIOTECA ");
	a.leer1(2);
	a.mostrar();
	System.out.println("\n"+"LISTA DE REGISTROS ");
	b.leer1(3);
	b.mostrar();
	
	
	/* 1) buscar en la seccion x,el libro,
	 si esta el libro mostrar cuantas veces lo descargaron*/
	/*System.out.println("\n"+"secccion en libros q desea buscar");
	String x=Leer.dato();
	System.out.println("\n"+"titulo del libro q desea buscar");
	String y=Leer.dato();
	System.out.println("\n"+"autor del libro q desea buscar");
	String z=Leer.dato();
	a.Recorre(x,y,z);*/
	
	/* 2)Contar y mostrar todos los documentos q han sido descargados en pdf*/
	/*System.out.println("\n"+"seccion en documentos q desea buscar");
	String m=Leer.dato();
	a.MuestraDoc(m);*/
	
	/* 3)Adicionar un nuevo lubro q hasido sugerido en la seccion x*/
	/*System.out.println("\n"+"Datos del libro q desea adicionar");
	Libro f=new Libro();
    f.leer();
    System.out.println("\n"+"seccion en libros donde adicionara");
	String n=Leer.dato();
	a.Adiciona(f,n);
    System.out.println("\n"+"seccion en libros q quiere buscar");
	String s=Leer.dato();
	a.buscaSeccionL(s);*/
	
	/* 4)Mostrar los correos que se registraron en la hora x,fecha y */
	/*System.out.println("\n"+"hora q quiere buscar");
	String h=Leer.dato();
	System.out.println("\n"+"fecha q quiere buscar");
	String t=Leer.dato();
	System.out.println("\n"+"correos q se registrron en la hora "+h+" y "+"fecha "+t);
	b.MuestraReg(b.p,h,t);*/
	
	/* 5)Eliminar los libros y documentos q nunca fueron consultados de los nodos terminales*/
	/* a.EliminaLD();
	 System.out.println("libros y documentos q han sido consultados");
	 a.mostrar();*/
	 
	 /*6)Mostrar la seccion x*/
	 /*System.out.println("\n"+"seccion en libros q quiere buscar");
	 String g=Leer.dato();
	 System.out.println("\n"+"LISTA DE LA SECCION"+g);
	 a.buscaSeccionL(g);*/
	
	 /*7) Mostrar lo libros y documentos q tienen el mismo autor y titulo*/
	/* System.out.println("libros y documentos q con el mismo titulo");
	 a.MostrarIguales();*/
	
	/* 8)Verificar cuantas personas descargaron el documento con titulo x el dia y*/
	/*System.out.println("\n"+"titulo del documento q quiere buscar");
	String w=Leer.dato();
	System.out.println("\n"+"dia q quiere buscar");
	String i=Leer.dato();
	 a.verifica(w,i);*/
	/* 9) Mostrar las sugerencias de las personas q se registraron*/
	/*System.out.println("\n"+"SUGERENCIAS ");
	b.MuestraSug(b.p);*/
	
	/* 10)Mostrar que libro descargo la persona x*/
	/*System.out.println("\n"+"nombre de la persona q desea buscar que descargo un libro");
	String j=Leer.dato();
	System.out.println("\n"+"La persona "+j+" descargo el siguiente libro: ");
	a.verificaLibro(b.mostrarLD(b.p,j));*/
	
    }
}

