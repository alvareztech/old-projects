package animaciones;

import java.awt.*;
import java.applet.*;

public class TestAnim1 extends Applet implements Runnable {
    //Declare a Thread object

    Thread count;
    int x;
    int y;
    // initialise applet

    public void init() {
        x = 0;
        y = 20;
        setBackground(Color.yellow);
        // init thread
        count = new Thread(this);
        //start the thread
        count.start();
    }
    //Thread code , overrides run method of Runnable

    public void run() {
        while (true) {
            try {
                // delay
                count.sleep(100);
                x++;
                // call paint method
                repaint();
            } catch (Exception e) {
            } //do nothing
        }
    }
    // paint method

    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(x, y, 30, 30);
    }
}
