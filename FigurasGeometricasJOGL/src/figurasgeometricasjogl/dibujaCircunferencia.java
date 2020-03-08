package figurasgeometricasjogl;

/* Importamos las clases JFrame y JPanel
 * contenidas dentro del paquete SWING */
import javax.swing.JFrame;
import javax.swing.JPanel;

/* Importamos las clases Container, BorderLayout,
 * Toolkit y Dimension del paquete AWT. */
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;

// Importamos la librería de OpenGL
import javax.media.opengl.*;

public class dibujaCircunferencia extends JFrame implements GLEventListener {
    /* Necesitaremos un JPanel para introducir
     * los elementos que se mostrarán en el JFrame. */

    JPanel panelDibujo;

    /* Declaramos un contenedor para introducir
     * nuestro panel principal, el contenedor
     * será el JFrame en general. */
    Container contenedor;

    /* El toolkit es útil para obtener
     * información básica de la computadora, cómo la resolución
     * o dimensión de la pantalla,
     * dónde se está ejecutando el programa */
    Toolkit kit;

    /* Esta variable la utilizaremos para almacenar
     * la dimensión (ancho x alto), en pixeles, de
     * la pantalla dónde se está ejecutando el programa. */
    Dimension dimensionPantalla;
    // Variable para almacenar la altura, en pixeles, de la pantalla
    int altura;
    // Variable para almacenar la anchura, en pixeles, de la pantalla
    int anchura;
    // La interfaz GL nos proporcionará el acceso a las funciones de OpenGL
    static GL gl;
    /* La clase GLCanvas nos proporciona el soporte para el renderizado
     * de los gráficos de OpenGL, por el momento solamente la utilizaremos
     * para mostrar los cuatro métodos principales de GLEventListener */
    static GLCanvas canvas;

    /* Declaramos un array de 8x2 elementos para representar las
     * coordenadas de los 8 vertices utilizados para dibujar el octagono */
    double punto[][] = new double[360][2];

    // Constructor
    public dibujaCircunferencia() {
        /* Llamamos a la superclase de JFrame
         * la cual colocará un título al mismo. */
        super("Circunferencia con JOGL");

        /* Inicializamos el array que representan
         * las coordenadas de los vértices */
        for (int i = 0; i < 360; i++) {
            punto[i][0] = 0.0f;
            punto[i][1] = 0.0f;
        }

        /* Instanciamos un objeto de Toolkit para obtener
         * los datos generales de nuestra computadora. */
        kit = Toolkit.getDefaultToolkit();

        /* Obtenemos la dimensión de la pantalla en pixeles */
        dimensionPantalla = kit.getScreenSize();

        /* Almacenamos la altura y anchura, en pixeles, de la pantalla.
         * Debido a que los métodos "getHeight" y "getWidth" regresan una
         * variable de tipo double, necesitaremos obligar
         * al programa que convierta dicha variable a int. */
        altura = (int) dimensionPantalla.getHeight();
        anchura = (int) dimensionPantalla.getWidth();

        // Creamos el objeto de la clase GLCanvas
        canvas = new GLCanvas();

        /* Añadimos el oyente de eventos para el renderizado de OpenGL,
         * esto automáticamente llamará a init() y renderizará los
         * gráficos cuyo código haya sido escrito dentro del método display() */
        canvas.addGLEventListener(this);

        /* Inicializamos la interfaz de GL la cual utilizaremos
         * para llamar a las funciones de OpenGL */
        gl = canvas.getGL();

        panelDibujo = new JPanel(new BorderLayout());

        /* Agregamos el objeto GLCanvas dentro del JPanel
         * para que los gráficos renderizados dentro del
         * objeto GLCanvas puedan ser visualizados. */
        panelDibujo.add(canvas, BorderLayout.CENTER);

        /* Le decimos a Java que el contenedor será el mismo JFrame */
        contenedor = getContentPane();

        /* Agregamos el JPanel dentro del JFrame utilizando el
         * contenedor creado previamente, situando al JPanel
         * en el centro del JFrame utilizando BorderLayout */
        contenedor.add(panelDibujo, BorderLayout.CENTER);

        /* Ya que tenemos obtenida la altura y anchura, en pixeles
         * de la pantalla, definimos el tamaño del JFrame.
         * En este caso será un cuadrado cuyos lados medirán
         * el tamaño de la mitad de la altura de la pantalla. */
        this.setSize(altura / 2, altura / 2);

        /* Ahora situamos al JFrame exactamente en el centro de la
         * pantalla donde se está ejecutando el programa */
        this.setLocation((anchura - altura / 2) / 2, altura / 4);

        /* Lo hacemos que no sea redimensionable pero sí visible */
        this.setResizable(false);
        this.setVisible(true);

        /* Finalmente, le indicamos a Java que queremos que nuestro
         * JFrame se cierre cuando demos click en el botón cerrar
         * que aparecerá en la parte superior derecha del mismo. */
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // A continuación se muestran los métodos utilizados por GLEventListener

    /* Como se explicó, este método es el que inicializará
     * los gráficos de OpenGL que GLCanvas utilizará,
     * para llamar a las funciones de OpenGL utilizaremos el objeto gl
     * creado anteriormente. */
    public void init(GLAutoDrawable drawable) {
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-5.0, 5.0, -5.0, 5.0, -5.0, 5.0);
        canvas.repaint();
    }

