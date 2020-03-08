package figurasgeometricasjogl;

import java.awt.BorderLayout;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;
import javax.swing.JFrame;

/**
 * Clase Ventana
 * @author Daniel Alvarez (a3dany)
 */
public class Ventana extends JFrame implements GLEventListener {

    GLU glu = new GLU();
    float incremento = -2.0f;
    GLUquadric q;

    public Ventana() {
        super("Figuras Geometricas JOGL");
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void inicializarComponentes() {
        
    }

    public void init(GLAutoDrawable glad) {
        GL gl = glad.getGL();
        gl.glClearColor(0, 0, 0, 0);
        q = glu.gluNewQuadric();
        gl.setSwapInterval(1);
    }

    public void display(GLAutoDrawable glad) {
        GL gl = glad.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
        glu.gluLookAt(0, 0, 10, 0, 0, 0, 0, 1, 0);
        auto(gl);
    }

    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        GL gl = glad.getGL();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(15, (float) i2 / (float) i3, 5, 15);
    }

    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public void auto(GL gl) {
        // Carroceria
        gl.glColor3f(1, 0, 0);
        gl.glTranslatef(incremento, 0, 0);
        gl.glBegin(GL.GL_POLYGON);
        gl.glVertex2f(0.15f, 0.1f);
        gl.glVertex2f(0.1f, 0.2f);
        gl.glVertex2f(-0.1f, 0.2f);
        gl.glVertex2f(-0.15f, 0.1f);
        gl.glVertex2f(-0.25f, 0.1f);
        gl.glVertex2f(-0.25f, 0);
        gl.glVertex2f(0.25f, 0);
        gl.glVertex2f(0.25f, 0.1f);
        gl.glEnd();
        // etc...
    }
}
