package a3d.teamorganizer.src;

class ListaMultiple_P
{
    NodoM_P PM;

    public ListaMultiple_P ()
    {
	PM = null;
    }


    /*
	public void leer (int n)
	{
	    for (int i = 1 ; i <= n ; i++)
	    {
		System.out.println (" Partido");
		System.out.print ("  Dia: ");
		int d = Leer.datoInt ();
		System.out.print ("  Mes: ");
		int m = Leer.datoInt ();
		System.out.print ("  Anio: ");
		int a = Leer.datoInt ();
		System.out.print ("  Tipo: ");
		String tip = Leer.datoString ();
		System.out.print ("  Lugar: ");
		String lug = Leer.datoString ();
		System.out.print ("  Rival: ");
		String riv = Leer.datoString ();
		System.out.print ("  GolesE: ");
		int gE = Leer.datoInt ();
		System.out.print ("  GolesR: ");
		int gR = Leer.datoInt ();
		System.out.print ("  Nro.Eventos: ");
		ListaSimple_E ev = new ListaSimple_E ();
		ev.leer (Leer.datoInt ());
		adiUltimo (d, m, a, tip, lug, riv, gE, gR, ev);
	    }
	}
    */

    public void mostrar ()
    {
	System.out.println (" Partidos");
	NodoM_P x = PM;
	while (x != null)
	{
	    System.out.println ("  Partido");
	    System.out.println ("   Fecha: " + x.dia + "/" + x.mes + "/" + x.anio);
	    System.out.println ("   Tipo: " + x.tipo);
	    System.out.println ("   Lugar: " + x.lugar);
	    System.out.println ("   Rival: " + x.rival);
	    System.out.println ("   Goles: " + x.golesE + " . " + x.golesR);
	    System.out.println ("   Eventos");
	    ListaSimple_E ev = new ListaSimple_E ();
	    ev.P = x.eventos;
	    ev.mostrar ();
	    x = x.sig;
	}
    }


    public boolean esVacia ()
    {
	if (PM == null)
	    return true;
	return false;
    }


    public void adiPrimero (int d, int m, int a, String tip, String lug, String riv, int gE, int gR, ListaSimple_E ev)
    {
	NodoM_P x = new NodoM_P ();
	x.dia = d;
	x.mes = m;
	x.anio = a;
	x.tipo = tip;
	x.lugar = lug;
	x.rival = riv;
	x.golesE = gE;
	x.golesR = gR;
	x.eventos = ev.P;
	x.sig = PM;
	PM = x;
    }


    public void adiUltimo (int d, int m, int a, String tip, String lug, String riv, int gE, int gR, ListaSimple_E ev)
    {
	NodoM_P x = new NodoM_P ();
	NodoM_P y;
	if (!esVacia ())
	{
	    x.dia = d;
	    x.mes = m;
	    x.anio = a;
	    x.tipo = tip;
	    x.lugar = lug;
	    x.rival = riv;
	    x.golesE = gE;
	    x.golesR = gR;
	    x.eventos = ev.P;
	    y = PM;
	    while (y.sig != null)
		y = y.sig;
	    y.sig = x;
	}
	else
	    adiPrimero (d, m, a, tip, lug, riv, gE, gR, ev);
    }


    public NodoM_P eliPrimero ()
    {
	NodoM_P x = null;
	if (!esVacia ())
	{
	    x = PM;
	    PM = PM.sig;
	    x.sig = null;
	}
	return x;
    }


    public NodoM_P eliUltimo ()
    {
	NodoM_P x = null;
	if (!esVacia ())
	{
	    x = PM;
	    if (PM.sig == null)
		PM = null;
	    else
	    {
		NodoM_P y = PM;
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
	NodoM_P x;
	x = PM;
	while (x != null)
	{
	    c = c + 1;
	    x = x.sig;
	}
	return c;
    }
}
