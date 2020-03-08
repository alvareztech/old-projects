package pruebas;
/*
 * collision2.c
 *
 * Draw three lines in blue, and place a red circle around a 
 * point when the user clicks the mouse.
 * 
 * Modify the program, by adding code to the checkCollisions() call,
 * to decide if the circle intersects a given line
 *
 * Jeff Parker         July 2009
 *
 * Ported to Java  September 2009 Jeff de Beer
 *
 * Usage:
 *   Click twice to create the third line
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


public class Collisions2 implements GLEventListener, MouseListener {
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

    /* Approximate a circle with NUM_CHORDS line segments */
    static final int NUM_CHORDS = 72; 
    
    /* Has the user made a selection yet? */
    int numPoints = 0; 

    /* Keep reference to canvas to simulate glut.glutPostRedisplay() */
    GLCanvas canvas;
    GL gl;
    GLU glu;

    Line l1 = new Line(0,100, 500,100);
    Line l2 = new Line(50,0, 50,500);
    Line l3 = new Line(0,0, 0,0);
    
    Circle cursor = new Circle(new Point(0, 0), 25);

    /* window size */
    int height;
    int width;

    /**
     * Check Collision - do the circles intersect?
     * 
     * Implement this method.
     */
    boolean checkCollision(Line l, Circle c2) {
        System.out.printf("checkCollision was called - place your logic here\n");

        /* Need to return something in order to compile */
        return false;
    }

    void check(int pos, Line l, Circle c)
    {
        System.out.printf("Check line l%d:", pos);
        if (checkCollision(l, c))
            System.out.printf("Ouch!\n");
        else
            System.out.printf("Missed again!\n");
    }
    void drawCircle(Circle c) {
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
        gl.glColor3ub((byte) 0, (byte) 0, (byte) 0xFF);
        drawLine(l1);
        drawLine(l2);
        
        if (this.numPoints > 1) 
        {
            drawLine(l3);
            
            /* Should we draw a ball? */
            if(this.numPoints > 2) {
                /* All red, no green or blue */
                gl.glColor3ub((byte) 0xFF, (byte) 0, (byte) 0);
                /* Draw the circle around the cursor */
                drawCircle(cursor); 
            }
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
        this.gl = gl;
        this.glu = new GLU();

        gl.glEnable(GL_RGB);
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
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
            int yPos = height - e.getY();        /* Flip, as y is reversed */

            System.out.printf("\nClicked on (x, y) = (%d, %d)\n", xPos, yPos);

            switch (numPoints) {
                case 0:
                    l3.p1.x = xPos;
                    l3.p1.y = yPos;
                    break;

                case 1:
                    l3.p2.x = xPos;
                    l3.p2.y = yPos;
                    break;

                case 2:
                case 3:
                    cursor.center.x = xPos;
                    cursor.center.y = yPos;
                    break;

                default:
                    System.out.printf("\nShould never reach here: numPoints = %d\n", numPoints);
                    break;
            }
            numPoints++;

            /* Something has changed: we should redisplay */
            canvas.repaint();

            if (numPoints > 2)
            {
                /* Call a routine to decide if the two cicles intersect */
                check(1, l1, cursor);
                check(2, l2, cursor);
                check(3, l3, cursor);
                numPoints = 3;
            }
      }


    public Collisions2(GLCanvas canvas) {
        this.canvas = canvas;
    }

    public static void main(String[] args) {

        GLCapabilities capabilities = new GLCapabilities();
        capabilities.setDoubleBuffered(false);

        Frame frame = new Frame("Collisions2");
        GLCanvas canvas = new GLCanvas(capabilities);

        Collisions2 program = new Collisions2(canvas);

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
