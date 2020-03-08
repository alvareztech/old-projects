package animacion1timer;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener {

    Image star;
    Image star2;
    Timer timer;
    int x, y;
    int x2, y2;

    public Board() {
        setBackground(Color.BLACK);

        ImageIcon ii = new ImageIcon(this.getClass().getResource("lapiz.png"));
        ImageIcon iii = new ImageIcon(this.getClass().getResource("lapiz.png"));
        star = ii.getImage();
        star2 = iii.getImage();

        setDoubleBuffered(true);

        x = y = 10;
        x2 = y2 = 50;
        timer = new Timer(25, this);
        timer.start();
    }


    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(star, x, y, this);
        g2d.drawImage(star2, x2, y2, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }


    public void actionPerformed(ActionEvent e) {

        x += 1;
        y += 1;

        x2 -= 1;
        y2 -= 1;

        if (y > 240) {
            y = -45;
            x = -45;
        }
        repaint();
    }
}