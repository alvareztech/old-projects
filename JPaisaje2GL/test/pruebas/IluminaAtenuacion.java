package pruebas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;

/**
 * Este demo muestra la iluminación sobre la tetera. Incluye la atenuación de la luz.
 * 
 * @author Jhonny Felipez
 * @version 1.0 10/06/2011
 */
public class IluminaAtenuacion implements GLEventListener, KeyListener {

	static float angulo = 0;
	
	// Inicia definición de materiales
	final float [] mat_ambiente  = {0.8f, 0.0f, 0.0f, 1.0f};
	final float [] mat_difuso    = {0.8f, 0.0f, 0.0f, 1.0f};
	final float [] mat_especular = {1.0f, 1.0f, 1.0f, 1.0f};
	final float mat_brillo = 128.0f;
	
	boolean atenuacion = false;

	public static void main(String[] args) {

		// Primero se crea el objeto JFrame
		JFrame miMarco = new JFrame("Superficies en OpenGL");

		// Para que al cerrar la ventana el programa finalice.
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Se crea el objeto GLCapabilities
		GLCapabilities miCapacidad = new GLCapabilities();

		// Solicita doble buffer en el modo de despliegue
		miCapacidad.setDoubleBuffered(true);

		// Se crea el objeto GLCanvas
		GLCanvas miCanvas = new GLCanvas(miCapacidad);

		// Indicamos que miCanvas detecte los eventos de openGL de la Clase
		miCanvas.addGLEventListener(new IluminaAtenuacion());

		// Agrega animación a miCanvas - 60 cuadros por segundo
		FPSAnimator animador = new FPSAnimator(miCanvas, 60);

		// A continuacion insertamos miCanvas en miMarco
		miMarco.add(miCanvas);

		// Definimos el tamaño de la ventana.
		miMarco.setSize(512, 512);

		// Definimos la posición inicial de la ventana.
		miMarco.setLocation(120, 120);

		// Hacemos visible el elemento de mayor nivel
		miMarco.setVisible(true);

		// Inicia la animación
		animador.start();
	}

	public void init(GLAutoDrawable drawable) {
		GL gl = drawable.getGL(); // inicializa la variable GL

		gl.glClearColor(0.5f, 0.5f, 1.0f, 0.0f);
		
		gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
		
		drawable.addKeyListener(this); // Para detectar eventos del teclado.
	}

	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		GLU glu = new GLU();
		GLUT glut = new GLUT();

		// borra buffer y el z-buffer, rota el cubo y dibuja, intercambiando buffers
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();

		//glu.gluLookAt(0.0f,10.0f,40.0f, 0.0f,0.0f,0.0f, 0.0f,1.0f,0.0f);
	
		gl.glTranslatef(0.0f, 0.0f, -25.0f);
		gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
		
		luz0(gl);
	
		material(gl, mat_ambiente, mat_difuso, mat_especular, mat_brillo);

		gl.glTranslatef(2.0f, 0.0f, -1.0f);
		
		glut.glutSolidTeapot(2.0f);

		drawable.swapBuffers();

		gl.glFlush();

		angulo += 0.2f;
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

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {}
	
	public void keyPressed(KeyEvent e) {
		int tecla = e.getKeyChar(); 
		switch (tecla) {
			case 'a': // cambia valores de la atenuación 
				atenuacion = !atenuacion; break;
        	case 'q':
        	case 27: // tecla Escape
        		System.exit(0);
		}
	}
	
	public void keyReleased(KeyEvent e) {}

	public void keyTyped(KeyEvent e) {}
	
	public void luz0(GL gl) {
		float [] negro = { 0.0f, 0.0f, 0.0f, 1.0f };
		float [] blanco = { 1.0f, 1.0f, 1.0f, 1.0f };
		
		float [] posicion = { -5.0f, 4.0f, 0.0f, 1.0f }; // w == 1 posicional
		
		gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
		gl.glEnable(GL.GL_LIGHT0); // Habilita la luz 0

		// Se setean los parámetros
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, negro, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, blanco, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, blanco, 0);
	  	gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);
	  	
		// Atenuación
		if (atenuacion) {
            gl.glLightf(GL.GL_LIGHT0, GL.GL_CONSTANT_ATTENUATION, 1.0f); // por defecto kc = 1
            gl.glLightf(GL.GL_LIGHT0, GL.GL_LINEAR_ATTENUATION, 0.1f); //  por defecto kl = 0
            gl.glLightf(GL.GL_LIGHT0, GL.GL_QUADRATIC_ATTENUATION, 0.0f); // por defecto kq = 0
        } else {
            gl.glLightf(GL.GL_LIGHT0, GL.GL_CONSTANT_ATTENUATION, 1.0f);
            gl.glLightf(GL.GL_LIGHT0, GL.GL_LINEAR_ATTENUATION, 0.0f);
            gl.glLightf(GL.GL_LIGHT0, GL.GL_QUADRATIC_ATTENUATION, 0.0f);
        }
	  	
	  	gl.glDisable(GL.GL_LIGHTING); // Deshabilita la iluminacion

	  	// Dibuja el punto de iluminación
	  	gl.glPointSize(12.0f);
        gl.glBegin(GL.GL_POINTS);
        	gl.glVertex3fv(posicion,0);
        gl.glEnd();

        gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
	}
	
	public void	material(GL gl, float amb[], float difu[], float espec[], float bri) {
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, difu, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, espec, 0);
		gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, bri);
	}
}
