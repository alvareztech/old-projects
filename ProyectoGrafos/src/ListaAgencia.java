

import java.util.LinkedList;
import java.util.Scanner;


public class ListaAgencia {
	LinkedList<Agencia> LP=new LinkedList<Agencia>();
	int n;
    public void leerl()
    {
    	Scanner in=new Scanner(System.in);
    	System.out.println(":::Lista de agencias:::");
    	System.out.print("\nIngrese nro. agencias : ");
    	 n=in.nextInt();
    	for(int i=1;i<=n;i++)
    	{
    		Agencia v=new Agencia();
    		v.leerAg();
    		LP.add(v);
    	}
    }
    
    public void mostrarl()
    {
    	System.out.println(":::Lista de agencias:::");
    	for(int i=1;i<=n;i++)
    	{
    		Agencia v=LP.removeFirst();
    		v.mostrarAg();
    		LP.addLast(v);
    	}
    }
}
