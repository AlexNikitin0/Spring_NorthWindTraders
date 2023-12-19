package com.pluralsight;

public class Product {
    private int productId;
    private String name;
    private int categoryID;
    private double price;

    public int getProductId() {
        return productId;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", category='" + categoryID + '\'' +
                ", price=" + price +
                '}';
    }

    public Product(int productId, String name, int categoryID, double price){
        this.productId = productId;
        this.name = name;
        this.categoryID = categoryID;
        this.price = price;
    }

}
