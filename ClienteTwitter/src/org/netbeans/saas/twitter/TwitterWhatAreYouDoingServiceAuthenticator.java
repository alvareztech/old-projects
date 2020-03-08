/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.netbeans.saas.twitter;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Daniel
 */
public class TwitterWhatAreYouDoingServiceAuthenticator extends Authenticator {

    private static String username;
    private static String password;
    private static final String PROP_FILE = TwitterWhatAreYouDoingServiceAuthenticator.class.getSimpleName().toLowerCase() + ".properties";
    
    static {
        try {
            Properties props = new Properties();
            props.load(TwitterWhatAreYouDoingServiceAuthenticator.class.getResourceAsStream(PROP_FILE));
            username = props.getProperty("username");
            password = props.getProperty("password");
        } catch (IOException ex) {
            Logger.getLogger(TwitterWhatAreYouDoingServiceAuthenticator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static TwitterWhatAreYouDoingServiceAuthenticator singleton = new TwitterWhatAreYouDoingServiceAuthenticator();
    
    public static void login() throws IOException {
        if (!isValidUsernamePassword()) {
            (new AuthenticationPanel()).show();
            if (!isValidUsernamePassword()) {
                throw new IOException("Invalid username and password");
            }
        }
        
        Authenticator.setDefault(singleton);
    }
        
    private static boolean isValidUsernamePassword() {
        return (username != null && username.length() > 0 &&
                password != null && password.length() > 0);
    }

    private TwitterWhatAreYouDoingServiceAuthenticator() {
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(username, password.toCharArray());
    }

    static class AuthenticationPanel implements ActionListener {
        private JFrame frame;
        private JPanel panel;
        private JTextField userNameTF = new JTextField(15);
        private JPasswordField passwordTF = new JPasswordField(15);

        public void makePanel() {
            JButton submitButton = new JButton("Submit");
            JButton cancelButton = new JButton("Cancel");
            JLabel unLabel = new JLabel("User Name   :");
            JLabel pwdLabel = new JLabel("Password    :");

            userNameTF.setText("");
            passwordTF.setText("");

            //adding elements to panel
            panel = new JPanel();
            panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 10));
            panel.setLayout(null);
            unLabel.setBounds(40, 40, 100, 20);
            userNameTF.setBounds(150, 40, 150, 20);
            pwdLabel.setBounds(40, 80, 100, 20);
            passwordTF.setBounds(150, 80, 150, 20);
            submitButton.setBounds(60, 140, 100, 30);
            cancelButton.setBounds(180, 140, 100, 30);

            cancelButton.addActionListener(this);
            submitButton.addActionListener(this);
            submitButton.setActionCommand("Submit");
            cancelButton.setActionCommand("Cancel");

            panel.add(unLabel);
            panel.add(userNameTF);
            panel.add(pwdLabel);
            panel.add(passwordTF);
            panel.add(submitButton);
            panel.add(cancelButton);

            userNameTF.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    passwordTF.grabFocus();
                }

            });

            passwordTF.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e) {
                    AuthenticationPanel.this.actionPerformed(new ActionEvent(passwordTF, 0, "Password"));
                }

            });
            userNameTF.getInputMap().put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "Cancel");
            passwordTF.getInputMap().put(javax.swing.KeyStroke.getKeyStroke("ESCAPE"), "Cancel");
            userNameTF.getActionMap().put("Cancel", new javax.swing.AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    AuthenticationPanel.this.actionPerformed(new ActionEvent(userNameTF, 0, "Cancel"));
                }
            });
            passwordTF.getActionMap().put("Cancel", new javax.swing.AbstractAction() {
                public void actionPerformed(ActionEvent e) {
                    AuthenticationPanel.this.actionPerformed(new ActionEvent(passwordTF, 1, "Cancel"));
                }
            });
        }

        //method to call to show authentication...can be replaced by main() if required
        public void show() {
            frame = new JFrame("User Authentication");
            makePanel();
            //setting up the frame
            frame.getContentPane().add(panel);
            frame.setSize(350, 250);
            frame.setVisible(true);
            
            //code to center the frame
            Toolkit tk = Toolkit.getDefaultToolkit();
            Dimension scrnSize = tk.getScreenSize();
            frame.setLocation((int) (scrnSize.getWidth() - frame.getWidth()) / 2, (int) (scrnSize.getHeight() - frame.getHeight()) / 2);
        
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException ex) {
                }
            }
        }

        //code to do actions on button press
        public void actionPerformed(ActionEvent evt) {
            String actionSource = evt.getActionCommand();
            if (actionSource.equals("Cancel")) {
                frame.dispose();
            } else if (actionSource.equals("Submit") || actionSource.equals("Password")) {
                username = userNameTF.getText();
                password = new String(passwordTF.getPassword());
                frame.dispose();
                //validate using connection to database
                //if validation is right move to next page
            }
            
            synchronized (this) {
                this.notify();
            }
        }
    }
}