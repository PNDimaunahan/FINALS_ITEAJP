package student.finalexam_iteajp_dimaunahan_budiogan_payumo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {

    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-GAj60UQH\\SQLEXPRESS:1433;databaseName=finalExam_ITEAJP;user=sa;password=Pa$$w0rd;;encrypt=true;trustServerCertificate=true;";

    public List<Product> getAllProducts(boolean includeProductCode) throws SQLException {
    List<Product> products = new ArrayList<>();

    try (Connection connection = DatabaseConnection.getConnection(DB_URL)) {
        String sql;
        if (includeProductCode) {
            sql = "SELECT ProductCode, ProductName, Description, Color, Size, Price FROM Product";
        } else {
            sql = "SELECT ProductName, Description, Color, Size, Price FROM Product";
        }
        
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String productCode = includeProductCode ? resultSet.getString("ProductCode") : null;
                String name = resultSet.getString("ProductName");
                String description = resultSet.getString("Description");
                String color = resultSet.getString("Color");
                String size = resultSet.getString("Size");
                float price = resultSet.getFloat("Price");

                Product product;
                if (includeProductCode) {
                    product = new Product(productCode, name, description, color, size, price);
                } else {
                    product = new Product(name, description, color, size, price);
                }
                products.add(product);
            }
        }
    }

    return products;
}
    
    public Product getProductByName(String productCode) throws SQLException {
        String sql = "SELECT ProductCode, ProductName, Description, Color, Size, Price FROM Product WHERE ProductCode = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, productCode);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String prodCode = resultSet.getString("ProductCode");
                String name = resultSet.getString("ProductName");
                String description = resultSet.getString("Description");
                String color = resultSet.getString("Color");
                String size = resultSet.getString("Size");
                float price = resultSet.getFloat("Price");

                resultSet.close();
                stmt.close();

                return new Product(prodCode, name, description, color, size, price);
            }

            resultSet.close();
            stmt.close();
        }

        return null;
    }

    
    public void addProduct(Product product) throws SQLException {
        String sql = "INSERT INTO Product (ProductCode, ProductName, Description, Color, Size, Price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
            PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, product.getProductCode());
            stmt.setString(2, product.getProductName());
            stmt.setString(3, product.getDescription());
            stmt.setString(4, product.getColor());
            stmt.setString(5, product.getSize());
            stmt.setFloat(6, product.getPrice());
            stmt.executeUpdate();
        }
    }

    public void updateProduct(Product product) throws SQLException {
    String sql = "UPDATE Product SET ProductName = ?, Description = ?, Color = ?, Size = ?, Price = ? WHERE ProductCode = ?";
    try (Connection connection = DatabaseConnection.getConnection(DB_URL);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, product.getProductName());
        stmt.setString(2, product.getDescription());
        stmt.setString(3, product.getColor());
        stmt.setString(4, product.getSize());
        stmt.setFloat(5, product.getPrice());
        stmt.setString(6, product.getProductCode());
        stmt.executeUpdate();
    }
}
    
    public void deleteProduct(String productCode) throws SQLException {
    String sql = "DELETE FROM Product WHERE ProductCode = ?";
    try (Connection connection = DatabaseConnection.getConnection(DB_URL);
         PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setString(1, productCode);
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

