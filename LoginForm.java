package loginapp;
import java.awt.*;

import javax.swing.*;

public class LoginForm extends JFrame {

    private JTextField usernameField;
    private JPasswordField passwordField;

    public LoginForm() {
        setTitle("Login - Vet Pharmacy");
        setSize(600, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon bgIcon = new ImageIcon("src/loginapp/images/background.jpg");
        Image bgImage = bgIcon.getImage().getScaledInstance(600, 350, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 600, 350);
        background.setLayout(null);
        setContentPane(background);
        JLabel LoginTitle= new JLabel("SRILATHA VETERNARY PHARMACY");
        LoginTitle.setBounds(210,15,250,50);
        add(LoginTitle);
        LoginTitle.setForeground(Color.WHITE);
       // LoginTitle.setFont(new Font("Arial", Font.BOLD, 24));
        
       
        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(150, 80, 100, 30);
        add(userLabel);
        userLabel.setForeground(Color.WHITE);

        usernameField = new JTextField();
        usernameField.setBounds(250, 80, 180, 30);
        add(usernameField);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(150, 150, 100, 30);
        add(passLabel);
passLabel.setForeground(Color.WHITE);
        passwordField = new JPasswordField();
        passwordField.setBounds(250, 150, 180, 30);
        add(passwordField);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(280, 200, 100, 30);
        add(loginButton);

        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());
            // Hardcoded for now. You can later fetch from MySQL.
            if (username.equals("admin") && password.equals("1234")) {
                new Homepage(username).setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid credentials");
            }
        });
         

    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginForm().setVisible(true));
    }
}