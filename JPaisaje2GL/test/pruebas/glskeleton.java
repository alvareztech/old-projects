package pruebas;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLException;
import javax.media.opengl.GLJPanel;

import com.sun.opengl.util.FPSAnimator;

/**
 * Abstract skeleton class for the red book examples. 
 * @author Kiet Le 
 **/
public abstract class glskeleton //
// implements //
// KeyListener//
// , MouseListener//
// , MouseMotionListener//
// , MouseWheelListener //
// Runnable //
{
    protected GLJPanel jcanvas;
    protected GLCanvas canvas;
    
    protected FPSAnimator animator;
    protected final int DefaultFPS = 24;
    protected final int THIRTY_FPS = 30;
    protected final int SIXTY_FPS = 60;
    
    protected boolean animate = false;
    
    /**
     * Constructs an instance of this object and also set its canvas reference
     * to be a GLJPanel.
     *
     * @param jcanvas
     */
//    public glskeleton(GLJPanel jcanvas) {nah, decendants can't use w/O overriding'
//        this();use just setCanvas meths
//        this.jcanvas = jcanvas;
//    }
    
    /**
     * Constructs an instance of this object and also set its canvas reference
     * to be a GLCanvas.
     *
     * @param jcanvas
     */
//    public glskeleton(GLCanvas canvas) {
//        this();
//        this.canvas = canvas;
//    }
    
    /**
     * Construct a default instance without specifying a type of canvas
     * reference. <br />
     * <br />
     * NOTE: <br />
     * When constructing an object this way, make sure to use
     * <code>setCanvas()</code> later to reference the canvas. Otherwise, a
     * GLException is thrown.
     */
    public glskeleton() {
    }
    
    public final void setCanvas(GLJPanel jcanvas) {
        this.canvas = null;
        this.jcanvas = jcanvas;
    }
    
    public final void setCanvas(GLCanvas canvas) {
        this.jcanvas = null;
        this.canvas = canvas;
    }
    
    /** to be called from decendant to add listeners (key, mouse*, action)
     * with one call
     */
    public void setDefaultListeners(Object demo){
        
        if (canvas == null && jcanvas !=null) {
            // explicit cast for class not impl'ing listeners
            // to make it compile,
//            jcanvas.addGLEventListener((GLEventListener) demo);this won't add gl listent'
            if (demo instanceof KeyListener)
                jcanvas.addKeyListener((KeyListener) demo);
            if (demo instanceof MouseListener)
                jcanvas.addMouseListener((MouseListener) demo);
            if (demo instanceof MouseMotionListener)
                jcanvas.addMouseMotionListener((MouseMotionListener) demo);
            if (demo instanceof MouseWheelListener)
                jcanvas.addMouseWheelListener((MouseWheelListener) demo);
        }
        if (jcanvas == null && canvas !=null){
//            canvas.addGLEventListener((GLEventListener)demo);
            if (demo instanceof KeyListener)
                canvas.addKeyListener((KeyListener) demo);
            if (demo instanceof MouseListener)
                canvas.addMouseListener((MouseListener) demo);
            if (demo instanceof MouseMotionListener)
                canvas.addMouseMotionListener((MouseMotionListener) demo);
            if (demo instanceof MouseWheelListener)
                canvas.addMouseWheelListener((MouseWheelListener) demo);
            
        }
    }
    /**
     * Call the reference canvas's display methods. Should be called after
     * handling of input events.
     */
    public final void refresh() {
        if (jcanvas == null && canvas == null)
            throw new GLException//
                    ("Either reference to GLJPanel or GLCanvas is not set.");
        if (jcanvas != null)
            jcanvas.display();
        if (canvas != null)
            canvas.display();
    }//
    
    /**
     * Set or reset the canvas's animator.
     *
     * @param fps
     */
    public final FPSAnimator setDefaultAnimator(int fps) {
        if(canvas !=null) animator = new FPSAnimator(canvas, DefaultFPS);
        
        if(jcanvas !=null) animator = new FPSAnimator(jcanvas, DefaultFPS);
        return animator;
    }//
    public void animate(){
        animate = true;
        animator.start();
    }
    public void pause(){
        animate = false;
        animator.stop();
    }
    
    public final void runExit() {
        new Thread(new Runnable() {
            public void run() {
                if (animator != null) animator.stop();
                System.exit(0);
            }
        }).start();
        
    }//
    
    public static void main(String [] args){
        glskeleton demo  = new glskeleton() {
        };
    }
}//
