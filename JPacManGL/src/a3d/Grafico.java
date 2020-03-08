package a3d;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Clase Grafico
 * @author Daniel Alvarez (a3dany)
 */
public class Grafico extends GLCanvas implements GLEventListener {

    public Grafico() {
        addGLEventListener(this);
        System.out.println("xxxxxxxxxx");
    }

    public void dibujaCirculo(GL gl) {
        int INCREMENTO = 16;
        gl.glBegin(GL.GL_POLYGON);
        for (int i = 0; i <= INCREMENTO * 2; i++) {
            float theta = (float) (i * Math.PI) / INCREMENTO;
            gl.glVertex2f((float) Math.sin(theta), (float) Math.cos(theta));
        }
        gl.glEnd();
    }

    public void init(GLAutoDrawable drawable) {
        System.out.println("init");
        GL gl = drawable.getGL();
        gl.glClearColor(1, 1, 1, 0);
    }

    public void display(GLAutoDrawable drawable) {
        System.out.println("display");
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        
        dibujaCirculo(gl);
        
        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("reshape");
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        
        gl.glViewport(0, 0, width, height); // define tamaño
        gl.glMatrixMode(GL.GL_PROJECTION); // utiliza matriz de proyeccion
        gl.glLoadIdentity(); // inicializa matriz de proyeccíon
        
        glu.gluOrtho2D(0.0f, 100.0f, 0.0f, 100.0f);
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        System.out.println("displayChanged");
    }
}
