package bolasrebotando;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import java.awt.Rectangle;

import javax.swing.JFrame;

public class frmMain extends JFrame {
    private MathFuncPanel mPanel = new MathFuncPanel();
    private BorderLayout borderLayout1 = new BorderLayout();

    public frmMain() {
        try {
            jbInit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void jbInit() throws Exception {
        this.getContentPane().setLayout(borderLayout1);
        this.setSize(new Dimension(400, 300));
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        mPanel.setBackground(Color.white);
        this.getContentPane().add(mPanel, BorderLayout.CENTER);
        this.addKeyListener(mPanel);
    }
}
