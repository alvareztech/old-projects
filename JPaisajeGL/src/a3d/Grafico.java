package a3d;

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;

/**
 * Clase Grafico
 * @author Daniel Alvarez (a3dany)
 */
public class Grafico extends GLCanvas implements GLEventListener {

    private boolean llover;
    private boolean sol;
    private float llu;
    private int anguloX;
    private int anguloY;
    private FPSAnimator animador;
    private Teclado eventosTeclado;

    public Grafico(GLCapabilities capacidad) {

        super(capacidad);
        llover = false;
        llu = 4;
        anguloX = 0;
        anguloY = 0;
        animador = new FPSAnimator(this, 60);
        addGLEventListener(this);
        eventosTeclado = new Teclado(this);
        animador.start();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0, 0, 0, 0);
        gl.glEnable(GL.GL_DEPTH_TEST);  // ocultamiento de superficies
        drawable.addKeyListener(eventosTeclado);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glRotatef(anguloX, 0, 1, 0);
        gl.glRotatef(anguloY, 1, 0, 0);

        dibujarBase(gl);
        dibujarParedes(gl);
        dibujarTecho(gl);
        dibujarPuertas(gl);

        dibujarArbol(gl);

        if (llover) {
            dibujaLluvia(gl);
        }
        if (sol) {
            dibujarSol(gl);
        }

        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(gl.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-6, 5, -2, 5, -5, 5);
        gl.glMatrixMode(gl.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        System.out.println("displayChanged");
    }

    public void dibujarCubo(GL gl) {
        gl.glColor3f(1, 0, 0);    // rojo
        // frontal
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();

        gl.glColor3f(0, 1, 0);    // verde
        // trasera
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glEnd();

        gl.glColor3f(0, 0, 1);    // azul
        // izquierda
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();

        gl.glColor3f(1, 1, 0);    // rojo, verde, azul
        // derecha
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(1, 1, 1);
        gl.glEnd();

        gl.glColor3f(1, 0, 1);    // rojo, verde, azul
        // arriba
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glEnd();

        gl.glColor3f(0, 1, 1);    // rojo, verde, azul
        // abajo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(-1, -1, -1);
        gl.glEnd();
    }

    public void dibujarParedes(GL gl) {
        gl.glColor3f(1, 0.5f, 0);    // rojo
        // frontal
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();

        // trasera
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, -2);
        gl.glVertex3f(1, -1, -2);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(-1, 1, -2);
        gl.glEnd();
        gl.glColor3f(1, 0.8f, 0);    // rojo
        // izquierda
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(-1, -1, -2);
        gl.glVertex3f(-1, 1, -2);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();

        // derecha
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -2);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(1, 1, 1);
        gl.glEnd();

        // arriba
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(-1, 1, -2);
        gl.glEnd();

        // abajo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -2);
        gl.glVertex3f(-1, -1, -2);
        gl.glEnd();
    }

    public void moverAdelante() {
        anguloY += 2;
    }

    public void moverAtras() {
        anguloY -= 2;
    }

    public void moverIzquierda() {
        anguloX += 2;
    }

    public void moverDerecha() {
        anguloX -= 2;
    }

    private void dibujarTecho(GL gl) {
        gl.glColor3f(1, 0, 0);    // rojo
        // frontal
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(0, 2, 1);
        gl.glEnd();
        // trasera
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(-1, 1, -2);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(0, 2, -2);
        gl.glEnd();
        // izquierda
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, 1, -2);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(0, 2, 1);
        gl.glVertex3f(0, 2, -2);
        gl.glEnd();
        // derecha
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(0, 2, 1);
        gl.glVertex3f(0, 2, -2);
        gl.glEnd();
    }

    private void dibujarArbol(GL gl) {
        gl.glColor3f(1, 1, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-3.1F, -1, 1);
        gl.glVertex3f(-2.9f, -1, 1);
        gl.glVertex3f(-2.9f, 1, 1);
        gl.glVertex3f(-3.1f, 1, 1);
        gl.glEnd();
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-3.1F, -1, -2);
        gl.glVertex3f(-2.9f, -1, -2);
        gl.glVertex3f(-2.9f, 1, -2);
        gl.glVertex3f(-3.1f, 1, -2);
        gl.glEnd();
        GLUT glut = new GLUT();
        gl.glColor3f(0, 1, 0);
        gl.glTranslatef(-3, 1.5f, 1);
        glut.glutSolidSphere(1, 8, 8);
        gl.glTranslatef(0, 0.0f, -3);
        glut.glutSolidSphere(1, 8, 8);

    }

    private void dibujarPuertas(GL gl) {
        gl.glColor3f(0.9f, 0.1f, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-0.5f, -1, 1.01f);
        gl.glVertex3f(0.5f, -1, 1.01f);
        gl.glVertex3f(0.5f, 0.5f, 1.01f);
        gl.glVertex3f(-0.5f, 0.5f, 1.01f);
        gl.glEnd();
    }

    private void dibujarSol(GL gl) {
        gl.glLoadIdentity();
        GLUT glut = new GLUT();
        gl.glColor3f(1, 1, 0);
        gl.glTranslatef(0, 5, 0);
        glut.glutWireSphere(1, 20, 20);
    }

    void llover() {
        llover = true;
        sol = false;
    }

    private void dibujaLluvia(GL gl) {
        gl.glColor3f(0, 0, 1);
        gl.glBegin(gl.GL_LINES);

        for (int j = -20; j < 20; j++) {
            for (int i = -10; i < 10; i++) {
                gl.glVertex3f(j, llu + 0.2f, 1 * i);
                gl.glVertex3f(j - 0.1f, llu + 0.4f, 1 * i);
                gl.glVertex3f(j + 0.5f, llu + 1.0f, 1 * i);
                gl.glVertex3f(j + 0.4f, llu + 1.2f, 1 * i);
                gl.glVertex3f(j, llu + 1.8f, 1 * i);
                gl.glVertex3f(j - 0.1f, llu + 2.0f, 1 * i);
            }
        }
        llu -= 0.4f;
        if (llu < -10) {
            llu = 5;
        }
        gl.glEnd();
    }

    void solear() {
        sol = true;
        llover = false;
    }

    private void dibujarBase(GL gl) {
        gl.glColor3f(0, 1, 0.1f);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-10, -1.01f, 10);
        gl.glVertex3f(10, -1.01f, 10);
        gl.glVertex3f(10, -1.01f, -10);
        gl.glVertex3f(-10, -1.01f, -10);
        gl.glEnd();
    }
}
