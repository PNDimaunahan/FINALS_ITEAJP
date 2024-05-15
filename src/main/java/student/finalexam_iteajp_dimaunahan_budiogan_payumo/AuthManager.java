package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AuthManager {

    public boolean login(String username, String password, String userType) throws LoginException {
        String dbUrl = "jdbc:sqlserver://LAPTOP-GAj60UQH\\SQLEXPRESS:1433;databaseName=finalExam_ITEAJP;user=sa;password=Pa$$w0rd;;encrypt=true;trustServerCertificate=true;";

        try (Connection connection = DatabaseConnection.getConnection(dbUrl)) {
            if (connection == null) {
                throw new LoginException("Unable to establish a database connection.");
            }
            return validateLogin(username, password, userType, connection);
        } catch (SQLException e) {
            throw new LoginException("Database error: " + e.getMessage());
        }
    }

    private boolean validateLogin(String username, String password, String userType, Connection connection) throws LoginException {
        // Basic validation
        if (username == null || username.isEmpty() || password == null || password.isEmpty() || userType == null || userType.isEmpty()) {
            throw new LoginException("All fields are required.");
        }

        boolean isValid = false;

        try {
            String sql = "SELECT * FROM [User] WHERE Username = ? AND Password = ? AND RoleId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
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
                    throw new LoginException("Invalid user type.");
            }

            statement.setInt(3, role);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                isValid = true;
            } else {
                throw new LoginException("Invalid username or password.");
            }

            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            throw new LoginException("Error during login validation: " + e.getMessage());
        }

        return isValid;
    }
}


