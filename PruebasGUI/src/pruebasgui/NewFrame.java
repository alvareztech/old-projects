/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewFrame.java
 *
 * Created on 22-02-2011, 11:18:42 PM
 */

package pruebasgui;

/**
 *
 * @author Daniel
 */
public class NewFrame extends java.awt.Frame {

    /** Creates new form NewFrame */
    public NewFrame() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar2 = new java.awt.MenuBar();
        menu2 = new java.awt.Menu();
        menu3 = new java.awt.Menu();
        button1 = new java.awt.Button();
        checkbox1 = new java.awt.Checkbox();
        choice1 = new java.awt.Choice();
        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();

        menu2.setLabel("File");
        menuBar2.add(menu2);

        menu3.setLabel("Edit");
        menuBar2.add(menu3);

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        button1.setBackground(new java.awt.Color(255, 204, 102));
        button1.setLabel("button1");
        add(button1, java.awt.BorderLayout.CENTER);

        checkbox1.setLabel("checkbox1");
        add(checkbox1, java.awt.BorderLayout.SOUTH);
        add(choice1, java.awt.BorderLayout.EAST);

        menu1.setLabel("File");
        menuBar1.add(menu1);

        setMenuBar(menuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /** Exit the Application */
    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewFrame().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Checkbox checkbox1;
    private java.awt.Choice choice1;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.Menu menu3;
    private java.awt.MenuBar menuBar1;
    private java.awt.MenuBar menuBar2;
    // End of variables declaration//GEN-END:variables

}