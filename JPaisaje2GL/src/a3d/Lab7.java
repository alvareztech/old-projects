package a3d;

import java.awt.event.*;
import javax.swing.JFrame;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;
import com.sun.opengl.util.GLUT;
import com.sun.opengl.util.FPSAnimator;

class Lab7 implements GLEventListener, KeyListener {
	public static void main(String[] args) {
		JFrame miMarco = new JFrame("Antialiasing");
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GLCapabilities miCapacidad = new GLCapabilities();
		miCapacidad.setDoubleBuffered(true);
		GLCanvas miCanvas = new GLCanvas(miCapacidad);
		miCanvas.addGLEventListener(new Lab7());
		FPSAnimator animador = new FPSAnimator(miCanvas, 30);
		miMarco.add(miCanvas);
		miMarco.setSize(600, 360);
		miMarco.setLocation(0, 0);
		miMarco.setVisible(true);
		animador.start();
	}

	boolean Lab7;
	boolean blending;
	boolean enabled;
	boolean fog;
	float fogDensity;

	public void init(GLAutoDrawable drawable) {
		GL gl = drawable.getGL(); // inicializa la variable GL
		GLU glu = new GLU();
		gl.glShadeModel(GL.GL_FLAT);
		gl.glClearDepth(1.0);
		gl.glEnable(GL.GL_DEPTH_TEST); // Habilita el ocultamiento de
										// superficies
		Lab7 = false;
		blending = false;
		fog = false;
		enabled = false;
		gl.glHint(GL.GL_LINE_SMOOTH_HINT, GL.GL_DONT_CARE);
		float fogColor[] = { 0.5f, 0.5f, 0.5f, 0.1f };
		fogMode = GL.GL_EXP;
		gl.glFogi(GL.GL_FOG_MODE, fogMode);
		gl.glFogfv(GL.GL_FOG_COLOR, fogColor, 0);
		fogDensity = 0.25f;
		gl.glHint(GL.GL_FOG_HINT, GL.GL_DONT_CARE);
		gl.glFogf(GL.GL_FOG_DENSITY, fogDensity);
		gl.glClearColor(0.5f, 0.5f, 0.5f, 1.0f);
		drawable.addKeyListener(this); // Para detectar eventos del teclado.
		yObj = 0f;
		xObj = 0f;
		xYo = 4.0f;
	}

	float yObj, xObj, xYo;
	int fogMode = GL.GL_LINEAR;

	public void display(GLAutoDrawable drawable) {
		GL gl = drawable.getGL();
		GLUT glut = new GLUT();
		GLU glu = new GLU();

		// Limpia la ventana
		gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);

