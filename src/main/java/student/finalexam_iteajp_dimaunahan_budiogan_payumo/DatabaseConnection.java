package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection getConnection(String dbUrl) {
        try {
            Connection connection = DriverManager.getConnection(dbUrl);
            if (connection != null && connection.isValid(2)) { // Wait up to 2 seconds to verify connection
                return connection;
            } else {
                throw new SQLException("Failed to establish a valid connection.");
            }
        } catch (SQLException e) {
            System.err.println("Error connecting to the database: " + e.getMessage());
            return null;
        }
    }
}

