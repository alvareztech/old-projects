

import java.util.*;
public class Lspasajero 
{
	LinkedList<Pasajero> LP=new LinkedList<Pasajero>();
	int n;
    public void leer()
    {
    	Scanner in=new Scanner(System.in);
    	System.out.println(":::Lista de pasajeros:::");
    	System.out.print("\nIngrese nro. de pasajeros : ");
    	 n=in.nextInt();
    	for(int i=1;i<=n;i++)
    	{
    		Pasajero P=new Pasajero();
    		P.leerPas();
    		LP.add(P);
    	}
    }
    
    public void mostrar2()
    {
    	System.out.println(":::Lista de pasajeros:::");
    	for(int i=1;i<=n;i++)
    	{
    		Pasajero P=LP.removeFirst();
    		P.mostrarPas();
    		LP.addLast(P);
    	}
    }
    public String  mostrar()
    {
        String c="";
    	c+="\n:::Lista de pasajeros:::";
    	for(int i=1;i<=n;i++)
    	{
    		Pasajero P=LP.removeFirst();
    		c+=P.mostrarPas2();
    		LP.addLast(P);
    	}
        return c;
    }

}
