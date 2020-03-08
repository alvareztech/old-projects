package pruebas;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLJPanel;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;


import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;

/**
 * This program demonstrates when to issue lighting and transformation commands
 * to render a model with a light which is moved by a modeling transformation
 * (rotate or translate). The light position is reset after the modeling
 * transformation is called. The eye position does not change. <br>
 * <br>
 * A sphere is drawn using a grey material characteristic. A single light source
 * illuminates the object. <br>
 * <br>
 * Interaction: pressing the left or middle mouse button alters the modeling
 * transformation (x rotation) by 30 degrees. The scene is then redrawn with the
 * light in a new position.
 * 
 * @author Kiet Le (Java port)
 */
public class Movelight//
        extends glskeleton//
        implements GLEventListener//
        , KeyListener//
        , MouseListener//
// , MouseMotionListener//
// , MouseWheelListener//
{
    private GLU glu;
    private GLUT glut;
 
    private static int spin = 0;

    //
    public Movelight() {
    }

    public static void main(String[] args) {
        GLCapabilities caps = new GLCapabilities();
        GLJPanel canvas = new GLJPanel(caps);
        Movelight demo = new Movelight();
        demo.setCanvas(canvas);
        canvas.addGLEventListener(demo);
        canvas.addKeyListener(demo);
        canvas.addMouseListener(demo);
        //
//        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Movelight");
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        canvas.requestFocusInWindow();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        glu = new GLU();
        glut = new GLUT();
        //
        gl.glEnable(GL.GL_LIGHTING);
        gl.glEnable(GL.GL_LIGHT0);
        gl.glDepthFunc(GL.GL_LESS);
        gl.glEnable(GL.GL_DEPTH_TEST);
    }

    /*
     * Here is where the light position is reset after the modeling
     * transformation (glRotated) is called. This places the light at a new
     * position in world coordinates. The cube represents the position of the
     * light.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        //
        float position[] = { 0.0f, 0.0f, 1.5f, 1.0f };

        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, -5.0f);

        gl.glPushMatrix();
        gl.glRotated((double) spin, 1.0, 0.0, 0.0);
        gl.glRotated(0.0, 1.0, 0.0, 0.0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, position, 0);

        gl.glTranslated(0.0, 0.0, 1.5);
        gl.glDisable(GL.GL_LIGHTING);
        gl.glColor3f(0.0f, 1.0f, 1.0f);
        glut.glutWireCube(0.1f);
        gl.glEnable(GL.GL_LIGHTING);
        gl.glPopMatrix();

        glut.glutSolidTorus(0.275f, 0.85f, 20, 20);
        gl.glPopMatrix();
        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL gl = drawable.getGL();
        //
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(40.0, (float) w / (float) h, 1.0, 20.0);
        gl.glMatrixMode(GL.GL_MODELVIEW);
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
            boolean deviceChanged) {
    }

    private void move_light() {
        spin = (spin + 30) % 360;
    }

    public void keyTyped(KeyEvent key) {
    }

    public void keyPressed(KeyEvent key) {
        char ch = key.getKeyChar();
        switch (ch) {
        case KeyEvent.VK_ESCAPE:
            super.runExit();
            break;

        default:
            break;
        }
    }

    public void keyReleased(KeyEvent key) {
    }

    public void mouseClicked(MouseEvent mouse) {
    }

    public void mousePressed(MouseEvent mouse) {
        if (mouse.getButton() == MouseEvent.BUTTON1) //
            move_light();
        super.refresh();
    }

    public void mouseReleased(MouseEvent mouse) {
    }

    public void mouseEntered(MouseEvent mouse) {
    }

    public void mouseExited(MouseEvent mouse) {
    }

}
