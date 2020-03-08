package jogl;

import javax.media.opengl.GL;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.glu.GLU;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.media.opengl.GLCanvas;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.awt.Color;

/**
 * Clase Principal
 * @author Daniel Alvarez (a3dany)
 */
public class Main extends JPanel implements GLEventListener {

    public void drawSquare(GLAutoDrawable gLDrawable, float x1, float y1, float lado) {
        final GL gl = gLDrawable.getGL();
        gl.glBegin(GL.GL_QUADS);
        gl.glVertex3f(x1, y1, 0);
        gl.glVertex3f(x1, y1 + lado, 0);
        gl.glVertex3f(x1 + lado, y1 + lado, 0);
        gl.glVertex3f(x1 + lado, y1, 0);
        gl.glEnd();
    }

    public void display(GLAutoDrawable gLDrawable) {
        final GL gl = gLDrawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glColor3f(0, 128 * 1 / 255, 1);
        gl.glLoadIdentity();
        this.drawSquare(gLDrawable, -1, -1, 1 / 2.0f);
        gl.glFlush();
    }

    public void displayChanged(GLAutoDrawable gLDrawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void init(GLAutoDrawable gLDrawable) {
        final GL gl = gLDrawable.getGL();
        gl.glClearColor(1, 1, 1, 0);
    }

    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
    }

    public void reshape(GLAutoDrawable gLDrawable, int width, int height) {
        final GL gl = gLDrawable.getGL();
        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-1, 1, -1, 1, -1, 1);
        gl.glMatrixMode(GL.GL_MODELVIEW);
    }

    public static void main(String[] a3d) {
        new PanelRender().setVisible(true);
    }
}
