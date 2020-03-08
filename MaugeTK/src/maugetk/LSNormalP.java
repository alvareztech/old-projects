package maugetk;


public class LSNormalP extends ListaSimpleP{
	LSNormalP ()
    {
        super ();
    }


    int nronodos ()
    {
        int c = 0;
        NodoP r = p;
        while (r != null)
        {
            c = c + 1;
            r = r.sig;
        }
        return c;

    }


    boolean esvacia ()
    {
        if (p == null)
            return true;
        return false;
    }


    void adiprimero (Registro oe)
    {
        NodoP w = new NodoP ();
        w.A = oe;
        w.sig = p;
        p = w;
    }


    void adiultimo (Registro oe)
    {
        NodoP w = new NodoP ();
        NodoP r;
        w.A = oe;
        if (esvacia ())
        {
            p = w;
        }
        else
        {
            r = p;
            while (r.sig != null)
                r = r.sig;
            r.sig = w;
        }
    }


    void leer1 (int n)
    {
        int i;
        for (i = 1 ; i <= n ; i++)
        {
            Registro a = new Registro ();
            
            a.leer ();
            adiprimero (a);
        }
    }


    void leer2 (int n)
    {
        int i;
        for (i = 1 ; i <= n ; i++)
        {
        	Registro a = new Registro ();
            a.leer ();
            adiultimo (a);
        }


    }


    void mostrar ()
    {
        NodoP r;
        r = p;
        System.out.println ("REGISTROS ");
        while (r != null)
        {
        	
        	r.A.mostrar ();
        	System.out.println ();
            r = r.sig;
        }
    }


    NodoP eliprimero ()
    {
        NodoP x;
        x = p;
        p = p.sig;
        x.sig = null;
        return x;
    }


    NodoP eliultimo ()
    {
        NodoP x, r;
        x = r = p;
        if (r.sig == null)
            p = null;
        else
            while (r.sig != null)
            {
                x = r;
                r = r.sig;
            }
        x.sig = null;
        x = r;
        return (x);
    }


    void llevafinal ()
    {
        NodoP x, r;
        r = p.sig;
        x = p;
        p = r;
        while (r.sig != null)
            r = r.sig;
        r.sig = x;
        x.sig = null;
    }
   
    void muestraP()
    {
    	
    	NodoP q=p;
    	while(q!=null)
    	{
    		System.out.println(q.A.getnom());
    		q=q.sig;
    	}
    	
    }
   String retornaP(int x)
    {
    	String c="";
    	NodoP q=p;
    	for(int i=1;i<=x;i++)
    	{
    		if(i==x)
    		{
    			c=q.A.getnom();
    		}
    		
    		q=q.sig;
    	}
    	
    	return (c);
    	
    	
    }
    
 
   public void MuestraReg(NodoP z ,String x,String y)
   {
	   if(z!=null)
	   {
		   if(z.A.gethora().equals(x)&& z.A.getfecha().equals(y))
		   {
		   	System.out.println(z.A.getcorreo());
		   }
		  MuestraReg(z.sig,x,y);
	   }
	   
   }
   public void MuestraSug(NodoP z)
   {
	   if(z!=null)
	   {
		  	System.out.println( z.A.getsug());
		   
		    MuestraSug(z.sig);
	   }
	   
   }
   public String mostrarLD(NodoP z,String x)
   {
	   if(z==null)
		      return "";
	  else
	  {
	  	 
		 if(z.A.getnom().equals(x))
				   
		   {
		     return z.A.getcod();
		   }
		 return (mostrarLD(z.sig,x));
		   
	  }
	   
   }

}
