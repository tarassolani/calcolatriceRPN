package calcolatrice;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class formLogin extends JFrame{
    private JTextField txtUsername;
    private JPanel panel1;
    private JPasswordField txtPassword;
    private JButton btnLogin;
    private JLabel lblTitle;
    private JButton btnRegister;

    Database db;

    public formLogin() {

        //Creazione oggetto database
        db = new Database("dbcalcolatricerpn");

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username=txtUsername.getText();
                String password=txtPassword.getText();

                if(db.Connect() && db.UserExists(username, password)){
                    //Apre il form calcolatrice
                    formCalcolatrice window2 = new formCalcolatrice(db, username);
                    window2.showForm();
                    //Chiude il form login
                    Window currentWindow = SwingUtilities.getWindowAncestor(btnLogin);
                    if (currentWindow != null) {
                        currentWindow.dispose();
                    }
                }
            }
        });
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String username=txtUsername.getText();
                String password=txtPassword.getText();

                if(db.Connect() && db.InsertUser(username, password)){
                    //Apre il form calcolatrice
                    formCalcolatrice window2 = new formCalcolatrice(db, username);
                    window2.showForm();

                    //Chiude il form login
                    Window currentWindow = SwingUtilities.getWindowAncestor(btnLogin);
                    if (currentWindow != null) {
                        currentWindow.dispose();
                    }
                }

            }
        });

        //Listener che richiamano la funzione changed() quando viene cambiato il testo in input
        txtPassword.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

        });

        txtUsername.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
            }
            public void removeUpdate(DocumentEvent e) {
                changed();
            }
            public void insertUpdate(DocumentEvent e) {
                changed();
            }

        });
    }


    public void changed() {
        if (txtPassword.getText().isEmpty() || txtUsername.getText().isEmpty()){
            btnLogin.setEnabled(false);
            btnRegister.setEnabled(false);
        }
        else {
            btnLogin.setEnabled(true);
            btnRegister.setEnabled(true);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("formLogin");
        frame.setContentPane(new formLogin().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

}
