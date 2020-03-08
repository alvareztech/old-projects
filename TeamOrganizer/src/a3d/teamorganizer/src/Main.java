package a3d.teamorganizer.src;

import java.awt.event.*;

public class Main {

    public static void main(String[] a3d) {
        EntornoGrafico f = new EntornoGrafico();
        f.setSize(640, 500);
        f.addWindowListener(new WindowAdapter() {

            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        f.inicio();
    }
}
