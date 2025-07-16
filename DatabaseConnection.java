package loginapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static final String URL = "";// use your own URL while connecting//scheme 
    private static final String USER = "root"; // your MySQL username
    private static final String PASSWORD = ""; // your password

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Connected to MySQL!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Connection Error: " + e.getMessage());
        }
        return conn;
    }

    public static void main(String[] args) {
        getConnection();
    }
}
