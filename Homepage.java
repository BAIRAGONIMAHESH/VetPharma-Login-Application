package loginapp;

import javax.swing.*;
import java.awt.*;

public class Homepage extends JFrame {

    public Homepage(String username) {
        setTitle("Vet Pharmacy - Home");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        ImageIcon bgIcon = new ImageIcon("src/loginapp/images/HomePage.jpeg");
        Image bgImage = bgIcon.getImage().getScaledInstance(1000, 600, Image.SCALE_SMOOTH);
        JLabel background = new JLabel(new ImageIcon(bgImage));
        background.setBounds(0, 0, 100, 600);
        background.setLayout(null);
        setContentPane(background);
        JLabel welcomeLabel = new JLabel("Welcome, Srilatha Veternary and General Store ");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setBounds(350, 20, 600, 60);
        add(welcomeLabel);
       JTextArea Description;
        Description = new JTextArea(
                """
                Welcome to SRILATHA VETARINARY MEDICAL AND GENERAL STORE 
                
                Srilatha Veterinary Medical Store offers a comprehensive range 
                
                of veterinary prescription medicinesWhether it's for small pets,
                
                 livestock, or farm animals, we provide high-quality medications
                
                to ensure the health and well-being of your animals. Our selection
                
                includes antibiotics, vaccines, dewormers, and specialized treatments
                
                for various conditions. Trust us for all your veterinary medicine needs.""");
       Description.setEditable(false);
       Description.setFont(new Font("SegoeUI",Font.PLAIN,14));
       Description.setBackground(Color.YELLOW);
       Description.setBounds(255, 80, 600, 300);
       add(Description);

        JButton profileBtn = new JButton("Profile",new ImageIcon("src/loginapp/images/user_icon.png" ));
        profileBtn.setBounds(30, 80, 40, 40);
        add(profileBtn);

        JButton inventoryBtn = new JButton("Inventory",new ImageIcon("src/loginapp/images/product_icon.png" ));
        inventoryBtn.setBounds(30, 200, 40, 40);
        add(inventoryBtn);

        JButton alertsBtn = new JButton("Expiry Alerts",new ImageIcon("src/loginapp/images/expiry.png" ));
        alertsBtn.setBounds(30, 280, 40, 40);
        add(alertsBtn);

        JButton logoutBtn = new JButton("Logout",new ImageIcon("src/loginapp/images/logout_icon.png" ));
        logoutBtn.setBounds(30, 360, 40, 40);
        add(logoutBtn);
        /*JLabel background = new JLabel(new ImageIcon(getClass().getResource("src/images/HomePage.jpg")));
setContentPane(background);
background.setLayout(null); // use absolute layout*/
//Button profileBtn = (new ImageIcon(getClass().getResource("/loginapp/icons/profile.png")));

        profileBtn.addActionListener(e -> {
            this.dispose();
            new ProfilePage(username).setVisible(true);
        });

        inventoryBtn.addActionListener(e -> {
            this.dispose();
            new InventoryPage().setVisible(true);
        });

        alertsBtn.addActionListener(e -> {
            this.dispose();
            new AlertsPage(username).setVisible(true);
        });

        logoutBtn.addActionListener(e -> {
            this.dispose();
            new LoginForm().setVisible(true);
        });
    }
}
