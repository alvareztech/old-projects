package pruebas;
/*
 * collisions4.c
 *
 * Draw two line segments, and decide if they intersect
 * 
 * Modify the program, by adding code to the checkCollisions() call,
 * to decide if the line segment intersect
 *
 * Jeff Parker         July 2009
 *
 * Ported to Java  September 2009 Jeff de Beer
 *
 * Usage:
 *   Click four times to create two line segments
 *   Fill in the collision detect routine below
 *   Press the escape key to exit.
 */
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static javax.media.opengl.GL.*;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

import com.sun.opengl.util.Animator;


public class Collisions4 implements GLEventListener, MouseListener {
    class Point {
        int x;
        int y;
    
        public Point() {}
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class Line {
        Point p1, p2;
        
        public Line(){}
        
        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
        }
        
        public Line(int x1, int y1, int x2, int y2) {
            this(new Point(x1, y1), new Point(x2, y2));
        }
    }
    
    /* Has the user made a selection yet? */
    int numPoints = 0; 

    /* Keep reference to canvas to simulate glut.glutPostRedisplay() */
    GLCanvas canvas;
    GL gl;
    GLU glu;

    Line l1 = new Line(0,0, 0,0);
    Line l2 = new Line(0,0, 0,0);

    /* window size */
    int height;
    int width;

    /**
     * Check Collision - do the circles intersect?
     * 
     * Implement this method.
     */
    boolean checkCollision(Line l1, Line l2) {
        System.out.printf("checkCollision was called - place your logic here\n");

        /* Need to return something in order to compile */
        return false;
    }

    void check(Line l1, Line l2)
    {
        if (checkCollision(l1, l2))
            System.out.printf("Ouch!\n");
        else
            System.out.printf("Missed again!\n");
    }
    
    /**
     *  Paint a Line.  Assume that the caller set a color
     */
    void drawLine(Line l) {
        /* Draw Line */
        gl.glBegin( GL_LINE_STRIP );
        {
            gl.glVertex2i(l.p1.x, l.p1.y);
            gl.glVertex2i(l.p2.x, l.p2.y);
        }
        gl.glEnd();
    }

    
    public void display(GLAutoDrawable drawable) {
        gl.glClear(GL_COLOR_BUFFER_BIT);

        /* No red or green: 100% blue */
        gl.glColor3ub((byte)0, (byte)0, (byte)0xFF);

        if (numPoints > 1)
            drawLine(l1);                 /* Draw line */

        /* 100% red */
        gl.glColor3ub((byte)0xFF, (byte)0, (byte)0);       
        if (numPoints > 3)
            drawLine(l2);                 /* Draw line */

        gl.glFlush();        
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged,
            boolean deviceChanged) {
    }

    /**
     * Perform startup
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        this.gl = gl;
        this.glu = new GLU();

        gl.glEnable(GL_RGB);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        System.out.printf("Click four times\n\n");

    }

    /**
     * What should we do when the user resizes the window?
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        final GLU glu = new GLU();

        /* We need positive height and width */
        this.height = (h > 1) ? h : 2;
        this.width = (w > 1) ? w : 2;

        gl.glMatrixMode(GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0.0, w, 0.0, h);

        gl.glMatrixMode(GL_MODELVIEW);
        gl.glLoadIdentity();
        gl.glViewport(0, 0, w, h);
    }

    /* MouseListener methods */
    public void mouseClicked(MouseEvent e) {/* Empty Impl */}
    public void mouseEntered(MouseEvent e) {/* Empty Impl */}
    public void mouseExited(MouseEvent e) {/* Empty Impl */}
    public void mouseReleased(MouseEvent e) {/* Empty Impl */}

    public void mousePressed(MouseEvent e) {

        int xPos = e.getX();
        /* Flip, as y is reversed */
        int yPos = height - e.getY();

        System.out.printf("\nClicked on (x, y) = (%d, %d)\n", xPos, yPos);

        switch (numPoints % 4) 
        {
            case 0:
                l1.p1.x = xPos;
                l1.p1.y = yPos;
                break;

            case 1:
                l1.p2.x = xPos;
                l1.p2.y = yPos;
                break;

            case 2:
                l2.p1.x = xPos;
                l2.p1.y = yPos;
                break;

            case 3:
                l2.p2.x = xPos;
                l2.p2.y = yPos;
                break;
        }
        numPoints++;
        if (numPoints == 5) numPoints = 1;

        /* Something has changed: we should redisplay */
        canvas.repaint();

        if (numPoints > 3)
        {
            /* Call a routine to decide if the two cicles intersect */
            check(l1, l2);
        }    
    }


    public Collisions4(GLCanvas canvas) {
        this.canvas = canvas;
    }

    public static void main(String[] args) {

        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setDoubleBuffered(false);

        Frame frame = new Frame("Collisions4");
        GLCanvas canvas = new GLCanvas(capabilities);

        Collisions4 program = new Collisions4(canvas);

        canvas.addGLEventListener(program);
        frame.add(canvas);
        frame.setSize(500, 500);
        frame.setLocation(100, 100);

        final Animator animator = new Animator(canvas);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                animator.stop();
                System.exit(0);
            }
        });

        canvas.addKeyListener(new KeyListener() {
            /* Take input from the keyboard */
            public void keyTyped(KeyEvent e) {/* Empty Impl */}
            public void keyReleased(KeyEvent e) {/* Empty Impl */}
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_ESCAPE:
                    animator.stop();
                    System.exit(0);
                }
            }
        });
        canvas.addMouseListener(program);

        frame.setVisible(true);
        animator.start();
    }
}
