package maugetk;

class arbolnormalD extends arbolD
{
    arbolnormalD ()
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
        PilaD nivel = new PilaD ();
        PilaD desc = new PilaD ();

        nodoD x = new nodoD ();
        System.out.println("DOCUMENTO Raiz-->");
        x.D.leer();
        raiz = x;
        nivel.adicion (raiz);
        while (!nivel.esvacia ())
        {
            while (!nivel.esvacia ())
            {
                x = nivel.eliminacion ();
                System.out.print (x.D.gettit());
                System.out.print ( " Tendra Izquierda ? S/N");
                resp = Leer.dato ();
                if (resp.compareTo ("s") == 0)
                {
                    nodoD y = new nodoD ();
                    System.out.print("DOCUMENTO-->");
                    y.D.leer ();
                    x.izq = y;
                    desc.adicion (y);
                }
                else
                    x.izq = null;
                System.out.print (x.D.gettit());
                System.out.print (" Tendra Derecha ? S/N");
                resp = Leer.dato ();
                if (resp.compareTo ("s") == 0)
                {
                    nodoD y = new nodoD ();
                    System.out.print("DOCUMENTO-->");
                    y.D.leer();
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

	nodoD x;
	PilaD nivel = new PilaD ();
	PilaD desc = new PilaD ();
   // int c=35;

	nivel.adicion (raiz);
	while (!nivel.esvacia ())
	{
	    while (!nivel.esvacia ())
	    {
		x = nivel.eliminacion ();
		
		x.D.mostrar();
		
	

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
	PilaD aux = new PilaD ();
	nodoD x;
	aux.adicion (null);
	x = raiz;
	while (x != null)
	{
	    if (x.der != null)
		aux.adicion (x.der);
	    x.D.mostrar();
	    if (x.izq != null)
		x = x.izq;
	    else
		x = aux.eliminacion ();
	}
    }


    int nroelem ()
    {
	nodoD x;
	PilaD nivel = new PilaD ();
	PilaD desc = new PilaD ();
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

	nodoD x;
	int niv = 0;
	PilaD nivel = new PilaD ();
	PilaD desc = new PilaD ();

	nivel.adicion (raiz);
	while (!nivel.esvacia ())
	{
	    System.out.println ("\n Nivel :" + niv);
	    while (!nivel.esvacia ())
	    {
		x = nivel.eliminacion ();
		if (x.izq == null && x.der == null)
		    x.D.mostrar();

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
	PilaD nivel = new PilaD ();
	PilaD desc = new PilaD ();

	nodoD x;
	nivel.adicion (raiz);
	int i = 0;
	while (!nivel.esvacia ())
	{
	    System.out.print ("Nivel : " + i);
	    while (!nivel.esvacia ())
	    {
		x = nivel.eliminacion ();
		System.out.print ("  " + x.D);
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
    
   
    int  cuentaD ()
    {
	PilaD aux = new PilaD ();
	aux.adicion (null);
	nodoD q = raiz;
	int c=0;
	while (q != null)
	{
		if (q.D.gettipo().equals("pdf"))
		{
			c=c+q.D.getcantdescpdf();
			System.out.println ();
		    q.D.mostrar();
		}
		if (q.der != null)
		aux.adicion (q.der);
	    
	    if (q.izq != null)
		q = q.izq;
	    else
		q = aux.eliminacion ();
	}
	return c;
    }
    
    public void EliminaD()
    {
	PilaD aux = new PilaD ();
	aux.adicion (raiz);
    nodoD x;
	while (!aux.esvacia ())
	{
       x = aux.eliminacion ();
		if (x.izq!=null && x.izq.izq==null && x.izq.der==null)
		{
			if (x.izq.D.getcantconsult()==0 )
				   x.izq=null;
		}
		if (x.der!=null && x.der.izq==null && x.der.der==null)
		{
			if (x.der.D.getcantconsult()==0 )
				   x.der=null;
		}
		
		if (x.der!= null)
		    aux.adicion (x.der);

		if (x.izq!= null)
		    aux.adicion (x.izq);
	    }
	   
    }
    
    int  buscaDoc (String x,String y)
    {
	PilaD aux = new PilaD ();
	aux.adicion (null);
	nodoD q = raiz;
	int c=0;
	while (q != null)
	{
		if ( q.D.gettit().equals(x)&& q.D.getdia().equals(y))
			 c=c+q.D.getcantdescpdf()+q.D.getcantdescword();
		if (q.der != null)
		aux.adicion (q.der);
	    
	    if (q.izq != null)
		q = q.izq;
	    else
		q = aux.eliminacion ();
	}
    
    return c;
    }
    
}


