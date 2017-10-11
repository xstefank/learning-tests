package org.learn.eventuate.eventuatelt.backend;

import com.google.common.collect.ImmutableList;
import org.learn.eventuate.eventuatelt.model.OrderInfo;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Order {

    @Id
    private String id;

    @ElementCollection
    private List<String> products;

    @Column
    private int price;

    public Order() {
    }

    public Order(OrderInfo orderInfo) {
        this.id = orderInfo.getId();
        this.products = orderInfo.getProducts();
        this.price = orderInfo.getPrice();
    }

    public Order(String id, List<String> products, int price) {
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
        return ImmutableList.copyOf(products);
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
