package pruebas;
/*
 * collision1.c
 *
 * Draw a circle and decide if it hits another circle
 * This program will draw a background circle in blue, and
 * place a red circle around a point when the user clicks the mouse.
 * 
 * Modify the program, by adding code to the checkCollisions() call,
 * to decide if the two circles intersect.
 *
 * Jeff Parker     July 2009
 * Edits           August 2009
 * 
 * Ported to Java  September 2009 Jeff de Beer
 *
 * Usage:
 *   Click to create a second circle
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

public class Collisions1 implements GLEventListener, MouseListener {

    class Point {
        int x;
        int y;
    
        public Point() {}
    
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    class Circle {
        Point center;
        int radius;
    
        public Circle() {}
    
        public Circle(Point center, int radius) {
            this.center = center;
            this.radius = radius;
        }
    }


    /* Approximate a circle with NUM_CHORDS line segments */
    static final int NUM_CHORDS = 72; 
    
    /* Has the user made a selection yet? */
    int numPoints = 0; 

    /* Keep reference to canvas to simulate glut.glutPostRedisplay() */
    GLCanvas canvas;

    Circle background = new Circle(new Point(50, 100), 25);
    Circle cursor = new Circle(new Point(0, 0), 25);

    /* window size */
    int height;
    int width;

    /**
     * Check Collision - do the circles intersect?
     * 
     * Implement this method.
     */
    boolean checkCollision(Circle c1, Circle c2) {
        System.out.printf("checkCollision was called - place your logic here\n");
        
        /* Need to return something in order to compile */
        return false;
    }

    void drawCircle(GLAutoDrawable drawable, Circle c) {
        GL gl = drawable.getGL();

        int i;

        /* Draw Center */
        gl.glBegin(GL_POINTS);
        {
            gl.glVertex2i(c.center.x, c.center.y);
        }
        gl.glEnd();

        /* Draw Circle Rim */
        gl.glBegin(GL_LINE_STRIP);
        {
            for (i = 0; i <= NUM_CHORDS; i++) {
                float theta = (float) (i * Math.PI * 2) / NUM_CHORDS;
                gl.glVertex2i((int) (c.radius * Math.sin(theta)) + c.center.x,
                        (int) (c.radius * Math.cos(theta)) + c.center.y);
            }
        }
        gl.glEnd();
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL_COLOR_BUFFER_BIT);
        /* No red or green: 100% blue */
        gl.glColor3ub((byte) 0, (byte) 0, (byte) 0xFF); 
        drawCircle(drawable, background); /* Draw background circle */

        /* Should we draw a ball? */
        /* Did the user make a selection? */
        if (this.numPoints > 0) 
        {
            /* All red, no green or blue */
            gl.glColor3ub((byte) 0xFF, (byte) 0, (byte) 0);
            /* Draw the circle around the cursor */
            drawCircle(drawable, cursor); 
        }
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
        gl.glEnable(GL_RGB);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    }

    /**
     * What should we do when the user resizes the window?
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        final GL gl = drawable.getGL();
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
        int yPos = height - e.getY();
        System.out.printf("\nClicked on (x, y) = (%d, %d)\n", xPos, yPos);

        /* Fill in the center for the cursor circle */
        /* Radius is already defined */
        cursor.center.x = xPos;
        cursor.center.y = yPos;
        numPoints = 1;
        /* Something has changed: we should redisplay */
        canvas.repaint();

        /* Call a routine to decide if the two cicles intersect */
        if (checkCollision(background, cursor))
            System.out.printf("Ouch!\n");
        else
            System.out.printf("Missed again!\n");
    }


    public Collisions1(GLCanvas canvas) {
        this.canvas = canvas;
    }

    public static void main(String[] args) {

        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setDoubleBuffered(false);

        Frame frame = new Frame("Collisions1");
        GLCanvas canvas = new GLCanvas(capabilities);

        Collisions1 program = new Collisions1(canvas);

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
