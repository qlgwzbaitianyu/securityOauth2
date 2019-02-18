//package com.security.demo.securitydemo.dto;
//
//import javax.persistence.*;
//import java.util.List;
//
//@Entity
//public class Wife {
//    @Id
//    @Column(name = "wife_id")
//    private int id;
//
//    @ManyToMany
//    @JoinTable(name = "wife_husband", joinColumns = {@JoinColumn(name = "wife_id")}, inverseJoinColumns = {@JoinColumn(name = "husband_id")})
//    private List<Husband> husbands;
//
//    public Wife(){
//        super();
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public List<Husband> getHusbands() {
//        return husbands;
//    }
//
//    public void setHusbands(List<Husband> husbands) {
//        this.husbands = husbands;
//    }
//}
