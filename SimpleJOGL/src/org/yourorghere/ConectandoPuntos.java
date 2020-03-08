package org.yourorghere;

/**
 * ConectandoPuntos.java		1.0 22/02/2011
 */
import java.awt.event.*;
import javax.swing.JFrame;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;

/**
 * Este programa dibuja lineas conectadas, ubicando los vertices(puntos) con el ratón.
 * 
 * Para utilizar: 
 * 		Click izquierdo para ubicar un punto. 
 * 			Número máximo de puntos permitidos 64. 
 * 		Presione "i" para elim inar el primer punto. 
 * 		Presione "f" para eliminar el último punto.
 * 		Presione escape para salir.
 * 
 * @author Jhonny Felipez
 * @version 1.0 22/02/2011
 */
public class ConectandoPuntos extends GLJPanel implements GLEventListener, MouseListener,
		KeyListener {
	final int maxNumPtos = 64;
	float[][] puntos = new float[maxNumPtos][2];
	int numPtos;
	
	// Tamaño de la ventana en pixeles
	int altoVentana;
	int anchoVentana;

	public static void main(String[] args) {

		// Primero se crea el objeto JFrame
		JFrame miMarco = new JFrame("Conectar puntos");

		// Para que al cerrar la ventana el programa finalice.
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Se crea el objeto GLCanvas
		GLCanvas miCanvas = new GLCanvas(new GLCapabilities());

		// Indicamos que miCanvas detecte los eventos de openGL de la Clase
		miCanvas.addGLEventListener(new ConectandoPuntos());

		// Indicamos que miCanvas detecte los eventos de ratón de la Clase
		miCanvas.addMouseListener(new ConectandoPuntos());

		// Indicamos que miCanvas detecte los eventos de teclado de la Clase
		miCanvas.addKeyListener(new ConectandoPuntos());

		// A continuacion insertamos miCanvas en miMarco
		miMarco.add(miCanvas);

		// Definimos el tamaño de la ventana.
		miMarco.setSize(400, 400);

		// Por ultimo hacemos visible el elemento de mayor nivel
		miMarco.setVisible(true);
	}

	public void init(GLAutoDrawable drawable) {
		GL gl = drawable.getGL(); // Inicializa la variable GL
		gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f); // Color de fondo (rojo,verde,azul,alfa)
		// alfa [0..1]: 1 totalmente opaco, 0 totalmente trasparente.

		gl.glPointSize(8); // Tamaño de los puntos.
		gl.glLineWidth(5); // Ancho de las lineas.

		// Las siguientes instrucciones logran que OpenGL cree puntos redondos,
		// además de puntos y lineas con antialias. (Esta implementación
		// puede reducir el tiempo de la renderizacion considerablemente.)
		gl.glEnable(GL.GL_POINT_SMOOTH);
		gl.glEnable(GL.GL_LINE_SMOOTH);
		gl.glHint(GL.GL_POINT_SMOOTH_HINT, GL.GL_NICEST); // Redondea puntos
		gl.glHint(GL.GL_LINE_SMOOTH_HINT, GL.GL_NICEST); // Agrega antialias a la línea
		gl.glEnable(GL.GL_BLEND);
		gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);

		drawable.addMouseListener(this); // Para detectar eventos del mouse.
		drawable.addKeyListener(this); // Para detectar eventos del teclado.
	}

	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL(); // inicializa la variable GL
		gl.glClear(GL.GL_COLOR_BUFFER_BIT); // borra el buffer de la ventana

		// Dibuja las lineas.
		gl.glColor3f(1.0f, 0.0f, 0.8f); // linea morada
		if (numPtos > 1) {
			gl.glBegin(GL.GL_LINE_STRIP); // inicia secuencia: lineas conectadas.
			for (int i = 0; i < numPtos; i++)
				gl.glVertex2f(puntos[i][0], puntos[i][1]); // vertice (x,y)
			gl.glEnd(); // finaliza secuencia
		}

		// Dibuja los puntos.
		gl.glColor3f(0.0f, 0.0f, 0.0f); // puntos negros
		if (numPtos > 1) {
			gl.glBegin(GL.GL_POINTS); // inicia secuencia: puntos.
			for (int i = 0; i < numPtos; i++)
				gl.glVertex2f(puntos[i][0], puntos[i][1]); // vertice (x,y)
			gl.glEnd(); // finaliza secuencia
		}

		gl.glFlush(); // asegura que se ejecuta las anteriores instrucciones
	}
	
	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL gl = drawable.getGL(); // Inicializa la variable GL
		GLU glu = new GLU(); // Inicializa la variable GLU
		anchoVentana = (w > 1) ? w : 2; // ancho de la ventana
		altoVentana = (h > 1) ? h : 2; // alto de la ventana
                System.out.println("(" + anchoVentana + ", " + altoVentana + ")");
		gl.glViewport(0, 0, w, h); // define tamaño
		gl.glMatrixMode(GL.GL_PROJECTION); // utiliza matriz de proyeccion
		gl.glLoadIdentity(); // inicializa matriz de proyeccíon

		// La vista siempre será [0,1] x [0,1].
		glu.gluOrtho2D(0.0f, 1.0f, 0.0f, 1.0f); // proyección en paralelo

		gl.glMatrixMode(GL.GL_MODELVIEW); // utiliza matriz de vista modelo
		gl.glLoadIdentity(); // inicializa matriz de vista de modelo
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {}


	public void mousePressed(MouseEvent e) {
		GLCanvas canvas = (GLCanvas) e.getComponent();
		
		// Presionando el boton izquierdo ubicamos un punto.
		if ((e.getModifiers() & InputEvent.BUTTON1_MASK) == InputEvent.BUTTON1_MASK) {
			float xPos = ((float) e.getX()) / ((float) (anchoVentana - 1));
			float yPos = ((float) e.getY()) / ((float) (altoVentana - 1));
                        System.out.println("< " + xPos + " > < " + yPos + " >");
			yPos = 1.0f - yPos; // Cambia el valor de la posicion y es desde la fila de arriba.
			adiNuevosPuntos(xPos, yPos);
			canvas.display();
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {}

	public void mouseEntered(MouseEvent arg0) {}

	public void mouseExited(MouseEvent arg0) {}

	public void mouseReleased(MouseEvent arg0) {}

	public void keyPressed(KeyEvent e) {
		switch (e.getKeyChar()) {
		case 'i':
			eliminaPrimerPunto();
			display();
			break;
		case 'f':
			eliminaUltimoPunto();
			display();
			break;
		case 27: // tecla Escape
			System.exit(0);
		}
	}

	public void keyTyped(KeyEvent e) {}
	
	public void keyReleased(KeyEvent e) {}

	public void eliminaPrimerPunto() {
		if (numPtos > 0) {
			// Elimina primer punto, recorriendo el resto a una posicion antes del vector.
			numPtos--;
			for (int i = 0; i < numPtos; i++) {
				puntos[i][0] = puntos[i + 1][0];
				puntos[i][1] = puntos[i + 1][1];
			}
		}
	}

	public void eliminaUltimoPunto() {
		numPtos = (numPtos > 0) ? numPtos - 1 : numPtos;
	}

	// Adiciona un nuevo punto al final de la lista.
	// Elimina el primer punto de la lista si hay muchos puntos.
	public void adiNuevosPuntos(float x, float y) {
		if (numPtos >= maxNumPtos) {
			eliminaUltimoPunto();
		}
		puntos[numPtos][0] = x;
		puntos[numPtos][1] = y;
		numPtos++;
	}
}
