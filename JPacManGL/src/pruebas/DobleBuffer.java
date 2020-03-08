package pruebas;


/*
 * @(#)Doble.java	1.0	28/04/2011
 */ 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

import javax.media.opengl.*;


import com.sun.opengl.util.FPSAnimator;

/**
 * Este es un simple programa de doble buffer. Presione el botón izquierdo del ratón
 * para rotar el rectangulo. Presione el botón del medio o el botón derecho del ratón 
 * para detener la rotación.
 *  
 * @author J Felipez
 * @version 1.0, 28/04/2011
 */
public class DobleBuffer implements GLEventListener, MouseListener, KeyListener {
	private float angulo = 0.0f, INCREMENTO = 0.0f;

	public static void main(String[] args) {
		
		// Primero se crea el objeto JFrame
		JFrame miMarco = new JFrame("Doble buffer");
		
		// Nos aseguramos que al cerrar la ventana el programa finalice.
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Se crea el objeto GLCapabilities 
		GLCapabilities miCapacidad = new GLCapabilities();
		
		// Solicita doble buffer en el modo de despliegue
		miCapacidad.setDoubleBuffered(true);
		
	    // Se crea el objeto GLCanvas
	    GLCanvas miLienzo = new GLCanvas(miCapacidad);
	    
	    // Indicamos que miLienzo detecte los eventos de openGL de la Clase
	    miLienzo.addGLEventListener(new DobleBuffer());
	    
	    // Agrega animación a miLienzo - 60 cuadros por segundo
	    FPSAnimator animador = new FPSAnimator(miLienzo, 60);
	    
	    // A continuacion insertamos miLienzo en miMarco
	    miMarco.add(miLienzo);
		
		// Definimos el tamaño de la ventana.
	    miMarco.setSize(512, 512);

	    // Hacemos visible el elemento de mayor nivel
	    miMarco.setVisible(true);
	    
	    // Inicia la animación
	    animador.start();
	}
	
	public void init(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
	    gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
	    
	    gl.glShadeModel(GL.GL_FLAT);

	    drawable.addMouseListener(this); // Para detectar eventos del mouse.
		drawable.addKeyListener(this); // Para detectar eventos del teclado.
	}

	public void display(GLAutoDrawable drawable) {
	    GL gl = drawable.getGL();						// inicializa la variable GL

		gl.glClear(GL.GL_COLOR_BUFFER_BIT);				// borra el buffer de la ventana
		gl.glPushMatrix();
		gl.glRotatef(angulo, 0.0f, 0.0f, 1.0f);
		gl.glColor3f(1.0f, 1.0f, 1.0f);
		gl.glRectf(-25.0f, -25.0f, 25.0f, 25.0f);
		gl.glPopMatrix();
		
		gl.glFlush();									// asegura que se ejecuta las anteriores instrucciones.

		incrementaAngulo();
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL gl = drawable.getGL();
	    gl.glViewport(0, 0, w, h);
	    gl.glMatrixMode(GL.GL_PROJECTION);
	    gl.glLoadIdentity();
	    if (w <= h) 
	        gl.glOrtho (-50.0, 50.0, -50.0*(float)h/(float)w, 
	            50.0*(float)h/(float)w, -1.0, 1.0);
	    else 
	        gl.glOrtho (-50.0*(float)w/(float)h, 
	            50.0*(float)w/(float)h, -50.0, 50.0, -1.0, 1.0);
	    gl.glMatrixMode(GL.GL_MODELVIEW);
	    gl.glLoadIdentity();
	}
	
	public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {}

	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mousePressed(MouseEvent mouse) {
	    switch (mouse.getButton()) {
	      case MouseEvent.BUTTON1:
	        INCREMENTO = 2f;
	        break;
	      case MouseEvent.BUTTON2:
	      case MouseEvent.BUTTON3:
	        INCREMENTO = 0f;
	        break;
	    }
	}

	public void mouseReleased(MouseEvent arg0) {}
	
	public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
        case 'q':
		case 27: // tecla Escape
			System.exit(0);
        }
	}

	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
	
	private void incrementaAngulo() {
	    angulo = angulo + INCREMENTO;
	    if (angulo > 360f) 
	    	angulo = angulo - 360;
	}
}