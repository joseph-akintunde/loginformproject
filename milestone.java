import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.lang.Exception;
import java.io.*;
import java.util.Scanner;
class loginUser extends JFrame implements ActionListener {
    JButton b1;
    JPanel newPanel;
    JLabel usernameLabel, passwordLabel;
    final JTextField textField1, textField2;

    loginUser() {
        usernameLabel = new JLabel();
        usernameLabel.setText("Username");

        textField1 = new JTextField(15);
        //textField1.setBackground(Color.BLUE);
        passwordLabel = new JLabel();
        passwordLabel.setText("Password");

        textField2 = new JPasswordField(15);

        b1 = new JButton("SUBMIT");

        newPanel = new JPanel(new GridLayout(3, 1));
        newPanel.add(usernameLabel);
        newPanel.add(textField1);
        newPanel.add(passwordLabel);
        newPanel.add(textField2);
        newPanel.add(b1);

        add(newPanel, BorderLayout.CENTER);

        b1.addActionListener(this);
        setTitle("JJJ BOOKSTORE");
    }

    public void actionPerformed(ActionEvent ae) {
        //boolean exit = false;
        //while (!exit) {
                String usernameValue = textField1.getText();
                String passwordValue = textField2.getText();
                String readPath = "C:\\Users\\josep\\Downloads\\account.txt";
                boolean loginSuccessful = false;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader(readPath));
                    String newLine = reader.readLine();
                    while (newLine != null) {
                        // System.out.println(newL);
                        newLine = reader.readLine();
                        if (newLine != null && newLine.equals(usernameValue + "," + passwordValue)) {
                            System.out.println("welcome " + usernameValue);
                            NewPage page = new NewPage();
                            page.setVisible(true);

                            JLabel wel_label = new JLabel("Welcome: " + usernameValue);
                            page.getContentPane().add(wel_label);
                            //System.out.println(newLine);
                            //exit = true;
                            loginSuccessful = true;
                            break;

                        }else if (newLine == null) {
                            System.out.println("User not found");
                            System.out.println("Wrong username and password");
                        }
                    }
                    //System.out.println(newLine);

                    reader.close();
                } catch (IOException e) {
                    System.out.println(e);
                }

                }
            }

       // }
class userLogin {
    public static void main(String arg[]) {
        try {
            loginUser form = new loginUser();
            form.setSize(200, 100);
            form.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}