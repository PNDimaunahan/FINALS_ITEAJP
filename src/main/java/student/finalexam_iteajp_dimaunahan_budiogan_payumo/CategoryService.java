package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {

    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-GAj60UQH\\SQLEXPRESS:1433;databaseName=finalExam_ITEAJP;user=sa;password=Pa$$w0rd;;encrypt=true;trustServerCertificate=true;";

    public List<Category> getAllCategories() throws SQLException {
        List<Category> categories = new ArrayList<>();

        String sql = "SELECT CategoryID, CategoryCode, Description FROM [finalExam_ITEAJP].[dbo].[Category]";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                int categoryID = resultSet.getInt("CategoryID");
                String categoryCode = resultSet.getString("CategoryCode");
                String description = resultSet.getString("Description");

                Category category = new Category(categoryID, categoryCode, description);
                categories.add(category);
            }
        }

        return categories;
    }

    public void addCategory(Category category) throws SQLException {
        String sql = "INSERT INTO [finalExam_ITEAJP].[dbo].[Category] (CategoryCode, Description) VALUES (?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, category.getCategoryCode());
            stmt.setString(2, category.getDescription());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int categoryID = generatedKeys.getInt(1);
                category.setCategoryID(categoryID);
            } else {
                throw new SQLException("Failed to get category ID, no keys generated.");
            }
        }
    }

    public void updateCategory(Category category) throws SQLException {
        String sql = "UPDATE [finalExam_ITEAJP].[dbo].[Category] SET CategoryCode = ?, Description = ? WHERE CategoryID = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, category.getCategoryCode());
            stmt.setString(2, category.getDescription());
            stmt.setInt(3, category.getCategoryID());
            stmt.executeUpdate();
        }
    }

    public Category getCategoryByCode(String categoryCode) throws SQLException {
    Category category = null;
    String sql = "SELECT CategoryID, CategoryCode, Description FROM [finalExam_ITEAJP].[dbo].[Category] WHERE CategoryCode = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoryCode);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int categoryId = resultSet.getInt("CategoryID");
                    String description = resultSet.getString("Description");
                    category = new Category(categoryId, categoryCode, description);
                }
            }
        }
        return category;
    }
    
    public void deleteCategory(String categoryCode) throws SQLException {
         String sql = "DELETE FROM [finalExam_ITEAJP].[dbo].[Category] WHERE CategoryCode = ?";
            try (Connection connection = DatabaseConnection.getConnection(DB_URL);
                 PreparedStatement stmt = connection.prepareStatement(sql)) {
                stmt.setString(1, categoryCode);
                int rowsAffected = stmt.executeUpdate();
                if (rowsAffected == 0) {
                    throw new SQLException("Category with code " + categoryCode + " does not exist.");
                }
            }
    }


    public Category getCategoryById(int categoryID) throws SQLException {
        String sql = "SELECT CategoryID, CategoryCode, Description FROM [finalExam_ITEAJP].[dbo].[Category] WHERE CategoryID = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, categoryID);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    String categoryCode = resultSet.getString("CategoryCode");
                    String description = resultSet.getString("Description");
                    return new Category(categoryID, categoryCode, description);
                }
            }
        }
        return null;
    }
}
