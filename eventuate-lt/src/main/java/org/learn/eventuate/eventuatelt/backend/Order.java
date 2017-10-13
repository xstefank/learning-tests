package org.learn.eventuate.eventuatelt.backend;

import com.google.common.collect.ImmutableList;
import org.learn.eventuate.eventuatelt.model.OrderInfo;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;
import java.util.UUID;

@Entity
public class Order {

    @Id
    private String id;

    @Column
    private String product;

    @Column
    private int price;

    public Order() {
    }

    public Order(OrderInfo orderInfo) {
        id = UUID.randomUUID().toString();
        product = orderInfo.getProduct();
        price = orderInfo.getPrice();
    }

    public Order(String id, String product, int price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProducts(String product) {
        this.product = product;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
