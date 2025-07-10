package loginapp;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.sql.SQLException;

public class InventoryPage extends JFrame {

    public InventoryPage() {
        setTitle("Inventory");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Column Names
        String[] columns = {"Product Name", "Quantity", "Expiry Date"};
        DefaultTableModel model = new DefaultTableModel(columns, 0);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // Add to UI
        add(scrollPane, BorderLayout.CENTER);

        // Load data from database
        try (Connection conn = DatabaseConnection.getConnection()) {
            if (conn == null) {
                JOptionPane.showMessageDialog(null, "Database not connected.");
                return;
            }

            String query = "SELECT product_name, quantity, expiry_date FROM inventory";
            PreparedStatement stmt = conn.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String product = rs.getString("product_name");
                int qty = rs.getInt("quantity");
                Date expiry = rs.getDate("expiry_date");

                model.addRow(new Object[]{product, qty, expiry});
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading data: " + e.getMessage());
        }
        JButton backButton = new JButton("Back");
        backButton.addActionListener(e -> {
            this.dispose();
            new Homepage("k.upender").setVisible(true);
        });
        add(backButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InventoryPage().setVisible(true));
    }
}