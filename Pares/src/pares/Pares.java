package pares;

import java.awt.*;
import java.lang.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random;
import java.io.*;

class Pares extends JFrame implements ActionListener
{
	JButton boton [][] = new JButton[5][8];
	JLabel nombre = new JLabel("Encontrando Pares",JLabel.CENTER);
	ImageIcon foto []=new ImageIcon[20]; 
	ImageIcon vacia;
	JLabel Lintentos=new JLabel("N�mero de intentos: 0        ");
	JLabel Puntos=new JLabel("Hello ",JLabel.RIGHT);

	int ficha [][]=new int [5][8];
	int comprobar=0;
	int pos1,i1,j1,j2,i2,quedan,intentos=0;

	Pares ()
	{

		vacia=new ImageIcon("quien.JPG");

		for(int i=0;i<20;i++)
		{
			foto[i]=new ImageIcon(Integer.toString(i)+".JPG");
		}
		add(nombre,"North");
		JPanel central=new JPanel(new GridLayout(5,8));
		for(int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{

				boton[i][j]=new JButton();

				boton[i][j].addActionListener(this);
				boton[i][j].setBackground(Color.WHITE);
				central.add(boton[i][j]);
			}
		}
		add(central,"Center");
		JPanel Pun = new JPanel();
		Pun.setLayout(new GridLayout(1,2));
		Pun.add(Lintentos);
		Pun.add(Puntos);
		add(Pun,"South");


		ImagenesAleatorias ();
		VerPuntuacion();


		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});



		setTitle("Proyecto de INF-143");	
		setResizable(false);
		setSize(800,600);
		setVisible(true);
	}

	void ImagenesAleatorias ()
	{
		int x,y=0;int numero=-1;
		double x1,y1=0;

		for(int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{
				ficha[i][j]=-1;
			}

		}

		for (int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{
				do
				{
					x1=Math.random()*5;
					y1=Math.random()*8;
					x=(int)x1;
					y=(int)y1;
				}
				while(ficha[x][y]!=-1);
				numero++;
				if (numero==20)numero=0;
				ficha[x][y]=numero;
				boton[i][j].setIcon(vacia);
			}
		}	
	}
	public void actionPerformed(ActionEvent ae)
	{
		for (int i=0;i<5;i++)
		{
			for(int j=0;j<8;j++)
			{	
				if(ae.getSource()==boton[i][j])
				{
					if(boton[i][j].getIcon().equals(vacia))
					{
						comprobar++;

						if(comprobar!=3)boton[i][j].setIcon(foto[ficha[i][j]]);
						if(comprobar==1)  
						{
							pos1=ficha[i][j]; 
							i1=i; 	
							j1=j;		
							intentos++; 
						}
						if(comprobar==2) 
						{ 
							if(pos1==ficha[i][j]) 
							{
								quedan++; 
								comprobar=0; 
								intentos++; 
							}
							else 
							{
								i2=i;
								j2=j;
							}
						}	 

						if(comprobar==3) 
						{
							boton[i1][j1].setIcon(vacia);
							boton[i2][j2].setIcon(vacia);	
							comprobar=0;	      		    	 	
						}

					}
				}
			}
		}

		Lintentos.setText("N�mero de intentos: "+intentos + "		");

		if(quedan==20)
		{
			JOptionPane.showMessageDialog(this,"El n� de Intentos es:     " + intentos,"FELISIDADEZ  GANAZTEZ",JOptionPane.INFORMATION_MESSAGE,vacia);	 
			Puntuacion();
			VerPuntuacion();
			quedan=0;
			intentos=0;
			ImagenesAleatorias();
			Lintentos.setText("N�mero de intentos: "+intentos );
		} 
	} 

	void VerPuntuacion() 
	{
		String record="";
		String nom="";
		try
		{
			FileReader puntuacionmax=new FileReader("record.txt");
			BufferedReader leer=new BufferedReader(puntuacionmax);
			record=leer.readLine();
			nom=leer.readLine();
			puntuacionmax.close();
		}
		catch(IOException ioe)
		{
		}
		Puntos.setText(nom + ": " + record);
	}

	void Puntuacion() 
	{
		String record="";
		String nom="Nose";
		try
		{
			FileReader puntuacionmax=new FileReader("record.txt");
			BufferedReader leer=new BufferedReader(puntuacionmax);
			record=leer.readLine();
			nom=leer.readLine();
			puntuacionmax.close();
		}
		catch(IOException ioe)
		{	
		}

		try
		{
			Integer.parseInt(record);
		}
		catch(NumberFormatException NFE)
		{
			record="100";  
		}
		if(intentos < Integer.parseInt(record))
		{
			try
			{	
				FileWriter  puntuacionmax=new FileWriter("record.txt");
				nom=JOptionPane.showInputDialog("Nuevo Record!!!Escribe tu Nombre:");
				puntuacionmax.write(Integer.toString(intentos)+"\n");
				puntuacionmax.write(nom +"\n");
				puntuacionmax.close();
			}
			catch (IOException ioe)
			{

			}

		}
	}  	

	public static void main (String [] args)
	{
		new Pares ();
	}
}