package maugetk;

class Pila extends Pila_Cola
{
    int top;
    Pila ()
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


    void adicion (nodo elem)
    {
	if (!esllena ())
	{
	    top++;
	    v [top] = elem;
	}
	else
	    System.out.println ("Pila llena");
    }


    nodo eliminacion ()
    {
	nodo elem = null;
	if (!esvacia ())
	{
	    elem = v [top];
	    top--;

	}
	else
	    System.out.println ("Pila vacia");
	return (elem);
    }

	void vaciar(Pila z)
	{
		while(!z.esvacia())
		    adicion(z.eliminacion());
	}
}
