package a3d;

import java.awt.event.KeyEvent;
import javax.media.opengl.*;
import javax.swing.JFrame;

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;
import java.awt.event.KeyListener;
import javax.media.opengl.glu.GLU;

/**
 * @author Daniel Alvarez
 */
public class Automovil implements GLEventListener, KeyListener {

    private float anguloCuboX = 0.0f;
    private float anguloCuboY = 0.0f;
    private float anguloCuboZ = 0.0f;
    private float xxx = 0;
    private float zzz = 0;

    public static void main(String[] args) {
        JFrame miMarco = new JFrame("JAutomovilGL | Daniel Alvarez");
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GLCapabilities miCapacidad = new GLCapabilities();
        miCapacidad.setDoubleBuffered(true);
        GLCanvas miCanvas = new GLCanvas(miCapacidad);
        miCanvas.addGLEventListener(new Automovil());
        FPSAnimator animador = new FPSAnimator(miCanvas, 60);   // Agrega animación a miCanvas - 60 cuadros por segundo
        miMarco.add(miCanvas);
        miMarco.setSize(600, 500);
        miMarco.setLocationRelativeTo(null);
        miMarco.setVisible(true);
        animador.start();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0.8f, 1, 1, 0);
        gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
        drawable.addKeyListener(this);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -5);
        gl.glTranslatef(xxx, 0, zzz);
        gl.glRotatef(anguloCuboX, 1, 0, 0);
        gl.glRotatef(anguloCuboY, 0, 1, 0);
        gl.glRotatef(anguloCuboZ, 0, 0, 1);

        //dibujarCubo(gl);
        dibujarLetrero(gl);
        gl.glPushMatrix();
        gl.glTranslatef(2, 0, -8);
        dibujarLetrero(gl);
        gl.glPopMatrix();
        gl.glPushMatrix();
        gl.glTranslatef(2, 0, -50);
        dibujarLetrero(gl);
        gl.glPopMatrix();

        dibujarCasa(gl);
        dibujarPista(gl);
        dibujarSubCarretera(gl);
        dibujarCarretera(gl);
        dibujarLineas(gl);
        dibujarArbol(gl);

        gl.glFlush();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        drawable.swapBuffers();
