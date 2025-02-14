package teamKS.storemanage.aggregate;

import java.io.Serializable;
import java.util.Date;


public class Product implements Serializable {
    int productID;
    String productName;
    int price;
    int productAmount;
    Category category;
    String receiptDate;
    String expirationDate;

    public Product() {
    }

    public Product(int productID, String productName, int price, int productAmount, Category category, String receiptDate) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.productAmount = productAmount;
        this.category = category;
        this.receiptDate = receiptDate;
    }

    public Product(int productID, String productName, int price, int productAmount, Category category, String receiptDate, String expirationDate) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.productAmount = productAmount;
        this.category = category;
        this.receiptDate = receiptDate;
        this.expirationDate = expirationDate;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(String receiptDate) {
        this.receiptDate = receiptDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", price=" + price +
                ", productAmount=" + productAmount +
                ", category=" + category +
                ", receiptDate=" + receiptDate +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
