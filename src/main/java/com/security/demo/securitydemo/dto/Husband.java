//package com.security.demo.securitydemo.dto;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import java.util.List;
//
//@Entity
//public class Husband {
//    @Id
//    @Column(name = "husband_id")
//    private int id;
//
//    @ManyToMany(mappedBy = "husbands")
//    private List<Wife> wifes;
//
//    public Husband() {
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
//    public List<Wife> getWifes() {
//        return wifes;
//    }
//
//    public void setWifes(List<Wife> wifes) {
//        this.wifes = wifes;
//    }
//}