//        anguloCuboX += 0.1f;
//        anguloCuboY += 0.1f;
//        anguloEsfera += 0.2f;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        gl.glViewport(x, y, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU glu = new GLU();
        float aspecto = (float) width / (float) height;
        glu.gluPerspective(90, aspecto, 1, 200);
        //glu.gluLookAt(0, 0, 0, 0, 0, 0, 0, 0, 0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'x') {
            anguloCuboX++;
        }
        if (e.getKeyChar() == 'y') {
            anguloCuboY++;
        }
        if (e.getKeyChar() == 'z') {
            anguloCuboZ++;
        }
        if (e.getKeyCode() == 38) { // arriba
            zzz++;
        }
        if (e.getKeyCode() == 40) { // abajo
            zzz--;
        }
        if (e.getKeyCode() == 37) { // izquierda
            //xxx++;
            anguloCuboY--;
        }
        if (e.getKeyCode() == 39) { // derecha
            //xxx--;
            anguloCuboY++;

        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void dibujarCubo(GL gl) {
        // frontal
        gl.glColor3f(1, 0, 0);    // rojo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();
        // trasera
        gl.glColor3f(0, 1, 0);    // verde
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glEnd();
        // izquierda
        gl.glColor3f(0, 0, 1);    // azul
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();
        // derecha
        gl.glColor3f(1, 1, 0);    // amarillo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(1, 1, 1);
        gl.glEnd();
        // arriba
        gl.glColor3f(1, 0, 1);    // rosado
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glEnd();
        // abajo
        gl.glColor3f(0, 1, 1);    // celeste
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(-1, -1, -1);
        gl.glEnd();
    }

    private void dibujarPista(GL gl) {
        int t = 50;
        gl.glColor3f(0.1f, 0.7f, 0);    // verde oscuro
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-t, -1, t);
        gl.glVertex3f(t, -1, t);
        gl.glVertex3f(t, -1, -t);
        gl.glVertex3f(-t, -1, -t);
        gl.glEnd();
    }

    private void dibujarArbol(GL gl) {
        gl.glColor3f(1, 1, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-3.1f, -1, 1);
        gl.glVertex3f(-2.9f, -1, 1);
        gl.glVertex3f(-2.9f, 1, 1);
        gl.glVertex3f(-3.1f, 1, 1);
        gl.glEnd();
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-3.1f, -1, -4);
        gl.glVertex3f(-2.9f, -1, -4);
        gl.glVertex3f(-2.9f, 1, -4);
        gl.glVertex3f(-3.1f, 1, -4);
        gl.glEnd();
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-3.1f, -1, -8);
        gl.glVertex3f(-2.9f, -1, -8);
        gl.glVertex3f(-2.9f, 1, -8);
        gl.glVertex3f(-3.1f, 1, -8);
        gl.glEnd();
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-3.1f, -1, -12);
        gl.glVertex3f(-2.9f, -1, -12);
        gl.glVertex3f(-2.9f, 1, -12);
        gl.glVertex3f(-3.1f, 1, -12);
        gl.glEnd();
        /////////////////////////////////////////
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(3.1f, -1, -16);
        gl.glVertex3f(2.9f, -1, -16);
        gl.glVertex3f(2.9f, 1, -16);
        gl.glVertex3f(3.1f, 1, -16);
        gl.glEnd();
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(8.1f, -1, -20);
        gl.glVertex3f(7.9f, -1, -20);
        gl.glVertex3f(7.9f, 1, -20);
        gl.glVertex3f(8.1f, 1, -20);
        gl.glEnd();
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(8.1f, -1, -24);
        gl.glVertex3f(7.9f, -1, -24);
        gl.glVertex3f(7.9f, 1, -24);
        gl.glVertex3f(8.1f, 1, -24);
        gl.glEnd();
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-8.1f, -1, -40);
        gl.glVertex3f(-7.9f, -1, -40);
        gl.glVertex3f(-7.9f, 1, -40);
        gl.glVertex3f(-8.1f, 1, -40);
        gl.glEnd();
        GLUT glut = new GLUT();
        gl.glColor3f(0, 1, 0);
        gl.glTranslatef(-3, 1.5f, 1);
        glut.glutSolidSphere(1, 8, 8);
        gl.glTranslatef(0, 0.0f, -5);
        gl.glColor3f(0.1f, 0.7f, 0);
        glut.glutSolidSphere(1.5f, 8, 8);
        gl.glTranslatef(0, 0.0f, -4);
        gl.glColor3f(0, 1, 0);
        glut.glutSolidSphere(1, 8, 8);
        gl.glTranslatef(0, 0.0f, -4);
        gl.glColor3f(0.1f, 0.7f, 0);
        glut.glutSolidSphere(1.5f, 8, 8);
        gl.glColor3f(0, 1, 0);
        gl.glTranslatef(6, 0.0f, -4);
        glut.glutSolidSphere(1, 8, 8);
        gl.glColor3f(0.1f, 0.7f, 0);
        gl.glTranslatef(5, 0.0f, -4);
        glut.glutSolidSphere(1, 8, 8);
        gl.glColor3f(0, 1, 0);
        gl.glTranslatef(0, 0.0f, -4);
        glut.glutSolidSphere(2, 8, 8);
        gl.glColor3f(0, 1, 0);
        gl.glTranslatef(-16, 0.0f, -16);
        glut.glutSolidSphere(2, 8, 8);
    }

    private void dibujarCarretera(GL gl) {
        int t = 50;
        gl.glColor3f(0.5f, 0.5f, 0.5f);    // plomo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -0.99f, t);
        gl.glVertex3f(1, -0.99f, t);
        gl.glVertex3f(1, -0.99f, -t);
        gl.glVertex3f(-1, -0.99f, -t);
        gl.glEnd();
    }

    private void dibujarSubCarretera(GL gl) {
        int t = 50;
        gl.glColor3f(0.6f, 0.6f, 0.6f);    // celeste
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1.2f, -0.999f, t);
        gl.glVertex3f(1.2f, -0.999f, t);
        gl.glVertex3f(1.2f, -0.999f, -t);
        gl.glVertex3f(-1.2f, -0.999f, -t);
        gl.glEnd();
    }

    private void dibujarLineas(GL gl) {
        int t = 50;
        gl.glColor3f(1, 1, 1);    // blanco
        for (int i = -50; i < 50; i += 5) {
            gl.glBegin(gl.GL_QUADS);
            gl.glVertex3f(-0.07f, -0.98f, i + 2);
            gl.glVertex3f(0.07f, -0.98f, i + 2);
            gl.glVertex3f(0.07f, -0.98f, i);
            gl.glVertex3f(-0.07f, -0.98f, i);
            gl.glEnd();
        }
    }

    private void dibujarLetrero(GL gl) {
        gl.glPushMatrix();
        float x = 0.5f;
        gl.glColor3f(1, 1, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(3.1f, -1, 2);
        gl.glVertex3f(2.9f, -1, 2);
        gl.glVertex3f(2.9f, 1, 2);
        gl.glVertex3f(3.1f, 1, 2);
        gl.glEnd();
        gl.glColor3f(1, 0, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(3.5f, 1, 2);
        gl.glVertex3f(2.5f, 1, 2);
        gl.glVertex3f(2.5f, 2, 2);
        gl.glVertex3f(3.5f, 2, 2);
        gl.glEnd();
        gl.glColor3f(1, 1, 1);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(3.4f, 1.1f, 2.01f);
        gl.glVertex3f(2.6f, 1.1f, 2.01f);
        gl.glVertex3f(2.6f, 1.9f, 2.01f);
        gl.glVertex3f(3.4f, 1.9f, 2.01f);
        gl.glEnd();
        gl.glPopMatrix();
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

    private void dibujarPuertas(GL gl) {
        gl.glColor3f(0.9f, 0.1f, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-0.5f, -1, 1.01f);
        gl.glVertex3f(0.5f, -1, 1.01f);
        gl.glVertex3f(0.5f, 0.5f, 1.01f);
        gl.glVertex3f(-0.5f, 0.5f, 1.01f);
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

    private void dibujarCasa(GL gl) {
        gl.glPushMatrix();
        gl.glTranslatef(7, 0, -5);
        gl.glRotatef(-60, 0, 1, 0);
        dibujarParedes(gl);
        dibujarTecho(gl);
        dibujarPuertas(gl);
        gl.glPopMatrix();
    }
}
