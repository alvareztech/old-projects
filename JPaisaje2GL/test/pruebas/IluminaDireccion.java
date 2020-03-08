package pruebas;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;

/**
 * Este demo muestra la iluminación sobre un objeto. Se muestra la rotación de la
 * luz al rededor de la tetera, como una especie de una linterna. Para
 * ello se realiza una rotación con respecto al eje 'y' tanto del vector de
 * posición asi como del vector de dirección, además del objeto de iluminación.
 * 
 * @author Jhonny Felipez
 * @version 1.0 13/06/2011
 */
public class IluminaDireccion implements GLEventListener, MouseListener {
	static float angulo = 0;

	// Inicia definición de materiales
	final float[] mat_ambiente = { 0.0f, 0.0f, 0.0f, 1.0f };
	final float[] mat_difuso = { 0.8f, 0.01f, 0.01f, 1.0f };
	final float[] mat_especular = { 1f, 0.001f, 0.001f, 1.0f };
	final float mat_brillo = 128.0f;

	GLU glu = new GLU();
	GLUT glut = new GLUT();

	public static void main(String[] args) {

		// Primero se crea el objeto JFrame
		JFrame miMarco = new JFrame("vista cubo");

		// Para que al cerrar la ventana el programa finalice.
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Se crea el objeto GLCapabilities
		GLCapabilities miCapacidad = new GLCapabilities();

		// Solicita doble buffer en el modo de despliegue
		miCapacidad.setDoubleBuffered(true);

		// Se crea el objeto GLCanvas
		GLCanvas miCanvas = new GLCanvas(miCapacidad);

		// Indicamos que miCanvas detecte los eventos de openGL de la Clase
		miCanvas.addGLEventListener(new IluminaDireccion());

		// Agrega animación a miCanvas - 60 cuadros por segundo
		FPSAnimator animador = new FPSAnimator(miCanvas, 60);

		// A continuacion insertamos miCanvas en miMarco
		miMarco.add(miCanvas);

		// Definimos el tamaño de la ventana.
		miMarco.setSize(500, 500);

		// Definimos la posición inicial de la ventana.
		miMarco.setLocation(100, 100);

		// Hacemos visible el elemento de mayor nivel
		miMarco.setVisible(true);

		// Inicia la animación
		animador.start();
	}

	public void init(GLAutoDrawable drawable) {
		GL gl = drawable.getGL(); // inicializa la variable GL

		gl.glClearColor(0.5f, 0.5f, 1.0f, 1.0f);

		// Habilita Iluminación
		gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de
										// superficies

		drawable.addMouseListener(this); // Para detectar eventos del teclado
	}

	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();

		// borra buffer y el z-buffer, rota el cubo y dibuja, intercambiando
		// buffers
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		glu.gluLookAt(0.0f, 0.0f, 5.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

		gl.glTranslatef(0.0f, 0.0f, -5.0f);

		gl.glPushMatrix();

		gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);

		luz0(gl);

		gl.glPopMatrix();

		// Superficie
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambiente, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_difuso, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_especular, 0);
		gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, mat_brillo);

		glut.glutSolidTeapot(1.0f);

		gl.glFlush();

		drawable.swapBuffers();
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL gl = drawable.getGL();
		GLU glu = new GLU();

		if (h == 0)
			h = 1;
		gl.glViewport(0, 0, w, h);
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		if (w > h)
			glu.gluPerspective(45.0f, w / h, 1, 150.0f);
		else
			glu.gluPerspective(45.0f, w / h, 1, 150.0f);

		gl.glMatrixMode(GL.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1)
			angulo = (angulo + 10) % 360;
	}

	public void mouseClicked(MouseEvent arg0) {
	}

	public void mouseEntered(MouseEvent arg0) {
	}

	public void mouseExited(MouseEvent arg0) {
	}

	public void mouseReleased(MouseEvent arg0) {
	}

	public void luz0(GL gl) {
		float[] negro = { 0.0f, 0.0f, 0.0f, 1.0f };
		float[] blanco = { 1.0f, 1.0f, 1.0f, 1.0f };

		float[] posicion = { 0.0f, 0.0f, 2.5f, 1.0f }; // w == 1 posicional
		float[] direccion = { 0.0f, 0.0f, -1.0f }; // por defecto (0,0,-1)

		gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
		gl.glEnable(GL.GL_LIGHT0); // Habilita la luz 0

		// Dirección, ángulo y exponente
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPOT_DIRECTION, direccion, 0); // por
																		// defecto
																		// (0,0,-1)
		gl.glLightf(GL.GL_LIGHT0, GL.GL_SPOT_CUTOFF, 10.0f); // por defecto 180º
		gl.glLightf(GL.GL_LIGHT0, GL.GL_SPOT_EXPONENT, 0.0f); // por defecto es
																// cero

		// Ambiente, difuso, especular y brillo.
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, negro, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, blanco, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, blanco, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);

		// gl.glTranslatef(0.0f, 0.0f, 1.5f);

		gl.glDisable(GL.GL_LIGHTING); // Deshabilita la iluminacion

		// Dibuja el punto de iluminación
		// gl.glColor3f (0.0f, 1.0f, 1.0f);
		// glut.glutWireCube (0.5f);

		gl.glPointSize(12.0f);
		gl.glBegin(GL.GL_POINTS);
		gl.glVertex3fv(posicion, 0);
		gl.glEnd();

		gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion

	}
}