    public void display(GLAutoDrawable drawable) {
        /* Este método es utilizado para crear todos los gráficos que
         * se dibujarán dentro del objeto GLCanvas. Primero llamamos al
         * método de OpenGL glClear(GLBitField mask) el cual limpiará
         * todos los buffers para poder dibujar. */
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);

        /* Ahora llamamos al método glColor3f(float, float, float)
         * el cual definirá el color de los gráficos que se
         * dibujarán. En este caso dibujaremos un punto de color Azul. */
        gl.glColor3f(0.0f, 0.5f, 1.0f);

        /* Esto es prácticamente igual a una declaración hecha
         * en C ó C++ utilizando OpenGL. Indicamos que iniciaremos
         * a dibujar con el método glBegin(GLEnum Mode) y que finalizaremos
         * con el método glEnd(). Dentro de ambos métodos irán TODOS
         * los gráficos que dibujaremos. */

        // Utilizar el siguiente solamente si se dibujan puntos
        // gl.glPointSize(12);

        // Método para cambiar el grosor de la línea
        // gl.glLineWidth(5);

        gl.glBegin(GL.GL_LINE_LOOP);
        // Inicializamos el primer vértice
        // Coordenada x (primer vértice)
        punto[0][0] = 4.0;

        // Coordenada y (primer vértice)
        punto[0][1] = 0.0;

        // Dibujamos el primer vértice
        gl.glVertex2d(punto[0][0], punto[0][1]);

        /* Dibujamos los 359 vértices restantes haciendo rotar
         * el anterior 1º, utilizaremos el equivalente en
         * radianes ya que las funciones sin y cos del
         * paquete Math de Java trabaja con estos últimos */
        for (int i = 1; i < 360; i++) {
            // Coordenada x' = x*cos(1º) - y*sin(1º)
            punto[i][0] = punto[i - 1][0] * Math.cos(Math.toRadians(1)) - punto[i - 1][1] * Math.sin(Math.toRadians(1));

            // Coordenada y' = x*sin(1º) + y*cos(1º)
            punto[i][1] = punto[i - 1][0] * Math.sin(Math.toRadians(1)) + punto[i - 1][1] * Math.cos(Math.toRadians(1));

            // Dibujamos el nuevo vértice obtenido
            gl.glVertex2d(punto[i][0], punto[i][1]);
        }

        gl.glEnd();

        /* Indicamos que dibuje inmediatamente después utilizando el método
         * glFlush(); */
        gl.glFlush();
        canvas.repaint();
    }

    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
        /* Método para el manejo de eventos del cambio de visualizador, este
         * tampoco lo utilizaremos ahora. */
    }

    // Finalizan los métodos utilizados por GLEventListener
    // Método principal para iniciar la ejecución de nuestro programa
    public static void main(String[] args) {
        /* Simplemente crearemos un objeto de la clase
         * jFrameCentrado, entonces el programa ejecutará
         * el código del constructor. */
        new dibujaCircunferencia();
    }
}
