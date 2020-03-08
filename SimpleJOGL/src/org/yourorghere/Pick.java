package org.yourorghere;

import java.awt.event.*;
import java.nio.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.*;

class Pick {

    private static class Renderer implements GLEventListener, MouseListener {

        private final int SIZE = 512;
        private ByteBuffer selectByteBuf = ByteBuffer.allocateDirect(SIZE * 4);
        private boolean picked = false;
        private int pickX, pickY;

        public void init(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();

            gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

            drawable.addMouseListener(this);
        }

        public void display(GLAutoDrawable drawable) {
            GL gl = drawable.getGL();

            if (picked) {
                // crea GLU
                GLU glu = new GLU(); // Necesita GLU

                int[] viewport = new int[4];

                // Obtiene coordenada x, y, ancho y alto
                gl.glGetIntegerv(GL.GL_VIEWPORT, viewport, 0);

                // El buffer retorna el valor del nombre de la pila, cuando el
                // modo de renderizado es GL_SELECT.
                gl.glSelectBuffer(SIZE, getBuffer(selectByteBuf));

                // La funcion glRenderMode configura el modo de renderizado.
                gl.glRenderMode(GL.GL_SELECT);

                // Modo seleccionado (GL_SELECT). No se produce un fragmento de
                // pixel, y no cambia el contenido del framebuffer. En lugar de
                // ello, retorna en el buffer de seleccionado el registro de nombres
                // de las primitivas que fueron dibujadas, en el modo renderizado
                // (GL_RENDER), este buffer tiene que ser creado antes de utilizar
                // el modo seleccionado.

                // La función glInitNames inicializa el nombre de la pila.
                gl.glInitNames();

                // La funciones glPushName y glPopName insertan y sacan el nombre de la pila.
                gl.glPushName(0);

                gl.glMatrixMode(GL.GL_PROJECTION);
                gl.glPushMatrix();
                gl.glLoadIdentity();

                // la funcion gluPickMatrix define una región picking.
                // gluPickMatrix(double x, double y, double height, double width,int viewport[4], int desplaza_viewport)

                /* crea la región elegida de 5x5 pixeles cerca de la ubicación del cursor */
                glu.gluPickMatrix((double) pickX,
                        (double) (viewport[3] - pickY), 5.0, 5.0, viewport, 0);

                glu.gluOrtho2D(-2.0, 2.0, -2.0, 2.0);
                drawObjects(gl, GL.GL_SELECT);

                gl.glPopMatrix();
                gl.glFlush();

                int hits = gl.glRenderMode(GL.GL_RENDER);
                int[] selectArray = new int[SIZE];
                getBuffer(selectByteBuf).get(selectArray);
                processHits(hits, selectArray);
                picked = false;
            } else {
                gl.glClear(GL.GL_COLOR_BUFFER_BIT);
                drawObjects(gl, GL.GL_RENDER);
                gl.glFlush();
            }
        }

        public void reshape(GLAutoDrawable drawable, int x, int y, int w, int h) {
            GL gl = drawable.getGL();
            GLU glu = new GLU();

            gl.glViewport(0, 0, w, h);
            gl.glMatrixMode(GL.GL_PROJECTION);
            gl.glLoadIdentity();
            glu.gluOrtho2D(-2.0, 2.0, -2.0, 2.0);
            gl.glMatrixMode(GL.GL_MODELVIEW);
            gl.glLoadIdentity();
        }

        public void displayChanged(GLAutoDrawable drawable,
                boolean faceChanged, boolean deviceChanged) {
        }

        public static void drawObjects(GL gl, int mode) {
            if (mode == GL.GL_SELECT) {
                gl.glLoadName(1);
            }
            gl.glColor3f(1.0f, 0.0f, 0.0f);
            gl.glRectf(-0.5f, -0.5f, 1.0f, 1.0f);
            if (mode == GL.GL_SELECT) {
                gl.glLoadName(2);
            }
            gl.glColor3f(0.0f, 0.0f, 1.0f);
            gl.glRectf(-1.0f, -1.0f, 0.5f, 0.5f);
        }

        private IntBuffer getBuffer(ByteBuffer buf) {
            buf.order(ByteOrder.nativeOrder());
            return buf.asIntBuffer();
        }

        /* processHits procesa la salida del contenido del arreglo seleccionado */
        private void processHits(int hits, int[] buffer) {
            int names;
            int bufIndex = 0;

            System.out.println("hits = " + hits);
            for (int i = 0; i < hits; i++) { /* for each hit */
                names = buffer[bufIndex];
                bufIndex += 3;
                for (int j = 0; j < names; j++) { /* for each name */
                    if (buffer[bufIndex] == 1) {
                        System.out.println("red rectangle");
                    } else {
                        System.out.println("blue rectangle");
                    }
                    bufIndex++;
                }
                System.out.println("");
            }
        }

        public void mousePressed(MouseEvent e) {
            GLCanvas canvas = (GLCanvas) e.getComponent();

            pickX = e.getX();
            pickY = e.getY();
            picked = true;
            // Actualmente el proceso de pick es realizado en display() porque
            // las llamadas OpenGL tiene que ser realizados en los metodos GLEventListener.
            canvas.display();
        }

        public void mouseReleased(MouseEvent e) {
        }

        public void mouseEntered(MouseEvent e) {
        }

        public void mouseExited(MouseEvent e) {
        }

        public void mouseClicked(MouseEvent e) {
        }
    }

    private static class KeyResponder implements KeyListener {

        public void keyPressed(KeyEvent e) {
            if (e.getKeyChar() == 27) {
                System.exit(0);
            }
        }

        public void keyReleased(KeyEvent e) {
        }

        public void keyTyped(KeyEvent e) {
        }
    }

    public static void main(String[] args) {
        GLCanvas miCanvas = new GLCanvas(new GLCapabilities());
        miCanvas.addGLEventListener(new Renderer());
        miCanvas.addKeyListener(new KeyResponder());
        ICGFrame miMarco = new ICGFrame("Pick", miCanvas);
        miMarco.setVisible(true);
    }
}
