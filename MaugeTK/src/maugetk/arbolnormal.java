package maugetk;

class arbolnormal extends arbol
{
    arbolnormal ()
    {
	super ();
    }


    boolean esvacia ()
    {
	if (raiz == null)
	    return true;
	return false;
    }


    void crear ()
    {
        String resp;
        Pila nivel = new Pila ();
        Pila desc = new Pila ();

        nodo x = new nodo ();
        System.out.println("LIBRO Raiz-->");
        x.F.leer();
        raiz = x;
        nivel.adicion (raiz);
        while (!nivel.esvacia ())
        {
            while (!nivel.esvacia ())
            {
                x = nivel.eliminacion ();
                System.out.print (x.F.gettit());
                System.out.print ( " Tendra Izquierda ? S/N");
                resp = Leer.dato ();
                if (resp.compareTo ("s") == 0)
                {
                    nodo y = new nodo ();
                    System.out.print("LIBRO-->");
                    y.F.leer ();
                    x.izq = y;
                    desc.adicion (y);
                }
                else
                    x.izq = null;
                System.out.print (x.F.gettit());
                System.out.print (" Tendra Derecha ? S/N");
                resp = Leer.dato ();
                if (resp.compareTo ("s") == 0)
                {
                    nodo y = new nodo ();
                    System.out.print("LIBRO-->");
                    y.F.leer();
                    x.der = y;
                    desc.adicion (y);
                }
                else
                    x.der = null;
            }
            while (!desc.esvacia ())

                nivel.adicion (desc.eliminacion ());
        }
    }



    void mostrar ()
    {

	nodo x;
	Pila nivel = new Pila ();
	Pila desc = new Pila ();
   // int c=35;

	nivel.adicion (raiz);
	while (!nivel.esvacia ())
	{
	    while (!nivel.esvacia ())
	    {
		x = nivel.eliminacion ();
		
		x.F.mostrar();
		
		
	

		if (x.izq != null)
		    desc.adicion (x.izq);
		if (x.der != null)
		    desc.adicion (x.der);
	    }
		
	   // c=c-20;
	    System.out.println ();
	    while (!desc.esvacia ())

		nivel.adicion (desc.eliminacion ());
	}
    }


    void preorden ()
    {
	Pila aux = new Pila ();
	nodo x;
	aux.adicion (null);
	x = raiz;
	while (x != null)
	{
	    if (x.der != null)
		aux.adicion (x.der);
	    x.F.mostrar();
	    if (x.izq != null)
		x = x.izq;
	    else
		x = aux.eliminacion ();
	}
    }


    int nroelem ()
    {
	nodo x;
	Pila nivel = new Pila ();
	Pila desc = new Pila ();
	int ne = 0;
	if (esvacia ())
	    return ne;
	else
	{
	    nivel.adicion (raiz);
	    while (!nivel.esvacia ())
	    {
		while (!nivel.esvacia ())
		{
		    x = nivel.eliminacion ();
		    ne++;
		    if (x.izq != null)
			desc.adicion (x.izq);
		    if (x.der != null)
			desc.adicion (x.der);
		}
		System.out.println ();
		while (!desc.esvacia ())

		    nivel.adicion (desc.eliminacion ());
	    }
	    return (ne);
	}
    }


