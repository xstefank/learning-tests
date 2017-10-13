package org.learn.eventuate.eventuatelt.model;

public class OrderInfo {

    private String product;
    private int price;

    public OrderInfo() {
    }

    public OrderInfo(String product, int price) {
        this.product = product;
        this.price = price;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
