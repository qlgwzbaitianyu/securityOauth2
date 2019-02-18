package com.security.demo.securitydemo.dto;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "sec_category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;
    @Column(name = "category_name")
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Product> products;

    public Category(){
        super();
    }

    public Category(int id, String name, List<Product> products) {
        this.id = id;
        this.name = name;
        this.products = products;
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

    public List<Product> getProducts() {
        if(products == null){
            return new LinkedList<Product>();
        }
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
