package pruebas;

import java.awt.event.*;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.FPSAnimator;

/**
 * Este demo muestra la iluminacion sobre el cubo.
 * 
 * @author Jhonny Felipez
 * @version 1.0 10/06/2011
 */

public class IluminaCubo implements GLEventListener, MouseListener {
	private static final float theta[] = {0.0f, 0.0f, 0.0f};
	private static int ejes = 2;
	private float[][] vertices = { {-1.0f, -1.0f, -1.0f}, { 1.0f, -1.0f, -1.0f},
		    { 1.0f,  1.0f, -1.0f}, {-1.0f,  1.0f, -1.0f}, {-1.0f, -1.0f, 1.0f},
		    { 1.0f, -1.0f,  1.0f}, { 1.0f,  1.0f,  1.0f}, {-1.0f,  1.0f, 1.0f}};
	
	private float[][] normales = {{-1.0f,-1.0f,-1.0f},{1.0f,-1.0f,-1.0f},
			{1.0f,1.0f,-1.0f}, {-1.0f,1.0f,-1.0f}, {-1.0f,-1.0f,1.0f}, 
			{1.0f,-1.0f,1.0f}, {1.0f,1.0f,1.0f}, {-1.0f,1.0f,1.0f}};

	// Inicia definición de materiales
	final float [] mat_ambiente  = {0.0f, 0.0f, 0.0f, 1.0f};
	final float [] mat_difuso    = {0.8f, 0.01f, 0.01f, 1.0f};
	final float [] mat_especular = {1f, 0.001f, 0.001f, 1.0f};
	final float mat_brillo = 128.0f;
	
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
		miCanvas.addGLEventListener(new IluminaCubo());
		
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
	    
	    gl.glClearColor(0.5f, 0.5f, 1.0f, 0.0f);
	    
	    // Parametros de la luz 0
		float [] luzAmbiente = { 0.5f, 0.5f, 0.5f, 1.0f };
		float [] luzDifusa = { 1.0f, 1.0f, 1.0f, 1.0f };
		float [] luzEspecular = { 1.0f, 1.0f, 1.0f, 1.0f };
		float [] posicion = { 10.0f, 0.0f, 0.0f, 0.0f }; // posición eje +x
	    
		// Se setean los parámetros
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, luzAmbiente, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, luzDifusa, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, luzEspecular, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);
	    
	    // Habilita Iluminación
		gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
		gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
		gl.glEnable(GL.GL_LIGHT0); // Habilita la luz 0 que previamente se habia seteado
	    
	    drawable.addMouseListener(this);  // Para detectar eventos del teclado
	}

	public void display(GLAutoDrawable drawable) {
	    GL gl = drawable.getGL();
	    GLU glu = new GLU();

	    // borra buffer y el z-buffer, rota el cubo y dibuja, intercambiando buffers
	    gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
	    gl.glLoadIdentity();
	    
	    glu.gluLookAt(0.0f,0.0f,10.0f, 0.0f,0.0f,0.0f, 0.0f,1.0f,0.0f);
	    
	    // Superficie
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambiente, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_difuso, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_especular, 0);
		gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, mat_brillo);
	    
	    gl.glRotatef(theta[0], 1.0f, 0.0f, 0.0f);
	    gl.glRotatef(theta[1], 0.0f, 1.0f, 0.0f);
	    gl.glRotatef(theta[2], 0.0f, 0.0f, 1.0f);

	    cubo(gl);

	    gl.glFlush();
	    
	    drawable.swapBuffers();
	    
	    theta[ejes] += 2.0f;
	    if (theta[ejes] > 360.0f)
	    	theta[ejes] -= 360.0f;
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

	public void mousePressed(MouseEvent e) {
		// selecciona un eje para rotar
		if (e.getButton() == MouseEvent.BUTTON1) ejes = 0;
		if (e.getButton() == MouseEvent.BUTTON2) ejes = 1;
		if (e.getButton() == MouseEvent.BUTTON3) ejes = 2;
	}
	
	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}
	
	private void poligono(GL gl, int a, int b, int c, int d) {
	    // dibuja un poligono mediante lista de vertices
	    gl.glBegin(GL.GL_POLYGON);
		    gl.glNormal3fv(normales[a],0);
		    gl.glVertex3fv(vertices[a],0);
		    gl.glNormal3fv(normales[b],0);
		    gl.glVertex3fv(vertices[b],0);
		    gl.glNormal3fv(normales[c],0);
		    gl.glVertex3fv(vertices[c],0);
		    gl.glNormal3fv(normales[d],0);
		    gl.glVertex3fv(vertices[d],0);
	    gl.glEnd();
	}
	
	private void cubo(GL gl) {
	    // vertices para las 6 caras
	    poligono(gl, 0, 3, 2, 1);
	    poligono(gl, 2, 3, 7, 6);
	    poligono(gl, 0, 4, 7, 3);
	    poligono(gl, 1, 2, 6, 5);
	    poligono(gl, 4, 5, 6, 7);
	    poligono(gl, 0, 1, 5, 4);
	}
}
