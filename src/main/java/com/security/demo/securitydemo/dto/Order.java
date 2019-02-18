package com.security.demo.securitydemo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sec_order")
public class Order {
    @Id
    @Column(name = "order_id")
    private int id;

    @Column(name = "order_status")
    private String status;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "order_user_id")
    @JsonIgnoreProperties("orders")
    private User user;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems;

    public Order(){
        super();
    }

    public Order(int id, String status, User user) {
        this.id = id;
        this.status = status;
        this.user = user;
    }

    public Order(int id, String status, User user, List<OrderItem> orderItems) {
        this.id = id;
        this.status = status;
        this.user = user;
        this.orderItems = orderItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
