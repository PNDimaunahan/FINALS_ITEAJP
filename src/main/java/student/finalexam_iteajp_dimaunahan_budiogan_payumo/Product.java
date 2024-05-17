package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

public class Product {
    private int productID;
    private String productCode;
    private String ProductName;
    private String description;
    private int categoryID;
    private String color;
    private String size;
    private float price;
    
    public Product(String productCode, String ProductName, String description, String color, String size, float price) {
        this.productCode = productCode;
        this.ProductName = ProductName;
        this.description = description;
        this.color = color;
        this.size = size;
        this.price = price;
    }

    public Product(String ProductName, String description, String color, String size, float price) {
        this.ProductName = ProductName;
        this.description = description;
        this.color = color;
        this.size = size;
        this.price = price;
    }
    

    
    public Product(int productID) {
        this.productID = productID;
    }

    // Getters and setters
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String ProductName) {
        this.ProductName = ProductName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
