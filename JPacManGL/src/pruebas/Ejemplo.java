package pruebas;

import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.swing.JFrame;

/**
 * Clase Ejemplo
 * @author Daniel Alvarez (a3dany)
 */
public class Ejemplo implements GLEventListener {
    
    public static void main(String[] args) {
        JFrame ventana = new JFrame();
        ventana.setSize(200, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GLCanvas grafico = new GLCanvas();
        grafico.addGLEventListener(new Ejemplo());
        ventana.add(grafico);
        ventana.setVisible(true);
    }

    public void init(GLAutoDrawable drawable) {
        System.out.println("INIT");
    }

    public void display(GLAutoDrawable drawable) {
        System.out.println("DISPLAY");
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        System.out.println("RESHAPE");
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        System.out.println("DISPLAY CHANGED");
    }
}
