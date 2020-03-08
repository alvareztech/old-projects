

import java.util.*;
public class ListaVuelo {
	LinkedList<Vuelo> LP=new LinkedList<Vuelo>();
	int n;
    public void leerl()
    {
    	Scanner in=new Scanner(System.in);
    	System.out.println(":::Lista de Vuelos:::");
    	System.out.print("\nIngrese nro. empleados : ");
    	 n=in.nextInt();
    	for(int i=1;i<=n;i++)
    	{
    		Vuelo v=new Vuelo();
    		v.leerVu();
    		LP.add(v);
    	}
    }
    
    public void mostrarl2()
    {
    	System.out.println(":::Lista de Vuelos:::");
    	for(int i=1;i<=n;i++)
    	{
    		Vuelo v=LP.removeFirst();
    		v.mostrarVu();
    		LP.addLast(v);
    	}
    }
public String mostrarl()
   {
     String c="";
    	c+="\n:::Lista de Vuelos:::";
    	for(int i=1;i<=n;i++)
    	{
    		Vuelo v=LP.removeFirst();
    		c+=v.mostrarVu();
    		LP.addLast(v);
    	}
        return c;
    }
}
