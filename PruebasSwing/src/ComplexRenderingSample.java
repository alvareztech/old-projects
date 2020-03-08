

/**
 * Clase ComplexRenderingSample
 * @author Daniel Alvarez (a3dany)
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.DefaultListCellRenderer;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;

public class ComplexRenderingSample {

    public static void main(String args[]) {

        Object elements[][] = {
            {new Font("Helvetica", Font.PLAIN, 20), Color.red,
                new DiamondIcon(Color.blue), "Help"},
            {new Font("TimesRoman", Font.BOLD, 14), Color.blue,
                new DiamondIcon(Color.green), "Me"},
            {new Font("Courier", Font.ITALIC, 18), Color.green,
                new DiamondIcon(Color.black), "I'm"},
            {new Font("Helvetica", Font.BOLD | Font.ITALIC, 12),
                Color.gray, new DiamondIcon(Color.magenta), "Trapped"},
            {new Font("TimesRoman", Font.PLAIN, 32), Color.pink,
                new DiamondIcon(Color.yellow), "Inside"},
            {new Font("Courier", Font.BOLD, 16), Color.yellow,
                new DiamondIcon(Color.red), "This"},
            {new Font("Helvetica", Font.ITALIC, 8), Color.darkGray,
                new DiamondIcon(Color.pink), "Computer"}};

        JFrame frame = new JFrame("Complex Renderer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();

        JList jlist = new JList(elements);
        ListCellRenderer renderer = new ComplexCellRenderer();
        jlist.setCellRenderer(renderer);
        JScrollPane scrollPane = new JScrollPane(jlist);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        JComboBox comboBox = new JComboBox(elements);
        comboBox.setRenderer(renderer);
        contentPane.add(comboBox, BorderLayout.NORTH);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }
}

class DiamondIcon implements Icon {

    private Color color;
    private boolean selected;
    private int width;
    private int height;
    private Polygon poly;
    private static final int DEFAULT_WIDTH = 10;
    private static final int DEFAULT_HEIGHT = 10;

    public DiamondIcon(Color color) {
        this(color, true, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public DiamondIcon(Color color, boolean selected) {
        this(color, selected, DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }

    public DiamondIcon(Color color, boolean selected, int width, int height) {
        this.color = color;
        this.selected = selected;
        this.width = width;
        this.height = height;
        initPolygon();
    }

    private void initPolygon() {
        poly = new Polygon();
        int halfWidth = width / 2;
        int halfHeight = height / 2;
        poly.addPoint(0, halfHeight);
        poly.addPoint(halfWidth, 0);
        poly.addPoint(width, halfHeight);
        poly.addPoint(halfWidth, height);
    }

    public int getIconHeight() {
        return height;
    }

    public int getIconWidth() {
        return width;
    }

    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.translate(x, y);
        if (selected) {
            g.fillPolygon(poly);
        } else {
            g.drawPolygon(poly);
        }
        g.translate(-x, -y);
    }
}

class ComplexCellRenderer implements ListCellRenderer {

    protected DefaultListCellRenderer defaultRenderer = new DefaultListCellRenderer();

    public Component getListCellRendererComponent(JList list, Object value,
            int index, boolean isSelected, boolean cellHasFocus) {
        Font theFont = null;
        Color theForeground = null;
        Icon theIcon = null;
        String theText = null;

        JLabel renderer = (JLabel) defaultRenderer.getListCellRendererComponent(list, value, index, isSelected,
                cellHasFocus);

        if (value instanceof Object[]) {
            Object values[] = (Object[]) value;
            theFont = (Font) values[0];
            theForeground = (Color) values[1];
            theIcon = (Icon) values[2];
            theText = (String) values[3];
        } else {
            theFont = list.getFont();
            theForeground = list.getForeground();
            theText = "";
        }
        if (!isSelected) {
            renderer.setForeground(theForeground);
        }
        if (theIcon != null) {
            renderer.setIcon(theIcon);
        }
        renderer.setText(theText);
        renderer.setFont(theFont);
        return renderer;
    }
}
