package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import java.sql.*;

public class DatabaseManager {
    // No need to store dbUrl as an instance variable

    public DatabaseManager() {
        // No need to initialize dbUrl in the constructor
    }

    public boolean validateLogin(String dbUrl, String username, String password, String userType) {
        boolean isValid = false;
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            // Get connection outside the try-with-resources to handle exceptions
            connection = DriverManager.getConnection(dbUrl);

            String sql = "SELECT * FROM user WHERE username = ? AND password = ? AND role = ?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);

            int role;
            switch (userType) {
                case "System Admin":
                    role = 1;
                    break;
                case "Manager":
                    role = 2;
                    break;
                case "Regular User":
                    role = 3;
                    break;
                default:
                    role = -1;
            }

            statement.setInt(3, role);

            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in finally block to ensure they are always closed
            closeResultSet(resultSet);
            closeStatement(statement);
            closeConnection(connection);
        }

        return isValid;
    }

    // Utility methods to close resources
    private void closeResultSet(ResultSet resultSet) {
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeStatement(PreparedStatement statement) {
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void closeConnection(Connection connection) {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

