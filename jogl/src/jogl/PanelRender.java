package jogl;

import java.awt.*;
import java.awt.Event.*;
import javax.swing.*;
import java.awt.Color;
import javax.media.opengl.GLCanvas;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class PanelRender extends JPanel {

    GLCanvas canvas;

    public PanelRender() {
        this.setBorder(BorderFactory.createEtchedBorder());
//this.setBackground(Color.GREEN);
        this.setSize(300, 300);
        canvas = new GLCanvas();
        canvas.addGLEventListener(new Main());
        canvas.setSize(300, 300);
        add(canvas);
        canvas.requestFocus();
        this.setVisible(true);
    }
}
