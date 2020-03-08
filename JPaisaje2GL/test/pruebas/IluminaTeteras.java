package pruebas;

import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

import com.sun.opengl.util.FPSAnimator;
import com.sun.opengl.util.GLUT;

/**
 * Este demo muestra algunos materiales sobre la tetera, todos están bajo una
 * luz con w=0, blanca y de intensidad media. El primer material es plástico
 * negro.
 * 
 * @author Jhonny Felipez
 * @version 1.0 10/06/2011
 */
public class IluminaTeteras implements GLEventListener {

    static float angulo = 0;
    // Inicia definición de materiales
    final float[] plasticoNegroAmb = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] plasticoNegroDif = {0.01f, 0.01f, 0.01f, 1.0f};
    final float[] plasticoNegroSpe = {0.5f, 0.5f, 0.5f, 1.0f};
    float plasticoNegroShi = 32.0f;
    final float[] oroAmb = {0.24725f, 0.2245f, 0.0645f, 1.0f};
    final float[] oroDif = {0.34615f, 0.3143f, 0.0903f, 1.0f};
    final float[] oroSpe = {0.797357f, 0.723991f, 0.208006f, 1.0f};
    float oroShi = 128.0f;
    final float[] esmeraldaAmb = {0.0215f, 0.1745f, 0.0215f, 0.55f};
    final float[] esmeraldaDif = {0.07568f, 0.61424f, 0.07568f, 0.55f};
    final float[] esmeraldaSpe = {0.633f, 0.727811f, 0.633f, 0.55f};
    float esmeraldaShi = 76.8f;
    final float[] cromoAmb = {0.25f, 0.25f, 0.25f, 1.0f};
    final float[] cromoDif = {0.4f, 0.4f, 0.4f, 1.0f};
    final float[] cromoSpe = {0.774597f, 0.774597f, 0.774597f, 1.0f};
    float cromoShi = 76.8f;
    final float[] totalAmb = {1.0f, 1.0f, 1.0f, 1.0f};
    final float[] totalDif = {1.0f, 1.0f, 1.0f, 1.0f};
    final float[] totalSpe = {1.0f, 1.0f, 1.0f, 1.0f};
    float totalShi = 128.0f;
    final float[] nadaAmb = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] nadaDif = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] nadaSpe = {0.0f, 0.0f, 0.0f, 1.0f};
    float nadaShi = 1.0f;
    final float[] difusionAmb = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] difusionDif = {1.0f, 1.0f, 1.0f, 1.0f};
    final float[] difusionSpe = {0.0f, 0.0f, 0.0f, 1.0f};
    float difusionShi = 1.0f;
    final float[] ambienteAmb = {1.0f, 1.0f, 1.0f, 1.0f};
    final float[] ambienteDif = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] ambienteSpe = {0.0f, 0.0f, 0.0f, 1.0f};
    float ambienteShi = 1.0f;
    final float[] especularAmb = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] especularDif = {0.0f, 0.0f, 0.0f, 1.0f};
    final float[] especularSpe = {1.0f, 1.0f, 1.0f, 1.0f};
    float especularShi = 40.0f;

    public static void main(String[] args) {

        // Primero se crea el objeto JFrame
        JFrame miMarco = new JFrame("Superficies en OpenGL");

        // Para que al cerrar la ventana el programa finalice.
        miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Se crea el objeto GLCapabilities
        GLCapabilities miCapacidad = new GLCapabilities();

        // Solicita doble buffer en el modo de despliegue
        miCapacidad.setDoubleBuffered(true);

        // Se crea el objeto GLCanvas
        GLCanvas miCanvas = new GLCanvas(miCapacidad);

        // Indicamos que miCanvas detecte los eventos de openGL de la Clase
        miCanvas.addGLEventListener(new IluminaTeteras());

        // Agrega animación a miCanvas - 60 cuadros por segundo
        FPSAnimator animador = new FPSAnimator(miCanvas, 60);

        // A continuacion insertamos miCanvas en miMarco
        miMarco.add(miCanvas);

        // Definimos el tamaño de la ventana.
        miMarco.setSize(800, 800);

        // Definimos la posición inicial de la ventana.
        miMarco.setLocation(120, 120);

        // Hacemos visible el elemento de mayor nivel
        miMarco.setVisible(true);

        // Inicia la animación
        animador.start();
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL(); // inicializa la variable GL

        gl.glClearColor(0.5f, 0.5f, 1.0f, 1.0f);

        // Parametros de la luz 0
        float[] luzAmbiente = {0.5f, 0.5f, 0.5f, 1.0f};
        float[] luzDifusa = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] luzEspecular = {1.0f, 1.0f, 1.0f, 1.0f};
        float[] posicion = {20.0f, 100.0f, 10.0f, 0.0f};

        // Se setean los parámetros
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, luzAmbiente, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, luzDifusa, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, luzEspecular, 0);
        gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);

        gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
        gl.glEnable(GL.GL_LIGHTING); // Habilita la iluminacion
        gl.glEnable(GL.GL_LIGHT0); // Habilita la luz 0 que previamente se habia seteado

        gl.glEnable(GL.GL_COLOR_MATERIAL); // Se activa los materiales de color

        // Se desean de tipo ambiente y difusión (tambien incluye specular)
        gl.glColorMaterial(GL.GL_BACK, GL.GL_AMBIENT_AND_DIFFUSE);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();
        GLUT glut = new GLUT();

        // borra buffer y el z-buffer, rota el cubo y dibuja, intercambiando buffers
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();

        glu.gluLookAt(0.0f, 10.0f, 40.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);

        // Plastico Negro
        material(gl, plasticoNegroAmb, plasticoNegroDif, plasticoNegroSpe, plasticoNegroShi);

        gl.glPushMatrix();
        gl.glTranslatef(-10.0f, 10.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Oro
        material(gl, oroAmb, oroDif, oroSpe, oroShi);

        gl.glPushMatrix();
        gl.glTranslatef(-10.0f, 0.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Esmeralda
        material(gl, esmeraldaAmb, esmeraldaDif, esmeraldaSpe, esmeraldaShi);

        gl.glPushMatrix();
        gl.glTranslatef(-10.0f, -10.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Cromo
        material(gl, cromoAmb, cromoDif, cromoSpe, cromoShi);

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 10.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Total
        material(gl, totalAmb, totalDif, totalSpe, totalShi);

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, 0.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Nada
        material(gl, nadaAmb, nadaDif, nadaSpe, nadaShi);

        gl.glPushMatrix();
        gl.glTranslatef(0.0f, -10.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Solo Difusión
        material(gl, difusionAmb, difusionDif, difusionSpe, difusionShi);

        gl.glPushMatrix();
        gl.glTranslatef(10.0f, 10.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Solo Ambiente
        material(gl, ambienteAmb, ambienteDif, ambienteSpe, ambienteShi);

        gl.glPushMatrix();
        gl.glTranslatef(10.0f, 0.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        //Solo Especular
        material(gl, especularAmb, especularDif, especularSpe, especularShi);

        gl.glPushMatrix();
        gl.glTranslatef(10.0f, -10.0f, 0.0f);
        gl.glRotatef(angulo, 0.0f, 1.0f, 0.0f);
        gl.glRotatef(15.0f, 1.0f, 0.0f, 0.0f);
        glut.glutSolidTeapot(3.0f);
        gl.glPopMatrix();

        drawable.swapBuffers();

        gl.glFlush();

        angulo += 0.2f;
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
        GL gl = drawable.getGL();
        GLU glu = new GLU();

        if (h == 0) {
            h = 1;
        }
        gl.glViewport(0, 0, w, h);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        if (w > h) {
            glu.gluPerspective(45.0f, w / h, 1, 150.0f);
        } else {
            glu.gluPerspective(45.0f, w / h, 1, 150.0f);
        }

        gl.glMatrixMode(GL.GL_MODELVIEW);
        gl.glLoadIdentity();
    }

    public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
    }

    public void material(GL gl, float amb[], float difu[], float espec[], float bri) {
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, difu, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, espec, 0);
        gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, bri);
    }
}
