package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderService {

    private static final String DB_URL = "jdbc:sqlserver://LAPTOP-GAj60UQH\\SQLEXPRESS:1433;databaseName=finalExam_ITEAJP;user=sa;password=Pa$$w0rd;;encrypt=true;trustServerCertificate=true;";

    public void addOrder(Order order) throws SQLException {
        String sql = "INSERT INTO [Order] (OrderDate, TotalAmount, Status) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            stmt.setTimestamp(1, new java.sql.Timestamp(order.getOrderDate().getTime()));
            stmt.setFloat(2, order.getTotalAmount());
            stmt.setString(3, order.getStatus());
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int orderId = generatedKeys.getInt(1);
                order.setOrderID(orderId);
            } else {
                throw new SQLException("Failed to get order ID, no keys generated.");
            }
        }
    }

    public void addOrderDetails(OrderDetails orderDetails) throws SQLException {
        String sql = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, Price) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderDetails.getOrderID());
            stmt.setInt(2, orderDetails.getProductID());
            stmt.setInt(3, orderDetails.getQuantity());
            stmt.setFloat(4, orderDetails.getPrice());
            stmt.executeUpdate();
        }
    }

    public List<Order> getAllOrders() throws SQLException {
        List<Order> orders = new ArrayList<>();

        String sql = "SELECT OrderID, OrderDate, TotalAmount, Status FROM [Order]";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet resultSet = stmt.executeQuery()) {

            while (resultSet.next()) {
                int orderID = resultSet.getInt("OrderID");
                java.util.Date orderDate = new java.util.Date(resultSet.getTimestamp("OrderDate").getTime());
                float totalAmount = resultSet.getFloat("TotalAmount");
                String status = resultSet.getString("Status");

                Order order = new Order(orderID, orderDate, totalAmount, status);
                orders.add(order);
            }
        }

        return orders;
    }
    
    public void completeOrder(int orderId) throws SQLException {
        String sql = "UPDATE [Order] SET Status = 'Completed' WHERE OrderID = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            stmt.executeUpdate();
        }
    }
    
    public Order getOrderById(int orderId) throws SQLException {
        String sql = "SELECT OrderID, OrderDate, TotalAmount, Status FROM [Order] WHERE OrderID = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            try (ResultSet resultSet = stmt.executeQuery()) {
                if (resultSet.next()) {
                    int orderID = resultSet.getInt("OrderID");
                    java.util.Date orderDate = new java.util.Date(resultSet.getTimestamp("OrderDate").getTime());
                    float totalAmount = resultSet.getFloat("TotalAmount");
                    String status = resultSet.getString("Status");

                    return new Order(orderID, orderDate, totalAmount, status);
                }
            }
        }
        return null;
    }

    public List<OrderDetails> getOrderDetailsByOrderId(int orderId) throws SQLException {
        List<OrderDetails> orderDetailsList = new ArrayList<>();

        String sql = "SELECT OrderDetailID, ProductID, Quantity, Price FROM OrderDetails WHERE OrderID = ?";
        try (Connection connection = DatabaseConnection.getConnection(DB_URL);
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, orderId);
            ResultSet resultSet = stmt.executeQuery();

            while (resultSet.next()) {
                int orderDetailID = resultSet.getInt("OrderDetailID");
                int productID = resultSet.getInt("ProductID");
                int quantity = resultSet.getInt("Quantity");
                float price = resultSet.getFloat("Price");

                OrderDetails orderDetails = new OrderDetails(orderId, productID, quantity, price);
                orderDetailsList.add(orderDetails);
            }
        }

        return orderDetailsList;
    }
}

