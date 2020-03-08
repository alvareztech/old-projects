package a3d;

import com.sun.opengl.util.GLUT;
import javax.media.opengl.GL;

/**
 * Clase Dibujos
 * @author Daniel Alvarez (a3dany)
 */
public class Dibujar {

    public static void cubo(GL gl) {
        // frontal
        gl.glColor3f(1, 0, 0);    // rojo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();
        // trasera
        gl.glColor3f(0, 1, 0);    // verde
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glEnd();
        // izquierda
        gl.glColor3f(0, 0, 1);    // azul
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(-1, -1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();
        // derecha
        gl.glColor3f(1, 1, 0);    // amarillo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(1, 1, 1);
        gl.glEnd();
        // arriba
        gl.glColor3f(1, 0, 1);    // rosado
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(1, 1, -1);
        gl.glVertex3f(-1, 1, -1);
        gl.glEnd();
        // abajo
        gl.glColor3f(0, 1, 1);    // celeste
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -1);
        gl.glVertex3f(-1, -1, -1);
        gl.glEnd();
    }

    public static void pista(GL gl) {
        int t = 200;
        gl.glColor3f(0.1f, 0.7f, 0);    // verde oscuro
        gl.glBegin(gl.GL_QUADS);
        gl.glNormal3f(-t, -1, t);
        gl.glVertex3f(-t, -1, t);
        gl.glNormal3f(t, -1, t);
        gl.glVertex3f(t, -1, t);
        gl.glNormal3f(t, -1, -t);
        gl.glVertex3f(t, -1, -t);
        gl.glNormal3f(-t, -1, -t);
        gl.glVertex3f(-t, -1, -t);
        gl.glEnd();
    }

    public static void arbol(GL gl) {
        gl.glColor3f(1, 1, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-0.2f, -1f, 0);
        gl.glVertex3f(0.2f, -1, 0);
        gl.glVertex3f(0.2f, 1, 0);
        gl.glVertex3f(-0.2f, 1, 0);
        gl.glEnd();
        gl.glTranslatef(0, 1, 0); // verde
        GLUT glut = new GLUT();
        gl.glColor3f(0, 1, 0);
        glut.glutSolidSphere(1, 10, 10);
    }

    public static void arbol2(GL gl) {
        gl.glColor3f(1, 1, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-0.2f, -1f, 0);
        gl.glVertex3f(0.2f, -1, 0);
        gl.glVertex3f(0.2f, 1, 0);
        gl.glVertex3f(-0.2f, 1, 0);
        gl.glEnd();
        gl.glTranslatef(0, 1, 0);
        GLUT glut = new GLUT();
        gl.glColor3f(0, 0.5f, 0); // verde oscuro
        glut.glutSolidSphere(1.5f, 10, 10);
    }

    public static void carretera(GL gl) {
        int t = 50;
        gl.glColor3f(0.5f, 0.5f, 0.5f);    // plomo
        gl.glBegin(gl.GL_QUADS);
        gl.glNormal3f(-1, -0.99f, t);
        gl.glVertex3f(-1, -0.99f, t);
        gl.glNormal3f(1, -0.99f, t);
        gl.glVertex3f(1, -0.99f, t);
        gl.glNormal3f(1, -0.99f, -t);
        gl.glVertex3f(1, -0.99f, -t);
        gl.glNormal3f(-1, -0.99f, -t);
        gl.glVertex3f(-1, -0.99f, -t);
        gl.glEnd();
    }

    public static void subCarretera(GL gl) {
        int t = 50;
        gl.glColor3f(0.6f, 0.6f, 0.6f);    // celeste
        gl.glBegin(gl.GL_QUADS);
        gl.glNormal3f(-1.2f, -0.999f, t);
        gl.glVertex3f(-1.2f, -0.999f, t);
        gl.glNormal3f(1.2f, -0.999f, t);
        gl.glVertex3f(1.2f, -0.999f, t);
        gl.glNormal3f(1.2f, -0.999f, -t);
        gl.glVertex3f(1.2f, -0.999f, -t);
        gl.glNormal3f(-1.2f, -0.999f, -t);
        gl.glVertex3f(-1.2f, -0.999f, -t);
        gl.glEnd();
    }

    public static void lineas(GL gl) {
        int t = 50;
        gl.glColor3f(1, 1, 1);    // blanco
        for (int i = -50; i < 50; i += 5) {
            gl.glBegin(gl.GL_QUADS);
            gl.glNormal3f(-0.07f, -0.98f, i + 2);
            gl.glVertex3f(-0.07f, -0.98f, i + 2);
            gl.glNormal3f(0.07f, -0.98f, i + 2);
            gl.glVertex3f(0.07f, -0.98f, i + 2);
            gl.glNormal3f(0.07f, -0.98f, i);
            gl.glVertex3f(0.07f, -0.98f, i);
            gl.glNormal3f(-0.07f, -0.98f, i);
            gl.glVertex3f(-0.07f, -0.98f, i);
            gl.glEnd();
        }
    }

