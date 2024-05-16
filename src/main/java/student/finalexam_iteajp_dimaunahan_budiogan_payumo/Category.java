package student.finalexam_iteajp_dimaunahan_budiogan_payumo;

public class Category {
    private int categoryID;
    private String categoryCode;
    private String description;

    public Category(int categoryID, String categoryCode, String description) {
        this.categoryID = categoryID;
        this.categoryCode = categoryCode;
        this.description = description;
    }
    
     public Category(String categoryCode, String description) {
        this.categoryCode = categoryCode;
        this.description = description;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}