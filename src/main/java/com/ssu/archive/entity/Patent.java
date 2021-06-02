package com.ssu.archive.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
@DiscriminatorValue("Patent")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Patent extends AbstractPrintedProducts {

    public String country;
    public int registrationNumber;


    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setCountry(String country) {
        country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setRegistrationNumber(int registrationNumber) {
        registrationNumber = registrationNumber;
    }
}
