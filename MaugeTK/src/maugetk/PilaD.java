package maugetk;

class PilaD extends Pila_ColaD
{
    int top;
    PilaD ()
    {
	top = 0;
    }


    boolean esvacia ()
    {
	if (top == 0)
	    return (true);
	return (false);
    }


    boolean esllena ()
    {
	if (top == max)
	    return (true);
	return (false);
    }


    void adicion (nodoD elem)
    {
	if (!esllena ())
	{
	    top++;
	    v [top] = elem;
	}
	else
	    System.out.println ("Pila llena");
    }


    nodoD eliminacion ()
    {
	nodoD elem = null;
	if (!esvacia ())
	{
	    elem = v [top];
	    top--;

	}
	else
	    System.out.println ("Pila vacia");
	return (elem);
    }

	void vaciar(PilaD z)
	{
		while(!z.esvacia())
		    adicion(z.eliminacion());
	}
}
