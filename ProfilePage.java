package loginapp;

import javax.swing.*;

public class ProfilePage extends JFrame {
    public ProfilePage(String username) {
        setTitle("Profile");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JLabel("Name: konda Upender"));
        add(new JLabel("Email: sample@gmail.com"));
        add(new JLabel("Role: Admin"));

        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            new Homepage(username).setVisible(true);
        });
        add(backButton);
    }
}
