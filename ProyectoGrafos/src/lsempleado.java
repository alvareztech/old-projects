

import java.util.*;
public class lsempleado 
{
	LinkedList<Empleado> LP=new LinkedList<Empleado>();
	int n;
    public void leere()
    {
    	System.out.println(":::Lista de empleados:::");
    	System.out.print("\nIngrese nro. empleados : ");
    	Scanner in=new Scanner(System.in);
		n=in.nextInt(); 
    	for(int i=1;i<=n;i++)
    	{
    		Empleado E=new Empleado();
    		E.leerE();
    		LP.add(E);
    	}
    }
    
    public void mostrare2()
    {
    	System.out.println(":::Lista de empleados:::");
    	for(int i=1;i<=n;i++)
    	{
    		Empleado E=LP.removeFirst();
    		E.mostrarE();
    		LP.addLast(E);
    	}
    }
    public String mostrare()
    {
        String c="";
    	c=c+"\n:::Lista de empleados:::";
    	for(int i=1;i<=n;i++)
    	{
    		Empleado E=LP.removeFirst();
    		c=c+E.mostrarE();
    		LP.addLast(E);
    	}
        return c;
    }
}
