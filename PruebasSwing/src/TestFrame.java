

/**
 * Clase TestFrame
 * @author Daniel Alvarez (a3dany)
 */
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TestFrame extends JFrame {

    public static void createGUI() {
        JFrame frame = new JFrame("Test frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] data = {"Chrome", "Firefox", "Internet Explorer", "Safari",
            "Opera", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "Morrowind", "Oblivion", "NFS", "Half Life 2",
            "Hitman", "IL-2", "CMR", "NFS Undercover",
            "Star Wars", "Call of Duty", "IL-2", "CMR",
            "NFS Undercover", "Star Wars", "Call of Duty",
            "IL-2", "CMR", "NFS Undercover", "Star Wars",
            "Call of Duty", "IL-2", "CMR", "NFS Undercover",
            "Star Wars", "Call of Duty", "IL-2", "CMR",
            "NFS Undercover", "Star Wars", "Call of Duty",
            "IL-2", "CMR", "NFS Undercover", "Star Wars",
            "Call of Duty", "Arena", "Dagerfall", "MS Office",
            "Open Office", "Windows", "Arena", "Dagerfall",
            "MS Office", "Open Office", "Windows", "Arena",
            "Dagerfall", "MS Office", "Open Office", "Windows",
            "Arena", "Dagerfall", "MS Office", "Open Office",
            "Windows", "Mac OS", "Ubuntu"
        };

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JList northList = new JList(data);
        northList.setLayoutOrientation(JList.VERTICAL);
        northList.setVisibleRowCount(0);

        JScrollPane northScroll = new JScrollPane(northList);
        northScroll.setPreferredSize(new Dimension(100, 100));

        JList centerList = new JList(data);
        centerList.setLayoutOrientation(JList.VERTICAL_WRAP);
        centerList.setVisibleRowCount(0);

        JScrollPane centerScroll = new JScrollPane(centerList);
        centerScroll.setPreferredSize(new Dimension(100, 100));

        JList southList = new JList(data);
        southList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        southList.setVisibleRowCount(0);

        JScrollPane southScroll = new JScrollPane(southList);
        southScroll.setPreferredSize(new Dimension(100, 100));

        mainPanel.add(northScroll);
        mainPanel.add(centerScroll);
        mainPanel.add(southScroll);

        frame.getContentPane().add(mainPanel);

        frame.setPreferredSize(new Dimension(330, 450));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
               // JFrame.setDefaultLookAndFeelDecorated(true);
                createGUI();
            }
        });
    }
}
