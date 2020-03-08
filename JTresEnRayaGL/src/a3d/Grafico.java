package a3d;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;

/**
 * Clase Grafico
 * @author Daniel Alvarez (a3dany)
 */
public class Grafico extends GLCanvas implements GLEventListener {

    private int ancho;
    private int alto;
    private char[] tablero;
    private Punto[] posiciones;
    private IA ia;
    private Ventana nucleo;
    private Punto punto1;
    private Punto punto2;
    private boolean hayGanador;

    public Grafico(final Ventana nucleo) {
        this.nucleo = nucleo;
        hayGanador = false;
        ia = new IA();
        tablero = new char[9];
        for (int i = 0; i < tablero.length; i++) {
            tablero[i] = ' ';
        }
        posiciones = new Punto[9];
        posiciones[0] = new Punto(0.2f, 0.8f);
        posiciones[1] = new Punto(0.5f, 0.8f);
        posiciones[2] = new Punto(0.8f, 0.8f);
        posiciones[3] = new Punto(0.2f, 0.5f);
        posiciones[4] = new Punto(0.5f, 0.5f);
        posiciones[5] = new Punto(0.8f, 0.5f);
        posiciones[6] = new Punto(0.2f, 0.2f);
        posiciones[7] = new Punto(0.5f, 0.2f);
        posiciones[8] = new Punto(0.8f, 0.2f);
        addGLEventListener(this);
        addMouseListener(new MouseAdapter() {

            public void mousePressed(MouseEvent e) {
                float xPos = ((float) e.getX()) / ((float) (ancho - 1));
                float yPos = ((float) e.getY()) / ((float) (alto - 1));
                yPos = 1.0f - yPos; // Cambia el valor de la posicion y es desde la fila de arriba.
                //System.out.println("< " + xPos + " > < " + yPos + " >");
                int pos = posicion(xPos, yPos);
                if (pos > 0 && tablero[pos - 1] == ' ') {
                    tablero[pos - 1] = 'x';

                    try {
                        ia.setMovimientoHumano(pos);
                        ia.minimax();
                        tablero = ia.getMovimientoIA();
                    } catch (Exception ex) {
                    }

                    buscarGanador();
                    display();
                }

            }

            private int posicion(float x, float y) {
                int p = 0;
                if (y > 0.05 && y < 0.35) { // ultima fila
                    if (x > 0.05 && x < 0.35) {
                        return 7;
                    }
                    if (x > 0.35 && x < 0.65) {
                        return 8;
                    }
                    if (x > 0.65 && x < 0.95) {
                        return 9;
                    }
                    return 0;
                } else {
                    if (y > 0.35 && y < 0.65) {// segunda fila
                        if (x > 0.05 && x < 0.35) {
                            return 4;
                        }
                        if (x > 0.35 && x < 0.65) {
                            return 5;
                        }
                        if (x > 0.65 && x < 0.95) {
                            return 6;
                        }
                        return 0;
                    } else {
                        if (y > 0.65 && y < 0.95) { // primera fila
                            if (x > 0.05 && x < 0.35) {
                                return 1;
                            }
                            if (x > 0.35 && x < 0.65) {
                                return 2;
                            }
                            if (x > 0.65 && x < 0.95) {
                                return 3;
                            }
                            return 0;
                        } else {
                            return 0;
                        }
                    }
                }
            }

            private void buscarGanador() {
                if (lleno()) {
                    nucleo.mostrarMensaje("EMPATAMOS! creo que ambos somos igual de buenos.");
                    nucleo.reiniciar(' ');
                } else {
                    if (gano('x')) {
                        hayGanador = true;
                        display();
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        nucleo.mostrarMensaje("GANASTE! perdi porque tengo un virus que me molesta.");
                        nucleo.reiniciar('x');
                    } else {
                        if (gano('o')) {
                            hayGanador = true;
                            display();
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Grafico.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            nucleo.mostrarMensaje("PERDISTE! soy mejor que tu, humano.");
                            nucleo.reiniciar('o');
                        }
                    }
                }
            }

            private boolean lleno() {
                for (int i = 0; i < tablero.length; i++) {
                    if (tablero[i] == ' ') {
                        return false;
                    }
                }
                return true;
            }

            private boolean gano(char c) {
                /*
                 * 0 1 2
                 * 3 4 5
                 * 6 7 8
                 */
                // filas
                if (tablero[0] == c && tablero[1] == c && tablero[2] == c) {
                    punto1 = new Punto(0.1f, 0.8f);
                    punto2 = new Punto(0.9f, 0.8f);
                    return true;
                }
                if (tablero[3] == c && tablero[4] == c && tablero[5] == c) {
                    punto1 = new Punto(0.1f, 0.5f);
                    punto2 = new Punto(0.9f, 0.5f);
                    return true;
                }
                if (tablero[6] == c && tablero[7] == c && tablero[8] == c) {
                    punto1 = new Punto(0.1f, 0.2f);
                    punto2 = new Punto(0.9f, 0.2f);
                    return true;
                }
                // columnas
                if (tablero[0] == c && tablero[3] == c && tablero[6] == c) {
                    punto1 = new Punto(0.2f, 0.1f);
                    punto2 = new Punto(0.2f, 0.9f);
                    return true;
                }
                if (tablero[1] == c && tablero[4] == c && tablero[7] == c) {
                    punto1 = new Punto(0.5f, 0.1f);
                    punto2 = new Punto(0.5f, 0.9f);
                    return true;
                }
                if (tablero[2] == c && tablero[5] == c && tablero[8] == c) {
                    punto1 = new Punto(0.8f, 0.1f);
                    punto2 = new Punto(0.8f, 0.9f);
                    return true;
                }
                // diagonales
                if (tablero[0] == c && tablero[4] == c && tablero[8] == c) {
                    punto1 = new Punto(0.1f, 0.9f);
                    punto2 = new Punto(0.9f, 0.1f);
                    return true;
                }
                if (tablero[2] == c && tablero[4] == c && tablero[6] == c) {
                    punto1 = new Punto(0.1f, 0.1f);
                    punto2 = new Punto(0.9f, 0.9f);
                    return true;
                }
                return false;
            }
        });
    }

    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        //gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glPointSize(8); // Tamaño de los puntos.
        gl.glLineWidth(5); // Ancho de las lineas.

