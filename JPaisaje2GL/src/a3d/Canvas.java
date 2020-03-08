package a3d;

import java.awt.event.KeyEvent;
import javax.media.opengl.*;
import java.awt.event.KeyListener;
import javax.media.opengl.glu.GLU;

/**
 * @author Daniel Alvarez
 */
public class Canvas extends GLCanvas implements GLEventListener, KeyListener {

    private float anguloCuboX = 0.0f;
    private float anguloCuboY = 0.0f;
    private float anguloCuboZ = 0.0f;
    private float xxx = 0;
    private float zzz = 0;
    // Inicia definición de materiales
    final float[] rojoAmb = {1, 0, 0, 0.55f};
    final float[] rojoDif = {1, 0, 0, 0.55f};
    final float[] rojoSpe = {0.633f, 0.727811f, 0.633f, 0.55f};
    float rojoShi = 76.8f;
    // esmeralda
    final float[] esmeraldaAmb = {0.0215f, 0.1745f, 0.0215f, 0.55f};
    final float[] esmeraldaDif = {0.07568f, 0.61424f, 0.07568f, 0.55f};
    final float[] esmeraldaSpe = {0.633f, 0.727811f, 0.633f, 0.55f};
    float esmeraldaShi = 76.8f;
    // oro
    final float[] oroAmb = {0.24725f, 0.2245f, 0.0645f, 1.0f};
    final float[] oroDif = {0.34615f, 0.3143f, 0.0903f, 1.0f};
    final float[] oroSpe = {0.797357f, 0.723991f, 0.208006f, 1.0f};
    float oroShi = 128.0f;
    // cromo
    final float[] cromoAmb = {0.25f, 0.25f, 0.25f, 1.0f};
    final float[] cromoDif = {0.4f, 0.4f, 0.4f, 1.0f};
    final float[] cromoSpe = {0.774597f, 0.774597f, 0.774597f, 1.0f};
    float cromoShi = 76.8f;

    public Canvas(GLCapabilities capacidad) {
        super(capacidad);
        this.addGLEventListener(this);
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClearColor(0.8f, 1, 1, 0);
        gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de superficies
        drawable.addKeyListener(this);

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
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        gl.glTranslatef(0, 0, -5);
        gl.glTranslatef(xxx, 0, zzz);
        gl.glRotatef(anguloCuboX, 1, 0, 0);
        gl.glRotatef(anguloCuboY, 0, 1, 0);
        gl.glRotatef(anguloCuboZ, 0, 0, 1);

        // letreros
        material(gl, oroAmb, oroDif, oroSpe, oroShi);
        gl.glPushMatrix();
        gl.glTranslatef(3, 0, -15);
        Dibujar.letrero(gl);
        gl.glPopMatrix();

        material(gl, oroAmb, oroDif, oroSpe, oroShi);
        gl.glPushMatrix();
        gl.glTranslatef(-2, 0, -5);
        Dibujar.letrero(gl);
        gl.glPopMatrix();

        material(gl, oroAmb, oroDif, oroSpe, oroShi);
        gl.glPushMatrix();
        gl.glTranslatef(-2, 0, -55);
        Dibujar.letrero(gl);
        gl.glPopMatrix();

        material(gl, rojoAmb, rojoDif, rojoSpe, rojoShi);
        gl.glPushMatrix();
        gl.glTranslatef(5, 0, -25);
        Dibujar.casa(gl);
        gl.glPopMatrix();

        material(gl, esmeraldaAmb, esmeraldaDif, esmeraldaSpe, esmeraldaShi);
        gl.glPushMatrix();
        Dibujar.pista(gl);
        gl.glPopMatrix();

        material(gl, cromoAmb, cromoDif, cromoSpe, cromoShi);
        gl.glPushMatrix();
        Dibujar.camino(gl);
        gl.glPopMatrix();

        material(gl, esmeraldaAmb, esmeraldaDif, esmeraldaSpe, esmeraldaShi);
        gl.glPushMatrix();
        gl.glTranslatef(-3, 0, -15);
        Dibujar.arbol(gl);
        gl.glPopMatrix();

        material(gl, esmeraldaAmb, esmeraldaDif, esmeraldaSpe, esmeraldaShi);
        gl.glPushMatrix();
        gl.glTranslatef(-5, 0, -10);
        Dibujar.arbol2(gl);
        gl.glPopMatrix();

        material(gl, esmeraldaAmb, esmeraldaDif, esmeraldaSpe, esmeraldaShi);
        gl.glPushMatrix();
        gl.glTranslatef(3, 0, -20);
        Dibujar.arbol(gl);
        gl.glPopMatrix();

        material(gl, esmeraldaAmb, esmeraldaDif, esmeraldaSpe, esmeraldaShi);
        gl.glPushMatrix();
        gl.glTranslatef(3, 0, -30);
        Dibujar.arbol2(gl);
        gl.glPopMatrix();


        gl.glFlush();
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glMatrixMode(GL.GL_MODELVIEW);
        drawable.swapBuffers();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL();
        gl.glViewport(x, y, width, height);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        GLU glu = new GLU();
        float aspecto = (float) width / (float) height;
        //glu.gluPerspective(45, aspecto, 1, 10000);
        glu.gluPerspective(90, (float) width / (float) height, 1, 200);

        gl.glMatrixMode(GL.GL_MODELVIEW);
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 38) { // arriba
            zzz++;
        }
        if (e.getKeyCode() == 40) { // abajo
            zzz--;
        }
        if (e.getKeyCode() == 37) { // izquierda
            //xxx++;
            anguloCuboY--;
        }
        if (e.getKeyCode() == 39) { // derecha
            //xxx--;
            anguloCuboY++;

        }
        this.display();
    }

    public void keyReleased(KeyEvent e) {
    }

    public void material(GL gl, float amb[], float difu[], float espec[], float bri) {
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, amb, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, difu, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, espec, 0);
        gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, bri);
    }
}
