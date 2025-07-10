package loginapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class AlertsPage extends JFrame {
    public AlertsPage(String username) {
        setTitle("Expiry Alerts");
        setSize(600, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        String[] columns = {"Product", "Expiry Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        add(new JScrollPane(table));

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT product_name, expiry_date FROM inventory WHERE expiry_date <= CURDATE() + INTERVAL 30 DAY";
            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getString("product_name"),
                    rs.getDate("expiry_date")
                });
            }
        } catch (SQLException e) {
        }
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            new Homepage(username).setVisible(true);
        });
        add(backButton);
    }
}
