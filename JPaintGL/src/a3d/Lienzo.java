package a3d;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;

/**
 * Clase Lienzo
 * @author Daniel Alvarez (a3dany)
 */
public class Lienzo extends GLCanvas implements GLEventListener, MouseListener, MouseMotionListener {

    private VentanaPrincipal nucleo;
    private float ancho;
    private float alto;
    private Point inicioArrastre;
    private Point finArrastre;

    public Lienzo(VentanaPrincipal nucleo, GLCapabilities capacidad) {
        super(capacidad);
        this.nucleo = nucleo;
        addGLEventListener(this);
        inicioArrastre = new Point();
        finArrastre = new Point();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0, 0, 0, 0);
        gl.glEnable(GL.GL_DEPTH_TEST);
        drawable.addMouseListener(this);
        drawable.addMouseMotionListener(this);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        float x0 = ((float) inicioArrastre.x) / ((float) (ancho - 1));
        float y0 = ((float) inicioArrastre.y) / ((float) (alto - 1));
        float x1 = ((float) finArrastre.x) / ((float) (ancho - 1));
        float y1 = ((float) finArrastre.y) / ((float) (alto - 1));
        int grosor = nucleo.getGrosorPincel();
        gl.glLineWidth(grosor);
        Color color = nucleo.getColor();
        gl.glColor3f((float) color.getRed() / (float) 255, (float) color.getGreen() / (float) 255, (float) color.getBlue() / (float) 255);
        String opcion = nucleo.getOpcion();
        if (opcion.equals("LINEA")) {
            gl.glBegin(gl.GL_LINES);
            gl.glVertex3f(x0, 1 - y0, 0);
            gl.glVertex3f(x1, 1 - y1, 0);
            gl.glEnd();
        } else {
            if (opcion.equals("RECTANGULO")) {
                gl.glBegin(gl.GL_QUADS);
                gl.glVertex3f(x0, 1 - y0, 0);
                gl.glVertex3f(x1, 1 - y0, 0);
                gl.glVertex3f(x1, 1 - y1, 0);
                gl.glVertex3f(x0, 1 - y1, 0);
                gl.glEnd();
            } else {
                if (opcion.equals("ELIPSE")) {
                    Punto punto = new Punto((float) (x0 + x1) / 2, 1-(float) (y0 + y1) / 2);
                    gl.glBegin(GL.GL_LINE_LOOP);
                    for (int i = 0; i < 40; i++) {
                        Punto puntoG = generar(punto.getX(), punto.getY(), i, (float) Math.sqrt(Math.pow(x1 - x0, 2) + Math.pow(y0 - y1, 2)));
                        gl.glVertex3f(puntoG.getX(), puntoG.getY(), 0);
                    }
                    gl.glEnd();
                }
            }

        }

        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        gl.glViewport(x, y, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0, 1, 0, 1, 0, 1);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        ancho = width;
        alto = height;
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void mouseDragged(MouseEvent e) {
        finArrastre = new Point(e.getX(), e.getY());
        display();
    }

    public void mouseMoved(MouseEvent e) {
        //System.out.println("moved");
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        inicioArrastre = new Point(e.getX(), e.getY());
    }

    public void mouseReleased(MouseEvent e) {
        finArrastre = new Point(e.getX(), e.getY());
        display();
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public static Punto generar(float centroX, float centroY, int i, float radio) {
        Punto punto = new Punto(0, 0);
        int rad = 9;
        punto.setX(centroX + (radio * (float) Math.cos(Math.toRadians(rad * i))));
        punto.setY(centroY + (radio * (float) Math.sin(Math.toRadians(rad * i))));
        return punto;
    }
}
