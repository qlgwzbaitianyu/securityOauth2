package com.security.demo.securitydemo.dto;

import javax.persistence.*;

@Entity
@Table(name = "sec_product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private int id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_price")
    private double price;
    @Column(name = "product_description")
    private String description;
    @Column(name = "product_img")
    private String img;
    @ManyToOne
    @JoinColumn(name = "product_category_id")
    private Category category;

    public Product(){super();}

    public Product(int id, String name, double price, String description, String img, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.img = img;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
