package pruebas;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;

/**
 * Este demo muestra la iluminacion sobre la tetera.
 * 
 * @author Jhonny Felipez
 * @version 1.0 10/06/2011
 */
public class IluminaTetera implements GLEventListener {

    static float angulo = 0;
    // Inicia definición de materiales
    final float[] mat_ambiente = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] mat_difuso = {0.8f, 0.01f, 0.01f, 1.0f};
    final float[] mat_especular = {1f, 0.001f, 0.001f, 1.0f};
    final float mat_brillo = 128.0f;

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
        miCanvas.addGLEventListener(new IluminaTetera());

        // Agrega animación a miCanvas - 60 cuadros por segundo
        FPSAnimator animador = new FPSAnimator(miCanvas, 60);

        // A continuacion insertamos miCanvas en miMarco
        miMarco.add(miCanvas);

        // Definimos el tamaño de la ventana.
        miMarco.setSize(500, 500);

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

        // Parametros de la luz 0
        float[] luzAmbiente = {0.5f, 0.5f, 0.5f, 1.0f};
        float[] luzDifusa = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] luzEspecular = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] posicion = {20.0f, 100.0f, 10.0f, 0.0f};

        // Se setean los parámetros
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, luzDifusa, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, luzEspecular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);

        gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
        gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
        gl.glEnable(GL.GL_LIGHT0); // Habilita la luz 0 que previamente se habia seteado
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        GLUT glut = new GLUT();

        // borra buffer y el z-buffer, rota el cubo y dibuja, intercambiando buffers
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        glu.gluLookAt(0.0f, 10.0f, 40.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

        // Superficie
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambiente, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_difuso, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, mat_especular, 0);
        gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, mat_brillo);

        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(8.0f);

        drawable.swapBuffers();

        gl.glFlush();

        angulo += 0.2f;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (h == 0) {
            h = 1;
        }
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        if (w > h) {
            glu.gluPerspective(45.0f, w / h, 1, 150.0f);
        } else {
            glu.gluPerspective(45.0f, w / h, 1, 150.0f);
        }

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
    }
}
