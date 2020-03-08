package pruebas;
/**
 * Transformacion2.java	2.0 6/04/2011
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;

/**
 * @author Jhonny Felipez
 * @version 2.0 6/04/2011
 */
public class Transformacion2 implements GLEventListener, KeyListener {
	final int INCREMENTO = 16;
	public static void main(String[] args) {
		
		// Primero se crea el objeto JFrame
		JFrame miMarco = new JFrame("Transformación 2");

		// Para que al cerrar la ventana el programa finalice.
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Se crea el objeto GLCanvas
		GLCanvas miCanvas = new GLCanvas();
		
		// Indicamos que miCanvas detecte los eventos de openGL de la Clase
		miCanvas.addGLEventListener(new Transformacion2());
		
		// A continuacion insertamos miCanvas en miMarco
		miMarco.add(miCanvas);
		
		// Definimos el tamaño de la ventana.
		miMarco.setSize(500, 500);
		
		// Definimos la posición inicial de la ventana.
		miMarco.setLocation(100, 100);
		
		// Por ultimo hacemos visible el elemento de mayor nivel
		miMarco.setVisible(true);
	}
	
	public void init(GLAutoDrawable drawable) {
	    GL gl = drawable.getGL(); // inicializa la variable GL
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); // fondo negro
		drawable.addKeyListener(this); // Para detectar eventos del teclado.
	}

	public void display(GLAutoDrawable drawable) {
	    GL gl = drawable.getGL(); // inicializa la variable GL
	    gl.glClear(GL.GL_COLOR_BUFFER_BIT);	// borra el buffer de la ventana
		gl.glMatrixMode(GL.GL_MODELVIEW); // utiliza matriz de vista del modelo
		gl.glLoadIdentity(); // inicializa matriz de vista de modelo

	    dibujaEjes(gl);

		gl.glColor3f(0.0f, 0.0f, 1.0f);	// azul
	    dibujaCirculo(gl);
	    
		gl.glColor3f(1.0f, 0.0f, 0.0f);	// rojo
		gl.glLoadIdentity(); // no es necesario
	    gl.glTranslated(8,0,0);
	    dibujaCirculo(gl);
	    
	    gl.glColor3f(0.0f, 1.0f, 0.0f);	// verde
	    gl.glLoadIdentity(); // retorna al origen
	    gl.glTranslated(3,2,0);
	    gl.glScaled(1,4,2);
	    dibujaCirculo(gl);
		gl.glFlush(); // asegura que se ejecute las anteriores instrucciones
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL gl = drawable.getGL(); // Inicializa la variable GL
		GLU glu = new GLU(); // Inicializa la variable GL

		gl.glViewport(0, 0, w, h); // define tamaño
		gl.glMatrixMode(GL.GL_PROJECTION); // utiliza matriz de proyeccion
		gl.glLoadIdentity(); // inicializa matriz de proyeccíon

		glu.gluOrtho2D(-2.0f, 10.0f, -2.0f, 10.0f); // proyección en paralelo
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {}
	
	public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
                case 'q':
        		case 27: // tecla Escape
        			System.exit(0);
        }
	}

	public void keyReleased(KeyEvent arg0) {}

	public void keyTyped(KeyEvent arg0) {}
		
	public void dibujaCirculo(GL gl) {
	    int contador;
        
	    gl.glBegin(GL.GL_POLYGON);
	        for (contador = 0; contador <= INCREMENTO*2; contador++)
	        {
	            float theta = (float)(contador * Math.PI)/INCREMENTO;
	            gl.glVertex2f((float)Math.sin(theta), (float)Math.cos(theta));        
	        }
	    gl.glEnd();
	}
	
	public void dibujaEjes(GL gl) {
		gl.glColor3f(1.0f, 1.0f, 0.0f);	// amarillo
	    gl.glBegin(GL.GL_LINES);
	        gl.glVertex2f(-2.0f, 0.0f);
	        gl.glVertex2f(10.0f, 0.0f);
	        gl.glVertex2f(0.0f, -2.0f);
	        gl.glVertex2f(0.0f, 10.0f);
	    gl.glEnd();
	}
}
