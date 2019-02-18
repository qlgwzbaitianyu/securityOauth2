package com.security.demo.securitydemo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "sec_resource")
public class Resource {
    @Id
    @Column(name = "resource_url")
    private String url;

    @Column(name = "resource_information")
    private String information;

    @ManyToMany(mappedBy = "resources", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JsonIgnoreProperties("resources")
    private List<Role> roles;


    public Resource(){
        super();
    }

    public Resource(String url, String information, List<Role> roles) {
        this.url = url;
        this.information = information;
        this.roles = roles;
    }

    public String getUrl() {
        List<Role> list;
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
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
