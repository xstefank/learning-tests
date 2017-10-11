package org.learn.eventuate.eventuatelt.model;

import java.util.List;

public class OrderInfo {

    private String id;

    private List<String> products;
    private int price;

    public OrderInfo() {
    }

    public OrderInfo(String id, List<String> products, int price) {
        this.id = id;
        this.products = products;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
