package bolasrebotando;

import java.awt.Graphics2D;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class DBPanel extends JPanel implements Runnable {
    protected BufferedImage buffer = null;
    protected Graphics2D bufferG = null;
    
    protected int frameRate = 10;    
    protected int delay = 20;
    
    protected volatile boolean isRunning = false;
    protected Thread animador = null;
    
    public void iniciar() {
        if( animador == null || ! isRunning ) {
            animador = new Thread(this);
            isRunning = true;
            animador.start();
        }
    }
    
    public void parar() {
        isRunning = false;
    }
    
    public DBPanel() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.setLayout( null );
        this.setIgnoreRepaint(true);
        this.addComponentListener(new ResizeListener());     
    }
    
    public void crearBuffer() {
        BufferedImage tmpBuffer = new BufferedImage(this.getWidth(),this.getHeight(),BufferedImage.TYPE_INT_RGB);        
        Graphics2D tmpBufferG = tmpBuffer.createGraphics();        
        tmpBufferG.setBackground(this.getBackground());
        tmpBufferG.clearRect(0,0,tmpBuffer.getWidth(),tmpBuffer.getHeight());
        if( buffer != null && bufferG != null ) {
            tmpBufferG.drawImage(buffer,0,0,null);            
            bufferG.dispose();
        } 
        buffer = tmpBuffer;
        bufferG = tmpBufferG;
        System.out.println("Buffer Creado Con Exito.");
    }

    public void run() {
        while( isRunning )    {
            actualizarEstado();
            dibujarBuffer();
            dibujar();            
            try  {
                animador.sleep(delay);
            } catch (Exception ex)  {
                ex.printStackTrace();
            } finally  {
            }            
        }
    }

    public void dibujarBuffer() {
        
    }
    
    public void actualizarEstado() {
        
    }
    
    public void dibujar() {
        Graphics2D g = (Graphics2D)this.getGraphics();
        if( g != null && buffer != null ) {
            g.drawImage(buffer,0,0,null);
        }
    }

    public void setFrameRate(int frameRate) {
        this.frameRate = frameRate;
        try  {
            delay = 1000 / frameRate ;    
        } catch (Exception ex)  {
            ex.printStackTrace();
            delay = 20;
        } finally  {
        }        
    }

    public int getFrameRate() {
        return frameRate;
    }

    public void setIsRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public boolean isIsRunning() {
        return isRunning;
    }

    class ResizeListener extends ComponentAdapter {
        public void componentResized(ComponentEvent e) {
            crearBuffer();        
        }
    }
}
