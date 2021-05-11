package com.ssu.archive.entity;

import javax.persistence.*;

import java.util.List;

@Entity
@DiscriminatorValue("Article")
public class Article extends AbstractPrintedProducts {

    private String publishingHouse;

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