		// Limpia la matriz actual (Modelo-Vista)
		gl.glLoadIdentity();
		gl.glFogi(GL.GL_FOG_MODE, fogMode);
		gl.glFogf(GL.GL_FOG_DENSITY, fogDensity);
		if (enabled) {
			gl.glEnable(GL.GL_LINE_SMOOTH);
			gl.glEnable(GL.GL_BLEND);
		} else {
			gl.glDisable(GL.GL_LINE_SMOOTH);
			gl.glDisable(GL.GL_BLEND);
			gl.glDisable(GL.GL_FOG);
		}
		if (blending)
			gl.glBlendFunc(GL.GL_ONE, GL.GL_ONE_MINUS_SRC_COLOR);
		if (Lab7)
			gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
		if (fog)
			gl.glEnable(GL.GL_FOG);
		else
			gl.glDisable(GL.GL_FOG);
		glu.gluLookAt(xYo, 0, 0, xObj, yObj, 0f, 0f, 0f, 1f);
		gl.glColor3f(1f, 1f, 1f);
		/*
		 * gl.glPushMatrix(); gl.glColor3f( 1f, 0f, 1f ); gl.glTranslatef (
		 * xObj, yObj, 0.0f ); glut.glutWireSphere(0.05, 10, 10);
		 * gl.glPopMatrix();
		 */
		gl.glPushMatrix();
		gl.glColor3f(0.6f, 0.6f, 0.6f);
		gl.glTranslatef(0.0f, 0.0f, -2.1f);
		gl.glScalef(500f, 50f, 0.1f);
		glut.glutSolidCube(1f);
		gl.glPopMatrix();
		gl.glPushMatrix();// Acera
		gl.glColor3f(0.5f, 0.5f, 0.5f);
		gl.glTranslatef(0.0f, -8f, -1f);
		gl.glScalef(500f, 10f, 0.3f);
		glut.glutSolidCube(1f);
		gl.glColor3f(0.0f, 0.0f, 0.0f);
		glut.glutWireCube(1f);
		gl.glPopMatrix();
		gl.glPushMatrix();// Acera
		gl.glColor3f(0.5f, 0.5f, 0.5f);
		gl.glTranslatef(0.0f, 8f, -1f);
		gl.glScalef(500f, 10f, 0.3f);
		glut.glutSolidCube(1f);
		gl.glColor3f(0.0f, 0.0f, 0.0f);
		glut.glutWireCube(1f);
		gl.glPopMatrix();
		gl.glPushMatrix();// Cables de electricidad
		gl.glColor3f(1f, 1f, 1f);
		gl.glTranslatef(0.0f, 5.5f, 7f);
		gl.glScalef(500f, 1.5f, 0.1f);
		glut.glutWireCube(1f);
		gl.glPopMatrix();
		gl.glPushMatrix();// Cables de electricidad
		gl.glColor3f(1f, 1f, 1f);
		gl.glTranslatef(0.0f, -5.5f, 7f);
		gl.glScalef(500f, 1.5f, 0.1f);
		glut.glutWireCube(1f);
		gl.glPopMatrix();
		int i = 0;
		for (float x = -1000; x <= 50; x += 5.0) {
			gl.glPushMatrix();// Tronco
			gl.glColor3f(0.55f, 0.35f, 0.2f);
			gl.glTranslatef(x, 10, 0);
			gl.glScalef(0.5f, 0.5f, 3f);
			glut.glutSolidCube(2);
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			glut.glutWireCube(2);
			gl.glPopMatrix();
			gl.glPushMatrix();// copa de árbol
			gl.glColor3f(0f, 1f, 0f);
			gl.glTranslatef(x, 10, 4f);
			glut.glutSolidSphere(2.0, 10, 10);
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			glut.glutWireSphere(2.1, 20, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();// tronco
			gl.glColor3f(0.55f, 0.35f, 0.2f);
			gl.glTranslatef(x, -10, 0);
			gl.glScalef(0.5f, 0.5f, 3f);
			glut.glutSolidCube(2);
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			glut.glutWireCube(2);
			gl.glPopMatrix();
			gl.glPushMatrix();// copa de árbol
			gl.glColor3f(0f, 1f, 0f);
			gl.glTranslatef(x, -10, 4f);
			glut.glutSolidSphere(2.0, 10, 10);
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			glut.glutWireSphere(2.1, 20, 10);
			gl.glPopMatrix();
			gl.glPushMatrix();// Marcas de transito
			gl.glColor3f(1f, 1f, 1f);
			gl.glTranslatef(x, 0, -1.0f);
			gl.glScalef(3f, 0.5f, 0.01f);
			glut.glutSolidCube(1);
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			glut.glutWireCube(1);
			gl.glPopMatrix();
			i++;
			if (i % 2 == 0)
				continue;
			float y = 5.5f;
			if ((i / 2) % 2 == 0)
				y *= -1;
			gl.glPushMatrix();// Poste de electricidad
			gl.glColor3f(0.55f, 0.35f, 0.2f);
			gl.glTranslatef(x, y, 0);
			gl.glScalef(0.1f, 0.1f, 7f);
			glut.glutSolidCube(2);
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			glut.glutWireCube(2);
			gl.glPopMatrix();
			gl.glPushMatrix();// Poste de electricidad
			gl.glColor3f(0.55f, 0.35f, 0.2f);
			gl.glTranslatef(x, y, 7);
			gl.glScalef(0.1f, 2f, 0.1f);
			glut.glutSolidCube(2);
			gl.glColor3f(0.0f, 0.0f, 0.0f);
			glut.glutWireCube(2);
			gl.glPopMatrix();
		}

		// Limpia la tuberia e intercambia los buffers
		gl.glFlush();
		// drawable.swapBuffers();
		// glutPostRedisplay(); // Requiere un redibujo para propositos de
		// animación.
	}

	public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
		GL gl = drawable.getGL();
		GLU glu = new GLU();
		float aspectRatio;
		h = (h == 0) ? 1 : h;
		w = (w == 0) ? 1 : w;
		gl.glViewport(0, 0, w, h); // Utiliza toda la ventana
		aspectRatio = (float) w / (float) h;

		// Configura la matriz de proyección (no muy bien!)
		gl.glMatrixMode(GL.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(60.0, aspectRatio, 0.1, 200.0);

		// Selecciona la matriz del Modelo-Vista
		gl.glMatrixMode(GL.GL_MODELVIEW);
	}

	public void keyPressed(KeyEvent e) {
		float xx = xObj, yy = yObj;
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			xYo -= 0.5f;
			xObj -= 0.5f;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			xYo += 0.25f;
			xObj += 0.25f;
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			yObj -= 0.25f;
			if (yObj < 0f)
				xObj += 0.25f;
			else
				xObj -= 0.25f;
			if (xObj > xYo) {
				xObj = xx;
				yObj = yy;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			yObj += 0.25f;
			if (yObj > 0f)
				xObj += 0.25f;
			else
				xObj -= 0.25f;
			if (xObj > xYo) {
				xObj = xx;
				yObj = yy;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_R) {
			enabled = false;
			Lab7 = false;
			blending = false;
			fog = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			enabled = true;
			Lab7 = true;
			blending = false;
			fog = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_B) {
			enabled = true;
			Lab7 = false;
			blending = true;
			fog = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_F) {
			enabled = true;
			Lab7 = false;
			blending = false;
			fog = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_M) {
			fogDensity += 0.02;
			if (fogDensity > 1)
				fogDensity = 1.0f;
		}
		if (e.getKeyCode() == KeyEvent.VK_N) {
			fogDensity -= 0.02;
			if (fogDensity < 0.0)
				fogDensity = 0.0f;
		}
	}

	public void displayChanged(GLAutoDrawable arg0, boolean arg1, boolean arg2) {
	}

	public void keyReleased(KeyEvent arg0) {
	}

	public void keyTyped(KeyEvent arg0) {
	}
}