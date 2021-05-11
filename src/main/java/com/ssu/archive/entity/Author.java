package com.ssu.archive.entity;

import org.hibernate.mapping.Set;

import javax.persistence.*;

import java.util.HashSet;
import java.util.List;

@DiscriminatorValue("Author")
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "author")
    private List<AbstractPrintedProducts> listProduct;

    public List<AbstractPrintedProducts> getListProduct() {
        return listProduct;
    }

    public void setListProduct(List<AbstractPrintedProducts> listProduct) {
        this.listProduct = listProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