        gl.glEnable(GL.GL_POINT_SMOOTH);
        gl.glEnable(GL.GL_LINE_SMOOTH);
        gl.glHint(GL.GL_POINT_SMOOTH_HINT, GL.GL_NICEST); // Redondea puntos
        gl.glHint(GL.GL_LINE_SMOOTH_HINT, GL.GL_NICEST); // Agrega antialias a la línea
        gl.glEnable(GL.GL_BLEND);
        gl.glBlendFunc(GL.GL_SRC_ALPHA, GL.GL_ONE_MINUS_SRC_ALPHA);
    }

    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();           // inicializa la variable GL
        gl.glClear(GL.GL_COLOR_BUFFER_BIT); // borra el buffer de la ventana

        // linea vertical
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(0.95f, 0.95f, 0.95f); // gris
        gl.glVertex2d(0.35f, 0.05f);
        gl.glColor3f(0.1f, 0.1f, 0.1f); // blanco
        gl.glVertex2d(0.35f, 0.95f);
        gl.glEnd();

        // linea vertical
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(0.1f, 0.1f, 0.1f); // blanco
        gl.glVertex2d(0.65f, 0.05f);
        gl.glColor3f(0.95f, 0.95f, 0.95f); // gris
        gl.glVertex2d(0.65f, 0.95f);
        gl.glEnd();

        // linea horizontal
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(0.1f, 0.1f, 0.1f); // blanco
        gl.glVertex2d(0.05f, 0.35f);
        gl.glColor3f(0.95f, 0.95f, 0.95f); // gris
        gl.glVertex2d(0.95f, 0.35f);
        gl.glEnd();

        // linea horizontal
        gl.glBegin(GL.GL_LINE_STRIP);
        gl.glColor3f(0.95f, 0.95f, 0.95f); // gris
        gl.glVertex2d(0.05f, 0.65f);
        gl.glColor3f(0.1f, 0.1f, 0.1f); // blanco
        gl.glVertex2d(0.95f, 0.65f);
        gl.glEnd();

        //gl.glColor3f(1.0f, 0.0f, 0.8f); // morado

        for (int i = 0; i < tablero.length; i++) {
            if (tablero[i] == 'x') {
                gl.glBegin(GL.GL_LINE_STRIP);
                gl.glColor3f(0.0f, 0.0f, 1.0f); // azul
                gl.glVertex2d(posiciones[i].getX() - 0.1f, posiciones[i].getY() - 0.1f);
                gl.glColor3f(0.0f, 0.75f, 1.0f); // azul claro
                gl.glVertex2d(posiciones[i].getX() + 0.1f, posiciones[i].getY() + 0.1f);
                gl.glEnd();
                gl.glBegin(GL.GL_LINE_STRIP);
                gl.glColor3f(0.0f, 0.0f, 1.0f); // azul
                gl.glVertex2d(posiciones[i].getX() - 0.1f, posiciones[i].getY() + 0.1f);
                gl.glColor3f(0.0f, 0.75f, 1.0f); // azul claro
                gl.glVertex2d(posiciones[i].getX() + 0.1f, posiciones[i].getY() - 0.1f);
                gl.glEnd();
            } else {
                if (tablero[i] == 'o') {
                    gl.glBegin(GL.GL_LINE_LOOP);
                    for (int j = 0; j < 40; j++) {
                        if (j < 10) {
                            gl.glColor3f(1.0f, 0.0f, 0.0f); // rojo
                        } else {
                            if (j < 20) {
                                gl.glColor3f(1.0f, 0.3f, 0.0f); // mas claro
                            } else {
                                if (j < 30) {
                                    gl.glColor3f(1.0f, 0.5f, 0.0f); // mas mas claro
                                } else {
                                    gl.glColor3f(1.0f, 0.6f, 0.0f); // mucho mas claro
                                }
                            }
                        }
                        Punto C = generar(posiciones[i].getX(), posiciones[i].getY(), j);
                        gl.glVertex2d(C.getX(), C.getY());
                    }
                    gl.glEnd();
                }
            }

        }

        if (hayGanador) {
            gl.glBegin(GL.GL_LINE_STRIP);
            gl.glColor3f(0.0f, 1.0f, 0.0f); // blanco
            gl.glVertex2d(punto1.getX(), punto1.getY());
            gl.glColor3f(0.9f, 1.0f, 0.0f); // gris
            gl.glVertex2d(punto2.getX(), punto2.getY());
            gl.glEnd();
        }

        gl.glFlush();
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        GL gl = drawable.getGL(); // Inicializa la variable GL
        GLU glu = new GLU(); // Inicializa la variable GLU

        ancho = (width > 1) ? width : 2; // ancho de la ventana
        alto = (height > 1) ? height : 2; // alto de la ventana

        gl.glViewport(0, 0, width, height); // define tamaño
        gl.glMatrixMode(GL.GL_PROJECTION); // utiliza matriz de proyeccion
        gl.glLoadIdentity(); // inicializa matriz de proyeccíon

        // La vista siempre será [0,1] x [0,1].
        glu.gluOrtho2D(0.0f, 1.0f, 0.0f, 1.0f); // proyección en paralelo

        gl.glMatrixMode(GL.GL_MODELVIEW); // utiliza matriz de vista modelo
        gl.glLoadIdentity(); // inicializa matriz de vista de modelo
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }

    public static Punto generar(float centroX, float centroY, int i) {
        Punto punto = new Punto();
        int rad = 9;
        float radio = 0.1F;
        punto.setX(centroX + (radio * (float) Math.cos(Math.toRadians(rad * i))));
        punto.setY(centroY + (radio * (float) Math.sin(Math.toRadians(rad * i))));
        return punto;
    }
}
