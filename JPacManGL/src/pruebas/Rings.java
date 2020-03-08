package pruebas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

/**
 * Ilustra push y pop de la pila de matrices. Dibuja un anillo de los anillos de triángulos.
 * 
 * @author Jhonny Felipez
 * @version 1.0 6/04/2011
 */
public class Rings implements GLEventListener, KeyListener {
	final int INCREMENTO = 30; // Grados

	public static void main(String[] args) {

		// Primero se crea el objeto JFrame
		JFrame miMarco = new JFrame("Rings");

		// Para que al cerrar la ventana el programa finalice.
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Se crea el objeto GLCanvas
		GLCanvas miCanvas = new GLCanvas();

		// Indicamos que miCanvas detecte los eventos de openGL de la Clase
		miCanvas.addGLEventListener(new Rings());

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
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		drawable.addKeyListener(this); // Para detectar eventos del teclado.
	}

	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL(); // inicializa la variable GL
		int angulo;
		gl.glClear(GL.GL_COLOR_BUFFER_BIT);
		for (angulo = 0; angulo < 360; angulo = angulo + INCREMENTO) {
			gl.glPushMatrix(); // Guarda el estado actual
			gl.glRotated(angulo, 0, 0, 1);
			gl.glTranslatef(0.0f, 0.75f, 0.0f);
			gl.glScalef(0.15f, 0.15f, 0.15f);
			dibujaAnillo(gl);
			gl.glPopMatrix(); // Restaura el estado original
		}
		gl.glFlush();
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL gl = drawable.getGL(); // inicializa la variable GL
		GLU glu = new GLU();
		gl.glViewport(0, 0, w, h);
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluOrtho2D(-1.0, 1.0, -1.0, 1.0);
		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
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

	// Dibuja un triángulo a la derecha del origen
	void dibujaTriangulo(GL gl) {
		gl.glBegin(GL.GL_POLYGON);
			gl.glVertex2d(-1, 1);
			gl.glVertex2d(-1, -1);
			gl.glVertex2d(1, -1);
		gl.glEnd();
	}

	// Dibuja una anillo de triangulos
	void dibujaAnillo(GL gl) {
		int angulo=0;
		for (angulo = 0; angulo < 360; angulo = angulo + INCREMENTO) {
			gl.glPushMatrix(); // Guarda el estado actual
			gl.glRotated(angulo, 0, 0, 1);
			gl.glTranslatef(0.0f, 0.75f, 0.0f);
			gl.glScalef(0.2f, 0.2f, 0.2f);
			gl.glColor3f((float) angulo / 360f, 0f,	1.0f - ((float) angulo / 360f)); 
			dibujaTriangulo(gl);
			gl.glPopMatrix(); // Restaura el estado original
		}
		gl.glFlush();
	}
}
