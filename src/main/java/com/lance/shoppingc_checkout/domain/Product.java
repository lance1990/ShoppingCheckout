package com.lance.shoppingc_checkout.domain;

public class Product {
    public String name;
    public double price;
    public int qyantity;
    public String location;

    public Product(String name, double price, int qyantity, String location) {
        this.name = name;
        this.price = price;
        this.qyantity = qyantity;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQyantity() {
        return qyantity;
    }

    public void setQyantity(int qyantity) {
        this.qyantity = qyantity;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", qyantity=" + qyantity +
                ", location='" + location + '\'' +
                '}';
    }
}
