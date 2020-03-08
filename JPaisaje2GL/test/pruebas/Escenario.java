package pruebas;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.media.opengl.glu.GLUquadric;

import com.sun.opengl.util.GLUT;

/**
 * 
 * @author Ivan Grover Mamani Huanca
 *
 */
public class Escenario implements GLEventListener, KeyListener {

	private float[] centro = { 0, 0, 0 };
	private float[] posicion = { -2, 1f, -10 };
	float angulo = 90;
	float radio = 4;
	float a, b;
	GLU glu;
	GLUT glut = new GLUT();

	float[] mat_ambiente = new float[4];
	float[] mat_difuso = new float[4];
	float[] mat_especular = new float[4];
	float mat_brillo = 128f;

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		Component c = e.getComponent();
		int tecla = e.getKeyCode();
		switch (tecla) {
		case 37: // Izquierda
			angulo -= 2;
			this.reDibujar(c);
			break;
		case 38: // Arriba
			if (Math.abs(posicion[0] - centro[0]) < 2) {
				posicion[2] += (posicion[2] < centro[2]) ? 1 : -1;
				centro[2] += (posicion[2] < centro[2]) ? 1 : -1;
			} else {
				this.calculaAB();
				posicion[0] += (posicion[0] < centro[0]) ? 1 : -1;
				centro[0] += (posicion[0] < centro[0]) ? 1 : -1;
				posicion[2] = a * posicion[0] + b;
				centro[2] = a * centro[0] + b;
			}
			this.reDibujar(c);
			break;
		case 39: // Derecha
			angulo += 2;
			this.reDibujar(c);
			break;
		case 40: // Abajo
			if (Math.abs(posicion[0] - centro[0]) < 2) {
				posicion[2] += (posicion[2] > centro[2]) ? 1 : -1;
				centro[2] += (posicion[2] > centro[2]) ? 1 : -1;
			} else {
				this.calculaAB();
				posicion[0] += (posicion[0] > centro[0]) ? 1 : -1;
				centro[0] += (posicion[0] > centro[0]) ? 1 : -1;
				posicion[2] = a * posicion[0] + b;
				centro[2] = a * centro[0] + b;
			}

			this.reDibujar(c);
			break;
		}
	}

	public void keyReleased(KeyEvent e) {
	}

	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		this.calculaCentro();
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		glu = new GLU();

		glu.gluLookAt(posicion[0], posicion[1], posicion[2], centro[0],
				centro[1], centro[2], 0, 1, 0);
		float[] color0 = { 1f, 1, 0 };
		float[] color1 = { 0.75f, 0.85f, 1 };
		float[] color2 = { 0.87f, 0.75f, 1 };
		float[] color3 = { 0.97f, 0.81f, 0.79f };
		float[] color4 = { 1, 1, 0.75f };

		this.cubo(gl, 9, 0, -1, 11, 6, -7, color0);
		this.cubo(gl, 4, 0, -7, 11, 4, -13, color1);
		this.cubo(gl, -11, 0, -7, -4, 5, -13, color1);
		this.cubo(gl, -11, 0, 13, -4, 6, 6, color2);
		this.cubo(gl, -11, 0, 6, -9, 5, 0, color3);
		this.cubo(gl, 4, 0, 13, 11, 7, 6, color3);
		this.cubo(gl, -1f, 0, 13, 1f, 0.5f, 6, color4);
		this.cubo(gl, -1f, 0, -7, 1f, 0.5f, -13, color2);

		this.circulo(gl, 4, 4);

		for (int i = -14; i <= 14; i++) {
			gl.glBegin(GL.GL_LINES);
			gl.glVertex3f(i, -0.01f, 16);
			gl.glVertex3f(i, -0.01f, -16);
			gl.glEnd();
		}
		for (int i = -16; i <= 16; i++) {
			gl.glBegin(GL.GL_LINES);
			gl.glVertex3f(14, -0.01f, i);
			gl.glVertex3f(-14, -0.01f, i);
			gl.glEnd();
		}

		this.arbol(gl, 0, 4, 0);
		this.arbol(gl, 0, 4, 8);
		this.arbol(gl, 0, 4, 11);
		this.arbol(gl, 0, 4, -8);
		this.arbol(gl, 0, 4, -11);
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
	}

	public void init(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

		float[] luzAmbiente = { 0.2f, 0.2f, 0.2f, 1 };
		float[] luzDifusa = { 1.0f, 1.0f, 1.0f, 1 };
		float[] luzEspecular = { 1.0f, 1.0f, 1.0f, 1 };
		float[] posicion = { 10.0f, 10.0f, 10.0f, 0 };

		gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, luzAmbiente, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, luzDifusa, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_SPECULAR, luzEspecular, 0);
		gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, posicion, 0);
		gl.glEnable(GL.GL_DEPTH_TEST);
		gl.glEnable(GL.GL_LIGHTING);
		gl.glEnable(GL.GL_LIGHT0);

		drawable.addKeyListener(this);
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL gl = drawable.getGL();
		gl.glViewport(0, 0, w, h);
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		GLU glu = new GLU();
		glu.gluPerspective(90, (float) w / (float) h, 1, 40);
		gl.glMatrixMode(GL.GL_MODELVIEW);
	}

	public void cubo(GL gl, float x0, float y0, float z0, float x1, float y1,
			float z1, float[] color) {
		gl.glPushMatrix();
		gl.glTranslatef(x0, y0, z0);
		gl.glScaled(Math.abs(x1 - x0), Math.abs(y1 - y0), Math.abs(z1 - z0));
		gl.glTranslatef(0.5f, 0.5f, -0.5f);

		mat_ambiente[0] = mat_difuso[0] = color[0];
		mat_ambiente[1] = mat_difuso[1] = color[1];
		mat_ambiente[2] = mat_difuso[2] = color[2];
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambiente, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_difuso, 0);
		glut.glutSolidCube(1);
		gl.glPopMatrix();
	}

	public void circulo(GL gl, float x, float z) {
		mat_ambiente[0] = mat_difuso[0] = 0;
		mat_ambiente[1] = mat_difuso[1] = 1;
		mat_ambiente[2] = mat_difuso[2] = 0;
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambiente, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_difuso, 0);
		gl.glPushMatrix();
		gl.glScaled(x, 0, z);
		gl.glBegin(GL.GL_POLYGON);
		gl.glVertex3f(0, 0, 0);
		for (int contador = 0; contador <= 360; contador += 5) {
			float theta = (float) (contador * 2 * Math.PI) / 360;
			gl.glVertex3f((float) Math.sin(theta), 0, (float) Math.cos(theta));
		}
		gl.glEnd();
		gl.glPopMatrix();
	}

	public void arbol(GL gl, float x, float y, float z) {
		gl.glPushMatrix();
		gl.glTranslated(x, y, z);
		mat_ambiente[0] = mat_ambiente[2] = 0;
		mat_ambiente[1] = mat_ambiente[3] = 1;
		mat_difuso[0] = mat_difuso[2] = 0;
		mat_difuso[1] = mat_difuso[3] = 1;
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambiente, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_difuso, 0);
		glut.glutSolidSphere(1.6, 15, 15);
		gl.glScalef(0.6f, 4, 0.6f);
		GLUquadric quadObj = glu.gluNewQuadric();
		mat_ambiente[0] = mat_difuso[0] = 0.46f;
		mat_ambiente[1] = mat_difuso[1] = 0.42f;
		mat_ambiente[2] = mat_difuso[2] = 0.2f;
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, mat_ambiente, 0);
		gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, mat_difuso, 0);
		gl.glRotatef(90, 1, 0, 0);
		glu.gluCylinder(quadObj, 0.5, 0.5, 1, 20, 10);
		gl.glPopMatrix();

	}

	private void reDibujar(Component c) {
		if (c instanceof GLCanvas) {
			GLCanvas canvas = (GLCanvas) c;
			canvas.display();
		}
	}

	public void calculaCentro() {
		centro[0] = (float) (radio * Math.cos(angulo * 2 * Math.PI / 360) + posicion[0]);
		centro[2] = (float) (radio * Math.sin(angulo * 2 * Math.PI / 360) + posicion[2]);
	}

	public void calculaAB() {
		a = (centro[2] - posicion[2]) / (centro[0] - posicion[0]);
		b = (centro[0] * posicion[2] - posicion[0] * centro[2])
				/ (centro[0] - posicion[0]);
	}
}