    public static void letrero(GL gl) {
        gl.glColor3f(1, 1, 0);      // amarillo
        gl.glBegin(gl.GL_QUADS);    // palo
        gl.glVertex3f(-0.2f, -1, 0);
        gl.glVertex3f(0.2f, -1, 0);
        gl.glVertex3f(0.2f, 1, 0);
        gl.glVertex3f(-0.2f, 1, 0);
        gl.glEnd();
        material(gl, 0.1745f, 0.01175f, 0.01175f, 0.61424f, 0.04136f, 0.04136f, 0.727811f, 0.626959f, 0.626959f, 0.6f);
        gl.glColor3f(1, 0, 0);      // rojo
        gl.glBegin(gl.GL_QUADS);    // cuadro grande
        gl.glVertex3f(-0.6f, 2, 0);
        gl.glVertex3f(0.6f, 2, 0);
        gl.glVertex3f(0.6f, 1, 0);
        gl.glVertex3f(-0.6f, 1, 0);
        gl.glEnd();
        material(gl, 0.2125f, 0.1275f, 0.054f, 0.714f, 0.4284f, 0.18144f, 0.393548f, 0.271906f, 0.166721f, 0.2f);
        gl.glColor3f(1, 1, 1);      // blanco
        gl.glBegin(gl.GL_QUADS);    // cuadro pequeño
        gl.glVertex3f(-0.5f, 1.9f, 0.01f);
        gl.glVertex3f(0.5f, 1.9f, 0.01f);
        gl.glVertex3f(0.5f, 1.1f, 0.01f);
        gl.glVertex3f(-0.5f, 1.1f, 0.01f);
        gl.glEnd();
    }

    public static void techo(GL gl) {
        gl.glColor3f(1, 0, 0);    // rojo
        // frontal
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(0, 2, 1);
        gl.glEnd();
        // trasera
        gl.glBegin(gl.GL_TRIANGLES);
        gl.glVertex3f(-1, 1, -2);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(0, 2, -2);
        gl.glEnd();
        // izquierda
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, 1, -2);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(0, 2, 1);
        gl.glVertex3f(0, 2, -2);
        gl.glEnd();
        // derecha
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(0, 2, 1);
        gl.glVertex3f(0, 2, -2);
        gl.glEnd();
    }

    public static void puertas(GL gl) {
        gl.glColor3f(0.9f, 0.1f, 0);
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-0.5f, -1, 1.01f);
        gl.glVertex3f(0.5f, -1, 1.01f);
        gl.glVertex3f(0.5f, 0.5f, 1.01f);
        gl.glVertex3f(-0.5f, 0.5f, 1.01f);
        gl.glEnd();
    }

    public static void paredes(GL gl) {
        gl.glColor3f(1, 0.5f, 0);    // rojo
        // frontal
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();

        // trasera
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, -2);
        gl.glVertex3f(1, -1, -2);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(-1, 1, -2);
        gl.glEnd();
        gl.glColor3f(1, 0.8f, 0);    // rojo
        // izquierda
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(-1, -1, -2);
        gl.glVertex3f(-1, 1, -2);
        gl.glVertex3f(-1, 1, 1);
        gl.glEnd();

        // derecha
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -2);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(1, 1, 1);
        gl.glEnd();

        // arriba
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, 1, 1);
        gl.glVertex3f(1, 1, 1);
        gl.glVertex3f(1, 1, -2);
        gl.glVertex3f(-1, 1, -2);
        gl.glEnd();

        // abajo
        gl.glBegin(gl.GL_QUADS);
        gl.glVertex3f(-1, -1, 1);
        gl.glVertex3f(1, -1, 1);
        gl.glVertex3f(1, -1, -2);
        gl.glVertex3f(-1, -1, -2);
        gl.glEnd();
    }

    public static void camino(GL gl) {
        subCarretera(gl);
        material(gl, 0.05f, 0.05f, 0.05f, 0.5f, 0.5f, 0.5f, 0.7f, 0.7f, 0.7f, .078125f);
        carretera(gl);
        material(gl, 0.25f, 0.20725f, 0.20725f, 1f, 0.829f, 0.829f, 0.296648f, 0.296648f, 0.296648f, 0.088f);
        lineas(gl);
    }

    public static void casa(GL gl) {
        material(gl, 0.19125f, 0.0735f, 0.0225f, 0.7038f, 0.27048f, 0.0828f, 0.256777f, 0.137622f, 0.086014f, 0.1f);
        paredes(gl);
        material(gl, 0.329412f, 0.223529f, 0.027451f, 0.780392f, 0.568627f, 0.113725f, 0.992157f, 0.941176f, 0.807843f, 0.21794872f);
        puertas(gl);
        material(gl, 0.329412f, 0.223529f, 0.027451f, 0.780392f, 0.568627f, 0.113725f, 0.992157f, 0.941176f, 0.807843f, 0.21794872f);
        techo(gl);
    }

    public static void material(GL gl, float a1, float a2, float a3, float d1, float d2, float d3, float e1, float e2, float e3, float bri) {
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_AMBIENT, new float[]{a1, a2, a3}, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_DIFFUSE, new float[]{d1, d2, d3}, 0);
        gl.glMaterialfv(GL.GL_FRONT, GL.GL_SPECULAR, new float[]{e1, e2, e3}, 0);
        gl.glMaterialf(GL.GL_FRONT, GL.GL_SHININESS, bri);
    }
}
