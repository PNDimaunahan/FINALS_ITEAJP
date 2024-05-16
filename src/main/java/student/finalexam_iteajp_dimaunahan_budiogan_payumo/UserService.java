package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-GAj60UQH\\SQLEXPRESS:1433;databaseName=finalExam_ITEAJP;user=sa;password=Pa$$w0rd;;encrypt=true;trustServerCertificate=true;";

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection(DB_URL)) {
            String sql = "SELECT Username, Email, Fullname, RoleId FROM [User]";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                String email = resultSet.getString("Email");
                String fullname = resultSet.getString("Fullname");
                int roleId = resultSet.getInt("RoleId");

                String role;
                switch (roleId) {
                    case 1:
                        role = "System Admin";
                        break;
                    case 2:
                        role = "Manager";
                        break;
                    case 3:
                        role = "Regular User";
                        break;
                    default:
                        role = "Unknown";
                }

                User user = new User(username, email, fullname, role);
                users.add(user);
            }

            resultSet.close();
            statement.close();
        }

        return users;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO [User] (Username, Email, Fullname, RoleId) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getFullname());
            stmt.setInt(4, getRoleId(user.getRole()));
            stmt.executeUpdate();
        }
    }

    public void updateUser(User user) throws SQLException {
        String sql = "UPDATE [User] SET Email = ?, Fullname = ?, RoleId = ? WHERE Username = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getEmail());
            stmt.setString(2, user.getFullname());
            stmt.setInt(3, getRoleId(user.getRole()));
            stmt.setString(4, user.getUsername());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(String username) throws SQLException {
        String sql = "DELETE FROM [User] WHERE Username = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            stmt.executeUpdate();
        }
    }

    public User getUserByUsername(String username) throws SQLException {
        String sql = "SELECT Username, Email, Fullname, RoleId FROM [User] WHERE Username = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, username);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String email = resultSet.getString("Email");
                String fullname = resultSet.getString("Fullname");
                int roleId = resultSet.getInt("RoleId");

                String role;
                switch (roleId) {
                    case 1:
                        role = "System Admin";
                        break;
                    case 2:
                        role = "Manager";
                        break;
                    case 3:
                        role = "Regular User";
                        break;
                    default:
                        role = "Unknown";
                }

                resultSet.close();
                stmt.close();

                return new User(username, email, fullname, role);
            }

            resultSet.close();
            stmt.close();
        }

        return null;
    }

    private int getRoleId(String role) {
        switch (role) {
            case "System Admin":
                return 1;
            case "Manager":
                return 2;
            case "Regular User":
                return 3;
            default:
                return 0;
        }
    }
}

