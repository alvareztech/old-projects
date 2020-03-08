package pruebas;

import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.swing.JFrame;

/**
 * 
 * @author Ivan Grover Mamani Huanca
 *
 */
public class Main {
	public static void main(String[] args) {
		JFrame miMarco = new JFrame("Ciudad OGL - Iluminación");
		miMarco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		GLCapabilities capabilities = new GLCapabilities();
		capabilities.setDoubleBuffered(true);

		GLCanvas miCanvas = new GLCanvas(capabilities);
		miCanvas.addGLEventListener(new Escenario());

		miMarco.add(miCanvas);
		miMarco.setSize(600, 600);
		miMarco.setVisible(true);
	}
}
