package a3d.teamorganizer.src;

class Arbol_J
{
    protected Nodo_J R;

    public Arbol_J ()
    {
	R = null;
    }


    public void cargar (String nom, int ed, String pos, int med, int est, int pes)
    {
	//System.out.println (" Jugador");
	Nodo_J x = new Nodo_J ();
	x.nombre = nom;
	x.edad = ed;
	x.posicion = pos;
	x.media = med;
	x.estatura = est;
	x.peso = pes;
	Nodo_J y;
	if (esVacia ())
	    R = x;
	else
	{
	    y = raiz ();
	    int sw = 0;
	    while (sw == 0)
	    {
		if (x.edad > y.edad)
		{
		    if (y.der != null)
			y = y.der;
		    else
		    {
			y.der = x;
			sw = 1;
		    }
		}
		else
		{
		    if (y.izq != null)
			y = y.izq;
		    else
		    {
			y.izq = x;
			sw = 1;
		    }
		}
	    }
	}
    }


    public void mostrar ()
    {
	r_inOrden ();
    }


    public Nodo_J raiz ()
    {
	return R;
    }


    public boolean esVacia ()
    {
	if (R == null)
	    return true;
	return false;
    }


    public PilaN_J r_inOrden ()
    {
	//System.out.println (" Jugadores");
	PilaN_J p = new PilaN_J ();
	PilaN_J aux = new PilaN_J ();
	p.adicionar (null);
	Nodo_J x = R;
	while (!p.esVacia ())
	{
	    while (x != null)
	    {
		p.adicionar (x);
		x = x.izq;
	    }
	    x = p.eliminar ();
	    if (x != null)
	    {
		aux.adicionar (x);
		//System.out.println ("  <" + x.nombre + " , " + x.edad + " , " + x.posicion + " , " + x.media + " , " + x.estatura + " , " + x.peso + " >");
		x = x.der;
	    }
	}
	return aux;
    }


    public String masJoven ()
    {
	PilaN_J p = new PilaN_J ();
	PilaN_J aux = new PilaN_J ();
	p.adicionar (null);
	Nodo_J x = R;
	while (!p.esVacia ())
	{
	    while (x != null)
	    {
		p.adicionar (x);
		x = x.izq;
	    }
	    x = p.eliminar ();
	    if (x != null)
	    {
		aux.adicionar (x);
		//System.out.println ("  <" + x.nombre + " , " + x.edad + " , " + x.posicion + " , " + x.media + " , " + x.estatura + " , " + x.peso + " >");
		x = x.der;
	    }
	}
	p.vaciar (aux);
	Nodo_J y = p.eliminar ();
	return y.nombre;
    }
}
