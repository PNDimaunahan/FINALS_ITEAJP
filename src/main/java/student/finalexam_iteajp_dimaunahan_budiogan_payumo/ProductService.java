package student.finalexam_iteajp_dimaunahan_budiogan_payumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-GAj60UQH\\SQLEXPRESS:1433;databaseName=finalExam_ITEAJP;user=sa;password=Pa$$w0rd;;encrypt=true;trustServerCertificate=true;";

    public List<Product> getAllProducts() throws SQLException {
        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseConnection.getConnection(DB_URL)) {
            String sql = "SELECT ProductName, Description, Color, Size, Price FROM Product";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("ProductName");
                String description = resultSet.getString("Description");
                String color = resultSet.getString("Color");
                String size = resultSet.getString("Size");
                float price = resultSet.getFloat("Price");

                Product product = new Product(name, description, color, size, price);
                products.add(product);
            }

            resultSet.close();
            statement.close();
        }

        return products;
    }

    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Product (ProductName, Description, Color, Size, Price) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getProductName());
            stmt.setString(2, product.getDescription());
            stmt.setString(3, product.getColor());
            stmt.setString(4, product.getSize());
            stmt.setFloat(5, product.getPrice());
            stmt.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
        String sql = "UPDATE Product SET Description = ?, Color = ?, Size = ?, Price = ? WHERE ProductName = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getDescription());
            stmt.setString(2, product.getColor());
            stmt.setString(3, product.getSize());
            stmt.setFloat(4, product.getPrice());
            stmt.setString(5, product.getProductName());
            stmt.executeUpdate();
        }
    }

    public void deleteProduct(String name) throws SQLException {
        String sql = "DELETE FROM Product WHERE ProductName = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, name);
            stmt.executeUpdate();
        }
    }
    
    public static int getProductIDByName(String productName) throws SQLException {
    int productID = -1; // Default value if product is not found
    String sql = "SELECT ProductID FROM Product WHERE ProductName = ?";
    try (Connection connection = DatabaseConnection.getConnection(DB_URL);
         PreparedStatement statement = connection.prepareStatement(sql)) {
        statement.setString(1, productName);
        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                productID = resultSet.getInt("ProductID");
            }
        }
    }
    return productID;
}


}

