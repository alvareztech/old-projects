package a3d.teamorganizer.src;

class ListaSimple_E
{
    Nodo_E P;
    public ListaSimple_E ()
    {
	P = null;
    }


    /*
	public void leer (int n)
	{
	    for (int i = 1 ; i <= n ; i++)
	    {
		System.out.println ("   Evento");
		System.out.print ("    Tiempo: ");
		String t = Leer.datoString ();
		System.out.print ("    Minuto: ");
		int m = Leer.datoInt ();
		System.out.print ("    Autor: ");
		String a = Leer.datoString ();
		System.out.print ("    Tipo:  ");
		String tip = Leer.datoString ();
		adiUltimo (t, m, a, tip);
	    }
	}
    */

    public void mostrar ()
    {
	Nodo_E x = P;
	while (x != null)
	{
	    System.out.println ("   -> " + x.tiempo + " - " + x.minuto + " - " + x.autor + " - " + x.tipo);
	    x = x.sig;
	}
    }


    public boolean esVacia ()
    {
	if (P == null)
	    return true;
	return false;
    }


    public void adiPrimero (String t, int m, String a, String tip)
    {
	Nodo_E x = new Nodo_E ();
	x.tiempo = t;
	x.minuto = m;
	x.autor = a;
	x.tipo = tip;
	x.sig = P;
	P = x;
    }


    public void adiUltimo (String t, int m, String a, String tip)
    {
	Nodo_E x = new Nodo_E ();
	Nodo_E y;
	if (!esVacia ())
	{
	    x.tiempo = t;
	    x.minuto = m;
	    x.autor = a;
	    x.tipo = tip;
	    y = P;
	    while (y.sig != null)
		y = y.sig;
	    y.sig = x;
	}
	else
	    adiPrimero (t, m, a, tip);
    }


    public Nodo_E eliPrimero ()
    {
	Nodo_E x = null;
	if (!esVacia ())
	{
	    x = P;
	    P = P.sig;
	    x.sig = null;
	}
	return x;
    }


    public Nodo_E eliUltimo ()
    {
	Nodo_E x = null;
	if (!esVacia ())
	{
	    x = P;
	    if (P.sig == null)
		P = null;
	    else
	    {
		Nodo_E y = P;
		while (x.sig != null)
		{
		    y = x;
		    x = x.sig;
		}
		y.sig = null;
	    }
	}
	return x;
    }


    public int nroElems ()
    {
	int c = 0;
	Nodo_E x;
	x = P;
	while (x != null)
	{
	    c = c + 1;
	    x = x.sig;
	}
	return c;
    }
}