    void hojas ()
    {

	nodo x;
	int niv = 0;
	Pila nivel = new Pila ();
	Pila desc = new Pila ();

	nivel.adicion (raiz);
	while (!nivel.esvacia ())
	{
	    System.out.println ("\n Nivel :" + niv);
	    while (!nivel.esvacia ())
	    {
		x = nivel.eliminacion ();
		if (x.izq == null && x.der == null)
		    x.F.mostrar();

		if (x.izq != null)
		    desc.adicion (x.izq);
		if (x.der != null)
		    desc.adicion (x.der);
	    }
	    System.out.println ();
	    while (!desc.esvacia ())
		nivel.adicion (desc.eliminacion ());
	    niv++;
	}
    }
    public void r_Niveles ()
    {
	Pila nivel = new Pila ();
	Pila desc = new Pila ();

	nodo x;
	nivel.adicion (raiz);
	int i = 0;
	while (!nivel.esvacia ())
	{
	    System.out.print ("Nivel : " + i);
	    while (!nivel.esvacia ())
	    {
		x = nivel.eliminacion ();
		System.out.print ("  " + x.F);
		if (x.izq != null)
		    desc.adicion (x.izq);

		if (x.der != null)
		    desc.adicion (x.der);
	    }
	    nivel.vaciar (desc);
	    System.out.println (" ");
	    i = i + 1;
	}
    }
    
    
    boolean  verifica (String x,String z)
    {
	Pila aux = new Pila ();
	aux.adicion (null);
	nodo q = raiz;
	while (q != null)
	{
		if (q.F.getAut().equals(z)&& q.F.gettit().equals(x))
			return true;
		if (q.der != null)
		aux.adicion (q.der);
	    
	    if (q.izq != null)
		q = q.izq;
	    else
		q = aux.eliminacion ();
	}
    
    return false;
    }
    int  busca (String x,String z)
    {
	Pila aux = new Pila ();
	aux.adicion (null);
	nodo q = raiz;
	while (q != null)
	{
		if (q.F.getAut().equals(z)&& q.F.gettit().equals(x))
			return q.F.getcantdesc();
		if (q.der != null)
		aux.adicion (q.der);
	    
	    if (q.izq != null)
		q = q.izq;
	    else
		q = aux.eliminacion ();
	}
    
    return 0;
    }
    public void Agrega (Libro e)
    {
        Pila nivel = new Pila ();
        Pila desc = new Pila ();
        nodo x;
        int sw=0;
        nivel.adicion (raiz);
        
        while (!nivel.esvacia ()&& sw==0)
        {
           while (!nivel.esvacia ()&& sw==0)
            {
                x = nivel.eliminacion ();
                
                     if (x.izq == null )
                     {
                     	
                        nodo nuevo= new nodo();
                        nuevo.F=e;
                        x.izq=nuevo;
                        x=null;
                        sw=1;
                     }
                      else
                      {
                      	if ( x.der == null)
                        {
                        	
                          nodo nuevo= new nodo();
                          nuevo.F=e;
                          x.der=nuevo;
                          x=null;
                          sw=1;

                        }
                      	else
                      	{

                            if (x.izq != null)
                                desc.adicion (x.izq);

                            if (x.der != null)
                            	desc.adicion (x.der);
                      	}
                      }
               
            }
            nivel.vaciar (desc);
           
        }
    }
    public void EliminaL ()
    {
	Pila aux = new Pila ();
	aux.adicion (raiz);
    nodo x;
	while (!aux.esvacia ())
	{
       x = aux.eliminacion ();
		if (x.izq!=null && x.izq.izq==null && x.izq.der==null)
		{
			if (x.izq.F.getcantconsult()==0 )
				   x.izq=null;
		}
		if (x.der!=null && x.der.izq==null && x.der.der==null)
		{
			if (x.der.F.getcantconsult()==0 )
				   x.der=null;
		}
		
		if (x.der!= null)
		    aux.adicion (x.der);

		if (x.izq!= null)
		    aux.adicion (x.izq);
	    }
	   
    }
   void  buscaLD (arbolnormalD A)
    {
	Pila aux = new Pila ();
	aux.adicion (null);
	nodo q = raiz;
	PilaD aux1= new PilaD ();
	
	while (q != null)
	{
		aux1.adicion (null);
		nodoD z = A.raiz;
		while (z != null)
		{
			if (q.F.gettit().equals(z.D.gettit()))
			{
				System.out.println ("\n LIBROS :" );
				q.F.mostrar();
				System.out.println ("\n DOCUMENTOS :");
			    z.D.mostrar();
			}
			
			if (z.der != null)
			aux1.adicion (z.der);
		    
		    if (z.izq != null)
			z = z.izq;
		    else
			z = aux1.eliminacion ();
		}
		if (q.der != null)
		aux.adicion (q.der);
	    
	    if (q.izq != null)
		q = q.izq;
	    else
		q = aux.eliminacion ();
	}
    
    
    }  
   void  buscaLibrodesc (String x)
   {
	Pila aux = new Pila ();
	aux.adicion (null);
	nodo q = raiz;
	while (q != null)
	{
		if (q.F.getcod().equals(x))
			 q.F.mostrar();
		if (q.der != null)
		aux.adicion (q.der);
	    
	    if (q.izq != null)
		q = q.izq;
	    else
		q = aux.eliminacion ();
	}
 
   }
}


