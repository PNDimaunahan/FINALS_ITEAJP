/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

public class OrderItems {
    private String productName;
    private int quantity;
    private float price;

    public OrderItems(String productName, int quantity, float price) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter methods
    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getPrice() {
        return price;
    }
}
