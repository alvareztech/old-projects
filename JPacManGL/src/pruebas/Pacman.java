package pruebas;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.FPSAnimator;

public class Pacman implements GLEventListener {

    final int MAXGRADO = 360;
    private float tx = -10;
    boolean sw = true;

    public static void main(String[] args) {

        // Primero se crea el objeto JFrame
        JFrame miMarco = new JFrame("Ejemplo de Pacman");

        // Nos aseguramos que al cerrar la ventana el programa finalice.
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crea el objeto GLCapabilities 
        GLCapabilities miCapacidad = new GLCapabilities();

        // Solicita doble buffer en el modo de despliegue
        miCapacidad.setDoubleBuffered(true);

        // Se crea el objeto GLCanvas
        GLCanvas miLienzo = new GLCanvas(miCapacidad);

        // Indicamos que miCanvas detecte los eventos de openGL de la Clase
        miLienzo.addGLEventListener(new Pacman());

        // Agrega animación a miLienzo - 60 cuadros por segundo
        FPSAnimator animador = new FPSAnimator(miLienzo, 10);

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
        GL gl = drawable.getGL();	// Inicializa la variable GL
        gl.glClearColor(0, 0, 0, 0);	// Color del buffer (rojo,verde,azul,alfa)
        // alfa [0..1]: 1 totalmente opaco, 0 totalmente trasparente.
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL(); // inicializa la variable GL
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);	// borra el buffer de la ventana
        gl.glMatrixMode(GL.GL_MODELVIEW); // utiliza matriz de vista del modelo
        gl.glLoadIdentity(); // inicializa matriz de vista de modelo

        gl.glTranslated(tx, 0, 0);
        if (sw) {
            dibujaArco(gl);
            sw = false;
        } else {
            dibujaOvalo(gl);
            sw = true;
        }

        gl.glFlush();

        tx = tx + 0.10f;
        if (tx > 10) {
            tx = -10f;
        }
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL gl = drawable.getGL(); // Inicializa la variable GL
        GLU glu = new GLU(); // Inicializa la variable GL

        gl.glViewport(0, 0, w, h); // define tamaño
        gl.glMatrixMode(GL.GL_PROJECTION); // utiliza matriz de proyeccion
        gl.glLoadIdentity(); // inicializa matriz de proyeccíon

        glu.gluOrtho2D(-10.0f, 10.0f, -10.0f, 10.0f); // proyección en paralelo
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
    }

    public void dibujaArco(GL gl) {
        gl.glRotatef(-90, 0, 0, 1);
        gl.glColor3f(1, 0, 0); // Selecciona el color rojo
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2f(0, 0);
        for (int contador = 30; contador <= 305; contador++) {
            float theta = (float) (contador * 2 * Math.PI) / MAXGRADO;
            gl.glVertex2f((float) Math.sin(theta), (float) Math.cos(theta));
        }
        gl.glEnd();
    }

    public void dibujaOvalo(GL gl) {
        
        gl.glColor3f(1, 0, 0); // Selecciona el color rojo
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2f(0, 0);
        for (int contador = 0; contador <= 360; contador++) {
            float theta = (float) (contador * 2 * Math.PI) / MAXGRADO;
            gl.glVertex2f((float) Math.sin(theta), (float) Math.cos(theta));
        }
        gl.glEnd();
    }
}
